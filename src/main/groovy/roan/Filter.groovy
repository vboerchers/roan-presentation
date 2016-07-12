package roan

//Author Jodi D. Krol 2013-2
import java.io.File;
import scriptlib.FilterLib
import java.util.ArrayList
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib
import scriptlib.RobotLib
import scriptlib.MapResources
import scriptlib.FileLib
import javax.swing.SwingUtilities

import org.freeplane.core.resources.ResourceController;
import org.freeplane.features.filter.FilterController
 
class Filter extends Record_Page{ //Taken from animation program; can be simplified...

	static final String PAGE  = "PAGE"
	
	Page_Mode page_Mode=new Page_Mode()
	static Page_Mode static_page_Mode=new Page_Mode()
	Integer postDelay //@@TEST Toegeveoegd...
	
	ArrayList included_Ids=[],
			  excluded_Ids=[],
			  included_Styles=[],
			  excluded_Styles=[]
	 
	// Workaround using filter across pages
	// In Play: copy page variables to static before calling filter, by calling fm.init(this)
	static FilterModel filterModel=new FilterModel()
	static class FilterModel {
		ArrayList included_Ids,
					excluded_Ids,
					included_Styles,
					excluded_Styles
					
		void init(def page){
		  included_Ids=page.included_Ids
		  excluded_Ids=page.excluded_Ids
		  included_Styles=page.included_Styles
		  excluded_Styles=page.excluded_Styles
		  }
	}
		  
	  String toString(){
		  return "Filter[action=$action, isAddToPreviousPage=$isAddToPreviousPage,"+
		  "included_Styles=$included_Styles,excluded_Styles=$excluded_Styles,"+
		  "inRoot_id=$page_Mode.inRoot_id,"+
		  "center_id=$page_Mode.center_id,"+
		  "fold=$page_Mode.fold,"+
		  "static_inRoot_id=$static_page_Mode.inRoot_id,"+
		  "static_center_id=$static_page_Mode.center_id,"+
		  "static_fold=$static_page_Mode.fold,"+
		  "included_Ids=$included_Ids,excluded_Ids=$excluded_Ids, postDelay=$postDelay]"
		 }
			  
	  
	  static void execute(ArrayList v){
		  if(v!=null){
			  //XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  
		  }
	  }
	  
	  
	  Filter(){}
	  String conditionName(String rawName){
		  if (rawName==null||rawName=="") return ""
		  else if (rawName[0]=='#') rawName-='#'
	  }
	  
	 static void invoke_undoConditionWithNameFilter(Proxy.Node node){ // node parents will be unfolded
		  if (Controller.current.isConditionWithNameFilter){
			  
			  if (Controller.debug) println "DEBUG: undo NameFilter $node.text"
			  SwingUtilities.invokeAndWait(new Runnable(){
				  public void run(){
					  Record_Page.restoreRoot()
					  roan.Filter.stopFilter()
					  NodeLib.unfoldParents(node)//make sure
				  }})
			  Controller.current.isConditionWithNameFilter=false
			  
			  NodeLib.invoke_selectNode(node) //nodig of teveel ??
		  }
	  }
	  
	 
	 
	void  play(Data data, Data.State col){
		if (Controller.debug) println "DEBUG: Filter play"
		 
		 //String eventStr="filter:ID_1723255651,0"
		 if (data==null||col!=Data.State.OPEN){} // only if open
		 else{
			 ArrayList al=data.filter(Data.State.OPEN)
			 
			  String eventStr=[]
			  if (al!=null&&al!=[]) eventStr="filter:"+al[0]+",0".replaceAll(";",",")
			  
		  def esp=new EventStr_Page_Static(eventStr,"filter", page_Mode)
		
			 isAddToPreviousPage=esp.isAddToPreviousPage
		  included_Ids=esp.included_Ids
		  if (included_Ids==[]&&Controller.current.doFilter){
			 if (data.node==NodeLib.root) isAddToPreviousPage=false
			 else included_Ids[0]=data.node.id
			 if(data.node.parent!=NodeLib.root) isAddToPreviousPage=true
		  }
		 postDelay=0
		 included_Ids.each{ def n=NodeLib.nodeForId(it); if (n!=null) n.parent.folded=false}
		  play()
		// }
	 }
	  }
	
	
	void play(){
		if (Controller.debug) println "DEBUG: Filter: $included_Ids"
		ArrayList currentPage=new ArrayList()
		static_page_Mode.read(page_Mode)
		if (!isAddToPreviousPage) previousPage=[] else println "PAGE: previousPage=$previousPage"
		def root= NodeLib.root
		String remember
				
		if (STYLE_NO_FILTERING in included_Styles){
			filterModel.init(this) // before filter thread
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					Record_Page.restoreRoot()
					static_page_Mode=new Page_Mode()
					Record_Page.stopFilter() //root.map.undoFilter()
				}})
		} else{
		
				//workaroundToGetRepaintOfGlasspane()
				
				if (static_page_Mode.inRoot_id!=null){//(first_id_InRoot){
					if (rememberRoot==null){
						rememberRoot=root.text
						root.text=NodeLib.nodeForId(static_page_Mode.inRoot_id).text
						}
					included_Ids-=[static_page_Mode.inRoot_id]
					println "included_Ids $included_Ids"
					}
				
				filterModel.init(this)
				invoke_applyNewFilter({
					if(
						( isStyle(it,filterModel.included_Styles) || it.id in filterModel.included_Ids ) &&
					  ! ( isStyle(it,filterModel.excluded_Styles) || it.id in filterModel.excluded_Ids )
						) {
						currentPage+=it
						it.setHideDetails(true)
						//ANodeTools.setDetails_IsHidden(it.delegate,true)
						return true}
					else {
						return (it in previousPage && it.id in filterModel.excluded_Ids==false)
					}
				})
			updateFolding()
			
			previousPage+=currentPage
			previousPage.each{
				if (it.id in filterModel.excluded_Ids||isStyle(it,filterModel.excluded_Styles))
					previousPage-=it
				}//make sure
		}
		//RobotLib.delay(postDelay)
		}
	
	 void updateFolding(){
		page_Mode.toFold.each{it.folded=true}
		}
	 
	 static Boolean getIsFiltering(){
		 def f= FilterController.getCurrentFilterController().getFilterConditions().getSelectedItem()
		 return f!=null&&f!= FilterController.NO_FILTERING
	 }
	 
	 
	 static String getPathNameConditions(){
		 String path=MapResources.pathDirectoryMapRaw+"."+FilterController.FREEPLANE_FILTER_EXTENSION_WITHOUT_DOT
	 }
	 
	 static String getPathNameConditionsBackup(){
		 pathNameConditions+".bak"
	 }
	 
	 static void loadConditions(){ // and replace
		 if (FileLib.exists(pathNameConditions)) 	 {
			 if (!FileLib.exists(pathNameConditionsBackup)) FilterLib.saveCurrentConditions(pathNameConditionsBackup)
			 FilterLib.clearConditions()
		    FilterLib.loadAndAddConditions(pathNameConditions)
			if(Controller.debug) println "DEBUG: loaded file $pathNameConditions"
		 }
		 else if(Controller.debug) println "DEBUG: no file $pathNameConditions to load"
	 }
	 
	 static void executeFiltercondition (String name){
		 if (FilterLib.isNamedCondition(name)){}
	 }
	 synchronized static void stop(){
		 Record_Page.stopFilter() //??roan.Filter.stopFilter
		 previousPage=[]
		 //isAddToPreviousPage=false
	 }
	
	 static void stopFilter(){
		 FilterLib.stopFilter()
		 roan.Controller.current.initCurrentNodeInRoot()
	 }
}



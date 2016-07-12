package roan
//Author Jodi D. Krol 2013-2
import java.util.ArrayList
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib
import scriptlib.RobotLib
import javax.swing.SwingUtilities

class Record_Page_Static extends Record_Page{

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
		  return "Record_Page_Static[action=$action, isAddToPreviousPage=$isAddToPreviousPage,"+
		  "included_Styles=$included_Styles,excluded_Styles=$excluded_Styles,"+
		  "inRoot_id=$page_Mode.inRoot_id,"+
		  "center_id=$page_Mode.center_id,"+
		  "fold=$page_Mode.fold,"+
		  "static_inRoot_id=$static_page_Mode.inRoot_id,"+
		  "static_center_id=$static_page_Mode.center_id,"+
		  "static_fold=$static_page_Mode.fold,"+
		  "included_Ids=$included_Ids,excluded_Ids=$excluded_Ids, postDelay=$postDelay]"
		 }
			  
	  Record_Page_Static(){}
	 void  play(ArrayList include_ids){
		  included_Ids=include_ids
		  postDelay=5
		  
		  play()
	  }
	Record_Page_Static(Proxy.Node currentNode,String eventString) {
		println "TEST PAGE=$PAGE, page_Mode=$page_Mode, eventString=$eventString"
		def p=new EventStr_Page_Static(eventString,PAGE, page_Mode)
		println "TEST p=$p"
		if (p.valid){
			
			action=p.action
			isAddToPreviousPage	=p.isAddToPreviousPage
			included_Styles= p.included_Styles
			excluded_Styles=p.excluded_Styles
			included_Ids=p.included_Ids
			excluded_Ids=p.excluded_Ids
			postDelay=p.postDelay*1000 // ms
			this.thisEvent_Node=currentNode
			}
		}
	
	void play(){
		ArrayList currentPage=new ArrayList()
		//ADebug.log("play $this")
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
				applyNewFilter({
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
			if (static_page_Mode.center_id==null||!NodeLib_Roan.isVisible(static_page_Mode.center_id)) {
				//def id=NodeLib_Roan.node_nodeId_HashMap(NodeLib_Roan.ROOTANCHOR_VIRTUALID)
				//println "TEST $NodeLib_Roan.ROOTANCHOR_VIRTUALID=$id"
				//NodeLib_Roan.invoke_centerNodeId(id)
				
				def n=NodeLib_Roan.nodeForId(NodeLib_Roan.ROOTANCHOR_VIRTUALID)
				NodeLib_Roan.invoke_centerNode(n)
				}
			else {
				assert (NodeLib_Roan.isVisible(static_page_Mode.center_id)): "Record_Page_Static node to center not visible: $static_page_Mode.center_id"
				NodeLib.invoke_centerNodeId(page_Mode.center_id)
				}
			
		//	Recorder_Scene.stop_PlayingRecords_AnchorNotVisible()
			previousPage+=currentPage
			previousPage.each{
				if (it.id in filterModel.excluded_Ids||isStyle(it,filterModel.excluded_Styles))
					previousPage-=it
				}//make sure
		}
		RobotLib.delay(postDelay)
		}
	
	 void updateFolding(){
		page_Mode.toFold.each{it.folded=true} 
		}
}



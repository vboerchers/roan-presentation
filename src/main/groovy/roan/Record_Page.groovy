package roan
import scriptlib.*
//Author Jodi D Krol 2013-02
import java.util.ArrayList
import org.freeplane.plugin.script.proxy.Proxy
import java.awt.MouseInfo
import javax.swing.SwingUtilities

abstract class Record_Page extends Record {
	
	static final String ID_SELECTED="ID_Selected"
	static final String ID_ROOT="ID_Root"
	static final String STYLE_NO_FILTERING="FULL_MAP"
	static String idInRoot=null
	
	static String       rememberRoot //root.text
	static def  		previousPage=[]
	String              action 
	EventStr_Page		page
	Boolean     		isAddToPreviousPage
	
	static Boolean getIsFilter(){Controller.current.isFilter}
	static void setIsFilter(Boolean b){Controller.current.isFilter=b}
	
	Record_Page(){}
	
	synchronized applyNewFilter (Closure closure){
		//println "TEST1 apply filter isFilter=$isFilter"
		if (true){//!isFilter){//TEST
			
					NodeLib.root.map.undoFilter()
					NodeLib.root.map.setFilter(false,false,closure)
					isFilter=true
					
			}
		println "TEST2 isfiltering isFilter=$isFilter"
	}
	
	synchronized invoke_applyNewFilter (Closure closure){
		println "TEST1 invoke_apply filter isFilter=$isFilter"
		if (true){//!isFilter){
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
			//println "TEST opletten, invokeAndWait uitgezet voor filter"
					NodeLib.root.map.undoFilter()
					NodeLib.root.map.setFilter(false,false,closure)
					Record_Page.isFilter=true
					}})
			}
		//println "TEST2 isfiltering isFilter=$isFilter"
	}

	synchronized static void stopFilter(){
		if (Controller.debug)println "DEBUG: Filter stop; isFilter=$isFilter"
			if (isFilter){
				 NodeLib.root.map.undoFilter()
				// NodeLib.centerAndFoldAll(NodeLib.root.id)//NodeLib_Roan.ROOTANCHOR_VIRTUALID)
				NodeLib.root.map.filter=null
				isFilter=false
			}
	}
	

	
	synchronized static void invoke_stopFilter(){
		if (Controller.debug)println "DEBUG: Filter invoke_stop; isFilter=$isFilter"
		if (isFilter){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				NodeLib.root.map.undoFilter()
				//NodeLib.centerAndFoldAll(NodeLib.root.id)//NodeLib_Roan.ROOTANCHOR_VIRTUALID)
				NodeLib.root.map.filter=null
				}})
		isFilter=false
		}
	}
	
	static void Record_Page_init(){
		rememberRoot=null
		previousPage=[]
	}
	
	//call end of scene, finish playing and full_mindmap
	static void restoreRoot(){if (rememberRoot!=null) {
		AThread.invoke ({NodeLib.root.text=rememberRoot}) 
		rememberRoot=null
		}}
	
	static Boolean isStyle(Proxy.Node node, ArrayList styles){
		if (styles==null||styles==[]) return false
		else{
			Integer count=0
			Boolean done=false
			while (count < styles.size() && ! done){
				 done=node.hasStyle(styles[count])
				 count+=1
			}
			return done
			}
	}
	
	//****** see RecordStore
	/*
	//	UITWERKEN voor Static en Show!!!!
	 void saveToMap(){
		 thisEvent_Node=Recorder_Scene.addEventNode(toEventString(),iconName())
			 }
	 
	void updateIcon(Proxy.Node node){ 
		 ANodeTools.replaceFirstIcon(node,iconName()) 
		 RecordStore.updateTextIdNode(node)
		 }
	 
	 Closure iconName={RecordStore.PAGE} // TODO new icon
	
	
	
	static void workaroundToGetRepaintOfGlasspane(){
		def p=MouseInfo.getPointerInfo().getLocation()
		def dummy; if (dummy) p.x+=1 else p.x-=1; dummy=!dummy
		ARobot.mouseJump(p)
		}
	*/
}


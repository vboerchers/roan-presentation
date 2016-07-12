package roan

import java.util.ArrayList;
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib

class EventStr_Page_Static extends EventStr_Page{
	
	def included_Ids=[],
		excluded_Ids=[],
		included_Styles=[],
		excluded_Styles=[]
		
	String idCenter=null
		
	static String STYLE_UNFOLD_DEFAULT="aUnfold"

	static Boolean isAction(String eventStr){ return eventStr.find(/^PAGE:.*/)}
	
	ArrayList id_Mode_List (String raw_id, Page_Mode pm){
		ArrayList r=[]
		def valid=raw_id.findAll(/(ID_\d+)|(_Fold)|_Depth_(\d+)|(_Center)|(_InRoot)/){
			full, f_id, f_Fold, f_Depth, f_Center, f_InRoot-> //, f_fold->
			  if (f_id!=null) {
				  if (NodeLib_Roan.id_Exists(f_id)) pm.node_id=f_id
				  else println "TEST missing node $f_id"//MessageToUser.showMissingNode(f_id, Recorder_Scene.stepNr, Recorder_Series.sceneNr)
			  }
			  if (f_Fold!=null) pm.fold=pm.node_id
			  if (f_Depth!=null)pm.depth=f_Depth.toInteger()
			  if (f_Center!=null) pm.center_id=pm.node_id
			  if (f_InRoot!=null) pm.inRoot_id=pm.node_id
		}
		r+=evaluatePageMode(pm)
		return r
}
	
	static ArrayList id_Fold_Depth(String id, Boolean fold, Integer depth,ArrayList toFold){ // toFold out
		ArrayList r=[id]
		Proxy.Node node=NodeLib.nodeForId(id)
		if (node==null) return []
		else if (depth>0)  node.children.each{
			 r.addAll( id_Fold_Depth(it.id, fold, depth-1,toFold))
			 }
			 else if (depth==0&&fold) toFold+=node
		return r
	}
	

	static ArrayList exclude_id_DepthChildren (String raw_id){
		ArrayList r=[]
		def valid=raw_id.find(/(ID_\d+$)|(ID_\d+)_Depth_(\d+)/){
			full, f_id, f_id_depth, f_depth->
			  if (f_id!=null) r+=f_id
			  if (f_id_depth !=null) {r+=NodeLib_Roan.id_Children(f_id_depth,f_depth.toInteger())}//-f_id_depth}
		}
		return r
}
	
	
	EventStr_Page_Static(String eventStr,String possibleAction, Page_Mode page_Mode){
		super(eventStr,possibleAction)
		
		println "TEST EventStr_Page_Static entry eventStr=$eventStr"
		
		ArrayList includedIdStr_List=[]
		if (valid){
			String sMinusPlus
			included_Ids=[]
			
			valid=valueStr.find(/^(\+)?,?(.*)/){full,a,b->isAddToPreviousPage=(a!=null); sMinusPlus=b}
			
			println "TEST valid=$valid; sMinusPlus=$sMinusPlus"
			
			if(valid) valid=sMinusPlus.findAll(/~(ID_\w+)|(ID_\w+)|~(\w+)|(\w+)/){
						full, not_id, id, not_style, style->
							if (not_id!=null) excluded_Ids+=exclude_id_DepthChildren(not_id);
							//if (id!=null) included_Ids+= id_DepthChildren(id) //includedIdStr_List+=id
							//if (id!=null) includedIdStr_List+=id
							included_Ids+=id_Mode_List(id, page_Mode)//.toFold)
							if (not_style!=null) excluded_Styles+=not_style;
							if (style!=null) included_Styles+=style
			}
		}
		println "TEST EventStr_Page_Static exit this$this"
	}

	String toString(){
		return "EventStr_Page_Static["+
					"action=$action,"+
					"valid=$valid,"+
					"valueStr=$valueStr,"+
					"included_styles=$included_Styles,"+
					"excluded_styles=$excluded_Styles,"+
					"included_Ids=$included_Ids,"+
					"excluded_Ids=$excluded_Ids,"+
					"isAddToPreviousPage=$isAddToPreviousPage"
					"postDelay=$postDelay]"
		}

	static ArrayList evaluatePageMode(Page_Mode pm){ //, ArrayList toFold){ // id_Fold_Depth(String id, Boolean fold, Integer depth){
		Boolean fold=false; if (pm.fold!=null) fold=pm.fold
		Integer depth=0; if (pm.depth!=null) depth=pm.depth
		return id_Fold_Depth(pm.node_id,fold, depth, pm.toFold)
	}
}



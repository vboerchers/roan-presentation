package roan
//Author Jodi D.Krol 2014-06
import java.util.ArrayList;
import org.freeplane.core.util.HtmlUtils
import org.freeplane.plugin.script.proxy.Proxy;
import scriptlib.NodeLib
import org.freeplane.plugin.script.proxy.Proxy

class Node {
		enum Attr{
	
/// to remove after conversion v0.0.x to o.1		
			center("center"),
			details("details"),
			edge("edge"),
			folded("folded"),
			link("link"),
			STOP("stop"),
			zoom("zoom"),
			delay("delay"),
			JUMP("jump"),
			menu("menu"), //te vervallen
			FILTER("filter"),
			ACTION("action"),
	///////		
			
			ACTIONS_O("roan-Open"),
			ACTIONS_C("roan-Continue"),
			ACTIONS_B("roan-Back");
			public final String val
			private Attr(String value){val = value}
			}
	
		// conversion only; delete afterwards
		enum Col{
			OPEN(0),
			CONT(1),
			BACK(2);
			public final int val
			private Col(int value){val = value}
			}
		
		static Boolean isScenario(Proxy.Node node){
			String scenarioIcon="roan-Scene"
			return node.icons.contains(scenarioIcon)
		}
		
		
		
		static void setDelayMs(Proxy.Node node, Integer delayMs, Data.State state){
			//Integer delayS=(delayMs/1000)
			if (state==Data.State.OPEN) Defaults.current.delayOnOpen=delayMs
			else (false)
			// if (state==Data.State.CONTINUE) current.delayOnContinue=delayS
			// if (state==Data.State.BACK) current.delayOnBack=delayS
			
			Actions actionsOnOpen=Node.getActions(node,Data.State.OPEN)
			//wipe old
			Actions actionsWithType=actionsOnOpen.actionsWithClass(Action_Delay)
			actionsOnOpen-=actionsWithType // delete old
			//add new
			String delayStr=delayMs
			Action_Delay ad=new Action_Delay([delayStr])
			
			actionsOnOpen.store+=[ad]
			node.attributes.removeAll(Node.Attr.ACTIONS_O.val)
			Node.setActions(node, actionsOnOpen, Data.State.OPEN)
			
		}
	
	
	static String plain(Proxy.Node node){
		return HtmlUtils.htmlToPlain(node.text)
	}
	
	static void setActions (Proxy.Node node, Actions actions, Data.State state){
		String keyStr
		if (state==Data.State.OPEN) keyStr=Node.Attr.ACTIONS_O.val
		else if (state==Data.State.CONTINUE) keyStr=Node.Attr.ACTIONS_C.val
		if (state==Data.State.BACK) keyStr=Node.Attr.ACTIONS_B.val
		
		node[keyStr]=actions.actionsStr
	}
	
	static Actions getActions(Proxy.Node node,Data.State col){
		String keyStr
		if (col==Data.State.OPEN) keyStr=Node.Attr.ACTIONS_O.val
		else if (col==Data.State.CONTINUE) keyStr=Node.Attr.ACTIONS_C.val
		if (col==Data.State.BACK) keyStr=Node.Attr.ACTIONS_B.val
		
		ArrayList al=node.attributes.findValues{key,val-> key == keyStr}//if multiple ACTIONS_O etc
		ArrayList ac=[]
		al.each{
			ArrayList f=it.split (";")
			ac+=f
			}
		
		def r=new Actions()
	
		ac.each{  r.addNodeStrs([it])}
		return r
	}
	
	//CONVERSIE, temporary
	
	static void convert(){
		convert(NodeLib.root)
	}
	
	//convert 0.0.x to v0.1
	static void convert(Proxy.Node node){
		node.children.each{convert(it)}
		convertNode(node)
	}
	static void convertNode (Proxy.Node node){
		String openStr=""
		String continueStr=""
		String backStr=""
		
		openStr=getNodeStrProCol(node, Col.OPEN)
		continueStr=getNodeStrProCol(node, Col.CONT)
		backStr=getNodeStrProCol(node, Col.BACK)
		
		if (openStr!="") node.attributes.add(Node.Attr.ACTIONS_O.val, openStr)
		if (continueStr!="") node.attributes.add(Node.Attr.ACTIONS_C.val, continueStr)
		if (backStr!="") node.attributes.add(Node.Attr.ACTIONS_B.val, backStr)
		
		//wissen residuen....
		node.attributes.removeAll(Attr.center.val)
		node.attributes.removeAll(Attr.details.val)
		node.attributes.removeAll(Attr.folded.val)
		node.attributes.removeAll(Attr.link.val)
		node.attributes.removeAll(Attr.STOP.val)
		node.attributes.removeAll(Attr.zoom.val)
		node.attributes.removeAll(Attr.delay.val)
		node.attributes.removeAll(Attr.JUMP.val)
		//node.attributes.removeAll(Attr.FILTER.val)
	}
	//convert 0.0.x to v0.1
	static String getNodeStrProCol(Proxy.Node node, Col col){
		String warningIcon="messagebox_warning"
		String nodeStr=""
		String nodeActionsStr=""
		
		String e=getElement(node,Attr.center, col)
		if(e!=null &&e!="") if (e.charAt(0).toUpperCase()=="T") nodeStr=Action_Center.key+"("+Action_Center.value_ON+")"
		else if (e.charAt(0).toUpperCase()=="F") nodeStr=Action_Center.key+"("+Action_Center.value_OFF+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		
		nodeStr=""
		e=getElement(node,Attr.details, col)
		if(e!=null &&e!="") if (e.charAt(0).toUpperCase()=="T") nodeStr=Action_DetailsVisibility.key+"("+Action_DetailsVisibility.value_ON+")"
		else if (e.charAt(0).toUpperCase()=="F") nodeStr=Action_DetailsVisibility.key+"("+Action_DetailsVisibility.value_OFF+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.folded, col)
		if(e!=null &&e!="") if (e.charAt(0).toUpperCase()=="T") nodeStr=Action_Folding.key+"("+Action_Folding.value_fold+")"
		else if (e.charAt(0).toUpperCase()=="F") nodeStr=Action_Folding.key+"("+Action_Folding.value_unfold+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.link, col)
		if(e!=null &&e!="") nodeStr=Action_Folding.key+"()"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.STOP, col)
		if(e!=null &&e!="") if (e.charAt(0).toUpperCase()=="T") nodeStr=Action_Continuation.key+"("+Action_Continuation.value_ON+")"
		else if (e.charAt(0).toUpperCase()=="F") nodeStr=Action_Continuation.key+"("+Action_Continuation.value_OFF+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.zoom, col)
		if(e!=null &&e!="") nodeStr=Action_Zoom.key+"("+e+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.delay, col)
		if(e!=null &&e!="") nodeStr=Action_Delay.key+"("+e+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.JUMP, col)
		if(e!=null &&e!="") nodeStr=Action_Jump.key+"("+e+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		nodeStr=""
		e=getElement(node,Attr.FILTER, col)
		if(e!=null &&e!="") {
			ArrayList a=e.split(";")
			int i=0
			String v
			String r=""
			a.each{
				v=""
				Character ch=it.charAt(0).toUpperCase()
				if(i==1) {
					if (ch=="F") v=Action_FilterNamed.value_hideAncestors
					else if (ch=="T") v=Action_FilterNamed.value_showAncestors
					else if (ch=="N") v=Action_FilterNamed.value_ancestorsNULL
					}
				else if (i==2){
					if (ch=="F") v=Action_FilterNamed.value_hideDescendants
					else if (ch=="T") v=Action_FilterNamed.value_showDescendants
					else if (ch=="N") v=Action_FilterNamed.value_descendantsNULL
				} 
				else if (i==3){
					if (ch=="T") v=Action_FilterNamed.value_visibleNodesOnlyON
					else if (ch=="F") v=Action_FilterNamed.value_visibleNodesOnlyOFF
					else if (ch=="N") v=Action_FilterNamed.value_visibleNodesOnlyNULL
				}
				if(v=="") v=it
				if (r=="") r=v else r+=","+v
				i+=1
			}
			nodeStr=Action_FilterNamed.key+"("+r+")"
		}
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=";"+nodeStr
		
		
		nodeStr=""
		e=getElement(node,Attr.menu, col)
		if (e!=null&&e!="") node.icons.add(warningIcon)
		/*
		node.attributes.removeAll(Attr.menu.val)
		if(e!=null &&e!="") nodeStr=Action_MenuFreeplane.key+"("+e+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=","+nodeStr
*/
		
		/*
		e=getElement(node,Attr.FILTER, col)
		node.attributes.removeAll(Attr.FILTER.val)
		if (e!="") nodeStr=Action_MenuFreeplane.key+"("+e+")"
		if (nodeStr!="") if(nodeActionsStr=="") nodeActionsStr=nodeStr else nodeActionsStr+=","+nodeStr
		return nodeActionsStr
		*/
		return nodeActionsStr
	}
	
// for conversion only
	static String getElement(Proxy.Node node, Attr attr, Col col){
	
		String v=node[attr.val]
		if (v==null||v=="") return null
		else{
			ArrayList al=[]
			if (v!=null) al=v.split(",")
			if (al!=null&&al.size()>col.val) return al[col.val] else return null
		}
	}

}

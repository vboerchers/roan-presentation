package roan
import java.awt.*
import java.awt.event.*
import java.text.NumberFormat
import org.freeplane.core.ui.components.UITools
import org.freeplane.features.mode.Controller
import org.freeplane.view.swing.map.*
import org.freeplane.plugin.script.proxy.NodeProxy
import org.freeplane.plugin.script.proxy.Proxy;
  
abstract class Record {
	Proxy.Node thisEvent_Node // node in map containing event definition
	def 		playableComment // physical field for display, e.g. CommentFieldText
	
  //*** GLOBAL
		static  String 	NODE_STYLE_SERIES			= "aSeries",
						NODE_STYLE_SCENE   			= "aScene",
						NODE_STYLE_STEP				= "aStep",
						NODE_STYLE_TEXTNODE			= "aText",
						NODE_STYLE_ANCHOR	    	= "aAnchor",
						NODE_STYLE_HELP				= "aHelp"
	
		static  ArrayList nodeStyles=[
						NODE_STYLE_SERIES,
						NODE_STYLE_SCENE,
						NODE_STYLE_STEP,
						NODE_STYLE_TEXTNODE,
						NODE_STYLE_ANCHOR,
						NODE_STYLE_HELP]
		
		protected static String nodeStyle(String action) {
			switch (action[0]) {
				case "C": NODE_STYLE_STEP; break
				case "K": NODE_STYLE_STEP	; break
				case "M": NODE_STYLE_STEP	; break
				case "T": NODE_STYLE_STEP	; break
				case "L": NODE_STYLE_STEP	; break
				case "N": NODE_STYLE_STEP	; break
				//p.m. screen, help
				default: assert 1==2: "WARNING RoAn: unknown action $action"
				}
			}
		
		//static void Record_init(){thisEvent_Node=null;playableComment=null}
		static String action(String eventString){
			eventString.find(/(\D+):.*/){full, thisAction-> return thisAction}
			}
		static String actionValue(String eventString){
			eventString.find(/(\D+):(.*)/){full, thisAction, value-> return value}
			}
		
		static Proxy.Node commentNode(Proxy.Node currentNode){ //subnode with text for comment
			Proxy.Node child=null
			def chldrn=currentNode.getChildren()
			if (chldrn!=null) child=chldrn.find{it.style.name==NODE_STYLE_TEXTNODE}
			return child
			}
		// similar commentNode
		static Proxy.Node postCommentNode(Proxy.Node currentNode){ //subnode with text for comment
			def child=null
			def chldrn=currentNode.getChildren()
			if (chldrn!=null) child=chldrn.find{it.style.name==NODE_STYLE_TEXTNODE}
			if (child!=null) { //find second
				chldrn-=child
				child=chldrn.find{ it.style.name==NODE_STYLE_TEXTNODE}
				}
			return child
			}
		
		static Proxy.Node preCommentNode(Proxy.Node currentNode){ //subnode with text for comment
			def child=null
			def chldrn=currentNode.getChildren()
			if (chldrn!=null) child=chldrn.find{it.style.name==NODE_STYLE_TEXTNODE}
			return child
			}
		
		Record(){}
}


package scriptlib
//Author Jodi D.Krol 2013-06
import java.util.Comparator;

import org.freeplane.plugin.script.proxy.Proxy
import org.freeplane.plugin.script.proxy.ProxyFactory
import org.freeplane.features.mode.Controller
import org.freeplane.features.mode.ModeController
import org.freeplane.features.map.FoldingController

//import roan.ImageInline.Location; //TEST temp

import javax.swing.SwingUtilities
//all static
// needs C_scriptlib
class NodeLib {
	static String CORETitle=Message.textUtils.getText(
		"addons.roan.nodelib.CORE",
		"CORE"
		)
	static String DETAILSTitle=Message.textUtils.getText(
		"addons.roan.nodelib.DETAILS",
		"DETAILS"
		)
	static String NOTETitle=Message.textUtils.getText(
		"addons.roan.nodelib.NOTE",
		"NOTE"
		)
	static String ARROWTitle=Message.textUtils.getText(
		"addons.roan.nodelib.ARROW",
		"ARROW"
		)
	
	static enum Field{CORE,DETAILS,NOTE,ARROW}
	
	static String toFieldTitle(Field l){
		if (l==Field.CORE) return CORETitle
		else if (l==Field.DETAILS) return DETAILSTitle
		else if (l==Field.NOTE) return NOTETitle
		else if (l==Field.ARROW) return ARROWTitle
	}
	static Field toLocationField(String s){
		if (s==CORETitle) return Field.CORE
		else if (s==DETAILSTitle ) return Field.DETAILS
		else if (s==NOTETitle) return Field.NOTE
		else if (s==ARROWTitle) return Field.ARROW
	}
	
	static public void selectNode(Proxy.Node node) {
		//unfoldParents(node)
		//prezifp.Controller.c.select(node) 
		
		if (node.visible) 	Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
		else 
		{println "Trying to select invisible node $node";assert(false):"Trying to select invisible node $node"}
		
	}
	
	static public void invoke_selectNode(Proxy.Node node) {
		//unfoldParents(node)
		//prezifp.Controller.c.select(node)
		if (node!=null){
		if (node.visible) 	{
			
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
					}})
		}else
		{println "Trying to select invisible node $node";
			//assert(false):"Trying to select invisible node $node"
			}
		
	}}
	
	static public void invoke_selectNodes(ArrayList list) {
		if (list==null||list==[]){}
		else{
		//unfoldParents(node)
		//prezifp.Controller.c.select(node)
		   def l2=[]
		
			
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					
					list.each{
						Proxy.Node n=it
						 if (n.parent!=null&&n.parent.folded==false) {l2+=n; }
						else {
						//println "DEBUG: Trying to select invisible node $n.id";
						//assert(false):"Trying to select invisible node $n.id"
						}}
					//Controller.currentController.selection.selectMultipleNodes(l2)
					
					Globals.current.c.selectMultipleNodes(l2)
					}})
		}
	}
	
	static public void selectNodes(ArrayList list) {
		if (list==null||list==[]){}
		else{
		//unfoldParents(node)
		//prezifp.Controller.c.select(node)
		   def l2=[]
					list.each{
						Proxy.Node n=it
						unfoldParents(n) 
						 if (n==NodeLib.root||
							 n.parent!=null&&(n.parent==NodeLib.root||n.parent.folded==false)) {l2+=n }
						else {
						//println "DEBUG: Trying to select invisible node $n.id";
						//assert(false):"Trying to select invisible node $n.id"
						}}
					//Controller.currentController.selection.selectMultipleNodes(l2)
					
					Globals.current.c.selectMultipleNodes(l2)
					
		}
	}
	//deprecated
	static Proxy.Node selectedNode(){
		return ProxyFactory.createNode(Controller.currentController.selection.selected,null)
		//Globals.current.c.selected
		}
	static Proxy.Node getSelectedNode(){
		return ProxyFactory.createNode(Controller.currentController.selection.selected,null)
		//ProxyFactory.createNode(Globals.current.c.selected,null)
		//Globals.current.c.selected
		}
	
	static List getSelectedNodes(){
		//Controller.currentController.selection.orderedSelection
		Globals.current.c.selecteds
		}
	
	static void unfoldParents(Proxy.Node node){
		if (node!=null&&node.parent!=null&&node!=NodeLib.root&&node.parent!=NodeLib.root) {
			if (node.parent!=null){
				if (node.parent!=NodeLib.root) {unfoldParents(node.parent)
				node.parent.folded=false;
				}
			}
			}
	}
	
	static void invoke_unfoldParents(Proxy.Node node){
		if (node!=null&&node.parent!=null&&node!=NodeLib.root&&node.parent!=NodeLib.root) {
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					node.parent.folded=false;
					NodeLib.unfoldParents(node.parent)
					}})
			
			}
	}
	
	
	static void centerNode(Proxy.Node node){
		if (node!=null){
			Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
			Controller.getCurrentController().getSelection().centerNode(node.delegate)
			//Globals.current.c.centerOnNode(node)
		}
	}
	
	static void invoke_centerNode(Proxy.Node node){
		if (node!=null){
			Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					Controller.getCurrentController().getSelection().centerNode(node.delegate)
					}})
			}
	}
	static void invoke_centerNodeId(String node_id){
		def node=NodeLib.nodeForId(node_id)
		if (node!=null) NodeLib.invoke_centerNode(node)
	}
	
	static void invoke_fold(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				node.folded=true
				}})
	}
	
	static void invoke_foldAll(Proxy.Node node){
		if (node!=null){
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					NodeLib.foldAll(node)
					}})
		}
	}
	
	static void invoke_unfoldAll(Proxy.Node node){
		if (node!=null){
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					NodeLib.unfoldAll(node)
					}})
			}
	}
	
	void centerNode_invokeAndWait(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
				Controller.getCurrentController().getSelection().centerNode(node.delegate)
				//Globals.current.c.centerOnNode(node)
			}})
		
	}
	
	static void invoke_setHideDetails(Proxy.Node node, Boolean b){
		if (node!=null&&node.details!=null)
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				node.setHideDetails(b)
				}})
	}
	
	static ArrayList nodesForIds(ArrayList ids){
		ArrayList r=[]
		ids.each{r+=[nodeForId(it)]}
		return r
	}
	
	static Proxy.Node nodeForId (String id){
		if (id==null) return null
		else{
			def nodeModel=Controller.currentController.map.getNodeForID(id)
			if (nodeModel==null) return null
			else return ProxyFactory.createNode(nodeModel,null)
			//alternative: Globals.current.node.map.node(id)
			}
		}
	static Boolean isAccessable(String nodeId){
		return nodeForId(nodeId)!=null}
	                                                   
	static String id(Proxy.Node node){if (node==null) return null else return node.id}
 		
	static Proxy.Node getRoot() {
		ProxyFactory.createNode(Controller.currentController.map.rootNode,null)
		//Globals.current.node.map.root
		}
	
	static void folded(Proxy.Node node, Boolean b){
				node.folded=b
	}
	
	static void invoke_folded(Proxy.Node node, Boolean b){
		if (node!=null&&b!=null){
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					node.folded=b
					}})
	}}
	
	static void unfoldAll(Proxy.Node node){
		ModeController mc = Controller.getCurrentController().getModeController();
		FoldingController foldingController = mc.getExtension(FoldingController.class);
		foldingController.unfoldAll(node.delegate)		
	}	
	
	static void foldAll(Proxy.Node node){
		ModeController mc = Controller.getCurrentController().getModeController();
		FoldingController foldingController = mc.getExtension(FoldingController.class);
		foldingController.foldAll(node.delegate)
	}
	
	static void invoke_foldChildrenAndDetails(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				//foldChildrenAndDetails(node)
				ArrayList children=node.children
				if(children!=null){ children.each{
					Proxy.Node n=it
					if (n.details!=null) n.hideDetails=true
					n.folded=true
					}
				}
				
			}})
	}
	
	static void foldChildrenAndDetails(Proxy.Node node){
		ArrayList children=node.children
		if(children!=null){ children.each{
			Proxy.Node n=it
			if (n.details!=null) n.hideDetails=true
			n.folded=true
			} 
		}
	}
	
	static void deleteChildren(Proxy.Node node){
		node.each{it.delete()}
	}
	
//***** multitasking threads ; id's
	void center(String node_id){
		Proxy.Node node=nodeForId(node_id)
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				if (node!=null){
					Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
					Controller.getCurrentController().getSelection().centerNode(node.delegate);
				}

			}})
	}
		
	static void centerAndFoldAll(String node_id){
		Proxy.Node node=nodeForId(node_id)
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				if (node!=null){
					Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
					Controller.getCurrentController().getSelection().centerNode(node.delegate);
					ModeController mc = Controller.getCurrentController().getModeController();
					FoldingController foldingController = mc.getExtension(FoldingController.class);
					foldingController.foldAll(node.delegate)
				}

			}})
	}
	
	static void centerAndUnfoldAll(String node_id){
		Proxy.Node node=nodeForId(node_id)
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				if (node!=null){
					Controller.currentController.selection.selectAsTheOnlyOneSelected(node.delegate)
					Controller.getCurrentController().getSelection().centerNode(node.delegate);
					ModeController mc = Controller.getCurrentController().getModeController();
					FoldingController foldingController = mc.getExtension(FoldingController.class);
					foldingController.foldAll(node.delegate)
				}

			}})
	}
	
	void foldAll(String node_id){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				ModeController mc = Controller.getCurrentController().getModeController();
				FoldingController foldingController = mc.getExtension(FoldingController.class);
				Proxy.Node node=NodeLib.nodeForId(node_id)
				foldingController.foldAll(node.delegate)
			}})
	}

	void unfold(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
			node.folded=false
			}})
	}
	void fold(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
			node.folded=true
			}})
	}
	void unfoldAll(String node_id){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				ModeController mc = Controller.getCurrentController().getModeController();
				FoldingController foldingController = mc.getExtension(FoldingController.class);
				Proxy.Node node=NodeLib.nodeForId(node_id)
				foldingController.unfoldAll(node.delegate)
			}})
	}
	//**** multitasking
	
	
	//*** Attributes
	 static Boolean isAttribute(Proxy.Node node,String key,String value){
		 return (node[key]!=null && node[key]==value)
	 }
	 static void deleteEmptyAttributes(Proxy.Node node){
		 node.attributes.names.each{if (node[it]=="")  def dummy=node.attributes.removeAll(it) }
	 }
	 //***
	 static void  setFree(Proxy.Node node){
		 selectNode(node)
		 MenuFreeplane.executeMenuActions(['FreeNodeAction'])
	 }
	 
	 static ArrayList getNodesForIds(ArrayList parms){
		 ArrayList r=[]
		 parms.each{
			 if (StringLib.isLeft(it,"ID_")){
			 Proxy.Node n=nodeForId(it);
			 if (n!=null) r+=[n]
			 }
		 }
		 return r
	 }
	 
	//// SORT 
	 void sortForeward(Proxy.Node node){
		 ArrayList list=node.children
		 Collections.sort(list, new Foreward() )
			  Integer i=0
			  list.each{it.moveTo(node,i); i+=1}
			  }
	 
	 class Foreward implements Comparator<Proxy.Node>{
		 
			@Override
			 int compare(Proxy.Node o1, Proxy.Node o2) {
				 Boolean i1=true//o1.icons.contains(Basic.icon_document)
				 Boolean i2=true//o2.icons.contains(Basic.icon_document)
				if (i1&&i2&&o1.text==o2.text) return 0
				else if (i1&&i2&&o1.text>o2.text) return -1
				else return 1
			}
		}
	 
	 
	 void sortBackward(Proxy.Node node){
		 ArrayList list=node.children
		 Collections.sort(list, new Backward() )
			  Integer i=0
			  list.each{it.moveTo(node,i); i+=1}
			  }
	 
	 class Backward implements Comparator<Proxy.Node>{
		 
			@Override
			 int compare(Proxy.Node o1, Proxy.Node o2) {
			 Boolean i1=true//o1.icons.contains(Basic.icon_document)
			 Boolean i2=true//o2.icons.contains(Basic.icon_document)
				if (i1&&i2&&o1.text==o2.text) return 0
				else if (i1&&i2&&o1.text>o2.text) return 1
				else return -1
			}
		}
}

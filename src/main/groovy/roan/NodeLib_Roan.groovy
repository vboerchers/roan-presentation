package roan
import org.freeplane.features.map.FoldingController
import org.freeplane.features.mode.ModeController
import org.freeplane.plugin.script.proxy.Proxy
import javax.swing.SwingUtilities
import scriptlib.NodeLib


class NodeLib_Roan extends NodeLib{
	static NodeLib_Roan current=new NodeLib_Roan()
	static final String ROOTANCHOR_VIRTUALID	 ="ID_Root" // current rootcenter; for anchor
	static final String SCREENANCHOR_VIRTUALID	 ="ID_ScreenCenter"  // rootcenter at start, fixed for menu's
	static final String MENUANCHOR_VIRTUALID	 ="ID_MenuMove"   // idem ID_Root, moving first x then y
	static final String CURRENTPOSITION_VIRTUALID="ID_CurrentPosition" //no mouse move
	protected static HashMap nodeId_HashMap
	
	@Override
	void foldAll(String node_id){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				if (node_id==ROOTANCHOR_VIRTUALID) {centerAndFoldAll(node_id); Thread.sleep(100)}
				else{
					ModeController mc = Controller.getCurrentController().getModeController();
					FoldingController foldingController = mc.getExtension(FoldingController.class);
					Proxy.Node node=nodeForId(node_id)
					foldingController.foldAll(node.delegate)
				}
			}})
	}
	
	public static Boolean id_Exists(String id){
			return (id_Virtual(id)||
					nodeForId(id)!=null||
					current.isNodeId_HashMap())
		}
	public static Boolean id_Virtual(String id){
		//if (Dashboard.element.containsKey(id)) {Animator.show(true)}// NOT Animator.waitForPendingAction()} //make sure
		 
		 return (id==ROOTANCHOR_VIRTUALID||
					id==SCREENANCHOR_VIRTUALID||
					id==MENUANCHOR_VIRTUALID||
					id==CURRENTPOSITION_VIRTUALID //||
					//Dashboard.element.containsKey(id)
					)
	 }
	//folded nodes not generally not found by id; workaround to find folded nodes by id
	static protected Boolean isNodeId_HashMap(String id){
		if (nodeId_HashMap==null|| nodeId_HashMap.containsKey(id)) initNodeId()// if changed
		return  nodeId_HashMap.containsKey(id)
		}
	static Proxy.Node node_nodeId_HashMap(String id){
		if (nodeId_HashMap==null) initNodeId()
		Proxy.Node result=nodeId_HashMap.get(id); println "folded node for id= $id from nodeId_HashMap : $result"
		return nodeId_HashMap.get(id)
		}
	static initNodeId(){
		//SwingUtilities.invokeAndWait(new Runnable(){
		//	public void run(){
				nodeId_HashMap=new HashMap()
				current.initNodeId(current.root.children)
		//	}})
		}
	static void initNodeId(ArrayList children){
		if (children!=null){
			children.each{
				nodeId_HashMap.put(it.id, it)
				initNodeId(it.getChildren())
			}
		}
	}
	static ArrayList id_Children(String id,Integer depth){
		ArrayList r=[id]
		if (depth>0)   nodeForId(id).children.each{r+=id_Children(it.id,depth-1)}
		return r
	}
	
	static Boolean isVisible(String node_id){
		def node=NodeLib.nodeForId(node_id)
		if (node!=null) return node.isVisible() else return (node_id==SCREENANCHOR_VIRTUALID)
		}
	
	public static Proxy.Node nodeForId(String id) {
		
		Proxy.Node result
		if (id==null||id=="") return null
	
		switch(id){
			case SCREENANCHOR_VIRTUALID: result=null; break//assert (false): "WARNING this is a virtual id: $SCREENANCHOR_VIRTUALID";break
			//case Dashboard.PLAY: result=null; break
			//case Dashboard.RECORD: result=null; break
			case ROOTANCHOR_VIRTUALID:  result= root; break
			//case MENUANCHOR_VIRTUALID: result= root_ProxyNode(); break
			default:
				result=NodeLib.nodeForId(id)
				if (result==null) result= current.node_nodeId_HashMap(id) // in case node folded
				//else result=ProxyFactory.createNode(nodeModel,null)
				if (result==null) println"WARNING node with id $id is not visible (is folded) or doesn't exist"
			}
		return result
		}
		
}


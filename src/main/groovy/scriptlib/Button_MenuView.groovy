package scriptlib
//Author Jodi D.Krol 2014-03
import org.freeplane.plugin.script.proxy.Proxy


class Button_MenuView extends Button_MenuView_ButtonNode { // all actions on nodes
	Button_MenuModel menuModel
	Proxy.Node node
	Closure deleteAllItems_extra ={false}
	URI itemUri='menuitem:_$addons.indexfile.menu.z_itemAction_on_single_node$0'.toURI()
	
	String toString(){ return "MenuView[node=$node;menuModel=$menuModel"}
	
	Button_MenuView(Button_MenuModel menuModel, Proxy.Node node, Closure deleteAllItems_extra ){
		if(deleteAllItems_extra!=null )this.deleteAllItems_extra=deleteAllItems_extra
		this.menuModel=menuModel
		this.node=node
		registerMenuNode(node)
		registerMenuAction(menuModel.uri.toString())
	}
	
	//String menuUri(Proxy.Node node){ return node.link.uri}
	
	
	void format( String label, String help, String icon){ //to display Menu
		//Proxy.Node menuNode=NodeLib.nodeForId(menuNodeId)
		
		if (menuModel.uri==null) assert(false):"ERROR: register menuAction first: $node"
		else{
			if (label!="") node.text=label
			if (help==null) node.details=null else if(help!="") {node.details=help;node.hideDetails=true}
			if (icon!="") {node.icons.add(icon)}
			node.link.uri=menuModel.uri
		}
	}
	
	Boolean isMenuNode(Proxy.Node node){
		if (menuModel.uri==null) assert(false):"menuUri not defined, register menu first, node=$node"
		return node.link.uri==menuModel.uri //&& buttonMenu(node.text)!=null
		}
	
	Proxy.Node existingItemNode(Proxy.Node menuNode, String label,URI uri_item){
		Proxy.Node r= menuNode.children.find({it.link.uri==uri_item&&it.text==label})
		return r
	}
	
	Proxy.Node createItemNode(String label, String help, String icon){ //Service only
		//if (menuNodeId=="")  {println "ERROR: to create item $label register menuNode first"; return null}
		if (itemUri==null) assert(false):"itemUri not defined, register item first"
		else{
			def menuNode=NodeLib.nodeForId(node.id)
			Proxy.Node e=existingItemNode(menuNode,label, itemUri)
			if (e==null){
				Proxy.Node node=menuNode.createChild()
				node.text=label
				node.details=help; node.hideDetails=true
				node.link.uri=itemUri
				if (icon!="") node.icons.add(icon)
				StyleLib.setButtonStyle(node)
			   return node
			}
			else return e
		}
	}
	
	Boolean isItem(String label){
		menuModel.itemActions[label]!=null}
	
	Boolean isItemNode(Proxy.Node node){
		if (itemUri==null) assert(false):"itemUri not defined, register item first, node=$node"
		return node.link.uri==itemUri
		}
	
	void deleteItem(Proxy.Node itemNode){
		if (isItem(itemNode)) itemNode.delete() else println "WARNING: trying to delete node which is not item:$itemNode"}
	
	void deleteAllItems(){
		if (isMenuNode(node)){
			node.children.each{ if (isItemNode(it)||deleteAllItems_extra(node) )  it.delete()}
		} else assert (false): "ERROR trying to delete node which is not menu: $node"
	}
	
	Button_MenuView_ButtonNode formatMenuNode( String label, String help, String icon){ //to display Menu
		//Proxy.Node menuNode=NodeLib.nodeForId(menuNodeId)
		if (menuUri==null) assert(false):"ERROR: register menuAction first: $node"
		else{
			if (label!="") node.text=label
			if (help==null) node.details=null else if(help!="") {node.details=help;node.hideDetails=true}
			if (icon!="") {node.icons.add(icon)}
			node.link.uri=menuUri
			return this
		}
	}
	
	
}

package scriptlib
//Author Jodi D.Krol 2013-08
// Define script scriptMenu.groovy which calls class MyMenu.displayMenuAction
// Extend this class : myMenu.groovy
// - displayMenuAction
// - creation of menuItems

//import indexfile.FileMenu;
import groovy.lang.Closure;
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib

class Button_MenuView_ButtonNode{

	def  buttonMenus=[:]//TEST aanpassen, zie ButtonMenus
		def itemActions=[:]
		String menuNodeId
		URI menuUri 
		URI itemUri='menuitem:_$addons.indexfile.menu.z_itemAction_on_single_node$0'.toURI()
		
		String toString(){
			return "ButtonMenu["+
				//"buttonMenus=$buttonMenus"+
			    "menuNodeId=$menuNodeId;"+
				"itemActions=$itemActions;"+
				//"displayMenuAction=$displayMenuAction;"+
				"menuUri=$menuUri;"+
				"itemUri=$itemUri"
				"]"
		}
		
		Button_MenuView_ButtonNode(){}
			
		def buttonMenu(Proxy.Node menuNode){
			def bm
			def k= buttonMenus.find({k,Button_MenuView_ButtonNode v->bm=v;v.menuNodeId==menuNode.id}) // kan dit anders??
			if (k==null){assert (false):"no registered menuAction for: $menuNode";return null} else return bm
		}
		def registerMenuAction(String menuLinkStr){ //one pro ButtonMenu
			menuUri=menuLinkStr.toURI()
			buttonMenus[menuLinkStr]=this
			return this
			}
		
		def registerMenuNode(Proxy.Node menuNode){ //one pro ButtonMenu
			this.menuNodeId=menuNode.id
			return this
			}
		
		def registerItemAction(String itemLabel,Closure itemAction){
			itemActions[itemLabel]=itemAction
			return this
		}
		
		Boolean isItem(String label){
			itemActions[label]!=null}
		
		Boolean isItemNode(Proxy.Node node){
			if (itemUri==null) assert(false):"itemUri not defined, register item first, node=$node"
			return node.link.uri==itemUri
			}
		
		Button_MenuView_ButtonNode formatMenuNode( String label, String help, String icon){ //to display Menu
			Proxy.Node menuNode=NodeLib.nodeForId(menuNodeId)
			if (menuUri==null) assert(false):"ERROR: register menuAction first: $menuNode"
			else{
				if (label!="") menuNode.text=label
				if (help==null) menuNode.details=null else if(help!="") {menuNode.details=help;menuNode.hideDetails=true}
				if (icon!="") {menuNode.icons.add(icon)}
				menuNode.link.uri=menuUri
				return this
			}
		}
		
		
		Boolean isMenuNode(Proxy.Node node){
			if (menuUri==null) assert(false):"menuUri not defined, register menu first, node=$node"
			return node.link.uri==menuUri //&& buttonMenu(node.text)!=null
			}
		
		Proxy.Node existingItemNode(Proxy.Node menuNode, String label,URI uri){
			Proxy.Node r= menuNode.children.find({it.link.uri==uri&&it.text==label})
			return r
		}
		
		Proxy.Node createItemNode(String label, String help, String icon){ //Service only
			if (menuNodeId=="")  {println "ERROR: to create item $label register menuNode first"; return null}
			if (itemUri==null) assert(false):"itemUri not defined, register item first"
			else{ 
				def menuNode=NodeLib.nodeForId(menuNodeId)
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
		
		void deleteItem(Proxy.Node itemNode){
			if (isItem(itemNode)) itemNode.delete() else println "WARNING: trying to delete node which is not item:$itemNode"}
		
		void deleteAllItems(){
			Proxy.Node menuNode=NodeLib.nodeForId(menuNodeId)
			if (isMenuNode(menuNode)){
				menuNode.children.each{ if (isItemNode(it))  it.delete()}
			} else assert (false): "ERROR trying to delete node which is not menu: $menuNode"
		}
		
		void itemAction(){
			def itemNode=NodeLib.selectedNode
			def menuNode=itemNode.parent
			registerMenuNode(menuNode)
			def menuLinkStr=menuNode.link.uri.toString()
			Button_MenuView_ButtonNode buttonMenu=buttonMenus[menuLinkStr]
			def itemLabel=itemNode.text  // verwijder link
			
			if (buttonMenu!=null&&buttonMenu.isItem(itemLabel)) {def action=buttonMenu.itemActions[itemLabel]; action()}
			else println "ERROR menu item not defined $itemNode"
		}
	}
		
	
	

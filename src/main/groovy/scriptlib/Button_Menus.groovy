package scriptlib
import org.freeplane.plugin.script.proxy.Proxy

class Button_Menus { // only one copy for a session; define in e.g. ControllerRoan.current.buttonMenus
	               
	private Button_MenusModel menusModel
	private URI menuUri
	static Closure deleteAllItems_extra

	Button_Menus(){
		if (menusModel==null) menusModel=new Button_MenusModel()
		
		}
	
// menuNode.link.uri -> menuLinkStr
	Button_MenuModel registerMenu(String menuLinkStr){ //one pro ButtonMenu
		assert (menusModel!=null):"First define menus"
		menuUri=menuLinkStr.toURI()
		return new Button_MenuModel(menusModel,menuUri)  // of menuUri string??
		}
	
	// itemNode.link.uri -> itemLinkStr; same for all items of all menu's
	void registerItem(Button_MenuModel menuModel,String itemLabel,Closure itemAction){
		assert (menusModel!=null):"First define menus"
		menuModel.itemActions[itemLabel]=itemAction
	}
	
	Button_MenuView defineMenuNode( Button_MenuModel menuModel, Proxy.Node node){""
		assert (menusModel!=null):"First define menus"
		return new Button_MenuView(node, menuModel, deleteAllItems_extra)
	}
	
	Boolean itemAction(Proxy.Node node){
		Button_MenuModel menuModel=menusModel.menuModel_ForNode(node.parent)
		if(Debug.debug) println "TEST menuModel=$menuModel"
		return menuModel.itemAction(node.text)
	}
	
	Boolean displayMenuAction(Proxy.Node node){
		Button_MenuModel menuModel=menusModel.menuModel_ForNode(node)
		if(Debug.debug) println "TEST menuModel=$menuModel"
		return menuModel.displayMenuAction(node)
	}
	
}

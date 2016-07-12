package scriptlib
//Author Jodi D.Krol 2014-03
import org.freeplane.plugin.script.proxy.Proxy

class Button_MenusModel {
	def  menusModel_Private=[:]
	
	String toString(){return "MenusModel[menusModel_Private=$menusModel_Private]"}
	
	Button_MenusModel(){ if (Debug.debug) println "TEST DEBUG: Define MenusModel $this" }
	
	void register(Button_MenuModel menuModel){
		menusModel_Private[menuModel.uri]=menuModel
		if (Debug.debug) println "TEST DEBUG: Register menuModel=$menuModel in $this"
	}
	
	Button_MenuModel menuModel_ForUri(String id_Uri){ return menusModel_Private[id_Uri]}
	Button_MenuModel menuModel_ForNode(Proxy.Node menuNode){ //???
		def id_Uri=menuNode.link.uri
		
		//println "TEST uri=$id_Uri;"
		//println "TEST $this; return menuModel:"
		//println menusModel_Private[id_Uri]
		return menusModel_Private[id_Uri]}
}

package scriptlib
//Author Jodi D.Krol 2014-03
import groovy.lang.Closure;

class Button_MenuModel { //logic only

	URI uri
	Closure displayMenuAction
	Button_MenusModel menus
	def itemActions=[:]
	
	String toString(){return "MenuModel[uri=$uri; itemActions=$itemActions; menus]"}
	
	Button_MenuModel(Button_MenusModel menus,URI uri, Closure displayAction){ // autoregisters menus
		this.uri=uri
		this.menus=menus
		menus.register(this)
		this.displayMenuAction=displayAction
		}
	
	def registerItemAction(String itemLabel,Closure itemAction){
		itemActions[itemLabel]=itemAction
		return this
	}
	
	Boolean itemAction(String itemLabel) {def a=itemActions[itemLabel]; if (a==null) return false else{ a(); return true}}
}

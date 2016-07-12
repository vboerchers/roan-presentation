package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import org.freeplane.core.resources.ResourceController;

class Action_Filtering extends ActionBoolean {
	
	static String key="filtering"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.filtering",
		"Filtering"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.filtering.tooltip",
		"<html>Virtually click automatic-filter button for<br>filtering nodes of current branch."
		)
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_Filtering(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		menu_tooltip=tooltip
		this.parms=parms
	}
	
	static Boolean getIsFilter(){
		Menu.current.filterButton.isOn
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		assert (parms!=null&&parms!=[])
		if (Controller.debug) println "DEBUG: ACTION setFilter,execute"
		if (parms[0]==value_ON){
			if(!isFilter){
				roan.Controller.current.filter_OnAction()
				Menu.current.filterButton.synchronizeOn(isFilter)
			}
		}
		 else if (parms[0]==value_OFF){
			if (isFilter){
				roan.Controller.current.filter_OffAction()
				Menu.current.filterButton.synchronizeOn(isFilter)
			}
		 }
	 }
}

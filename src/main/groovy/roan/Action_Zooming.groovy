package roan
//Author Jodi D.Krol
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import org.freeplane.core.resources.ResourceController;

class Action_Zooming extends ActionBoolean{
	
	static String key="zooming"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.zooming",
		"Zooming"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.zooming.tooltip",
		"<html>Virtually click automatic-zoom button for zooming in and out while stepping."
		)
	
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_Zooming(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	static Boolean getIsZoom(){
		Menu.current.autoZoomButton.isOn
	}
	
	Action setParms_translated(ArrayList parms_translated){
		parms=parm_fromParm_translation(parms_translated)
		return this
	}
	
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		assert (parms!=null&&parms!=[])
		if (Controller.debug) println "DEBUG: ACTION setFilter,execute"
		if (parms[0]==value_ON){
			if(!isZoom){
				Menu.current.autoZoomButton.setOn(false)
			}
		}
		 else if (parms[0]==value_OFF){
			if (isZoom){
				Menu.current.autoZoomButton.setOn(true)
			}
		 }
	 }
}

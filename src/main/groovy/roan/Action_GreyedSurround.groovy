package roan
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import org.freeplane.core.resources.ResourceController;

class Action_GreyedSurround extends ActionBoolean{
	
	static String key="greyedSurround"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.greyedSurround", 
		"Greyed surround"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.greyedSurround.tooltip",
		"<html>Virtually click greyed surround button<br>to enhance presentation focus."
		)
	
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_GreyedSurround(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	private static final String PRESENTATION_MODE_ENABLED = "presentation_mode"
	static Boolean getIsOn(){
		ResourceController.getResourceController().getBooleanProperty(PRESENTATION_MODE_ENABLED);
	}
	
	
	Action setParms_translated(ArrayList parms_translated){
		parms=parm_fromParm_translation(parms_translated)
		return this
	}
	
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		assert (parms!=null&&parms!=[])
		if (Controller.debug) println "DEBUG: ACTION greyBackground,execute"
		 if (parms[0]==value_ON){
			
			 roan.Controller.current.greyBackground_OnAction()
			 Menu.current.greyBackgroundButton.synchronizeOn(isOn)
			 //if(!MenuItems.isGreyBackground)actions+=[new Action('SetBooleanPropertyAction.presentation_mode')]
		 }
		 else if (parms[0]==value_OFF){
			 roan.Controller.current.greyBackground_OffAction()
			 Menu.current.greyBackgroundButton.synchronizeOn(isOn)
			 //if(MenuItems.isGreyBackground)actions+=[new Action('SetBooleanPropertyAction.presentation_mode')]
		 }
	 }
		
}



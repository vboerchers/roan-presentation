package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import org.freeplane.features.mode.Controller
import org.freeplane.features.ui.ViewController

class Action_FullScreen extends ActionBoolean{
	
	static String key="fullScreen"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.fullScreen",
		"Full screen"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.fullScreen.tooltip",
		"<html>Virtually click full screen button to hide or show menu bars "
		)
	
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_FullScreen(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	static Boolean getIsOn(){
		final ViewController viewController = Controller.getCurrentController().getViewController();
	    return viewController.isFullScreenEnabled()
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		assert (parms!=null&&parms!=[])
		if (roan.Controller.debug) println "DEBUG: ACTION setFullscreen, execute"
		if (parms[0]==value_ON){
			if (!isOn){
				roan.Controller.current.fullScreen_OnAction()
			}
			Menu.current.fullScreenButton.synchronizeOn(isOn)
		}
		 else if (parms[0]==value_OFF){
			 if (isOn){
				 roan.Controller.current.fullScreen_OffAction()
			 }
			 Menu.current.fullScreenButton.synchronizeOn(isOn)
		 }
	 }
}


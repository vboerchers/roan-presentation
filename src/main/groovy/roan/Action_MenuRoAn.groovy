package roan
// Author Jodi D.Krol 201408
import java.util.ArrayList;

import groovy.lang.Closure;
import scriptlib.Message

class Action_MenuRoAn extends ActionBoolean{
	
	static String key="menuRoan"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.menuRoan",
		"Menu RoAn size"
		)
	
	static String key_ON_translated=Message.textUtils.getText( //static necessary !
		"addons.roan.menuRoan.maximum",
		"Maximum"
		)
		
	static String key_OFF_translated=Message.textUtils.getText(
		"addons.roan.menuRoan.minimum",
		"Minimum"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.menuRoan.tooltip",
		"<html>Virtually click sizing button of Roan menu."
		)
	
	Action_MenuRoAn(ArrayList parms){
		name=key
		name_translated=key_translated
		ON_translated=key_ON_translated //override ActionBoolean
		OFF_translated=key_OFF_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //action
		if (parms[0]== value_ON) roan.Controller.current.plusSizeAction()
		else if (parms[0]== value_OFF) roan.Controller.current.minSizeAction()
	}
	
}

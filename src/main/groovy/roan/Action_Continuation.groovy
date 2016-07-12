package roan
// Author Jodi D.Krol 201408
import java.util.ArrayList;

import groovy.lang.Closure;
import scriptlib.Message

class Action_Continuation extends ActionBoolean{
	
	static String key="continuation"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.continuation",
		"Stop and Bounce"
		)
	
	static String key_ON_translated=Message.textUtils.getText( //static necessary !
		"addons.roan.continuation.STOP",
		"STOP"
		)
		
	static String key_OFF_translated=Message.textUtils.getText(
		"addons.roan.continuation.BOUNCE",
		"BOUNCE"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.continuation.tooltip",
		"<html>STOP: finish presentation.<br>BOUNCE: continue with sibling."
		)
	
	Boolean getIsStop(){
		return parms!=[]&&parms[0]==value_ON
	}
	
	Boolean getIsBounce(){
		return parms!=[]&&parms[0]==value_OFF
	}
	
	Action_Continuation(ArrayList parms){
		name=key
		name_translated=key_translated
		ON_translated=key_ON_translated //override ActionBoolean
		OFF_translated=key_OFF_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //action
		assert(false):"ERROR: Action_Continuation should not be executed"
		// See data.actions
	}
	
}


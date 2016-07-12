package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.MenuFreeplane
import scriptlib.MapLib

class Action_Delay extends Action { //menu:freeplaneAction
static String key="delay"

static String key_translated=Message.textUtils.getText( //used in Edit dialog
	"addons.roan.delay",
	"Delay"
	)

static String dialog_message=Message.textUtils.getText(
	"addons.roan.delay.message",
	"Delay/wait seconds"
	)

static String tooltip=Message.textUtils.getText(
	"addons.roan.delay.tooltip",
	"Display seconds"
	)

Action_Delay(ArrayList parms){ //parms irrelevant
	name=key
	name_translated=key_translated
	parm_fromParm_translation=parm_fromTranslation_private
	parm_toParm_translation=parm_toTranslation_private
	this.parms=parms
	menu_tooltip=tooltip
}

Closure parm_toTranslation_private={ //used in Edit dialog
	val-> return val  // no translation, raw menu key
}
						  
Closure parm_fromTranslation_private={//used in node
	val-> return val  //no translation, raw menu key
	}



@ Override
void execute(Data data, Data.State col){
	assert(false)
}


@ Override
void executeMenuItem(EditDialog editDialog){//invoker
	String value=Message.getInputStr(dialog_message)
	
	if (value) 	{
		parms[0]=value
		editDialog.addScripActionStr(action_translatedStr)
	}
}

String getDelayStr(){ if (parms==[]) return "" else return parms[0]}
}


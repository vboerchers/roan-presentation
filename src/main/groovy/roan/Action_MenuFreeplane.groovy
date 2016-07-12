package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.MenuFreeplane

class Action_MenuFreeplane extends Action { //menu:freeplaneAction
static String key="menuFreeplane"

static String key_translated=Message.textUtils.getText( //used in Edit dialog
	"addons.roan.menuFreeplane",
	"Menu action"
	)

static String dialog_message=Message.textUtils.getText(
	"addons.roan.menuFreeplane.dialog_message",
	"<html>Execute freeplane menu action.<br>Get with addon Developer tools and paste here:"
	)

static String tooltip=Message.textUtils.getText(
	"addons.roan.menuFreeplane.tooltip",
	"<html>Execute freeplane menu action."
	)

Action_MenuFreeplane(ArrayList parms){ //parms irrelevant
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
	if (parms!=null&&parms!=[]) MenuFreeplane.invoke_executeMenuActions([parms[0]])
}


@ Override
void executeMenuItem(EditDialog editDialog){//invoker
	String value=Message.getInputStr(dialog_message)
	parms[0]=value
	if (value) 	editDialog.addScripActionStr(action_translatedStr)
}
}

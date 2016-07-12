package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.MenuFreeplane
import scriptlib.MapLib
import scriptlib.NodeLib

class Action_Jump extends Action { //menu:freeplaneAction
static String key="jump"

static String key_translated=Message.textUtils.getText( //used in Edit dialog
	"addons.roan.jump",
	"Jump"
	)

static String tooltip=Message.textUtils.getText(
	"addons.roan.jump.tooltip",
	"Jump to currently selected node"
	)

static String warningMessage=Message.textUtils.getText(
	"addons.roan.jump.warningMessage",
	"You have to select a node to jump to, not being the current node."
	)

Action_Jump(ArrayList parms){ //parms irrelevant
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
	if (parms!=null&&parms!=[]){
	  

	}
}


@ Override
void executeMenuItem(EditDialog editDialog){//invoker
	String selectedId=NodeLib.selectedNode.id
	if (editDialog.currentNode.id==selectedId) Message.warning(warningMessage)
	else {
		parms[0]=selectedId
		editDialog.addScripActionStr(action_translatedStr)
	}
}

String getNodeId(){ if (parms==[]) return "" else return parms[0]}
}

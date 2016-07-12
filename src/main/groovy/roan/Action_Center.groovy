package roan
//Author Jodi D.Krol 201408
import java.util.ArrayList;

import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.NodeLib
import scriptlib.MapLib

class Action_Center extends ActionBoolean{
	
	static String key="center"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.center",
		"Center"
		)
	static String tooltip=Message.textUtils.getText(
		"addons.roan.center.tooltip",
		"Center currently selected node."
		)

	Action_Center(ArrayList parmsList){
		super()
		name=key
		name_translated=key_translated
		parms=parmsList
		menu_tooltip=tooltip
		allSelecteds=true
		skipCurrentNode=true
	}
	
	String toString(){return key_translated+"["+ parms_translatedStr+"]"} //for EditDialog Actions ComboBox
	
	
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		def node
		def state=parms[0]
		if (state==value_ON){
			if (parms==null||parms.size()<2) node=data.node
			else {String nodeId=parms[1]; node=NodeLib.nodeForId(nodeId)}
			Boolean slow=true
			Boolean isScenario=(data.isScenario&&data.node==node)
			if (!isScenario) MapLib.invoke_centerNode(node,slow)
		}
		else{} //skip
		}
	
	//***MenuObject
	
	/*
	void executeMenuItem(EditDialog editDialog){//invoker
		def selectedNode=NodeLib.selectedNode
		if (editDialog.currentNode==selectedNode) setParms([])
		else setParms([selectedNode.id])
		editDialog.addScripActionStr(action_translatedStr)
	}
	*/
	//***
}

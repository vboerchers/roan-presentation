package roan
//Author Jodi D.Krol 201408
import java.util.ArrayList;
import scriptlib.WindowLib
import groovy.lang.Closure
import scriptlib.Message
import scriptlib.NodeLib

class Action_DetailsVisibility extends ActionBoolean{
	
	static String key="detailsVisible"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.detailsVisible.key",
		"Details"
		)
	
	static String key_ON_translated=Message.textUtils.getText( //static necessary !
		"addons.roan.detailsVisible.show",
		"SHOW"
		)
		
	static String key_OFF_translated=Message.textUtils.getText(
		"addons.roan.detailsVisible.hide",
		"HIDE"
		)
	static String tooltip=Message.textUtils.getText(
		"addons.roan.detailsVisible.tooltip",
		"<html>Set details for node of this action (default) or<br>for currently selected node(s)"
		)
	
	Action_DetailsVisibility(ArrayList parms){
		name=key
		name_translated=key_translated
		ON_translated=key_ON_translated //override ActionBoolean
		OFF_translated=key_OFF_translated
		menu_tooltip=tooltip
		this.parms=parms
		
		ask_allSelecteds=true
	}
	
	void execute(Data data, Data.State col){  //action
		Boolean b=!isON
		if (b!=null) nodesForIdsInParms.each{
			Boolean isScenario=(data.isScenario&&data.node==it)
			if (!isScenario){
				NodeLib.invoke_setHideDetails(it,b)
				WindowLib.scrollToVisible(it)
			}
			}
		}
	
}


package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import org.freeplane.core.resources.ResourceController;

class Action_HomeRoAn extends Action{
	
	static String key="homeRoAn"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.homeRoAn",
		"Home RoAn"
		)
	static String tooltip=Message.textUtils.getText(
		"addons.roan.homeRoAn.tooltip",
		"<html>Virtually click RoAn button home."
		)
	
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_HomeRoAn(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=[]
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		Controller.current.homeAction()
	}
}

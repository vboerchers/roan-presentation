package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import scriptlib.MenuFreeplane
import org.freeplane.core.resources.ResourceController;

class Action_FollowLink extends Action{
	
	static String key="followLink"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.followLink",
		"Follow link"
		)
	static String tooltip=Message.textUtils.getText(
		"addons.roan.followLink.tooltip",
		"<html>Open and display link."
		)
	
	//zie ActionBoolean Closure parm_toTranslation
	//                   Closure parm_fromTranslation
	
	Action_FollowLink(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=[]
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		if(data.node.link!=null)	MenuFreeplane.invoke_executeMenuActions(['FollowLinkAction'])
	}
}

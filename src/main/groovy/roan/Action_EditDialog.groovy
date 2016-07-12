package roan
//Author Jodi D.Krol 201408
import scriptlib.Message
import scriptlib.NodeLib

class Action_EditDialog extends Action{
	
	static String key="toggleEditDialog"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.toggleEditDialog",
		"Toggle Edit dialog"
		)
	static String tooltip=Message.textUtils.getText(
		"addons.roan.toggleEditDialog.tooltip",
		"<html>Show or hide RoAn's Edit dialog."
		)

	Action_EditDialog(ArrayList dummy){
		super()
		name=key
		name_translated=key_translated
		parms=[]
		menu_tooltip=tooltip
	}
	
	String toString(){return key_translated} //for EditDialog Actions ComboBox
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		roan.Controller.current.editDialogAction()
	 }
}
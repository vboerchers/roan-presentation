package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.NodeLib
import scriptlib.StringLib
import scriptlib.WindowLib
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.Message
import scriptlib.MenuObject

class Action_Selecteds extends Action{
	
	String toString(){return key_translated} // for ComboBox
	
	static String key="selecteds"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.selecteds",
		"Selected nodes"
		)
	static String addingCurrentlySelected=Message.textUtils.getText(
		"addons.roan.selecteds.addingCurrentlySelected",
		"Adding currently selected nodes:"
		)
	static String change=Message.textUtils.getText(
		"addons.roan.selecteds.change",
		"To change selection: press Cancel."
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.selecteds.tooltip",
		"<html>The currently selected nodes will be selected."
		)
	
	Closure parm_toParm_translation={val->
		return val
	}
	
	Closure parm_fromParm_translation={val ->
		return val
	}
	
	Action_Selecteds(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	
	void execute(Data data, Data.State col){ 
		
		ArrayList nodes=nodesForIdsInParms
		nodes.each{
			if (it==null) assert (false) else {
				Boolean isScenario=(data.isScenario&&data.node==it)
				if (!isScenario) {NodeLib.invoke_unfoldParents(it);WindowLib.invoke_scrollToVisible(it)}
				}
		} 
		NodeLib.invoke_selectNodes(nodes)
		roan.Controller.current.invoke_setCurrentNodeInRoot(data.node)
		}
	
	//***MenuObject
	void setMenu(EditDialog editDialog){
		def menu=editDialog.actionsButton.setItem(key_translated, new Action_Selecteds()) //new = workaround for usting this
		menu.setToolTipText(tooltip)
	}
	static ActionsField scriptActions // workaround; global for use in listener
	void executeMenuItem(EditDialog editDialog){//invoker)
		def selecteds=NodeLib.selectedNodes
		String r=""
		selecteds.each{if (r=="") r=it.id else r+=","+ it.id}
		
		if (Message.confirm(addingCurrentlySelected+r+"\n"+change)){
			r=key_translated+":"+r
			scriptActions=editDialog.currentScriptActionsField
			if (scriptActions.text=="") scriptActions.text=r
			else scriptActions.setText( scriptActions.text+"\n"+r)
		}
	}
	//***
	}   

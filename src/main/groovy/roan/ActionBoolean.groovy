package roan
//Author Jodi D.Krol
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.StringLib
import scriptlib.NodeLib
import  java.lang.reflect.Constructor

class ActionBoolean extends Action{
	
	static String allSelectedsMessage=Message.textUtils.getText(
		"addons.roan.actionBoolean.allSelectedsMessage",
		"By default node with action.\nApply to currently selected node(s) ?"
		)
	static String key_ON_translated=Message.textUtils.getText( //static necessary !
		"addons.roan.actionBoolean.ON",
		"ON"
		)
		
	static String key_OFF_translated=Message.textUtils.getText(
		"addons.roan.actionBoolean.OFF",
		"OFF"
		)
	
	static String key_NULL_translated=Message.textUtils.getText(
		"addons.roan.boolean.null",
		"Null"
		)
	
	static String value_ON="TRUE"  // used in node only
	static String value_OFF="FALSE"
	static String value_NULL="NULL"
	Boolean allSelecteds=false  //adds list of nodeId's
	Boolean ask_allSelecteds=false //asks to  ,,
	Boolean skipCurrentNode=false
	
	Closure parm_toParm_translation_private={ //used in Edit dialog
		String val-> 
		if(val==value_ON) return ON_translated //prefix necessary !!
		else if(val==value_OFF) return OFF_translated
		else if(val==value_NULL) return NULL_translated
		else return val //ID_...
	}
		                      
	Closure parm_fromParm_translation_private={//used in node
		String val->
		if(val==ON_translated) return value_ON
		else if(val==OFF_translated) return value_OFF
		if(val==NULL_translated) return value_NULL
		else return val //ID_...
		} 
	
	String ON_translated=key_ON_translated
	String OFF_translated=key_OFF_translated
	String NULL_translated=key_NULL_translated
	
	
	Boolean getIsON(){     if (parms.contains(value_ON)) return true
		              else if (parms.contains(value_OFF)) return false
					  else return null
	}
	

	
	ActionBoolean(){
		super()
		// empty, abstract
		// in subclass:  name= , name_translated=, execute(parms)
		
		parm_toParm_translation=parm_toParm_translation_private
		parm_fromParm_translation=parm_fromParm_translation_private
	}	
	
	//***MenuObject
	void setMenu(EditDialog editDialog){//invoker
		def menu=editDialog.actionsButton.setMenu(name_translated)
		if(menu_tooltip!=null) menu.setToolTipText(menu_tooltip)

		def cl=this.class
		editDialog.actionsButton.setItem(menu,ON_translated, cl.getConstructor(ArrayList.class).newInstance([value_ON]))
		editDialog.actionsButton.setItem(menu,OFF_translated, cl.getConstructor(ArrayList.class).newInstance([value_OFF]))
	}
	
	void executeMenuItem(EditDialog editDialog){//invoker
		if(ask_allSelecteds) {allSelecteds=Message.confirm(allSelectedsMessage)}
		if (allSelecteds){
		    String selectedsStr=""
			def selectedNodes=NodeLib.selectedNodes
			if (skipCurrentNode) selectedNodes-=[editDialog.currentNode]
			selectedNodes.each{if (selectedsStr=="") selectedsStr=it.id else selectedsStr+=","+ it.id} 
			
			if (selectedsStr!="") parms[1]=selectedsStr else parms-=parms[1]
		}
		 editDialog.addScripActionStr(action_translatedStr)
	}
	//***
}




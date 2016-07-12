package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import org.freeplane.features.filter.FilterController
import java.util.ArrayList
import javax.swing.JComboBox
import javax.swing.JPanel
import scriptlib.Message
import scriptlib.NodeLib
import scriptlib.FilterLib
import scriptlib.StringLib
import org.freeplane.plugin.script.proxy.Proxy
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

class Action_FilterNamed extends Action{
	
	//filter:name,showParents,showChildren,applyToVisibleNodesOnly,ID_nodesToSelect
	
	
	static String key="filterNamed"
	
	static String key_translated=Message.textUtils.getText(
		"addons.roan.filterNamed",
		"Filter (named)"
		)
	
	static String dialogTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.dialogTitle",
		"Apply predefined named filter."
		)
	
	static String error=Message.textUtils.getText(
		"addons.roan.filterNamed.error",
		"You must first define a named filter with the freeplane Compose filter editor."
		)
	
	static String hideAncestorsTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.hideAncestorsTitle",
		"Hide ancestors"
		)
	
	static String showAncestorsTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.showAncestorsTitle",
		"Show ancestors"
		)
	
	static String ancestorsNULLTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.ancestorsNULL",
		"Default ancestors"
		)
	
	static String hideDescendantsTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.hideDesendantsTitle",
		"Hide descendants"
		)
	
	static String showDescendantsTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.showDescendantsTitle",
		"Show descendants"
		)
	
	static String descendantsNULLTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.descendantsNULL",
		"Default descendants"
		)
	
	static String visibleNodesOFFTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.applyToAllNodesTitle",
		"Apply to all nodes "
		)
	
	static String visibleNodesOnlyONTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.applyToVisibleNodesOnlyTitle",
		"Apply to visible nodes only"
		)
	static String visibleNodesOnlyNULLTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.visibleNodesOnlyNULLTitle",
		"Default visible/all"
		)
	
	static String selectCurrentTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.selectCurrentTitle",
		"Select current node"
		)
	
	static String selectCurrentlySelectedsTitle=Message.textUtils.getText(
		"addons.roan.filterNamed.selectCurrentlySelectedsTitle",
		"Select currently selected nodes"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.filterNamed.tooltip",
		"<html>Set named filter.<br>Select for dialog."
		)
	
	static String value_hideAncestors="ancestorsOFF"
	static String value_showAncestors="ancestorsON"
	static String value_ancestorsNULL="ancestorsNULL"
	static String value_hideDescendants="descendantsOFF"
	static String value_showDescendants="descendantsON"
	static String value_descendantsNULL="descendantsNULL"
	static String value_visibleNodesOnlyOFF="visibleOnlyOFF"
	static String value_visibleNodesOnlyON="visibleOnlyON"
	static String value_visibleNodesOnlyNULL="visibleOnlyNULL"
	
	Boolean getIsShowAncestors(){ 
		     if (parms.contains(value_showAncestors)) return true
		else if (parms.contains(value_hideAncestors)) return false
		else return FilterController.getCurrentFilterController().showAncestors.isSelected()
		}
	Boolean getIsShowDescendants(){
		if (parms.contains(value_showDescendants)) return true
		else if (parms.contains(value_hideDescendants)) return false
		else return FilterController.getCurrentFilterController().showDescendants.isSelected()
   		}
	Boolean getIsApplyToVisibleNodesOnly(){
		if (parms.contains(value_visibleNodesOnlyON)) return true
		else if (parms.contains(value_visibleNodesOnlyOFF)) return false
		else return FilterController.getCurrentFilterController().applyToVisibleNodeOnly.isSelected()
		   }
	String getFilterName(){if (parms==null||parms==[]) return ""
		else return parms[0]
		}
	
	Closure parm_toParm_translation={val->
			 if (val==value_hideAncestors) return hideAncestorsTitle
		else if (val==value_showAncestors) return showAncestorsTitle
		else if (val==value_ancestorsNULL) return ancestorsNULLTitle
		else if (val==value_hideDescendants) return hideDescendantsTitle
		else if (val==value_showDescendants) return showDescendantsTitle
		else if (val==value_descendantsNULL) return descendantsNULLTitle
		else if (val==value_visibleNodesOnlyOFF) return visibleNodesOFFTitle
		else if (val==value_visibleNodesOnlyON) return visibleNodesOnlyONTitle
		else if (val==value_visibleNodesOnlyNULL) return visibleNodesOnlyNULLTitle
		else return val //ID_...
	}
	
	Closure parm_fromParm_translation={val ->
			 if (val==hideAncestorsTitle)return value_hideAncestors
		else if (val==showAncestorsTitle)return value_showAncestors
		else if (val==ancestorsNULLTitle)return value_ancestorsNULL
		else if (val==hideDescendantsTitle)return value_hideDescendants
		else if (val==showDescendantsTitle) return value_showDescendants
		else if (val==descendantsNULLTitle) return value_descendantsNULL
		else if (val==visibleNodesOFFTitle) return value_visibleNodesOnlyOFF
		else if (val==visibleNodesOnlyONTitle)return value_visibleNodesOnlyON
		else if (val==visibleNodesOnlyNULLTitle)return value_visibleNodesOnlyNULL
		else return val  //ID_...
	}
	
	Action_FilterNamed(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	ArrayList getNodeIdsToSelect(){
		nodeIdsInParms
	}
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		data.filterNamed=this
		
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
			ArrayList selectedNodeIds=[]// data.filterNamed.nodeIdsInParms
			if (selectedNodeIds==[])selectedNodeIds=[data.node.id]
			   roan.Controller.current.setCurrentNodeInRoot(data.node)// to use when continuing
			   FilterLib.applyFilterConditionWithName((String) data.filterNamed.filterName,
				   									 (Boolean) data.filterNamed.isShowAncestors, 
													 (Boolean) data.filterNamed.isShowDescendants, 
													 (Boolean) data.filterNamed.isApplyToVisibleNodesOnly, 
													 ( ArrayList) selectedNodeIds)
			   NodeLib.root.folded=false
			   FilterLib.unfoldVisibleNodes()
			   Controller.current.isConditionWithNameFilter=true
			}})

	   Controller.current.isConditionWithNameFilter=true
	   
	   }
	
	@ Override
	void executeMenuItem(EditDialog editDialog){//invoker
		
		if (FilterLib.namesOfConditions==[]){Message.warning(error)}
		else{
		JPanel myPanel = new JPanel()
		
		 String[] s= FilterLib.namesOfConditions
		JComboBox nameCB = new JComboBox(s)
		myPanel.add(nameCB)
		
		s=[hideAncestorsTitle, showAncestorsTitle, ancestorsNULLTitle]
		JComboBox ancestorsCB = new JComboBox(s)
		myPanel.add(ancestorsCB)
		
		s=[hideDescendantsTitle, showDescendantsTitle, descendantsNULLTitle]
		JComboBox childrenCB = new JComboBox(s)
		myPanel.add(childrenCB)
		
		s=[visibleNodesOFFTitle, visibleNodesOnlyONTitle, visibleNodesOnlyNULLTitle]
		JComboBox applyCB = new JComboBox(s)
		myPanel.add(applyCB)
		
		s=[selectCurrentTitle, selectCurrentlySelectedsTitle]
		JComboBox nodesCB = new JComboBox(s)
		myPanel.add(nodesCB)
		
		int result = JOptionPane.showConfirmDialog(null, myPanel,dialogTitle, JOptionPane.OK_OPTION)
		if (result == JOptionPane.OK_OPTION) {
			String selectedsStr=""
			if (nodesCB.selectedItem==selectCurrentlySelectedsTitle){
				def selectedNodes=NodeLib.selectedNodes
				selectedNodes.each{if (selectedsStr=="") selectedsStr=it.id else selectedsStr+=","+ it.id}
				editDialog.addScripActionStr(key_translated+":"+nameCB.selectedItem+","+ancestorsCB.selectedItem+","+childrenCB.selectedItem+","+applyCB.selectedItem+","+selectedsStr)
			}
			else editDialog.addScripActionStr(key_translated+":"+nameCB.selectedItem+","+ancestorsCB.selectedItem+","+childrenCB.selectedItem+","+applyCB.selectedItem)
		}
	}
	}
}


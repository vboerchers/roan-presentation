package roan
//Author Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.WindowLib
import java.util.ArrayList
import javax.swing.JComboBox
import javax.swing.JPanel
import scriptlib.Message
import scriptlib.NodeLib
import scriptlib.StringLib
import org.freeplane.plugin.script.proxy.Proxy
import javax.swing.JOptionPane

class Action_Folding extends Action{
	
	//folding:fold,root,All
	
	
	static String key="folding"
	
	static String key_translated=Message.textUtils.getText(
		"addons.roan.folding",
		"Folding"
		)
	
	static String fold=Message.textUtils.getText(
		"addons.roan.folding.fold",
		"Fold"
		)
	
	static String unfold=Message.textUtils.getText(
		"addons.roan.folding.unfold",
		"Unfold"
		)
	
	static String current=Message.textUtils.getText(
		"addons.roan.folding.current",
		"Action node"
		)
	static String selecteds=Message.textUtils.getText(
		"addons.roan.folding.selecteds",
		"Currently selected nodes"
		)
	
	static String root=Message.textUtils.getText(
		"addons.roan.folding.root",
		"Root node"
		)
	
	static String all=Message.textUtils.getText(
		"addons.roan.folding.all",
		"All"
		)
	
	static String level1=Message.textUtils.getText(
		"addons.roan.folding.level1",
		"First level"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.folding.tooltip",
		"<html>Fold or unfold node(s).<br>Select for dialog."
		)
	
	static String value_fold="fold"
	static String value_unfold="unfold"
	static String value_root="root"
	static String value_current="current"
	static String value_selecteds="selecteds"  //current
	static String value_all="all"
	static String value_level1="level1"
	
	Boolean getIsFold(){ parms.contains(value_fold)}
	Boolean getIsUnfold(){ parms.contains(value_unfold)}
	Boolean getIsCurrent(){ parms.contains(value_current)}
	Boolean getIsLevel1(){ parms.contains(value_level1)}
	Boolean getIsAll(){ parms.contains(value_all)}//return (parms.size()>1&& parms[parms.size()-1]==value_all)}
	Boolean getIsSelected(){ parms.contains(value_selecteds)}
	Boolean getIsRoot(){ parms.contains(value_root)}
	
	Closure parm_toParm_translation={val->
		     if (val==value_fold) return fold
		else if (val==value_unfold) return unfold
		else if (val==value_current) return current
		else if (val==value_root) return root
		else if (val==value_selecteds) return selecteds
		else if (val==value_level1) return level1
		else if (val==value_all) return all
		else return val //ID_...
	}
	
	Closure parm_fromParm_translation={val ->
		     if (val==fold)return value_fold
		else if (val==unfold)return value_unfold
		else if (val==current)return value_current
		else if (val==root)return value_root
		else if (val==selecteds) return value_selecteds
		else if (val==all) return value_all
		else if (val==level1)return value_level1
		else return val  //ID_...
	}
	
	Action_Folding(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
       ArrayList nodes=nodesForIdsInParms
	   
	   if(isFold){
			if (isRoot) NodeLib.invoke_foldAll(NodeLib.root) 
			else if (nodes==[]){
				 if(isAll) NodeLib.invoke_foldAll(NodeLib.selectedNode()) 
				 else NodeLib.invoke_fold(NodeLib.selectedNode()) 
				}
			else if(nodes!=[]) {
				if (isAll) nodes.each{NodeLib.invoke_foldAll(it)}
				else   nodes.each{NodeLib.invoke_fold(it)}
			} 
	   }
	   else{// unfold
		   if (isRoot) NodeLib.invoke_unfoldAll(NodeLib.root)
		   else if (nodes==[]){
			   Boolean isScenario=(data.isScenario)
				if(!isScenario&&isAll) NodeLib.invoke_unfoldAll(NodeLib.selectedNode())
				else if(!isScenario) NodeLib.invoke_folded(NodeLib.selectedNode(),false)
			   }
		   else if(nodes!=[]) {
			   nodes.each{
				   Boolean isScenario=(data.isScenario&&data.node==it)
				   if (!isScenario&&isAll) NodeLib.invoke_unfoldAll(it)
				   else if (!isScenario)   {NodeLib.invoke_folded(it, false); WindowLib.invoke_scrollToVisible(it)}
			   }
			  
		   }
		   
	   }
	 }
	
	@ Override
	void executeMenuItem(EditDialog editDialog){//invoker
		
		JPanel myPanel = new JPanel()
		String[] s=[fold,unfold]
		JComboBox foldingCB = new JComboBox(s)
		myPanel.add(foldingCB)
		s=[level1, all]
		JComboBox levelsCB = new JComboBox(s)
		myPanel.add(levelsCB)
		s=[current, root, selecteds]
		JComboBox nodesCB = new JComboBox(s)
		myPanel.add(nodesCB)
		
		int result = JOptionPane.showConfirmDialog(null, myPanel,key_translated, JOptionPane.OK_OPTION)
		if (result == JOptionPane.OK_OPTION) {
			String selectedsStr=""
			if (nodesCB.selectedItem==selecteds){
				def selectedNodes=NodeLib.selectedNodes
				selectedNodes.each{if (selectedsStr=="") selectedsStr=it.id else selectedsStr+=","+ it.id}
				editDialog.addScripActionStr(key_translated+":"+foldingCB.selectedItem+","+levelsCB.selectedItem+","+selectedsStr)
			}
			else editDialog.addScripActionStr(key_translated+":"+foldingCB.selectedItem+","+levelsCB.selectedItem+","+nodesCB.selectedItem)
		}
	}
}

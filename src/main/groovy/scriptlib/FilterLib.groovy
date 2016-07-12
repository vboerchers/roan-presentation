package scriptlib
//Author Jodi D.Krol 20140801
//import org.freeplane.features.filter.Filter;
import org.freeplane.features.filter.FilterController
import org.freeplane.features.filter.condition.ASelectableCondition;
import org.freeplane.features.filter.condition.ICondition;
import org.freeplane.features.mode.Controller;
import javax.swing.DefaultComboBoxModel;
 
class FilterLib {

	static void loadAndAddConditions(String path){
		def controller=FilterController.getCurrentFilterController()
		if (FileLib.exists(path)) 	 {
		try {
			//FP 1.3
			controller.loadConditions(controller.getFilterConditions(),path,true);  //if (Controller.debug) println "DEBUG loaded $path"
			}
			catch (Exception e) {
			   // FP 1.2
				controller.loadConditions(controller.getFilterConditions(),path)
			   //if (Controller.debug) println "DEBUG FP 1.2 loaded $path"
			}
			}
		else {
			println "WARNING: No saved filter  RoAn:  $path "
			//scriptlib.Message.warning("Missing filter file:$path")
			}
	}
	
	static Boolean isNamedCondition(String name){
		return namesOfConditions.contains(name)
	}
	static ArrayList getNamesOfConditions(){
		ArrayList r=[]
		def fc=FilterController.getCurrentFilterController().getFilterConditions()
		(0..fc.size()-1).each{String e= fc.getElementAt(it).getUserName(); if (e!=null) r+=[e]}
		return r
	}
	
	static void saveCurrentConditions(String path){
		def c= FilterController.getCurrentFilterController().getFilterConditions()
		FilterController.getCurrentFilterController().saveConditions(c, path)
	}
	
	static void clearConditions(){
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		FilterController.getCurrentFilterController().setFilterConditions(model) // clear existing model; MESSAGE toevoegen; optellen bij bestaand ??
	}
	
	static Integer getIndexConditionWithName (String name){ // null if no name
		Integer r=null
		def fc=FilterController.getCurrentFilterController().getFilterConditions()
		(0..fc.size()-1).each{String e= fc.getElementAt(it).getUserName(); if (e!=null&&e==name)  r=it}
		if (r==null) return null else return  r
	}
	
	static ASelectableCondition getConditionWithName (String name){ // null if no name
		Integer r=null
		def fc=FilterController.getCurrentFilterController().getFilterConditions()
		(0..fc.size()-1).each{String e= fc.getElementAt(it).getUserName(); if (e!=null&&e==name)  r=it}
		if (r==null) return null else return  fc.getElementAt(r)
	}
	
	static void applyFilterConditionWithName(String name) {
		Boolean showAncestors=false//FilterController.getCurrentFilterController().showAncestors.isSelected()
		Boolean showDescendants=false//FilterController.getCurrentFilterController().showDescendants.isSelected()
		Boolean applyToVisibleNodeOnly=false//FilterController.getCurrentFilterController().applyToVisibleNodeOnly.isSelected()
		applyFilterConditionWithName(name,showAncestors, showDescendants, applyToVisibleNodeOnly,null) 
	}
	
	static void applyFilterConditionWithName(String name, Boolean showAncestors, Boolean showDescendants, Boolean applyToVisibleNodeOnly, String nodeToSelectId) {
		applyFilterConditionWithName(name, showAncestors, showDescendants, applyToVisibleNodeOnly, [nodeToSelectId]) 
		}
	static void applyFilterConditionWithName(String name, Boolean showAncestors, Boolean showDescendants, Boolean applyToVisibleNodeOnly, ArrayList nodeToSelectIds) {	
		ArrayList nodesToSelect=[]
		final ASelectableCondition selectedCondition = getConditionWithName(name);
		if (selectedCondition==null) { println "TEST WARNING: no filtercondition name= $name"}
		else{
			final org.freeplane.features.filter.Filter filter = 
				new org.freeplane.features.filter.Filter(selectedCondition, (Boolean) showAncestors, (Boolean) showDescendants, (Boolean) applyToVisibleNodeOnly);
				def fc=FilterController.getCurrentFilterController().getFilterConditions() //TEST temp
				fc.setSelectedItem(selectedCondition) //TEST temp
				filter.applyFilter(filter, Controller.getCurrentController().getMap(), true);
				filter.displayFilterStatus()//TEST temp
		}
		if (nodeToSelectIds!=null&&nodeToSelectIds!=[]){ //TEST temp
			if (nodeToSelectIds!=null&&nodeToSelectIds!=[]){
					nodeToSelectIds.each{
						def n=NodeLib.nodeForId(it)
						if (n!=null&&n.isVisible()){nodesToSelect+=[n]; WindowLib.scrollToVisible(n)}
				    }
					NodeLib.selectNodes(nodesToSelect)
			}
			 else NodeLib.selectNode(firstVisibleNode)
		}
	}
	/*
	static getIsFilter(){// TEST temp
		//def a=FilterController.getCurrentFilterController().getFilterToolbar().g
		def f= FilterController.getCurrentFilterController().getFilterConditions().getSelectedItem()
		Boolean b=false;
		b= (f!=null&&f!= FilterController.NO_FILTERING)
		//def filter=Controller.getCurrentController().getMap().getFilter()
		println "TEST temp f=$f; filter=$b; nofilter=$FilterController.NO_FILTERING"
		//return filter!=null
		//println "TEST map.filter=$NodeLib.root.map.filter"
		return b
	}
	*/
	static void stopFilter(){
				NodeLib.root.map.undoFilter()
				NodeLib.root.map.filter=null
				NodeLib.root.children.each{it.folded=true}
				def fc=FilterController.getCurrentFilterController().getFilterConditions() //TEST temp
				fc.setSelectedItem(FilterController.NO_FILTERING) //TEST temp
	}		
	
	static def getFirstVisibleNode(){
		def result=firstVisibleNode(NodeLib.root)
		if (result==null) return NodeLib.root else return result
		}
	
	static def firstVisibleNode(def node){
		Boolean done=false
		def result=null
		node.children.each{
			if(result==null){
			  if (it.isVisible()) result= it 
			  else result= firstVisibleNode(it) 
	         }
		}
		return result	
		}	
	
	static void unfoldVisibleNodes(){
		unfoldVisibleNodes(NodeLib.root)
	}
	static void unfoldVisibleNodes(def node){
		if (node!=null) node.children.each{ 
			 if (it.isVisible()) it.folded=false
			 unfoldVisibleNodes(it);
			 }
	}
}

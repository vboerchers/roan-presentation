package roan

//Author Jodi D.Krol 201408
import org.freeplane.features.filter.FilterController

  class FilterConditionSetting{
		  String name
		  Boolean showAncestors=false//FilterController.getCurrentFilterController().showAncestors.isSelected()
		  Boolean showDescendants=false//FilterController.getCurrentFilterController().showDescendants.isSelected()
		  Boolean applyToVisibleNodeOnly=false//FilterController.getCurrentFilterController().applyToVisibleNodeOnly.isSelected()
		  String nodeToSelect=null
		  
		  String toString(){"FilterConditionSetting[name =$name; showAncestors=$showAncestors; showDescendants=$showDescendants; applyToVisibleNodeOnly=$applyToVisibleNodeOnly; nodeToSelect=$nodeToSelect]"}
		  
		  Boolean getIs(){return name!=""}
		  
		  FilterConditionSetting (String eventStr){ // #myName;showAncestors;...;ID_XXXXX   At minimum #myName
			  //println eventStr
			 // println eventStr.trim()[0]
		  if (eventStr!=null&&eventStr!=""){
			  if (eventStr.trim()[0]=='#'||eventStr.trim().substring(0,3)!="ID_"){ 
				  ArrayList al=eventStr.split (";")
				  
				  name=al[0]-'#' // depreciated
				  al-=al[0]
				  
				  if (al!=[]){
					  nodeToSelect=al[al.size()-1]
					  String nodeId=al[al.size()-1]
				  
					  // last element nodeToSelect
					  if ( nodeId.substring(0,3)=="ID_"){
						  nodeToSelect=nodeId
						  al-=[nodeId]
					  }
				  }
				  
				  String v
				  if (al!=[]){
					  
					  if (al[0].trim()!="") v=al[0].trim()[0].toUpperCase()
					  if (v=="T")  showAncestors=true 
					  else  if (v=="F") showAncestors=false
					  else showAncestors=FilterController.getCurrentFilterController().showAncestors.isSelected()
					  
					  if (al.size()>1){
				  		  if (al[1].trim()!="") v=al[1].trim()[0].toUpperCase()
						  if (v=="T") showDescendants=true
						   else  if (v=="F") showDescendants=false
						   else showDescendants=FilterController.getCurrentFilterController().showDescendants.isSelected()
					  
						   if (al.size()>2){
							  if (al[2].trim()!="") v=al[2].trim()[0].toUpperCase()
							  if (v=="T") applyToVisibleNodeOnly=true
							  else  if (v=="F") applyToVisibleNodeOnly=false
							  else applyToVisibleNodeOnly=FilterController.getCurrentFilterController().applyToVisibleNodeOnly.isSelected()
						   }
					  }
			  	} 
			  }
		  }
		  }
}

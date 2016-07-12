package roan
//Author Jodi D.Krol 201408
import java.util.ArrayList
import scriptlib.MenuObject
import scriptlib.StringLib
import scriptlib.NodeLib
import org.freeplane.plugin.script.proxy.Proxy
//import java.awt.Component

class Action extends MenuObject{ // actionStr= action; or actionStr=actionName:x,y,...==> x,y,... is parms //as in Edit dialog
	  
	// set in subclass
		String name=null
		String name_translated=null
		String menu_tooltip=null
		ArrayList parms=null
		Closure parm_toParm_translation={println "ERROR, not defined in subclass: parm_toTranslation"} 
		Closure parm_fromParm_translation={println "ERROR, not defined in subclass: parm_fromTranslation"}
	//
	   	
		String toString(){ // to be overruled in subclass by name_translated, for use in JComboBox
			return "Action[name=$name; name_translated=$name_translated; parms=$parms]" 
		}
		
		Action(){
			//define in subclass.....
			//name=key
			//name_translated=key_translated
			//parm_fromTranslation=
			//parm_toTranslation=
		}
		
		ArrayList getNodesForIdsInParms(){
			ArrayList r=[]
			parms.each{
				if (StringLib.isLeft(it,"ID_")){
				Proxy.Node n=NodeLib.nodeForId(it);
				if (n!=null&&n.isVisible()) r+=[n]
				}
			}
			return r
		}
		
		ArrayList getNodeIdsInParms(){
			ArrayList r=[]
			parms.each{
				if (StringLib.isLeft(it,"ID_")) r+=[it]
			}
			return r
		}
		
		String toString_nodeIds(ArrayList nodeIds){
			String r=""
			nodeIds.each{if (r=="") r=it else r+=","+ it}
			return r
		}
		
		Boolean isTranslatedStr(String translatedStr){StringLib.isLeft(translatedStr, name_translated)}
		Boolean isNodeStr(String nodeStr){StringLib.isLeft(nodeStr,name)}
		
		Action setParms_translated(ArrayList parms_translated){
			parms=parm_fromParm_translation(parms_translated)
			return this
		}
		
		String getNodeStr(){
			return name+"("+parmsStr+")"
		}
		
		String getAction_translatedStr(){
			return name_translated+":"+parms_translatedStr
		}
		
		static Action setNodeStr (String nodeStr){ //action(x,y) for different actions
			String name=Action.name_fromNodeStr(nodeStr)
			if(name==null) return null
			
			ArrayList parms=Action.parms_fromNodeStr(nodeStr,name)
			return ActionRegister.current.action(name, parms)
		}
		
		
		static Action setAction_translatedStr (String action_translatedStr){//actionTranslated:x,y  
			String name_translated=Action.nameTranslated_fromAction_translatedStr(action_translatedStr)
			if (name_translated==null) return null
			ArrayList parms_translated=Action.parmsTranslated_fromActionStr(action_translatedStr)
			return ActionRegister.current.action_translated(name_translated, parms_translated)
		}
		
		Actions execute(Actions dum){println "ERROR 'execute' not defined in subclass of Action"} // override in subclass
		
		
	
	static String name_fromNodeStr(String s){ // actionx(x;y)-->actionx
		if (s==null||s=="") return null
		ArrayList al=s.split('\\(') // note \\ to make regex escape (
		return al[0]
	}
	
	static ArrayList parms_fromNodeStr(String nodeActionStr,String name){// actionx(x,y)--> [x,y]
		String attributesStr=nodeActionStr-name-"("-")"
		return attributesStr.split(",")
	}
	
	
	static String name_fromAction_translatedStr(String translatedStr){ //actionX:x,y-->actionTranslated
		if (translatedStr==null||translatedStr=="") return null
		ArrayList al=translatedStr.split(':')
		
		return ActionRegister.current.name_forTranslated(al[0])
	}
	
	static String nameTranslated_fromAction_translatedStr(String translatedStr){ //actionX:x,y-->actionTranslated
		if (translatedStr==null||translatedStr=="") return null
		ArrayList al=translatedStr.split(':')
		
		return al[0]
	}
		
	static ArrayList parmsTranslated_fromActionStr(String actionStr){ //actionx:x,y--> [x,y]
		if (actionStr==null||actionStr=="") return null
		ArrayList al=actionStr.split(':')
		String parmsStr=al[1]
		if (parmsStr==null) return []
		else return parmsStr.split(",")
	}
	
	String getParmsStr(){ //for use in node
		String r=""
		parms.each{
			if (r=="") r=it else r+=","+it
		}
		return r
	}
	
	String getParms_translatedStr(){ //for use in node
		String r=""
		parms.each{
			if (r=="") r= parm_toParm_translation(it) else r+=","+parm_toParm_translation(it)
		}
		return r
	}
	
	static String getParmsStr_fromParms_translatedActionStr(String actionStr){
		String parmsStr=""
		if (actionStr==null||actionStr=="") return ""
		else {
			def al=actionStr.split(":")
			if (al.size()==1) return ""
			else return al[1] 
		}
	}
	
	ArrayList setParms_fromParms_translated(ArrayList parms_translated){
		ArrayList parms=[]
		parms_translated.each{parms+=[parm_fromParm_translation(it)]}
		return parms
	}
	static Boolean is(Action a){ 
		if (a==null) return false
		else return (a.name!=null)
	}
	
	//***MenuObject
	 void setMenu(EditDialog editDialog){//invoker
		 def cl=this.class
		 def menu=editDialog.actionsButton.setItem(name_translated,cl.getConstructor(ArrayList.class).newInstance([]))
		 if(menu_tooltip!=null) menu.setToolTipText(menu_tooltip)
	 }
	 
	 static ActionsField scriptActions // workaround; global for use in listene
	 void executeMenuItem(EditDialog editDialog){//invoker
		 editDialog.addScripActionStr(name_translated)
	 }
	
}

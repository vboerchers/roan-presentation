package roan
//Author Jodi D.Krol 2014-06
import java.util.ArrayList;

import org.freeplane.plugin.script.proxy.Proxy;
import scriptlib.NodeLib


class Data {
    Actions actionsOpen=null
	Actions actionsContinue=null
	Actions actionsBack=null
	String delayOpen=null
	String delayContinue=null
	String delayBack=null
	String jumpOpen=null
	String jumpContinue=null
	String jumpBack=null
	Boolean isStop=null
	Boolean isBounce=null
	Boolean getIsScenario(){return Node.isScenario(node)}
	Boolean getIsJump(){return !(jumpOpen==null&&jumpContinue==null&&jumpBack==null)} 
	
	
	enum State{
			OPEN(1),  //nr is extension audio
			CONTINUE(2),
			BACK(3);
			public final int val
			private State(int value){val = value}
		}
		
	
	ArrayList parmsTemp
	
	private Proxy.Node node
	//private Object[][]data = new Object[Data.Row.FILTER.val+1][Data.Col.back.val+1]
	History history=new History()
	Action_FilterNamed filterNamed=null
	Boolean isJumpedTo=false
	
	
	//String toString(){"Data[data=$data; of node=$node.text; history=$history]"}
	String toString(){"Data[ node=$node.text; history=$history; jumpOpen=$jumpOpen; jumpContinue=$jumpContinue;jumpBack=$jumpBack]"}
	
	
	Long formatDelay(String s){
		//long null1=null
		if (s==null||s==""||!isValidDelay(s)) return (Long) null
		else return (Long) s.toInteger()*1000 //secods to miliseconds
	}
	
	static Boolean isValidDelay(String s){
		if (s==null||s=="")return true
		else if (s.find(/^[0-9]*$/)!=null) {
		  Integer i= s.toInteger()
			if (i>=0&& i<3600) return true else return false
		}
		else return false
	}
	
	static String formatNext(String s){ //C or ID
		if (s==null||!isValidJump(s)) return null
		else return s
	}
	
	static Boolean isValidJump(String s){
		if (s==null||s=="")return true
		else if (s.find(/^ID_[0-9]*$/)!=null) return NodeLib.isAccessable(s)
		else return false
		}
	
	Boolean isSkip(Data.State col){
		return formatNext(data[Data.Row.JUMP][col.val])==valSkip
		}
	
	static Boolean formatBoolean(String s){
		if (s==null||s=="") return null
		else if(s[0].toUpperCase()=="T") return (Boolean) true
		else if(s[0].toUpperCase()=="F")return (Boolean) false
		else if(s[0]=="-") return null
		else assert(false): "ERROR data not boolean: $s" 
	}
	
	static Float formatZoom(Integer i){
		Float f=1.0
		if(i!=null&&isValidZoom(i)){
			if (i>0) f= (i/100) // ratio
		}
		return f
	}
	
	static Boolean isValidZoom(Integer i){
		//if (s==null||s=="")return true
		//else if (s.find(/^[0-9]*$/)!=null) {
		 // Integer i= s.toInteger()
			if (i>0&& i<500) return true else return false
		//} else return false
	}
	
	
	static Boolean isValidMenu(String s){true}//TEST uitwerken+ toepassen; idem filter}
	
	static Boolean isValidFilter(String s){
		//ArrayLis fl=filter
		true
		}
	
	Actions actionsFor(State col){
		if (col==State.OPEN) return actionsOpen
		else if (col==State.CONTINUE) return actionsContinue
		else return actionsBack
	}
	
	Data (Proxy.Node node){
		this.node=node
		actionsOpen=actions(State.OPEN)
		actionsContinue=actions(State.CONTINUE)
		actionsBack=actions(State.BACK)
		//get Stop and Bounce
		Actions actionsWithType=actionsBack.actionsWithClass(Action_Continuation);actionsBack-=actionsWithType //skip, wipe
		actionsWithType=actionsContinue.actionsWithClass(Action_Continuation);actionsContinue-=actionsWithType
		if (actionsWithType.isEmpty) {actionsWithType=actionsOpen.actionsWithClass(Action_Continuation);actionsOpen-=actionsWithType}
		else {def actionsWithType1=actionsOpen.actionsWithClass(Action_Continuation);actionsOpen-=actionsWithType1}
		if (actionsWithType.isEmpty){
			isStop=null
			isBounce=null
		}
		else {
			Action_Continuation c=actionsWithType.store[0]
			isStop=c.isStop
			isBounce=c.isBounce
		}
		
		//get delay
		actionsWithType=actionsOpen.actionsWithClass(Action_Delay);actionsOpen-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Delay d=actionsWithType.store[0]
			delayOpen=d.delayStr
		}
		
		actionsWithType=actionsContinue.actionsWithClass(Action_Delay);actionsContinue-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Delay d=actionsWithType.store[0]
			delayContinue=d.delayStr
		}
		
		actionsWithType=actionsBack.actionsWithClass(Action_Delay);actionsBack-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Delay d=actionsWithType.store[0]
			delayBack=d.delayStr
		}
		//get jump
		actionsWithType=actionsOpen.actionsWithClass(Action_Jump);
		actionsOpen-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Jump d=actionsWithType.store[0]
			jumpOpen=d.nodeId
		}
		
		actionsWithType=actionsContinue.actionsWithClass(Action_Jump);actionsContinue-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Jump d=actionsWithType.store[0]
			jumpContinue=d.nodeId
		}
		
		actionsWithType=actionsBack.actionsWithClass(Action_Jump);actionsBack-=actionsWithType
		if (!actionsWithType.isEmpty){
			Action_Jump d=actionsWithType.store[0]
			jumpBack=d.nodeId
		}
		if (jumpContinue==null) jumpContinue=jumpOpen //USE continue only
		
		
		//if (Controller.debug)println "DEBUG Data $this" 
	}
	
		String jump(Data.State col){
			//return formatNext(data[Data.Row.JUMP.val][col.val])
			if(col==Data.State.OPEN) return formatNext(jumpOpen)
			else if(col==Data.State.CONTINUE) return formatNext(jumpContinue)
			else if(col==Data.State.BACK) return formatNext(jumpBack)
		}
		
		Integer delay(Data.State col){
			if (col==State.OPEN) return formatDelay(delayOpen)
			else if (col==State.CONTINUE) return formatDelay(delayContinue)
			else if (col==State.BACK) return formatDelay(delayBack)
		}
		
		ArrayList filter(Data.State col){  
			ArrayList rl=[]
			ArrayList al=node.attributes.findValues{key,val-> key == Node.Attr.FILTER.val} // all values for filter
			//println "TEST filter from node al= $al"
			al.each{
				ArrayList f=it.split (",")
				//"TEST filter from node f= $f"
				if(f.size()>col.val-1) {
					String element=f[col.val-1]
					if (element!=null&&element !="") rl+=element
				}
			}
			//println "TEST filter from node rl= $rl"
			return rl
		}
		
		Actions actions(Data.State col){
			return Node.getActions(node,col)
		}
}
	
	
	
		
		


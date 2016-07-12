package roan
class EventStr {
	Boolean valid
	String 	action
	String 	valueStr
	Integer postDelay=0
	
	String toString(){ return
		"EventStr[valid=$valid,action,$action,valueStr=$valueStr,postDelay=$postDelay"
	}
	EventStr(String eventStr, String possibleAction){ // ACTION:valueStr,postDelay
	   valid= eventStr.find(/^(\w+):(.*),(\d+)$/){
		   full,action,valueStr,postDelay->
				   this.action=action;
				this.valueStr=valueStr;
				this.postDelay=postDelay.toInteger()}
	   if (valid) valid= (action==possibleAction)
	   }
	
	EventStr(String eventStr, Closure isPossibleAction){ // ACTION:valueStr,postDelay
		valid= eventStr.find(/^(\w+):(.*),(\d+)$/){
			full,action,valueStr,postDelay->
				 this.action=action;
				 this.valueStr=valueStr;
				 this.postDelay=postDelay.toInteger() //ms
				 }
		if (valid) valid= (isPossibleAction(this))
		}
}



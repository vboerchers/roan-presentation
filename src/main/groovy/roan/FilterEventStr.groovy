package roan

import groovy.lang.Closure;

class FilterEventStr {
		Boolean valid
		String 	action
		String 	valueStr
		
		String toString(){ return
			"EventStr[valid=$valid,action,$action,valueStr=$valueStr"
		}
		FilterEventStr(String eventStr){ 
		   valid= eventStr.find(/^filter:(.*),(\d+)$/){
			   full,action,valueStr,postDelay->
					   this.action=action;
					this.valueStr=valueStr;
					}
		   if (valid) valid= (action==possibleAction)
		   }
		
		
	}
	
	

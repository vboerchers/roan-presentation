package roan
//Author Jodi D. Krol 2013

class EventStr_Page extends EventStr{
		enum Mode {STYLE,ID}
		//Mode mode
		//String addToPage=[]
		Boolean isAddToPreviousPage=false
		Boolean inRoot=false
		
		EventStr_Page(String eventStr, String possibleAction){
			super(eventStr,possibleAction)
	}
}


package roan
//Author Jodi D.Krol 201408

class Actions {
	
	Actions(){}
	
	ArrayList store=[]
	
	String toString(){
		String r=""
		if (store==null||store==[]) return "Actions[]"
		else {
		   store.each{r+=","+it.toString()}
		   r-=","
		   return "Actions["+r+"]"
		}
	}
	
	String getActionsStr(){
		String r=""
		if (store==null||store==[]) return ""
		else {
		   store.each{Action a=it; if (r=="")  r=a.nodeStr else r+=","+a.nodeStr}
		   return r
		}
	}
	
	Actions minus(Actions min){
		store-=min.store
		return this
	}
	
	Boolean getIsEmpty(){return store==[]}
	
	Actions executeAll(Data data, Data.State col){
		
		Actions done=new Actions()
		store.each{
			Action a=it;  
			a.execute(data,col); 
			done.store+=[it];
			 }
		return done
	}
	
	void executePost(Data data, Data.State col){
		store.each{ 
			Action a=it;  a.execute(data,col)
			 }
	}
	
	void executePre(Data data, Data.State col){
		roan.Controller.current.skipCenter=false
		store.each{
			Action a=it
			if(a.name==Action_Filtering.key||
			   a.name==Action_Zooming.key){	a.execute(data,col); store-=[a]	}
		}
	}
	
	
	Actions addNodeStrs(ArrayList nodeActionStrs){ //list of nodeActionStr
		if (nodeActionStrs==null) return this
		else {
			nodeActionStrs.each{
				Action a=Action.setNodeStr(it)
				if (a!=null) 	store+=[a]
			}
		return this
		}
	}
	
	Actions remove(Action action){ store-=[action]}
	
	Actions actionsWithClass(Class type){
		Actions r= new Actions()
		store.each{ if (it.class==type) r.store+=[it]}
		return r
	}
	
	Boolean isAction(Class type){
		def r=actionsWithClass(type)
		return r.isEmpty==false
	}
}


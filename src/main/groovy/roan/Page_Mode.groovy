package roan

//Author Jodi D. Krol 2013-02
class Page_Mode {
	String  node_id=null,
			center_id=null,
			inRoot_id=null
	Boolean fold=null
	Integer depth=null
	ArrayList toFold=[]
	Page_Mode(){}
	
	String toString(){
		return "Page_Mode["+
			   "node_id=$node_id,"+
			   "center_id=$center_id,"+
			   "inRoot_id=$inRoot_id,"+
			   "fold=$fold,"+
			   "depth=$depth"+
			   "toFold=$toFold"
			   "]"
		}
	
	void read(Page_Mode pm){
		if (pm.node_id!=null) this.node_id=pm.node_id
		if (pm.center_id!=null) this.center_id=pm.center_id
		if (pm.inRoot_id!=null) this.inRoot_id=pm.inRoot_id
		if (pm.fold!=null) this.fold=pm.fold
		if (pm.depth!=null) this.depth=pm.depth
	}
}


package roan
//Author Jodi D.Krol 2014-06
class History {
private ArrayList list=[]

String toString(){String s=list.size().toString(); return "History[size=$s]"}
Data getPrevious(){
	Integer le=list.size()
	if (le==0) return null
	else {
		return list[le-1]
		list-=list[le-1]
	}
}
 void add(Data data){list+=data}

}

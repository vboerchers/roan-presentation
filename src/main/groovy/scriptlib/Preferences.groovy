package scriptlib
//Author Jod D.Krol 2013-08
import org.freeplane.plugin.script.FreeplaneScriptBaseClass.ConfigProperties

class Preferences {
	
	//static debug=true
	
	static Boolean getBooleanProp(String name, Boolean ifNull){
		String exist=new ConfigProperties().getProperty(name)
		if (exist==null)  { if (true/*Controller.currentController.logfile*/) println "ERROR: missing preference $name"; return ifNull}
		else return exist=="true"
	}
	
	static Integer getIntegerProp(String name, Integer ifNull){
		//def r=new ConfigProperties().getProperty(name)
		//if (r!=null&&r!="")
		//	return new ConfigProperties().getIntProperty(name)
		//else{ println "ERROR: missing preference $name"; return ifNull}
		//workaround because attributes in FP1.2 cannot be integers
		def r= new ConfigProperties().getProperty(name, "NOTPROPERTY")
		if (r=="NOTPROPERTY") {if (true/*Controller.currentController.logfile*/) println "ERROR: missing preference $name"; return ifNull}
		else {
		
			if (r!=""&&r[0]=='"') r= r-'"'
            return r.toInteger()
			} // remove " before number, to prevent automatic make up defaults
	}
	
	static String getStringProp(String name, String ifNull){
		def r= new ConfigProperties().getProperty(name, "NOTPROPERTY")
		if (r=="NOTPROPERTY") {if (true/*Controller.currentController.logfile*/) println "ERROR: missing preference $name"; return ifNull}
		else {
			if (r!=""&&r[0]=='"') return r-'"' else return r} // remove " before number, to prevent automatic make up defaults
	}
}

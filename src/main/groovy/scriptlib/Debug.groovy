package scriptlib
//Author Jodi D.Krol 2013-06
class Debug {
	
//static final Debug current=new Debug()


static Boolean debug=false//_private=false

static void log(String s){println s}

//$Preferences for scriptlib only; use setDebug
//static Boolean logFile=Preferences.getBooleanProp(
//	"addons.scriptlib.debug.logfile",false
//	)

//void setDebug(Boolean b){debug_private=b}

//static Boolean getDebug(){return debug_private}//||logFile}
}

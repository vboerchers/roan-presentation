package roan
import scriptlib.FileLib
import scriptlib.Message
import org.freeplane.core.resources.ResourceController

class UserDirFiles {
	
	static String remove1=Message.textUtils.getText(
		"addons.roan.userdirfiles.remove1",
		"1. Remove files if not for language " 
		)
	
	static String remove2=Message.textUtils.getText(
		"addons.roan.userdirfiles.remove2",
		"2. Remove log files ?"
		)
	
	static String remove3=Message.textUtils.getText(
		"addons.roan.userdirfiles.remove3",
		"3. Remove backup files ?"
		)
	static String restart=Message.textUtils.getText(
		"addons.roan.userdirfiles.restart",
		"You may have to restart Freeplane."
		)
	
	void clean(){
		String lc=languageCode
		
		if (Message.confirm("$remove1 $lc?" )){
	
			if (lc=="nl"){
			     FileLib.deleteUserDirOrFile("/doc/roan-presentation_help/roan-presentation_help.mm")
				 FileLib.deleteUserDirOrFile("/doc/freeplane/freeplaneTutorial.mm")
			}
			else{
				FileLib.deleteUserDirOrFile("/doc/roan-presentation_help/roan-presentation_help_nl.mm")
				FileLib.deleteUserDirOrFile("/doc/freeplane/freeplaneTutorial_nl.mm")
			}
		}
		if (Message.confirm(remove2)){
			File directory = new File(FileLib.path_userdir("/logs"));
			ArrayList fList = directory.listFiles()
			long lastModified=0
			fList.each{if (it.lastModified()>lastModified) {lastModified=it.lastModified()}}//keep last
			if (lastModified!=0) fList.each{if (it.lastModified()<lastModified) it.delete()}
		}
		if (Message.confirm(remove3)){
			File directoryB = new File(FileLib.path_userdir("/.backup"));
			ArrayList fListB = directoryB.listFiles()
			fListB.each{ it.delete()}
		}
		//Message.plainMessage(restart)
	}

	
	
static	String getLanguageCode(){
		ResourceController resourceController = ResourceController.resourceController
		String dir=resourceController.freeplaneUserDirectory
		String languageCode = resourceController.languageCode
		return languageCode
	}
}

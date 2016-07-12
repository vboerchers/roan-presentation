// In preferences/plugins add ;lib to classpath and set execute files

import java.io.*
import javax.swing.JOptionPane;
import org.freeplane.core.ui.components.UITools
import org.freeplane.core.resources.ResourceController
import org.freeplane.plugin.script.ScriptingPermissions

setLibAndFileAction()
new Message().plainMessage("Restart Freeplane to finish activation of lib")
	
String getProp(String key){
		final ResourceController resourceController = ResourceController.getResourceController();
		return resourceController.getProperty(key);
}

void setProp(String key, String val){
		final ResourceController resourceController = ResourceController.getResourceController();
		resourceController.setProperty(key,val);
}



	void setLibAndFileAction(){
		
/*
		println getProp("execute_scripts_without_file_restriction")
               setProp("execute_scripts_without_file_restriction","true")
*/


		String classPath= getProp("script_classpath")
		if (classPath==null||classPath=="") classPath=";lib"
		else if (!classPath.find(";lib")) classPath+=";lib"
		setProp("script_classpath", classPath)	
								
	}

class Message{ //subset
		
		public static void plainMessage(String message){
		  def x=JOptionPane.showMessageDialog(UITools.frame,
			message,
			"Information",
			JOptionPane.PLAIN_MESSAGE);
		  }
	}


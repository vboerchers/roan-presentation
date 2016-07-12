package scriptlib

import java.io.*
import javax.swing.JOptionPane;
import org.freeplane.core.ui.components.UITools


import org.freeplane.core.resources.ResourceController;
class Auto {
	static String autoFile=FileLib.pathname_userdir("/auto.properties")
	Boolean classPath=false
	Boolean writeRestriction=false
	
	static void setLibAndFileAction(){//preferences
		def store=auto
		def autoNew=[]
		Boolean classPath=false
		Boolean writeRestriction=false
		store.each{
			if (it.find("script_classpath=")) {
		
				if (it.find(";lib")){
					classPath=true 
					autoNew+=[it]
					}
				else {
					autoNew+=[it+";lib"]
					 println "TEST storelib=$store"
					 }
			}
			else if(it.find("execute_scripts_without_file_restriction=true")){
				 writeRestriction=true
				 autoNew+=[it]
			}	
			else autoNew+=[it]
		}
		
		if(!writeRestriction)autoNew+=["execute_scripts_without_file_restriction=true"]
		if (!writeRestriction||!classPath) { 
			println "WARNING: write auto file";
			println "TEST auto=$autoNew" 
			setAuto(autoNew)
			Message.plainMessage("Restart Freeplane to finish activation of lib")
			} else println "TEST auto ok"
	}
	
	static ArrayList getAuto(){
	ArrayList store=[]
		try{
			FileInputStream fstream = new FileInputStream(autoFile)
			DataInputStream inS = new DataInputStream(fstream)
			BufferedReader br = new BufferedReader(new InputStreamReader(inS))
			String strLine
			while ((strLine = br.readLine()) != null)   {
				store+=strLine
				//println strLine
				}
			
				inS.close();
				  }catch (Exception e){//Catch exception if any
				System.err.println("Error: " + e.getMessage());
				}
				  return store
	}
	
	static ArrayList setAuto(ArrayList store){
		if (store==null||store==""){println "TEST ERROR no auto file"}
		else{
			try{
			FileWriter fstream = new FileWriter(autoFile);
			BufferedWriter outW = new BufferedWriter(fstream);
			store.each{	outW.write(it)}
			outW.close();
			}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			}
		}
	}
	
	static class FileLib{ //subset
		static final ResourceController resourceController = ResourceController.resourceController
		static final String dir=resourceController.freeplaneUserDirectory
		static String pathname_userdir(String restPathname){
			path_userdir(restPathname)
		}
		static String path_userdir(String restPath){
			def p=""; 	(dir+restPath).each{if (it=="/") p+=File.separator else p+=it}
			//return dir+File.separator+ restPath.replaceAll("/", File.separator)} gives error
			return p
		}
	}
	
	static class Message{ //subset
		
		public static void plainMessage(String message){
		  def x=JOptionPane.showMessageDialog(UITools.frame,
			message,
			"Information",
			JOptionPane.PLAIN_MESSAGE);
		  }
	}
}

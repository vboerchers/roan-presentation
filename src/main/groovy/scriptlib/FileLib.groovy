package scriptlib
//Author Jodi D.Krol 2014
import java.io.File
import javax.swing.SwingUtilities;
import java.net.URL
import org.freeplane.features.map.MapModel
import org.freeplane.features.mode.Controller
import org.freeplane.features.url.UrlManager
import org.freeplane.core.resources.ResourceController
import java.awt.Desktop
import static java.nio.file.StandardCopyOption.*
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import org.freeplane.core.util.FileUtils

//SEE ALSO MapLib and MapResources

class FileLib { //Use forwardslash only; depending on system - automatic conversion to backslash
	static def textUtils= new org.freeplane.core.util.TextUtils()
	//$TRANSALATE
	static final String libName=textUtils.getText(
		"addon.{name}",
		"generalResoures")
	
	static final String CREATE_MISSING_FOLDER=textUtils.getText(
		"addons.scriptlib.filelib.createMissingFolder",
		"Create missing folder ?")
	
	static final String MISSING_APPLICATION=textUtils.getText(
		"addons.scriptlib.filelib.warningMissingApplication",
	    "WARNING: missing application for this file type: ")

	static final String urlPrefix="file:///"
	static final ResourceController resourceController = ResourceController.resourceController
	static final String dir=resourceController.freeplaneUserDirectory
//	static final String languageCode = resourceController.languageCode
	
	static void copyFile(String source, String target){
		Files.copy(Paths.get(source), Paths.get(target), REPLACE_EXISTING)
	}
	
static final String extension(final String s){ FileUtils.getExtension(s)}

static String separator=File.separator

static final String dotExtension(final String filename){
	String e=extension(filename)
	if (e=="")return "" else return "."+e
}

	static String getPath_userdir(){return dir}
	
	static String path_userdir(String restPath){ 
		def p=""; 	(dir+restPath).each{if (it=="/") p+=File.separator else p+=it}
		//return dir+File.separator+ restPath.replaceAll("/", File.separator)} gives error
	    return p
	}
	
	 //static String getPath(String s){def p=""; 	s.each{if (it=="/") p+=File.separator else p+=it}; return p}
	
	 static String path_currentdir(String currentDir, String restPath){
		def p=""; 	(currentDir+restPath).each{if (it=="/") p+=File.separator else p+=it}
		//return dir+File.separator+ restPath.replaceAll("/", File.separator)} gives error
		return p
	}
	
	static String pathname_userdir(String restPathname){
		path_userdir(restPathname)
	}
	
	
	static Boolean exists(String path){new File(path).isFile()} //local
		
	static URL url(String path){(urlPrefix+path).toURL()}
	
	//""""""""""""""""""
	// Open general folder, file
	// Opens any file type - if a connection between type and program is known by the operation system.
	// In windows:  gives unclear system error if a connection between type and application is missing. 
	static Boolean open_file(String pathname){
		Boolean r=true
		if (Desktop.isDesktopSupported()){
			if (exists(pathname)){
				try {
				new Desktop().open(new File(pathname))
				}
				catch (IOException e) {
					r=false
					Message.warning( MISSING_APPLICATION+ pathname)
					 }
			} else r=false
		} else{
			println "WARNING: java Desktop not supported"
			r= false
		}
		return r
	}
	
	static Boolean open_folder (String path){
		Boolean r=true
		if (!exists(path)&&Message.confirm(CREATE_MISSING_FOLDER)) new File(path).mkdirs()
		if(exists(path)){
		try {
			//new Desktop.open()(path);
			Runtime.getRuntime().exec("explorer "+ path)
			} catch (IOException e) {
			r=false
			}
			return r
		} else return false
}
	//""""""""""""""""""
	// Open map-resource
	static Boolean open_mapRecource(){
		open_folder(MapResources.pathDirectory)
	}
	Boolean open_fileMapResource(String name){
		String pathname=MapResources.pathDirectory+File.separator+name
		return open_file(pathname)
	}
	
	//

	//""""""""""""""""""
	// hyperlinks URL
	public static boolean urlExists(String URLName){
		try {
		  HttpURLConnection.setFollowRedirects(false);
		  // note : you may also need
		  //        HttpURLConnection.setInstanceFollowRedirects(false)
		  HttpURLConnection con =
			 (HttpURLConnection) new URL(URLName).openConnection();
		  con.setRequestMethod("HEAD");
		  return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		}
		catch (Exception e) {
		   e.printStackTrace();
		   return false;
		}
	  }
	
	
	static def resourcepathToUrl(String path){
		def url = ResourceController.getResourceController().getResource(path) //e.g. Freeplane icons
		assert (url != null): "WARNING: Couldn't find file= $path in freeplaneuserdir/resources"
		return url
	}
	static def preferredFrom_resourcepathToUrl(String preferredPath, String defaultPath){
		def url = ResourceController.getResourceController().getResource(preferredPath) //e.g. Freeplane icons
		//assert(url!=null): "nietgevonden $preferredPath"
		if (url!=null) return preferredPath
		else{
			url = ResourceController.getResourceController().getResource(defaultPath)
			
		    if (url!=null) return defaultPath
			else assert (false): "WARNING: Couldn't find file= $preferredPath or $defaultPath in freeplaneuserdir/resources"
		}
	}
	
	
	static String getPath_mapDirectory(){
		MapModel map=  Controller.currentController.map
		if ((map != null) && (map.getFile() != null) && (map.getFile().getParentFile() != null)) {
			String fs= map.getFile();
			String fps=map.getFile().getParentFile()
	}}
	
	private static void delete(String fileOrDir){
	File f1 = new File(fileOrDir);
	boolean success = f1.delete();
	if (!success){
		println("File deletion failed: $fileOrDir");
		System.exit(0);
	}else{
		println("File deleted: $fileOrDir");
	  }
	}
	
	static void deleteUserDirOrFile(String fileOrDir){
		FileLib.delete(FileLib.path_userdir(fileOrDir))
	}
	
	Boolean isUriStr(String s){ return toUri(s)!=null}
	
	static URI toUri(String s){ //for testing only
		URI u=null
		try {u=new URI(s)}
		catch (URISyntaxException e) {println "TEST temp error no URIstr on entry: $s"}
		
		// TEST temp following for test only
		if (u==null){
			try {u=new URI(StringLib.toRegexStr(s))}
			catch (URISyntaxException e) {"TEST temp error no URIstr after trying to fix with toRegex"}
		}
		return u
	}
	
}
	
/*	
 // niet gebruikt
	String getPath_libResource(){ 
		return path_userdir+File.separator+libName
	}
	
	
	static String getPath_resourceDirectory(){
		 MapModel map=  Controller.currentController.map
		 if ((map != null) && (map.getFile() != null) && (map.getFile().getParentFile() != null)) {
			 String fs= map.getFile();
			 String fps=map.getFile().getParentFile()
			 String f=fs-fps
			 f-="\\"
			 f-=".mm"
			 return fps+"\\_"+ f  //e.g. MyDir\MyMap.mm becomes MyDir\_MyMap
		 }
		 else return null;
	 }
	 

	 static ArrayList<String> getSiblingNames_currentMap(){
		 File parentFile =  Controller.currentController.map.getFile().getParentFile()
		 // File f = new File("C:\\");
	 	ArrayList<String> names = new ArrayList<String>(Arrays.asList(parentFile.list()));
	 }
 
	
	
	 String pathname_map_lc(String path){
		 path-=".mm"
		 return path+"_"+languageCode+".mm"
	 }
	 
	
	 Boolean open_map(String pathname){
		 String p=pathname_map_lc(pathname)
		 if (!exists(p)) p=pathname
		 if (exists(p)){
			 Controller.currentModeController.mapController.newDocumentationMap(url(p))
			 return true
		 }
		 else return false
	 }
	 
	 Boolean open_mapOnline(String pathname){
		 String p=pathname_map_lc(pathname)
		 if (!urlExists(p)) p=pathname
		 if (urlExists(p)){
			 URL url=p.toURL()
			 Controller.currentModeController.mapController.newDocumentationMap(url)
			 return true
		 }
		 else return false
	 }
	 */
	 

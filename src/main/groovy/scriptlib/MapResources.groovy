package scriptlib
//Author Jodi D.Krol 2014-04
import org.freeplane.features.map.MapModel
import org.freeplane.features.mode.Controller

//To store files related to map in same directory as map ,e.g. in case MyDir\MyMap.mm: MyDir\_MyMap
class MapResources {
	MapResources(){}
	static String getPathDirectory(){
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
	
	static String getPathDirectoryMapRaw(){
		MapModel map=  Controller.currentController.map
		if ((map != null) && (map.getFile() != null) && (map.getFile().getParentFile() != null)) {
			String fs= map.getFile();
			String fps=map.getFile().getParentFile()
			String f=fs-fps
			f-="\\"
			f-=".mm"
			return (fps+"\\"+f) //.replaceAll(/ /, /%20/)  //e.g. MyDir\MyMap.mm becomes MyDir\_MyMap
		}
		else return null;
	}
	
	
	static Boolean open(){
		FileLib.open_folder(MapResources.pathDirectory)
	}
	Boolean open(String name){
		String pathname=MapResources.pathDirectory+File.separator+name
		return FileLib.open_file(pathname)
	}
}

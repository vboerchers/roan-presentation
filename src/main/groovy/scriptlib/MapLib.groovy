package scriptlib
//Author Jodi D.Krol 2014-04
import javax.swing.SwingUtilities

import org.freeplane.core.resources.ResourceController
import org.freeplane.features.map.MapModel
import org.freeplane.features.mode.Controller
import org.freeplane.plugin.script.proxy.Proxy
import org.freeplane.view.swing.map.NodeView
import org.freeplane.view.swing.map.MapScroller
import org.freeplane.view.swing.map.MapView
import org.freeplane.view.swing.map.ScrollingDirective

class MapLib {
	
	
	
	MapLib(){}
	static final ResourceController resourceController = ResourceController.resourceController
	static final String languageCode = resourceController.languageCode
	
	static String pathname_map_lc(String path){
		path-=".mm"
		return path+"_"+languageCode+".mm"
	}
	
	static Boolean open_map(String pathname){
		String p=pathname_map_lc(pathname)
		if (!FileLib.exists(p)) p=pathname
		if (FileLib.exists(p)){
			Controller.currentModeController.mapController.newDocumentationMap(FileLib.url(p))
			return true
		}
		else return false
	}
	
	static Boolean open_mapOnline(String pathname){
		String p=pathname_map_lc(pathname)
		if (!FileLib.urlExists(p)) p=pathname
		if (FileLib.urlExists(p)){
			URL url=p.toURL()
			Controller.currentModeController.mapController.newDocumentationMap(url)
			return true
		}
		else return false
	}
	
	static String getPath_templates(){
		return FileLib.path_userdir+File.separator+"templates"
	}
	
	
	static float getZoom() {
		return Controller.currentController.getViewController().getZoom();
	}
	
	static void invoke_setZoom(Float ratio) {
		if (ratio!=null){
			float f=ratio.floatValue()
		
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					//Controller.currentController.getViewController().setZoom(z)
					Globals.current.c.setZoom(f)
				}})
		}
	}
	
	static class Slow{
		static Integer max=20
		static ArrayList step=[]
		Slow(){ 
			step[0]=1
			(1..max).each{step[it]=2*step[it-1]}
		}
	}
	
	static Slow slow=new Slow()
	
	static void invoke_setZoom(Float ratio, Boolean slow) {
		if (slow) invoke_setZoom_slow(ratio)
		else{
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					Globals.current.c.setZoom(ratio.floatValue())
			}})
		}
	}
	
	static void invoke_setZoom_slow(Float ratio) {
		
		if (ratio!=null){
			float newZoom=ratio.floatValue()
			//final ViewController viewController = Globals.current.c.getViewController();
			final float currentZoom = Globals.current.c.getZoom()//viewController.getZoom();
			float delta=(newZoom-currentZoom)
			if (delta!=0){
				(3..slow.max).each{ 
					SwingUtilities.invokeAndWait(new Runnable(){
						public void run(){
							float tempZoom=(float) delta*slow.step[it]/slow.step[slow.max]+currentZoom
							Globals.current.c.setZoom(tempZoom)
							//println "test $tempZoom"
						}})
				Thread.sleep(10+(slow.max-it))
				}
			}	
		}
	}
	
	static void setZoom(Float ratio) {
		if (ratio!=null){
			float f=ratio.floatValue()
		  // SwingUtilities.invokeAndWait(new Runnable(){
			//	public void run(){
					//Controller.currentController.getViewController().setZoom(f)
					Globals.current.c.setZoom(f)
			//	}})
		}
	}
	
	static void invoke_centerNode(Proxy.Node proxyNode, Boolean slow){
		//Thread.sleep(1000)//workaround
		//println "TEST invoke_center $proxyNode.text"
		
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run() {
				centerNode(proxyNode, slow)
			}
		})
	}
	
	static void centerNode(Proxy.Node proxyNode, Boolean slow){
		//TEST@@Thread.sleep(50)//workaround
		def mapView = Controller.currentController.mapViewManager.mapView
		final NodeView nodeView= mapView.getNodeView(proxyNode.delegate)
		if (nodeView==null) {
			println "ERROR centerNode nodeView=null, skip center"
		}
		else {
			def mapScroller = new MapScroller(mapView)
			// otherwise we hit a NPE
			mapScroller.setAnchorView(nodeView)		
			mapScroller.scrollNode(nodeView, ScrollingDirective.SCROLL_NODE_TO_CENTER, slow)
		}
	}
	//****
	
	
	//NIET GEBRUIKT ******
	// niet gebruikt
	static ArrayList<String> getSiblingNames_currentMap(){
		File parentFile =  Controller.currentController.map.getFile().getParentFile()
		// File f = new File("C:\\");
		ArrayList<String> names = new ArrayList<String>(Arrays.asList(parentFile.list()));
	}
	
	static File getDir_currentMap(){
		MapModel map=  Controller.currentController.map
		return map.file.parentFile
		 }
	
	// niet gebruikt ??
	static String getPathname_currentMap(){
		return (String) file_currentMap
	}
	// niet gebruikt
	static String getPath_currentMap(){
		return (String) file_currentMap.parentFile
	}
	// niet gebruikt
	static File getFile_currentMap(){
	   MapModel map=  Controller.currentController.map
	   return map.file
		}
	
	static Boolean getIsNewMap(){
		return NodeLib.root.children==[]
	}
	
	static enum Division{RIGHT,RIGHTLEFT, LEFTRIGHT, MAPFILE, FILEMAP}
	
	static final String icon_folder="folder"
	static void divideRoot(Division d){
		if (d==Division.RIGHT){}
		else if (d==Division.RIGHTLEFT||d==Division.LEFTRIGHT){
			Boolean b
			if(d==Division.RIGHTLEFT) b= true else b=false
			ArrayList children=NodeLib.root.children
			if (children!=[]){
				Integer half
				Integer i=0
				half=children.size()/2
				children.each{
					if(i>=half&&b) it.left=true
					else if (i<half&&!b) it.left=true
					i+=1
				}
			}
		} 
		else{
			Boolean b
			if(d==Division.MAPFILE) b= true else b=false
			ArrayList children=NodeLib.root.children
			if (children!=[]){
			
				children.each{
					if( it.icons.contains(icon_folder)) it.left=b
					else  it.left=!b
				}
			}
			
		}
	} 
}

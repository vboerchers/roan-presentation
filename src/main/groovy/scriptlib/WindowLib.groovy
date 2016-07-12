package scriptlib
//Jodi Krol 2012
import java.awt.*
//import java.beans.StaticFieldsPersistenceDelegate;
import org.freeplane.core.ui.components.UITools
import org.freeplane.features.map.NodeModel;
import org.freeplane.features.mode.Controller
import org.freeplane.plugin.script.proxy.Proxy;
import org.freeplane.view.swing.map.MainView
import org.freeplane.view.swing.map.MapView
import org.freeplane.view.swing.map.NodeView
import javax.swing.*
import java.awt.event.MouseEvent
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.MouseInfo
 
class WindowLib {
	//static AWindowTools current=ControllerRoan.current.windowTools//new AWindowTools()
   
	WindowLib(){}//ADebug.log("DEBUG new AWindowTools")} //CONSTRUCTOR
			
	   static JFrame    		mainFrame = UITools.getFrame()   //main frame of Freeplane
		Integer 		HDTV_WIDTH=1280,
		                HDTV_HEIGHT=720
	   	Integer 		windowX=5, 
		   				windowY=5 
		Integer			windowWidth=HDTV_WIDTH, 
						windowHeight=HDTV_HEIGHT  // default fixed size
		Point			point_ScreenLeftTop	=new Point()						                                                                          // set definitive in Animator !
	
		
		void setFocusToFreeplane(){
			assert requestFocus(mainFrame): "WARNING mainFrame is not getting focus"
			}
		
		 //return true if the component has focus or probably will get focus
		 // http://www.java2s.com/Code/Java/Swing-JFC/Requestsfocusunlessthecomponentalreadyhasfocus.htm
		boolean requestFocus(Component component) {
		  return KeyboardFocusManager.getCurrentKeyboardFocusManager().getFocusOwner() == component ||
				 component.requestFocusInWindow();
			}
	  
		Boolean containsPoint(Point pt){
			 return mainFrame.contains(pt)
			}
		Boolean containsPoint(MouseEvent me){
			 return containsPoint(me, mainFrame)
			}
		
		Boolean containsPoint( MouseEvent me, Component c){
			MouseEvent converted = SwingUtilities.convertMouseEvent(me.getComponent(), me, c)
			Point pt = converted.getPoint();
			return c.contains(pt)
		}
		 
		
		void setFixedSize(){ // defaut values
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize()
			assert (screenSize.width > (windowWidth - windowX)) : 
				"Setting of x=$windowX or width=$windowWidth of freeplane window beyond screen width=$screenSize.width"
			assert (screenSize.height > (windowHeight - windowY)): "Setting of y=$windowY or height=$windowHeight of freeplane window beyond screen height=$screenSize.height"

			def f=UITools.getFrame()
		   f.setBounds(windowX,windowY,windowWidth, windowHeight)
		   f.setResizable(false)
			}
		
		void setSize(Integer width,Integer height){
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize()
			assert (screenSize.width > (width - windowX)) : "Setting of x=$windowX or width=$width of freeplane window beyond screen width=$screenSize.width"
			assert (screenSize.height > (height - windowY)): "Setting of y=$windowY or height=$height of freeplane window beyond screen height=$screenSize.height"
		   //mainFrame.setBounds(windowX,windowY,width, height)
		  // mainFrame.setResizable(false)
			def f=UITools.getFrame()
			f.setBounds(windowX,windowY,width, height)
			//f.setResizable(false)
			}
		
		static Dimension getScreenSize(){Toolkit.getDefaultToolkit().getScreenSize()}
		
	void setFixedSize(Integer width, Integer height){
		setSize(width,height)
		def f=UITools.getFrame()
		f.setResizable(false)
	}	
	   void finishFixedWindow(){
			mainFrame.setResizable(true)
			}
	    	
	  static Point point_RootNodeCenter(){  point_NodeCenter(NodeLib.root)  }
	   
		static Point point_NodeCenter(Proxy.Node node){// in screencoordinates for ControllerRoan.current.robot.move x,y
			assert(node.isVisible()): "ERROR: not visible $node"
			point_NodeCenter(node.delegate)
			} 
		
		// TO BE REVISED
		static void invoke_scrollToVisible(Proxy.Node node){
		    SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				WindowLib.scrollToVisible(node)
				}})
		}
		
	static void scrollToVisible(Proxy.Node node){
		//def controller = roan.Controller.current.c//Controller.getCurrentController()
		def controller = Controller.getCurrentController()
		final NodeView nodeView= Controller.currentController.mapViewManager.mapView.getNodeView(node.delegate)
		controller.getMapViewManager().getMapViewComponent().scrollNodeToVisible(nodeView)
	}	
	
	
	
	// werkt niet FP 1.3, aanpassen als hierboven scrollToVisible
	Point point_NodeCenter(NodeModel node){// in screencoordinates for ControllerRoan.current.robot.move x,y
		if (node==null) Debug.log(" node null in point_NodeCenter(NodeModel node)")
		else{
			Point pointOnMap
			def controller = Controller.getCurrentController()
			def mainView = (MainView) controller.getViewController().getComponent(node)
			if (mainView==null) {
				Debug.log("delay 200 to allow possible node unfolding = $node")
				  RobotLib.delay(200);
				mainView = (MainView) controller.getViewController().getComponent(node)
				}
			
			
			if (mainView==null) {
				Debug.log("delay extra 800 to allow possible node unfolding")
				  RobotLib.delay(800);mainView = (MainView) controller.getViewController().getComponent(node)
				}
			
			assert (mainView!=null):"WARNING node folded/not visible"// at step $ControllerRoan.current.recorder.scene.stepNr: $node"

				def nodeView = (NodeView) SwingUtilities.getAncestorOfClass(NodeView.class, mainView )
				controller.getMapViewManager().getMapViewComponent().scrollNodeToVisible(nodeView) // make sure
				
				def content=nodeView.getContent()
				def rectangle =new Rectangle()
				content.getBounds(rectangle)
			   
				pointOnMap= mainView.getLocationOnScreen()
				
				pointOnMap.x +=rectangle.width/2
				pointOnMap.y +=rectangle.height/2
			
			return pointOnMap  // point on screen !!
			}
		}
		
	static Point getScroll_Point(org.freeplane.plugin.script.proxy.Proxy.Controller controller){
		def vp= controller.getViewController().getViewport()
		return vp.getViewPosition()
	}
	static void setScroll_Point(org.freeplane.plugin.script.proxy.Proxy.Controller controller,Point p){
	def vp= controller.getViewController().getViewport()
	if (vp==null||p==null) println "ERROR set scroll $p"
	else vp.slowSetViewPosition(p)
	//else vp.setViewPosition(p)
	mainFrame.repaint()
	}
}

package roan
//Author Jodi D.Krol 2014-06
import java.awt.Frame
import scriptlib.WindowLib
import scriptlib.Auto

import org.freeplane.core.ui.components.UITools
import groovy.lang.Closure;
import java.awt.event.ActionListener;
import javax.swing.*
import java.awt.Container
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent

import javax.swing.BoxLayout
import javax.swing.ImageIcon;
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.JWindow
import scriptlib.APanelWithGradient
import scriptlib.AThread
import javax.swing.BorderFactory
import javax.swing.event.ChangeEvent
import java.awt.BorderLayout
import javax.swing.event.ChangeListener

import org.freeplane.core.resources.ResourceController;
import org.freeplane.plugin.script.proxy.Proxy;

import scriptlib.AButton
import scriptlib.AIcon
import scriptlib.NodeLib
import scriptlib.FileLib
import scriptlib.MenuFreeplane


class Menu extends JPanel{// implements ActionListener {
	static Menu current 
	JPanel top=new JPanel()
	private int Y = 0;
	private int X = 0;

	AButton playButton
	AButton stopButton
	AButton stepButton
	AButton backButton
	AButton editButton  //also greyed version ?
	AButton greyBackgroundButton
	AButton tooltipsButton
	AButton attributesButton
	AButton attributesIconButton
	AButton imageButton //also greyed version ? 
	AButton indexButton
	AButton helpButton  //also greyed version ?
	AButton homeButton
	AButton fullScreenButton
	AButton fullMenuSizeButton
	AButton filterButton
	AButton autoZoomButton
	AButton lockButton
	DelaySlider slider
	DelayProgress progress
	
	Boolean isActive(AButton button){
		
	}
	
	Integer getSpeed(){	return slider.delay}
	
	
	void finishRunning(){
		
		}
	
	Menu(){}
	 String autoZoom_OnIcon=			icon("/images/roan_autoZoomOn.png", "/images/CenterSelectedNodeAction.png")
	 String autoZoom_OffIcon=			icon("/images/roan_autoZoomOff.png", "/images/icons/mindmap.png")
	
	 String stepIcon=					icon("/images/roan-step.png", "/images/MoveTo_NextNode.png")
	 
	 String backIcon=					icon("/images/roan-back.png", "/images/MoveTo_PrevNode.png")
	 
	 String playIcon=					icon("/images/roan-play.png", "/images/icons/video.png")
	 String stopIcon=					icon("/images/roan-stop.png", "/images/quit.png")
	
	  String grey_OnIcon=				icon("/images/roan-greyBackgroundOn.png", "/images/ShowSelectionAsRectangleAction.png")
	 String grey_OffIcon=				icon("/images/roan-greyBackroundOff.png", "/images/ShowSelectionAsRectangleAction.png")
	 
	 String editIcon=					icon("/images/roan-editDialog.png",			"/images/icons/edit.png")
	 String edit_InactiveIcon=			icon("/images/roan-editDialogInactive.png",	"/images/icons/edit.png")
	 
	 String tooltip_OnIcon=				icon("/images/roan-tooltipOn.png",		"/images/AttributesView.png")
	 String tooltip_OffIcon=			icon("/images/roan-tooltipOff.png",		"/images/AttributesView.png")
	 String tooltip_InactiveIcon=		icon("/images/roan-tooltipInactive.png","/images/AttributesView.png")
	 
	 String attributes_OnIcon=			icon("/images/roan-attributesOn.png",		"/images/icons/list.png")
	 String attributes_OffIcon=			icon("/images/roan-attributesOff.png",		"/images/icons/list.png")
	 String attributes_InactiveIcon=	icon("/images/roan-attributesInactive.png",	"/images/icons/list.png")
	 
	 String state_OnIcon=				icon("/images/roan-showAtributesIconOn.png",		"/images/Btn_edit.gif")
	 String state_OffIcon=				icon("/images/roan-showAttributesIconOff.png",		"/images/Btn_edit.gif")
	 String state_InactiveIcon=			icon("/images/roan-showAttributesIconInactiv.pnge",	"/images/Btn_edit.gif")
	
	 String imageIcon=					icon("/images/roan-insertImage.png",			"/images/icons/penguin.png")
	 String image_InactiveIcon=			icon("/images/roan-insertImageInactive.png",	"/images/icons/penguin.png")
	 
	 String indexIcon=					icon("/images/roan-index.png",			"/images/icons/bookmark.png")
	 String index_InactiveIcon=			icon("/images/roan-index.png",	"/images/icons/bookmark.png")
	 
	 String homeIcon=					icon("/images/roan-home.png",			"/images/icons/gohome.png")
	 String home_InactiveIcon=			icon("/images/roan-homeInactive.png",	"/images/icons/gohome.png")
	 
	 String helpIcon=					icon("/images/roan-help", "/images/icons/help.png")
	 String help_InactiveIcon=			icon("/images/roan-helpInactive", "/images/icons/help.png")
	 
	 String fullScreen_OnIcon=			icon("/images/roan-fullScreenOn.png",		"/images/Executable.png")
	 String fullScreen_OffIcon=			icon("/images/roan-fullScreenOff.png",		"/images/Executable.png")
	 
	 String fullSize_OnIcon=			icon("/images/roan-maximizeOn.png",			"/images/ZoomIn24.png")
	 String fullSize_OffIcon=			icon("/images/roan-maximizeOff.png",		"/images/ZoomOut24.png")
	 String fullSize_InactiveIcon=		icon("/images/roan-maximizeInactive.png",	"/images/ZoomOut24.png")
	 String filter_OnIcon=				icon("/images/roan-filter_On.png",			"/images/filter.png")
	 String filter_OffIcon=				icon("/images/roan-filter_Off.png",			"/images/remove_filtering.png")
	 String lock_OnIcon=				icon("/images/roan-lock_On.png",			"/images/lock.png")
	 String lock_OffIcon=				icon("/images/roan-lock_Off.png",			"/images/unlock.png")
	 
	 static icon(String preferredPathname, String defaultPathname){
		 def r= FileLib.preferredFrom_resourcepathToUrl(preferredPathname,defaultPathname) //workaround...
		 return r
	 }
	 
	 
	 void deActivateButtons(){ //when playing make grey
		 homeButton.inactivate()
		 editButton.inactivate()
		 imageButton.inactivate()
		 indexButton.inactivate()
		 lockButton.inactivate()
		 helpButton.inactivate()
		 
		 //remember state
		 tooltipsButton.inactivate()
		 attributesButton.inactivate()
		 attributesIconButton.inactivate()
		 //fullMenuSizeButton.inactivate()
		 Menu.current.refresh()
	 }
	 
	 void reActivateButtons(){// after playing
		 homeButton.reactivate()
		 editButton.reactivate()
		 imageButton.reactivate()
		 indexButton.reactivate()
		 lockButton.reactivate()
		 helpButton.reactivate()
		 
		 //remember state
		 tooltipsButton.reactivate()
		 attributesButton.reactivate()
		 attributesIconButton.reactivate()
		 //fullMenuSizeButton.reactivate()
		 Menu.current.refresh()
	 }
	 
	public createButtons(Boolean fullSize){
		
	    current=this
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))
		
		slider = new DelaySlider();
		slider.toolTipText=Translate.sliderTooltip
		slider.setVisible(fullSize)
		add(slider)
		
		progress=new DelayProgress()
		add(progress)
		
		stepButton=new AButton(stepIcon,1.0,Translate.stepTitle,
		 { Controller.current.stepAction()   })
		top.add(stepButton,BorderLayout.NORTH)
		
		backButton=new AButton(backIcon, 1.0,Translate.backTitle, 
			{if (Controller.current.playThread) Controller.current.stopAction()
			 else Controller.current.backAction()})
		top.add(backButton,BorderLayout.NORTH)
		
		playButton=new AButton(stopIcon,1.0,playIcon,1.0,Translate.stopTitle,Translate.playTitle,
			{	Controller.current.playAction() },
			{	Controller.current.stopAction() }
			)
		   	top.add(playButton,BorderLayout.NORTH)
			   
	   homeButton=new AButton(homeIcon,1.0,Translate.homeTitle,
		   {Controller.current.homeAction()})
	   homeButton.setInactiveIcon(home_InactiveIcon, 1.0)
	   top.add(homeButton,BorderLayout.SOUTH)
		   	
	   filterButton=new AButton(filter_OnIcon,1.0,filter_OffIcon,1.0,Translate.filter_OnTitle,Translate.filter_OffTitle,
		   {Controller.current.filter_OffAction()},
		   {Controller.current.filter_OnAction()}
		   )
	   Controller.current.doFilter=Controller.current.doFilter_preference
	   Menu.current.filterButton.synchronizeOn(!Controller.current.doFilter)
	   top.add(filterButton,BorderLayout.SOUTH)
	   
	   autoZoomButton=new AButton(autoZoom_OnIcon,1.0,autoZoom_OffIcon,1.0,Translate.autoZoom_OnTitle,Translate.autoZoom_OffTitle,
		   {Controller.current.autoZoom_OffAction()},
		   {Controller.current.autoZoom_OnAction()}
		   )
	   Controller.current.doAutoZoom=Controller.current.doAutoZoom_preference
	    Menu.current.autoZoomButton.synchronizeOn(!Controller.current.doAutoZoom)
	   top.add(autoZoomButton,BorderLayout.SOUTH)
		
		greyBackgroundButton=new AButton(grey_OnIcon,1.0,grey_OffIcon,1.0,Translate.grey_OnTitle,Translate.grey_OffTitle,
			{Controller.current.greyBackground_OnAction() },
			{Controller.current.greyBackground_OffAction() }
			)
		Menu.current.greyBackgroundButton.synchronizeOn(Action_GreyedSurround.isOn)
		top.add(greyBackgroundButton,BorderLayout.SOUTH)
		
		fullScreenButton=new AButton(fullScreen_OnIcon,1.0,fullScreen_OffIcon,1.0,Translate.fullScreenOnTitle,Translate.fullScreenOffTitle,
			{Controller.current.fullScreen_OnAction()},
			{Controller.current.fullScreen_OffAction()}
			)
		Menu.current.fullScreenButton.synchronizeOn(Action_FullScreen.isOn)
		top.add(fullScreenButton,BorderLayout.SOUTH)
		
		
		editButton=new AButton(editIcon,1.0,Translate.editTitle,
			{	def selected=NodeLib.selectedNode()
				new EditDialog().open(selected)
			})
		editButton.setVisible(fullSize)
		editButton.setInactiveIcon(edit_InactiveIcon,1.0)
		top.add(editButton,BorderLayout.SOUTH)
		
		tooltipsButton=new AButton(tooltip_OnIcon,1.0,tooltip_OffIcon,1.0,Translate.tooltip_OnTitle,Translate.tooltip_OffTitle,
			{Controller.current.tooltips_OnAction()},
			{Controller.current.tooltips_OffAction()}
			)
		tooltipsButton.setVisible(fullSize)
		tooltipsButton.setInactiveIcon(tooltip_InactiveIcon, 1.0)
		Menu.current.tooltipsButton.synchronizeOn(MenuItems.isTooltips)
		top.add(tooltipsButton,BorderLayout.SOUTH)
		
		attributesButton=new AButton(attributes_OnIcon,1.0,attributes_OffIcon,1.0,Translate.attributes_OnTitle,Translate.attributes_OffTitle,
			{Controller.current.attributes_OnAction()},
			{Controller.current.attributes_OffAction()}
			)
		attributesButton.setVisible(fullSize)
		attributesButton.setInactiveIcon(attributes_InactiveIcon,1.0)
		Menu.current.attributesButton.synchronizeOn(MenuItems.isAttributes)
		top.add(attributesButton,BorderLayout.SOUTH)
		
		attributesIconButton=new AButton(state_OnIcon,1.0,state_OffIcon,1.0,Translate.state_OnTitle,Translate.state_OffTitle,
			{Controller.current.attributesIcon_OnAction()},
			{Controller.current.attributesIcon_OffAction()}
			)
		attributesIconButton.setVisible(fullSize)
		attributesIconButton.setInactiveIcon(state_InactiveIcon,1.0)
		Menu.current.attributesIconButton.synchronizeOn(MenuItems.isAttributesIcon)
		top.add(attributesIconButton,BorderLayout.SOUTH)
		
		imageButton=new AButton(imageIcon,1.0,Translate.imageTitle,{new ImageInline().doImageAction()})//{Controller.current.imageAction()})
		imageButton.setVisible(fullSize)
		imageButton.setInactiveIcon(image_InactiveIcon,1.0)
		top.add(imageButton,BorderLayout.SOUTH)
		
		indexButton=new AButton(indexIcon,1.0,Translate.indexTitle,{new Index().indexAction()})//{Controller.current.imageAction()})
		indexButton.setVisible(fullSize)
		indexButton.setInactiveIcon(index_InactiveIcon,1.0)
		top.add(indexButton,BorderLayout.SOUTH)
		
		
		lockButton=new AButton(lock_OffIcon,1.0,Translate.lockTitle,
			{if (!Controller.current.playThread) Controller.current.lockAction()})
		lockButton.setVisible(fullSize)
		//lockButton.setInactiveIcon(help_InactiveIcon,1.0)
		top.add(lockButton,BorderLayout.SOUTH)
		
		fullMenuSizeButton=new AButton(fullSize_OnIcon,1.0,fullSize_OffIcon,1.0,Translate.minSizeTitle,Translate.plusSizeTitle,
			{Controller.current.minSizeAction()},
			{Controller.current.plusSizeAction()}
			)
		if(!fullSize) fullMenuSizeButton.toggleButtonWithoutAction()
		top.add(fullMenuSizeButton,BorderLayout.SOUTH)
		
		helpButton=new AButton(helpIcon,1.0,Translate.helpTitle,
			{if (!Controller.current.playThread) Controller.current.helpAction()})
		helpButton.setVisible(fullSize)
		helpButton.setInactiveIcon(help_InactiveIcon,1.0)
		top.add(helpButton,BorderLayout.SOUTH)
		
		
		
		add(top,BorderLayout.NORTH)
	if (Controller.debug)	println" ..."
	if (Controller.debug)	println "DEBUG: main window open"
		//assert(false)
	
	Controller.current.attributes_OffAction()
	Controller.current.attributesIcon_OffAction()
}
	
	void initMenu_FreeplaneItems(){
		setMenuButtons(!Defaults.onOpenMaxMenu_screenModeMaxOff,false,false,false,true,MenuItems.isStatusBar)
		MenuFreeplane.executeMenuActions(['ApplyNoFilteringAction','FoldAllAction'])
		}
	void finishMenu_FreeplaneItems(){
		setMenuButtons(!Defaults.onCloseMenu_screenModeMaxOff,false,false,false,true)
		MenuFreeplane.executeMenuActions(['ApplyNoFilteringAction','FoldAllAction'])
		}
	private Boolean fullScreen_OnPlay
	private Boolean grey_OnPlay
	private Boolean  attributes_OnPlay
	private Boolean attributesIcon_OnPlay
	private Boolean tooltips_OnPlay
	private Boolean statusBar_OnPlay
	
	void initPlay_FreeplaneItems(){// niet meer nodig
		
		fullScreen_OnPlay=Action_FullScreen.isOn
		grey_OnPlay=Action_GreyedSurround.isOn
		attributes_OnPlay=MenuItems.isAttributes
		attributesIcon_OnPlay=MenuItems.isAttributesIcon
		tooltips_OnPlay=MenuItems.isTooltips
		statusBar_OnPlay=MenuItems.isStatusBar
		Boolean maxScreen=null; if (Defaults.onPlay_screenModeMaxOn)maxScreen=true
		Boolean greyBackground=null;if ( Defaults.onPlay_greyBackgroundOn) greyBackground=true
		Boolean attributes=null;if ( Defaults.onPlay_attributesOff) attributes=false
		Boolean attributesIcon=null;if ( Defaults.onPlay_attributesIconOff) attributesIcon=false
		Boolean tooltips=null;if ( Defaults.onPlay_tooltipsOff) tooltips=false
		
		setMenuButtons(maxScreen,
			greyBackground,
			attributes,
			attributesIcon,
			tooltips,
			null)
		}
	void finishPlay_FreeplaneItems(){
		Boolean maxScreen=fullScreen_OnPlay; if (Defaults.finishPlay_screenModeMaxOff)maxScreen=false
		Boolean greyBackground=grey_OnPlay;if ( Defaults.finishPlay_greyBackgroundOff) greyBackground=false
		Boolean attributes=attributes_OnPlay;if ( Defaults.finishPlay_attributesOn) attributes=true
		Boolean attributesIcon=attributesIcon_OnPlay;if ( Defaults.finishPlay_attributesIconOn) attributesIcon=true
		Boolean tooltips=tooltips_OnPlay;if ( Defaults.finishPlay_tooltipsOn) tooltips=true
		setMenuButtons(maxScreen,
			         greyBackground,
					 attributes,
					 attributesIcon,
					 tooltips,
					 statusBar_OnPlay)
		if (Controller.debug) println "DEBUG: finishPlay_FreeplaneItems() resets menu"
		}
	
	Boolean remember_Fullscreen_OnMinimize
	void initMenu_minimize(){
		remember_Fullscreen_OnMinimize=Action_FullScreen.isOn
		Boolean maxScreen=null; if (Defaults.onOpenMinMenu_screenModeMaxOn)maxScreen=true
		Boolean greyBackground=null;if ( Defaults.onOpenMinMenu_greyBackgroundOn) greyBackground=true
		Boolean attributes=null;if ( Defaults.onOpenMinMenu_attributesOff) attributes=false
		Boolean attributesIcon=null;if ( Defaults.onOpenMinMenu_attributesIconOff) attributesIcon=false
		Boolean tooltips=null;if ( Defaults.onOpenMinMenu_tooltipsOff) tooltips=false
		setMenuButtons(maxScreen, greyBackground,attributes,attributesIcon,tooltips,null)
	}
	
	void initMenu_maximize(){
		Boolean maxScreen=null; if (Defaults.onOpenMaxMenu_screenModeMaxOff)maxScreen=false
		Boolean greyBackground=null;if ( Defaults.onOpenMaxMenu_greyBackgroundOff) greyBackground=false
		Boolean attributes=null;if ( Defaults.onOpenMaxMenu_attributesOff) attributes=false
		Boolean attributesIcon=null;if ( Defaults.onOpenMaxMenu_attributesIconOff) attributesIcon=false
		Boolean tooltips=null;if ( Defaults.onOpenMaxMenu_tooltipsOn) tooltips=true
		
		setMenuButtons(maxScreen, greyBackground,attributes,attributesIcon,tooltips,null)
	}
	
	void setSize(Boolean maxMenu){
		//if (maxMenu) initMenu_maximize()else initMenu_minimize()
		//println "TEST maxMenu=$maxMenu"
		Menu.current.fullMenuSizeButton.synchronizeOn(!maxMenu)
		Menu.current.fullScreenButton.setVisible(true)
		Menu.current.greyBackgroundButton.setVisible(true)
		Menu.current.attributesButton.setVisible(maxMenu)
		Menu.current.attributesIconButton.setVisible(maxMenu)
		Menu.current.fullMenuSizeButton.setVisible(true)
		Menu.current.editButton.setVisible(maxMenu)
		Menu.current.imageButton.setVisible(maxMenu)
		Menu.current.indexButton.setVisible(maxMenu)
		Menu.current.lockButton.setVisible(maxMenu)
		Menu.current.tooltipsButton.setVisible(maxMenu)
		Menu.current.helpButton.setVisible(maxMenu)
		Menu.current.slider.setVisible(maxMenu)
		Menu.current.refresh()
	}
 
 void setMenuButtons(Boolean fullScreen, Boolean greyBackground, Boolean attributes, Boolean attributeIcons,Boolean tooltips, Boolean statusBar){
	//assert(false)
	 if (fullScreen!=null) 		Menu.current.fullScreenButton.setOn(fullScreen)
	 if (greyBackground!=null)  Menu.current.greyBackgroundButton.setOn(greyBackground)
	 if (attributes!=null) 		Menu.current.attributesButton.setOn(attributes)
	 if (attributeIcons!=null) 	Menu.current.attributesIconButton.setOn(attributeIcons)
	 if (tooltips!=null) 		Menu.current.tooltipsButton.setOn(tooltips)
	 if (statusBar!=null)		Controller.current.statusBarAction(statusBar)
 }

 //SwingUtilities.getWindowAncestor( component )
 public static Frame getTopFrame() {
	 Frame[] frames = Frame.getFrames();
	 for(int i = 0; i < frames.length; i++) {
	   if(frames[i].getFocusOwner() != null) {
		 return frames[i];
	   }
	 }
	 if(frames.length > 0) {
	   return frames[0];
	 }
	 return null;
   }
 
 public static JFrame getMenuFrame(){
	/* JFrame[]*/ def frames = JFrame.getFrames(); //def is workaround converison error; when menu is closed and reopened
	/* JFrame*/def f=null
	 frames.each{if (it.title==Translate.menuTitle) f=it}
	 return f
 }
 
private void createAndShowGUI(Boolean fullSize) {
	//if (Controller.current.menuFrame==null){
	//Disable boldface controls.
	 UIManager.put("swing.boldMetal", Boolean.FALSE);

	//Create and set up the window.
	// JFrame    		mainFrame = UITools.getFrame()//??
	
	JFrame frame =menuFrame // already exists
	if (frame==null) frame= new JFrame(Translate.menuTitle)
	
	//{
		//@Override
		//public void dispose() {
		//	new EditDialog().finishEditDialogs()
		//	super.dispose();
		//}}
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	frame.addWindowListener(new WindowAdapter(){
		public void windowClosing(WindowEvent e){
			new EditDialog().finishEditDialogs()
			Controller.current.fullScreenAction(false)
		}
	})
	frame.setAlwaysOnTop(true)
	def screen=WindowLib.screenSize
	frame.setLocation(0,screen.height.toInteger()-150)

	//Create and set up the content pane.
	Menu newContentPane = new Menu();
		
	newContentPane.createButtons(fullSize);
	newContentPane.setOpaque(true); //content panes must be opaque
	frame.setContentPane(newContentPane);

	//Display the window.
	frame.pack();
	frame.setVisible(true);
	frame.setResizable(false);
	
	Controller.current.menuFrame=frame
	if (Controller.debug) println "DEBUG: Menu created; menuFrame=$menuFrame"
	
	//assert(false)
	//}
}

void open(Boolean fullSize){
	roan.Controller.current.initCurrentNodeInRoot() // used by selecteds/filter; once pro session, hence when opening window
	createAndShowGUI(fullSize)
	//else if(Controller.debug) println "DEBUG: skip open new menu, menu already exists"
	}

void finish(){
	Controller.current.mode=Controller.Mode.STOP
	if(Controller.current.menuFrame==null) Controller.current.menuFrame=menuFrame
	if(Controller.current.menuFrame!=null){
		Controller.current.stopAction()//make sure
		Controller.current.menuFrame.setVisible(false); //you can't see me!
		Controller.current.menuFrame.dispose(); //Destroy the JFrame object
	}
}

void resize(Boolean fullSize){
	
	//if(Controller.current.PlayThread) playButton.toggleButtonWithoutAction()
	if(Controller.current.menuFrame==null) Controller.current.menuFrame=menuFrame
			setSize(fullSize)
			Controller.current.menuFrame.pack()
			Controller.current.menuFrame.repaint();
}

void refresh(){
			if(Controller.current.menuFrame==null) Controller.current.menuFrame=menuFrame
			Controller.current.menuFrame.pack()
			Controller.current.menuFrame.repaint();
}
Closure isStop={false}
	

static void setFilterOn(Boolean b){ Menu.current.filterButton.setOn(b)}
static void setZoomOn(Boolean b){ Menu.current.autoZoomButton.setOn(b)}


}

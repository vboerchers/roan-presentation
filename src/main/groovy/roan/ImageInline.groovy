package roan
//Author Jodi D.Krol 2013
import javax.swing.ImageIcon
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.JCheckBox
import javax.swing.JComboBox
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib
import scriptlib.Filename
import javax.swing.JOptionPane
import java.awt.BorderLayout
import javax.swing.SwingUtilities
import scriptlib.Preferences
import scriptlib.Message
import scriptlib.FileLib
import scriptlib.LinkLib
import scriptlib.StringLib


class ImageInline extends Index{ 
	

	static Integer widthMaxPref=Preferences.getIntegerProp(
		"addons.roan.imageinline.widthMax",
		300
		)
	static Integer heightMaxPref=Preferences.getIntegerProp(
		"addons.roan.imageinline.heightMax",
		200
		)
////
	static String locationImageLabelTitle=Message.textUtils.getText(
		"addons.roan.imageinline.locationImageLabelTitle",
		"Location image"
		)
	static String widthMaxTitle=Message.textUtils.getText(
		"addons.roan.imageinline.widthMaxTitle",
		"maximum width"
		)
	static String heightMaxTitle=Message.textUtils.getText(
		"addons.roan.imageinline.heightMaxTitle",
		"maximum height"
		)
	static String CurrentTitle=Message.textUtils.getText(
		"addons.roan.imageinline.Current",
		"Current node"
		)
	static String ParentTitle=Message.textUtils.getText(
		"addons.roan.imageinline.Parent",
		"Parent node"
		)
	static String dialogTitle=Message.textUtils.getText(
		"addons.roan.imageinline.dialogTitle",
		"Insert inline image(s)"
		)
	static String fromParentDirectoryTitle=Message.textUtils.getText(
		"addons.roan.imageinline.fromParentDirectoryTitle",
		"New images from parent directory"
		)
	static String fromRedArrowLinksTitle=Message.textUtils.getText(
		"addons.roan.imageinline.fromRedArrowLinksTitle",
		"Images from red-arrow links"
		)
	static String fromAddonInsertInlineImageTitle=Message.textUtils.getText(
		"addons.roan.imageinline.fromAddonInsertInlineImageTitle",
		"Image by addon Insert Inline Image"
		)
	static String subMenuTitle=Message.textUtils.getText(
		"addons.roan.imageinline.subMenuTitle",
		"SubMenu"
		)
	
	static String isResizeExisitingTitle=Message.textUtils.getText(
		"addons.roan.imageinline.isResizeExisitingTitle",
		"Resize existing"
		)
	
	
	ImageInline(){}
	
	static enum LocationCP{Current,Parent}
	// weg ??
	static String locationCPToTitle(LocationCP l){
	
		if (l==LocationCP.Current) return CurrentTitle
		else if (l==LocationCP.Parent) return ParentTitle
	}
	static LocationCP toLocationCP(String s){
		if (s==CurrentTitle) return LocationCP.Current
		else if (s==ParentTitle) return LocationCP.Parent
	}
	
	
	static JCheckBox isResizeExisiting
	
	JPanel mainPanel
	JPanel imagePanel
	static JLabel subMenu
	static JComboBox locationCB
	static JLabel widthLabel
	static JTextField widthMax
	static JLabel heightLabel
	static JLabel locationLabel
	static JTextField heightMax
	static JComboBox nodeTypeCB
	
	
	void doAll(String relativePath, Proxy.Node node, NodeLib.Field field, Integer maxWidth, Integer maxHeight, Boolean isResizeExisting,Boolean isDirectoryNodes,NodeLib.Field fieldDirectory, Boolean isIcon){
		String separatorF=FileLib.separator
		String separatorL="/"
		if(relativePath=="") {separatorF="";separatorL=""}
		File f= new File(mapDirectory+separatorF+relativePath)
		
		def li=f.list()
		if (li!=null){
			li.each{
				if(it.substring(0,1)=="\$") {}//skip hidden files
				else{
				String target_rPath=relativePath+separatorL+it
				String target_uriStr=LinkLib.toUriStr(target_rPath) //TEST temp
				File currentF= new File(mapDirectory+separatorF+relativePath+FileLib.separator+it)
				if (currentF.isDirectory()){
					Proxy.Node dirNode
					if (isDirectoryNodes) dirNode=getDirNode(node,relativePath,it,target_uriStr, fieldDirectory, isIcon) 
					else dirNode=NodeLib.root
					assert(dirNode!=null)
					doAll(target_rPath, dirNode, field, maxWidth, maxHeight,isResizeExisting, isDirectoryNodes,fieldDirectory,isIcon)
				}
				else{
					//println "TEST temp it=$it; isResizeExisting=$isResizeExisting; inBranch:"; println isFileNodeInBranch(node,targetRegexStr)
					 if (isImageFile(it)&&!isFileNodeInBranch(node, target_uriStr))
							  createImageNode (node,relativePath,it,field,maxWidth,maxHeight)
							  
					 else if (isResizeExisting &&isImageFile(it)){
						 def n=getFileNodeInBranch(node,target_uriStr)
						 resetInlineImageLink(n, field, maxWidth, maxHeight)
						 }
				}
				
			}
		}}
		NodeLib.foldAll(NodeLib.root)
	}
	

		
	static void createImageNode (Proxy.Node parent,rPath,String filename,NodeLib.Field field, Integer maxWidth, Integer maxHeight){
		if (parent==null){}
		else{
			String separator="/"; if(rPath=="") separator=""
			def node=parent.createChild()
			Filename fn=new Filename(filename)
			node.text=filename//-fn.dotExtension
			String s=LinkLib.toUriStr(rPath+separator+filename)
			URI uri=new URI(s)
			if (uri==null){ println "TEST temp ERROR URI format: $s" }
			else{
				setInlineImage(node,uri,field, (LocationCP) null, maxWidth,maxHeight)
			}
			}
		}
		
	ArrayList newImageFiles(ArrayList allFiles){
		ArrayList r=[]
		if (allFiles==[]) return []
		else{
			allFiles.each{ 	if(!isFilenameInBranch(NodeLib.root,it)) r+=it}
		}
		return r
	}
	
	Boolean isFilenameInBranch(Proxy.Node node, String fileName){
		Boolean done=false
		if (isFilename(node,fileName)) done= true
		else if (node.children!=null) node.children.each{if (!done&&isFilenameInBranch(it,fileName)) done=true}
		return done
	}
	
	Boolean isFilename(Proxy.Node node,String fileName){
		return (node.details!=null&&node.details.find(fileName)==fileName)||
			   (node.text!=null&&node.text.find(fileName)==fileName)||
			   (node.note!=null&&node.note.find(fileName)==fileName)
	}
	
	
	ArrayList getAllImageFiles(){
		ArrayList r=[]
		String mapDirectory=FileLib.path_mapDirectory
		File f= new File(mapDirectory)
		def li=f.list()
		if (li!=null){
			li.each{
				if (isImageFile(it)){r+=it}
			}
		}
		return r
	}
	
	
	JPanel menuPanel
	JComboBox menuCB
	
   void initImagePanel()		{
		imagePanel = new JPanel()
		imagePanel.setLayout(new BorderLayout());
		
		JPanel level1=new JPanel()
		imagePanel.add(level1,BorderLayout.NORTH)
		
		String[] menu=[fromParentDirectoryTitle, fromRedArrowLinksTitle,fromAddonInsertInlineImageTitle]
		menuCB = new JComboBox(menu)
		
		menuPanel=new JPanel()
		subMenu=new JLabel(subMenuTitle)
		menuPanel.add(subMenu)
		menuPanel.add(menuCB)
		level1.add(menuPanel)
		menuCB.addItemListener (new ItemListener () {
			@Override
			public void itemStateChanged(ItemEvent event) {
			   if (event.getStateChange() == ItemEvent.SELECTED) {
				  Object item = event.getItem();
				  ImageInline.setMenu(item)
			   }
			}
		});
	
		JPanel level2=new JPanel()
		imagePanel.add(level2, BorderLayout.CENTER)
		
		widthLabel=new JLabel(widthMaxTitle)
		level2.add(widthLabel)
		widthMax=new JTextField(widthMaxPref.toString())
		level2.add(widthMax)
		
		heightLabel=new JLabel(heightMaxTitle)
		level2.add(heightLabel)
		heightMax=new JTextField(heightMaxPref.toString())
		level2.add(heightMax)
		
		isResizeExisiting= new JCheckBox( isResizeExisitingTitle)
		level2.add(isResizeExisiting)
		String[] location=[NodeLib.toFieldTitle(NodeLib.Field.DETAILS),NodeLib.toFieldTitle(NodeLib.Field.CORE),NodeLib.toFieldTitle(NodeLib.Field.NOTE),NodeLib.toFieldTitle(NodeLib.Field.ARROW)]
		locationLabel=new JLabel(locationImageLabelTitle)
		level2.add(locationLabel)
		locationCB = new JComboBox(location)
		level2.add(locationCB)
		
		String[] nodeType=[locationCPToTitle(LocationCP.Current), locationCPToTitle(LocationCP.Parent)]
		nodeTypeCB = new JComboBox(nodeType)
	
		setMenu(fromParentDirectoryTitle) //initialize
		//setMenu(fromAddonInsertInlineImageTitle) //initialize
   }
   
   void initImageAction(){
	   
	   mainPanel = new JPanel()
	   mainPanel.setLayout(new BorderLayout());
	   initIndexPanel()
	   mainPanel.add(indexPanel,BorderLayout.SOUTH)
	   initImagePanel()
	   mainPanel.add(imagePanel,BorderLayout.NORTH)
	   
	   isDirectoryNodes.setVisible(true)
	   showFileExtension.setVisible(false)
	   locationLinkFileCB.setVisible(false)
	   locationLinkFileLabel.setVisible(false)
   }
	  void doImageAction(){
		initImageAction()
		int result = JOptionPane.showConfirmDialog(null, mainPanel,dialogTitle, JOptionPane.OK_OPTION)
		if (result == JOptionPane.OK_OPTION) {
			ArrayList selecteds=NodeLib.selectedNodes
			
			Integer maxWidth= widthMax.text.toInteger()
			Integer maxHeight=heightMax.text.toInteger()
			
			if (maxWidth==null||maxWidth<10||maxWidth > 2000) maxWidth=widthMaxPref
			if (maxHeight==null||maxHeight<10||maxHeight > 2000) maxHeight=heightMaxPref
			
			if (menuCB.selectedItem==fromParentDirectoryTitle){
				doAll("", 
					NodeLib.root,
					NodeLib.toLocationField(locationCB.selectedItem), 
					maxWidth, 
					maxHeight,isResizeExisiting.isSelected(),
					isDirectoryNodes.isSelected(),
					NodeLib.toLocationField(locationLinkDirectoryCB.selectedItem),
					isDirectoryIcon.isSelected())
				finishIndex()
				}
			else if (menuCB.selectedItem==fromRedArrowLinksTitle){
				selecteds.each{
					convertLinkToInlineImage(it, NodeLib.toLocationField( locationCB.selectedItem), toLocationCP( nodeTypeCB.selectedItem),maxWidth, maxHeight)
				}
			}
			else roan.Controller.current.imageAction()
			
		}
	}
	
	static void setMenu(Object item){
		if (item==fromAddonInsertInlineImageTitle){
			ImageInline.widthLabel.setVisible(false)
			ImageInline.widthMax.setVisible(false)
			ImageInline.heightLabel.setVisible(false)
			ImageInline.heightMax.setVisible(false)
			ImageInline.isResizeExisiting.setVisible(false)
			ImageInline.locationLabel.setVisible(false)
			ImageInline.locationCB.setVisible(false)
			ImageInline.nodeTypeCB.setVisible(false)
			//ImageInline.isDirectoryNodes.setVisible(false)
			//ImageInline.locationLinkDirectoryLabel.setVisible(false)
			//ImageInline.locationLinkDirectoryCB.setVisible(false)
			//ImageInline.isDirectoryIcon.setVisible(false)
			indexPanel.setVisible(false)
		}
		else if(item==fromParentDirectoryTitle){
			ImageInline.widthLabel.setVisible(true)
			ImageInline.widthMax.setVisible(true)
			ImageInline.heightLabel.setVisible(true)
			ImageInline.heightMax.setVisible(true)
			ImageInline.isResizeExisiting.setVisible(true)
			ImageInline.locationLabel.setVisible(true)
			ImageInline.locationCB.setVisible(true)
			ImageInline.nodeTypeCB.setVisible(false)
			//if (isDirectoryNodes.isSelected()){
			//ImageInline.isDirectoryNodes.setVisible(true)
			//ImageInline.isDirectoryIcon.setVisible(true)
			//ImageInline.locationLinkDirectoryLabel.setVisible(true)
				//ImageInline.locationLinkDirectoryCB.setVisible(true)
				//ImageInline.isDirectoryIcon.setVisible(true)
			//}
			//	else{
			//		ImageInline.isDirectoryInDetails.setVisible(false)
			//		ImageInline.isDirectoryIcon.setVisible(false)
			//	}
			indexPanel.setVisible(true)
		}
		else if(item==fromRedArrowLinksTitle){//covert red-arrow link
			ImageInline.widthLabel.setVisible(true)
			ImageInline.widthMax.setVisible(true)
			ImageInline.heightLabel.setVisible(true)
			ImageInline.heightMax.setVisible(true)
			ImageInline.isResizeExisiting.setVisible(false)
			ImageInline.locationLabel.setVisible(true)
			ImageInline.locationCB.setVisible(true)
			ImageInline.nodeTypeCB.setVisible(true)
			//ImageInline.isDirectoryNodes.setVisible(true)
			//ImageInline.locationLinkDirectoryLabel.setVisible(false)
			//ImageInline.locationLinkDirectoryCB.setVisible(false)
			//ImageInline.isDirectoryIcon.setVisible(false)
			
			indexPanel.setVisible(false)
		}
		else assert(false)
	}
	
	static void convertLinkToInlineImage(Proxy.Node node, NodeLib.Field field, LocationCP nodeType, Integer maxWidth, Integer maxHeight){
		URI uri=getImageLink(node)
		if (uri!=null){
			setInlineImage(node,uri,field, nodeType, maxWidth,maxHeight)
			node.link.uri=null
		}
	}
	
	static URI getImageLink(Proxy.Node node){
		if (node.link.uri==null||
			!node.link.uri.toString().find(/(.jpg|.JPG|.png|.PNG|.svg|.SVG|.ico|.ICO|.gif|.GIF)$/)
			) return null
		else return  node.link.uri
	}
	
	/////////////
	static String getLinkRaw(String s){
		println s.find(/(?i)<a([^>]+)>(.+?)<\/a>/)}
	//'<a href="' + pathname +'"><img width="' + newWidth.toInteger().toString() + '" height="'+ newHeight.toInteger().toString() +'" src="'+ pathnameInline + '"></a>'
	
	static void resetInlineImageLink(Proxy.Node node, NodeLib.Field field, Integer maxWidth, Integer maxHeight){
		String s=""	
		if (field==NodeLib.Field.DETAILS &&node.details!=null) s=node.details
		else if (field==NodeLib.Field.CORE) s=node.text
		else if (field==NodeLib.Field.NOTE) s=node.note
		
		LinkLib linkOld=new LinkLib(s)
		if (linkOld.uriStr==null){}
		else{
		
			ScaledRectangle newRect=getInlineImageRectangle(linkOld.uriStr,maxWidth,maxHeight)
			
			String oldVal='width="'+linkOld.width+'"'
			String newVal='width="'+newRect.newWidth+'"'
			s=s.replace(oldVal, newVal)
			oldVal='height="'+linkOld.height+'"'
			newVal='height="'+newRect.newHeight+'"'
			s=s.replace(oldVal, newVal)
			
			if (field==NodeLib.Field.DETAILS){node.details=s;node.hideDetails=true}
			else if (field==NodeLib.Field.CORE){node.text=s}
			else if (field==NodeLib.Field.NOTE){node.note=s}
		}
	}
	
	static class ScaledRectangle{ //??
		Integer newWidth,newHeight
		String toString(){ "ScaledRectangle[newWidth=$newWidth; newHeight=$newHeight]"}
		
	    ScaledRectangle(Integer maxWidth, Integer maxHeight, Integer curWidth, Integer curHeight){
			
			def ratioHeight=maxHeight/curHeight
			def ratioWidth=maxWidth/curWidth
			if(curHeight-maxHeight>curWidth-maxWidth){newHeight=ratioHeight*curHeight;newWidth=ratioHeight*curWidth}
			else {newHeight=ratioWidth*curHeight;newWidth=ratioWidth*curWidth}
			
		}
	}
	
	static ScaledRectangle getInlineImageRectangle (String uriStr,Integer maxWidth,Integer maxHeight){ //TEST temp UITWERKEN
		File file=new File(uriStr)
		String iconPathName=FileLib.path_mapDirectory+FileLib.separator+ uriStr.replaceAll("%20"," ")
		ImageIcon imageIcon = new ImageIcon(iconPathName)
		//println "TEST uri=$link.uri"
		int curHeight = imageIcon.getIconHeight()
		int curWidth = imageIcon.getIconWidth()
		
		return new ScaledRectangle(maxWidth, maxHeight, curWidth,curHeight)
				
		}
	
	
	static String getInlineImageLinkStr (String uriStr,Integer maxWidth,Integer maxHeight){ //TEST temp UITWERKEN
		File file=new File(uriStr)
		String iconPathName=FileLib.path_mapDirectory+FileLib.separator+ uriStr.replaceAll("%20"," ")
		ImageIcon imageIcon = new ImageIcon(iconPathName)
		//println "TEST uri=$link.uri"
		int curHeight = imageIcon.getIconHeight()
		int curWidth = imageIcon.getIconWidth()
		
		ScaledRectangle sr=new ScaledRectangle(maxWidth, maxHeight, curWidth,curHeight)
		
		String pathnameInline=uriStr.replace('file:/','file:///')
		URI uri = new URI(pathnameInline)//TEST temp moet dit ???????????????????????????????????????????
		String inlineLink=
			"<html><body> <p>"+
			'<a href="' + uri +'"><img width="' +sr.newWidth.toString()+ '" height="'+ sr.newHeight.toString() +'" src="'+ pathnameInline + '"></a>'
			"</p></body></html>"
		return inlineLink
		}

static void setInlineImage (Proxy.Node node, URI uri,NodeLib.Field field, LocationCP nodeType, Integer maxWidth,Integer maxHeight){ //TEST temp UITWERKEN
	
	if (nodeType==null) nodeType=LocationCP.Current
		Proxy.Node destination=node
		if (nodeType==LocationCP.Parent&&node!=NodeLib.root)  destination=node.parent
		
		String inlineLink=getInlineImageLinkStr (uri.toString(),maxWidth,maxHeight)
						   
		if (field==NodeLib.Field.CORE) {if (destination.text==null) destination.text=inlineLink else destination.text=inlineLink+destination.text}
		else if (field==NodeLib.Field.DETAILS) { if (destination.details==null) destination.details=inlineLink else destination.details=inlineLink+destination.details}
		else if (field==NodeLib.Field.NOTE) { if (destination.note==null) destination.note=inlineLink else destination.note=inlineLink+destination.note}
		else if (field==NodeLib.Field.ARROW) { destination.link.uri=uri}
		
		destination.hideDetails=true

	Filename fn=new Filename(destination.text)
	destination.text-=fn.dotExtension
	
	if (destination!=node) node.delete()
	}
	
	
	static String extension(String fileName){return FileLib.extension(fileName)}
	static Boolean isImageFile(String s){
		return isImageExtension(extension(s))
	}
	static Boolean isImageExtension(String extension){
		String ext=extension.toUpperCase()
		return 	ext=="JPG"||ext=="PNG"||ext=="ICO"||ext=="SVG"||ext=="GIF"
	}
	
}





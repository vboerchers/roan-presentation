package roan

import java.awt.BorderLayout
import scriptlib.MapLib
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URI;
import java.util.Comparator;

import javax.swing.JOptionPane
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import scriptlib.Filename

import org.freeplane.plugin.script.proxy.Proxy;

import scriptlib.FileLib
import scriptlib.NodeLib
import scriptlib.Message
import scriptlib.LinkLib
import scriptlib.StringLib


class Index {
	static String directoryTitle=Message.textUtils.getText(
		"addons.roan.index.directoryTitle",
		"directory"
		)
	static String isDirectoryIconTitle=Message.textUtils.getText(
		"addons.roan.index.isDirectoryIconTitle",
		"Icon for directory"
		)
	static String locationLinkDirectoryLabelTitle=Message.textUtils.getText(
		"addons.roan.index.locationLinkDirectoryLabelTitle", 
		"Location directory link"
		)
	static String locationLinkFileLabelTitle=Message.textUtils.getText(
		"addons.roan.index.locationLinkFileLabelTitle", 
		"Location file link"
		)
	static String dialogTitle=Message.textUtils.getText(
		"addons.roan.index.dialogTitle",
		"Add node and link for each folder and file"
		)
	static String sortLabelTitle=Message.textUtils.getText(
		"addons.roan.index.sortLabelTitle",
		"Sort direction"
		)
	static String divisionRootLabelTitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootLabelTitle",
		"Divide nodes left-right"
		)
	static String divisionRootRIGHTTitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootRIGHTTitle",
		"RIGHT"
		)
	static String divisionRootLEFTRIGHTTitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootLEFTRIGHTTitle",
		"LEFT-RIGHT"
		)
	static String divisionRootRIGHTLEFTTitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootRIGHTLEFTTitle",
		"RIGHT-LEFT"
		)
	static String divisionRootMAPFILETitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootMAPFILETitle",
		"MAP-FILE"
		)
	static String divisionRootFILEMAPTitle=Message.textUtils.getText(
		"addons.roan.index.divisionRootFILEMAPTitle",
		"FILE-MAP"
		)
	
	static String sortNONETitle=Message.textUtils.getText(
		"addons.roan.index.sortNONETitle",
		"NONE"
		)
	static String sortFOREWARDTitle=Message.textUtils.getText(
		"addons.roan.index.sortFOREWARDTitle",
		"FOREWARD"
		)
	static String sortBACKWARDTitle=Message.textUtils.getText(
		"addons.roan.index.sortBACKWARDTitle",
		"BACKWARD"
		)
	static String showFileExtensionTitle=Message.textUtils.getText(
		"addons.roan.index.showFileExtensionTitle",
		"Show file extension"
		)
	static String isDirectoryNodesTitle=Message.textUtils.getText(
		"addons.roan.index.isDirectoryNodesTitle",
		"Directory nodes"
		)
	
	static final String icon_folder="folder"
	static String mapDirectory=FileLib.path_mapDirectory
	
	void doAll(String relativePath, 
				Proxy.Node node, 
				NodeLib.Field fieldDirectory,  
				Boolean isIcon, 
				Boolean showFilenameExtension,
				NodeLib.Field fieldFile, 
				Sort sort){
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
					String target_uriStr=LinkLib.toUriStr(target_rPath)
					File currentF= new File(mapDirectory+separatorF+relativePath+FileLib.separator+it)
					if (currentF.isDirectory()){
						Proxy.Node dirNode
						dirNode=getDirNode(node,relativePath,it, target_uriStr,fieldDirectory, isIcon) //TEST temp
						assert(dirNode!=null)
						doAll(target_rPath, dirNode, fieldDirectory, isIcon, showFilenameExtension,fieldFile, sort)
						sortNodes(dirNode, sort)
					}
					
					else{
						if (!isFileNodeInBranch(node,target_uriStr))
						createFileNode (node,relativePath,it, fieldFile, showFilenameExtension)
					}
				}
			}
		}
		//NodeLib.foldAll(NodeLib.root)
	}
						
		
	static Proxy.Node getDirNode(Proxy.Node parent,String rPath, String filename, target_uriStr, NodeLib.Field field, Boolean isIcon){
		
		Proxy.Node node=null
		
		if (!mapIsEmpty) node=getDirNodeInBranch(NodeLib.root,target_uriStr )
		
		if(node==null) node=createDirNode(parent,rPath,filename,field, isIcon )
		return node
	}
	
	static Boolean isFileNodeInBranch(Proxy.Node node, String target_uriStr){
		//String rAllowBrackets=rPathnameNotSpace.replaceAll(/\(/,'\\\\(').replaceAll(/\)/,'\\\\)').replaceAll(/\{/,'\\\\{').replaceAll(/\}/,'\\\\}')
		if (mapIsEmpty) return false else return getFileNodeInBranch(node, target_uriStr)!=null
	}
	static Proxy.Node getFileNodeInBranch(Proxy.Node node,String target_uriStr){ 
		assert(node!=null)
		Proxy.Node done=null
		URI uri=new URI(target_uriStr)
		if (
			(uri!=null&&node.link!=null&&node.link.uri==uri)||
			(node.details!=null&&node.details.find('href="'+target_uriStr))||
			(node.text!=null&&node.text.find('href="'+target_uriStr))||
			(node.note!=null&&node.note.find('href="'+target_uriStr))
			) done = node
		else if (node.children!=null) node.children.each{
			if (done==null)	done= getFileNodeInBranch(it,uri,target_uriStr)
			}
		return done
			
	}
	static void createFileNode (Proxy.Node parent,rPath,String filename, NodeLib.Field field, Boolean showFileExtension){
		if (parent==null){}
		else{
			def node=parent.createChild()
			String title
			Filename fn=new Filename(filename)
			if (showFileExtension) title=filename else title=filename-fn.dotExtension
			LinkLib link=new LinkLib(rPath, filename, title)
			link.setInNode(node,field)
		}
		}
	
	
	static getFileLinkStr (String uriStr,String title){ //TEST temp UITWERKEN
		String pathnameInline=uriStr.replace('file:/','file:///')
		URI uri = new URI(pathnameInline)//TEST temp moet dit ???????????????????????????????????????????
		String inlineLink=
			"<html><body> <p>"+
			'<a href="' + uri +'">'+title + '"></a>'
			"</p></body></html>"
		return inlineLink
		}
	
	static Proxy.Node getDirNodeInBranch(Proxy.Node node, String rPathnameNotSpace){
		Proxy.Node done=null
		
		// .find needs escaped round brackets to find in a text.
		Boolean b= ( rPathnameNotSpace!=""&&
			         ( (node.link!=null&&node.link.uri.toString()==rPathnameNotSpace)||
					    node.text.find('href="'+rPathnameNotSpace)
					 )
			       )
		
		if (rPathnameNotSpace!=""&&b) {done = node}
		else if (node.children!=null) node.children.each{
			if (done==null)	done= getDirNodeInBranch(it,rPathnameNotSpace)
			}
		return done
	}
	static Proxy.Node createDirNode(Proxy.Node parent, String rPath, String filename,  NodeLib.Field field, Boolean isIcon){
		Proxy.Node node=parent.createChild()
		LinkLib link=new LinkLib(rPath, filename, filename)
		link.setInNode(node,field)
		if (isIcon) node.icons.add(icon_folder)
		return node
	}
	
	static void setRootLink(){
		String title=directoryTitle//MapLib.dir_currentMap.name
		String link='<html><a href="./">'+title+'</a>'
		if (NodeLib.root.details==null) NodeLib.root.details=link
		else if (!NodeLib.root.details.find(link)) NodeLib.root.details=link+NodeLib.root.details
		NodeLib.root.hideDetails=true
	}

	
	
	static JCheckBox isDirectoryIcon
	static JCheckBox showFileExtension
	
	//static JPanel indexPanel
	static JPanel indexPanel
	static JComboBox locationLinkDirectoryCB
	static JComboBox locationLinkFileCB
	static JLabel locationLinkDirectoryLabel
	static JLabel locationLinkFileLabel
	static JLabel sortLabel
	static JComboBox sortCB
	static JLabel dvideRootLabel
	static JComboBox divisionRootCB
	static JCheckBox isDirectoryNodes
	
	static Boolean mapIsEmpty
	
	
		
	void initIndexPanel(){
		mapIsEmpty=MapLib.isNewMap
		
		indexPanel = new JPanel()
		indexPanel.setLayout(new BorderLayout());
		JPanel level0=new JPanel()
		indexPanel.add(level0,BorderLayout.NORTH)
		
	
		isDirectoryNodes=new JCheckBox(isDirectoryNodesTitle,true)
		level0.add(isDirectoryNodes)
		isDirectoryNodes.setVisible(false)
		
		isDirectoryIcon= new JCheckBox( isDirectoryIconTitle,true)
		level0.add(isDirectoryIcon)
		showFileExtension=new JCheckBox(showFileExtensionTitle)
		level0.add(showFileExtension)
		locationLinkDirectoryLabel=new JLabel(locationLinkDirectoryLabelTitle)
		level0.add(locationLinkDirectoryLabel)
		String[] location1=[NodeLib.toFieldTitle(NodeLib.Field.CORE),NodeLib.toFieldTitle(NodeLib.Field.ARROW)]
		locationLinkDirectoryCB = new JComboBox(location1)
		level0.add(locationLinkDirectoryCB)
		locationLinkDirectoryCB.selectedIndex=1
		
	JPanel level1=new JPanel()
		//indexPanel.add(level1,BorderLayout.CENTER)
		
		
		
		JPanel level2=new JPanel()
		sortLabel=new JLabel(sortLabelTitle)
		level2.add(sortLabel)
		String[] sort=[sortNONETitle,sortFOREWARDTitle,sortBACKWARDTitle]
		sortCB = new JComboBox(sort)
		if (MapLib.isNewMap) sortCB.selectedIndex=1 else sortCB.selectedIndex=0
		level2.add(sortCB)
		String[] division=[divisionRootRIGHTTitle,divisionRootRIGHTLEFTTitle,divisionRootLEFTRIGHTTitle,divisionRootMAPFILETitle,divisionRootFILEMAPTitle]
		divisionRootCB = new JComboBox(division)
		if (MapLib.isNewMap) divisionRootCB.selectedIndex=1 else divisionRootCB.selectedIndex=0
		level2.add(divisionRootCB)
		
		locationLinkFileLabel=new JLabel(locationLinkFileLabelTitle)
		level2.add(locationLinkFileLabel)
		String[] location3=[NodeLib.toFieldTitle(NodeLib.Field.CORE),NodeLib.toFieldTitle(NodeLib.Field.ARROW)]
		locationLinkFileCB = new JComboBox(location3)
		level2.add(locationLinkFileCB)
		indexPanel.add(level2,BorderLayout.CENTER)
	}
	
	void finishIndex(){
		setRootLink()
		NodeLib.root.text=MapLib.dir_currentMap.name
		NodeLib.foldAll(NodeLib.root)
		sortNodes(NodeLib.root, toSort(sortCB.selectedItem))
		if (NodeLib.root.children.size()>1) MapLib.divideRoot(toDivision(divisionRootCB.selectedItem))
	}
	void indexAction(){
		initIndexPanel()
		int result = JOptionPane.showConfirmDialog(null, indexPanel,dialogTitle, JOptionPane.OK_OPTION)
		if (result == JOptionPane.OK_OPTION) {
			ArrayList selecteds=NodeLib.selectedNodes
			doAll("", NodeLib.root, 
						NodeLib.toLocationField(locationLinkDirectoryCB.selectedItem),
						isDirectoryIcon.isSelected(), 
						showFileExtension.selected,
						NodeLib.toLocationField(locationLinkFileCB.selectedItem), 
						toSort(sortCB.selectedItem))
			finishIndex()
		}
	}
	
	MapLib.Division toDivision(String s){
		if (s==divisionRootRIGHTTitle) return MapLib.Division.RIGHT
		else if (s==divisionRootLEFTRIGHTTitle) return MapLib.Division.LEFTRIGHT
		else if (s==divisionRootRIGHTLEFTTitle) return MapLib.Division.RIGHTLEFT
		else if (s==divisionRootMAPFILETitle) return MapLib.Division.MAPFILE
		else if (s==divisionRootFILEMAPTitle) return MapLib.Division.FILEMAP
	}
	
	Sort toSort(String s){
		if (s==sortNONETitle) return Sort.NONE
		else if (s==sortFOREWARDTitle) return Sort.FOREWARD
		else if (s==sortBACKWARDTitle) return Sort.BACKWARD
	}
	String fromSort(Sort sort){
		if(sort==Sort.NONE) return sortNONETitle
		else if(sort==Sort.FOREWARD) return sortFOREWARDTitle
		else if(sort==Sort.BACKWARD) return sortBACKWARDTitle
	}
	
	static enum Sort{NONE,FOREWARD,BACKWARD}
	
	void sortNodes (Proxy.Node node, Sort direction){
		if (direction==Sort.NONE) {}
		else if (direction==Sort.FOREWARD) sortForeward(node)
		else if (direction==Sort.BACKWARD) sortBackward(node)
	}
	
	void sortForeward(Proxy.Node node){
		ArrayList list=node.children
		Collections.sort(list, new Foreward() )
			 Integer i=0
			 list.each{it.moveTo(node,i); i+=1}
			 }
	
	class Foreward implements Comparator<Proxy.Node>{
		
		  @Override
		int compare(Proxy.Node o1, Proxy.Node o2) {
			//println "compare $o1.plainText; $o2.plainText"
			
			Boolean i1=o1.icons.contains(icon_folder)
			Boolean i2=o2.icons.contains(icon_folder)
			Boolean similar= (i1==i2)
			if ((!i1&&i2)||(similar&&o1.plainText.toUpperCase()>o2.plainText.toUpperCase())) return 1
			else if ((i1&&!i2)||(similar&&o1.plainText.toUpperCase()<o2.plainText.toUpperCase())) return -1
			else return 0
		   }
	   }
	
	void sortBackward(Proxy.Node node){
		ArrayList list=node.children
		Collections.sort(list, new Backward() )
			 Integer i=0
			 list.each{it.moveTo(node,i); i+=1}
			 }
	
	class Backward implements Comparator<Proxy.Node>{
		
		@Override
		int compare(Proxy.Node o1, Proxy.Node o2) {
			Boolean i1=o1.icons.contains(icon_folder)
			Boolean i2=o2.icons.contains(icon_folder)
			Boolean similar= (i1==i2)
			if ((i1&&!i2)||(similar&&o1.plainText.toUpperCase()>o2.plainText.toUpperCase())) return -1
			else if ((!i1&&i2)||(similar&&o1.plainText.toUpperCase()<o2.plainText.toUpperCase())) return 1
			else return 0
		   }
	   }
	
	
}

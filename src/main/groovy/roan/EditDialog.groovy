package roan
//Author Jodi D.Krol 2014-06
import javax.swing.*

import org.freeplane.core.util.HtmlUtils
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer
import javax.swing.table.TableCellRenderer
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Font
import java.awt.GridLayout;
import java.awt.Component
//import javax.swing.JTextField
import java.awt.Dimension;
import org.freeplane.plugin.script.proxy.Proxy

import scriptlib.AThread
import scriptlib.MenuObject;
import scriptlib.Message
import scriptlib.NodeLib
import scriptlib.AButton
import scriptlib.ButtonWithPopUpMenu

public class EditDialog extends JPanel {
									
									
	static String toggleMenuStateIcon="redo.png"
									
	
	
	
	static final String titleAddActions=Message.textUtils.getText(
		"addons.roan.EditDialog.addActions",
		"Add actions"
		)
	static final String action=Message.textUtils.getText(
		"addons.roan.action",
		"Action"
		)
	static final String actionOnOpen=Message.textUtils.getText(
		"addons.roan.actionOnOpen",
		"Open"
		)
	
	static final String actionOnNext=Message.textUtils.getText(
		"addons.roan.actionOnNext",
		"Continue"
		)
	static final String actionOnBack=Message.textUtils.getText(
		"addons.roan.actionOnBack",
		"Back"
		)
	//*****
	
	
	static final String currentNodeTitle=Message.textUtils.getText(
		"addons.roan.currentNodeTitle",
		"Load from current node"
		)
	static final String currentNodeTitle_tooltip=Message.textUtils.getText(
		"addons.roan.currentNodeTitle_tooltip",
		"Load from selected node"
		)
	static final String pasteSelectedsTitle=Message.textUtils.getText(
		"addons.roan.pasteSelectedsTitle",
		"Paste to selected nodes"
		)
	
	static final String pasteCurrentTitle=Message.textUtils.getText(
		"addons.roan.pasteCurrentTitle",
		"Paste to curent node"
		)
	
	static final String pasteCurrentTitle_tooltip=Message.textUtils.getText(
		"addons.roan.pasteCurrentTitle_tooltip",
		"Current node is shown to the left."
		)
	
	static final String pasteSelectedsTitle_tooltip=Message.textUtils.getText(
		"addons.roan.pasteSelecteds_tooltip",
		"Paste to all selected nodes. Replace old."
		)
	
	static final String scriptLabelTitle=Message.textUtils.getText(
		"addons.roan.scriptLabelTitle",
		'Actions'
		)
	static final String scriptButtonOpenTitle=Message.textUtils.getText(
		"addons.roan.scriptButtonOpenTitle",
		'Open'
		)
	static final String scriptButtonContinueTitle=Message.textUtils.getText(
		"addons.roan.scriptButtonContinueTitle",
		'Continue'
		)
	static final String scriptButtonBackTitle=Message.textUtils.getText(
		"addons.roan.scriptButtonBackTitle",
		'Back'
		)
	
	////TOOLTIPS
	static final String currentNodeText_tooltip=Message.textUtils.getText(
		"addons.roan.currentNodeText_tooltip",
		"Node text of current node."
		)
	static final String toggleScriptButton_tooltip=Message.textUtils.getText(
		"addons.roan.toggleScriptButton_tooltip",
		"Toggle Open - Continue - Back states."
		)
	
	static final String scriptActions_tooltip=Message.textUtils.getText(
		"addons.roan.scriptActions_tooltip",
		"List of menu items. "
		)
	
	Proxy.Node currentNode
	JButton currentNodeButton
	JTextField currentNodeText
	JTextField scriptLabel
	ActionsField scriptActionsOnOpen
	JScrollPane scrollPaneOpen
	ActionsField scriptActionsOnContinue
	JScrollPane scrollPaneContinue
	ActionsField scriptActionsOnBack
	JScrollPane scrollPaneBack
	JButton pasteSelectedsButton
	JButton pasteCurrentButton
	AButton toggleScriptStateButton
	AButton fullScreenButton
	Data.State toggleScriptMode=Data.State.OPEN
	EditDialog current  //NOT static; workaround for  actionlistener
	JFrame frame
	ButtonWithPopUpMenu actionsButton
	//??static EditDialog getCurrent(){Controller.current.editDialogs[currentNode.id]}
	
	void toggleScriptStateAction(){
		if (toggleScriptMode==Data.State.OPEN) toggleScriptMode=Data.State.CONTINUE
		else if (toggleScriptMode==Data.State.CONTINUE) toggleScriptMode=Data.State.BACK
		else toggleScriptMode=Data.State.OPEN
		setToggleScriptStateButton()
	}
	 void setToggleScriptStateButton(){
		 if (toggleScriptMode==Data.State.OPEN){
			  toggleScriptStateButton.text=scriptButtonOpenTitle
			  scrollPaneOpen.setVisible(true)
			  scrollPaneContinue.setVisible(false)
			  scrollPaneBack.setVisible(false)
			  }
		 else if (toggleScriptMode==Data.State.CONTINUE){
			 toggleScriptStateButton.text=scriptButtonContinueTitle
			 scrollPaneOpen.setVisible(false)
			 scrollPaneContinue.setVisible(true)
			 scrollPaneBack.setVisible(false)
		 }
		 else {
			 toggleScriptStateButton.text=scriptButtonBackTitle
			 scrollPaneOpen.setVisible(false)
			 scrollPaneContinue.setVisible(false)
			 scrollPaneBack.setVisible(true)
		 }
	 }
	
	 void setStartMenuMode(){ //priority to state with content
		 toggleScriptMode=Data.State.OPEN
		 if (scriptActionsOnOpen.text=="" &&
		 	 scriptActionsOnContinue.text!="") toggleScriptMode=Data.State.CONTINUE else if (scriptActionsOnBack.text!="") toggleScriptMode=Data.State.BACK
		 // println "....TEST toggleMenuMode=$toggleMenuMode"
		 
		  setToggleScriptStateButton()
	 }
	 
	public EditDialog() {
		//super();
		current=this
		currentNode=NodeLib.selectedNode()
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS))
		JPanel top=new JPanel()
		JPanel middle=new JPanel()
		//must be first, to prevent null error
		JPanel bottom=new JPanel()
		//setLayout(new BoxLayout(bottom, BoxLayout.PAGE_AXIS))
		Integer width=35
		def italic = new Font("Arial", Font.ITALIC, 16);
		def fontSize = new Font("Arial", Font.PLAIN, 16);
		scriptLabel=new JTextField(scriptLabelTitle, 7)
		scriptLabel.setFont(italic)
		scriptLabel.setEditable(false)
		
		JPanel scriptLabels=new JPanel()
		scriptLabels.setLayout(new BoxLayout(scriptLabels, BoxLayout.PAGE_AXIS))
		//scriptLabels.add(scriptLabel, BorderLayout.NORTH)
		toggleScriptStateButton=new AButton(toggleMenuStateIcon,toggleScriptButton_tooltip, {   toggleScriptStateAction() })
		scriptLabels.add(toggleScriptStateButton,BorderLayout.CENTER)
		middle.add(scriptLabels,BorderLayout.EAST);
		
		actionsButton=new scriptlib.ButtonWithPopUpMenu(titleAddActions)
		actionsButton.invoker=this
		def actions=ActionRegister.current.actionsList
		actions.each{ it([]).setMenu(this)}
		middle.add(actionsButton,BorderLayout.WEST);
		
		
		
		 Integer height=10
		scriptActionsOnOpen= new ActionsField(height, width);
		scriptActionsOnOpen.setFont(fontSize)
		scrollPaneOpen = new JScrollPane(scriptActionsOnOpen);
		scriptActionsOnOpen.setEditable(true);
		scriptActionsOnOpen.toolTipText=scriptActions_tooltip
		bottom.add(scrollPaneOpen,BorderLayout.SOUTH);
		
		scriptActionsOnContinue= new ActionsField(height, width);
		scriptActionsOnContinue.setFont(fontSize)
		scrollPaneContinue = new JScrollPane(scriptActionsOnContinue);
		scrollPaneContinue.setVisible(false);
		scriptActionsOnContinue.toolTipText=scriptActions_tooltip
		bottom.add(scrollPaneContinue,BorderLayout.CENTER);
		
		scriptActionsOnBack= new ActionsField(height, width);
		scriptActionsOnBack.setFont(fontSize)
		scrollPaneBack = new JScrollPane(scriptActionsOnBack);
		scriptActionsOnBack.setEditable(true);
		scriptActionsOnBack.toolTipText=scriptActions_tooltip
		bottom.add(scrollPaneBack,BorderLayout.SOUTH);
		scrollPaneBack.setVisible(false);
		
		currentNodeButton=new JButton(currentNodeTitle)
		currentNodeButton.toolTipText=currentNodeTitle_tooltip
		top.add(currentNodeButton,BorderLayout.NORTH)
		currentNodeText=new JTextField(HtmlUtils.htmlToPlain(currentNode.text),15)
		currentNodeText.setEditable(false)
		currentNodeText.setToolTipText(currentNodeText_tooltip)
		currentNodeText.setCaretPosition(0)
		top.add(currentNodeText,BorderLayout.SOUTH)
		add(top,BorderLayout.NORTH)
		add(middle,BorderLayout.CENTER)
		add(bottom,BorderLayout.SOUTH)
		EditDialog current=this
		
		currentNodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{   
				Proxy.Node selected=NodeLib.selectedNode
				current.loadCurrentNodeAction();
			   }
		});
	
		pasteCurrentButton=new JButton(pasteCurrentTitle)
		pasteCurrentButton.toolTipText=pasteCurrentTitle_tooltip
		top.add(pasteCurrentButton,BorderLayout.SOUTH)
		pasteCurrentButton.addActionListener(new ActionListener() {
			
					   public void actionPerformed(ActionEvent e)
					   {
						   current.pasteActionsFieldToNode(currentNode)
					   }
				   });
	
	
	pasteSelectedsButton=new JButton(pasteSelectedsTitle)
	top.add(pasteSelectedsButton,BorderLayout.SOUTH)
	pasteSelectedsButton.toolTipText=pasteSelectedsTitle_tooltip
	pasteSelectedsButton.addActionListener(new ActionListener() {
		
				   public void actionPerformed(ActionEvent e)
				   {
					   current.pasteActionsToSelectedNodes()
				   }
			   });
		   
	
	add(bottom,BorderLayout.SOUTH)
	loadCurrentNodeAction()
	
}
	
	void pasteActionsToSelectedNodes(){
		def selecteds=NodeLib.selectedNodes
		selecteds.each{pasteActionsFieldToNode(it) }
	}
	
	
	void pasteActionsFieldToNode(Proxy.Node node){
		
		node.attributes.removeAll(Node.Attr.ACTIONS_O.val)
		ArrayList a1= actionNodeStrs((ArrayList) scriptActionsOnOpen.getText().split("\\n"))
		String aStr=""
		a1.each{if (it!="") {if (aStr=="") aStr=it else aStr+=";"+it}}
		if (aStr!="") node.attributes.add(Node.Attr.ACTIONS_O.val, (aStr))
		
		aStr=""
		node.attributes.removeAll(Node.Attr.ACTIONS_C.val)
		a1= actionNodeStrs((ArrayList) scriptActionsOnContinue.getText().split("\\n"))
		a1.each{if (it!="") {if (aStr=="") aStr=it else aStr+=";"+it}}
		if (aStr!="") node.attributes.add(Node.Attr.ACTIONS_C.val, (aStr))
		
		aStr=""
		node.attributes.removeAll(Node.Attr.ACTIONS_B.val)
		a1= actionNodeStrs((ArrayList) scriptActionsOnBack.getText().split("\\n"))
		a1.each{if (it!="") {if (aStr=="") aStr=it else aStr+=";"+it}}
		if (aStr!="") node.attributes.add(Node.Attr.ACTIONS_B.val, (aStr))
		
		clearChanged()
		
	}
	
	void loadActionsFieldFromNode(Proxy.Node node){
			Data.State col
			(Data.State.OPEN..Data.State.BACK).each{col=it
				Actions actions=Node.getActions(node,col)
				actionsToActionsField(actions,col)
				
			}
	}
	
	void clearChanged(){
		scriptActionsOnBack.setBackground(Color.WHITE)
		scriptActionsOnOpen.setBackground(Color.WHITE)
		scriptActionsOnContinue.setBackground(Color.WHITE)
	}
	
	void actionsToActionsField(Actions actions, Data.State col){
		if (actions!=null){
			if(col==Data.State.OPEN)  {scriptActionsOnOpen.setText(multilineText(actions)) ;scriptActionsOnOpen.clearBackground()}
			else if (col==Data.State.CONTINUE) {scriptActionsOnContinue.setText(multilineText(actions)); scriptActionsOnContinue.clearBackground()}
			else if (col==Data.State.BACK) {scriptActionsOnBack.setText(multilineText(actions)) ; scriptActionsOnBack.clearBackground()}
		}
	}

	//////////////////////////////////////////////////////////////
	
	String multilineText(Actions actions){
		if (actions==null) return ""
		String s=""
		actions.store.each{ Action a=it
			if (s=="") s=a.action_translatedStr
			else s+="\n"+a.action_translatedStr
			}
		return s
		}
	 
		public void actionPerformed(ActionEvent event) {
			//String command = event.getActionCommand();
		}
	
	ArrayList actionNodeStrs(ArrayList translatedStrs){
		ArrayList r=[]
		translatedStrs.each{
			def a= new Action().setAction_translatedStr(it)
			if (a!=null) r+=[new Action().setAction_translatedStr(it).nodeStr]
		}
		return r
	}
	
	void createAndShowGUI(Proxy.Node node) {
		//Disable boldface controls.
		UIManager.put("swing.boldMetal", Boolean.FALSE);
 
		//Create and set up the window.
		frame = new JFrame(Translate.editTitle);
		frame.setAlwaysOnTop(true)
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
		//Create and set up the content pane.
		EditDialog newContentPane = new EditDialog();
		newContentPane.setOpaque(true); //content panes must be opaque
		frame.setContentPane(newContentPane);
 
		//Display the window.
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	}
	
	
	void finish(EditDialog ed){
		if(ed!=null&&ed.frame!=null){
			ed.frame.setVisible(false)
			ed.frame.dispose()
		}
		}
	
	
	static Map editDialogs=Controller.current.editDialogs
	
	void finishEditDialogs(){
		editDialogs.each{key,val-> finish(val)}
	}	
	
	void open(Proxy.Node node){
		EditDialog currentEd=editDialogs[node.id]
		if(currentEd!=null) { // only one pro node; toggle open/close
			finish(currentEd); 
			editDialogs.remove(node.id)
			} 
		else{
			loadActionsFieldFromNode(currentNode)
			createAndShowGUI(node)
			editDialogs[node.id]=this
		}
		}
	
	void loadCurrentNodeAction(){
		Proxy.Node selected=NodeLib.selectedNode()
		current.clearMenuFields()
		if (currentNode!=selected){ //switch
		EditDialog currentED=Controller.current.editDialogs[currentNode.id]
		Controller.current.editDialogs.remove(currentNode.id)
		currentNode=selected
		Controller.current.editDialogs[currentNode.id]=currentED
		}
		
		currentNodeText.text=   HtmlUtils.htmlToPlain(currentNode.text)
		currentNodeText.setCaretPosition(0)
		current.loadActionsFieldFromNode(currentNode)
	
		setStartMenuMode() // detrmins if Open, Continue or Back field is showing first
		}
	
	void clearMenuFields(){
		scriptActionsOnOpen.text=""
		scriptActionsOnOpen.clearBackground()
		scriptActionsOnContinue.text=""
		scriptActionsOnContinue.clearBackground()
		scriptActionsOnBack.text=""
		scriptActionsOnBack.clearBackground()
	}
	
	ActionsField getCurrentScriptActionsField(){
	if (scrollPaneOpen.visible) return scriptActionsOnOpen
	else if (scrollPaneContinue.visible) return scriptActionsOnContinue
	else if (scrollPaneBack.visible) return scriptActionsOnBack
	}
	
	void addScripActionStr(String r){
		def scriptActions=currentScriptActionsField
		if (scriptActions.text=="") scriptActions.text=r
		else scriptActions.setText( scriptActions.text+"\n"+r)
	}
}

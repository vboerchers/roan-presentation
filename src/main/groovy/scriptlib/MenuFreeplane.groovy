package scriptlib
//Author Jodi D Krol 2013-01
//overgenomen van RobotControllerRoan.current.animator.recordMenu; controleren
import org.freeplane.core.util.MenuUtils

import groovy.lang.Closure;
import java.awt.Point
import java.util.ArrayList;
import java.awt.MouseInfo
import javax.swing.SwingUtilities


import org.freeplane.plugin.script.proxy.Proxy;

class MenuFreeplane{
	protected static String 	EXECUTE_MENU_ACTION 		= "EMA" // FREEPLANE MENU
	static ArrayList			actions 	=[EXECUTE_MENU_ACTION]
	protected String 	    	action
	protected String            menuActions_String
	ArrayList 					menuActions_List =[]
	Integer 					postDelay
	
	static Map shortCuts =[
						PresentationMode		:["SetBooleanPropertyAction.presentation_mode"],
						ShowAttributes 			:["ShowAllAttributesAction"],
						HideAttributes			:["HideAllAttributesAction"],
						ToggleAttributeIcon     :["SetBooleanMapPropertyAction.show_icon_for_attributes"],
		
						Root                	:["MoveToRootAction"],
						CenterMap				:["Root","FoldAll","CenterNode"],
						CloseMap				:["CloseAction"],
						CenterNode				:["CenterSelectedNodeAction"],
						FoldAll					:["FoldAllAction"],
						UnfoldAll				:["UnfoldAllAction"],
						FoldOneLevel            :["FoldOneLevelAction"],
						UnfoldOneLevel          :["UnfoldOneLevelAction"],
						ShowNextChild			:["ShowNextChildAction"],

						Undo					:["UndoAction"],
						Redo					:["RedoAction"],
						
						Find   					:["QuickFindAction.FORWARD"],
						FindBack				:["QuickFindAction.BACK"],
						FindAll					:["QuickFindAllAction"],
						
						// May interfere with proper functioning of PAGE and SHOW; see Record_Page: automatic undo
						Filter					:["QuickFilterAction"],
						Filter_Undo				:["UndoFilterAction"],
						Filter_Redo				:["RedoFilterAction"],
						Filter_Stop				:["ApplyNoFilteringAction"], //see Record_Page for better alternative
						Filter_Edit       		:["EditFilterAction"],
						Filter_ShowVisble		:["ApplyToVisibleAction"],
						Filter_ShowAncestors	:["ShowAncestorsAction"],
						Filter_ShowDescendants	:["ShowDescendantsAction"],
						Filter_UnfoldRoot       :["Root","UnfoldAll","CenterNode"], // workaround to undo folsAll afer filter
						
						Quit                    :["QuitAction"]
						]
	
	static final Closure possibleAction={it in actions}
	static Closure values_ListOfMenuActions={it.findAll(/(\w+)/)}
	
		 
	 String toString(){ return "Menu[action=$action, menu actions=$menuActions_String, delay=$postDelay]"}
	 
	 String toEventString(){ "$action:$menuActions_String,$postDelay"}
	 
	 static void executeMenuActions_invokeAndWait (ArrayList mnemonics){
		 def items =new Menu_private().formattedActions(mnemonics)
		 SwingUtilities.invokeAndWait(new Runnable(){
			 public void run(){
				 MenuUtils.executeMenuItems(items)
			 }})
	 }
	 
	 static void executeMenuActions (ArrayList mnemonics){
		 def items =new Menu_private().formattedActions(mnemonics)
		 
		// SwingUtilities.invokeLater(new Runnable(){
		//	 public void run(){
				 MenuUtils.executeMenuItems(items)
		//	 }})
	 }
	 
	 static void invoke_executeMenuActions (ArrayList mnemonics){
		 def items =new Menu_private().formattedActions(mnemonics)
		 if (items!=null&&items!=[]){
			 SwingUtilities.invokeAndWait(new Runnable(){
				 public void run(){
					 MenuUtils.executeMenuItems(items)
				 }})
		 }
	 }
	 static void executeMenuActions_Raw (ArrayList mnemonics){
		 def items =new Menu_private().formattedActions(mnemonics)
		 if (items!=null&&items!=[]){
			 MenuUtils.executeMenuItems(items)
		 }
	 }
		  
	  
	 static class Menu_private{
		 private ArrayList menuActionsPrivate=[]
		 private int i=0
		 private String menuActionFormat(String menuAction) {
			 menuAction=(menuAction-"-X").trim() 
			 if (menuAction=="") return null
			 else return menuAction
			 }
	 
		 ArrayList formattedActions(ArrayList menuActions){
			 formattedMenuActions(menuActions)
			 return menuActionsPrivate
			 }
		 
		 void formattedMenuActions(ArrayList menuActions){
			 menuActions.each{
				 it-="-X" // in case copied with developer tools
				 if (shortCuts.containsKey(it)) {formattedMenuActions(shortCuts[it])}
				 else { def r=menuActionFormat(it); if(r!=null){  menuActionsPrivate[i]=r; i+=1}}
			 }
		 }
	 }
}

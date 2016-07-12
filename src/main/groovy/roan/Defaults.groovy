package roan
//Author Jodi D.Krol 2014-07
import org.freeplane.plugin.script.proxy.Proxy;
import org.freeplane.core.util.HtmlUtils
import scriptlib.Preferences
import scriptlib.NodeLib

class Defaults {
	static Defaults current=new Defaults()
	private Actions defaultActions
	Boolean centerOnOpen=null
	Boolean detailsOnOpen=null
	Boolean detailsOnContinue=null
	Boolean detailsOnBack=null
	Boolean foldOnOpen=null
	Boolean foldOnContinue=null
	Boolean foldOnBack=null
	Integer delayOnOpen=null
	Integer delayOnContinue=null
	Integer delayOnBack=null
	
	//**** On open/max menu
	static final Boolean onOpenMaxMenu_screenModeMaxOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMaxMenu.screenModeMaxOff",
		true
	)
	static final Boolean onOpenMaxMenu_greyBackgroundOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMaxMenu.greyBackgroundOff",
		false
	)
	static final Boolean onOpenMaxMenu_tooltipsOn=Preferences.getBooleanProp(
		"addons.roan.onOpenMaxMenu.tooltipsOn",
		true
	)
	static final Boolean onOpenMaxMenu_attributesOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.attributesOff",
		true
	)
	static final Boolean onOpenMaxMenu_attributesIconOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMaxMenu.attributesIconOff",
		true
	)
	//***** On minimize menu
	static final Boolean onOpenMinMenu_screenModeMaxOn=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.screenModeMaxOn",
		true
	)
	static final Boolean onOpenMinMenu_greyBackgroundOn=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.greyBackgroundOn",
		false
	)
	static final Boolean onOpenMinMenu_tooltipsOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.tooltipsOff",
		false
	)
	static final Boolean onOpenMinMenu_attributesOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.attributesOff",
		true
	)
	static final Boolean onOpenMinMenu_attributesIconOff=Preferences.getBooleanProp(
		"addons.roan.onOpenMinMenu.attributesIconOff",
		true
	)
	//****** On close menu
	static final Boolean onCloseMenu_screenModeMaxOff=Preferences.getBooleanProp(
		"addons.roan.onCloseMenu.screenModeMaxOff",
		true
		)
	static final Boolean onCloseMenu_greyBackgroundOff=Preferences.getBooleanProp(
		"addons.roan.onCloseMenu_greyBackgroundOff",
		true
	)
	static final Boolean onCloseMenu_tooltipsOn=Preferences.getBooleanProp(
		"addons.roan.onCloseMenu.tooltipsOn",
		false
	)
	static final Boolean onCloseMenu_attributesOn=Preferences.getBooleanProp(
		"addons.roan.onCloseMenu_attributesOn",
		false
	)
	static final Boolean onCloseMenu_attributesIconOn=Preferences.getBooleanProp(
		"addons.roan.onCloseMenu_attributesIconOn",
		false
	)
	//****** On play
	static final Boolean onPlay_screenModeMaxOn=Preferences.getBooleanProp(
		"addons.roan.onPlay.screenModeMaxOn",
		true
		)
	
	static final Boolean onPlay_greyBackgroundOn=Preferences.getBooleanProp(
		"addons.roan.onPlay.greyBackgroundOn",
		true
		)
	static final Boolean onPlay_tooltipsOff=Preferences.getBooleanProp(
		"addons.roan.onPlay.tooltipsOff",
		true
	)
	static final Boolean onPlay_attributesOff=Preferences.getBooleanProp(
		"addons.roan.onPlay_attributesOff",
		true
	)
	static final Boolean onPlay_attributesIconOff=Preferences.getBooleanProp(
		"addons.roan.onPlay_attributesIconOff",
		true
	)
	
	
	//*** On finish play
	static final Boolean finishPlay_screenModeMaxOff=Preferences.getBooleanProp(
		"addons.roan.finishPlay.screenModeMaxOff",
		true
		)
	
	static final Boolean finishPlay_greyBackgroundOff=Preferences.getBooleanProp(
		"addons.roan.finishPlay.greyBackgroundOff",
		true
		)
	static final Boolean finishPlay_tooltipsOn=Preferences.getBooleanProp(
		"addons.roan.finishPlay.tooltipsOn",
		false
	)
	static final Boolean finishPlay_attributesOn=Preferences.getBooleanProp(
		"addons.roan.finishPlay_attributesOn",
		false
	)
	static final Boolean finishPlay_attributesIconOn=Preferences.getBooleanProp(
		"addons.roan.finishPlay_attributesIconOn",
		false
	)
	
	Defaults(){
		Data data=new Data(NodeLib.root)
		
		//center
		Actions actionsWithType=data.actionsOpen.actionsWithClass(Action_Center)
		if (!actionsWithType.isEmpty) {Action_Center centerAction=actionsWithType.store[0]; centerOnOpen= centerAction.isON}
		if (centerOnOpen==null) centerOnOpen=true
		
		//details
		actionsWithType=data.actionsOpen.actionsWithClass(Action_DetailsVisibility)
		if (!actionsWithType.isEmpty) {Action_DetailsVisibility detailsAction=actionsWithType.store[0]; detailsOnOpen= detailsAction.isON}
		if (detailsOnOpen==null) detailsOnOpen=true
		
		actionsWithType=data.actionsContinue.actionsWithClass(Action_DetailsVisibility)
		if (!actionsWithType.isEmpty) {Action_DetailsVisibility detailsAction=actionsWithType.store[0]; detailsOnContinue= detailsAction.isON}
		if (detailsOnContinue==null) detailsOnContinue=false
		
		actionsWithType=data.actionsBack.actionsWithClass(Action_DetailsVisibility)
		if (!actionsWithType.isEmpty) {Action_DetailsVisibility detailsAction=actionsWithType.store[0]; detailsOnBack= detailsAction.isON}
		if (detailsOnBack==null) detailsOnBack=false
		
		
		//folding
		Action_Folding foldingAction
		actionsWithType=data.actionsOpen.actionsWithClass(Action_Folding)
		if (!actionsWithType.isEmpty) {
			foldingAction=actionsWithType.store[0]
			if (foldingAction.isFold) foldOnOpen=true
			else if (foldingAction.isUnfold) foldOnOpen=false
			else foldOnOpen=true
		}
		else foldOnOpen=true
		
		actionsWithType=data.actionsContinue.actionsWithClass(Action_Folding)
		if (!actionsWithType.isEmpty) {
			foldingAction=actionsWithType.store[0]
			if (foldingAction.isFold) foldOnContinue=true
			else if (foldingAction.isUnfold) foldOnContinue=false
			else foldOnContinue=null
		} else foldOnContinue=null
		
		actionsWithType=data.actionsBack.actionsWithClass(Action_Folding)
		if (!actionsWithType.isEmpty) {
			foldingAction=actionsWithType.store[0]
			if (foldingAction.isFold) foldOnBack=true
			else if (foldingAction.isUnfold) foldOnBack=false
			else foldOnBack=true
		} else foldOnBack=true
		
	
	//delay
	actionsWithType=data.actionsOpen.actionsWithClass(Action_Delay)
	if (!actionsWithType.isEmpty){
		Action_Delay delayAction=actionsWithType.store[0];
		delayOnOpen= delayAction.delayStr
		}
	
	actionsWithType=data.actionsContinue.actionsWithClass(Action_Delay)
	if (!actionsWithType.isEmpty){
		Action_Delay delayAction=actionsWithType.store[0];
		delayOnContinue= delayAction.delayStr
		}
	
	actionsWithType=data.actionsBack.actionsWithClass(Action_Delay)
	if (!actionsWithType.isEmpty){
		Action_Delay delayAction=actionsWithType.store[0];
		delayOnBack= delayAction.delayStr
		}
	}
	
	// root=default
	// if default null...
	// if if default !=null
	//see Node for setDelatMs
	static Integer getDelayMs(Proxy.Node node, Data.State state){
		if (state==Data.State.OPEN) return delayOnOpenMs(node)
		else if (state==Data.State.CONTINUE) delayOnContinueMs(node)
		else if (state==Data.State.BACK) delayOnContinueMs(node)
	}
	static Integer delayOnOpenMs(Proxy.Node node){
		String e= current.delayOnOpen
		Integer r
		if (e==null||e=="") r= (length(node) * 17) +Controller.delay_defaultMs_private //scaled
		else r= (length(node)*e.toInteger() *4) +Controller.delay_defaultMs_private //scaled
		return r
	}
	
	static Integer delayOnContinueMs(Proxy.Node node){
		String e= current.delayOnContinue
		Integer r
		if (e==null||e=="")  r= null // default null
		else  r= e.toInteger() * 1000 // absolute ms
		return r
	}
	
	
	static String plain(Proxy.Node node){
		return HtmlUtils.htmlToPlain(node.text)
	}
	
	static Integer length(Proxy.Node node){
		Integer length
		if (node.details==null){
			String text=HtmlUtils.htmlToPlain(node.text)
			length=text.length()
		}
		else {
			String text=node.details
			text=HtmlUtils.htmlToPlain(text)
			length=text.length()
		}
		return length
	}
	
}

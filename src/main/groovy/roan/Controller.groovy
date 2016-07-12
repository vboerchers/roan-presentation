package roan
//Author Jodi D.Krol 2014-06
import javax.swing.JFrame

import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib
import scriptlib.Globals
import scriptlib.MapLib
import scriptlib.StyleLib
import scriptlib.AThread
import scriptlib.MenuFreeplane
import scriptlib.Message
import scriptlib.AClipboard
import scriptlib.WindowLib
import javax.swing.SwingUtilities
import scriptlib.Help
import scriptlib.Preferences
import scriptlib.StringLib
import scriptlib.FilterLib


class Controller {
	
	static Integer autoZoomMax_preference=Preferences.getIntegerProp(
		"addons.roan.whilePlay.autoZoomMax",
		150
		)

	static Integer autoZoomMin_preference=Preferences.getIntegerProp(
		"addons.roan.whilePlay.autoZoomMin",
		100
		)
	static Integer windowWidth_preference=Preferences.getIntegerProp(
		"addons.roan.windowWidth",
		1200
		)
	static Integer windowHeight_preference=Preferences.getIntegerProp(
		"addons.roan.windowHeight",
		750
		)
	
	static Boolean cyclePlay=Preferences.getBooleanProp(
		"addons.roan.whilePlay.cycle",
		true
		)
	static Boolean parentPlay=Preferences.getBooleanProp(
		"addons.roan.whilePlay.all",
		true
		)
	static Boolean slow=Preferences.getBooleanProp(
		"addons.roan.whilePlay.slowMove",
		true
		)
	static Boolean doFilter_preference=Preferences.getBooleanProp(
		"addons.roan.whilePlay.doFilter",
		false
		)
	
	static Boolean doAutoZoom_preference=Preferences.getBooleanProp(
		"addons.roan.whilePlay.doAutoZoom",
		false
		)
	
	String getState(){
		return "state[debug=$debug, mode=$mode, doFilter=$doFilter, isFilter=$isFilter, isLoop=$isLoop, isNodeUnfoldAndStop=$isNodeUnfoldAndStop;firtsStep=$firstStep]"
	}
	static Boolean debug=false
	
	Boolean isFilter=false
	Boolean doFilter=doFilter_preference
	Boolean playThread=false
	Boolean isLoop=false
	Boolean isNodeUnfoldAndStop=false
	Boolean isCycle=true// Preference...
	Proxy.Node playStart=null
	Boolean pauseState=false
	Boolean skipDelay=false
	Boolean doAutoZoom=doAutoZoom_preference
	Mode mode=null
	Boolean skipCenter=false
	Boolean isScenario=false
	
	def editDialogs=[:]
	
	static Controller current
	static org.freeplane.plugin.script.proxy.Proxy.Controller c
	static enum Mode{STEP,PLAY,PAUSE,STOP}
	
	static Integer delay_defaultMs_private=2500
	
	Boolean saveSliderInNode=false //use in slider; workaround
	JFrame menuFrame=null
	
	static String system="roan-p"
	static String inited="inited"
	//static String isMenu="isMenu"
	static String tooltipOff="tooltipOff"
	static String version="v0.1.0"
	Boolean inited_private=false
	Boolean isRedoPrevious=false
	Boolean isLoadConditions=false
	Boolean isConditionWithNameFilter=false
	
	void init(){
		Integer versionScriptlib=2014090601
		scriptlib.Version.check(versionScriptlib)
		Boolean isLoadConditions=false// case other map
		firstStep=true//also for play
		if(isNewerVersion()) NodeLib.root[system]=inited+","+version
		
		if (!isInited) {
				NodeLib.root[system]=inited+","+version
				Message.plainMessage(Translate.initMessage)
				NodeLib.root.link.uri=new URI('menuitem:_$addons.roan.presentation_menuAction_on_single_node$0')
				inited_private=true
		}
		
		else if(!inited_private){
			NodeLib.root[system]=inited+","+version
			inited_private=true
		}
	}
	
	Boolean isNewerVersion(){
		String v=NodeLib.root[system]; 
		if(v!=null ) {v-= inited+","}
		if (v!=null&&version > v && 
			Message.confirm("This map has an old data structure. Load a new version or convert it.\n"+
				            "Proceding will automatically convert so-called three-state presentation actions\n"+ 
							"for çenter, show children, show details etc. Nodes with presentation actions\n"+
							"which cannot be converted get a warning triangle. You must redefine these by hand.\n"+
							"For example, actions which execute freeplane menu items are not converted.\n"+
							"N.B Node attributes 'menu' can be deleted once you defined them new. Besides\n"+
							"many menu actions are now available as regualr actions, see 'Add actions.'\n"+
							"Save after conversion to prevent this message in the future.\n"+
							"Continue with automatic conversion ?"))
			{roan.Node.convert(); return true}
			else return false
	}
	
	/////
	static String CURRENTNODE="roan-currentNode"
	
	void invoke_setCurrentNodeInRoot(Proxy.Node node){
		SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){
				current.setCurrentNodeInRoot(node)
				}})
		}
	void setCurrentNodeInRoot(Proxy.Node node) {
		NodeLib.root[CURRENTNODE]=node.id
	}
	Proxy.Node getCurrentNodeInRoot(){
		String id=NodeLib.root[CURRENTNODE]
		if (id==null) return null
		else return NodeLib.nodeForId(id)
	}
	
	void invoke_initCurrentNodeInRoot(){
	SwingUtilities.invokeAndWait(new Runnable(){
		public void run(){
			current.initCurrentNodeInRoot()
			}})
	}
	
	void initCurrentNodeInRoot(){
		NodeLib.root[CURRENTNODE]=""
	}
	Boolean getIsCurrentNodeInRoot(){
		return (getCurrentNodeInRoot()!=null)
	}
	Proxy.Node getCurrentNodeInRootAndInit(){
		String id=NodeLib.root[CURRENTNODE]
		if(id==null||id=="") return null
		else{
			NodeLib.root[CURRENTNODE]=""
		    return NodeLib.nodeForId(id)
		}
	}
	
	////
	
	
	//*** continue states
	Boolean isStopData(Data data)  {return data.isStop}
	Boolean isContinue(Data data){Boolean b=data.isStop; return (mode==Mode.STEP||b==null)}
	Boolean isStop(Data data){ 
		return data.isStop
		}
	Boolean isBounce(Data data){
		return data.isBounce
		}
	
	Controller (org.freeplane.plugin.script.proxy.Proxy.Controller c){
		this.c=c
		this.current=this
		def globals=scriptlib.Globals.current.init(c,null) //HERZIEN??
		if (Menu.current==null) def dummy=new Menu()
		Filter.loadConditions()
	}

Data getData(Proxy.Node node, Data currentData){
	Data newData= new Data(node)
	
	if (currentData!=null){
		 newData.history.add(currentData)
	}
	return newData
}

static void doDelay(Data data,Data.State state){
	Proxy.Node node=data.node
	Integer delay=data.delay(state)
	if (delay==null) delay=Defaults.current.getDelayMs(node,state)
	if (delay!=null){
		Menu.current.slider.delay=delay
		Menu.current.progress.progress=delay
		Integer count=delay/100
		while(count>0&&Controller.current.mode!=Mode.STOP&&!Controller.current.skipDelay){
			AThread.sleep(100)
			Menu.current.progress.setProgress(count*100)
			count-=1
			}
		Controller.current.skipDelay=false
		//if (Controller.current.filter&&Controller.current.mode!=Mode.STEP) Record_Page.stopFilter()
	}		
}


void doOpen(Data data){
	Proxy.Node node=data.node
	String nodeStr=StringLib.left(node.text,10)
	if(Controller.debug) {println "DEBUG:+doOpen $nodeStr; "+ Controller.current.state}
	if (firstStep) firstStep=false 
	setStateAndDelay(data, Data.State.OPEN)
	if (mode==Mode.STEP) mode=Mode.STOP
	Audio.current.finish(node,Data.State.OPEN) //.avi plays as long as delay
	doContinue(data)
}

void continueStep(Data data){mode=Mode.STEP; doContinue(data)}
void continuePlay(Data data){mode=Mode.PLAY; doContinue(data)}
void continueBack(Data data){mode=Mode.PLAY; def d=doBack(data)}

Boolean firstStep=true // gets false in doOpen
static String leftStr(Proxy.Node node){return StringLib.left(Node.plain(node),10)}

Boolean getIsBacktracking(){return isLoop&&firstStep}

Data dataCheckFiltering(Data data){ //if filter, find filter node in root
	
		def node=currentNodeInRoot //overrule
		if (node==null) return data
		else return getData(node,null)
}

void doContinue(Data data){  // called by mouseclick or by doOpen
	dataCheckFiltering(data) //TEST new
	assert(data!=null):"ERROR data null"
	Proxy.Node node=data.node
	String nodeStr=leftStr(node)
	Boolean isNodeOpen=false 
	
	
	if(Controller.debug){ println".";println "DEBUG: +doContinue $nodeStr; "+ state} 
	
	if(mode==Mode.STOP){if (Controller.debug) "DEBUG: doContinue mode=STOP"}
	else if(isNodeUnfoldAndStop){ 
		if(Controller.debug) println "DEBUG: doContinue isUnfolAndStop "
		mode=Mode.STOP
		doOpen(data)
		}
	else if(isBacktracking) {
		 if(Controller.debug) println "DEBUG:doContinue isBacktracking $nodeStr; "+ state
		 isLoop=false;firstStep=false;
		doOpen(data)
		 } 
	 else{
	 Data.State state=Data.State.CONTINUE
	 
	 if(Controller.debug) println "DEBUG: doContinue isContinue >>>> $nodeStr; "+ state
	
	 Boolean isStop=isStop(data)
	 Boolean isBounce=isBounce(data)
	 
	 if(firstStep||mode!=Mode.STOP){ //state && delay
		if (Controller.debug) "DEBUG: doContinue state and delay; isStop=$isStop; isBounce=$isBounce"
		
		if (isStop&& mode!=Mode.STEP&&!firstStep) mode=Mode.STOP
		Proxy.Node root=NodeLib.root
		
		if(node==root||mode==Mode.STEP){
			if (!data.isScenario&&node.details!=null&&node.hideDetails==true){
				setStateAndDelay(data,Data.State.OPEN); //if(Controller.debug) println"DEBUG: doContinue set step/root state open"
				isNodeOpen=true
				
				}
				else if (node.details==null||(node.details!=null&&node.hideDetails==false)){
				setStateAndDelay(data,Data.State.CONTINUE); //if(Controller.debug) println"DEBUG: doContinue set step/root state continue"
				if(mode==Mode.STOP){if (Controller.debug) "DEBUG: doContinue Finished state and delay1"}
				}
		}
		else if(!isBounce&&mode!=Mode.STOP){ //continue, not root
			if(Controller.debug){println"DEBUG: $nodeStr; set state, delay and audio "+ state}
			setStateAndDelay(data, state);
		    Audio.current.finish(node,state)//make sure
			if (Controller.debug) "DEBUG: doContinue Finished state and delay2"
			}
		else if(Controller.debug){if (Controller.debug) "DEBUG: doContinue Stop, skip state and delay"}//println"DEBUG: STOP $nodeStr set state, delay and audio "+ state }
	////
		
		if (!isBounce&&(isContinue(data)||firstStep)){ //jump node
			if (Controller.debug) "DEBUG: doContinue jump"
			String v=data.jump(state)
			Proxy.Node jumpNode=jumpToId(v)
			if(jumpNode!=null){
				doJumpNode(jumpNode,data)
				if (Controller.debug) "DEBUG: doContinue Finished jump"
			}
		}
	}
	 
	if (Controller.debug) "DEBUG: doContinue checking continue node: isJump=$data.isJump; firstStep=$firstStep; mode=$mode; isNodeOpen=$isNodeOpen"
	if (data.isJump){if (Controller.debug) "DEBUG: doContinue isJump"}
	else if (isBounce||( mode==Mode.STOP&&!firstStep)||(mode==Mode.STEP&&isNodeOpen)) {if (Controller.debug) "DEBUG: doContinue nothing"}
	else if(!isNodeOpen){
		if (Controller.debug) "DEBUG: doContinue children"
		ArrayList children=node.children
		if (node==NodeLib.root) children=rootChildrenRightLeft(children)
		children.each{
			if(!data.isScenario&&node.folded) NodeLib.invoke_folded(node,false)
			if(Controller.debug){println"DEBUG:+Children of $nodeStr: child="+ leftStr(it) +" $state"}
			if(mode!=Mode.STOP&&(firstStep||(isContinue(data)))){ //case stop is pressed
				Data siblingData=getData(it,data)
				doOpen(siblingData)
			} else if(Controller.debug){println"DEBUG: NOT isContinue child="+ leftStr(it)+ " $state"}
		}
	    }
	else if (mode!=Mode.STEP&&mode!=Mode.STOP){if (Controller.debug) "DEBUG: doContinue data";doContinue(data)} //isRootOpen==true
	
	
	if (!isContinue(data)||mode==Mode.STOP||node==NodeLib.root){if (Controller.debug) "DEBUG: doContinue skip back"}//skip back
	else {if (Controller.debug) "DEBUG: doContinue doBack";doBack(data)}
	
	if (Controller.debug) println "DEBUG: doContinue finish continue $nodeStr"
	
	//if (mode!=Mode.STOP&&Controller.current.doFilter)  Record_Page.invoke_stopFilter()
	 }
}	

void doJumpNode(Proxy.Node node,Data parentData){
	ArrayList nodes
	if (node==NodeLib.root) nodes=[node] else nodes=node.parent.children
	Boolean done=false
	while(!done){
		if (nodes[0]==node) done=true
		else nodes-=nodes[0]
	}
	NodeLib.invoke_unfoldParents(node)
	nodes.each{
		if(Controller.debug){println"DEBUG: jump $it.text"}
			Data jumpData=getData(it,parentData)
		if (jumpData!=null&&mode!=Mode.STOP) doOpen(jumpData)
	}
}

static ArrayList rootChildrenRightLeft(ArrayList ch){
	if(ch==null ||ch==[])return [] 
	else {
		ArrayList leftA=[]
		ArrayList rightA=[]
		ch.each{if(it.left) leftA+=[it] else rightA+=[it]}
		return rightA+leftA
	}
}
static Proxy.Node jumpToId(String id){
	if (id==null||id=="") return null  //toevoegen contorle ID_
	else return NodeLib.nodeForId(id)
}

void doBack(Data data){ //returns node to do after back
	current.invoke_initCurrentNodeInRoot() 
	assert(data!=null)
	if (mode==Mode.STOP){}// keep filter state
	else if(Controller.current.doFilter)  Record_Page.invoke_stopFilter()
	Proxy.Node node=data.node
	if (Controller.debug) println "DEBUG: doBack "+leftStr(node)
	if (!isFilter) setStateAndDelay(data, Data.State.BACK)
	doDelay(data,Data.State.BACK)
	Audio.current.finish(node,Data.State.BACK)
	if (Controller.debug) println "DEBUG: finished back "+leftStr(node)
	
}

void setRootState(Data data, Data.State col){ // begin state
	Proxy.Node node=NodeLib.root
	//skip state for root itself
	//set defaults in root
	//then continue with children of root
//	(Data.Col.open..Data.Col.back).each{
//		def v=data.menu(it)
//		if(v!=null&&v!=[]) MenuItems.execute(v)
//		}
	setStateAndDelay(data, col)
}


void setStateAndDelay2oud ( Data data, Data.State actionCol){ 
	Actions actions=data.actions(actionCol)
	if (actions!=null)actions.executeAll()	
}

void setStateAndDelay ( Data data, Data.State state){ //actions before setting filter
	Proxy.Node node=data.node
	def nodeStr=leftStr(node)
	assert(node!=null): "ERROR node null"
	if (Controller.debug) println "DEBUG: set state of node=$nodeStr; $data; col=$state"
	def v
	
	Filter.invoke_undoConditionWithNameFilter(node) //make sure
	
	Actions actions=data.actionsFor(state)
	
	if (Controller.debug) println "DEBUG: Execute menu actions=$actions"
	
	if (actions!=null) actions.executePre(data,state)
	if (Controller.debug) println "DEBUG: Executed preactions"
	
	if (state==Data.State.OPEN) {
		if(!data.isScenario) NodeLib.invoke_unfoldParents(node)	
		Actions actionsWithType=actions.actionsWithClass(Action_FilterNamed)
		Actions done=actionsWithType.executeAll(data,state)
		if (done.isEmpty&&Controller.current.doFilter ) new Filter().play(data,state) //basic filtering of branch
		else actions-=done

		if (!data.isScenario&&!isCurrentNodeInRoot){ 
			 WindowLib.invoke_scrollToVisible(node)
			 NodeLib.invoke_selectNode(node)}
		 else {current.invoke_initCurrentNodeInRoot();NodeLib.invoke_selectNode(node)} //NOTE must be current ??
		
		actionsWithType=actions.actionsWithClass(Action_Folding)
		done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty) {
			Boolean b=Defaults.current.foldOnOpen
			NodeLib.invoke_folded(node,b)
			WindowLib.scrollToVisible(node)}
		else actions-=done
		
		actionsWithType=actions.actionsWithClass(Action_DetailsVisibility)
		done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty) {
			Boolean b= Defaults.current.detailsOnOpen
			b=!b
			NodeLib.invoke_setHideDetails(node,b);
			WindowLib.scrollToVisible(node)
		} else actions-=done
		
		if(!skipCenter){ // see Action scroll
			actionsWithType=actions.actionsWithClass(Action_Center)
			done=actionsWithType.executeAll(data,state)
			if (!data.isScenario&&done.isEmpty){ 
				Boolean b=Defaults.current.centerOnOpen
				
			    if (b!=null&&b) MapLib.invoke_centerNode(node,slow)
			}else actions-=done
		}
		
		
		actionsWithType=actions.actionsWithClass(Action_Zoom)
		done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty){
			if (doAutoZoom){ 
				if (state==Data.State.OPEN) v=data.formatZoom(autoZoomMax_preference) 
				else v=data.formatZoom(autoZoomMin_preference)
				Thread.sleep(500) // workaround incorrect centering first root child
				MapLib.invoke_setZoom(v,slow)
			}
		}
		else actions-=done
		
	}
	
	if (state==Data.State.CONTINUE){
		if (doFilter) 	{
			new Filter().play(data,state) //FIRST TO DO; regelt ook welke knoop te selecteren
			NodeLib.invoke_selectNode(node)// nog intern filter regelen...
		}
	} 
	
	
	if (state==Data.State.CONTINUE) {
		
		Actions actionsWithType=actions.actionsWithClass(Action_Folding)
		Actions done=actionsWithType.executeAll(data,state)
		Boolean b=Defaults.current.foldOnContinue
		if (done.isEmpty) {if (!data.isScenario) NodeLib.invoke_folded(node,b)}
		else actions-=done
		
	}
	
	if (state==Data.State.BACK) {
		Actions actionsWithType=actions.actionsWithClass(Action_Folding)
		Actions done=actionsWithType.executeAll(data,state)
		Boolean b=Defaults.current.foldOnBack
		if (done.isEmpty) {if (!data.isScenario) NodeLib.invoke_folded(node.parent,b)} 
		else actions-=done
		
	}
	
		
	if (state==Data.State.CONTINUE){
		Actions actionsWithType=actions.actionsWithClass(Action_DetailsVisibility)
		Actions done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty) {
			Boolean b= Defaults.current.detailsOnContinue
			b=!b
			NodeLib.invoke_setHideDetails(node,b);
		}
		else actions-=done
		
		actionsWithType=actions.actionsWithClass(Action_Zoom)
		done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty){
			if (doAutoZoom){
			
				if (state==Data.State.OPEN) v=data.formatZoom(autoZoomMax_preference)
				else v=data.formatZoom(autoZoomMin_preference)
				Thread.sleep(500) // workaround incorrect centering first root child
				MapLib.invoke_setZoom(v,slow)
			}
		}
		else actions-=done
		
	}//**Continue
	
	
	if (state==Data.State.BACK) {
		Actions actionsWithType=actions.actionsWithClass(Action_DetailsVisibility)
		Actions done=actionsWithType.executeAll(data,state)
		if (!data.isScenario&&done.isEmpty) {
			Boolean b= Defaults.current.detailsOnBack
			b=!b
			NodeLib.invoke_setHideDetails(node,b);
		//NodeLib.invoke_setHideDetails(node,false==(Boolean)Node.getDetails_default(Data.toNodeCol(state)))
		}else actions-=done
		
	}//**Back
	
	Actions actionsWithType=actions.actionsWithClass(Action_FollowLink)
	Actions done=actionsWithType.executeAll(data,state)
	actions-=done
	
	
	//actions=MenuItems.executePost(actions)
	if (actions!=null) actions.executePost(data,state)
	if (Controller.debug) println "DEBUG: Executed post actions"
	
	Audio.current.play(node,state) //separate thread
	 
	if (mode!=Mode.STOP&&
		(mode!=Mode.STEP&&state==Data.State.OPEN)//|| data.isScenario
		) doDelay(data,state)//TEST...
	

}
	
	static Boolean getIsInited(){
		String sv=NodeLib.root[system]
		ArrayList al
		if (sv!=null) al=sv.trim().split(",")
		return (al!=null&&al.contains(inited))
	}
	
	static String getVersion(){ // position 1
		if (isInited){
			String sv=NodeLib.root[system]
			ArrayList al
			if (sv!=null) al=sv.trim().split(",")
			return al[1]
		}
		else return null
	}
	/*
	static Boolean getIsAttributesHidden(){
		String sv=NodeLib.root[system]
		ArrayList al=[]
		if (sv!=null) al=sv.trim().split(",")
		return (al!=null&&al.contains(isMenu))
	}
	*/
	static Boolean getIsTooltipOff(){
		String sv=NodeLib.root[system]
		ArrayList al=[]
		if (sv!=null) al=sv.trim().split(",")
		return (al!=null&&al.contains(tooltipOff))
	}
	

	//ACTIONS ****************************************************************
	void menuAction(){
		init()
		if (Controller.debug) println "DEBUG: New menu"
		new Menu().open(true)
	}

		void stepAction(Proxy.Node node){
			if (Controller.debug) {println "..."; println "DEBUG: step $node.text"}
			init()
			mode=Mode.STEP
			Data data=getData(node,null)
			continueStep(data)
			if (Menu.current!=null) Menu.current.finishRunning()
	}
		
		void playAction(Proxy.Node node){
			if (Controller.debug) {println "..."; println "DEBUG: play $node.text"}
			init()
				Data data=getData(node,null)
				continuePlay(data);  
				Menu.current.playButton.synchronizeOn(true)
	}
		
	 void backAction(){
			init()
			if (Controller.debug) println "DEBUG: backAction"
			Proxy.Node selected=NodeLib.selectedNode()
			if (!playThread &&selected.details!=null&&selected.hideDetails==false) {selected.hideDetails=true}
			else {MenuFreeplane.executeMenuActions(['BackAction'])
			}
			selected=NodeLib.selectedNode();selected.folded=true
			if (Menu.current!=null) Menu.current.finishRunning()
		}
	
	
//*************************************************************************************************	

Boolean getIsThread(){return playThread}

	void playAction(){
		init()
		if (Menu.current!=null) Menu.current.deActivateButtons()
		if (Controller.debug) println "DEBUG: playAction"
	   if (Controller.current.menuFrame==null){
		   def menu=new Menu()
		    menu.open(false)
			//Menu.current.playButton.toggleButtonWithoutAction()
			Menu.current.playButton.synchronizeOn(true)
			Menu.current.refresh()
	   }
		Thread.start({ 
			isLoop=false
			Menu.current.initPlay_FreeplaneItems()
			Menu.current.deActivateButtons()
			playThread=true
			def selected=NodeLib.selectedNode();  Controller.current.playAction(selected)
			isLoop=true
			def n
			if (mode!=Mode.STOP) {
				if (selected==NodeLib.root) n=NodeLib.root 
				else if(parentPlay) n=Navigate.backNode(selected)
				}
			
			while(cyclePlay&&n!=null&&mode!=Mode.STOP){ // in case not started at root
				def currentNode=Controller.current.currentNodeInRootAndInit 
				if(currentNode!=null) n=currentNode
				
				isLoop=true
				if (Controller.debug) println "DEBUG: Loop playAction node "+ leftStr(n)
				NodeLib.invoke_selectNode(n)
			    Controller.current.playAction(n)
				selected=NodeLib.selectedNode()
				n=Navigate.backNode(selected)
				
			}
			playThread=false	
			Menu.current.reActivateButtons()
			Menu.current.finishPlay_FreeplaneItems()
			
			if (Menu.current!=null) {  
				Menu.current.finishRunning()
				Menu.current.playButton.reset()
				Menu.current.refresh()
			
			if (Controller.debug) println "DEBUG: play FINISHED"
			if(mode!=Mode.STOP) NodeLib.invoke_selectNode(n)
		}
			})
	}
	
	void stepAction(){
		init()
		isLoop=false
		if (Controller.debug) println "DEBUG skipdelay=$skipDelay"
		if (Controller.debug) println "DEBUG: stepAction"
		if (playThread){skipDelay=true}
		else{
		Thread.start({
			playThread=true
			def selected
			
			if (isCurrentNodeInRoot) {selected=currentNodeInRoot} //during filtering && multi-select (!) a different node can be selected
			else selected=NodeLib.selectedNode()
			
			if(!Node.isScenario(selected)&&selected.details!=null && selected.hideDetails){
				isNodeUnfoldAndStop=true
				  Controller.current.stepAction(selected) //open details
			}
			else{
				isNodeUnfoldAndStop=false
				Controller.current.stepAction(selected)
				def n=selected
				isLoop=true
				
				if (Controller.debug) println "DEBUG stepAction: firstStep= $firstStep; hideDetails=$selected.hideDetails; if hidden: stop"
				if (firstStep &&isHiddenDetails(selected)) {
					//if (Controller.current.doFilter)  Record_Page.stopFilter()
					n=Navigate.backNode(selected)
					if(!Node.isScenario(n)) NodeLib.invoke_selectNode(n)
					Controller.current.stepAction(n)
				}
			}
			playThread=false
			})
		}
	}
	
	//overbodig ??
	 Boolean isHiddenDetails (Proxy.Node node){ //if closed, contue else stop
		 if (node.details==null) return true
		 else return (node.hideDetails)
	 }
	
	void stopAction(){
		init()
		if (debug) println "DEBUG: finishAction"
		Proxy.Node node=NodeLib.selectedNode
		init()
		mode=Mode.STOP
		if (Menu.current!=null) Menu.current.finishRunning()
	}
	
	void tooltips_OnAction(){
		if (!MenuItems.isTooltips) 	tooltipsAction(true)
		else Menu.current.tooltipsButton.toggleButtonWithoutAction()
	}
		void tooltips_OffAction(){
			if (MenuItems.isTooltips) 	tooltipsAction(false)
			else Menu.current.tooltipsButton.toggleButtonWithoutAction()
		}
		void tooltipsAction(Boolean b){
			init()
			if ((b&&!MenuItems.isTooltips)||
				 (!b&&MenuItems.isTooltips)) {
				 	MenuFreeplane.executeMenuActions(['SetBooleanPropertyAction.show_node_tooltips'])
					 //Menu.current.tooltipsButton.toggleButtonWithoutAction()
			}
		}
	
		void greyBackground_OnAction(){// set on from menu window; hence not invoke...
			if(!Action_GreyedSurround.isOn) greyBackgroundAction(true)
			else Menu.current.greyBackgroundButton.toggleButtonWithoutAction()
		}
		void greyBackground_OffAction(){
			if(Action_GreyedSurround.isOn) greyBackgroundAction(false)
			else Menu.current.greyBackgroundButton.toggleButtonWithoutAction() //correct hand set value
		}
		void greyBackgroundAction(Boolean b){ //true=set on; do not call from men
			init()
			Proxy.Node node=NodeLib.selectedNode
			if (!isInited) init()
			if ((b&&!Action_GreyedSurround.isOn)||(!b&&Action_GreyedSurround.isOn)) { //toggle
				
			//if(playThread) MenuFreeplane.invoke_executeMenuActions(['SetBooleanPropertyAction.presentation_mode'])
			//	else MenuFreeplane.executeMenuActions(['SetBooleanPropertyAction.presentation_mode'])
				MenuFreeplane.executeMenuActions(['SetBooleanPropertyAction.presentation_mode'])
				}
		}
		
		void attributes_OnAction(){
			if (!MenuItems.isAttributes) attributesAction(true)
			else Menu.current.attributesButton.toggleButtonWithoutAction()
		}
		void attributes_OffAction(){
			if (MenuItems.isAttributes) attributesAction(false)
			else Menu.current.attributesButton.toggleButtonWithoutAction()
		}
		void attributesAction(Boolean b){
			init()
			if (b) {if(!MenuItems.isAttributes) MenuFreeplane.executeMenuActions(['ShowAllAttributesAction'])
					}
			else if (!b) {if(MenuItems.isAttributes)  MenuFreeplane.executeMenuActions(['HideAllAttributesAction'])
			}
		}
		
		void attributesIcon_OnAction(){
			if (!MenuItems.isAttributesIcon) attributesIconAction(true)
			else Menu.current.attributesIconButton.toggleButtonWithoutAction()
		}
		void attributesIcon_OffAction(){

			if (MenuItems.isAttributesIcon) attributesIconAction(false)
				else Menu.current.attributesIconButton.toggleButtonWithoutAction()
		}
		
		void attributesIconAction(Boolean b){
			init()
			if ((b&&!MenuItems.isAttributesIcon)||
				 (!b&&MenuItems.isAttributesIcon)){ 
				 	 MenuFreeplane.executeMenuActions(['SetBooleanMapPropertyAction.show_icon_for_attributes'])
					 //Menu.current.attributesIconButton.toggleButtonWithoutAction()
			}
		}
		
		
		
		void statusBarAction(Boolean b){
			init()
			if ((b&&!MenuItems.isStatusBar)||
				 (!b&&MenuItems.isStatusBar)){
					  MenuFreeplane.executeMenuActions(['ToggleStatusAction'])
					 //Menu.current.attributesIconButton.toggleButtonWithoutAction()
			}
		}
		

		void fullScreen_OnAction(){
			if (!Action_FullScreen.isOn) {fullScreenAction(true)}
			else Menu.current.fullScreenButton.toggleButtonWithoutAction()
		}
		void fullScreen_OffAction(){
			if (Action_FullScreen.isOn) {fullScreenAction(false)}
			else Menu.current.fullScreenButton.toggleButtonWithoutAction()
		}
		
		void fullScreenAction(Boolean b){
			init()
			Proxy.Node node=NodeLib.selectedNode
			if (!isInited) init()
			if (b&&!Action_FullScreen.isOn||!b&&Action_FullScreen.isOn){
				 MenuFreeplane.executeMenuActions(['ToggleFullScreenAction'])
				 //Menu.current.fullScreenButton.toggleButtonWithoutAction()
			}
		}
		
		
		void imageAction(){
			MenuFreeplane.executeMenuActions(['addons.roan.insertInlineImage_on_single_node'])
		}
		
		void foldAll(Proxy.Node n){n.children.each{foldAll(it);it.folded=true}}
		void homeAction(){
			if (playThread){
				//scriptlib.Filter.invoke_stopFilter()
				MenuFreeplane.executeMenuActions(['MoveToRootAction','FoldAllAction'])
				NodeLib.root.children.each{closeNode(it)}
				MapLib.invoke_setZoom(1.0)
			}
			else{
			Filter.stopFilter()
			//MenuFreeplane.executeMenuActions(['MoveToRootAction','FoldAllAction'])
			foldAll(NodeLib.root)
			closeNode(NodeLib.root)
			MapLib.setZoom(1.0)
			NodeLib.centerNode(NodeLib.root)
			}
		}
		
		 void closeNode(Proxy.Node node){
			 if (node.children!=null) node.children.each{closeNode(it)}
			 hideDetails(node)
			 node.folded=true
		 }
		 
		void hideDetails(Proxy.Node node){
			node.hideDetails=true
			node.children.each{it.hideDetails=true}
			}
		
		void plusSizeAction(){// max menu
			new Menu().resize(true)
			Menu.current.initMenu_maximize()
		}
		
		void minSizeAction(){ //min menu
			new Menu().resize(false)
			Menu.current.initMenu_minimize()
		}
		
		void helpAction(){new Help().openInUserdir("roan-presentation_help/roan-presentation_help.mm")}
		
		void editDialogAction(){
			init()
			if (Controller.debug) println "DEBUG: New editDialog"
			//check if menu...
			//toggles openclose
			def selected=NodeLib.selectedNode()
			new EditDialog().open(selected)
		}
		void filter_OnAction(){
			doFilter=true
		}
		void filter_OffAction(){
			doFilter=false
			if (playThread) MenuFreeplane.invoke_executeMenuActions(['ApplyNoFilteringAction']) //??
			else MenuFreeplane.executeMenuActions(['ApplyNoFilteringAction'])
			
		}
		
		void autoZoom_OnAction(){
			doAutoZoom=true
		}
		
		void autoZoom_OffAction(){
			doAutoZoom=false
			if (playThread) MapLib.invoke_setZoom(1.0) else MapLib.setZoom(1.0)
		}
		
		void filterControllerAction(String name){
			if (name!=null&&Filter.setFilter(name)) MenuFreeplane.executeMenuActions(['QuickFilterAction'])
		}
		
		void windowSizeAction(){
			new WindowLib().setSize(windowWidth_preference, windowHeight_preference)
		}
		
		void lockAction(){
			MenuFreeplane.executeMenuActions(['EnterPassword'])
			//NodeLib.root.link.uri=new URI('menuitem:_$EnterPassword$0')
			}
		
	}
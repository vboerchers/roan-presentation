package roan

class ActionRegister {   // Defined action classes; naming follows class Node, node attributes

static private Integer TRANSLATED=0
static private Integer NEW=1	
static ActionRegister current=new ActionRegister()

def register=[:]  // keys are action names as used in node attributes

ActionRegister(){ 
	// each new subclass of Action must have form: MySubclass(ArrayList parms)
	// all subclasses of Action must be registered here
	
	register[Action_Center.key]				=[Action_Center.key_translated,			{ArrayList parms->new Action_Center(parms)}]
	register[Action_Delay.key]				=[Action_Delay.key_translated,			{ArrayList parms->new Action_Delay(parms)}]
	register[Action_DetailsVisibility.key]	=[Action_DetailsVisibility.key_translated,{ArrayList parms->new Action_DetailsVisibility(parms)}]
	register[Action_Filtering.key]			=[Action_Filtering.key_translated, 		{ArrayList parms->new Action_Filtering(parms)}]
	register[Action_FilterNamed.key]		=[Action_FilterNamed.key_translated, 	{ArrayList parms->new Action_FilterNamed(parms)}]
	register[Action_Folding.key]			=[Action_Folding.key_translated,		{ArrayList parms->new Action_Folding(parms)}]
	register[Action_FollowLink.key]			=[Action_FollowLink.key_translated,		{ArrayList parms->new Action_FollowLink(parms)}]
	register[Action_FullScreen.key]			=[Action_FullScreen.key_translated,		{ArrayList parms->new Action_FullScreen(parms)}]
	register[Action_GreyedSurround.key]		=[Action_GreyedSurround.key_translated,	{ArrayList parms->new Action_GreyedSurround(parms)}]
	register[Action_HomeRoAn.key]			=[Action_HomeRoAn.key_translated,		{ArrayList parms->new Action_HomeRoAn(parms)}]
	register[Action_Jump.key]				=[Action_Jump.key_translated,			{ArrayList parms->new Action_Jump(parms)}]
	register[Action_MenuFreeplane.key]		=[Action_MenuFreeplane.key_translated,  {ArrayList parms->new Action_MenuFreeplane(parms)}]
	register[Action_MenuRoAn.key]			=[Action_MenuRoAn.key_translated,		{ArrayList parms->new Action_MenuRoAn(parms)}]
	register[Action_Selecteds.key]			=[Action_Selecteds.key_translated,		{ArrayList parms->new Action_Selecteds(parms)}]
	register[Action_Scrolling.key]			=[Action_Scrolling.key_translated,		{ArrayList parms->new Action_Scrolling(parms)}]
	register[Action_Continuation.key]		=[Action_Continuation.key_translated,	{ArrayList parms->new Action_Continuation(parms)}]
	register[Action_EditDialog.key]			=[Action_EditDialog.key_translated,		{ArrayList parms->new Action_EditDialog(parms)}]
	register[Action_Zoom.key]				=[Action_Zoom.key_translated, 			{ArrayList parms->new Action_Zoom(parms)}]
	register[Action_Zooming.key]			=[Action_Zooming.key_translated, 		{ArrayList parms->new Action_Zooming(parms)}]
	
	
	}

String toString(){
	return "ActionRegister[$register]"
}

ArrayList getActionsList(){
	ArrayList r=[]
	register.each{
		r+=it.value[NEW]
	}
	return r.toArray(new Object[r.size()]);// convert to fixed array
}

// Action returned, also if sublass of Action	
Action action(String name, ArrayList parms){
	if (register[name]==null) {println "ROAN ERROR: no such action registered: $name; remove it from node attribute"; return null}
    else register[name][NEW](parms)
	} //action(parms)
Action action_translated(String name_translated, ArrayList parms_translated){
	Action a=register.find{it.value[TRANSLATED]==name_translated }?.value[NEW]([])
	a.parms=a.setParms_fromParms_translated(parms_translated) //action(parms)
	return a	
}

String name_forTranslated(String name_translated){
	return register.find{it.value[TRANSLATED]==name_translated }?.key
	}
}
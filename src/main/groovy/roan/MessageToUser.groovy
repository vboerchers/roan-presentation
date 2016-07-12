package roan
//Author Jodi Krol 2012
import javax.swing.*;
import java.awt.event.*;

class MessageToUser {

			
	public static showMissingNode(String nodeId, Integer stepNr, Integer sceneNr){
		//sceneNr+=1
		String message="Node with $nodeId expected in step $stepNr of\n"+
					   "scene $sceneNr: node not in this map!"
					   show(message)
	  }
	public static show(message){
		JFrame frame = new JFrame(message);
		JOptionPane.showMessageDialog(frame,message);
}
			
	/*
	  protected static MessageToUser current=new MessageToUser()
  protected Boolean isDisclaimer = false
  static JFrame frame;
  static String disclaimer=
	  "DISCLAIMER and PRECAUTIONS\n\n"+
	  "You may use this software for your own responisbility.\n\n "+
	  "Before continuing close all other programs to prevent robot\n"+
	  "actions to accidentally go to these other programs. Keep\n"+
	  "away from keyboard and mouse when RoAn is typing!\n\n"+
	  "When RoAn is playing, keyboard control keys are:\n"+
	  "- Pause: hold playing of current step; press again to continue\n"+
	  "- Home:  stop and replay current scene\n"+
	  "- PgUp:  stop current scene and play previous scene\n"+
	  "- PgDn:  stop current scene and play next scene\n"+
	  "- End:    End playing\n\n"+
	  "While playing (BUSY), no other keys should be pressed and\n"+
	  "the mouse should be left alone. Turn your loadspeaker ON.\n"
	  
	static String selectSeriesOrScene=
			"Select a node of type aScene or aSeries before pressing Load. Try again."
	//static String addCommentRecord=
			
	static String missingCommentTextChildNodeWithText=
			"Comment Text event misses child node of type aText with comment text."
			
	static String incorrectFormatOrContent=
			"Incorrect format or content animation step."
	static void show_Message_Event_Scene_Step(String message, String event, Integer sceneNr, Integer stepNr){
		String stepNrStr=stepNr.toString()
		String sceneNrStr=sceneNr.toString()
		String seriesId
		String sceneId
		String scene
		String series
		if (Recorder_Series.seriesNode==null) series=""
			else{
				seriesId=Recorder_Series.seriesNode.id
				series="scene nr=$sceneNrStr of $seriesId "
			   }
		if (Recorder_Scene.sceneNode==null) scene=""
			else{
			   sceneId=Recorder_Scene.sceneNode.id
				scene="step nr=$stepNrStr of $sceneId"
			}
		String m="$message\n"+
				 "Event string=$event\n"+
				 "Location: "+ scene + series
		show(m)
	}
	
public static showUnknownAction(String action, String eventStr, Integer sceneNr, Integer stepNr){
	
	String message="Unknown action $action in $eventStr\n"+
				   "at sceneNr= $sceneNr, stepNr=$stepNr.\n"+
				   "Repair and try again."
				   show(message)
  }

public static showUnknownAction(String action, Integer sceneNr, Integer stepNr){
	//sceneNr+=1
	String message="Unknown action $action at sceneNr= $sceneNr, stepNr=$stepNr.\n"+
				   "Check help for format and actions. Repair and try again."
				   show(message)
  }



public static showHiddenNode(String nodeId, Integer stepNr, Integer sceneNr){
	//sceneNr+=1
	String message="Node with $nodeId expected in step $stepNr of\n"+
				   "scene $sceneNr: skipped because node hidden by folding or filtering!"
				   show(message)
  }
	   
  public static showDisclaimer(){
	  if (current.isDisclaimer==false){
		  current.isDisclaimer=true
		  JFrame frame = new JFrame(disclaimer);
		  JOptionPane.showMessageDialog(frame,disclaimer);
  }}
  
 
  */
}


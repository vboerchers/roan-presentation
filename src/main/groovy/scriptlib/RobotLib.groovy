package scriptlib
//Autor Jodi D.Krol 2014-04

import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.awt.event.KeyEvent

class RobotLib {
	RobotLib(){}
	
	static Robot zobot = new Robot()
	
	Integer ECHOTIME=700
	Boolean isEchoPrivate=true 
	Boolean getIsEcho(){return isEchoPrivate}
	void setIsEcho(Boolean b){isEchoPrivate=b}
	
	Boolean isMousePressed = false // used in Recorder to prevent Break if pressed
	
	static void delay(Integer delay){Thread.sleep(delay)}
			
	void control_Key(Integer key){
		zobot.keyPress(KeyEvent.VK_CONTROL);
		zobot.keyPress(key);
		delay(10)
		zobot.keyRelease(key);
		zobot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	void alt_Key(Integer key){
		zobot.keyPress(KeyEvent.VK_ALT);
		zobot.keyPress(key);
		delay(10)
		zobot.keyRelease(key);
		zobot.keyRelease(KeyEvent.VK_ALT);
	}
	
	static Integer keyCodeRelease, keyCodePress
	
	void robotKeyPress(Integer keyCode){ //for synchronisation with glassplane
		keyCodePress=keyCode
		zobot.keyPress(keyCode)
	}
	
	void robotKeyRelease(Integer keyCode){ //for synchronisation with glassplane
		keyCodeRelease=keyCode
		zobot.keyRelease(keyCode)
	}
	
	 void clickLowerKey(Integer keyCode, delay) {       //IF Caps lock, upper/lower reversed
		  robotKeyPress(keyCode-32)
		  robotKeyRelease(keyCode-32)
		  this.delay(delay)
		  }
	 
	void clickUpperKey(Integer keyCode, delay) {    //IF Caps lock, upper/lower reversed
		  robotKeyPress(KeyEvent.VK_SHIFT)
		  robotKeyPress(keyCode)
		  robotKeyRelease(keyCode)
		  robotKeyRelease(KeyEvent.VK_SHIFT)
		  this.delay(delay)
		  }
	
	void keyClick(Integer keyCode, delay) {
		  robotKeyPress(keyCode)
		  robotKeyRelease(keyCode)
		  this.delay(delay)
		  }
	
	void keyPress(Integer keyCode, delay) {
		  robotKeyPress(keyCode)
		  this.delay(delay)
		  }
	
	void keyRelease(Integer keyCode, delay) {
		  robotKeyRelease(keyCode)
		  this.delay(delay)
		  }
	
	void keyGroupPress(ArrayList keyCodes){
		if (keyCodes !=null){
			keyCodes.each{//println "it code= $it";
				robotKeyPress(it)}
			}
		if (isEcho) this.delay(ECHOTIME)
		}
	
	void keyGroupRelease(ArrayList keyCodes){
		Collections.reverse(keyCodes);
		if (keyCodes !=null){
			keyCodes.each{robotKeyRelease(it)
			}
			}
		}
	
	void keyGroupClick(ArrayList list){
		//if (list[0]==KeyEvent.VK_ENTER){}
		//else ControllerRoan.current.windowTools.setFocusToFreeplane() // necessary, to prevent entering edit mode; unclear
		// mogelijk ook toevoegen aan press key
		
		def reverseList=list.clone()
		Collections.reverse(reverseList);
		if (list !=null){
			
			//@@@
			list.each{ robotKeyPress(it)}//;ControllerRoan.current.robot.waitForIdle()}//@@ creates bug, enetering insert mode + dot
			if (isEcho) this.delay(ECHOTIME)
			reverseList.each{robotKeyRelease(it)}//;ControllerRoan.current.robot.waitForIdle()}
			}
		}
	
	void mousePress (buttonCode, delay){ //buttonCode = InputEvent.BUTTON1_MASK etc.
		isMousePressed=true
		zobot.mousePress(buttonCode)
		if (isEcho && delay < ECHOTIME)  this.delay(ECHOTIME)
		this.delay(delay)
		}
	
	void mouseRelease(buttonCode, delay){// see above
		if (isEcho) zobot.mousePress(buttonCode) //necessary because long interval from press
		zobot.mouseRelease(buttonCode)
		isMousePressed=false
		this.delay(delay)
		}
	
	void mouseClick(buttonCode, delay){// see above
		zobot.mousePress(buttonCode)
		if (isEcho)  {
			this.delay(ECHOTIME)
			zobot.mousePress(buttonCode)}
		zobot.mouseRelease(buttonCode)
		isMousePressed=false
		this.delay(delay)
		}
	
	void mouseDoubleClick(buttonCode, delay){// see above
		zobot.mousePress(buttonCode)
		if (isEcho)  {this.delay(ECHOTIME) ; zobot.mousePress(buttonCode)}
		//ControllerRoan.current.robot.mousePress(buttonCode) //necessary, reason unclear
		zobot.mouseRelease(buttonCode)
		zobot.mousePress(buttonCode)
		zobot.mouseRelease(buttonCode)
		isMousePressed=false
		this.delay(delay)
		}
}

package scriptlib
// Author Jodi.D.Krol 2013-06
import javax.swing.JComboBox
import javax.swing.JOptionPane;
import javax.swing.JPanel
import org.freeplane.core.ui.components.UITools
import javax.swing.JLabel

class Message{
	def static textUtils= new org.freeplane.core.util.TextUtils()
	
	//$TRANSLATE
	static String WARNING=textUtils.getText(
		"addons.scriptlib.message.warning",
		"Warning"
		)
	static String INFORMATION=textUtils.getText(
		"addons.scriptlib.message.information",
		"Information"
		)
	//$END
	
  public static Boolean continueMessage(String message){	  
	  return 0==JOptionPane.showConfirmDialog(UITools.frame,message)  
  }
 
  public static void stop(String message){
	  
def x=JOptionPane.showMessageDialog(
	UITools.frame,
	message,
	WARNING,
	JOptionPane.WARNING_MESSAGE
	);
   println "smartlocker WARNING:" +message //log file
   assert(false):message
}
  
  static void warning(String message){
	    
  def x=JOptionPane.showMessageDialog(
	  UITools.frame,
	  message,
	  WARNING,
	  JOptionPane.WARNING_MESSAGE
	  );
     println "WARNING:" +message //log file
  }
  
  public static void plainMessage(String message){
	  
	def x=JOptionPane.showMessageDialog(UITools.frame,
	  message,
	  INFORMATION,
	  JOptionPane.PLAIN_MESSAGE);
	}
  
  
  static Boolean confirm(String message){
	  JOptionPane.OK_OPTION==JOptionPane.showConfirmDialog(null, message)
  }
  
  static String getInputStr(String message){
	  JOptionPane.showInputDialog ( message )
	  }
  
  static String getOptionStr(String[] sl){
	  JPanel myPanel = new JPanel();
	  myPanel.add(new JLabel("x:"));
	  Object[] folding = ["fold", "unfold"]
	  Object[] nodes = ["root", "selected nodes"]
	  String s = (String)JOptionPane.showInputDialog(
						  myPanel,
						  "Set parms",
						  JOptionPane.PLAIN_MESSAGE,
						  null,
						  folding,
						  nodes,
						  "ham");
  }
  
  
 
  
}

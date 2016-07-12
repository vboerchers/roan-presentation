package roan
//Athor Jodi D.Krol 201408
import groovy.lang.Closure;
import scriptlib.Message
import scriptlib.WindowLib
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.SwingUtilities
import javax.swing.JOptionPane

class Action_Scrolling extends Action{
	static String key="scrolling"
	static String key_translated=Message.textUtils.getText(
		"addons.roan.scrolling",
		"Scrolling"
		)
	
	static String tooltip=Message.textUtils.getText(
		"addons.roan.scrolling.tooltip",
		"<html>Move the current scroll position delta X,Y pixels."
		)
	Closure parm_toParm_translation={val->return val} // keep number values unchanged
	Closure parm_fromParm_translation={val -> return val}

	Action_Scrolling(ArrayList parms){
		super()
		name=key
		name_translated=key_translated
		this.parms=parms
		menu_tooltip=tooltip
	}
	
	void execute(Data data, Data.State col){  //actions: removes this action and possibly adds raw Freeplane menu action
		if(parms!=null){
			data.parmsTemp=parms
			SwingUtilities.invokeAndWait(new Runnable(){
				public void run(){
					def point=WindowLib.getScroll_Point(roan.Controller.current.c)
					point.x-=data.parmsTemp[0].toInteger()
					point.y-=data.parmsTemp[1].toInteger()
					WindowLib.setScroll_Point(roan.Controller.current.c,point)
				}})
			roan.Controller.current.skipCenter=true
			
		}

	 }
	
	@ Override
	void executeMenuItem(EditDialog editDialog){//invoker
		
		JPanel myPanel = new JPanel()
		JLabel xL=new JLabel("delta X")
		myPanel.add(xL)
		JTextField xT= new JTextField("0     ")
		myPanel.add(xT)
		JLabel yL=new JLabel("delta Y")
		myPanel.add(yL)
		JTextField yT=new JTextField("0     ")
		myPanel.add(yT)
		
		int result = JOptionPane.showConfirmDialog(null, myPanel,key_translated, JOptionPane.OK_OPTION)
		if (result == JOptionPane.OK_OPTION) {
			Integer X=xT.text.toInteger(); if (X==null) X=0
			Integer Y=yT.text.toInteger(); if (Y==null) Y=0
			 editDialog.addScripActionStr(key_translated+":"+X.toString()+","+Y.toString())
		}
	}
}

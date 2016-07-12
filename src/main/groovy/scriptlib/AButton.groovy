package scriptlib
// Author Jodi Krol 2012-8-01
// generic template for button definition
import groovy.lang.Closure;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory

	class AButton extends JButton implements ActionListener{
		private ImageIcon 	onIcon, 
							offIcon,  //default
							inactiveIcon
		private String 	onText,
						offText
		private Closure onAction, 
						offAction
		private Boolean isOff = true
		private Boolean isActive = true
		
		void setInactiveIcon(String iconFile, def scale)	{
			this.inactiveIcon=new AIcon(
				//new APath().imgURL(APath.Type.RESOURCEPATH,"/images/icons/$iconFile")).scaled(scale)
				FileLib.resourcepathToUrl(checkDefault(iconFile))).scaled(scale)
		}
		
		void inactivate(){isActive=false; if (inactiveIcon!=null) setIcon(inactiveIcon)}
		void reactivate(){isActive=true; if(isOff) setIcon(offIcon) else setIcon(onIcon)}
		
		AButton(){}
		
		Boolean getIsOn(){return isOff} //! on icon
		
		void synchronizeOn(Boolean on){ //during creation			
			if (on && isOff) toggleButtonWithoutAction() 
			else if (!on&&!isOff) toggleButtonWithoutAction()
		}
		
		void setOn(Boolean on){ // set definite state 
			if (on) { if(isOff) toggleButtonWithAction() }
			else if (!on&&!isOff) toggleButtonWithAction()
		}
		
		void reset(){if(!isOn) toggleButtonWithoutAction()}
		
		public void toggleButtonWithoutAction(){
			if (isOff){
				isOff=false
				setIcon(onIcon)
				setToolTipText(onText)
				}
			else {
				isOff=true
				setToolTipText(offText)
				setIcon(offIcon)
				}
		}
		
		public void toggleButtonWithAction(){
			if (isOff){ //unpressed
				isOff=false
				setIcon(onIcon)
				setToolTipText(onText)
				if (onAction !=null) onAction()
				}
			else {
				isOff=true
				setToolTipText(offText)
				setIcon(offIcon)
				if (offAction!=null) offAction()
				}
		}
		
		// single state button, specialisation of toggle button
		public AButton(String iconFile, def scale, String toolTip, Closure action){
			this.onIcon=new AIcon(
				//new APath().imgURL(APath.Type.RESOURCEPATH,"/images/icons/$iconFile")).scaled(scale)
				FileLib.resourcepathToUrl(checkDefault(iconFile))).scaled(scale)
				
			this.offIcon=onIcon
			this.onText=toolTip
			this.offText=toolTip
			this.onAction={ if(isActive) action()}
			this.offAction={ if (isActive) action()}
			setIcon(onIcon)
			setToolTipText(offText)
			addActionListener(this)
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
			}//CONSTRUCTOR
		
		
		// single state button, specialisation of toggle button
		public AButton(String iconFile,  String toolTip, Closure action){
			this.onIcon=new AIcon(
				//new APath().imgURL(APath.Type.RESOURCEPATH,"/images/icons/$iconFile")).scaled(0.75)
				FileLib.resourcepathToUrl(checkDefault(iconFile))).scaled(0.75)
			this.offIcon=onIcon
			this.onText=toolTip
			this.offText=toolTip
			this.onAction={ if (isActive) action()}
			this.offAction={ if(isActive) action()}
			setIcon(onIcon)
			setToolTipText(offText)
			addActionListener(this)
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
			}//CONSTRUCTOR
		
		// toggle button
		public AButton(String onIconFile, String offIconFile, String onToolTip, String offToolTip, Closure onAction, Closure offAction){
			init(onIconFile, 0.84, offIconFile, 0.84, onToolTip, offToolTip, onAction, offAction)
			}
		public AButton(String onIconFile, def scaleOn, String offIconFile, def scaleOff, String onToolTip, String offToolTip, Closure onAction, Closure offAction){
			init(onIconFile, scaleOn, offIconFile, scaleOff, onToolTip, offToolTip, onAction, offAction)
			}
			
		public init(String onIconFile, def scaleOn, String offIconFile, def scaleOff, String onToolTip, String offToolTip, Closure onAction, Closure offAction){
			this.onIcon=new AIcon(	
				//new APath().imgURL(APath.Type.RESOURCEPATH,"/images/icons/$onIconFile")).scaled(0.84)
				FileLib.resourcepathToUrl(checkDefault(onIconFile))).scaled(scaleOn)
			this.offIcon= new AIcon(
				//new APath().imgURL(APath.Type.RESOURCEPATH,"/images/icons/$offIconFile")).scaled(0.84)
				FileLib.resourcepathToUrl(checkDefault(offIconFile))).scaled(scaleOff)
			this.onText=onToolTip
			this.offText=offToolTip
			this.onAction={ if (isActive) onAction()}
			this.offAction={ if (isActive) offAction()}
			setIcon(offIcon)
			setToolTipText(offText)
			addActionListener(this)
			setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5))
			}//CONSTRUCTOR
		
		public void actionPerformed(ActionEvent e){
			//AGlasspane.current.show(true)
			String text=(String)e.getActionCommand()
			
			if (isActive) toggleButtonWithAction()
			//AGlasspane.current.updateMousePoint()
		}
		
		protected String formatHtmlForButton(String string){
			if (string!=""){
				if (string.toUpperCase().indexOf("<HTML>") != -1){ // already html
					return  string.replaceAll("</p>","<br>")
					}
				else {
					return new AHtmlUtils().plainToHtmlForButton(string)	// add html
				}
			}
		}
		
		String checkDefault(String s){
			ArrayList al= s.split("/")
			if (al.size()==1) return "/images/icons/$s" else return s
		}
		
}

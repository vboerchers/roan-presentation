package roan
//Author Jodi D.Krol 2014-06
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.NodeLib

class DelaySlider extends JSlider implements ChangeListener  {
		static DelaySlider current
		//static Integer speed=5000
		void setDelay(Integer newDelay) {myDelay=newDelay; 
			if(delay!=null){
				//saveInNode=false
				setValue((Integer)newDelay/1000)
			}
		}
		synchronized Integer getDelay(){return this.myDelay}
		
		private Integer myDelay
		
		
		static final int FPS_MIN = 0;
		static final int FPS_MAX = 30;
		static final int FPS_INIT = 0//Controller.delay_defaultMs/1000
		Boolean getSaveInNode(){
			!Controller.current.playThread
			}  // cannot be local, workaround
		
		
		DelaySlider(){
			super(JSlider.HORIZONTAL, FPS_MIN, FPS_MAX, FPS_INIT)
			current=this
			addChangeListener(this)
			//Turn on labels at major tick marks.
			setMajorTickSpacing(10);
			setMinorTickSpacing(1);
			setPaintTicks(true);
			setPaintLabels(true);
		}
		
		
		void stateChanged(ChangeEvent e) {
			JSlider source = (JSlider)e.getSource();
			if (!source.getValueIsAdjusting()) {
			def Integer delayS = (int)source.getValue()
			Proxy.Node root=NodeLib.root
			delay=delayS *1000
			if (saveInNode){
				if(Controller.current.playThread) Node.setDelayMs(root,delayS,Data.State.OPEN)
				else Controller.current.c.selecteds.each{Node.setDelayMs(it,delayS,Data.State.OPEN)}
			}
		}
	}
}	

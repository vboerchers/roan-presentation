package roan
//Author Jodi D.Krol 2014-06

import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyChangeEvent
import java.beans.PropertyChangeListener
import javax.swing.JProgressBar
import javax.swing.SwingWorker
import javax.swing.event.ChangeListener

import scriptlib.AThread
import javax.swing.SwingUtilities


class DelayProgress extends JProgressBar  {

DelayProgress(){
	super(0,100)
	setValue(0)
	setStringPainted(false)
}
Integer maxMs=30000
Integer calibration=4

void setProgress(Integer delayMs){ 
	Integer p=(delayMs/maxMs)*100
	p=(Math.min(p+calibration, 100))
	setValue(p)
	}

}


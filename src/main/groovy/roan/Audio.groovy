package roan
//Author Jodi D.Krol 2014-06
import org.freeplane.plugin.script.proxy.Proxy
import scriptlib.AThread

class Audio{
	static Audio current=new Audio()
	scriptlib.Audio a
	Data.State stateCol
	
	void play(Proxy.Node node, Data.State stateCol){
		this.stateCol=stateCol
		a=new scriptlib.Audio()
		String pn=node.id+"_"+stateCol.val.toString()+".wav"
		a.loadFromMapDirectory(pn)
		
		if (a.exists){
			if (Controller.debug) println "DEBUG: playing $pn"
			a.play()
		}
		else if (Controller.debug) println "DEBUG: Audio: no file $pn"
	}
	
	void finish(Proxy.Node duumy,Data.State stateCol){
		if (a!=null&&this.stateCol==stateCol){
			 a.stop()
			 a=null
		}
	}
}

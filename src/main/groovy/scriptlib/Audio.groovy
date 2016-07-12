package scriptlib
// Author Jodi Krol 2012-08
  // file in USERDIR/resources/myDir/mySound.wav; limited size of file
	//TEST
	//def s=new Audio("/sound/mySound.wav")
	//s.play(8000) || play()
	//s.stop()
 

// to play mp3, see http://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java
import org.freeplane.core.resources.ResourceController
import javax.sound.sampled.Clip
import javax.sound.sampled.AudioInputStream
import javax.sound.sampled.AudioSystem

class Audio {
	Audio(){}
		   
	 public Boolean exists=false
	 def frameLength
	 Clip clip
		   
	 String toString(){return "Audio[exists=$exists, frameLength=$frameLength, clip=$clip]"}
		   
	 static Boolean existsInMapDirectory(name){
		 def pathname=new FileLib().path_mapDirectory +File.separator+name
		 File file = new File(pathname);
		 return file.exists()
	 }
	 
	  Audio loadFromMapDirectory(name ){ 
		   def pathname=new FileLib().path_mapDirectory +File.separator+name
		   File file = new File(pathname);
		   if(file.exists()) {
				   URL url =  file.toURL();
				   AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
				   frameLength= audioIn.getFrameLength();
				 // Get a sound clip resource.
				   clip = AudioSystem.getClip();
				 // Open audio clip and load samples from the audio input stream.
				   clip.open(audioIn);
			   exists= true
			   }
		   else {if (Debug.debug) println "WARNING: No file $pathname";exists= false}
		   return this
	   		}
		   
		void play(){
			clip.start()
			}
		void play(Integer offset){
			assert (offset>=0&&offset < frameLength): "WARNING: start audio= $offset exceeds length $frameLength"
			// clip.setLoopPoints(begin, end) not working !
			clip.setFramePosition(offset)
			clip.start()
			}
		void stop(){ if (clip!=null&&clip.isRunning()) clip.stop()}
							
}

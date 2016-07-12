package scriptlib
//Author Jodi D Krol 2013
//Swing is not thread safe, meaning that
//UI functions must be called from AWT-dispatch thread 
import javax.swing.SwingUtilities
 
class AThread {
	static AThread current =new AThread()
	static Thread dispatchThread=Thread.currentThread()
	static String dispatchThreadName=Thread.currentThread().getName()
	
	AThread(){
		/*
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				dispatchThread = Thread.currentThread()
				dispatchThreadName = dispatchThread.getName()
				ADebug.log("dispatcher=$dispatchThreadName")
			}})
			*/
	}
	
	static void sleep(def i){if (i!=null) Thread.sleep(i)}
	
	static void assert_UI_Thread(){
		assert(dispatchThread==Thread.currentThread()): "ERROR, not AWT-dispatch thread"
		}
	
	//asynchronic execution in AWT-dispatcher thread; and in listeners
	static void invokeLater (Closure method){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				method()
			}})
	}
	
	//synchronized execution in AWT-dispatcher thread
	static void invoke (Closure method){
		if (dispatchThread==Thread.currentThread())	method() //in AWT-dispatcher thread already
		else{
		  SwingUtilities.invokeAndWait(new Runnable(){
			public void run(){ 
				//ADebug.log("Thread.invokeAndWait START")
				method()
				//ADebug.log( "Thread.invokeAndWait FINISHED")
			}})	
	    }
    }}

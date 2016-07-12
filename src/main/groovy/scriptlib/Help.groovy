package scriptlib
//Author Jodi D.Krol 2013-08
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.SwingUtilities;
import org.freeplane.core.resources.ResourceController;
import org.freeplane.core.util.ConfigurationUtils;
import org.freeplane.core.util.LogUtils;
import org.freeplane.features.mode.Controller;
import java.security.*;

class Help {
	def static textUtils= new org.freeplane.core.util.TextUtils()
	
	//$Preferences
	static Boolean hashCode=Preferences.getBooleanProp(
		"addons.scriptlib.help.hashCode",true
		)
	// attribute value in default.properties should not start with http; hence start with 'http
	static final String online_path=Preferences.getStringProp(
		"addons.scriptlib.help.onlinePath",
		"http://freeplane.sourceforge.net/wiki/images/"
	
		) //-online_path[0] //work around preference must not start with http; hence ' as first char
	static final String NO_ONLINE_HELP=textUtils.getText(
		"addons.scriptlib.help.onlineError",
		"No Help online available: "
		)
	//$END
	
	final ResourceController resourceController = ResourceController.getResourceController()
	
	String getOnlinePath(){
		String onlinePath=online_path
		if (onlinePath[0]=="'") onlinePath-=onlinePath[0] //default.properties table value cannot start with http 
		return onlinePath
	}
	
	String pathOnlineDefault(String helpFile, Boolean wiki, String path){ 
		String h=helpFile+".mm"
		if (wiki) return path+prefixUpload(h)+h
		else return path+h
		}
	
	
	void openInUserdir(String helpFile){
		def fl=new FileLib()
		String pathname=fl.path_userdir+File.separator+"doc"+File.separator+helpFile
		if (MapLib.open_map(pathname)){}
		else Message.warning("Help file missing: $helpFile")
	}
	void openOnline(String helpFile){ //oud, sciptlib
		String pathname=pathOnlineDefault(helpFile, hashCode, onlinePath)
		if (MapLib.open_mapOnline(pathname)){}
		else Message.warning(NO_ONLINE_HELP+ pathname)
	}
	
	// nieuw voor indexfile TE HERZIEN
	void openOnline(String path, Boolean wiki, String helpFile){ //uitbreiden
		SwingUtilities.invokeLater(new Runnable(){ //workaround
			public void run(){
				String pathname=pathOnlineDefault(helpFile,wiki,path)
				if (MapLib.open_mapOnline(pathname)){}
				else Message.warning(NO_ONLINE_HELP+ pathname)
			}})
	}
	
	String prefixUpload(String filename){  //when uploading wiki adds prefix
		String hash=getHashMD5(filename)
		return hash[0]+"/"+hash[0]+hash[1]+"/"
	}

	String getHashMD5(String plaintext){ 
		// thx http://stackoverflow.com/questions/415953/generate-md5-hash-in-java
		
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.reset();
			m.update(plaintext.getBytes());
			byte[] digest = m.digest();
			BigInteger bigInt = new BigInteger(1,digest);
			String hashtext = bigInt.toString(16);
			// Now we need to zero pad it if you actually want the full 32 chars.
			while(hashtext.length() < 32 ){
				hashtext = "0"+hashtext;
			}
			return hashtext
		}
	
}

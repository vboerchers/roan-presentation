package scriptlib
//TEST
import java.net.URL

class Internet {

	static boolean exists(String URLName){
		try {
		  HttpURLConnection.setFollowRedirects(false);
		  // note : you may also need
		  //        HttpURLConnection.setInstanceFollowRedirects(false)
		  HttpURLConnection con =
			 (HttpURLConnection) new URL(URLName).openConnection();
		  con.setRequestMethod("HEAD");
		  return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		}
		catch (Exception e) {
		   e.printStackTrace();
		   return false;
		}
	}
}

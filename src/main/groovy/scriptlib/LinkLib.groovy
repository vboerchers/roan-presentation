package scriptlib
//Author Jodi D.Krol 2014-04
import java.util.regex.Matcher
import java.util.regex.Pattern

import org.freeplane.features.url.UrlManager
import org.freeplane.plugin.script.proxy.Proxy;

import java.io.File;
import java.net.URI;
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.file.Paths
import java.nio.file.Path
import org.freeplane.features.mode.Controller


class LinkLib {
	static Boolean debug=Debug.debug
	//http://www.mkyong.com/regular-expressions/how-to-extract-html-links-with-regular-expression/
	//http://www.dscripts.net/2010/09/04/extract-hyperlinks-from-html-using-regular-expression-in-java/
	// fileName to display as title has spaces
	// filename in link has %20 
	    String raw // string when defined
		String title // filename with clear space, not %20
		String uriStr //raw, with space=%20, %=%25 etc
		String fileNameForTitle
		String fileNameForLink
		String width=null //image
		String height=null //image
		
		static final String saveFirstMessage=Message.textUtils.getText(
			"addons.scriptlib.saveFirstMessage",
			"Warning: Save mindmap first."
			)
		
		String toString(){
			return "LinkLib[raw=$raw; uriStr=$uriStr;title=$title;path=$path; filename=$fileNameForTitle; fileNameForLink=$fileNameForLink; src=$src; width=$width;height=$height]" }
		
		
		Integer getWidth(){
			if(width==null) def r=raw.find(/width="([^"]*)"/){a,b->width=b}
			if (width!=null) return width.toInteger() else return null
		}
		Integer getHeight(){
			if(height==null)def r=raw.find(/height="([^"]*)"/){a,c->height=c}
			if (height!=null) return height.toInteger() else return null
		}
		
		
		String getSrc(){
				if (raw==null) return null
				else{
					def src=null
					def r=raw.find(/src="([^"]*)"/){a,c->src=c}
					return src
				}
		}
		
		String getFileNameRaw(){if (uriStr==null) return ""
			//assert(false): "ERROR no uri in $title" 
			else 	{def r= uriStr.find(/([^\/]+)$/); if (r==null) return "" else return r}
			
		}
		
		
		
		String getPath(){if (uriStr==null||uriStr==fileNameRaw) return "" else return uriStr-("/"+fileNameRaw)}
		
		String basePath=null
		String linkRaw(String s){	s.replaceAll(/\s/,"").find(/(?i)<a([^>]+)>(.+?)<\/a>/)}
		//String linkRaw(String s){s.find(/<a(.+)<\/a>/)}
		LinkLib(String basePath, String rPathname){
			this.basePath=basePath
			String s=rPathname
			String l=linkRaw(s)
			raw=l
			if (l==null) {title=s; uriStr=null;if (debug) println "DEBUG: missing link in: $s"}
			else  l.find(/\s*(?i)href\s*=\s*(\"([^"]*)|'[^']*'|([^'">\s]+))\">([^<]*)/){t,a,b,c,d->
			//else  l.find(/\s*(?i)href\s*=\s*(\.'([^']*)|"[^"]*"|([^'">\s]+))\'>([^<]*)/){t,a,b,c,d->
			uriStr=toUriStr(b) //TEST temp
			title=d; if (title==null) title=""
			fileNameForTitle=fromUriStr(fileNameRaw)//fromHtmlChars(fileNameRaw) //TEST temp
			fileNameForLink=fileNameRaw
			}
		}
		LinkLib(String s ){ 
			String l=linkRaw(s)
			raw=l
			if (l==null) {title=s; uriStr=null;if (debug) println "DEBUG: missing link in: $s"}
			else  l.find(/\s*(?i)href\s*=\s*(\"([^"]*)|'[^']*'|([^'">\s]+))\">([^<]*)/){t,a,b,c,d->
			//else  l.find(/\s*(?i)href\s*=\s*(\.'([^']*)|"[^"]*"|([^'">\s]+))\'>([^<]*)/){t,a,b,c,d->
			uriStr= toUriStr(b) //TEST temp
			title=d; if (title==null) title=""
			fileNameForTitle=fromHtmlChars(fileNameRaw)
			fileNameForLink=fileNameRaw
			}
        }
		
	
	 LinkLib(String rPath, String filename, String title)	{
		String separator="/"; if(rPath=="") separator=""
		String rPathname=rPath+separator+filename
		//uriStr=rPathname.replaceAll(" ","%20") TEST temp
		uriStr=toUriStr(rPathname)
		this.title=title
		fileNameForTitle=title
		fileNameForLink=filename
	}
	void setArrow(Proxy.Node node){
		
		node.text='<html>'+title
		node.link.uri=new URI(uriStr)//TEST temp FileLib.toUri(uriStr)  
		if (node.link.uri==null) println "ERROR: NOT ARROW link URI: $uriStr in $node.text" //TEST temp	
	}
	 
	void setInNode (Proxy.Node node, NodeLib.Field field){ //TEST temp volledige html body definieren....
		if (field==NodeLib.Field.CORE){if (node.text==null) node.text=linkStr else node.text+=linkStr}
		else if (field==NodeLib.Field.DETAILS) {
			if (node.details==null) node.details=linkStr else node.details+=linkStr
			node.hideDetails=true}
		else if (field==NodeLib.Field.NOTE) { if (node.note==null) node.note=linkStr else node.note+=linkStr}
		else if (field==NodeLib.Field.ARROW) setArrow(node)
		}
	
	String getFilename(){
		if (uriStr==null) return ""
		else{
			File f= new File(uriStr)  //TEST temp fromUriStr ??
			if (f==null) return "" else return f.name
		}
	}
	
	//static String preHtml='<html>' 
	
	static String email(String s){
		return s.find(/([a-zA-Z0-9.]+@[a-zA-Z0-9]+[.][a-zA-Z]+)/)
	}
	
	//http://stackoverflow.com/questions/18243265/send-an-image-with-hyperlink-via-email-java
	static void setEmailLink(Proxy.Node node, String uriStr, String subject, String body){
		if(subject!=""&&body!="") 	node.link.uri=('mailto:'+uriStr+'&subject='+subject+'&body='+body).toURI()
		else if(subject!="") 	node.link.uri=('mailto:'+uriStr+'&subject='+subject).toURI()
		else if(body!="") 	node.link.uri=('mailto:'+uriStr+'&body='+body).toURI()
		else node.link.uri=('mailto:'+uriStr).toURI()
	}	
	static void setLinkToNode (Proxy.Node node, Proxy.Node toNode)	{
		if (node!=null&&toNode!=null){
			node.link.uri=("#"+toNode.id).toURI()
		}
	}
	
	String getLinkStr(){
		return ('<html><a href="'+uriStr+'">'+ title + '</a>')
	}
	String getLinkStr_AbsolutePathname(){
		//println "TEST:"
		//println '<html><a href="'+file_AbsolutePathname+'">'+title+'</a>'
		return '<html><a href="'+file_AbsolutePathname+'">'+title+'</a>'
	}
	
	Boolean getIsAbsolute(){
		Boolean b=uriStr.find("file:")
		return b
		
	}
	
	String getFile_AbsolutePathname(){
		assert (basePath!=null):"ERROR basePath not defined"
		if (uriStr==null) return ""
		else if (uriStr.find("file:/")) LinkLib.fromHtmlChars(uriStr)
		else return "file:///"+ basePath+"/"+ LinkLib.fromHtmlChars( uriStr)
	}
	
	static String toHtmlChars(String s){
		return s.replaceAll(/%/, /%25/).replace(/ /, /%20/)
	}
	
	static String fromHtmlChars(String s){
		return s.replaceAll( /%25/,/%/).replaceAll(/%20/,/ /)
	}
	
		
	static URI toAbsoluteUri(URI uri) {
		def map=Controller.getCurrentController().getMap()
		final UrlManager urlManager = (UrlManager) Controller.getCurrentModeController().getExtension(UrlManager.class);
		return urlManager.getAbsoluteUri(map, uri);
		}
	
/////
	static void linkToClipboard(Proxy.Node node){
		LinkLib link=new LinkLib(parentFile_Rightslash,node.text)
		AClipboard.setHtml(link.linkStr_AbsolutePathname)
	}
	static void linksToClipboardAction(def script_c, Proxy.Node node){ //link.uri or first uri in node.text
		File f=Controller.currentController.map.getFile()
		if (f==null){Message.plainMessage(saveFirstMessage)}
		else{
		String textHtml=""
		LinkLib link
		ArrayList selecteds=script_c.selecteds
		selecteds.each{
			link=new LinkLib(parentFile_Rightslash,it.text)
	
			if (link==null||link.uriStr==null){//red arrow link; make absolut first
				if (it.link!=null&&it.link.uri!=null){
					textHtml+='<html> <a href="'+LinkLib.toAbsoluteUri(it.link.uri).toString()+'">'+it.text+'</a>'+ '<br>'
					}
				}
			else textHtml+=link.linkStr_AbsolutePathname+"<br>"
			}
		
		if (textHtml!="") AClipboard.setHtml(textHtml)
		}
	}
	
	
	static void linkAddressesToClipboardAction(def script_c, Proxy.Node node){ //link.uri or first uri in node.text
		File f=Controller.currentController.map.getFile()
		if (f==null){Message.plainMessage(saveFirstMessage)}
		else{
		String addresses=""
		String separator=""
		LinkLib link
		ArrayList selecteds=script_c.selecteds
		selecteds.each{
			link=new LinkLib(parentFile_Rightslash,it.text)
	
			if (link==null||link.uriStr==null){//red arrow link; make absolut first
				if (it.link!=null&&it.link.uri!=null){
					addresses+=separator+(new File(LinkLib.toAbsoluteUri(it.link.uri))); separator=";"
					}
				}
			else {
				//addresses+=separator+(new File(link.linkStr_AbsolutePathname-'file:/')); separator=";"
				addresses+=separator+(new File(link.linkStr_AbsolutePathname-'file:/')); separator=";"
				}
			}
		
		if (addresses!="") AClipboard.setText(addresses)
		}
	}
	
	
	
	static File getParentFile() {  Controller.currentController.map.getFile().getParentFile()}
	static String getParentFile_Rightslash(){
		String p=parentFile.toString()
		p=p.replace("\\","/")
		return p
	}
	
	
	//
	static void nodeLinkToClipboardAction(def c, Proxy.Node script_node){
		String nodeId=script_node.id
		File f=Controller.currentController.map.getFile()
		if (f==null){Message.plainMessage(saveFirstMessage)}
		else {String uriString= f.toURI().toString()+"#"+nodeId
		//String uri="file:/"+currentFile_Pathname.replace('\\', '/').replace(" ","%20")+"#"+nodeId
		
		String textHtml='<html> <a href="'+uriString+'">'+script_node.text+'</a>'
		AClipboard.setHtml(textHtml)
		//AClipboard.setHtml('<html>'+uri)
		}
	}
	static void nodeLinkFromClipboardAction(def c, Proxy.Node script_node){ //paste map#nodeId in node
		File f=Controller.currentController.map.getFile()
		if (f==null){Message.plainMessage(saveFirstMessage)}
		else{
		LinkLib link=new LinkLib(AClipboard.text)
		if (link==null) println "WARNING: clipboard not containing link"
		else{
			Proxy.Node child=script_node.createChild()
			child.link.uri=new URI(link.uriStr)
			child.text=link.title
		}
		}
	}
	 
	static void linkToClipboard(def c, Proxy.Node node){
		LinkLib link=new LinkLib(parentFile_Rightslash,node.text)
		AClipboard.setHtml(link.linkStr_AbsolutePathname)
	}
	static void addressToClipboard(Proxy.Node node){
		LinkLib link=new LinkLib(parentFile_Rightslash,node.text)
		AClipboard.setText(link.file_AbsolutePathname-'file:/')
	}
	
	static String toUriStr(String s){// %, space, round brackets, curly brackets etc
		return s.replaceAll(/%/, /%25/).replaceAll(" ", "%20").replaceAll(/\(/,"%28").replaceAll(/\)/,"%29").replaceAll(/\{/,"%7B").replaceAll(/\}/,"%7D").replaceAll(/\[/,"%5B").replaceAll(/\]/,"%5D")
	}
	static String fromUriStr(String s){// space, round brackets, curly brackets etc
		return s.replaceAll("%20"," ").replaceAll( /%25/,/%/).replaceAll("%29",/\(/).replaceAll("%28",/\)/).replaceAll("%&B",/\{/).replaceAll("%7D",/\}/).replaceAll("%5B",/\[/).replaceAll("5D",/\]/)
	}
}

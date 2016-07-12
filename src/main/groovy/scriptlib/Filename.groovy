package scriptlib
//Author Jodi D.Krol 2013-12
import java.io.File;
import java.net.URI;



class Filename extends FileLib{
		String raw
		String title
		String extension // not lnk
		Boolean link     //lnk
		Boolean ilink   // aspx
		Boolean i2link   // LINK
		static final String LINK="lnk"
		static final String ILINK="aspx"
		static final String I2LINK="URL"
		static final String I2Link="url"
		static final String DOT_LINK=".lnk"
		static final String DOT_ILINK=".aspx"
		static final String DOT_I2LINK=".URL"
		static final String DOT_I2link=".url"
		
		String toString(){return "Filename[raw=$raw; title=$title;extension=$extension;link=$link;dotLink=$DOT_LINK;ilink=$ILINK;dotILink=$DOT_ILINK]"}
		
		Filename(String raw){  //title.extension.lnk ||title.aspx ||title.lnk ||title.LNK
			super()
			this.raw=raw
			extension=FileLib.extension(raw)
			if (extension==LINK) {
				link=true; title=raw-DOT_LINK
				extension=FileLib.extension(title)
				title-=("."+extension)
				}
			else if (extension==ILINK) {
				ilink=true; title=raw-DOT_ILINK
				extension=FileLib.extension(title)
				title-=("."+extension)
				}
			else if (extension==I2LINK) {
				ilink=true; title=raw-DOT_I2LINK
				extension=FileLib.extension(title)
				title-=("."+extension)
				}
			else if (extension==I2Link) {
				ilink=true; title=raw-DOT_I2link
				extension=FileLib.extension(title)
				title-=("."+extension)
				}
			else title=raw-("."+extension)
		}
		
		Boolean getIsExtension(){return extension!=null&&extension!=""}
		Boolean getIsLink(){return (link||ilink||i2link)}
		String getDotExtension(){
			if (extension=="") return ""
            else return "." + extension
		}
		
		String getDotLink(){
			if (!link&&!ilink) return ""
			//else return "." + extension  //?? klopt dit
			else if (link) return DOT_LINK
			else if (ilink)return DOT_ILINK
			else if (i2link)return DOT_I2LINK
		}
		
		String getTitleAndExtension(){
		return title+dotExtension
	}
		String getAll(){
			println title+dotExtension+dotLink 
			return title+dotExtension+dotLink
		}
}

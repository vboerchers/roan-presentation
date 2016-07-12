package scriptlib
//Author Jodi Krol 2012-08
import java.awt.Image
import javax.swing.ImageIcon
import org.freeplane.core.resources.ResourceController
  
class AIcon extends ImageIcon{
	AIcon(){}
 
	public AIcon(def imgURL){
		super(imgURL)
	}

	ImageIcon scaled(def scale){
		 Image img = getImage() ;
		 Integer width=img.width*scale
		 Integer height=img.height*scale
		 Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;
		 return new ImageIcon( newimg );
		 }
	
	static ImageIcon imageIcon (String fileName){ //fileName = name.ext
		return new AIcon( FileLib.resourcepathToUrl("/images/icons/$fileName"))
		//return new AIcon( FileLib.resourcepathToUrl("/images/$fileName"))
		}

}

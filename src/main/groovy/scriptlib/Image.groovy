package scriptlib
import javax.swing.ImageIcon;

import org.freeplane.core.util.FreeplaneIconUtils

class Image {
	static List<String> standardIconKeys=FreeplaneIconUtils.listStandardIconKeys()
	
	ImageIcon icon(String standardKey) {FreeplaneIconUtils.createImageIconByResourceKey(standardKey)}
	
	ImageIcon scaled(ImageIcon icon, scale){
		Image img = icon.getImage() ;
		Integer width=img.width*scale
		Integer height=img.height*scale
		Image newimg = img.getScaledInstance( width, height,  java.awt.Image.SCALE_SMOOTH ) ;
		return new ImageIcon( newimg );
		}

}

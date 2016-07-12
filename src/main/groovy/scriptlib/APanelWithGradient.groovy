package scriptlib
//Author Jodi Krol 2012
import java.awt.Color
import java.awt.GradientPaint
import java.awt.Graphics;
import java.awt.Graphics2D

import javax.swing.JPanel;
 
class APanelWithGradient extends JPanel {
	Color color = getBackground( );
	Color color1 = color.brighter( );
	Color color2= color//.darker()

	protected void paintComponent( Graphics g ) 
{
    if ( !isOpaque( ) )
    {
        super.paintComponent( g );
        return;
    }
 
   Graphics2D g2d = (Graphics2D)g;
   int w = getWidth( );
   int h = getHeight( );
	
   // Paint a gradient from top to bottom
   GradientPaint gp = new GradientPaint(
	   0, 0, color1,
	   0, h, color2 );
   
   g2d.setPaint( gp );
   g2d.fillRect( 0, 0, w, h );
 
    setOpaque( false );
    super.paintComponent( g );
    setOpaque( true );
}
	
}

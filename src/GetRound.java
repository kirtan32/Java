

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class GetRound {

	BufferedImage getImg(String s)
	{
		BufferedImage bim=null;
        // Get the BufferedImage object for the image file
		try {
	        BufferedImage originalImg=ImageIO.read(new File(s));
	        
	        // Get the width,height of the image
	        int width=originalImg.getWidth();
	        int height=originalImg.getHeight();
	        
	        // Create a new BufferedImage object with the width,height
	        // equal to that of the image file
	        bim=new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
	        
	        // Create a Graphics2D object by using
	        // createGraphics() method. This object is 
	        // used to perform the operation!
	        Graphics2D g2=bim.createGraphics();
	        
	        // You can also use rendering hints
	        // to smooth the edges or the rounded rectangle
	        RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        qualityHints.put(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
	        g2.setRenderingHints(qualityHints);
	        
	        // This method does it all!. You can clip the
	        // image into the shape you wish, play it as you like!
	        g2.setClip(new RoundRectangle2D.Double(0,0,width,height,width/7,height/6));
	        
	        // Now, draw the image. The image is now
	        // in the 'clipped' shape, the shape in the setClip()
	        g2.drawImage(originalImg,0,0,null);
	        
	        // Dispose it, we no longer need it.
	        g2.dispose();
	        
	        // Write to a new image file
	       // ImageIO.write(bim,"PNG",new File(s+"-rounded.png"));
	        
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return bim;
	}
}

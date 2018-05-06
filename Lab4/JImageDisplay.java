import javax.swing.JComponent;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Dimension;

public class JImageDisplay extends JComponent
{
	private BufferedImage MyImage;
	public JImageDisplay(int width, int height)
	{
		MyImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Dimension DM= new Dimension(width,height);
		super.setPreferredSize(DM);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(MyImage,0,0,MyImage.getWidth(),MyImage.getHeight(),null);
	}
	public void clearImage()
	{
		for(int i=0;i<MyImage.getWidth();i++)
		{
			for(int j=0;j<MyImage.getHeight();j++)
			{
				drawPixel(i,j,0);
			}
		}
	}
	public void drawPixel(int x,int y, int rgbColor)
	{
		MyImage.setRGB(x,y,rgbColor);
	}
	public BufferedImage getImage()
	{
		return MyImage;
	}
}
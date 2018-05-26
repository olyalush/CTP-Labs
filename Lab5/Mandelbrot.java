import java.awt.geom.Rectangle2D;

public class Mandelbrot extends FractalGenerator
{
public static int MAX_ITERATIONS =2000;
	public void getInitialRange(Rectangle2D.Double range)
	{
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
	}
	public int numIterations(double x,double y)
	{
		int iter=0;
		double re=0;
		double im=0;
		double moduleZ;
		while(iter<MAX_ITERATIONS)
		{
			double nextRe=re*re-im*im+x;
			double nextIm=2*re*im+y;
			moduleZ=nextRe*nextRe+nextIm*nextIm;
			re=nextRe;
			im=nextIm;
			iter++;
			if (moduleZ>4)
				return iter;
		}
		return -1;
	}
		public String toString()
	{
		return "Mandelbrot";
	}
}
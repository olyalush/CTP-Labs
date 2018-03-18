/**A two-dimensional point class.
 */ 
двумерный
класс
точки
.
public class Point3d {
    
    /** X  координата точки*/
    private double xCoord;
    
    /** Y  координата точки*/
    private double yCoord;

    /** Конструктор, чтобы инициализировать точку к(x, y)  значение.  */
    public Point3d(double x, double y) {
        xCoord = x;
        yCoord = y;
    }

    /** Конструктор без параметров:  значения по умолчанию к точке в источнике. */
    public Point2d() {
        // 
        this(0, 0);
    }

    /** Верните X координат точки. */
    public double getX() {
        return xCoord;
    }

    /** Возвратите координату Y точки. */
    public double getY() {
        return yCoord;
    }

    /** Набор X координат точки. */
    public void setX(double val) {
        xCoord = val;
    }

    /** Набор Y координат точки. */
    public void setY(double val) {
        yCoord = val;
    }
	// Метод, проверяющий равенство двух точек
	public boolean areEqual (Point3d point) {
		if (xCoord==point.getX() && yCoord==point.getY() && zCoord==point.getZ()) return true;
		return false;
	}
	// метод distanceTo, который берет другой Point3d  в качестве параметра и вычисляет двойную точность приближения
	public double distanceTo(Point3d p){
		return Math.sqrt(Math.pow(xCoord-p.getX(),2)+Math.pow(yCoord-p.getY(),2)+Math.pow(zCoord-p.getZ(),2));
}
}
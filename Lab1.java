// Импортируем класс Scanner
import java.util.Scanner;
// Класс, содержащий статический основной метод. 
public class Lab1{
	// Функция получает координаты трёх точек и находит площадь треугольника.
	public static void main(String[] args){
		int eqError=0;
		// Создаём массив из трёх точек:
		Point3d[] p = new Point3d[]{new Point3d(),new Point3d(),new Point3d()};
		// Вводим координаты точек:
        Scanner scanner = new Scanner(System.in);
        for(int j=1; j<=3; j++)
        {
            System.out.println("Введите координаты точки:");
            p[j-1].SetX(Double.parseDouble(scanner.next()));
            p[j-1].SetY(Double.parseDouble(scanner.next()));
            p[j-1].SetZ(Double.parseDouble(scanner.next()));
        }
		// Проверка на  совпадение:
		if (p[0].areEqual(p[1]) || p[0].areEqual(p[2]) || p[1].areEqual(p[2])) {
			System.out.println("Введены одинаковые координаты");
			eqError++;
		}
		// Если не совпало, находим площадь треугольника.
		if (eqError<1) {
			double area=computeArea(p[0],p[1],p[2]);
			System.out.println("Площадь треугольника равна "+area);
		}		
	}
	// Метод находит площадь треугольника используя формулу Герона 
	public static double computeArea (Point3d p1, Point3d p2, Point3d p3){
		double a=p2.distanceTo(p1);
		double b=p1.distanceTo(p3);
		double c=p3.distanceTo(p2);
		double d=(a+b+c)/2;
		return (Math.sqrt(d*(d-a)*(d-b)*(d-c)));
	}
}
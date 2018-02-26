Класс находит и выводит все простые числа меньше 100
public class Primes 
{
	// перебор чисел от 2 до 100, с помощью функции isPrime определяем простое число или нет, если да то выводим их
	public static void main(String[] args) 
	{
		for (int i=2;i<=100;i++)
		{
			if (isPrime(i))
			System.out.println(" "i+);
		}
	}
	// функция isPrime определяет простое число или нет
	public static boolean isPrime(int n)
    {
		for (int j=2;j<n;j++)
		{
			if (n%j==0) 
			return false;
		}
		return true;
	}
}

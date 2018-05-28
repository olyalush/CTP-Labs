//Класс показыват показывает является ли строка полиндромом
public class Palindrome 
{
// метод получает массив, затем в строку сохраняет слова и сравнивает изменённую строку с начальной
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) 
		{
			String s = args[i];
			if (isPalindrome(s)) 
			System.out.println(s+ " Палиндром ");
			else System.out.println(s+ " Не палиндром ");
		} 
	}
//изменяет строку 
	public static String reverseString(String s)
	{
		String rev="";
		for (int i = s.length()-1; i >=0; i--) 
		{
			rev+s.charAt(i);
		}
		return rev;
	}
//метод создаёт обратную версию, а затем сравнивает её с первоначальными данными
	public static boolean isPalindrome(String s)
	{
	return s1.equals(reverseString(s));
	}
}

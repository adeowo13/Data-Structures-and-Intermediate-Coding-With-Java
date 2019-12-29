import java.util.Scanner;
import java.lang.*;
public class Logs
{
	public static void main (String []args)
	{
		Scanner scan = new Scanner(System.in);
		int a = 0;
		int b = 0;
		int c = 0;
		
		System.out.println("Hello, please enter an integer base bigger than 1");
		a = scan.nextInt();
		
		if ( a<1 )
		{ 
			System.exit(0);
		}
		do
		{
			System.out.println("Thank you. Please enter a positive integer 'X'");
			b = scan.nextInt();
		}
		while (b<=0);
		c = b;
		
		while ( b > a)
		{
			b = b / a;
		}
		
		
		System.out.println("The log of " + c + " base " + a + " equals " + b);
		
	}
}
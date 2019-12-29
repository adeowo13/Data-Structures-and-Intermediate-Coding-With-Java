import java.util.*;
import java.io.*;
public class Knapsack
{
	public static void main(String [] args) throws Exception
	{
		Scanner sc = new Scanner(new FileReader(args[0]));
		int [] arr = new int [16];
		
		for(int i = 0; i < 16; i++)
		{
			arr[i] = sc.nextInt();
			System.out.print(arr[i] + " ");
		}
		int Tsum = Integer.parseInt(sc.next());
		System.out.println("");
		System.out.println(Tsum);
		
		String subset ="";
		int sum = 0;
		int a;
		int b;
		for (a = 0 ; a  < 0xFFFF ; ++ a)
		{
			for (b = 15 ; b >=0  ; --b )
			{
				/* shift i'th bit to the end position then AND it with 1 */
				if ( (a >> b) % 2 == 1 ) /* true iff i'th bit is a 1 */
				{
					sum += arr[b];
					subset += arr[b] + " ";
				}
			}
			if(sum == Tsum)
			{
				System.out.println(subset);
			}//if
			subset = "";
			sum = 0;
		}//for
	}//main
}//class	
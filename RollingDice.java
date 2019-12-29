import java.util.Scanner;
import java.util.Random;

public class RollingDice
{
	public static void RollDice(int numRolls, Random randomNums)
	{
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;
		int counter5 = 0;
		int counter6 = 0;
		int counter7 = 0;
		int counter8 = 0;
		int counter9 = 0;
		int counter10 = 0;
		int counter11 = 0;
		int counter12 = 0;

		
		for(int a = 0; a <= numRolls; a++)
		{
			int n = randomNums.nextInt(12)+2;
			switch(n)
			{
			
				case 2:
				counter2++;
				break;
				
				case 3:
				counter3++;
				break;
				
				case 4:
				counter4++;
				break;
				
				case 5:
				counter5++;
				break;
				
				case 6:
				counter6++;
				break;
				
				case 7:
				counter7++;
				break;
				
				case 8:
				counter8++;
				break;
				
				case 9:
				counter9++;
				break;
				
				case 10:
				counter10++;
				break;
				
				case 11:
				counter11++;
				break;
				
				case 12:
				counter12++;
				break;
				}
		}
		
		System.out.println("Value: 2" + "\t\t Fraction: " + counter2 + "/" + numRolls);
		System.out.println("Value: 3" + "\t\t Fraction: " + counter3 + "/" + numRolls);
		System.out.println("Value: 4" + "\t\t Fraction: " + counter4 + "/" + numRolls);
		System.out.println("Value: 5" + "\t\t Fraction: " + counter5 + "/" + numRolls);
		System.out.println("Value: 6" + "\t\t Fraction: " + counter6 + "/" + numRolls);
		System.out.println("Value: 7" + "\t\t Fraction: " + counter7 + "/" + numRolls);
		System.out.println("Value: 8" + "\t\t Fraction: " + counter8 + "/" + numRolls);
		System.out.println("Value: 9" + "\t\t Fraction: " + counter9 + "/" + numRolls);
		System.out.println("Value: 10" + "\t\t Fraction: " + counter10 + "/" + numRolls);
		System.out.println("Value: 11" + "\t\t Fraction: " + counter11 + "/" + numRolls);
		System.out.println("Value: 12" + "\t\t Fraction: " + counter12 + "/" + numRolls);
		
		
	}
	public static void main(String []args)
	{
	Random randomNums = new Random();
	Scanner scan = new Scanner(System.in);
	Boolean stop = false;
	int numRolls = 0;
	int option = 0;
	
	
	for(int i = 0; i <= numRolls; i++)
	{
	
		System.out.println("Enter the number of rolls desired:");
		numRolls = scan.nextInt();
	
		RollDice(numRolls, randomNums);
		System.out.println("Would you like to continue? 1 for yes 2 for no");
		option = scan.nextInt();
		
		if(option == 2)
		{
			System.exit(0);
		}
	}
	
	
	}
}
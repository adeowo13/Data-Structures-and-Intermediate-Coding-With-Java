//Ade Owodunni
//CS0401
//Assignment 1
 
import java.util.Scanner;
import java.util.Random;
public class SCIGasStation
{
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		boolean check;
		
		String option;
		String payment;
		String type;
	
		int menu;
		int gasC;
		int washC;
		int amount;
		int o;
		int f;
		int tn;
		int tw;
		int p;
		int n; 
		int d;
		int q;
	
		double paid;
		double pay;
		double gasP;
		double washP;
		double total;
		double fill;
		double change;
		boolean breakD;
		boolean breakD2;
		boolean breakD3;
		boolean breakD4;
		
		do{//last
		do//1st
		{
			check = false;
		
			option = "";
			payment = "";
			type = "";
	
		 	menu = 0;
			gasC = 0;
			washC = 0;
			amount = 0;
			o = 0;
			f = 0;
			tn = 0;
			tw = 0;
			p = 0;
			n = 0; 
			d = 0;
			q = 0;
			
			paid = 0.0;
			pay = 0.0;
			gasP = 0.0;
		 	washP = 0.0;
			total = 0.0;
			fill = 0.0;
			change = 0.0;
			breakD = false;
			breakD2 = false;
			breakD3 = false;
			breakD4 = false; 
			
			/*I reset all the variable to the initial values inside the do while loop so that anytime
			the loop is broken and returns back to the main menu, the values will start back at the
			original values*/
			
			do//2nd
			{
				do//3rd
				{
					System.out.printf("\nWelcome to the SCI Gas Station!!!\n");
					System.out.println("Please choose your service.");
					System.out.println(" 1. Gas Only");
					System.out.println(" 2. Gas with car wash (10c off per gallon up to 15 gallons)");
					System.out.println(" 3. Exit");
					menu = scan.nextInt();
					if(menu == 1 || menu == 2 || menu == 3)
					{ 
						breakD = true;
					}
					else
					{
						System.out.println("Invalid Option !!"); 
						breakD = false;
					}
				}while(breakD == false); // 3rd do-while
				switch(menu)
				{
					case 1:
					{
						System.out.println("Please select a gasoline type: ");
						System.out.println("1) 87 ($2.59 per gallon)");
						System.out.println("2) 89 ($2.69 per gallon)");
						System.out.println("3) 91 ($2.84 per gallon)");
						System.out.println("4) 94 ($2.99 per gallon)");
						System.out.println("5) Cancel");
						gasC = scan.nextInt();
						if(gasC == 1 || gasC == 2 || gasC == 3 || gasC == 4)
						{
							breakD2 = true;
							check = false;
						}
						else if(gasC == 5)
						{
							breakD2 = false;
							check = true;
						}
						else
						{
							System.out.println("Invalid Option !!"); 
							breakD2 = false;
						}
						break;
					} //case 1 close
					case 2:
					{
						System.out.println("Please select a type of car wash: ");
						System.out.println("1) Basic ($5.00)");
						System.out.println("2) Shine ($7.00)");
						System.out.println("3) Deluxe ($9.00)");
						System.out.println("4) Premium ($11.00)");
						System.out.println("5) Cancel ");
						washC = scan.nextInt();
						if(washC == 1 || washC == 2 || washC == 3 || washC == 4)
						{
							breakD2 = true;
							check = false;
						}
						else if(washC == 5)
						{
							breakD2 = false;
							check = true;
						}
						else
						{
							System.out.println("Invalid Option !!"); 
							breakD2 = false;
							check = false;
						}
						if(washC != 5)
						{
							System.out.println("Please select a gasoline type: ");
							System.out.println("1) 87 ($2.59 per gallon)");
							System.out.println("2) 89 ($2.69 per gallon)");
							System.out.println("3) 91 ($2.84 per gallon)");
							System.out.println("4) 94 ($2.99 per gallon)");
							System.out.println("5) Cancel");
							gasC = scan.nextInt();
							if(gasC == 1 || gasC == 2 || gasC == 3 || gasC == 4)
							{
								breakD2 = true;
								check = false;
							}
							else if(gasC == 5)
							{
								breakD2 = false;
								check = true;
							}
							else
							{
								System.out.println("Invalid Option !!"); 
								breakD2 = false;
								check = false;
							}
						}
						break;
					} //case 2 close
					case 3:
					{
						System.out.println("GOODBYE!!");
						System.exit(0);
						break;
					} //case 3 close
				}//switch(menu close)
				if(check)
				{
					continue;
				}
				/*This last if statement sends the program back to the beginning whenever 
				the cancel option is chosen*/
				
			}while(check == true);//2nd do-while
			
			System.out.println("You order is as follows: ");
			if(menu == 1 || menu == 2)
			{
				if(gasC == 1)
				{
					gasP = 2.59;
					System.out.println("1. A full tank of gas 87 ($ " + gasP + " per gallon)");
				}
				else if(gasC == 2)
				{
					
					gasP = 2.69;
					System.out.println("1. A full tank of gas 89 ($ " + gasP + " per gallon)");
				}
				else if(gasC == 3)
				{
					gasP = 2.84;
					System.out.println("1. A full tank of gas 91 ($ " + gasP + " per gallon)");
				}
				else if(gasC == 4)
				{
					gasP = 2.99;
					System.out.println("1. A full tank of gas 94 ($ " + gasP + " per gallon)");
					
				}
				if(menu == 2)
				{
					if(washC == 1)
					{
						washP = 5.00;
						System.out.println("2. Basic Car Wash ($" + washP + ")");
					}
					else if(washC == 2)
					{
						washP = 7.00;
						System.out.println("2. Shine Car Wash ($" + washP + ")");
					}
					else if(washC == 3)
					{
						washP = 9.00;
						System.out.println("2. Deluxe Car Wash ($" + washP + ")");
					}
					else if(washC == 4)
					{
						washP = 11.00;
						System.out.println("2. Premium Car Wash ($" + washP + ")");
					}
				}// menu = 2 close
			}// menu = 1 or menu = 2
			option = scan.nextLine();
			System.out.printf("Confirm Your Order? (Y/N): \n");
			option = scan.nextLine();
			if(option.equals("Y"))
			{
				breakD3 = true;
				check = false;
			}
			else if(option.equals("N"))
			{
				breakD3 = false;
				check = true;
			}
			if(check)
			{
				continue;
			}
		}while(check == true);//1st do-while
		
		fill = 10.0 + rand.nextDouble() * 10.0;
		fill = (double)Math.round(fill*100)/100;
		
		total = fill * gasP + washP; 
		total = (double)Math.round(total*100)/100;
		
		System.out.printf("\nIt took " + fill + " gallons to fill your car.");
		System.out.printf("\nYour total is $" + total + ".");
		System.out.printf("\nPlease enter a payment amount in the following format: \n");
		System.out.println("<amount><space><type>");
		System.out.println("<amount> is an integer");
		System.out.println("<space> is a blank space");
		System.out.println("<type> is either 20s, 10s, 5s, or 1s");
		System.out.printf("You may enter as many times as you like. Each entry will be%nadded to your total until sufficient funds have been obtained.");
		
		do{
			System.out.printf("\n\nEnter your payment: ");
			payment = scan.nextLine();
			String[] amountArr = payment.split(" ");
			amount = Integer.parseInt(amountArr[0]);
			type = amountArr[1];
			System.out.println("You have added: " + amount + " " + type + " to your total.");
			if(type.equals("20s"))
			{
				pay += 20.00 * amount;
			}
			else if(type.equals("10s"))
			{
				pay += 10.00 * amount;
			}
			else if(type.equals("5s"))
			{
				pay += 5.00 * amount;
			}
			else if(type.equals("1s"))
			{
				pay += 1.00 * amount;
			}
			if(total > pay)
			{
				double owe = (double)Math.round((total-pay)*100)/100;
				System.out.println("You still owe $" + owe + ".");
			}
			change = pay - total;
		}while(pay <= total);//while close
		do{
			if((change / 20) >= 1)
				{
					change = change - 20;
					change = (double)Math.round((change)*100)/100;
					tw++;
				}
				else if((change / 10) >= 1)
				{
					change = change - 10;
					change = (double)Math.round((change)*100)/100;
					tn++;
				}
				else if((change / 5) >= 1)
				{
					change = change - 5;
					change = (double)Math.round((change)*100)/100;
					f++;
				}		
				else if((change / 1) >= 1)
				{
					change = change - 1;
					change = (double)Math.round((change)*100)/100;
					o++;
				}
				else if((change / .25) >= 1)
				{
					change = change - .25;
					change = (double)Math.round((change)*100)/100;
					q++;
				}	
				else if((change / .10) >= 1)
				{
					change = change - .10;
					change = (double)Math.round((change)*100)/100;
					d++;			
				}
				else if((change / .05) >= 1)
				{
					change = change - .05;
					change = (double)Math.round((change)*100)/100;
					n++;
				}
				else if((change / .01) >= 1)
				{
					change = change - .01;
					change = (double)Math.round((change)*100)/100;
					p++;
				}
			}while(change > 0);
			
			System.out.printf("\n\nYour Change is: \n");
			if(tw == 1)
			{
				System.out.println(tw + " twenty-dollar bill");
			}
			else
				System.out.println(tw + " twenty-dollar bills");
			if(tn == 1)
			{
				System.out.println(tn + " ten-dollar bill");
			}
			else
				System.out.println(tn + " ten-dollar bills");	
			if(f == 1)
			{
				System.out.println(f + " five-dollar bill");
			}
			else
				System.out.println(f + " five-dollar bills");
			if(o == 1)
			{
				System.out.println(o + " one-dollar bill");
			}
			else
				System.out.println(o + " one-dollar bills");
			if(q == 1)
			{
				System.out.println(q + " quarter,");
			}
			else
				System.out.println(q + " quarters,");
			if(d == 1)
			{
				System.out.println(d + " dime,");
			}	
			else
				System.out.println(d + " dimes,");
			if(n == 1)
			{
				System.out.println(n + " nickel, and ");
			}	
			else
				System.out.println(n + " nickels, and ");
			if(p == 1)
			{
				System.out.println(p + " penny");
			}
			else
				System.out.println(p + " pennies");
			
			System.out.println("-------------------------------------------");			
			System.out.printf("Thank you for shopping at SCI Gas Station!!\n");
			check = true;
			if(check)
			{
				continue;
			}
		}while(check == true);//4th do-while	
	} //main method close
} //class close
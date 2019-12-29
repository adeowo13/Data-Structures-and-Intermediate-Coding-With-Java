/*
Ade Owodunni
CS401
Spring 2018
Assignment 1
*/

import java.util.Scanner;
import java.text.DecimalFormat;
public class CoffeeShop
{
	public static void main(String [] args)
	{
	final double COFFEE = 1.50;
	final double LATTE = 3.50;
	final double CAPPUCHINO = 3.25;
	final double ESPRESSO = 2.00;
	final double SCONE = 2.50;
	final double MUFFIN = 3.00;
	double quantity = 0.0;
	double price = 0.0;
	double amount = 0.0;
	Scanner keyboard = new Scanner(System.in);
	String name = new String("");
	int item = 0;
	double discount = 0.0;
	double discountPrice = 0.0;
	double tax = 0.0;
	double finalPrice = 0.0;
	double total = 0.0;
	double newItem = 0.0;
	double newQuantity = 0.0;
	int paymentType = 0;
	boolean isFood = false;
	int secondYes = 0;
	
	System.out.println(" Welcome, what is your name please? ");
	name = keyboard.nextLine();
	
	System.out.println(" Hi " + name + ", That is a lovely name, what can I get for you today? ");
	System.out.println(" 1. COFFEE - $1.50");
	System.out.println(" 2. LATTE - $3.50");
	System.out.println(" 3. CAPPUCCINO - $3.25");
	System.out.println(" 4. ESPRESSO - $2.00");
	System.out.println(" 5. SCONE - $2.50");
	System.out.println(" 6. MUFFIN - $3.00");
	
	System.out.println(" Please insert the item number: ");
	item = keyboard.nextInt();
		
		// switch  statement for original choice
		switch (item)
		{
		case 1:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * COFFEE;
		break;
		
		case 2:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * LATTE;
		break;
		
		case 3:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * CAPPUCHINO;
		break;
		
		case 4:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * ESPRESSO;
		break;
		
		case 5:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * SCONE;
		isFood = true;
		break;
		
		case 6:
		System.out.println(" Please insert the quantity that you would like: ");
		quantity = keyboard.nextDouble();
		price = quantity * MUFFIN;
		isFood = true;
		break;
		}
		//boolean used to ask for second choice
		if (isFood)
		{
		System.out.println("Would you like to add a drink? Press 1 for yes and 0 for no.");
		secondYes = keyboard.nextInt();
		
			if (secondYes == 1)
			{
			System.out.println(" 1. COFFEE - $1.50");
			System.out.println(" 2. LATTE - $3.50");
			System.out.println(" 3. CAPPUCCINO - $3.25");
			System.out.println(" 4. ESPRESSO - $2.00");
			
			System.out.println(" Please insert the item number: ");
			item = keyboard.nextInt();
			
				switch (item)
				{
				case 1:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * COFFEE);
				break;
		
				case 2:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * LATTE);
				break;
		
				case 3:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * CAPPUCHINO);
				break;
		
				case 4:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * ESPRESSO);
				break;
				}
			}
		}
		
		else 
		{
		System.out.println("Would you like to add a food? Press 1 for yes and 0 for no.");
		secondYes = keyboard.nextInt();
		
			System.out.println(" 5. SCONE - $2.50");
			System.out.println(" 6. MUFFIN - $3.00");
	
			System.out.println(" Please insert the item number: ");
			item = keyboard.nextInt();
	
			
			if (secondYes == 1)
			{
				switch (item)
				{
				case 5:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * SCONE);
				break;
		
				case 6:
				System.out.println(" Please insert the quantity that you would like: ");
				quantity = keyboard.nextDouble();
				price = price + (quantity * MUFFIN);
				break;
				}
			}
		}

		if (price >= 10) // checks for discount
		{
		 discount= price / 10;
		 price = price - discount;
		}
	 tax = price * .07;
	 price = price - tax;
	
	System.out.println("Your total will be $" + new DecimalFormat("#0.00").format(price));
	System.out.println("Cash or credit? 1 for cash 0 for credit.");
	paymentType = keyboard.nextInt();
	
		if(paymentType ==1)
		{
		System.out.println("Okay, enter your amount of cash: ");
		amount = keyboard.nextDouble();
			if(amount < price)
			{
			System.out.println("Oops! Sorry, but that is insufficient funds!");
			}
			else
			{
			System.out.println("Thank you! Please stop by again!");
			}
		}
		else
		{
		System.out.println("Your credit card went through, please come back again soon!");
		}
	}
}
	/*System.out.println(" Would you like to add an espresso drink or snack to your order? Enter 1 for yes or 2 for no ");
	addition = keyboard.nextInt();*/
		
		/* if(orderStatus[i-1] == 0)
                                {
                    

                                    while (inputFile.hasNextLine())
                                    {
                                        list.add(inputFile.nextLine());
                                    }

                                    receivedOrders[i-1] = list.get(i-1);
                                    orderStatus[i-1] = 1;
                                }

	
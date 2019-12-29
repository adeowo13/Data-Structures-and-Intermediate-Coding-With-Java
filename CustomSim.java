import java.util.Random;
import java.util.Scanner;

public class CustomerSim {
  public static void main(String[] args) {
    final double COFFEE_PRICE = 1.5;
    final double LATTE_PRICE = 3.5;
    final double CAPPUCCINO_PRICE = 3.25;
    final double ESPRESSO_PRICE = 2.0;

    int itemNumber, quantity, numCustomers, simulateAgain;
    String itemName = "";
    double totalCost = 0.0;
    Random randomNumbers = new Random();
    Scanner keyboard = new Scanner(System.in);

    // add a do-while loop to allow for multiple simulations
    do {
      // prompt the user for the number of customers
      System.out.print("\nHow many customers would you like to simulate? ");
      numCustomers = keyboard.nextInt();

      // generate the random numbers for item
      // and quantity
      // 0 - Coffee
      // 1 - Latte
      // 2 - Cappuccino
      // 3 - Espresso
      //
      // assumption: quantity is in range 1 - 5

      // print the table header
      System.out.printf("\n%-15s%-15s%12s%18s\n", "Customer", "Selection", "Quantity", "Total Cost($)");
      System.out.printf("%-15s%-15s%12s%18s\n", "--------", "---------", "--------", "--------------");

      for (int i = 1; i <= numCustomers; i++)
      {
        itemNumber = randomNumbers.nextInt(4);
        quantity = randomNumbers.nextInt(5) + 1;

        // determine which item was purchased and
        // calculate the total cost

        switch(itemNumber) {
          case 0:   // Coffee
            itemName = "Coffee";
            totalCost = quantity * COFFEE_PRICE;
            break;
          case 1:   // Latte
            itemName = "Latte";
            totalCost = quantity * LATTE_PRICE;
            break;
          case 2:   // Cappuccino
            itemName = "Cappuccino";
            totalCost = quantity * CAPPUCCINO_PRICE;
            break;
          case 3:   // Espresso
            itemName = "Espresso";
            totalCost = quantity * ESPRESSO_PRICE;
            break;
        }

        System.out.printf("%-15s%-15s%12d%18.2f\n",
            "Customer " + i,
            itemName,
            quantity,
            totalCost);
      } // end of for loop

      // prompt the user to run another simulation or exit
      System.out.print("\nEnter 1 to run another simulation or 0 to exit: ");
      simulateAgain = keyboard.nextInt();

    } while(simulateAgain == 1);  // end of do-while
	
    System.out.println("Goodbye!");

  }
}







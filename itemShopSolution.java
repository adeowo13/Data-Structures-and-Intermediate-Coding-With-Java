



import java.util.Scanner;
public class ItemShopSolution
{
        public static void main(String[] args)
        {
                final int LONG_SWORD_COST = 120;
                final int SHORT_SWORD_COST = 90;
                final int MACE_COST = 80;
                final int MAGIC_RING_COST = 150;
                final int HEALING_POTION_COST = 10;

                int userGoldCoins, itemChoice, quantity;
                int discount = 0, totalCost = 0, finalCost = 0;
                String userName, itemName = "";

                Scanner keyboard = new Scanner(System.in);

                System.out.print("\nEnter your name: ");
                userName = keyboard.nextLine();

                System.out.print("Enter your number of gold coins: ");
                userGoldCoins = keyboard.nextInt();

                System.out.printf("\nWelcome to The Item Shop, %s!\n\n", userName);
                System.out.println("Here's what we have for sale (all prices are in units of gold):\n");

                System.out.printf("1. %-18s%-3d\n", "Long Sword", 120);
                System.out.printf("2. %-18s%-3d\n", "Short Sword", 90);
                System.out.printf("3. %-18s%-3d\n", "Mace", 80);
                System.out.printf("4. %-18s%-3d\n", "Magic Ring", 150);
                System.out.printf("5. %-18s%-3d\n", "Healing Potion", 10);

                System.out.print("\nPlease enter the item number: ");
                itemChoice = keyboard.nextInt();

                System.out.print("Please enter the quantity: ");
                quantity = keyboard.nextInt();

                switch(itemChoice)
                {
                        case 1:
                                itemName = "Long Sword";
                                totalCost = LONG_SWORD_COST * quantity;
                                break;
                        case 2:
                                itemName = "Short Sword";
                                totalCost = SHORT_SWORD_COST * quantity;
                                break;
                        case 3:
                                itemName = "Mace";
                                totalCost = MACE_COST * quantity;
                                break;
                        case 4:
                                itemName = "Magic Ring";
                                totalCost = MAGIC_RING_COST * quantity;
                                break;
                        case 5:
                                itemName = "Healing Potion";
                                totalCost = HEALING_POTION_COST * quantity;
                                break;
                }

                if (quantity > 2)
                        discount = (int) (totalCost * 0.1);

                finalCost = totalCost - discount;

                System.out.printf("\n%-10s: %5d gold", "Total cost", totalCost);
                System.out.printf("\n%-10s: %5d gold", "Discount", discount);
                System.out.printf("\n%-10s: %5d gold", "Final cost", finalCost);

                if (userGoldCoins < finalCost)
                        System.out.println("\n\nYou have insufficient funds! Please come back with more gold!\n");
                else
                        System.out.printf("\n\nThank you, %s! Your transaction is complete! Please stop by again!\n\n", userName);
        }
}
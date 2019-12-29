/*Adetokunbo Owodunni
Cs007
Fall 2017
Assignment 4
*/
import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class AdventureGameV3
{
        public static void main(String[] args) throws IOException
        {
                final int SHORT_SWORD_MIN = 1;
                final int SHORT_SWORD_MAX = 4;
                final int LONG_SWORD_MIN = 3;
                final int LONG_SWORD_MAX = 7;
                final int JUMP_KICK_MIN = 2;
                final int JUMP_KICK_MAX = 6;
                final int AXE_MIN = 2;
                final int AXE_MAX = 6;
                final int FIRE_BLAST_MIN = 4;
                final int FIRE_BLAST_MAX = 10;

                final int ROGUE_INIT_HP = 55;
                final int ROGUE_INIT_STRENGTH = 8;
                final int PALADIN_INIT_HP = 35;
                final int PALADIN_INIT_STRENGTH = 14;
                final int CHAN_INIT_HP = 45;
                final int CHAN_INIT_STRENGTH = 10;

                final int MINION_INIT_HP = 25;
                final int GOBLIN_INIT_STRENGTH = 4;
                final int SKELETON_INIT_STRENGTH = 3;
                final int WIZARD_INIT_HP = 40;
                final int WIZARD_INIT_STRENGTH = 8;

                final int NUM_GOBLINS = 3;
                final int NUM_SKELETONS = 5;
                final int HP_HOLDER = 0, STRENGTH_HOLDER = 1, DAMAGE_MIN = 2, DAMAGE_MAX = 3;
                
                /* 
                final int enemyStrength = 0;
				final int enemyDamageMin = 1;
				final int enemyDamageMax = 2;
				
                String playerName = "";
                
                0- HP
                1- Strength
                2- Damage Min
                3- Damage Max
                
                
                int[] playerAttributes = new int[4];
                String enemyName = "";
                int[] enemyAttributes = new int[3];
                Random randomNums
                int characterChoice = 0, pathChoice = 0, itemChoice = 0, numEnemies = 0;
                String pathName = "";

                int playerDamage, playerATK;
                int enemyDamage, enemyATK;
                
                */
                
                String playerName = "";
                int playerValues[] = new int[4];
                
                String enemyName = "";
                int enemyValues[] = new int[4];

                int characterChoice = 0, pathChoice = 0, itemChoice = 0, numEnemies = 0;
                String pathName = "";

                int playerDamage, playerATK;
                int enemyDamage, enemyATK;

                int playerActionChoice, randomNumAnswer, randomNumGuess;
                String weaponType = "";

                Scanner keyboard = new Scanner(System.in);
                Random randomNums = new Random();


		File gameHistory = new File("PreviousGameResults.txt");
		
			//System.out.println 

                System.out.println("\nAdventure Game - Start!\n");
                System.out.println("Would you like to see your previous gaming results? Press '1' for yes, otherwise use '2' for no.");
                	if(keyboard.nextInt() == 1)
                	{
                		keyboard.nextLine();
                		System.out.println("Character\tWeapon\t\tHP\tPath\t\tWon Game");
                		System.out.println("---------\t------\t\t--\t----\t\t--------");
                			if(gameHistory.exists() )
                			{
                				Scanner inputFile = new Scanner(gameHistory);
                				while(inputFile.hasNext())
                				{
                					System.out.printf("%-11s\t%-14s\t%2s\t%-13s\t%-10s\n", inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine(), inputFile.nextLine() );
                				}
                				inputFile.close();
                			}
                	}
                
                System.out.println("Here are the characters:");
                System.out.println("1. Rogue\n2. Paladin\n3. Jackie Chan\n");

                System.out.print("Which character do you choose?: ");
                characterChoice = keyboard.nextInt();
                
                keyboard.nextLine();
                switch(characterChoice)
                {
                        case 1:
                                playerName = "Rogue";
                                playerValues[HP_HOLDER] = ROGUE_INIT_HP;
                                playerValues[STRENGTH_HOLDER] = ROGUE_INIT_STRENGTH;
                                weaponType = "Short Sword";
                                playerValues[DAMAGE_MIN] = SHORT_SWORD_MIN;
                                playerValues[DAMAGE_MAX] = SHORT_SWORD_MAX;
                                break;
                        case 2:
                                playerName = "Paladin";
                                playerValues[HP_HOLDER] = PALADIN_INIT_HP;
                                playerValues[STRENGTH_HOLDER] = PALADIN_INIT_STRENGTH;
                                weaponType = "Long Sword";
                               	playerValues[DAMAGE_MIN] = LONG_SWORD_MIN;
                                playerValues[DAMAGE_MAX] = LONG_SWORD_MAX;
                                break;
                        case 3:
                                playerName = "Jackie Chan";
                                playerValues[HP_HOLDER] = CHAN_INIT_HP;
                                playerValues[STRENGTH_HOLDER] = CHAN_INIT_STRENGTH;
                                weaponType = "Jump Kick";
                                playerValues[DAMAGE_MIN] = JUMP_KICK_MIN;
                                playerValues[DAMAGE_MAX] = JUMP_KICK_MAX;
                                break;
                }

                System.out.printf("\nYou chose: %s\n\n", playerName);

                System.out.print("The Evil Wizard must be defeated! He is in The Castle. To get to ");
                System.out.println("The Castle, you must travel through either:");
                System.out.println("1. The Forest\n2. The Graveyard\n");

                System.out.print("Which path will you take?: ");
                pathChoice = keyboard.nextInt();
				
				keyboard.nextLine();
                switch(pathChoice)
                {
                        case 1:
                                pathName = "The Forest";
                                enemyName = "Goblin";
                                enemyValues[STRENGTH_HOLDER] = GOBLIN_INIT_STRENGTH;
                                enemyValues[DAMAGE_MIN] = AXE_MIN;
                                enemyValues[DAMAGE_MAX] = AXE_MAX;
                                numEnemies = NUM_GOBLINS;
                                break;
                        case 2:
                                pathName = "The Graveyard";
                                enemyName = "Skeleton";
                                enemyValues[STRENGTH_HOLDER] = SKELETON_INIT_STRENGTH;
                                enemyValues[DAMAGE_MIN] = SHORT_SWORD_MIN;
                                enemyValues[DAMAGE_MAX] = SHORT_SWORD_MAX;
                                numEnemies = NUM_SKELETONS;
                                break;
                }

                System.out.printf("\nYou chose: %s\n\n", pathName);
                System.out.printf("Once you enter %s, you encounter %d %ss! Time for battle!\n\n", pathName,
                                  numEnemies, enemyName);

                for (int i = 1; i <= numEnemies; i++)//minion battle
                {
                        enemyValues[HP_HOLDER] = MINION_INIT_HP;

                        System.out.printf("***%s vs %s %d***\n", playerName, enemyName, i);

                        while(enemyValues[HP_HOLDER] > 0 && playerValues[HP_HOLDER] > 0)
                        {
                                playerDamage = randomNums.nextInt(playerValues[DAMAGE_MAX] - playerValues[DAMAGE_MIN] + 1) + playerValues[DAMAGE_MIN];
                                playerATK = playerValues[STRENGTH_HOLDER] + playerDamage;
                                enemyValues[HP_HOLDER] -= playerATK;
                                System.out.printf("%s attacks with ATK = %d + %d = %d\n", playerName, playerValues[STRENGTH_HOLDER], playerDamage, playerATK);
                                System.out.printf("%s HP is now %d - %d = %d\n\n", enemyName, enemyValues[HP_HOLDER] + playerATK, playerATK, enemyValues[HP_HOLDER]);

                                if (enemyValues[HP_HOLDER] <= 0)
                                        break;

                                enemyDamage = randomNums.nextInt(enemyValues[DAMAGE_MAX] - enemyValues[DAMAGE_MIN] + 1) + enemyValues[DAMAGE_MIN];
                                enemyATK = enemyValues[STRENGTH_HOLDER] + enemyDamage;
                                playerValues[HP_HOLDER] -= enemyATK;
                                System.out.printf("%s attacks with ATK = %d + %d = %d\n", enemyName, enemyValues[STRENGTH_HOLDER], enemyDamage, enemyATK);
                                System.out.printf("%s HP is now %d - %d = %d\n\n", playerName, playerValues[HP_HOLDER] + enemyATK, enemyATK, playerValues[HP_HOLDER]);
                                
                                System.out.println("Press enter to continue...");
                                keyboard.nextLine(); //Smoothens the gameplay
                        } // end of while loop

                        if (playerValues[HP_HOLDER] > 0)
                                System.out.printf("%s defeated %s %d!\n\n", playerName, enemyName, i);
                        else
                        {
                                System.out.printf("--%s is defeated in battle!--\n\nGAME OVER\n", playerName);
                                System.exit(0);
                        }
                } // end of for loop

                System.out.printf("Your HP is: %d\n\n", playerValues[HP_HOLDER]);

                System.out.println("Please choose a reward.\n1. Healing Potion\n2. Ring of Strength\n3.) Staff of Power");
                System.out.print("Which item do you choose?: ");
                itemChoice = keyboard.nextInt();

				keyboard.nextLine();
                switch(itemChoice)
                {
                        case 1:
                                System.out.println("\nYou chose: Healing Potion\n");
                                playerValues[HP_HOLDER] += 10;
                                System.out.printf("Your HP has increased to %d + %d = %d!\n\n", playerValues[HP_HOLDER] - 10, 10, playerValues[HP_HOLDER]);
                                break;
                        case 2:
                                System.out.println("\nYou chose: Ring of Strength\n");
                                playerValues[STRENGTH_HOLDER] += 5;
                                System.out.printf("Your Strength has increased to %d + %d = %d!\n\n", playerValues[STRENGTH_HOLDER] - 5, 5, playerValues[STRENGTH_HOLDER]);
                                break;
                                
                        case 3: //new addition to the game(another weapon)
                        		System.out.println("\nYou chose: Staff of Power\n");
                        		weaponType = "Staff of Power";
                        		playerValues[DAMAGE_MIN] = 5;
                        		playerValues[DAMAGE_MAX] = 9;
                        		System.out.println("You know have gained a damage minimum of 5 and maximum of 9 to assist you on your quest! Good luck!");
                }

                System.out.println("You have now reached The Castle! Time to battle The Evil Wizard!\n");

                enemyName = "Wizard";
                enemyValues[HP_HOLDER] = WIZARD_INIT_HP;
                enemyValues[STRENGTH_HOLDER] = WIZARD_INIT_STRENGTH;
                enemyValues[DAMAGE_MIN] = FIRE_BLAST_MIN;
                enemyValues[DAMAGE_MAX] = FIRE_BLAST_MAX;

                randomNumAnswer = randomNums.nextInt(6) + 1;

                System.out.printf("***%s vs The Evil Wizard***\n", playerName);
                while(playerValues[HP_HOLDER] > 0 && enemyValues[HP_HOLDER] > 0)//wizard battle
                {
                        System.out.println("Choose your action:\n1. Attack\n2. Attempt Spell Cast\n");
                        System.out.print("What would you like to do: ");
                        playerActionChoice = keyboard.nextInt();
						
						keyboard.nextLine();
                        switch(playerActionChoice)
                        {
                                case 1://hand to hand combat
                                        playerDamage = randomNums.nextInt(playerValues[DAMAGE_MAX] - playerValues[DAMAGE_MIN] + 1) + playerValues[DAMAGE_MIN];
                                        playerATK = playerValues[STRENGTH_HOLDER] + playerDamage;
                                        enemyValues[HP_HOLDER] -= playerATK;
                                        System.out.printf("\n%s attacks with ATK = %d + %d = %d\n", playerName, playerValues[STRENGTH_HOLDER], playerDamage, playerATK);
                                        System.out.printf("%s HP is now %d - %d = %d\n\n", enemyName, enemyValues[HP_HOLDER] + playerATK, playerATK, enemyValues[HP_HOLDER]);
                                        break;
                                        
                                case 2://spell cast
                                        System.out.print("Enter your guess: ");
                                        randomNumGuess = keyboard.nextInt();
                                        if (randomNumGuess == randomNumAnswer)
                                        {
                                                System.out.println("\nCorrect!\n");
                                                System.out.printf("The %s's spell is cast successfully! The Wizard's HP is now 0!\n\n", playerName);
                                                enemyValues[HP_HOLDER] = 0;
                                        }
                                        else
                                                System.out.println("\nIncorrect! The spell cast fails!\n");
                                        break;
                        }

                        if (enemyValues[HP_HOLDER] <= 0)
                                break;

                        enemyDamage = randomNums.nextInt(enemyValues[DAMAGE_MAX] - enemyValues[DAMAGE_MIN] + 1) + enemyValues[DAMAGE_MIN];
                        enemyATK = enemyValues[STRENGTH_HOLDER] + enemyDamage;
                        playerValues[HP_HOLDER] -= enemyATK;
                        System.out.printf("%s attacks with ATK = %d + %d = %d\n", enemyName, enemyValues[STRENGTH_HOLDER], enemyDamage, enemyATK);
                        System.out.printf("%s HP is now %d - %d = %d\n\n", playerName, playerValues[HP_HOLDER] + enemyATK, enemyATK, playerValues[HP_HOLDER]);

                } // end of while loop

                if (playerValues[HP_HOLDER] > 0)
                {
                        System.out.printf("--%s wins the battle!--\n\n", playerName);
                        System.out.println("You win! Congratulations!");
                }
                else
                {
                        System.out.printf("--%s is defeated in battle!--\n\nGAME OVER\n", playerName);
                }

			FileWriter fwriter = new FileWriter("PreviousGameResults.txt",true);
			PrintWriter saveFile = new PrintWriter(fwriter);
			saveFile.println(playerName);
			saveFile.println(weaponType);
			saveFile.println(playerValues[HP_HOLDER]);
			saveFile.println(pathName);
			if(playerValues[HP_HOLDER] > 0) //stores whether the player was actually won the game or otherwise
				saveFile.println("Yes");
			else
				saveFile.println("No");
				
		saveFile.close();
		
        } // end of main
} // end of class
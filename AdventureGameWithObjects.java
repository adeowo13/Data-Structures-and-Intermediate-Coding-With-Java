import java.util.Scanner;
import java.util.Random;

public class AdventureGameWithObjects
{
        public static void main(String[] args)
        {
         
                Scanner keyboard = new Scanner(System.in);
                Random randomNums = new Random();
				Player player = null;
				Enemy goons = null;
				Enemy wizard = Enemy.getWizard();
				int numEnemies = 0;
				int fights = 0;
				String pathname = " ";
                System.out.println("\nAdventure Game - Start!\n");
                System.out.println("Here are the characters:");
                System.out.println("1. Rogue\n2. Paladin\n3. Jackie Chan\n");

                System.out.print("Which character do you choose?: ");
                int characterChoice = keyboard.nextInt();

                switch(characterChoice)
                {
                        case 1:
                                /*playerName = "Rogue";
                                playerHP = ROGUE_INIT_HP;
                                playerStrength = ROGUE_INIT_STRENGTH;
                                playerDamageMin = SHORT_SWORD_MIN;
                                playerDamageMax = SHORT_SWORD_MAX;*/
                                player = Player.getRogue();
                                break;
                        case 2:
                                /*playerName = "Paladin";
                                playerHP = PALADIN_INIT_HP;
                                playerStrength = PALADIN_INIT_STRENGTH;
                                playerDamageMin = LONG_SWORD_MIN;
                                playerDamageMax = LONG_SWORD_MAX;*/
                                player = Player.getPaladin();
                                break;
                        case 3:
                                /*playerName = "Jackie Chan";
                                playerHP = CHAN_INIT_HP;
                                playerStrength = CHAN_INIT_STRENGTH;
                                playerDamageMin = JUMP_KICK_MIN;
                                playerDamageMax = JUMP_KICK_MAX;*/
                                player = Player.getJackieChan();
                                break;
                }

                System.out.printf("\nYou chose: %s\n\n", player.getName());

                System.out.print("The Evil Wizard must be defeated! He is in The Castle. To get to ");
                System.out.println("The Castle, you must travel through either:");
                System.out.println("1. The Forest\n2. The Graveyard\n");

                System.out.print("Which path will you take?: ");
                int pathChoice = keyboard.nextInt();

                switch(pathChoice)
                {
                        case 1:
                                
                                /*enemyName = "Goblin";
                                enemyStrength = GOBLIN_INIT_STRENGTH;
                                enemyDamageMin = AXE_MIN;
                                enemyDamageMax = AXE_MAX;*/
                                System.out.println("You chose: The Forest");
                                goons = Enemy.getGoblins();
                                numEnemies = goons.getNumGoblins();
                                break;
                        case 2:
                                
                                /*enemyName = "Skeleton";
                                enemyStrength = SKELETON_INIT_STRENGTH;
                                enemyDamageMin = SHORT_SWORD_MIN;
                                enemyDamageMax = SHORT_SWORD_MAX;*/
                                System.out.println("You chose: The Graveyard");
                                goons = Enemy.getSkeletons();
                                numEnemies = goons.getNumSkeletons();
                                break;
                }

                for (int i = 1; i <= numEnemies; i++)
                {
              		goons.resetHitPoints();
              		fights++;
              		player.fightGoons(goons);
              		
                        if(player.isDefeated())
                        {
                                System.out.printf("--%s is defeated in battle!--\n\nGAME OVER\n", player.getName());
                                System.exit(0);
                        }
                        else
                        {
                        		System.out.print("Press Enter to Continue.....");
                        			if(fights == 0)
                        		keyboard.nextLine();
                        		keyboard.nextLine();
                        	System.out.println();
                        }
                } // end of for loop

                System.out.printf("Your HP is: %d\n\n", player.getHitPoints());

                System.out.println("Please choose a reward.\n1. Healing Potion\n2. Ring of Strength\n3. Staff of Power\n");
                System.out.print("Which item do you choose?: ");
                int itemChoice = keyboard.nextInt();

                switch(itemChoice)
                {
                        case 1:
                                System.out.println("\nYou chose: Healing Potion\n");
                                player.increaseHitPoints(10);
                                System.out.printf("Your HP has increased to %d + %d = %d!\n\n", player.getHitPoints() - 10, 10, player.getHitPoints());
                                break;
                        case 2:
                                System.out.println("\nYou chose: Ring of Strength\n");
                                player.increaseStrength(5);
                                System.out.printf("Your Strength has increased to %d + %d = %d!\n\n", player.getStrength() - 5, 5, player.getStrength());
                                break;
                        case 3:
                        		System.out.println("\nYou chose: Staff of Power\n");
                        		player = Player.staffOfPowerAddition();
                        		break;
                }

                System.out.println("You have now reached The Castle! Time to battle The Evil Wizard!\n");

                /*enemyName = "Wizard";
                enemyHP = WIZARD_INIT_HP;
                enemyStrength = WIZARD_INIT_STRENGTH;
                enemyDamageMin = FIRE_BLAST_MIN;
                enemyDamageMax = FIRE_BLAST_MAX;
                randomNumAnswer = randomNums.nextInt(6) + 1;*/

                System.out.printf("***%s vs The Evil Wizard***\n", player.getName());
                player.fightWizard(wizard);
                
                if (player.getHitPoints() > 0)
                {
                        System.out.printf("--%s wins the battle!--\n\n", player.getName());
                        System.out.println("You win! Congratulations!");
                }
                else
                {
                        System.out.printf("--%s is defeated in battle!--\n\nGAME OVER\n", player.getName());
                }

        } // end of main
/*
	public Player(String _name, int _hitPoints, int _strength, weapon _weapon)
	{
		name = _name;
		hitPoints = _hitPoints;
		strength = _strength;
		weapon = _weapon;
	}
	public static getName()
	{
	
	}
	public static getHitPoints()
	{
	
	}
	public static increaseHitPoints(_pointIncrease)
	{
	
	}
	public static decreaseHitPoints(_pointDecrease)
	{
	
	}
	public static getStrength()
	{
	
	}
	public static increaseStrength(_strengthIncrease)
	{
	
	}       
	public static setWeapon(_weapon)
	{
	
	}
	public static attack(_enemy)
	{
	
	}
	public static battleMinion(_enemy)
	{
	
	}
	public static battleWizard(_enemy)
	{
	
	}
	public static isDefeated()
	{
	
	}
*/
        
} // end of class
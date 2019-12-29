import java.util.*;
public class Yahtzee
{
	public static String name;
	public static int total = 0;
	public static DieInterface [] dice = new DieInterface[5];
	public static ScoreInterface [] score = new ScoreInterface[13];
	public static ScoreInterface [] Uscore = new ScoreInterface[14];
	public static void scoreCardImage()
	{
		String top = "+----------------------+";
		String bottom = "+----------------------+";
		String side = "|";
		StringBuilder sc = new StringBuilder();
		sc.append(top);
		sc.append("\n" + side);  
		sc.append("\n" + "  Name:   " + name);
	}
	public static void main(String []args)
	{
		String choosenScore;
		int rCounter;
		Scanner s = new Scanner(System.in);
		boolean continueGame = true;
		boolean rolled = true;
		ArrayList<Integer>DiceKept = new ArrayList<Integer>();
		ArrayList<ScoreInterface>ScoresKept = new ArrayList<ScoreInterface>();
		
main: do{
			System.out.println("Welcome! Would you like to play Yahtzee?? (Y/N)");
			String input = s.nextLine();
			if(input.equals("Y") || input.equals("y"))
			{
				System.out.println("What is your name?");
				name = s.nextLine();
				
				for(int i = 0; i < score.length; i++)
				{
					switch(i)
					{
						case 0:
							score[i] = new UpperSectionScore("           Ones", i+1);
							break;
						case 1:
							score[i] = new UpperSectionScore("           Twos", i+1);
							break;
						case 2:
							score[i] = new UpperSectionScore("         Threes", i+1);
							break;
						case 3:
							score[i] = new UpperSectionScore("          Fours", i+1);
							break;
						case 4:
							score[i] = new UpperSectionScore("          Fives", i+1);
							break;
						case 5:
							score[i] = new UpperSectionScore("          Sixes", i+1);
							break;
						case 6:
							score[i] = new Kind("Three of a Kind", 3);
							break;
						case 7:
							score[i] = new Kind(" Four of a Kind", 4);
							break;
						case 8:
							score[i] = new FullHouse("     Full House");
							break;
						case 9:
							score[i] = new Straight(" Small Straight", 4);
							break;
						case 10:
							score[i] = new Straight(" Large Straight", 5);
							break;
						case 11:
							score[i] = new Chance("         Chance");
							break;
						case 12:
							score[i] = new Kind("        Yahtzee", 5);
							break;
					}//switch
				}//for
				for(int a = 0; a < score.length; a++)
				{
					ScoresKept.add(score[a]);
				}
				for(int b = 0; b < 5; b++)
				{
					dice[b] = new Die();
				}
				rCounter = 1;
				scoreCardImage();
				while(rCounter < 14)
				{
					System.out.println("First Roll");
					for(int c = 0; c < dice.length; c++)
					{
						dice[c].roll();
					}
					System.out.println(DieInterface.toDiceString(dice));
					System.out.println("Which would you like to keep?(Number followed by single space =)");
					System.out.println("IF NONE SHALL BE KEPT, PRESS ENTER...");
					String choose = s.nextLine();
					String [] kDice = choose.split(" ");
					if(choose.equals(""))
					{
						for(int d = 0; d < kDice.length; d++)
						{
							DiceKept.add(0);
						}
					}
					else
					{
						for(int e = 0; e < kDice.length; e++)
						{
							DiceKept.add(Integer.parseInt(kDice[e]));
						}
					}
				}//while
					System.out.println("Final Score: ");
					scoreCardImage();
					System.out.println("\n\n");
			}//if
			else
			{
				break main;
			}//else
		}while(continueGame);
		System.out.println("G_BYE!!");
	}	
}
/*
Ade Owodunni
CS0401
Project 3
*/
import java.util.*;
import java.io.File;
public class Bingo
{
public static int nP;
public static double pot;
public static double house;
public static ArrayList<BingoPlayer> players = new ArrayList <BingoPlayer>();
public static BingoCage bCage;
public static ArrayList<BingoBall> balls = new ArrayList <BingoBall>();
	public static void Filer(File f, Scanner s)
	{
		while(s.hasNextLine())
		{
			house = Double.parseDouble(s.next());
			nP = Integer.parseInt(s.next());
			for(int i = 0; i < nP; i++)
			{
				String stats = s.next();
				String[] splitter = stats.split(",");
				String fName = splitter[0];
				String lName = splitter[1];
				double money = Double.parseDouble(splitter[2]);
				BingoPlayer player = new BingoPlayer(fName, lName, money);
				players.add(player);
			}
		}
	}
	public static void main(String []args) throws Exception
	{

				File playersF = new File("players.txt");
				Scanner s = new Scanner(playersF);
				Scanner scan = new Scanner(System.in);
				ArrayList<String> fake = new ArrayList<String>();
				ArrayList<BingoPlayer> fakeBP = new ArrayList<BingoPlayer>();
				pot = 0;
				for(BingoPlayer b : players)
				{
					fake.add(b.getFullName());
				}
				Collections.sort(fake);
				for(int a = 0; a < fake.size(); a++)
				{
					for(int d = 0; d < players.size(); d++)
					{
						if(players.get(d).getFullName().equals(fake.get(a)))
						{
							fakeBP.add(players.get(d));
						}
					}
					players.set(a, fakeBP.get(a));
				}
				for(int c = 0; c < players.size(); c++)
				{
					System.out.println(players.get(c));
				}
				Filer(playersF, s);
				System.out.println("******************************");
				System.out.println("* Welcome to SCI Bingo House *");
				System.out.println("******************************");
				System.out.println("These are all available players: ");
				for(int i = 0; i < players.size(); i++)
				{
					int g = 0;
					g++;
					System.out.println(g+ ". " + players.get(i).getFullName());
				}
				for(int e = 0; e < players.size(); e++)
				{
					System.out.println(players.get(e).getFullName() + " would you like to play this round? (y/n): ");
					String input = "";
					input = scan.nextLine();
					if(input.equals("Y") || input.equals("y"))
					{
						System.out.println("How many Bingo card would you like to buy? (1 - 4): ");
						String cs = scan.nextLine();
						double nCards = Double.parseDouble(cs);
						house = house + nCards;
						pot = pot + (nCards / 2);
						players.get(e).remove((int) nCards);
					}
				}
					
		}
}
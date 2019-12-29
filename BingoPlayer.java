/*
Ade Owodunni
CS0401
Project 3
*/
import java.util.*;
import java.lang.*;
public class BingoPlayer
{
private String fName;
private String lName;
private Double mon;
private int numC;
private ArrayList<BingoCard> hand = new ArrayList<BingoCard>();
private ArrayList<BingoCard> winners = new ArrayList<BingoCard>();
private boolean win;

	public BingoPlayer(String first, String last, double amount)
	{
		fName = first;
		lName = last;
		mon = amount;
		win = false;
	}
	public String getFullName()
	{
		String full = fName +"  "+ lName;
		return full;
	}
	public String getFullInfo()
	{
		String fullInfo =  fName +"  "+ lName+" ($"+ mon + ")";
		return fullInfo;
	}
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		for(int a = 0; a < hand.size(); a++)
		{
			if(hand.get(a) == null)
			{
				s.append("No Bingo Cards");
			}
			else
			{
				for(int i = 0; i < hand.size(); i++)
				{
					s.append(hand.get(i).toSideBySideString());
				}
			}
		}
		return s.toString();
	}
	public boolean isBingo()
	{
		win = false;
		int b = 0;
		int count = 0;
		int count2 = 0;
		for(int i = 0; i < hand.size(); i++)
		{
			BingoCard card = hand.get(i);
			for(int a = 0; a < 5; a++)
			{
				while(b < 5)
				{
					if(card.getNumber(a,b).isMarked())
					{
						count++;
					}
				}
				if(count == 5)
				{
					win = true;
					winners.add(card);
					return win;
				}
			}//vertical bingo row
			count = 0;
			for(int a = 0; a < 5; a++)
			{
				while(b < 5)
				{
					if(card.getNumber(b,a).isMarked())
					{
						count++;
					}
				}
				if(count == 5)
				{
					win = true;
					winners.add(card);
					return win;
				}
			}//horizontal bingo row
			count = 0;
			for(int c = 0; c < 5; c++)
			{
				int d = 4;
				if(card.getNumber(c,c).isMarked())
				{
					count++;
				}
				else if(card.getNumber(d,c).isMarked())
				{
					count2++;
				}
				d--;
			}//diagonal check
			if(count == 5 || count2 == 5)
			{
				win = true;
				winners.add(card);
				return win;
			}
		}// for loop
		return win;
	}
	public BingoCard[] getBingoCards()
	{
		BingoCard [] c = new BingoCard[4];
		for(int i = 0; i < winners.size(); i++)
		{
			c[i] = winners.get(i);
		}
		return c;
	}
	public int remove(int amount)
	{
		if(mon > amount)
		{
			mon = mon - amount;
			return amount;
		}
		else
		{
			int money = (int) Math.floor(mon);
			mon = mon - money;
			return money;
		}
	}
	public void add(double amount)
	{
		mon = mon + amount;
	}
	public void addBingoCards(BingoCard[] cards)
	{
		numC = 0;
		for(int i = 0; i < cards.length; i++)
		{
			if(cards[i]!= null)
			{
				numC++;
			}
		}
		if(mon >= numC)
		{
			for(int a = 0; a < numC; a++)
			{
				hand.add(cards[a]);
			}
		}
		else
		{
			System.out.println(getFullName() + " does not have enough for " + numC + " cards!");
		}
	}
	public void marks(int number)
	{
		for(int i = 0; i < hand.size(); i++)
		{
			BingoCard temp = hand.get(i);
			temp.mark(number);
		}
	}
	public void clear()
	{
		hand.clear();
	}
	public static void main(String []args) 
	{
			BingoPlayer aPlayer = new BingoPlayer("John", "Smith", 50.0);
          System.out.println(aPlayer.getFullName());
          System.out.println(aPlayer.getFullInfo());
          System.out.println("====");
          System.out.println(aPlayer);
          System.out.println("====");
          BingoCard[] cards = new BingoCard[3];
          cards[0] = new BingoCard();
          cards[1] = new BingoCard();
        	cards[2] = new BingoCard();
		 aPlayer.addBingoCards(cards);
		 System.out.println(aPlayer);
	}
}

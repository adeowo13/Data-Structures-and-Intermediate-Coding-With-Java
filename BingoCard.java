/*
Ade Owodunni
CS0401
Project 3
*/
import java.util.*;
public class BingoCard
{
private BingoNumber [][] bn;
private BingoNumber [][] sbs;
private Random r = new Random();
private int column;
private int max;
private	int min;
private boolean marked;
	public BingoNumber [] columnMaker(int i)
	{
		min = 0;
		max = 0;
		ArrayList<BingoNumber> columns = new ArrayList<BingoNumber>();
			switch(i)
			{
				case 0:
					min = 1;
					max = 15;
					break;
				case 1:
					min = 16;
					max = 30;
					break;
				case 2:
					min = 31;
					max = 45;
					break;
				case 3:
					min = 46;
					max = 60;
					break;
				case 4:
					min = 61;
					max = 75;
					break;
			}
		for(int a = 0; a < 5; a++)
		{
			if(i==2 && a==2)
			{
				columns.add(new BingoNumber(-1));
			}
			else
			{
				int rand = r.nextInt((max - min) + 1) + min;  
 				columns.add(new BingoNumber(rand));
			}
		}
		BingoNumber [] randC = new BingoNumber[columns.size()];
		randC = (BingoNumber[]) columns.toArray(randC);
		return randC;
	}
	public BingoCard()
	{
		BingoNumber [][] fake = new BingoNumber [5][5];
		bn = new BingoNumber [5][5];
		sbs = new BingoNumber [5][10];
		for(int c = 0; c < 5; c++)
		{
			fake[c] = columnMaker(c);
		}
		for(int a = 0; a < 5; a++)
		{
			for(int b = 0; b < 5; b++)
			{
				bn[a][b] = fake[b][a];
				sbs[a][b] = bn[a][b];
			}
		}
	}
	public String toString()
	{

			StringBuilder a = new StringBuilder();
			a.append("  B  I  N  G  O  ");
			a.append("\n" + toStringLine() + "\n");
			for(int h = 0; h < 5; h++)
			{
				a.append("|");
				for(int i = 0; i < 5; i++)
				{
					a.append(bn[h][i].toString());
					a.append("|");
				}
				a.append("\n" + toStringLine() + "\n");
			}
			return a.toString();
	}
	public String toStringLine()
	{
		StringBuilder b = new StringBuilder();
		b.append("+--+--+--+--+--+");
		return b.toString();
	}
	public BingoNumber getNumber(int row, int column)
	{
		return bn[row][column];
	}
	public String toSideBySideString()
	{
		StringBuilder q = new StringBuilder();
        q.append("  B  I  N  G  O  \t  B  I  N  G  O ");
        q.append("\n" + toStringLine() + "\t" + toStringLine() + "\n");
        for (int i = 0; i < 5; i++)
        {
            q.append("|");
            for (int j = 0; j < 5; j++) 
            {
				if(i == 2 && j == 2)
				{
					q.append("XX");
					q.append("|");
				}
				else 
				{
					q.append(bn[i][j].toNumberString());
					q.append("|");
				}
            }
            q.append("\t");
            q.append("|");
            for (int j = 0; j < 5; j++) 
            {
				if((i == 2 && j == 2 )||(bn[i][j].isMarked()))
				{
					q.append("XX");
					q.append("|");
				}
				else 
				{
					q.append(bn[i][j].toNumberString());
					q.append("|");
				}
            }
            q.append("\n" + toStringLine() + "\t" + toStringLine() + "\n");
        }  
        return q.toString();
	}
	public boolean mark(int number)
	{
		marked = false;
		if(number>=1 && number<=15)
		{
			column = 0;
		}
		else if(number>=16 && number<=30)
		{
			column = 1;
		}
		else if(number>=31 && number<=45)
		{
			column = 2;
		}
		else if(number>=46 && number<=60)
		{
			column = 3;
		}
		else if(number>=61 && number<=75)
		{
			column = 4;
		}
		for(int i = 0; i < 5; i++)
		{
			if(bn[i][column].getNumber() == number)
			{
				bn[i][column].mark();
				marked = true;
			}
		}
		return marked;
	}
	public static void main(String [] args)
	{
		BingoCard aCard = new BingoCard();
		System.out.println(aCard);
		aCard.mark(45);
		aCard.mark(22);
		System.out.println(aCard);
		System.out.println(aCard.toSideBySideString());
	}
}

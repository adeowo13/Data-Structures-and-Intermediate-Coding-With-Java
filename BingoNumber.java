/*
Ade Owodunni
CS0401
Project 3
*/
import java.text.DecimalFormat;
import java.util.*;
public class BingoNumber
{
	private int num;
	private boolean mark;
	private DecimalFormat df = new DecimalFormat("00");
	
	public BingoNumber(int aNumber)
	{
		num = aNumber;
		mark = false;
	}
	public int getNumber()
	{
		return num;
	}
	public boolean isMarked()
	{
		if(mark)
		{
			return true;
		}
		else
			return false;
	}
	public String toString()
	{
		StringBuilder a = new StringBuilder();
		if(mark == true || num == -1)
		{
			a.append("XX");
		}
		else
		{
			if(num < 10)
			{
				a.append(" " + num);
			}
			else
			{
				a.append(num);
			}
		}	
		return a.toString();
	}
	public String toNumberString()
	{
		StringBuilder b = new StringBuilder();
		if(num < 10)
		{
			b.append(" " + num);
		}
		else
		{
			b.append(num);
		}
		return b.toString();
	}
	public void mark()
	{
		mark = true;
	}
}
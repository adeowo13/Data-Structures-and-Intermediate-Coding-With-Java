/*
Ade Owodunni
CS0401
Project 3
*/
public class BingoBall
{
	private int num;
	
	public BingoBall(int number)
	{
		while(number >= 1 && number <= 75)
		{
			num = number;
		}
	}
	public int getNumber()
	{
		return num;
	}
	public String toString()
	{
		return String.valueOf(num);
	}

}

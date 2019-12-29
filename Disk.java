/*
Ade Owodunni
CS0401
Project 2
*/
public class Disk
{
	private int ads;
	private char adc;
	private char apc;
	public Disk(int aDiskSize, char aDiskChar, char aPoleChar)
	{
		if(aDiskSize < 0)
		{
			this.ads = 1;
		}
		else
		{
			this.ads = aDiskSize;
		}
			this.adc = aDiskChar;
			this.apc = aPoleChar;	
	}
	public Disk(int aDiskSize)
	{
		if(aDiskSize < 0)
		{
			this.ads = 1;
		}
		else
		{
			this.ads = aDiskSize;
		}
		this.adc = '*';
		this.apc = '|';
	}
	public int getSize()
	{
		return this.ads;
	}
	public String toString()
	{
		StringBuilder D = new StringBuilder();
		for(int i = 0; i < ads; i++)
		{
			D.append(adc);
		}
		
		D.append(apc);
		
		for(int i = 0; i < ads; i++)
		{
			D.append(adc);
		}  
		return D.toString();
	}
}
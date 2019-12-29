/*
Ade Owodunni
CS0401
Project 3
*/
import java.util.*;
public class BingoCage
{
	private BingoBall [] bb;
	private BingoBall returnVal;
	private Random r = new Random();
	private int rBall;
	private int ballsLeft;
	private boolean empty;

	public BingoCage()
	{
		bb = new BingoBall [75];
		for(int i = 1; i < bb.length; i++)
		{
			bb[i-1] = new BingoBall(i);
		}
		ballsLeft = 75;
	}
	public BingoBall draw()
	{
		rBall = r.nextInt(75)+1;
		BingoBall returnVal = null;
		
		while(bb[rBall-1] == null)
		{
			rBall = r.nextInt(75)+1;
		}
		returnVal = bb[rBall -1];
		bb[rBall -1] = null;
		ballsLeft--;
		return returnVal;
	}
	public void reset()
	{
		bb = new BingoBall [75];
		for(int i = 1; i < bb.length; i++)
		{
			bb[i-1] = new BingoBall(i);
		}
		ballsLeft = 75;
	}
}
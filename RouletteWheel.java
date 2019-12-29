import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  
import java.util.Random;

public class RouletteWheel extends JPanel implements Runnable
{
	private RColors c;
	private RParities p;
	private RRanges r;
	private int v;
	private int n;
	private int count;
	private Activatable A;
	private Thread spinner;
	private RouletteSquare rs;
	private Random rand;
	private JFrame theWindow;
	private JPanel tops;
	 
	public RouletteWheel(Activatable a)
	{
		Random rand = new Random();
		count = 0;
		A = a;
		n = rand.nextInt(37) + 0;
		v = n;
	}
	public void set()
	{
		v = 0;
		r = null;
		p = null;
		c = null;
		count = 0;
	}
	public void spin()
	{
			count++;
			//RouletteWheel rw = new RouletteWheel();
 			Thread spinner = new Thread(new RouletteWheel());
 			spinner.start();
	}
	public int checkBet(RouletteBet b)
	{
		if(b.getBetType().equals("Color"))
		{
			if(b.getBetValue().equals(c))
			{
				return 1;
			}
			else
			{ 
				return 0;
			}
		}
		if(b.getBetType().equals("Parity"))
		{
			if(b.getBetValue().equals(p))
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}	
		if(b.getBetType().equals("Range"))
		{
			if(b.getBetValue().equals(r))
			{
				return 1;
			}
			else 
			{
				return 0;
			}
		}
		if(b.getBetType().equals("Value")) //parse the value different from just setting the values cpr with the equals method
		{
			if(Integer.parseInt(b.getBetValue()) == v)
			{
				return 35;
			}
			else
			{ 
				return 0;
			}
		}
		return 0;
	}
	public RouletteResult getResult()
	{
		if(count > 0)
		{
			return new RouletteResult(c,r,p,v);
		}
		else 
			return null;			
		// Get the selected square (after a completed spin) and return its
		// data as a new RouletteResult object.  If a spin() has not yet been
		// performed this method should return null.  The RouletteResult class
		// was provided in previous assignments.
	}
	public void run()
	{
		try 
		{ 
			for(int i = 0; i < 10; i++)
			{
				rs = new RouletteSquare(n);
				rs.choose(); 
				Thread.sleep(3000);
				rs.unChoose();
			}
		}
		catch (InterruptedException e)
		{  
			System.out.println("Problem with Thread!"); 
		}
	}
		// implementation of the Runnable interface.  This should select 
		// RouletteSquare objects in a random way for a certain amount of time,
		// so that visually the user sees the wheel "moving".  This is done in
		// the run() method rather than the spin() method directly so that it
		// can be run in a Thread asynchronously.
}
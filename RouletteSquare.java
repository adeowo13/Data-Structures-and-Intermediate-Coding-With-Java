import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  
import java.awt.Color;


public class RouletteSquare extends JLabel
{

	private RBets betType;
	private int v;
	private RColors c;
	private RParities p;
	private RRanges r;
	 
	private String betValue;
	private JLabel viewNumber;
	
	
	public RouletteSquare(int val_)
	{
			v = val_;
			
			setLayout(new GridLayout(1,1));
			viewNumber = new JLabel(String.valueOf(v)); 
			viewNumber.setFont(new Font("Serif", Font.BOLD, 40));
			viewNumber.setHorizontalAlignment(SwingConstants.CENTER);
			viewNumber.setOpaque(true);
			if(v == 0)
			{
				viewNumber.setForeground(Color.GREEN);
				c = RColors.valueOf("Green");
				p =	RParities.valueOf("None");
				r = RRanges.valueOf("None");
			}
			else if(v>0 && v<= 10)
			{
				if(v % 2 == 0)
				{
					viewNumber.setForeground(Color.BLACK);
					c = RColors.valueOf("Black");
					p = RParities.valueOf("Even");
				}
				else
				{
					viewNumber.setForeground(Color.RED);
					c = RColors.valueOf("Red");
					p = RParities.valueOf("Odd");
				}
				r = RRanges.valueOf("Low");
			}
			else if(v>10 && v<= 18)
			{
				if(v % 2 == 0)
				{
					viewNumber.setForeground(Color.RED);
					c = RColors.valueOf("Red");
					p = RParities.valueOf("Odd");
				}
				else
				{
					viewNumber.setForeground(Color.BLACK);
					c = RColors.valueOf("Black");
					p = RParities.valueOf("Even");
				}
				r = RRanges.valueOf("Low");
			}
			else if(v>18 && v<= 28)
			{
				if(v % 2 == 0)
				{
					viewNumber.setForeground(Color.BLACK);
					c = RColors.valueOf("Black");
					p = RParities.valueOf("Even");
				}
				else
				{
					viewNumber.setForeground(Color.RED);
					c = RColors.valueOf("Red");
					p = RParities.valueOf("Odd");
				}
				r = RRanges.valueOf("High");
			}
			else if(v>28 && v<= 36)
			{
				if(v % 2 == 0)
				{
					viewNumber.setForeground(Color.RED);
					c = RColors.valueOf("Red");
					p = RParities.valueOf("Odd");
				}
				else
				{
					viewNumber.setForeground(Color.BLACK);
					c = RColors.valueOf("Black");
					p = RParities.valueOf("Even");
				}
				r = RRanges.valueOf("High");
			}		
			add(viewNumber);
	}
	public boolean isChosen()
	{
	 	if()
	 	{
	 		return true;
	 	}
	 	else
	 		return false;
	}
	public void unChoose()//changes the background color 
	{
		viewNumber.setBackground(Color.CYAN);
		add(viewNumber);
	}
	public void choose()// changes the background color to blue to indicate the selection 
	{
		viewNumber.setOpaque(true);
		add(viewNumber);
	}
	public RRanges getRange()
	{
		return r;
	}
	public RColors getColor()
	{
		return c;
	}
	public RParities getParity()
	{
		return p;
	}
	public int getValue()
	{
		return v;
	}
	
}
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  

public class RoulettePanel extends JPanel
{
	private RouletteBet rb;
	private RBets rbs;
	private int v;
	private boolean qu;
	private RColors c;
	private RParities p;
	private RRanges r;
	private RoulettePlayer rP;
	private GameInterface g;
	
	private boolean over;
	private boolean fbt;
	private String btv;
	private double bet;

	private String betValue;
	private JLabel intro;
	private JLabel [] rLabel ;
	private JPanel rPanel;
	private JPanel buttons;
	private JFrame theWindow;
	private Container thePane;
	private JButton makeBet, spinWheel, showInfo, Quit;
	private final Font myFont = new Font("TimesRoman", Font.BOLD, 40);

	public RoulettePanel(RoulettePlayer rp, GameInterface G)
	{
		//theWindow.addWindowListener(new Closer());
		rP = rp;
		g = G;
		JOptionPane.showMessageDialog(theWindow, "Welcome to the game, " + rP.getName() + "!");
		ActionListener listen = new ButtonListener();
		setLayout(new GridLayout(1,2));
		///theWindow = new JFrame("RoulettePanel");
		//theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		intro = new JLabel("");
		buttons = new JPanel();
		buttons.setLayout(new GridLayout(5,1));
		rPanel = new JPanel();
		rPanel.setLayout(new GridLayout(5, 8));
		
		makeBet = new JButton("Make Bet");
		makeBet.setFont(myFont);
		makeBet.addActionListener(listen);
		
		
		spinWheel = new JButton("Spin Wheel");
		spinWheel.setFont(myFont);
		spinWheel.addActionListener(listen);
		
		showInfo = new JButton("Show Info");
		showInfo.setFont(myFont);
		showInfo.addActionListener(listen);
		
		Quit = new JButton("Quit");
		Quit.setFont(myFont);
		Quit.addActionListener(listen);
		
		buttons.add(intro);
		buttons.add(makeBet);
		buttons.add(spinWheel);
		buttons.add(showInfo);
		buttons.add(Quit);
		
		//thePane = theWindow.getContentPane();
		//thePane.setLayout(new GridLayout(1,2));
        add(buttons);
        
        rLabel = new JLabel[40];
        for(int i = 0; i < (rLabel.length - 3); i++)
        {
        	//rPanel = theWindow.getContentPane();
			//rPanel.setLayout(new GridLayout(5,8));
        	rLabel[i] = new JLabel(Integer.toString(i));
        	rLabel[i].setHorizontalAlignment(SwingConstants.CENTER);
        	if(i == 0)
			{
				rLabel[i].setForeground(Color.GREEN);
			}
			else if(i >0 && i <= 10)
			{
				if(i % 2 == 0)
				{
					rLabel[i].setForeground(Color.BLACK);
				}
				else
				{
					rLabel[i].setForeground(Color.RED);
				}
			}
			else if(i > 10 && i <= 18)
			{
				if(i % 2 == 0)
				{
					rLabel[i].setForeground(Color.RED);
				}
				else
				{
					rLabel[i].setForeground(Color.BLACK);
				}
			}
			else if(i >18 && i <= 28)
			{
				if(i % 2 == 0)
				{
					rLabel[i].setForeground(Color.BLACK);
				}
				else
				{
					rLabel[i].setForeground(Color.RED);
				}
			}
			else if(i > 28 && i <= 36)
			{
				if(i % 2 == 0)
				{
					rLabel[i].setForeground(Color.RED);
				}
				else
				{
					rLabel[i].setForeground(Color.BLACK);
				}
			}		
            rPanel.add(rLabel[i]);
        }//for loop
        	add(buttons);
        	add(rPanel);
        	//theWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //theWindow.pack();
            //theWindow.setVisible(true);
        
	}
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			do{
				if(e.getSource() == makeBet)
				{
			
					do 
					{
						String b = JOptionPane.showInputDialog("How much would you like to bet? (<= $250.00)", "" );
						bet = Integer.parseInt(b);
				
						if(bet > 250.00)
						{
							over = true;
						}
						else 
							over = false;
					} while(over == true);
					//do{
						String bType = JOptionPane.showInputDialog("Type of your bet? [Value, Color, Range, Parity]", "");
						if(bType.equals("Value"))
						{
							btv = JOptionPane.showInputDialog("Enter your value. 0-36", "");
							v = Integer.parseInt(btv);
							boolean fbt = false;
						}
						else if(bType.equals("Color"))
						{
							rbs = RBets.valueOf("Color");
							btv = JOptionPane.showInputDialog("Enter your Color. [Red, Black, Green(input for 0)]", "");
							if(bType.equals("Red"))
							{
								c = RColors.valueOf("Red");
							}
							else if(bType.equals("Black"))
							{
								c = RColors.valueOf("Black");
							}
							else if(bType.equals("Green"))
							{
								c = RColors.valueOf("Green");
							}
							rb = new RouletteBet(rbs, btv);
							fbt = false;
						}
						else if(bType.equals("Range"))
						{
							rbs = RBets.valueOf("Range");
							btv = JOptionPane.showInputDialog("Enter your Range. [Low, High, None(input for 0)]", "");
							if(bType.equals("Low"))
							{
								r = RRanges.valueOf("Low");
							}
							else if(bType.equals("High"))
							{
								r = RRanges.valueOf("High");	
							}
							else if(bType.equals("None"))
							{
								r = RRanges.valueOf("None");
							}
							rb = new RouletteBet(rbs, btv);
							fbt = false;
						}
						else if(bType.equals("Parity"))
						{
							rbs = RBets.valueOf("Parity");
							btv = JOptionPane.showInputDialog("Enter your Parity. [Odd, Even, None(Input for 0)]", "");
							if(bType.equals("Odd"))
							{
								p = RParities.valueOf("Odd");
							}
							else if(bType.equals("Even"))
							{
								p = RParities.valueOf("Even");
							}
							else if(bType.equals("None"))
							{
								p = RParities.valueOf("None");
								
							}
							rb = new RouletteBet(rbs, btv);
							fbt = false;
						}
						else
						{
							fbt = true;
						}
					//} while(fbt == true); //make bet
				}
				else if(e.getSource() == spinWheel)
				{
						intro.setText("You bet on " + rb.getBetValue() + "!");
				}
				else if(e.getSource() == showInfo)
				{
					JOptionPane.showMessageDialog(null, rp.toString());
				}
				else if(e.getSource() == Quit)
				{
					String ans = JOptionPane.showInputDialog(theWindow, "Leaving Already" + rP.getName() + "?");	
					if(ans.equals("yes") || ans.equals("Yes"))
					{
						g.gameOver();
					}
					else
					{
						qu = false;
					}
				}
			} while(qu == false);
		}//public 
	}//private class
}
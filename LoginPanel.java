import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class LoginPanel extends JPanel
{
	RPList rpl;
	Question [] quests = new Question[2];
	RoulettePlayer [] rpa;
	RoulettePlayer [] Nrpa;
	LoginInterface lI;
	private JLabel top, user, pass;
	private JFrame theWindow;
	private JPanel middleP;
	private Container thePane;
	private JButton submit;
	private JTextField u,p;

	private String uInput;
	private String pInput;
	private String na;
	private String pw;
	private double ca;
	private double de;
	private String Q1;
	private	String A1;
	private	String Q2;
	private	String A2;
	private boolean notP;
	
	
	public LoginPanel (RPList playersl, LoginInterface L)
	{
		//do{
			rpl = playersl;
			lI = L;
			try
			{
				File file = new File("players.txt");
				Scanner sc = new Scanner(file);
				int size = Integer.parseInt(sc.nextLine());
				rpa = new RoulettePlayer[size];
			
				while(sc.hasNext())
				{
						String line = sc.nextLine();
						String [] arr = line.split(",");
						na = arr[0];
						pw = arr[1];
						ca = Double.parseDouble(arr[2]);
						de = Double.parseDouble(arr[3]);
			
					if(arr.length > 4)
					{
						Question q = new Question(arr[4],arr[5]);
						quests[0] = q;
						quests[1] = new Question(arr[6],arr[7]);
				
					}
					else
					{
						Q1 = null;
						A1 = null;
						Q2 = null;
						A2 = null;
					}

					for(int i = 0; i < rpa.length; i++)
					{
						rpa[i] = new RoulettePlayer(na, pw, ca, de);
					}
				}//while
			}	
			catch(FileNotFoundException ex)
			{
				JOptionPane.showMessageDialog(null, "Unable to open file");                
			}
			submit = new JButton("Submit");
			submit.setFont(new Font("Serif", Font.BOLD, 40));
			submit.addActionListener(new LoginListener());
		
			//theWindow = new JFrame("Login Panel");
			//theWindow.setFont(new Font("Serif", Font.BOLD, 40));
		
		   
			//thePane = theWindow.getContentPane();
			//thePane.setLayout(new GridLayout(3,1));
			setLayout(new GridLayout(3,1));
		
			top = new JLabel("Please log into the site!");
			top.setFont(new Font("Serif", Font.BOLD, 40));
		
			user = new JLabel("Username");
			pass = new JLabel("Password");
		
			u = new JTextField();
			p = new JTextField();
	
			middleP = new JPanel(true);
			middleP.setLayout(new GridLayout(2,4));
			middleP.add(user);
			middleP.add(u);
			middleP.add(pass);
			middleP.add(p);
		
			add(top);
			add(middleP);
			add(submit);
		
			uInput = u.getText();
			pInput = p.getText();
	}
	private class LoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			remove(submit);
			for(int i = 0; i < rpa.length; i++)
			{
				if(!uInput.equals(rpa[i].getName()) && !pInput.equals(rpa[i].getPassword()))
				{
					JOptionPane.showMessageDialog(null, "ACCOUNT NOT FOUND");
					notP = true;
				}
				else if(uInput.equals(rpa[i].getName()) && !pInput.equals(rpa[i].getPassword()))
				{
					u.setText(na);
					JOptionPane.showMessageDialog(null, "INCORRECT PASSWORD");
					notP = true;
				}
				else if(uInput.equals(rpa[i].getName()) && pInput.equals(rpa[i].getPassword()))
				{
					notP = false;
					lI.setPlayer(rpa[i]);
				}
			add(submit);
			}//for
		}//actionperform
	}//class
		//}while(notP == true);
		//JOptionPane.showMessageDialog(null, "Hello "+ na + " ");
}

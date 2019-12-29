
import java.util.List;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.*;

public class CoffeeProcessingApp
{

	public static void main (String []args)throws IOException
	{
		int lineReader = 0;
		int menu = 0;
		
		Scanner keyboard = new Scanner(System.in);
		File myFile = new File("Orders.txt");
		File myFile2 = new File("Status.txt");
		PrintWriter printWriter = new PrintWriter("status.txt");
		BufferedReader buff = new BufferedReader (new FileReader ("orders.txt"));
		FileReader fReader = new FileReader(myFile);
		FileReader fReader2 = new FileReader(myFile2);
		LineNumberReader reader = new LineNumberReader(fReader);
		LineNumberReader reader2 = new LineNumberReader(fReader2);
		Scanner sc = new Scanner(myFile);
		
		ArrayList<String> list = new ArrayList<String>();
		Scanner inputFile = new Scanner(System.in);

		while (reader.readLine() != null)
        		lineReader++;
                String [] receiveOrders = new String[lineReader];
                int [] orderStatus = new int[10];
		
	do
	{
		System.out.println("Welcome to the Java Code Coffee Shop Processing program!");
		System.out.println("----Processing Menu----");
		System.out.println("1. View Orders");
		System.out.println("2. Receive Orders");
		System.out.println("3. Begin Processing Order");
		System.out.println("4. Complete Processing Order");
		System.out.println("5. View Order History"); 
		System.out.println("6. Run a Report");
		System.out.println("7. Exit");
		menu = keyboard.nextInt();
		
		switch(menu)
		{
			case 1:
			//File myFile = new File("Orders.txt");
			boolean fileResults = myFile.exists();
			//Scanner sc = new Scanner(myFile);
			if(fileResults && myFile.length() != 0)
			{
				while(sc.hasNextLine())
				System.out.println(sc.nextLine());
			}
			else
			{
				System.out.println("There are no orders at this time");
			}
				
				
			
								/*try
								{	
								File myFile = new File("Orders.txt");
								Scanner inputReader = new Scanner(myFile);
									//while loop to print all lines of the file
									while (inputReader.hasNext())
									{
										// Read the first line from the file.
    									String line = inputReader.nextLine();
      
      									// Display the line.
     									System.out.println(line);

     									// Close the file.
     									inputReader.close();
									}
					
								}//try
			
								catch (Exception e)
								{//Catch exception if any
									System.out.println("There are no orders at this time");
									System.err.println("Error: " + e.getMessage());
								}*/
			break;
			
			case 2:
			//BufferedReader buff = new BufferedReader (new FileReader ("orders.txt"));
			String fileHolder;
			while((fileHolder = buff.readLine()) != null)
			{
				list.add(fileHolder);
			}
			String [] fileArray = list.toArray( new String[0]);
			while(reader.readLine()!= null)
			lineReader++;
			
			for(int b=0; b <= lineReader; b++)
			{
				if(orderStatus[b-1] == 0)
                {
					printWriter.print("Order " + b + " has been received!");
					System.out.println("Order " + b + " has been received!");
					while(inputFile.hasNextLine())
					{
						list.add(inputFile.nextLine());
					}
				receiveOrders[b-1] = list.get(b-1);
                orderStatus[b-1] = 1;
                 }
			}
			
			printWriter.close();
			PrintWriter delete = new PrintWriter("orders.txt");
			delete.print("");
			 delete.close();	
			break;
			
			case 3:
			break;
			
			case 4:
			break;
			
			case 5:
			System.out.println("--- Order History ---");
            System.out.println("Customer        Coffee        Latte        Cappuccino        Espresso       Scone        Muffin");
            System.out.println("--------        ------        -----        ----------        --------       -----        ------");
			break;
			
			case 6:
			break;
			
			case 7:
			System.exit(0);
			break;
			
		}//switch menu
		
	
}while(menu <=7);

	} //main
} //class
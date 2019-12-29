import java.io.*;
import java.util.Scanner;

public class WeeklySales 
{

    public static void main(String[] args) throws IOException
    {
        Scanner keyboard = new Scanner(System.in);
        double sum = 0;
        System.out.println("Welcome to the Weekly Sales Goal Program");
        System.out.print("Enter the input file name: ");
        String response = keyboard.nextLine();
        String correct1= "week1SalesData.txt";
        String correct2= "week2SalesData.txt";

            if(!(response.equals(correct1) || response.equals(correct2)) )
            {
            System.out.println("Invalid input file name. Please try again.");
            System.exit(0);
            }
        System.out.println("Enter your sales goal in (in dollars): ");
        double salesgoal= 0.0;
        salesgoal= keyboard.nextDouble();
        File file= new File(response);
        	Scanner inputFile = new Scanner(file);
    while (inputFile.hasNext () )
    {
    double number= inputFile.nextDouble();
    sum = sum + number;
    }
    inputFile.close();
    System.out.println("Your total sales for this week " + response + " is " + sum);
    
    if(sum>salesgoal)
    {
    System.out.println("You have reached your goal!");
    }
    else
    {
    double difference;
    difference= sum - salesgoal;
    System.out.println("You have missed your goal by " + difference);
    }
    System.out.println("Goodbye!!!!!");

    }
}
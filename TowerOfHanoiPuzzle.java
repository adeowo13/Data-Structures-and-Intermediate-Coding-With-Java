/*
Ade Owodunni
CS0401
Project 2
*/
import java.util.*;
public class TowerOfHanoiPuzzle
{
	public static void main(String []args)
	{
		int menu = 0;
		int moves = 0;
		String from = "";
		String to = "";
		String game = "";
		boolean check = false;
		boolean win = false;
		TowerOfHanoi toh = new TowerOfHanoi();
		Scanner scan = new Scanner(System.in);
		
		do{
			System.out.println("Welcome to the Tower of Hanoi Puzzle!");
			System.out.println("Take a Pick:");
			System.out.printf("\t 1) Play Tower of Hanoi Puzzle \n");
			System.out.printf("\t 2) Exit \n");
			menu = scan.nextInt();
			scan.nextLine();
			if(menu == 1)
			{
				System.out.println("yes ");
			}
			else if(menu == 2)
			{
				System.out.println("Goodbye!!");
				System.exit(0);
			}
			else if(menu != 1 || menu != 2)
			{
				check = true;
			}
			if(check)
			{
				continue;
			}
		}while(check == true);
		
		do{
			System.out.println("How many disks would you like to play (between 1 and 64): ");
			int input = scan.nextInt();
			
			if(input < 1 || input > 64)
			{
				check = true;
			}
			if(check)
			{
				continue;
			}
		}while(check == true);
		do{	
			toh(input);
			toh.toString();
			System.out.println("The goal is to move all "+ input +" disks from pole 1 to pole 3");
			System.out.println("The least number of moves for " + + " is " + (input*4)-1);
			System.out.println("Are you ready to play? (y/n): ");
			String input2 = scan.nextLine();
			if(input2.equals("n"))
			{
				check = true;
			}
			if(check)
			{
				continue;
			}
		}while(check == true);
		
		do{
			toh.toString();
			System.out.println("Number of Moves: " + moves);
			System.out.println("Enter <from><space><to> to move a disk: ");
			game = scan.nextLine();
			String[] splitter = game.split(" ");
			from = Integer.parseInt(splitter[0]);
			to = Integer.parseInt(splitter[1]);
			if(from == 0 && to == 0)
			{
				check = true;
			}
			if(check)
			{
				continue;
			}
			toh.move(from, to);
			moves++;
			if(toh.getNumberOfDisks(1) == 0 && toh.getNumberOfDisks(3) == input)
			{
				System.out.println("Congratulation!!!");
				win = true;
				System.out.println("Number of Moves: " + moves);
			}
		}while(win == true || check == true);
	}
}
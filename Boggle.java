import java.io.*;
import java.util.*;

// just generates all the strings & prints them as they are generated

public class Boggle
{	
	static String[][] board;
	//static long startTime,endTime; // for timing
	static final short SMALLEST_WORD = 3;
	static TreeSet<String> wordsFound = new TreeSet<String>();
	static TreeSet<String> dictionary = new TreeSet<String>();
	static HashSet<Integer> wLength = new HashSet<Integer>();
	
	public static void main( String args[] ) throws Exception
	{	
		board = loadBoard( args[1] );
		
		BufferedReader dFile = new BufferedReader(new FileReader(args[0]));
		while(dFile.ready())
		{
			String line = dFile.readLine();
			if(line.length() >= SMALLEST_WORD && line.length() <= Math.pow(board.length, 2))
			{
				dictionary.add(line);
				wLength.add(line.length());
			}
		}
		dFile.close();
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[row].length; col++)
				dfs( row, col, ""  ); // FOR EACH [R][C] THE WORD STARTS EMPTY
		
		// print your sorted list of real dictionary words found in the grid - one word per line
		for(String word : wordsFound)
			System.out.println(word);
//		endTime =  System.currentTimeMillis(); // for timing
//		System.out.println("GENERATION COMPLETED: runtime=" + (endTime-startTime)/MILLISEC_PER_SEC );

	} // END MAIN ----------------------------------------------------------------------------

	static void dfs( int r, int c, String word  )
	{	
		word += board[r][c];
		if(searchD(word))
			wordsFound.add(word);
		else if(!dictionary.higher(word).startsWith(word))
		{
			return;
		}
		// if the word above is a valid dictionary word then add it to your wordsFounds/matches data structure  
		//System.out.println( word ); // DLELETE THIS LATER. START BY PRINTING EVERY STRING FORMED TO DEBUG
		
		// THIS IS THE FORM OF EACH OF YOUR N,NE,E,SE,S,SW,W,NW BLOCKS 
		
		// IM GIVING THE NORTH VERSION SUDO CODE - YOU MUST WRITE 7 MORE BELOW IT
		// DO NOT ELSE THEM OFF! GIVE EVERY BLOCK AN INDEPENDENAT IF TEST
		// YOU WANT TO RESUME YOUR CLOCKWISE SWEEP OF HTE NEGHBORS
		
		// N IS [r-1][c]
		if (((r-1 >=0 && r-1 < board.length) && (c >= 0)) && board[r-1][c] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r-1, c, word);
			board[r][c] = b4mark;
		}
		
		// NE IS [r-1][c+1]  YOU WILL NEED TO TEST BOTH r-1 AND c+1 FOR OUT OF BOUNDS
		if (((r-1 >=0 && r-1 < board.length) && (c+1 >= 0 && c+1 < board[r-1].length)) && board[r-1][c+1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r-1, c+1, word);
			board[r][c] = b4mark;
		}
		
		// E IS [r][c+1]
		if (((r >=0) && (c+1 >= 0 && c+1 < board[r].length)) && board[r][c+1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r, c+1, word);
			board[r][c] = b4mark;
		}
		
		// SE IS ...
		if (((r+1 >=0 && r+1 < board.length) && (c+1 >= 0 && c+1 < board[r].length)) && board[r+1][c+1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r+1, c+1, word);
			board[r][c] = b4mark;
		}
		// S IS ...
		if (((r+1 >=0 && r+1 < board.length) && (c >= 0)) && board[r+1][c] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r+1, c, word);
			board[r][c] = b4mark;
		}
		// SW IS ...
		if (((r+1 >=0 && r+1 < board.length) && (c-1 >= 0 && c-1 < board[r].length)) && board[r+1][c-1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r+1, c-1, word);
			board[r][c] = b4mark;
		}
		// W IS ...
		if (((r >=0) && (c-1 >= 0 && c-1 < board[r].length)) && board[r][c-1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r, c-1, word);
			board[r][c] = b4mark;
		}
		
		// NW IS ...
		if (((r-1 >=0 && r-1 < board.length) && (c-1 >= 0 && c-1 < board[r].length)) && board[r-1][c-1] != null)  // THE r-1 WILL CHANGE FOR EVEY BLOCK BELOW
		{	
			String b4mark = board[r][c];
			board[r][c] = null;
			dfs(r-1, c-1, word);
			board[r][c] = b4mark;
		}
	} // END DFS ----------------------------------------------------------------------------

	//=======================================================================================
	static String[][] loadBoard( String fileName ) throws Exception
	{	Scanner in = new Scanner( new File(fileName) );
		int r = in.nextInt();
		int c = r;
		String[][] board = new String[r][c];
		for(int i = 0; i < r; i++)
			for(int a = 0; a < c; a++)
				board[i][a] = in.next();
		// read in the data from file and fill the frid
		in.close();
		return board;
	} //END LOADBOARD 
	static boolean searchD(String word)
	{
		if(word.length() >= SMALLEST_WORD && wLength.contains(word.length()))
		{
			if(dictionary.contains(word))
				return true;
		}
		return false;
	}
} // END BOGGLE CLASS

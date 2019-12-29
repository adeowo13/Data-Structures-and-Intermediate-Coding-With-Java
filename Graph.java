/* This class was borrowed and modified as needed with permission from it's original author
   Mark Stelhik ( http:///www.cs.cmu.edu/~mjs ).  You can find Mark's original presentation of
   this material in the links to his S-01 15111,  and F-01 15113 courses on his home page.
*/

import java.io.*;
import java.util.*;

public class Graph 
{
	private final int NO_EDGE = -1; // all real edges are positive
	private int G[][];              // will point to a 2D array to hold our graph data

	private int numEdges;
	public Graph( String graphFileName ) throws Exception  // since readFild doesn't handle them either
	{
		loadGraphFile( graphFileName );
		
//		T E M P O R A R Y    C O D E    T O    V E R I F Y    P R I V A T E 
// 		M E T H O D S    W E    C A N T    C A L L    F R O M   T E S T E R 
//		      ........R E M O V E   A F T E R   T E S T I N G .......
/*
		for (int node = 0 ; node < G.length ; ++node )
		{
			System.out.format( "DEBUG:: in (%d)=%d  ",node,inDegree(node) );
			System.out.format( "out(%d)=%d  ",node,outDegree(node) );
			System.out.format( "deg(%d)=%d\n",node,degree(node) );
		}
*/
	}

	///////////////////////////////////// LOAD GRAPH FILE //////////////////////////////////////////
	//
	// FIRST NUMBER IN GRAPH FILE IS THE SQUARE DIMENSION OF OUR 2D ARRAY
	// THE REST OF THE LINES EACH CONTAIN A TRIPLET <ROW,COL,WEIGHT> REPRESENTING AN EDGE IN THE GRAPH

	private void loadGraphFile( String graphFileName ) throws Exception
	{
		Scanner graphFile = new Scanner( new File( graphFileName ) );

		int dimension = graphFile.nextInt();   	// THE OF OUR N x N GRAPH
		G = new int[dimension][dimension]; 		// N x N ARRAY OF ZEROS
		numEdges=0;

		// WRITE A LOOP THAT PUTS NO_EDGE VALUE EVERYWHERE EXCPT ON THE DIAGONAL
		for(int i = 0; i < G.length; i++)
		{
			for(int a = 0; a < G.length; a++)
			{
				if(i == a)
				{
					G[i][a] = 0;
				}
				else
				{					
					G[i][a] = -1;
				}
			}
		}
	

		// NOW LOOP THRU THE FILE READING EACH TRIPLET row col weight FROM THE LINE
		// USE row & col AS WHERE TO STORE THE weight
		// i.e. g[row][col] = w;

		while ( graphFile.hasNextInt() )
		{
			int r = graphFile.nextInt();
			int c = graphFile.nextInt();
			int w = graphFile.nextInt();
			addEdge(r,c,w);
			// read in the row,col,weight // that eat us this line
			// call add edge
		}

	} // END readGraphFile

	private void addEdge( int r, int c, int w )
	{
		G[r][c] = w;
		++numEdges; // only this method adds edges so we do increment counter here only
	}
	
  private boolean hasEdge(int fromNode, int toNode)
  {
    if(fromNode >= G.length || toNode >= G.length)
    {
    	return false;
    }	
    if(G[toNode][fromNode] > 0)
    {
    	return true;
    }	
    return false; 
  }

	// IN DEGREE IS NUMBER OF ROADS INTO THIS CITY
	// NODE IS THE ROW COL#. IN DEGREE IS HOW MANY POSITIVE NUMBERS IN THAT COL
	private int inDegree(int node)
	{
		int iDeg = 0;
		for(int i = 0; i < G.length; i++)
		{
			if(hasEdge(i, node))
			{
				iDeg++;
			}
		}
		return iDeg;
	}

	// OUT DEGREE IS NUMBER OF ROADS OUT OF THIS CITY
	// NODE IS THE ROW #. IN DEGREE IS HOW MANY POSITIVE NUMBERS IN THAT ROW
	private int outDegree(int node)
	{
		int oDeg = 0;
		for(int i = 0; i < G.length; i++)
		{
			if(hasEdge(node, i))
			{
				oDeg++;
			}
		}
		return oDeg;	
	}

	// DEGREE IS TOTAL NUMBER OF ROAD BOTH IN AND OUT OFR THE CITY 
	private int degree(int node)
	{
		return inDegree(node) + outDegree(node);
	}

	// PUBLIC METHODS 
	
	public int maxOutDegree()
	{
		int maxO = 0;
		for(int i = 0; i < G.length; i++)
		{
			int maxAtI = outDegree(i);
			if(maxAtI > maxO)
			{
				maxO = outDegree(i);
			}
		}
		return maxO;
	}

	public int maxInDegree()
	{
		int maxI = 0;
		for(int i = 0; i < G.length; i++)
		{
			int maxAtI = inDegree(i);
			if(maxAtI > maxI)
			{
				maxI = inDegree(i);
			}
		}
		return maxI;
	}

	public int minOutDegree()
	{
		int minO = 0;
		for(int i = 0; i < G.length; i++)
		{
			int minAtI = outDegree(i);
			if(minAtI < minO)
			{
				minO = outDegree(i);
			}
		}
		return minO;
	}
	public int minInDegree()
	{
		int minI = 0;
		for(int i = 0; i < G.length; i++)
		{
			int minAtI = inDegree(i);
			if(minAtI < minI)
			{
				minI = inDegree(i);
			}
		}
		return minI;
	}	
	
	public int maxDegree()
	{
		int max = 0;
		for(int i = 0; i < G.length; i++)
		{
			int maxD = degree(i);
			if(maxD > max)
			{
				max = maxD;
			}
		}
		return max;
	}

	public int minDegree()
	{
		int min = 0;
		for(int i = 0; i < G.length; i++)
		{
			int minD = degree(i);
			if(minD < min)
			{
				min = minD;
			}
		}
		return min;
	}
	
	public void removeEdge(int fromNode, int toNode)
	{
		/* if caller passes in a row col pair that 
		   out of bound or has no edge there, you must 
		   throw and catch an exception. See my output.
		
		   if the edge is there then remove it by writing 
		   in a NO_EDGE value at that coordinate in the grid	
		*/
		try
		{
			if(hasEdge(fromNode, toNode))
			{
				G[fromNode][toNode] = -1;
			}
			else
			{ 
				throw new Exception();
			}
		}
		catch(Exception e)
		{
			System.out.println("Java.lang.Exception: Non Existent Edge Exception: removeEdge("+ fromNode + "," + toNode + ")");
		}
	}
	
	// TOSTRING
	public String toString()
	{	String the2String = "";
		for (int r=0 ; r < G.length ;++r )
		{
			for ( int c=0 ; c < G[r].length ; ++c )
				the2String += String.format("%3s",G[r][c] + " ");
			the2String += "\n";
		}
		return the2String;
	} // END TOSTRING

} //EOF

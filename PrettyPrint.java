import java.util.*;
import java.io.*;
////////////////////////////////////////////////////////////////////////////////////////
class PrettyPrintNode
{
	String key;
	PrettyPrintNode left;
	PrettyPrintNode right;
	
	PrettyPrintNode(String key, PrettyPrintNode left, PrettyPrintNode right)
	{
		this.key = key;
		this.left = left;
		this.right = right;
	}
}
/////////////////////////////////////////////////////////////////////////////////////////
class PrettyPrint
{
	private PrettyPrintNode root;
	private int pNodeCount;
	private boolean dupe = false;
	private boolean unBalanced = false;
	static String[][] board;
	
	public void PrettyPrint()
	{
		pNodeCount = 0;
		root = null;
	}
	
	@SuppressWarnings("unchecked")
	public PrettyPrint(String fileName)throws Exception
	{
		pNodeCount = 0;
		root = null;
		BufferedReader file = new BufferedReader( new FileReader(fileName));
		while(file.ready())
		{
			String letter = file.readLine();
			if(letter != null)
				add(letter.trim());
		}
		file.close();
	}//prettyPrint method
	@SuppressWarnings("unchecked")
	public boolean add(String key)
	{
		dupe = false;
		root = addHelper(this.root, key);
		if(!dupe)
			pNodeCount++;
		return !dupe;
	}
	@SuppressWarnings("unchecked")
	private PrettyPrintNode addHelper(PrettyPrintNode root, String key)
	{
		if(root == null)
			return new PrettyPrintNode(key, null, null); 
		
		int value = ((Comparable)key).compareTo(root.key);
		if(value == 0)
		{
			dupe = true;
			return root;
		}
		else if(value < 0)
		{
			dupe = false;
			root.left = addHelper(root.left, key);
		}
		else if(value > 0)
		{
			dupe = false;
			root.right = addHelper(root.right, key);
		}
		return root;
	}//addHelper
	public void printInOrder()
	{
		printInOrder(this.root);
		System.out.println();
	}
	private void printInOrder(PrettyPrintNode root)
	{
		if(root == null)
			return;
			
		printInOrder(root.left);
		System.out.println(root.left + " ");
		printInOrder(root.right);
	}
	public int levelCount()
	{
		return levelCount(this.root);
	}
	private int levelCount(PrettyPrintNode root)
	{	
		if(root==null)
			return 0;
			
		return 1 + Math.max(levelCount(root.left),levelCount(root.right));
	}
	public int nodeCount()
	{
		return nodeCount(this.root);
	}
	private int nodeCount(PrettyPrintNode root)
	{
		if(root==null)
			return 0;
			
		return 1 + nodeCount(root.left) + nodeCount(root.right);
	}
	public PrettyPrint makeBalancedCopyOf()
	{
		ArrayList<String> keys = new ArrayList<String>();
		addInOrder(this.root, keys);
		PrettyPrint balancedTree = new PrettyPrint();
		int hi = keys.size()-1;
		int low = 0;
		addKeysBalanced(keys,low,hi, balancedTree);
		return balancedTree;
	}
	private void addInOrder(PrettyPrintNode root, ArrayList<String> keys)
	{
		if(root == null)
			return;
			
		addInOrder(root.left, keys);
		keys.add(root.key);
		addInOrder(root.right, keys);
	}
	void addKeysBalanced(ArrayList<String> keys, int low, int hi, PrettyPrint bTree)
	{
		if(low > hi)
			return;
			
		int mid = (low+hi)/2;
		bTree.add(keys.get(mid));
		addKeysBalanced(keys, low, mid-1, bTree);
		addKeysBalanced(keys, mid+1, hi, bTree);
	}
	public void prettyPrint()
	{
		board = new String[this.levelCount()][2*pNodeCount];
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[r].length; c++)
			{
				board[r][c] = " ";
			}
		}
		if(this.levelCount() == pNodeCount)
			unBalanced = true;
		
		subTree(0,pNodeCount,this.root);
		for(int r = 0; r < board.length; r++)
		{
			for(int c = 0; c < board[r].length; c++)
			{
				System.out.print(board[r][c]);
			}
			System.out.println();
		}
	}
	void subTree(int r, int c, PrettyPrintNode sb)
	{
		if(sb != null)
		{
			board[r][c] = sb.key;
			if(unBalanced)
			{
				subTree(r+1,c-1, sb.left);
				subTree(r+1,c+1, sb.right);
			}
			else
			{
				subTree(r+1,c-this.nodeCount(sb.left), sb.left);
				subTree(r+1,c+this.nodeCount(sb.right), sb.right);
			}
		}
	}
}//prettyPrint class

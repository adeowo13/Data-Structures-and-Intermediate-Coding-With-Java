import java.io.*;
import java.util.*;

///////////////////////////////////////////////////////////////////////////////
class BSTNode<T>
{	T key;
	BSTNode<T> left,right;
	BSTNode( T key, BSTNode<T> left, BSTNode<T> right )
	{	this.key = key;
		this.left = left;
		this.right = right;
	}
}

///////////////////////////////////////////////////////////////////////////////////////
class Queue<T>
{	LinkedList<BSTNode<T>> queue;
	Queue() { queue =  new LinkedList<BSTNode<T>>(); }
	boolean empty() { return queue.size() == 0; }
	void enqueue( BSTNode<T>  node ) { queue.addLast( node ); }
	BSTNode<T>  dequeue() { return queue.removeFirst(); }
	// THROWS NO SUCH ELEMENT EXCEPTION IF Q EMPTY
}

////////////////////////////////////////////////////////////////////////////////
class BSTreeP6<T>
{
	private BSTNode<T> root;
	private boolean addAttemptWasDupe=false;
	@SuppressWarnings("unchecked")
	public BSTreeP6( String infileName ) throws Exception
	{
		root=null;
		Scanner infile = new Scanner( new File( infileName ) );
		while ( infile.hasNext() )
			add( (T) infile.next() ); // THIS CAST RPODUCES THE WARNING
		infile.close();
	}

	public int size()
	{
		return countNodes(); 
	}

	// DUPES BOUNCE OFF & RETURN FALSE ELSE INCR COUNT & RETURN TRUE
	@SuppressWarnings("unchecked")
	public boolean add( T key )
	{	addAttemptWasDupe=false;
		root = addHelper( this.root, key );
		return !addAttemptWasDupe;
	}
	@SuppressWarnings("unchecked")
	private BSTNode<T> addHelper( BSTNode<T> root, T key )
	{
		if (root == null) return new BSTNode<T>(key,null,null);
		int comp = ((Comparable)key).compareTo( root.key );
		if ( comp == 0 )
			{ addAttemptWasDupe=true; return root; }
		else if (comp < 0)
			root.left = addHelper( root.left, key );
		else
			root.right = addHelper( root.right, key );

		return root;
    } // END addHelper


	// ITS A SEARCH - ONE OF FEW OPS YOU CAN DO ITERATIVELY
	public boolean contains( T key )
	{
		return contains( this.root, key  );
	}
	@SuppressWarnings("unchecked")
	private boolean contains( BSTNode<T> root, T key  )
	{
		if (root == null) return false;
		int comp = ((Comparable)key).compareTo( root.key );
		if ( comp == 0 ) return true;
		if (comp < 0) return contains(root.left, key );
		return contains(root.right, key );
	}

	public int countNodes()
	{
		return countNodes( root );
	}
	private int countNodes( BSTNode root)
	{
		if (root==null) return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
		
	public int countLevels()
	  {
		return countLevels( root ); 
	  }
	  private int countLevels( BSTNode root)
	  {
		if (root==null) return 0;
		return 1 + Math.max( countLevels(root.left), countLevels(root.right) );
	  }
	  
	  public int[] calcLevelCounts()
	  {
		int levelCounts[] = new int[countLevels()];
		calcLevelCounts( root, levelCounts, 0 );
		return levelCounts;
	  }
	  private void calcLevelCounts( BSTNode root, int levelCounts[], int level )
	  {
		if (root==null)return;
		++levelCounts[level];
		calcLevelCounts( root.left, levelCounts, level+1 );
		calcLevelCounts( root.right, levelCounts, level+1 );
	  }

	// INORDER TRAVERSAL REQUIRES RECURSION
	public void printInOrder()
	{
		printInOrder( this.root );
		System.out.println();
	}
	private void printInOrder( BSTNode<T> root )
	{
		if (root == null) return;
		printInOrder( root.left );
		System.out.print( root.key + " " );
		printInOrder( root.right );
	}

	public void printLevelOrder()
	{	if (this.root == null) return;
		Queue<T> q = new Queue<T>();
		q.enqueue( this.root ); // this. just for emphasis/clarity
		while ( !q.empty() )
		{	BSTNode<T> n = q.dequeue();
			System.out.print( n.key + " " );
			if ( n.left  != null ) q.enqueue( n.left );
			if ( n.right != null ) q.enqueue( n.right );
		}
	}

	// # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
	// DO NOT MODIFY ANYTHING ABOVE THIS LINE.  YOU FILL IN ALL THE CODE BELOW
	// # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #

	// return true only if it finds/removes the node
	public boolean remove( T key2remove )
	{
		if(root == null) 
			return false;
			
		BSTNode<T> parent = findParent( key2remove );
		BSTNode<T> pLeft = parent.left;
		BSTNode<T> pRight = parent.right;
		if(parent == null) 
			return false;
	
		if(pLeft.left == null && pRight.right == null) //(key2rem is a LEAF)
		{
			if (parent.left != null && key2remove.equals(parent.left.key))
			{
				parent.left = null;
				return true;
			}
			else if (parent.right != null && key2remove.equals(parent.right.key))
			{
				parent.right = null;
				return true;
			}
		}
		if(pLeft.left != null && pRight.right == null) //key2rem has one child
		{
			parent.right = pLeft;
			return true;
		}
		else if(pLeft.left == null && pRight.right != null) //other child
		{
			parent.right = pRight;
			return true;
		}
	}
	private BSTNode<T> findParent( T key2remove )
	{
		if(root == null) return null;
		BSTNode<T> parent = root;
		while(parent != null)
		{
			if(key2remove.compareTo(parent.key) < 0)//key2rem < parent.key
			{
				if(parent.left != null && parent.left.key.equals(key2remove)) 
					return parent;
				else if(parent.right != null && parent.right.key.equals(key2remove)) 
					return parent;
			}
			if(key2remove.compareTo(parent.key) < 0)
				parent = parent.left;
			else
				parent = parent.right;
		}
		return null;	
	}
}
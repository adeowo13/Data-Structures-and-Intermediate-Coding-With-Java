import java.io.*;
import java.util.*;

public class CDLL_JosephusList<T>
{
	private CDLL_Node<T> head;  // pointer to the front (first) element of the list
	private int count=0;
	// private Scanner kbd = new Scanner(System.in); // FOR DEBUGGING. See executeRitual() method 
	public CDLL_JosephusList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	
	public CDLL_JosephusList( String infileName ) throws Exception
	{
		BufferedReader infile = new BufferedReader( new FileReader( infileName ) );	
		while ( infile.ready() )
		{	@SuppressWarnings("unchecked") 
			T data = (T) infile.readLine(); // CAST CUASES WARNING (WHICH WE CONVENIENTLY SUPPRESS)
			insertAtTail( data ); 
		}
		infile.close();
	}
	

	
	// ########################## Y O U   W R I T E / F I L L   I N   T H E S E   M E T H O D S ########################
	
	// TACK ON NEW NODE AT END OF LIST
	@SuppressWarnings("unchecked")
	public void insertAtTail(T data)
	{
		CDLL_Node<T> newNode = new CDLL_Node( data,null,null);
		count++;
		if (head==null)
		{
			newNode.setNext( newNode );
			newNode.setPrev( newNode );
			head = newNode;
			return;
		}
		CDLL_Node<T> tail = head.getPrev();
		newNode.setPrev(tail);
		newNode.setNext(head);
		tail.setNext(newNode);
		head.setPrev(newNode);
		return;
	}
	public int size()
	{	
		return count;
	}
	
	// RETURN REF TO THE FIRST NODE CONTAINING  KEY. ELSE RETURN NULL
	public CDLL_Node<T> search( T key )
	{	

		CDLL_Node<T> curr = head;
		do
		{
			if(curr.getData().equals(key))
			{
				return curr;
			}
			curr = curr.getNext();
		}while(curr != head);		
 	 	return null;
	}
	
	// RETURNS CONATENATION OF CLOCKWISE TRAVERSAL
	@SuppressWarnings("unchecked")
	public String toString()
	{
		String result = "";
 		CDLL_Node<T> curr = head;
		do
		{
 			result += curr.getData() + "<=>";
 			curr = curr.getNext();		
 		}while(!curr.getNext().equals(head));
 		result += curr.getData();	
 		return result;
	}
	
	void removeNode( CDLL_Node<T> deadNode )
	{
		deadNode.getNext().setPrev(deadNode.getPrev());
		deadNode.getPrev().setNext(deadNode.getNext());
		count--;
	}
	
	public void executeRitual( T first2Bdeleted, int skipCount )
	{
		if (size() < 1 ) return;
		CDLL_Node<T> curr = search( first2Bdeleted );
		if ( curr==null ) return;
			 
		// OK THERE ARE AT LEAST 2 NODES AND CURR IS SITING ON first2Bdeleted
		do
		{
			CDLL_Node<T> deadNode = curr;
			T deadName = deadNode.getData();
			System.out.println("stopping on " + curr.getData() + " to delete " + curr.getData());
			removeNode(curr);
				
			if(head == deadNode)
			{
				if(skipCount > 0)
				{
					head = deadNode.getNext();
				}
				else
					head = deadNode.getPrev();
			}

			if(skipCount > 0)
			{	
				System.out.println("deleted. list now:  " + toString());
				if(size() == 1)
					break;
				System.out.println("resuming at "+ curr.getNext()+ ", skipping "+ curr.getNext() +" + "+ (skipCount-1) + " nodes CLOCKWISE after");						
				for(int i = 0; i <= skipCount; i++)// write loop that advance curr skipCount times (be sure of CLOCKWISE or COUNTER)
					curr = curr.getNext();
			 }
			 else
			 {
				System.out.println("deleted. list now:  " + toString());
				if(size() == 1)
					break;
				System.out.println("resuming at "+ curr.getPrev()+ ", skipping "+ curr.getPrev() +" + "+ (Math.abs(skipCount)-1) + " nodes COUTNER-CLOCKWISE after");			 
				for(int i = 0; i >= skipCount; i--)// write loop that advance curr skipCount times (be sure of CLOCKWISE or COUNTER)
					curr = curr.getPrev();
			}
		}while(size() > 1 );				
	} 		// String junk = kbd.nextLine();  <= MIGHT FIND THis HELPFUL. FOR DEBUGGING. WAITS FOR YOU TO HIT RETUN KEY

} // END CDLL_LIST CLASS
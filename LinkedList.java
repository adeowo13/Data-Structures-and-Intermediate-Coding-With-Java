import java.io.*;
import java.util.*;

public class LinkedList<T>
{
	private Node<T> head;  // pointer to the front (first) element of the list
	// private int counter;
	public LinkedList()
	{
		head = null; // compiler does this anyway. just for emphasis
	}

	// LOAD LINKED LIST FORM INCOMING FILE
	@SuppressWarnings("unchecked")	
	public LinkedList( String fileName, boolean orderedFlag )
	{
		head=null;
		try
		{
			BufferedReader infile = new BufferedReader( new FileReader( fileName ) );
			while ( infile.ready() )
			{
				if (orderedFlag)
					insertInOrder( (T)infile.readLine() );  // WILL INSERT EACH ELEM INTO IT'S SORTED POSITION
				else
					insertAtTail( (T)infile.readLine() );  // TACK EVERY NEWELEM ONTO END OF LIST. ORIGINAL ORDER PRESERVED
			}
			infile.close();
		}
		catch( Exception e )
		{
			System.out.println( "FATAL ERROR CAUGHT IN C'TOR: " + e );
			System.exit(0);
		}
	}

	//-------------------------------------------------------------

	// inserts new elem at front of list - pushing old elements back one place
	public void insertAtFront(T data)
	{
		head = new Node<T>(data,head);
	}

	// we use toString as our print


	public String toString()
	{
		String toString = "";

		for (Node curr = head; curr != null; curr = curr.getNext())
		{
			toString += curr.getData();		// WE ASSUME OUR T TYPE HAS toString() DEFINED
			if (curr.getNext() != null)
				toString += " ";
		}

		return toString;
	}

	// ########################## Y O U   W R I T E    T H E S E    M E T H O D S ########################

	
	public int size() // OF COURSE MORE EFFICIENT TO MAINTAIN COUNTER. BUT YOU WRITE LOOP!
	{
		Node <T> curr = head;
		int counter = 0;
		if(curr == null)
		{
			return counter;
		}
		while(curr != null)
		{
			counter++;
			curr = curr.getNext();
		}
		return counter;
	}
	public boolean empty()
	{
		return size() == 0;
	}
	public boolean contains( T key )
	{
		return this.search(key) != null;
	}
	public Node<T> search( T key )
	{
		if(head == null)
		return null;
		
		Node <T> curr = head;
		while(curr != null)
		{
			if(curr.getData().equals(key))
			{
				return curr;
			}
			curr = curr.getNext();
		}
		return null;
	}
	public void insertAtTail(T data) // TACK A NEW NODE (CABOOSE) ONTO THE END OF THE LIST
	{
		if(head == null)
		{
			head = new Node <T>(data);
		}
		else
		{
			Node <T> curr = head;
			while(curr.getNext() != null)
			{
				curr = curr.getNext();
			}
			curr.setNext(new Node<T>(data));
		}
	}
	@SuppressWarnings("unchecked")
	public void insertInOrder(T  data) // PLACE NODE IN LIST AT ITS SORTED ORDER POSTIOPN
	{
		Node <T> curr = head;	
		Comparable cdata = (Comparable<T>) data;
		if(head == null || cdata.compareTo(head.getData()) <= 0)
		{
			insertAtFront(data);
			return;
		}
		while(curr.getNext() != null)
		{
			if(cdata.compareTo(curr.getNext().getData()) < 0)
			{
				Node<T> new1 = new Node<T>(data, curr.getNext());
				curr.setNext(new1);
				return;
			}
		curr = curr.getNext();
		}
		Node<T> new2 = new Node<T>(data);
		curr.setNext(new2);
	}
	public boolean remove(T key) // FIND/REMOVE 1st OCCURANCE OF A NODE CONTAINING KEY
	{
		Node<T> curr = head;
		if(head == null)
			return false;
		if(head.getData().equals(key))
		{
			return removeAtFront();
		}
		while(curr.getNext()!= null)
		{
			if(curr.getNext().getData().equals(key))
			{	
				curr.setNext(curr.getNext().getNext());
				return true;
			}
		curr = curr.getNext();
		}
		return true;
	}
	public boolean removeAtTail()	// RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		if(head == null)
		{ 
			return false;
		} 
		Node <T> curr = head;
		if(curr.getNext() == null)
		{
			head = head.getNext();
			return true;
		}
		while(curr.getNext().getNext() != null)
		{
			curr = curr.getNext();
		}
		curr.setNext(null);
		return true;
	}
	public boolean removeAtFront() // RETURNS TRUE IF THERE WAS NODE TO REMOVE
	{
		if(head == null)
		{
			return false;
		}
		head = head.getNext();
		return true;
	}

	public LinkedList<T> union( LinkedList<T> other )
	{
		Node<T> curr = head;
		Node<T> otherC = other.head;
		LinkedList<T> temp = new LinkedList<T>();
		while(curr != null)
		{
			temp.insertInOrder(curr.getData());
			curr = curr.getNext();
		}
		while(otherC != null)
		{
			if(temp.contains(otherC.getData()) == false)
			{
				temp.insertInOrder(otherC.getData());
			}
			otherC = otherC.getNext();
		}
		return  temp; // CHANGE TO YOUR CODE
	}
	

	public LinkedList<T> inter( LinkedList<T> other )
	{	
		Node<T> curr = head;
		Node<T> otherC = other.head;
		LinkedList<T> temp = new LinkedList<T>();
		while(curr != null)
		{
			while(otherC != null)
			{
				if(this.contains(otherC.getData()) == true)
				{
					temp.insertInOrder(otherC.getData());
				}
				otherC = otherC.getNext();
			}
			curr = curr.getNext();
		}
		return temp;
	}


	public LinkedList<T> diff( LinkedList<T> other )
	{
		Node<T> curr = head;
		Node<T> otherC = other.head;
		LinkedList<T> temp = new LinkedList<T>();
		LinkedList<T> result = temp;
		while(curr != null)
		{
			if(!other.contains(curr.getData()))
			{
				temp.insertInOrder(curr.getData());
			}
			curr = curr.getNext();
		}
		return  result;
	}

	
	public LinkedList<T> xor( LinkedList<T> other )
	{
		return  (union(other)).diff(inter(other));
	}

} //END LINKEDLIST CLASS

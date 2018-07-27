import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Queue_Linked_List<Item> implements Iterable<Item>
{
	private class Node
	{
		Item item;
		Node next;
	}

	private Node first;
	private Node last;
	private int N = 0;

	public int size() { return N; }

	public boolean isEmpty() { return N == 0; }

	public void enqueue(Item item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty())
		{
			first = last;
		}
		else
		{
			oldlast.next = last;
		}
		N++;
	}

	public Item dequeue()
	{
		Item temp = first.item;
		first = first.next;
		if (isEmpty()) last = null;
		N--;
		return temp;
	}

	public Iterator<Item> iterator()
	{
		return new Queue_Linked_List_Iterator();
	}

	private class Queue_Linked_List_Iterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext() { return current != null; }

		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() { }
	}
}
import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Stack_Linked_List<Item> implements Iterable<Item>
{
	private class Node
	{
		Item item;
		Node next;
	}

	private Node first;
	private int N = 0;

	public int size() { return N; }

	public boolean isEmpty() { return N == 0; }

	public void push(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}

	public Item pop()
	{
		if (!isEmpty())
		{
			Item temp = first.item;
			first = first.next;
			N--;
			return temp;
		}
		return null;
	}

	public Iterator<Item> iterator()
	{
		return new Stack_Linked_List_Iterator();
	}

	private class Stack_Linked_List_Iterator implements Iterator<Item>
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
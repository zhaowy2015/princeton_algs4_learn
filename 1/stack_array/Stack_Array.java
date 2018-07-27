import edu.princeton.cs.algs4.StdOut;
import java.util.*;

public class Stack_Array<Item> implements Iterable<Item>
{
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;

	public int size() {return N;}

	public boolean isEmpty() {return N == 0;}

	private void resize(int newsize)
	{
		Item[] newarray = (Item[]) new Object[newsize];
		for (int i = 0; i < N; i++)
			newarray[i] = a[i];
		a = newarray;	
	}

	public void push(Item item)
	{
		if (a.length == N)
			resize(2 * a.length);
		a[N++] = item;
	}

	public Item pop()
	{
		Item item = a[N - 1];
		a[N - 1] = null;
		N--;
		if (N == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	public Iterator<Item> iterator()
	{
		return new Stack_Array_Iterator();
	}

	private class Stack_Array_Iterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext() { return i > 0; }
		public Item next() { return a[--i]; }
		public void remove() { }
	}

}
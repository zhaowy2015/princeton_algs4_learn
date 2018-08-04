import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;


public class Priority_queue<Key extends Comparable<Key>>
{
	private Key[] pq;
	private int N = 0;

	public Priority_queue(int maxN)
	{
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public boolean isEmpty()
	{
		return N == 0;
	}

	public int size()
	{
		return N;
	}

	public void insert(Key v)
	{
		if (N == pq.length-1) resize(2 * pq.length);
		pq[++N] = v;
		swim(N);
	}

	
	public Key delMax()
	{
		exch(1, N);
		Key temp = pq[N];
		pq[N--] = null;
		sink(1);
		if (N > 0 && N == (pq.length-1)/4) resize(pq.length/2);
		return temp;
	}

	private boolean less(int i, int j)
	{
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i , int j)
	{
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

	private void swim(int k)
	{
		while (k > 1 && less(k/2, k))
		{
			if (k == 1) break;
			exch(k, k/2);
			k = k/2;
		}
	}

	private void sink(int k)
	{
		while (2 * k <= N)
		{
			int j = 2 * k;
			if (j+1 <= N && less(j, j+1))
				j++;
			if (!less(k, j)) break;
			exch(j, k);
			k = j;
		}
	}

	private void resize(int newN)
	{
		Key[] newarr = (Key []) new Comparable[newN];
		for (int i = 0; i <= N; i++)
			newarr[i] = pq[i];
		pq = newarr;
	}

	private void show()
	{
		for (int i = 1; i < pq.length; i++)
			StdOut.println(pq[i]);
	}

	public static void main(String[] args)
	{
		Integer[] a = {0, 6, 4, 9, 2, 1, 3};
		Priority_queue prq = new Priority_queue(5);
		prq.insert(6);
		prq.insert(4);
		prq.insert(9);
		prq.insert(2);
		prq.insert(1);
		prq.insert(3);
		prq.show();

		StdOut.println("del" + prq.delMax());
		StdOut.println("del" + prq.delMax());
		StdOut.println("del" + prq.delMax());
		StdOut.println("del" + prq.delMax());

		prq.show();
	}
}
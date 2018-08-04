import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Insertion_sort
{
	public static void sort(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			for (int j = i; j > 0; j--)
			{
				if (less(a[j - 1], a[j])) break;
				exch(a, j, j - 1);
			}
		}
	}

	private static boolean less(Comparable v, Comparable w)
	{
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j)
	{
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
		{
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
		{
			if (less(a[i], a[i - 1])) return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		int N = 100000;
		Double a[] = new Double[N];
		for (int i = 0; i < a.length; i++)
			a[i] = StdRandom.uniform(0.0, 101.0);

		Insertion_sort insert_sort = new Insertion_sort();
		insert_sort.sort(a);
		if (insert_sort.isSorted(a)) StdOut.println("Excellent!");
		//if (insert_sort.isSorted(a)) insert_sort.show(a);
	}
}
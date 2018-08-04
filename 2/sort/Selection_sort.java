import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Selection_sort
{
	public static void sort(Comparable[] a)
	{
		for (int i = 0; i < a.length - 1; i++)
		{
			int min = i;
			for (int j = i + 1; j < a.length; j++)
			{
				if (less(a[j], a[min])) min = j;
			}
			exch(a, i, min);
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

		Selection_sort select_sort = new Selection_sort();
		select_sort.sort(a);
		if (select_sort.isSorted(a)) StdOut.println("Excellent!");
	}
}
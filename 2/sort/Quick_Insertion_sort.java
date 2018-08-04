import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_Insertion_sort
{
	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo + 10) { insert_sort(a, lo, hi); return; }
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}

	private static void insert_sort(Comparable[] a, int lo, int hi)
	{
		for (int i = lo; i <= hi; i++)
		{
			for (int j = i; j > lo; j--)
			{
				if (less(a[j - 1], a[j])) break;
				exch(a, j, j - 1);
			}
		}
	}

	private static int partition(Comparable[] a, int lo, int hi)
	{
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];

		while (true)
		{
			while (less(a[++i], v)) if (i == hi) break;
			while (less(v, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
		
		int N = 1000000;
		Double a[] = new Double[N];
		for (int i = 0; i < a.length; i++)
			a[i] = StdRandom.uniform(0.0, 101.0);
		//show(a);
		Quick_Insertion_sort quick_insert_sort = new Quick_Insertion_sort();
		quick_insert_sort.sort(a);
		if (quick_insert_sort.isSorted(a)) StdOut.println("Excellent!");
		//if (quick_insert_sort.isSorted(a)) quick_insert_sort.show(a);
		
		//Integer[] a = {4};
		//Integer[] a = {7, 3, 2, 9};
	
		//if (check(a, partition(a, 0, a.length-1))) StdOut.println("Excellent!");
		//show(a);
	}
}
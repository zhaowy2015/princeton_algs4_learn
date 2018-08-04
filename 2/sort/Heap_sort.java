import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Heap_sort
{
	public static void sort(Comparable[] a)
	{
		int N = a.length - 1;
		convert_heap(a);
		for (int i = N; i > 0; i--)
		{
			exch(a, 0, i);
			sink(a, 0, --N);
		}
	}

	private static void convert_heap(Comparable[] a)
	{
		for (int i = (a.length-1)/2; i >= 0; i--)
		{
			sink(a, i);
		}
	}

	private static boolean less(Comparable[] a, int i, int j)
	{
		return a[i].compareTo(a[j]) < 0;
	}

	private static void exch(Comparable[] a, int i , int j)
	{
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void swim(Comparable[] a, int k)
	{
		while (k > 0 && less(a, (k-1)/2, k))
		{
			//if (k == 0) break;
			exch(a, k, (k-1)/2);
			k = (k-1)/2;
		}
	}

	private static void sink(Comparable[] a, int k)
	{
		while (2*k + 1 <= a.length-1)
		{
			int j = 2*k + 1;
			if (j+1 <= a.length-1 && less(a, j, j+1))
				j++;
			if (!less(a, k, j)) break;
			exch(a, j, k);
			k = j;
		}
	}

	private static void sink(Comparable[] a, int k, int N)
	{
		while (2*k + 1 <= N)
		{
			int j = 2*k + 1;
			if (j+1 <= N && less(a, j, j+1))
				j++;
			if (!less(a, k, j)) break;
			exch(a, j, k);
			k = j;
		}
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
			if (less(a, i, i - 1)) return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		
		int N = 100000;
		Double a[] = new Double[N];
		for (int i = 0; i < a.length; i++)
			a[i] = StdRandom.uniform(0.0, 101.0);

		Heap_sort heap_sort = new Heap_sort();
		heap_sort.sort(a);
		if (heap_sort.isSorted(a)) StdOut.println("Excellent!");
		//if (heap_sort.isSorted(a)) heap_sort.show(a);
		
		

		/*
		Integer[] a = {4, 7, 6, 9};
		Heap_sort heap_sort = new Heap_sort();
		heap_sort.sort(a);
		heap_sort.show(a);
		*/
		

	}
}
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Merge_Insertion_sort
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		Comparable[] temp = new Comparable[N];

		if (N < 20) 
			{
				insert_sort(a, 0, N-1);
				return;
			}

		for (int i = 0; i < N; i += 16)
		{
			insert_sort(a, i, Math.min(i+15, N-1));
		}

		for (int size = 16; size < N; size *= 2)
		{
			for (int i = 0; i < N; i += (2 * size))
			{
				//StdOut.println("!!!");
				merge(a, i, Math.min(i+size-1, N-1), Math.min(i+ 2*size - 1, N-1), temp);
				//show(a);
				//StdOut.printf("\n\n");

			}
		}
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

	private static void merge(Comparable[] a, int lo, int mid, int hi, Comparable[] temp)
	{
		//Merge a[lo, mid] and a[mid + 1, hi]
		//StdOut.printf("%d, %d, %d\n", lo, mid, hi);
		int i = lo;
		int j = mid + 1;

		for (int k = lo; k <= hi; k++) temp[k] = a[k];

		for (int k = lo; k <= hi; k++)
		{
			if (i > mid) a[k] = temp[j++];
			else if (j > hi) a[k] = temp[i++];
			else if (less(temp[j], temp[i])) a[k] = temp[j++];
			else a[k] = temp[i++];
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
		
		
		int N = 10000000;
		Double a[] = new Double[N];
		for (int i = 0; i < a.length; i++)
			a[i] = StdRandom.uniform(0.0, 101.0);

		Merge_Insertion_sort merge_insertion_sort = new Merge_Insertion_sort();
		merge_insertion_sort.sort(a);
		
		if (merge_insertion_sort.isSorted(a)) StdOut.println("Excellent!");	
		//if (merge_sort.isSorted(a)) merge_sort.show(a);

	}
}
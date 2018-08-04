import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class Shell_sort
{
	public static void sort(Comparable[] a)
	{
		int h = a.length / 3 + 1;
		while (h >= 1)
		{
			for (int i = a.length - 1; i >= a.length - h; i--)
			{
				//StdOut.println(i);
				for (int j = i; j - h >= 0; j -= h)
				{
					if (less(a[j - h], a[j])) break;
					exch(a, j, j - h);
				}

			}
			h--;
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

		Shell_sort shell_sort = new Shell_sort();
		shell_sort.sort(a);
		if (shell_sort.isSorted(a)) StdOut.println("Excellent!");
		
		//if (shell_sort.isSorted(a)) shell_sort.show(a);

		//Integer[] b = {7, 1, 9, 2, 4, 5, 6, 3, 11};
		//Shell_sort.sort(b);
	}
}
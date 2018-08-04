import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import java.util.*;

public class SortCompare
{
	public static double time(String alg, Double[] a)
	{
		Stopwatch timer = new Stopwatch();
		if (alg.equals("Insertion")) Insertion_sort.sort(a);
		if (alg.equals("Selection")) Selection_sort.sort(a);
		if (alg.equals("Shell")) Shell_sort.sort(a);
		if (alg.equals("Merge")) Merge_sort.sort(a);
		if (alg.equals("MergeInsert")) Merge_Insertion_sort.sort(a);
		if (alg.equals("Quick")) Quick_sort.sort(a);
		if (alg.equals("QuickInsert")) Quick_Insertion_sort.sort(a);
		if (alg.equals("Heap")) Heap_sort.sort(a);
		if (alg.equals("Standard")) Arrays.sort(a);
		return timer.elapsedTime();
	}

	public static double timeRandomInput(String alg, int N, int T)
	{
		double total = 0.0;
		Double[] a = new Double[N];
		for (int i = 0; i < T; i++)
		{
			for (int j = 0; j < N; j++)
			{
				a[j] = StdRandom.uniform(0.0, 201.0);
			}
			total += time(alg, a);
		}
		return total;

	}

	public static void main(String[] args)
	{
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);

		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);

		StdOut.printf("N = %d, T = %d\n", N, T);
		StdOut.printf("%s: %.1f\n", alg1, t1/T);
		StdOut.printf("%s: %.1f\n", alg2, t2/T);
		StdOut.printf("%s / %s: %.1f\n", alg1, alg2, t1/t2);
	}
}
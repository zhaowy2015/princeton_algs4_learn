import edu.princeton.cs.algs4.StdOut;

public class Binary_search
{
	public static int binary_search_rank(int key, int[] a)
	{
		int lo = 0;
		int hi = a.length - 1;
		int mid = 0;

		while (lo <= hi)
		{
			mid = (lo + hi) / 2;
			if (key == a[mid])
				return mid;
			else if (key < a[mid])
			{
				hi = mid - 1;
			}
			else
			{
				lo = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args)
	{
		int[] a = {1, 7, 9, 13, 17};
		int index = binary_search_rank(-9, a);
		StdOut.printf("index is : %d\n", index);
	}
}
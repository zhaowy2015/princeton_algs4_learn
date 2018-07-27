import edu.princeton.cs.algs4.StdOut;

public class test
{
	public static void main(String[] args)
	{
		Stack_Array<Integer> stack = new Stack_Array<Integer>();
		for (int i = 0; i < 101; i++)
			stack.push(i);
		for (int i = 0; i < 95; i++)
			stack.pop();
		for (int item : stack)
			StdOut.println(item);

	}
}

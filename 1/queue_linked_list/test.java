import edu.princeton.cs.algs4.StdOut;

public class test
{
	public static void main(String[] args)
	{
		Queue_Linked_List<Integer> stack = new Queue_Linked_List<Integer>();
		for (int i = 0; i < 101; i++)
			stack.enqueue(i);
		for (int i = 0; i < 101; i++)
			stack.dequeue();
		for (int i = 0; i < 10; i++)
			stack.enqueue(i);		
		for (int item : stack)
			StdOut.println(item);

	}
}

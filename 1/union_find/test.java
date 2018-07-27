import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class test
{
	public static void main(String[] args)
	{
		int N = StdIn.readInt();
		UF uf = new UF(N);
		
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (uf.connected(p, q)) continue;
			uf.union(p, q);
			//StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + "components");
		
		
	}
}
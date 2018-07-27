public class UF
{
	private int[] id;
	private int count;
	private int[] size;

	public UF(int N)
	{
		count = N;
		id = new int[N];
		size = new int[N];

		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			size[i] = 1;
		}
	}

	public void union(int p, int q)
	{
		int id_p = find(p);
		int id_q = find(q);
		if (id_p == id_q) return;
		else
		{
			if (size[id_p] < size[id_q])
			{
				size[id_q] += size[id_p];
				id[id_p] = id_q;
				count--;
			}
			else
			{
				size[id_p] += size[id_q];
				id[id_q] = id_p;
				count--;
			}
		}
	}

	public int find(int p)
	{
		int temp_id_p = p;
		while (temp_id_p != id[temp_id_p])
		{
			temp_id_p = id[temp_id_p];
		}
		return temp_id_p;
	}

	public boolean connected(int p, int q)
	{
		return find(p) == find(q);
	}

	public int count()
	{
		return count;
	}
}
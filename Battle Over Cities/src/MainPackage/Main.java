package MainPackage;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		List<Pair> pairs = new ArrayList<Pair>();
		int cities;
		int highways;
		int checkCity;
		int from, to;
		int root1, root2;
		DisjSets uions;
		
		cities = in.nextInt();
		highways = in.nextInt();
		checkCity = in.nextInt();

		for(int i = 0; i < highways; i++)
		{
			from = in.nextInt();
			to = in.nextInt();
			pairs.add(new Pair(from, to));
		}
		
		for(int i = 0; i < checkCity; i++)
		{
			uions = new DisjSets(cities);
			int intTmp = in.nextInt();
			
			for(Pair pair : pairs)
			{
				if(pair.a != intTmp && pair.b != intTmp)
				{
					root1 = uions.find(pair.a);
					root2 = uions.find(pair.b);
					if(root1 != root2)
						uions.union(root1, root2);
				}
			}
			
			System.out.println(uions.count - 2);
		}
	}
	
	private static class DisjSets
	{
		private int count;
		private int[] s;
		
		public DisjSets(int nums)
		{
			count = nums;
			s = new int[count + 1];
			for(int i = 0; i < s.length; i++)
				s[i] = -1;
		}
		
		public void union(int root1, int root2)
		{
			if(root1 >= s.length || root2 >= s.length)
				return;
			
			if(s[root2] > s[root1])
			{
				s[root1] += s[root2];
				s[root2] = root1;
				count--;
			}
			else
			{
				s[root2] += s[root1];
				s[root1] = root2;
				count--;
			}
		}
		
		public int find(int x)
		{
			if(s[x] < 0)
				return x;
			else 
			{
				s[x] = find(s[x]);
				return s[x];
			}
		}
	}
	
	private static class Pair
	{
		private int a;
		private int b;
		
		public Pair(int a, int b)
		{
			this.a = a;
			this.b = b;
		}
	}
}

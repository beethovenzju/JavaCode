package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
		int num;
		Uion uion;
		Result firstResult = new Result();
		Result secondResult = new Result();
		List<Vertex> result = new LinkedList<Vertex>();
		
		num = in.nextInt();
		uion = new Uion(num);
		
		if(num == 1)
		{
			System.out.print("1");
			return;
		}
		
		for(int i = 1; i <= num; i++)
		{
			Vertex v = new Vertex(i);
			map.put(i, v);
		}
		
		for(int i = 0; i < num - 1; i++)
		{
			int one = in.nextInt();
			int other = in.nextInt();
			uion.merge(one, other);
			Vertex oneV = map.get(one);
			Vertex otherV = map.get(other);
			oneV.addItem(otherV);
			otherV.addItem(oneV);
		}
		
		if(uion.count > 1)
			System.out.print("Error: " + uion.count + " components");
		else
		{
			int depth = 0;
			Vertex root = map.get(1);
			DFS(root, firstResult, depth);
			depth = 0;
			root = firstResult.items.get(0);
			for(Map.Entry<Integer, Vertex> entry : map.entrySet())
				entry.getValue().isVisited = false;
			
			DFS(root, secondResult, depth);
			
			for(int i = 0; i < firstResult.items.size(); i++)
				result.add(firstResult.items.get(i));
			
			for(int i = 0; i < secondResult.items.size(); i++)
			{
				Vertex tmp = secondResult.items.get(i);
				if(!result.contains(tmp))
					result.add(tmp);
			}
			
			Collections.sort(result);
			
			for(int i = 0; i < result.size(); i++)
				System.out.println(result.get(i).id);
		}
	}
	
	public static class Vertex implements Comparable<Vertex>
	{
		private int id;
		private boolean isVisited;
		private List<Vertex> adjacent;
		
		public Vertex(int id)
		{
			this.id = id;
			isVisited = false;
			adjacent = new LinkedList<Vertex>();
		}
		
		public void addItem(Vertex v)
		{
			adjacent.add(v);
		}
		
		public int compareTo(Vertex arg)
		{
			return  this.id - arg.id;
		}
	}
	
	public static class Uion
	{
		private int count;
		private int[] array;
		
		public Uion(int count)
		{
			this.count = count;
			array = new int[count + 1];
			
			for(int i = 1; i <= count; i++)
				array[i] = -1;
		}
		
		public int find(int sour)
		{
			if(array[sour] == -1)
				return sour;
			else
			{
				array[sour] = find(array[sour]);
				return array[sour];
			}
		}
		
		public void merge(int a, int b)
		{
			if(find( a) == find(b))
				return;
			else
			{
				array[b] = a;
				count--;
			}
		}
	}
	
	public static class Result
	{
		private int depth;
		private List<Vertex> items;
		
		public Result()
		{
			depth = 0;
			items = new LinkedList<Vertex>();
		}
	}
	
	public static void DFS(Vertex root, Result list, int depth)
	{
		depth++;
		root.isVisited = true;
		if(root.adjacent.size() == 0)
			return;
		
		for(Vertex v : root.adjacent)
		{
			if(v.isVisited)
				continue;
			
			if(depth > list.depth)
			{
				list.items.clear();
				list.depth = depth;
				list.items.add(v);
			}
			else if(depth == list.depth)
				list.items.add(v);
			
			DFS(v, list, depth);
		}
		
	}
}

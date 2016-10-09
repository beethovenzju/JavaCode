package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
		Stack<Vertex> stack = new Stack<Vertex>();
		Vertex start;
		Vertex tmp;
		int cityNum = 0;
		int roadNum = 0;
		int startIndex = 0;
		int destIndex = 0;
		int one;
		int other;
		int distance;
		int cost;
		
		cityNum = in.nextInt();
		roadNum = in.nextInt();
		startIndex = in.nextInt();
		destIndex = in.nextInt();
		for(int i = 0; i < cityNum; i++)
		{
			Vertex v = new Vertex(i);
			map.put(i, v);
		}
		
		for(int i = 0; i < roadNum; i++)
		{
			one = in.nextInt();
			other = in.nextInt();
			distance = in.nextInt();
			cost = in.nextInt();
			map.get(one).addItem(map.get(other), distance, cost);
			map.get(other).addItem(map.get(one), distance, cost);
		}
		
		start = map.get(startIndex);
		start.distance = 0;
		start.cost = 0;
		for(;;)
		{
			tmp = null;
			int tmpDistance = Integer.MAX_VALUE;
			for(Map.Entry<Integer, Vertex> entry : map.entrySet())
			{
				Vertex current = entry.getValue();
				if(!current.isVisited && current.distance < tmpDistance)
				{
					tmpDistance = current.distance;
					tmp = current;
				}
			}
			if(tmp == null || tmp.id == destIndex)
				break;
			
			tmp.isVisited = true;
			for(AdjacentInfo a : tmp.adjacent)
			{
				if(a.v.isVisited)
					continue;
				if(a.v.distance > tmp.distance + a.distance)
				{
					a.v.distance = tmp.distance + a.distance;
					a.v.cost = tmp.cost + a.cost;
					a.v.path = tmp;
				}
				else if(a.v.distance == tmp.distance + a.distance)
				{
					if(a.v.cost > tmp.cost + a.cost)
					{
						a.v.cost = tmp.cost + a.cost;
						a.v.path = tmp;
					}
				}
			}
		}
		tmp = map.get(destIndex);
		stack.add(tmp);
		while(tmp.path != null)
		{
			stack.push(tmp.path);
			tmp = tmp.path;
		}
		
		System.out.print(stack.pop().id);
		while(stack.size() != 0)
			System.out.print(" " + stack.pop().id);
		System.out.print(" " + map.get(destIndex).distance + " " + map.get(destIndex).cost);
	}
	
	public static class Vertex
	{
		private int id;
		private int distance;
		private int cost;
		private Vertex path;
		private List<AdjacentInfo> adjacent;
		private boolean isVisited;
		
		public Vertex(int id)
		{
			this.id = id;
			this.distance = Integer.MAX_VALUE;
			this.cost = Integer.MAX_VALUE;
			this.path = null;
			this.isVisited = false;
			this.adjacent = new LinkedList<AdjacentInfo>();
		}
		
		public void addItem(Vertex id, int distance, int cost)
		{
			AdjacentInfo info = new AdjacentInfo(id, distance, cost);
			adjacent.add(info);
		}
	}
	
	public static class AdjacentInfo
	{
		private Vertex v;
		private int distance;
		private int cost;
		
		public AdjacentInfo(Vertex v, int distance, int cost)
		{
			this.v = v;
			this.distance = distance;
			this.cost = cost;
		}
	}
}

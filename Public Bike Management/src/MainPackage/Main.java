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
		Result result;
		int maxNum;
		int stations = 0;
		int destIndex = 0;
		int roads = 0;
		int num;
		
		Vertex start = new Vertex(0, 0);
		map.put(0, start);
		
		maxNum = in.nextInt();
		stations = in.nextInt();
		destIndex = in.nextInt();
		roads = in.nextInt();
		
		result = new Result(maxNum);
		
		for(int i = 1; i <= stations; i++)
		{
			num = in.nextInt();
			Vertex v = new Vertex(i, num);
			map.put(i, v);
		}
		
		for(int i = 0; i < roads; i++)
		{
			int v1 = in.nextInt();
			int v2 = in.nextInt();
			int cost = in.nextInt();
			map.get(v1).addItem(v2, cost);
			map.get(v2).addItem(v1, cost);
		}

		start.distance = 0;
		
		for(;;)
		{
			Vertex v = null;
			int distance = Integer.MAX_VALUE;
			for(Map.Entry<Integer, Vertex> entry : map.entrySet())
			{
				Vertex value = entry.getValue();
				if(!value.isVisited && value.distance < distance)
				{
					distance = value.distance;
					v = value;
				}
			}
			
			if(v == null || v.id == destIndex)
				break;
			
			v.isVisited = true;
			
			for(Pair pair : v.lists)
			{
				Vertex cur = map.get(pair.id);
				if(cur.isVisited)
					continue;
				
				if(v.distance + pair.cost < cur.distance)
				{
					cur.distance = v.distance + pair.cost;
					
					if(cur.pathList.size() == 0)
						cur.pathList.add(v);
					else if(cur.pathList.size() == 1)
						cur.pathList.set(0, v);
					else
					{
						cur.pathList.clear();
						cur.pathList.add(v);
					}
					
				}
				else if(v.distance + pair.cost == cur.distance)
					cur.pathList.add(v);
			}
		}
		
		Vertex end = map.get(destIndex);
		
		findPath(end, stack, result);
		
		System.out.print(result.carryNum + " ");
		
		for(Vertex v : result.path)
		{
			if(v.id == 0)
				System.out.print(0);
			else
				System.out.print("->" + v.id);
		}
		
		System.out.print(" " + result.rebackNum);
	}
	
	public static class Vertex
	{
		private int id;
		private List<Pair> lists;
		private boolean isVisited;
		private int distance;
		private int num;
		private List<Vertex> pathList;
		
		public Vertex(int id, int num)
		{
			this.id = id;
			this.num = num;
			this.distance = Integer.MAX_VALUE;
			lists = new LinkedList<Pair>();
			isVisited = false;
			pathList = new LinkedList<Vertex>();
		}
		
		public void addItem(int id, int cost)
		{
			Pair pair = new Pair(id, cost);
			lists.add(pair);
		}
	}
	
	public static class Pair
	{
		private int id;
		private int cost;
		
		public Pair(int id, int cost)
		{
			this.id = id;
			this.cost = cost;
		}
	}
	
	public static class Result
	{
		private int carryNum;
		private int rebackNum;
		private List<Vertex> path;
		private final int MaxNum;
		
		public Result(int max)
		{
			MaxNum = max;
			carryNum = Integer.MAX_VALUE;
			rebackNum = Integer.MAX_VALUE;
		}
	}
	
	public static void findPath(Vertex v, Stack<Vertex> stack, Result result)
	{
		stack.push(v);
		if(v.id != 0)
		{
			for(Vertex tmp : v.pathList)
			{
				findPath(tmp, stack, result);
				stack.pop();
			}
		}
		else
		{
			List<Vertex> list = new ArrayList<Vertex>();
			list.add(v);
			int carryNum = 0;
			int totalNum = 0;
			int count = 0;
			for(int i = stack.size() - 2; i >= 0; i--)
			{
				Vertex vt = stack.get(i);
				list.add(vt);
				if(vt.num < result.MaxNum / 2)
				{
					count = result.MaxNum / 2 - vt.num;
					if(totalNum < count)
					{
						carryNum += count - totalNum;
						totalNum += (count - totalNum);
					}
					
					totalNum -= count;
				}
				else if(vt.num > result.MaxNum / 2)
				{
					count = vt.num - result.MaxNum / 2;
					totalNum += count;
				}
			}
			
			if(carryNum < result.carryNum)
			{
				result.carryNum = carryNum;
				result.rebackNum = totalNum;
				result.path = list;
			}
			else if(carryNum == result.carryNum)
			{
				if(totalNum < result.rebackNum)
				{
					result.rebackNum = totalNum;
					result.path = list;
				}
			}
		}
	}
}

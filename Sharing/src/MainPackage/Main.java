package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	private static final int MAXN = 100010;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Vertex[] arrays = new Vertex[MAXN];
		int start1, start2;
		Vertex current;
		int nodeNum = 0;
		int id, next;
		String item;

		start1 = Integer.parseInt(in.next());
		start2 = Integer.parseInt(in.next());
		nodeNum = in.nextInt();
		for(int i = 0; i < nodeNum; i++)
		{
			id = Integer.parseInt(in.next());
			item = in.next();
			next = Integer.parseInt(in.next());
			if(arrays[id] == null)
				arrays[id] = new Vertex(id, next);
		}
		
		current = arrays[start1];
		current.isVisited = true;
		while(current.next != -1)
		{
			current = arrays[current.next];
			current.isVisited = true;
		}
		
		current = arrays[start2];
		if(current.isVisited)
		{
			System.out.println(current.id);
			return;
		}
		else
		{
			current.isVisited = true;
			while(current.next != -1)
			{
				current = arrays[current.next];
				
				if(current.isVisited)
				{
					System.out.printf("%05d", current.id);
					return;
				}
			}
		}

		System.out.println("-1");
	}
	
	public static class Vertex
	{
		private int id;
		private boolean isVisited;
		private int next;
		
		public Vertex(int id, int next)
		{
			this.id = id;
			this.next = next;
			
			isVisited = false;
		}
	}
}

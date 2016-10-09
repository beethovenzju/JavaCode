package MainPackage;

import java.util.*;

public class Main 
{
	public static void main(String[] args)
	{
		int nodes;
		int nonleafNodes;
		int tmpChildCount;
		int tmpDepth;
		int leafNode;
		String parentId;
		String childId;
		Vertex tmpVertex;
		Vertex childVertex;
		Queue<Vertex> que = new LinkedList<Vertex>();
		Map<String, Vertex> map = new HashMap<String, Vertex>();
		Scanner in = new Scanner(System.in);
		
		nodes = in.nextInt();
		nonleafNodes = in.nextInt();
		
		tmpVertex = new Vertex();
		map.put("01", tmpVertex);
		
		for(int i = 0; i < nonleafNodes; i++)
		{
			parentId = in.next();
			tmpChildCount = in.nextInt();
			
			if(map.containsKey(parentId))
				tmpVertex = map.get(parentId);
			else
			{
				tmpVertex = new Vertex();
				map.put(parentId, tmpVertex);
			}
			
			tmpVertex.childCount = tmpChildCount;
			
			for(int j = 0; j < tmpChildCount; j++)
			{
				childId = in.next();
				if(map.containsKey(childId))
					childVertex = map.get(childId);
				else
				{
					childVertex = new Vertex();
					map.put(childId, childVertex);
				}
				
				tmpVertex.addChild(childVertex);
			}
		}
		tmpVertex = map.get("01");
		tmpVertex.depth = 0;
		que.add(tmpVertex);
		tmpDepth = 0;
		leafNode = 0;
		while(que.size() != 0)
		{
			tmpVertex = que.remove();
			if(tmpVertex.depth != tmpDepth)
			{
				System.out.print(leafNode + " ");
				tmpDepth ++;
				leafNode = 0;
			}

			if(tmpVertex.childCount == 0)
				leafNode++;
			else
			{
				for(Vertex v : tmpVertex.childs)
				{
					v.depth = tmpVertex.depth + 1;
					que.add(v);
				}
			}
		}
		System.out.print(leafNode);
		
		if(in != null)
			in.close();
	}
	
	private static class Vertex
	{
		private int childCount;
		private int depth;
		private List<Vertex> childs;
		
		public Vertex()
		{
			childCount = 0;
			depth = 0;
			childs = new LinkedList<Vertex>();
		}
		
		public void addChild(Vertex item)
		{
			if(childs != null && item != null)
				childs.add(item);
		}
	}
}

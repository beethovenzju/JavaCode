package MainPackage;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			Map<Integer, Vertex> map = new HashMap<Integer, Vertex>();
			int n = in.nextInt();
			int m = in.nextInt();
			for(int i = 0; i < m; i++){
				int from = in.nextInt();
				int to = in.nextInt();
				Vertex fromVertex;
				Vertex toVertex;
				if(map.containsKey(from))
					fromVertex = map.get(from);
				else
					fromVertex = new Vertex(from);
				if(map.containsKey(to))
					toVertex = map.get(to);
				else
					toVertex = new Vertex(to);
				
				int cost = in.nextInt();
				int unableFromTime = in.nextInt();
				int unableToTime = in.nextInt();
				Info info = new Info(to, cost, unableFromTime, unableToTime);
				fromVertex.list.add(info);
				map.put(from, fromVertex);
				
				info = new Info(from, cost, unableFromTime, unableToTime);
				toVertex.list.add(info);
				map.put(to, toVertex);
			}
			
			Vertex first = map.get(1);
			first.value = 0;
			while(true){
				int minValue = Integer.MAX_VALUE;
				Vertex cur = null;
				for(Map.Entry<Integer, Vertex> entry : map.entrySet()){
					Vertex tmp = entry.getValue();
					if(!tmp.isVisited &&tmp.value < minValue){
						minValue = tmp.value;
						cur = tmp;
					}
				}
				
				if(cur.index == n){
					System.out.println(cur.value);
					return;
				}
				
				cur.isVisited = true;
				for(Info info : cur.list){
					Vertex tmp = map.get(info.to);
					if(!tmp.isVisited){
						int value = info.getTime(cur.value);
						if(value < tmp.value)
							tmp.value = value;
					}
				}
			}
		}
	}
	
	private static class Vertex{
		private int index;
		private boolean isVisited;
		private List<Info> list;
		private int value;
		
		public Vertex(int index){
			this.index = index;
			isVisited = false;
			list = new LinkedList<Info>();
			value = Integer.MAX_VALUE;
		}
	}
	
	private static class Info{
		private int to;
		private int cost;
		private int unableFromTime;
		private int unableToTime;
		
		public Info(int to, int cost, int unableFromTime, int unableToTime) {
			this.to = to;
			this.cost = cost;
			this.unableFromTime = unableFromTime;
			this.unableToTime = unableToTime;
		}
		
		public int getTime(int start){
			if(start + cost < unableFromTime || start > unableToTime)
				return (start + cost);
			else
				return (unableToTime + 1 + cost);
		}
	}
}

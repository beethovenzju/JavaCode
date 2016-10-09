package MainPackage;

import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			List<Item> list = new LinkedList<Item>();
			int num = in.nextInt();
			for(int i = 0; i < num; i++){
				int requestTime = in.nextInt();
				int neededTime = in.nextInt();
				Item item = new Item(requestTime, neededTime);
				list.add(item);
			}
			Collections.sort(list, new Comparator<Item>(){

				@Override
				public int compare(Item item0, Item item1) {
					if(item0.requestTime != item1.requestTime)
						return item0.requestTime- item1.requestTime;
					else
						return item0.neededTime - item1.neededTime;
				}
			});
			Item item = list.get(0);
			double totalTime = 0;
			int curTime = item.requestTime + item.neededTime;
			for(int i = 1; i < list.size(); i++){
				Item tmp = list.get(i);
				if(curTime < tmp.requestTime)
					curTime = tmp.requestTime + item.neededTime;
				totalTime += (curTime - tmp.requestTime);
				curTime += tmp.neededTime;
			}
			System.out.println(String.format("%.4f", totalTime / num));
		}
	}
	
	public static class Item{
		private int requestTime;
		private int neededTime;
		
		public Item(int requestTime, int neededTime){
			this.requestTime = requestTime;
			this.neededTime = neededTime;
		}
	}
}

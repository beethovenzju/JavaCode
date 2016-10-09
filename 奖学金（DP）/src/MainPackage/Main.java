package MainPackage;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			long n = in.nextLong();
			long r = in.nextLong();
			long avg = in.nextLong();
			long total = n * avg;
			long cur = 0;
			List<Test> list = new ArrayList<Test>((int)n);
			for(int i = 0; i < n; i++){
				long a = in.nextLong();
				long b = in.nextLong();
				list.add(new Test(a, b, i));
				cur += a;
			}
			Collections.sort(list);

			long minCost = 0;
			while(list.size() != 0 && cur < total){
				Test t = list.get(0);
				if(cur < total){
					if(cur + r - t.basic < total){
						minCost += ((r - t.basic) * t.cost);
						cur += (r- t.basic);
					}
					else{
						minCost += (total - cur) * t.cost;
						cur = total;
					}
				}
				list.remove(t);
			}
			System.out.println(minCost);
		}
	}
	
	public static class Test implements Comparable<Test>{
		private long basic;
		private long cost;
		private long index;
		
		public Test(long basic, long cost, long index) {
			this.basic = basic;
			this.cost = cost;
			this.index = index;
		}

		@Override
		public int compareTo(Test t) {
			// TODO Auto-generated method stub
			return (int)(this.cost - t.cost);
		}
	}
}

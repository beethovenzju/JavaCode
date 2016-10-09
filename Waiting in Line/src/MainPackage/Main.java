package MainPackage;

import java.util.*;

public class Main 
{
	private static final int MAX_TIME = 540;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n, m, k, q;
		int waitNum;
		int waittingIndex = 1;
		int count = 0;
		int[] finishTime;
		boolean[] isTimeOut;
		Map<Integer, Pair> map = new HashMap<Integer, Pair>();
		List<Queue<Pair>> queList = new ArrayList<Queue<Pair>>();
		
		n = in.nextInt();
		m = in.nextInt();
		k = in.nextInt();
		q = in.nextInt();
		waitNum = n * m;
		finishTime = new int[n]; //current queue's finishTime
		isTimeOut = new boolean[n]; //is the time is after 17:00
		for(int i = 0; i < n; i++)
		{
			finishTime[i] = 0;
			isTimeOut[i] = false;
		}
		
		for(int i = 0 ; i < n; i++)
		{
			Queue<Pair> que = new LinkedList<Pair>();
			queList.add(que);
		}
		
		for(int i = 1; i <= k; i++)
		{
			int time = in.nextInt();
			Pair pair = new Pair(i, time);
			map.put(i, pair);
			
			if(i <= waitNum)
			{
				int queIndex = (i - 1) % n;
				queList.get(queIndex).add(pair);
				waittingIndex++;
				pair.finishTime = finishTime[queIndex] + pair.handleTime;
				finishTime[queIndex] = pair.finishTime;
			}
		}
		
		while(count < k)
		{
			int minIndex = 0;
			int minTime = Integer.MAX_VALUE;
			boolean findOne = false;
			for(int i = 0; i < n; i++)
			{
				if(!queList.get(i).isEmpty() && !isTimeOut[i])
				{
					Pair pair = queList.get(i).peek();
					if(pair.finishTime < minTime)
					{
						minTime = pair.finishTime;
						minIndex = i;
						findOne = true;
					}
				}
			}
			
			if(!findOne)
				break;
			
			Pair last = queList.get(minIndex).poll();
			if((last.finishTime - last.handleTime) < MAX_TIME)
				last.isHandled = true;
			else
				isTimeOut[minIndex] = true;
			count++;
			
			if(waittingIndex <= k)
			{
				Pair pair = map.get(waittingIndex);
				queList.get(minIndex).add(pair);
				waittingIndex++;
				pair.finishTime = finishTime[minIndex] + pair.handleTime;
				finishTime[minIndex] = pair.finishTime;
			}
		}
		
		for(int i = 0 ; i < q; i++)
		{
			int tmp = in.nextInt();
			Pair pair = map.get(tmp);
			if(!pair.isHandled)
				System.out.println("Sorry");
			else
				System.out.println(pair.getFormatTime());
		}
	}
	
	public static class Pair
	{
		private int id;
		private int handleTime;
		private int finishTime;
		private boolean isHandled;
		
		public Pair(int id, int handleTime)
		{
			this.id = id;
			this.handleTime = handleTime;
			isHandled = false;
		}
		
		public String getFormatTime()
		{
			if(!isHandled)
				return "";
			
			else
			{
				String result;
				int hours = finishTime / 60;
				int mins = finishTime % 60;
				
				if(hours < 2)
					result = "0" + (8 + hours);
				else 
					result = "" + (8 + hours);
				
				if(mins < 10)
					result = result + ":0" + mins;
				else
					result = result + ":" + mins;
				
				return result;
			}
		}
	}
}

package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	private static final int START_TIME = 8 * 3600;
	private static final int END_TIME = 21 * 3600;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Customer> ordinarys = new LinkedList<Customer>();
		List<Customer> VIPs = new LinkedList<Customer>();
		List<Customer> result = new LinkedList<Customer>();
		Table[] tables;
		int playerNum;
		int tableNum;
		int VIPNum;
		int tmp;
		String arriveTime;
		int playTime;
		int isVIP;
		
		playerNum = in.nextInt();
		for(int i = 0; i < playerNum; i++)
		{
			arriveTime = in.next();
			playTime = in.nextInt();
			isVIP = in.nextInt();
			Customer customer = new Customer(arriveTime, playTime, isVIP);
			if(isVIP == 0)
				ordinarys.add(customer);
			else
				VIPs.add(customer);
		}
		Collections.sort(ordinarys);
		Collections.sort(VIPs);
		
		tableNum = in.nextInt();
		tables = new Table[tableNum + 1];
		VIPNum = in.nextInt();
		for(int i = 1; i <= tableNum; i++)
		{
			Table table = new Table(i);
			tables[i] = table;
		}
		for(int i = 0; i < VIPNum; i++)
		{
			tmp = in.nextInt();
			tables[tmp].isVIP = true;
		}
		
		while(true)
		{
			Customer ordinaryCus = null;
			Customer VIPCus = null;
			Customer current = null;
			if(ordinarys.size() != 0)
				ordinaryCus = ordinarys.get(0);
			if(VIPs.size() != 0)
				VIPCus = VIPs.get(0);
			
			if(ordinaryCus == null && VIPCus == null)
				break;
			else if(ordinaryCus != null && VIPCus != null)
				current = (ordinaryCus.arriveSecond > VIPCus.arriveSecond? VIPCus: ordinaryCus);
			else if(ordinaryCus != null)
				current = ordinaryCus;
			else
				current = VIPCus;

			int tableIndex = 0;
			int minTime = Integer.MAX_VALUE;
			for(int i = 1; i <= tableNum; i++)
			{
				if(tables[i].currentTime < minTime)
				{
					minTime = tables[i].currentTime;
					tableIndex = i;
				}
			}

			if(tables[tableIndex].currentTime >= END_TIME)
				break;

			if(tables[tableIndex].isVIP && VIPCus != null && VIPCus.arriveSecond <= tables[tableIndex].currentTime)
			{
				VIPCus.startSecond = tables[tableIndex].currentTime;
				tables[tableIndex].currentTime += VIPCus.playSecond;
				tables[tableIndex].servedNum++;
				result.add(VIPCus);
				VIPs.remove(VIPCus);
			}
			else
			{
				if(current.arriveSecond <= tables[tableIndex].currentTime)
				{
					current.startSecond = tables[tableIndex].currentTime;
					tables[tableIndex].currentTime += current.playSecond;
					tables[tableIndex].servedNum++;
					if(current.isVIP)
						VIPs.remove(current);
					else
						ordinarys.remove(current);
					result.add(current);
				}
				else
				{
					if(!current.isVIP)
					{
						int index = 1;
						for(int i = 1; i < tableNum + 1; i++)
						{
							if(current.arriveSecond >= tables[i].currentTime)
							{
								index = i;
								break;
							}
						}
	
						current.startSecond = current.arriveSecond;
						tables[index].currentTime = current.arriveSecond + current.playSecond;
						tables[index].servedNum++;
						ordinarys.remove(current);
						result.add(current);
					}
					else
					{
						int index = 1;
						boolean isFind = false;
						for(int i = 1; i < tableNum + 1; i++)
						{
							if(tables[i].isVIP && current.arriveSecond >= tables[i].currentTime)
							{
								index = i;
								isFind = true;
								break;
							}
						}
						if(!isFind)
						{
							for(int i = 1; i < tableNum + 1; i++)
							{
								if(current.arriveSecond >= tables[i].currentTime)
								{
									index = i;
									break;
								}
							}
						}
						
						current.startSecond = current.arriveSecond;
						tables[index].currentTime = current.arriveSecond + current.playSecond;
						tables[index].servedNum++;
						VIPs.remove(current);
						result.add(current);
					}
				}
			}
		}
		
		for(Customer c : result)
		{
			System.out.println(c.getArriveTime() + " " + c.getStartTime() + " " + c.getWaitMin());
		}
		for(int i = 1; i < tableNum + 1; i++)
		{
			if(i == 1)
				System.out.print(tables[i].servedNum);
			else
				System.out.print(" " + tables[i].servedNum);
		}
	}
	
	public static class Customer implements Comparable<Customer>
	{
		private int arriveSecond;
		private int playSecond;
		private int startSecond;
		private boolean isVIP;
		
		public Customer(String arrive, int play, int VIP)
		{
			String[] strs = arrive.split(":");
			if(strs != null && strs.length == 3)
				arriveSecond = Integer.parseInt(strs[0]) * 3600 + Integer.parseInt(strs[1]) * 60 + Integer.parseInt(strs[2]);
			
			if(play > 120)
				playSecond = 120 * 60;
			else
				playSecond = play * 60;
			
			if(VIP == 0)
				isVIP = false;
			else
				isVIP = true;
		}
		
		public int compareTo(Customer customer)
		{
			return (this.arriveSecond - customer.arriveSecond);
		}
		
		public String getArriveTime()
		{
			String result;
			int remainder = arriveSecond;
			int h = remainder / 3600;
			remainder -= h * 3600;
			int m = remainder / 60;
			remainder -= m * 60;
			int s = remainder;
			
			if(h < 12)
				result = "0" + h + ":";
			else
				result = "" + h + ":";
			
			if(m < 10)
				result = result + "0" + m + ":";
			else
				result = result + m + ":";
			
			if(s < 10)
				result = result + "0" + s;
			else
				result = result + s;
				
			return result;
		}
		
		public String getStartTime()
		{
			String result;
			int remainder = startSecond;
			int h = remainder / 3600;
			remainder -= h * 3600;
			int m = remainder / 60;
			remainder -= m * 60;
			int s = remainder;
			
			if(h < 12)
				result = "0" + h + ":";
			else
				result = "" + h + ":";
			
			if(m < 10)
				result = result + "0" + m + ":";
			else
				result = result + m + ":";
			
			if(s < 10)
				result = result + "0" + s;
			else
				result = result + s;
				
			return result;
		}
		
		public int getWaitMin()
		{
			int result;
			int pow;
			int tmp = startSecond - arriveSecond;
			int remainder = tmp % 60;
			if(remainder < 30)
				pow = 0;
			else
				pow = 1;
			result = tmp / 60;
			return result + pow;
		}
	}
	
	public static class Table
	{
		private int index;
		private boolean isVIP;
		private int servedNum;
		private int currentTime;
		
		public Table(int index)
		{
			this.index = index;
			isVIP = false;
			servedNum = 0;
			currentTime = START_TIME;
		}
	}
}

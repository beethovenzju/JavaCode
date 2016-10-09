package MainPackage;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main 
{
	private static final int START_TIME_OF_BANK = 8 * 3600;
	private static final int END_TIME_OF_BANK = 17 * 3600;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Customer> customers = new LinkedList<Customer>();
		ListIterator<Customer> iterator;
		Customer[] serviceWindows;
		int windows;
		int count = 0;
		int num = 0;
		int handle;
		int totalWaitTime = 0;
		String str;
		
		count = in.nextInt();
		windows = in.nextInt();
		serviceWindows = new Customer[windows];
		for(int i = 0; i < count; i++)
		{
			str = in.next();
			handle = in.nextInt();
			Customer customer = new Customer(str, handle);
			customers.add(customer);
		}
		
		Collections.sort(customers);
		iterator = customers.listIterator();
		
		if(customers.size() > windows)
		{
			for(int i = 0; i < windows; i++)
			{
				serviceWindows[i] = iterator.next();
				
				if(serviceWindows[i].arriveTime > END_TIME_OF_BANK)
					break;
				
				if(serviceWindows[i].arriveTime < START_TIME_OF_BANK)
					serviceWindows[i].startTime = START_TIME_OF_BANK;
				else 
					serviceWindows[i].startTime = serviceWindows[i].arriveTime;
				
				totalWaitTime += serviceWindows[i].handle();
				num++;
			}
			while(iterator.hasNext())
			{
				int startTime = Integer.MAX_VALUE;
				int index = 0;
				Customer c = iterator.next();
				
				if(c.arriveTime > END_TIME_OF_BANK)
					break;
				
				for(int i = 0; i < windows; i++)
				{
					if(serviceWindows[i].endTime < startTime)
					{
						startTime = serviceWindows[i].endTime;
						index = i;
					}
				}
				
				serviceWindows[index] = c;
				
				if(c.arriveTime < startTime)
					serviceWindows[index].startTime = startTime;
				else
					serviceWindows[index].startTime = serviceWindows[index].arriveTime;
				
				totalWaitTime += serviceWindows[index].handle();
				num++;
			}
		}
		else
		{
			while(iterator.hasNext())
			{
				Customer c = iterator.next();
				
				if(c.arriveTime > END_TIME_OF_BANK)
					break;
				
				if(c.arriveTime < START_TIME_OF_BANK)
					c.startTime = START_TIME_OF_BANK;
				else 
					c.startTime = c.arriveTime;
				
				totalWaitTime += c.handle();
				num++;
			}
		}
		
		BigDecimal big = BigDecimal.valueOf(totalWaitTime / 60.00 / num);
		System.out.print(big.setScale(1, BigDecimal.ROUND_HALF_UP));
	}
	
	public static class Customer implements Comparable<Customer>
	{
		private int arriveTime;
		private int startTime;
		private int handleTime;
		private int endTime;
		
		public Customer(String str, int handleTime)
		{
			arriveTime = getTime(str);
			this.handleTime = handleTime * 60;
		}
		
		public int compareTo(Customer cus)
		{
			return this.arriveTime - cus.arriveTime;
		}
		
		public int handle()
		{
			endTime = startTime + handleTime;
			return startTime - arriveTime;
		}
	}
	
	public static int getTime(String str)
	{
		String[] strs = str.split(":");
		int result = 0;
		
		if(strs != null && strs.length == 3)
		{
			if(strs[0].charAt(0) == '0')
				result += (strs[0].charAt(1) - '0') * 3600;
			else 
				result += Integer.parseInt(strs[0]) * 3600;
			
			if(strs[1].charAt(0) == '0')
				result += (strs[1].charAt(1) - '0') * 60;
			else 
				result += Integer.parseInt(strs[1]) * 60;
			
			if(strs[2].charAt(0) == '0')
				result += strs[2].charAt(1) - '0';
			else 
				result += Integer.parseInt(strs[2]);
		}
		return result;
	}
}

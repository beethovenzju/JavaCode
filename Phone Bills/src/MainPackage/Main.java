package MainPackage;

import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int dayCost = 0;
		int tmpCost;
		Map<Integer, Integer> tolls = new HashMap<Integer, Integer>();
		Map<String, Customer> customers = new TreeMap<String, Customer>();
		int recordsNum;
		String name;
		String recordStr;
		String statusStr;
		
		for(int i = 0; i < 24; i++)
		{
			tmpCost = in.nextInt();
			dayCost += tmpCost * 60;
			tolls.put(i, tmpCost);
		}
		
		recordsNum = in.nextInt();
		
		for(int i = 0; i < recordsNum; i++)
		{
			name = in.next();
			recordStr = in.next();
			statusStr = in.next();
			
			Record record = new Record(recordStr, statusStr);
			
			if(customers.containsKey(name))
				customers.get(name).addItem(record);
			else
			{
				Customer c = new Customer();
				c.addItem(record);
				customers.put(name, c);
			}
		}
		
		for(Map.Entry<String, Customer> entry : customers.entrySet())
		{
			int cost = 0;
			name = entry.getKey();
			Customer customer = entry.getValue();
			List<Record> list = customer.calculate();
			
			if(list.size() == 0)
				continue;
			
			System.out.println(name + " " + customer.records.getFirst().mon);
			for(int i = 0; i < list.size(); i += 2)
			{
				int thisCost = 0;
				Record inRecord = list.get(i);
				Record outRecord = list.get(i + 1);
				int cost1 = 0;
				int cost2 = 0;
				
				int s = outRecord.day * 24 * 60 + outRecord.hour * 60 + outRecord.min - (inRecord.day * 24 * 60 + inRecord.hour * 60 + inRecord.min);
				
				cost1 += inRecord.day * dayCost;
				for(int j = 0; j < inRecord.hour; j++)
					cost1 += tolls.get(j) * 60;
				cost1 += tolls.get(inRecord.hour) * inRecord.min;
				
				cost2 += outRecord.day * dayCost;
				for(int j = 0; j < outRecord.hour; j++)
					cost2 += tolls.get(j) * 60;
				cost2 += tolls.get(outRecord.hour) * outRecord.min;
				thisCost = cost2 - cost1;

				cost += thisCost;
				BigDecimal bigCost = BigDecimal.valueOf(thisCost / 100.00);
				System.out.println(inRecord.getFormat() + " " + outRecord.getFormat() + " " + s + " $" + bigCost.setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			
			BigDecimal bigCost = BigDecimal.valueOf(cost / 100.00);
			System.out.println("Total amount: $" + bigCost.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}
	
	public static class Customer
	{
		private LinkedList<Record> records;
		
		public Customer()
		{
			records = new LinkedList<Record>();
		}
		
		public void addItem(Record record)
		{
			ListIterator<Record> listIterator = records.listIterator();
			Record tmp;
			
			while(listIterator.hasNext())
			{
				tmp = listIterator.next();
				if(record.compareTo(tmp) < 0)
				{
					listIterator.previous();
					listIterator.add(record);
					return;
				}
			}
			
			listIterator.add(record);
		}
		
		public List<Record> calculate()
		{
			List<Record> result = new ArrayList<Record>();
			
			ListIterator<Record> listIterator = records.listIterator();
			Record current, prev = null;
			
			while(listIterator.hasNext())
			{
				current = listIterator.next();
				if(prev != null && !current.isOn && prev.isOn)
				{
					result.add(prev);
					result.add(current);
				}
				prev = current;
			}
			
			return result;
		}
	}
	
	public static class Record implements Comparable<Record>
	{
		private String mon;
		private int day;
		private int hour;
		private int min;
		private boolean isOn;
		
		public Record(String str, String status)
		{
			String[] strs = str.split(":");
			if(strs != null && strs.length == 4)
			{
				mon = strs[0];
				
				if(strs[1].charAt(0) == '0')
					day = strs[1].charAt(1) - '0';
				else
					day = Integer.parseInt(strs[1]);
				
				if(strs[2].charAt(0) == '0')
					hour = strs[2].charAt(1) - '0';
				else
					hour = Integer.parseInt(strs[2]);
				
				if(strs[3].charAt(0) == '0')
					min = strs[3].charAt(1) - '0';
				else
					min = Integer.parseInt(strs[3]);
			}
			
			if("on-line".equals(status))
				isOn = true;
			else if("off-line".equals(status))
				isOn = false;
		}

		public int compareTo(Record arg) 
		{
			if(this.day != arg.day)
				return this.day - arg.day;
			else if(this.hour != arg.hour)
				return this.hour - arg.hour;
			else if(this.min != arg.min)
				return this.min - arg.min;
								
			return 0;
		}
		
		public String getFormat()
		{
			String result;
			
			if(day < 10)
				result = "0" + day + ":";
			else 
				result = day + ":";
			
			if(hour < 10)
				result = result + "0" + hour + ":";
			else
				result = result + hour + ":";
			
			if(min < 10)
				result = result + "0" + min;
			else
				result = result + min;
			
			return result;
		}
	}
}

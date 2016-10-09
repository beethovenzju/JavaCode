package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Map<String, List<Book>>> mapList = new ArrayList<Map<String, List<Book>>>();
		Map<String, List<Book>> titleMap = new HashMap<String, List<Book>>();
		mapList.add(titleMap);
		Map<String, List<Book>> authorMap = new HashMap<String, List<Book>>();
		mapList.add(authorMap);
		Map<String, List<Book>> keyWordMap = new HashMap<String, List<Book>>();
		mapList.add(keyWordMap);
		Map<String, List<Book>> publisherMap = new HashMap<String, List<Book>>();
		mapList.add(publisherMap);
		Map<String, List<Book>> yearMap = new HashMap<String, List<Book>>();
		mapList.add(yearMap);
		List<Book> list;
		List<String> queryList = new LinkedList<String>();
		int bookNum;
		int queryNum;
		int id;
		String title;
		String author;
		String keyWord;
		String[] keyWords;
		String publisher;
		String year;
		
		bookNum = Integer.parseInt(in.nextLine());
		for(int i = 0; i < bookNum; i++)
		{
			id = Integer.parseInt(in.nextLine());
			title = in.nextLine();
			author = in.nextLine();
			keyWord = in.nextLine();
			keyWords = keyWord.split(" ");
			publisher = in.nextLine();
			year = in.nextLine();
			Book book = new Book(id);
			
			if(titleMap.containsKey(title))
			{
				list = titleMap.get(title);
				list.add(book);
			}
			else
			{
				list = new LinkedList<Book>();
				list.add(book);
				titleMap.put(title, list);
			}
			
			if(authorMap.containsKey(author))
			{
				list = authorMap.get(author);
				list.add(book);
			}
			else
			{
				list = new LinkedList<Book>();
				list.add(book);
				authorMap.put(author, list);
			}
			
			for(int j = 0; j < keyWords.length; j++)
			{
				if(keyWordMap.containsKey(keyWords[j]))
				{
					list = keyWordMap.get(keyWords[j]);
					list.add(book);
				}
				else
				{
					list = new LinkedList<Book>();
					list.add(book);
					keyWordMap.put(keyWords[j], list);
				}
			}
			
			if(publisherMap.containsKey(publisher))
			{
				list = publisherMap.get(publisher);
				list.add(book);
			}
			else
			{
				list = new LinkedList<Book>();
				list.add(book);
				publisherMap.put(publisher, list);
			}
			
			if(yearMap.containsKey(year))
			{
				list = yearMap.get(year);
				list.add(book);
			}
			else
			{
				list = new LinkedList<Book>();
				list.add(book);
				yearMap.put(year, list);
			}
		}
		
		queryNum = Integer.parseInt(in.nextLine());
		for(int i = 0; i < queryNum; i++)
		{
			String str = in.nextLine();
			queryList.add(str);
		}
		
		Iterator<String> iterator = queryList.iterator();
		while(iterator.hasNext())
		{
			String str = iterator.next();
			System.out.println(str);
			String[] strs = str.split(":");
			int index = Integer.parseInt(strs[0]);
			String value = strs[1].substring(1, strs[1].length());
			list = mapList.get(index - 1).get(value);
			if(list == null || list.size() == 0)
				System.out.println("Not Found");
			else
			{
				Collections.sort(list);
				
				for(Book book : list)
					System.out.println(book.id);
			}
		}
	}
	
	public static class Book implements Comparable<Book>
	{
		private int id;
		
		public Book(int id)
		{
			this.id = id;
		}
		
		public int compareTo(Book arg)
		{
			return this.id - arg.id;
		}
	}
}

package MainPackage;

import java.util.*;
import java.io.*;
import java.math.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Place> places = new LinkedList<Place>();
		List<Student> allStudents = new LinkedList<Student>();
		int placeNum;
		int tmpNum;
		int score;
		BigInteger big;
		
		placeNum = in.nextInt();
		for(int i = 0; i < placeNum; i++)
		{
			Place place = new Place(places.size() + 1);
			tmpNum = in.nextInt();
			for(int j = 0; j < tmpNum; j++)
			{
				big = in.nextBigInteger();
				score = in.nextInt();
				Student student = new Student(big, score, place.index);
				place.list.add(student);
				allStudents.add(student);
			}
			Collections.sort(place.list);
			places.add(place);
		}
		
		for(Place place : places)
		{
			int sameScoreNum = 0;
			Student last = null;
			Collections.sort(place.list);
			for(Student student : place.list)
			{
				if(last == null)
				{
					sameScoreNum = 1;
					student.localRank = 1;
					last = student;
				}
				else
				{
					if(student.score != last.score)
					{
						student.localRank = last.localRank + sameScoreNum;
						sameScoreNum = 1;
						last = student;
					}
					else
					{
						sameScoreNum++;
						student.localRank = last.localRank;
						last = student;
					}
				}
			}
		}
		
		Collections.sort(allStudents);
		System.out.println(allStudents.size());
		int sameScoreNum = 0;
		Student last = null;
		for(Student student : allStudents)
		{
			if(last == null)
			{
				sameScoreNum = 1;
				student.totalRank = 1;
				last = student;
			}
			else
			{
				if(student.score != last.score)
				{
					student.totalRank = last.totalRank + sameScoreNum;
					sameScoreNum = 1;
					last = student;
				}
				else
				{
					sameScoreNum++;
					student.totalRank = last.totalRank;
					last = student;
				}
			}
			System.out.println(student.id + " " + student.totalRank + " " + student.localNum + " " + student.localRank);
		}
	}
	
	public static class Student implements Comparable<Student>
	{
		private BigInteger id;
		private int score;
		private int totalRank;
		private int localRank;
		private int localNum;
		
		public Student(BigInteger id, int score, int localNum)
		{
			this.id = id;
			this.score = score;
			this.totalRank = 0;
			this.localRank = 0;
			this.localNum = localNum;
		}
		
		public int compareTo(Student stu)
		{
			if(this.score != stu.score)
				return stu.score - this.score;
			else
				return this.id.compareTo(stu.id);
		}
	}
	
	public static class Place
	{
		private int index;
		private List<Student> list;
		
		public Place(int index)
		{
			this.index = index;
			this.list = new LinkedList<Student>();
		}
	}
}

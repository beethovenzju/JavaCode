package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Student> list = new LinkedList<Student>();
		int num;
		int queryType;
		String id;
		String name;
		int grade;
		
		num = in.nextInt();
		queryType = in.nextInt();
		if(num == 0)
			return;
		
		for(int i = 0; i < num; i++)
		{
			id = in.next();
			name = in.next();
			grade = in.nextInt();
			Student student = new Student(id, name, grade);
			list.add(student);
		}
		
		switch(queryType)
		{
		case 1:
			Collections.sort(list, new Comparator<Student>()
			{
				@Override
				public int compare(Student stu0, Student stu1)
				{
					return stu0.id.compareTo(stu1.id);
				}
			});
			break;
		case 2:
			Collections.sort(list, new Comparator<Student>()
					{
						@Override
						public int compare(Student stu0, Student stu1)
						{
							if(!stu0.name.equals(stu1.name))
								return stu0.name.compareToIgnoreCase(stu1.name);
							else
								return stu0.id.compareTo(stu1.id);
						}
					});
			break;
		case 3:
			Collections.sort(list, new Comparator<Student>()
					{
						@Override
						public int compare(Student stu0, Student stu1)
						{
							if(stu0.score != stu1.score)
								return stu0.score - stu1.score;
							else
								return stu0.id.compareTo(stu1.id);
						}
					});
			break;
		default:
			break;
		}
		
		for(Student student : list)
		{
			System.out.println(student.id + " " + student.name + " " + student.score);
		}
	}
	
	public static class Student
	{
		private String id;
		private String name;
		private int score;
		
		public Student(String id, String name, int score)
		{
			this.id = id;
			this.name = name;
			this.score = score;
		}
	}
}

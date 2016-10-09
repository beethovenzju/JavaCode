package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		boolean isFound = true;
		List<Student> maleList = new LinkedList<Student>();
		List<Student> femaleList = new LinkedList<Student>();
		int count;
		String name;
		String gender;
		String id;
		int grade;
		int femaleHighest = 0;
		int maleLowest = 0;
		
		count = in.nextInt();
		for(int i= 0; i < count; i++){
			name = in.next();
			gender = in.next();
			id = in.next();
			grade = in.nextInt();
			Student student = new Student(name, gender, id, grade);
			if("M".equals(gender))
				maleList.add(student);
			else if("F".equals(gender))
				femaleList.add(student);
		}
		
		Collections.sort(maleList, new Comparator<Student>(){
			@Override
			public int compare(Student arg0, Student arg1){
				return arg0.grade - arg1.grade;
			}
		});
		Collections.sort(femaleList, new Comparator<Student>(){
			@Override
			public int compare(Student arg0, Student arg1){
				return arg1.grade - arg0.grade;
			}
		});
		
		if(femaleList.size() == 0){
			isFound = false;
			System.out.println("Absent");
		}
		else{
			System.out.println(femaleList.get(0).name + " " + femaleList.get(0).id);
			femaleHighest = femaleList.get(0).grade;
		}
		
		if(maleList.size() == 0){
			isFound = false;
			System.out.println("Absent");
		}
		else{
			System.out.println(maleList.get(0).name + " " + maleList.get(0).id);
			maleLowest = maleList.get(0).grade;
		}
		
		if(isFound)
			System.out.println(femaleHighest - maleLowest);
		else
			System.out.println("NA");
	}
	
	public static class Student{
		private String name;
		private String gender;
		private String id;
		private int grade;
		
		public Student(String name, String gender, String id, int grade){
			this.name = name;
			this.gender = gender;
			this.id = id;
			this.grade = grade;
		}
	}
}

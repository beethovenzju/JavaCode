package MainPackage;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		Map<String, Student> map = new HashMap<String, Student>();
		int studentNum = 0;
		int courseNum = 0;
		int index;
		int num;
		String name;
		
		studentNum = in.nextInt();
		courseNum = in.nextInt();
		for(int i = 1; i <= courseNum; i++){
			index = in.nextInt();
			num = in.nextInt();
			for(int j = 0; j < num; j++){
				name = in.next();
				if(map.containsKey(name))
					map.get(name).list.add(index);
				else{
					Student stu = new Student();
					stu.list.add(index);
					map.put(name, stu);
				}
			}
		}
		
		for(int i = 0; i < studentNum; i++){
			StringBuilder builder = new StringBuilder();
			name = in.next();
			Student stu = map.get(name);
			builder.append(name);
			
			if(stu == null)
				builder.append(" " + 0);
			else{
				builder.append(" " + stu.list.size());
				Collections.sort(stu.list);
				for(int a : stu.list)
					builder.append(" " + a);
			}
			
			System.out.println(builder);
		}
	}
	
	public static class Student{
		private List<Integer> list;
		
		public Student(){
			list = new LinkedList<Integer>();
		}
	}
}

package MainPackage;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int col = in.nextInt();
			int row = in.nextInt();
			int[][] arrs = new int[row][col];
			int num = 0;
			for(int i = 0; i < row; i++){
				for(int j = 0; j < col; j++){
					if(i % 4 == 0 || i % 4 == 1){
						if(j % 4 == 0 || j % 4 == 1)
							num++;
					}
					else{
						if(j % 4 == 2 || j % 4 == 3)
							num++;
					}
				}
			}
			System.out.println(num);
		}
	}
}

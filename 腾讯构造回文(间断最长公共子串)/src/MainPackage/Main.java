package MainPackage;

import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String org = in.next();
			String inv = new StringBuilder(org).reverse().toString();
			System.out.println(org.length() - getLCS(org, inv));
		}
	}
	
	private static int getLCS(String org, String inv){
		int row = inv.length();
		int col = org.length();
		int[][] arrs = new int[row + 1][col + 1];
		for(int i = 1; i <= row; i++){
			for(int j = 1; j <= col; j++){
				if(inv.charAt(i - 1) == org.charAt(j - 1))
					arrs[i][j] = arrs[i - 1][j - 1] + 1;
				else
					arrs[i][j] = Math.max(arrs[i - 1][j - 1], Math.max(arrs[i - 1][j], arrs[i][j - 1]));
			}
		}
		return arrs[row][col];
	}
}

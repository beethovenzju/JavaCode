package MainPackage;

import java.util.*;

public class Main {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num = in.nextInt();
			int[] arrs = new int[num];
			for(int i = 0; i < num; i++)
				arrs[i] = in.nextInt();
			System.out.println(getColorNum(arrs));
		}
		in.close();
	}
	
	public static int getColorNum(int[] arrs){
		int num = 0;
		int matrixArr[][] = getMatrix(arrs);
		
		for(int i = 0; i < 32; i++){
			int rowIndex;
			for(rowIndex = num; rowIndex < arrs.length; rowIndex++){
				if(matrixArr[rowIndex][i] != 0)
					break;
			}
			
			if(rowIndex == arrs.length)
				continue;
			
			matrixArr = changeLine(matrixArr, num, rowIndex);
			
			for(int j = rowIndex + 1; j < arrs.length; j++){
				if(matrixArr[j][i] != 0){
					for(int k = i; k < 32; k++){
						matrixArr[j][k] ^= matrixArr[num][k];
					}
				}
			}
			num++;
		}
		
		return num;
	}
	
	public static int[][] getMatrix(int[] arrs){
		int matrixArr[][] = new int[arrs.length][32];
		for(int i = 0; i < arrs.length; i++){
			int tmp = arrs[i];
			for(int j = 31; j >= 0 && tmp != 0; j--){
				matrixArr[i][j] = (tmp & 1);
				tmp >>= 1;
			}
		}
		
		return matrixArr;
	}
	
	public static int[][] changeLine(int[][] arr, int i, int j){
		for(int k = 0; k < 32; k++){
			int tmp = arr[i][k];
			arr[i][k] = arr[j][k];
			arr[j][k] = tmp;
		}
		return arr;
	}
}

package MainPackage;
import java.util.*;

public class Main {

	/*
	 * ��һ��int����arr����ֻ����1��2��3���ֱ��������Բ��Ŀǰ��״̬��1����������2����������3����������arr[i]��ֵ�����i+1��Բ�̵�λ�á�
	 * ���磬arr=[3,3,2,1]�������1��Բ���������ϡ���2��Բ���������ϡ���3��Բ���������ϡ���4��Բ���������ϡ����arr�����״̬�������ƶ���
	 * �������г��ֵ�״̬������arr����״̬�������ƶ��켣�еĵڼ���״̬�����arr�����״̬���������ƶ��켣�����г��ֵ�״̬���򷵻�-1��
	 * ����һ��int����arr������Ĵ�Сn�����������������뷵��һ��int����������Ľ����
	 */
	private int[] cur;
	
	public int chkStep(int[] arr, int n) {
        // write code here
		cur = new int[n];
    }
	
	private int move(int count, int from, int to, int[] arr){
		if(count <= 0)
			return -1;
		
		move(count - 1, from, 3 - from - to, arr);
		cur[count] = to;
		move(count - 1, 3 - from - to, to, arr);
	}
}

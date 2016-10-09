package Package;
import java.util.*;

public class Main {

	/*
	 * ���ڴ�ͳ�ĺ�ŵ����Ϸ������һ����չ�������дӴ�С���õ�n��Բ�̣���ʼʱ����Բ�̶�������ߵ������ϣ����պ�ŵ����Ϸ��Ҫ������Ҫ�����е�Բ�̶��Ƶ��ұߵ������ϣ�
	 * ��ʵ��һ��������ӡ�����ƶ��켣������һ��int n����ʾ��n��Բ�̡��뷵��һ��string���飬���е�Ԫ������Ϊÿ���ƶ���������������ʽΪ��
	 *  move from [left/mid/right] to [left/mid/right]��
	 */
	private String[] name = {"left", "mid", "right"};
	public ArrayList<String> getSolution(int n) {
        // write code here
		ArrayList<String> list = new ArrayList<String>();
		move(n, 0, 2, list);
		return list;
    }
	
	private void move(int count, int from, int to, ArrayList<String> list){
		if(count <= 0)
			return;
		
		move(count - 1, from, 3 - from - to, list);
		list.add("move from " + name[from] + " to " + name[to]);
		move(count - 1, 3 - from - to, to, list);
	}
}

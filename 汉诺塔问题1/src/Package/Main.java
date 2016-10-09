package Package;
import java.util.*;

public class Main {

	/*
	 * 对于传统的汉诺塔游戏我们做一个拓展，我们有从大到小放置的n个圆盘，开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，
	 * 请实现一个函数打印最优移动轨迹。给定一个int n，表示有n个圆盘。请返回一个string数组，其中的元素依次为每次移动的描述。描述格式为：
	 *  move from [left/mid/right] to [left/mid/right]。
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

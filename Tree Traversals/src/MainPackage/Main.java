package MainPackage;

import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		int count;
		int[] postArrays;
		int[] inArrays;
		BinaryTree root;
		BinaryTree cur;
		Queue<BinaryTree> que = new LinkedList<BinaryTree>();
		
		count = in.nextInt();
		postArrays = new int[count];
		inArrays = new int[count];
		
		for(int i = 0; i < count; i++)
			postArrays[i] = in.nextInt();
		
		for(int i = 0; i < count; i++)
			inArrays[i] = in.nextInt();
		
		root = Main.BuildTree(postArrays, inArrays, 0, postArrays.length - 1, 0, inArrays.length - 1);

		que.add(root);
		while(que.size() != 0)
		{
			cur = que.poll();
			if(cur == root)
				System.out.print(cur.value);
			else
				System.out.print(" " + cur.value);
			
			if(cur.left != null)
				que.add(cur.left);
			
			if(cur.right != null)
				que.add(cur.right);
		}
	}
	
	public static class BinaryTree
	{
		private int value;
		private BinaryTree left;
		private BinaryTree right;
		
		public BinaryTree(int value)
		{
			this.value = value;
		}
	}
	
	public static BinaryTree BuildTree(int[] post, int[] in, int ps, int pe, int ins, int ine)
	{
		if(pe < ps)
			return null;
		BinaryTree root = new BinaryTree(post[pe]);
		int mid = ins;
		while(in[mid] != post[pe])
			mid++;
		
		int leftNum = mid - ins;
		
		root.left = BuildTree(post, in, ps, ps + leftNum - 1, ins, mid - 1);
		root.right = BuildTree(post, in, ps + leftNum, pe - 1, mid + 1, ine);
		return root;
	}
	
	public static void GetLeverOrder(Queue<Integer> que, BinaryTree root)
	{
		if(root.left == null && root.right == null)
			return;
		else
		{
			if(root.left != null)
				que.add(root.left.value);
			if(root.right != null)
				que.add(root.right.value);
		}
	}
}

package MainPackage;

import java.util.*;

public class Main 
{
	private static final int AVERAGE_TYPE = 0;
	private static final int C_LANGUE_TYPE = 1;
	private static final int MATHEM_TYPE = 2;
	private static final int ENGLISH_TYPE = 3;
	
	private static final int CUTOFF = 20;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		Map<String, Score> map = new HashMap<String, Score>();
		List<Score> scoreList = new ArrayList<Score>();
		List<String> checkList = new ArrayList<String>();
		int studentsCount = 0;
		int checkCount = 0;
		String id;
		Score currentScore;
		Score lastScore;
		
		studentsCount = in.nextInt();
		checkCount = in.nextInt();
		
		for(int i = 0; i < studentsCount; i++)
		{
			id = in.next();
			Score score = new Score(id);
			score.CLang = in.nextInt();
			score.mathem = in.nextInt();
			score.english = in.nextInt();
			score.getAverage();
			
			map.put(id, score);
			scoreList.add(score);
		}
		
		quicksort(scoreList, 0, scoreList.size() - 1, AVERAGE_TYPE);
		
		currentScore = scoreList.get(scoreList.size() - 1);
		currentScore.averageRank = 1;
		currentScore.bestRank = 1;
		currentScore.bestName = "A";
		for(int i = scoreList.size() - 2; i >= 0; i--)
		{
			currentScore = scoreList.get(i);
			lastScore = scoreList.get(i + 1);
			if(currentScore.average < lastScore.average)
				currentScore.averageRank = scoreList.size() - i;
			else
				currentScore.averageRank = lastScore.averageRank;
			
			currentScore.bestRank = currentScore.averageRank;
			currentScore.bestName = "A";
		}
		
		quicksort(scoreList, 0, scoreList.size() - 1, C_LANGUE_TYPE);
		
		currentScore = scoreList.get(scoreList.size() - 1);
		currentScore.CLangRank = 1;
		if(currentScore.bestRank != 1)
		{
			currentScore.bestRank = 1;
			currentScore.bestName = "C";
		}
		for(int i = scoreList.size() - 2; i >= 0; i--)
		{
			currentScore = scoreList.get(i);
			lastScore = scoreList.get(i + 1);
			if(currentScore.CLang < lastScore.CLang)
				currentScore.CLangRank = scoreList.size() - i;
			else
				currentScore.CLangRank = lastScore.CLangRank;
			
			if(currentScore.CLangRank < currentScore.bestRank)
			{
				currentScore.bestRank = currentScore.CLangRank;
				currentScore.bestName = "C";
			}
		}
		
		quicksort(scoreList, 0, scoreList.size() - 1, MATHEM_TYPE);
			
		currentScore = scoreList.get(scoreList.size() - 1);
		currentScore.mathemRank = 1;
		if(currentScore.bestRank != 1)
		{
			currentScore.bestRank = 1;
			currentScore.bestName = "M";
		}
		for(int i = scoreList.size() - 2; i >= 0; i--)
		{
			currentScore = scoreList.get(i);
			lastScore = scoreList.get(i + 1);
			if(currentScore.mathem < lastScore.mathem)
				currentScore.mathemRank = scoreList.size() - i;
			else
				currentScore.mathemRank = lastScore.mathemRank;
			
			if(currentScore.mathemRank < currentScore.bestRank)
			{
				currentScore.bestRank = currentScore.mathemRank;
				currentScore.bestName = "M";
			}
		}
		
		quicksort(scoreList, 0, scoreList.size() - 1, ENGLISH_TYPE);
			
		currentScore = scoreList.get(scoreList.size() - 1);
		currentScore.englishRank = 1;
		if(currentScore.bestRank != 1)
		{
			currentScore.bestRank = 1;
			currentScore.bestName = "E";
		}
		for(int i = scoreList.size() - 2; i >= 0; i--)
		{
			currentScore = scoreList.get(i);
			lastScore = scoreList.get(i + 1);
			if(currentScore.english < lastScore.english)
				currentScore.englishRank = scoreList.size() - i;
			else
				currentScore.englishRank = lastScore.englishRank;
			
			if(currentScore.englishRank < currentScore.bestRank)
			{
				currentScore.bestRank = currentScore.englishRank;
				currentScore.bestName = "E";
			}
		}
		
		for(int i = 0; i < checkCount; i++)
		{
			id = in.next();
			checkList.add(id);
		}
		
		for(int i = 0; i < checkList.size(); i++)
		{
			Score score = map.get(checkList.get(i));
			if(score == null)
				System.out.println("N/A");
			else
				System.out.println(score.bestRank + " " + score.bestName);
		}
	}
	
	private static class Score
	{
		private String id;
		
		private int CLang;
		private int mathem;
		private int english;
		private int average;
		
		private int CLangRank;
		private int mathemRank;
		private int englishRank;
		private int averageRank;
		
		private int bestRank;
		private String bestName;
		
		public Score(String myId)
		{
			id = myId;
			CLang = 0;
			mathem = 0;
			english = 0;
			average = 0;
			
			CLangRank = 1;
			mathemRank = 1;
			englishRank = 1;
			averageRank = 1;
		}
		
		public void getAverage()
		{
			this.average = (CLang + mathem + english) / 3;
		}
	}
	
	public static Score median3(List<Score> a, int left, int right, int type)
	{
		if(left < 0 || left >= a.size() || right < 0 || right >= a.size())
			return null;
		
		int center = (left + right) / 2;
		
		if(type == AVERAGE_TYPE)
		{
			if(a.get(left).average > a.get(center).average)
				swapReferences(a, left, center);
			if(a.get(left).average > a.get(right).average)
				swapReferences(a, left, right);
			if(a.get(center).average > a.get(right).average)
				swapReferences(a, center, right);
		}
		else if(type == C_LANGUE_TYPE)
		{
			if(a.get(left).CLang > a.get(center).CLang)
				swapReferences(a, left, center);
			if(a.get(left).CLang > a.get(right).CLang)
				swapReferences(a, left, right);
			if(a.get(center).CLang > a.get(right).CLang)
				swapReferences(a, center, right);
		}
		else if(type == MATHEM_TYPE)
		{
			if(a.get(left).mathem > a.get(center).mathem)
				swapReferences(a, left, center);
			if(a.get(left).mathem > a.get(right).mathem)
				swapReferences(a, left, right);
			if(a.get(center).mathem > a.get(right).mathem)
				swapReferences(a, center, right);
		}
		else if(type == ENGLISH_TYPE)
		{
			if(a.get(left).english > a.get(center).english)
				swapReferences(a, left, center);
			if(a.get(left).english > a.get(right).english)
				swapReferences(a, left, right);
			if(a.get(center).english > a.get(right).english)
				swapReferences(a, center, right);
		}
		else 
			return null;
		
		swapReferences(a, center, right - 1);
		return a.get(right - 1);
	}
	
	public static void quicksort(List<Score> a, int left, int right, int type)
	{
		if(left + CUTOFF <= right)
		{
			Score pivot = median3(a, left, right, type);
			
			int i = left, j = right - 1;
			for(;;)
			{
				if(type == AVERAGE_TYPE)
				{
					while(a.get(++i).average < pivot.average);
					while(a.get(--j).average > pivot.average);
					
					if(i < j)
						swapReferences(a, i, j);
					else 
						break;
				}
				else if(type == C_LANGUE_TYPE)
				{
					while(a.get(++i).CLang < pivot.CLang);
					while(a.get(--j).CLang > pivot.CLang);
					
					if(i < j)
						swapReferences(a, i, j);
					else 
						break;
				}
				else if(type == MATHEM_TYPE)
				{
					while(a.get(++i).mathem < pivot.mathem);
					while(a.get(--j).mathem > pivot.mathem);
					
					if(i < j)
						swapReferences(a, i, j);
					else 
						break;
				}
				else if(type == ENGLISH_TYPE)
				{
					while(a.get(++i).english < pivot.english);
					while(a.get(--j).english > pivot.english);
					
					if(i < j)
						swapReferences(a, i, j);
					else 
						break;
				}
			}
			
			swapReferences(a, i, right - 1);
			
			quicksort(a, left, i - 1, type);
			quicksort(a, i + 1, right, type);
		}
		else
			insertionSort(a, left, right, type);
	}
	
	public static void swapReferences(List<Score> a, int left, int right)
	{
		if(left < 0 || left >= a.size() || right < 0 || right >= a.size())
			return;
		
		Score tmp = a.get(left);
		
		a.set(left, a.get(right));
		a.set(right, tmp);
	}
	
	public static void insertionSort(List<Score> a, int left, int right, int type)
	{
		if(left < 0 || left >= a.size() || right < 0 || right >= a.size())
			return;
		int j ;
		if(type == AVERAGE_TYPE)
		{
			for(int i = left; i <= right; i++)
			{
				Score tmp = a.get(i);
				for(j = i; j > left && a.get(j - 1).average > tmp.average; j--)
					a.set(j, a.get(j - 1));
				a.set(j, tmp);
			}
		}
		else if(type == C_LANGUE_TYPE)
		{
			for(int i = left; i <= right; i++)
			{
				Score tmp = a.get(i);
				for(j = i; j > left && a.get(j - 1).CLang > tmp.CLang; j--)
					a.set(j, a.get(j - 1));
				a.set(j, tmp);
			}
		}
		else if(type == MATHEM_TYPE)
		{
			for(int i = left; i <= right; i++)
			{
				Score tmp = a.get(i);
				for(j = i; j > left && a.get(j - 1).mathem > tmp.mathem; j--)
					a.set(j, a.get(j - 1));
				a.set(j, tmp);
			}
		}
		else if(type == ENGLISH_TYPE)
		{
			for(int i = left; i <= right; i++)
			{
				Score tmp = a.get(i);
				for(j = i; j > left && a.get(j - 1).english > tmp.english; j--)
					a.set(j, a.get(j - 1));
				a.set(j, tmp);
			}
		}
	}
}
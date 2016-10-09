package MainPackage;

import java.util.*;

public class Main 
{
	public static int INFINITY = Integer.MAX_VALUE;
	public static void main(String[] args)
	{
		AdjacencyList[] adjacencyArrays;
		int cities;
		int roads;
		int currentCity;
		int destinationCity;
		int min;
		AdjacencyList currentAdjacency = null;
		AdjacencyList nextAdjacency = null;
		
		Scanner in = new Scanner(System.in);
		cities = in.nextInt();
		roads = in.nextInt();
		currentCity = in.nextInt();
		destinationCity = in.nextInt();
		
		adjacencyArrays = new AdjacencyList[cities];
		for(int i = 0; i < cities; i++)
		{
			int teams = in.nextInt();
			adjacencyArrays[i] = new AdjacencyList(teams);
			adjacencyArrays[i].addAItem(adjacencyArrays[i], 0);
		}
		
		for(int i = 0; i < roads; i++)
		{
			int fromCity = in.nextInt();
			int toCity = in.nextInt();
			int length = in.nextInt();
			adjacencyArrays[fromCity].addAItem(adjacencyArrays[toCity], length);
			adjacencyArrays[toCity].addAItem(adjacencyArrays[fromCity], length);
		}
		
		adjacencyArrays[currentCity].distance = 0; 
		
		for(int i = 0; i < cities; i++)
		{
			min = INFINITY;
			for(int j = 0; j < cities; j++)
			{
				if(!adjacencyArrays[j].isVisited && adjacencyArrays[j].distance < min)
				{
					min = adjacencyArrays[j].distance;
					currentAdjacency = adjacencyArrays[j];
				}
			}
			
			if(currentAdjacency == null)
				break;
			else if(currentAdjacency == adjacencyArrays[destinationCity])
				break;
			
			currentAdjacency.isVisited = true;
			
			for(int j = 0; j < currentAdjacency.adjacencyList.size(); j++)
			{
				nextAdjacency = currentAdjacency.adjacencyList.get(j);
				int tmp = currentAdjacency.distance + currentAdjacency.relativeDistance.get(j);
				if(!nextAdjacency.isVisited && tmp < nextAdjacency.distance)
				{
					nextAdjacency.distance = tmp;
					nextAdjacency.waysCount = currentAdjacency.waysCount;
					nextAdjacency.totalTeams = currentAdjacency.totalTeams + nextAdjacency.teamsCount;
				}
				else if(!nextAdjacency.isVisited && tmp == nextAdjacency.distance)
				{
					nextAdjacency.waysCount += currentAdjacency.waysCount;
					if(currentAdjacency.totalTeams + nextAdjacency.teamsCount > nextAdjacency.totalTeams)
						nextAdjacency.totalTeams = currentAdjacency.totalTeams + nextAdjacency.teamsCount;
				}
			}
		}
		
		System.out.print(adjacencyArrays[destinationCity].waysCount + " " + adjacencyArrays[destinationCity].totalTeams);
	}
	
	private static class AdjacencyList
	{
		private int teamsCount;
		private int distance;
		private int totalTeams;
		private int waysCount;
		private boolean isVisited;
		private List<AdjacencyList> adjacencyList;
		private List<Integer> relativeDistance; 
		
		public AdjacencyList(int count)
		{
			teamsCount = count;
			distance = INFINITY;
			totalTeams = count;
			waysCount = 1;
			isVisited = false;
			adjacencyList = new ArrayList<AdjacencyList>();
			relativeDistance = new ArrayList<Integer>();
		}
		
		public void addAItem(AdjacencyList destAdjacency, int distance)
		{
			if(adjacencyList != null)
				adjacencyList.add(destAdjacency);
			if(relativeDistance != null)
				relativeDistance.add(distance);
		}
	}
}

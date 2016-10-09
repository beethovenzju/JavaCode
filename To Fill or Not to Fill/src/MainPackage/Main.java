package MainPackage;

import java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Main {
	public static void main(String[] args){
		Scanner in = new Scanner(new BufferedInputStream(System.in));
		List<Station> list = new LinkedList<Station>();
		int capacity;
		double currentCap = 0.0;
		int distance, currentDis = 0;
		double currentPrice = 0.0;
		int longest = 0;
		int average;
		int stationNum;
		
		capacity = in.nextInt();
		distance = in.nextInt();
		average = in.nextInt();
		stationNum = in.nextInt();
		longest = capacity * average;
		
		for(int i = 0; i < stationNum;i++){
			double price = in.nextDouble();
			int curDistance = in.nextInt();
			Station station = new Station(price, curDistance);
			list.add(station);
		}
		Station station = new Station(0, distance);
		list.add(station);
		
		Collections.sort(list, new Comparator<Station>(){
			@Override
			public int compare(Station arg0, Station arg1){
				return arg0.distance - arg1.distance;
			}
		});
		
		if(list.get(0).distance != 0){
			System.out.println("The maximum travel distance = 0.00");
			return;
		}
		
		int index = 0;
		while(index <= stationNum && list.get(index).distance < distance){
			Station current = list.get(index);
			int nextIndex = index + 1;
			Station next = list.get(nextIndex);
			
			int cheapestIndex = -1;
			double cheapestPrice = Integer.MAX_VALUE;
			while(next.distance - current.distance <= longest){
				if(next.price < cheapestPrice){
					cheapestIndex = nextIndex;
					cheapestPrice = next.price;
				}
				if(nextIndex < list.size() - 1){
					nextIndex++;
					next = list.get(nextIndex);
				}
				else 
					break;
			}
			
			if(cheapestIndex == -1){
				double needed = capacity - currentCap;
				currentPrice += needed * current.price;
				currentDis += capacity * (double) average;
				currentCap = 0;
				BigDecimal big = new BigDecimal(currentDis);
				System.out.println("The maximum travel distance = " + big.setScale(2, BigDecimal.ROUND_HALF_UP));
				break;
			}
			else if(current.price >= list.get(cheapestIndex).price){
				int latest = index + 1;
				while(current.price < list.get(latest).price)
					latest++;
				
				double needed = (list.get(latest).distance - current.distance) / (double) average;
				if(needed > currentCap){
					currentPrice += (needed - currentCap) * current.price;
					currentDis += (list.get(latest).distance - current.distance);
					currentCap = 0;
				}
				else{
					currentDis += (list.get(latest).distance - current.distance);
					currentCap -= needed;
				}
				index = latest;
			}
			else if(current.price < list.get(cheapestIndex).price){
				double needed = capacity - currentCap;
				currentPrice += needed * current.price;
				currentDis += (list.get(cheapestIndex).distance - current.distance);
				currentCap = capacity - (list.get(cheapestIndex).distance - current.distance) / (double)average;
				index = cheapestIndex;
			}
		}
		
		if(list.get(index).distance == distance){
			BigDecimal big = new BigDecimal(currentPrice);
			System.out.println(big.setScale(2, BigDecimal.ROUND_HALF_UP));
		}
	}
	
	public static class Station{
		private double price;
		private int distance;
		
		public Station(double price, int distance){
			this.price = price;
			this.distance = distance;
		}
	}
}

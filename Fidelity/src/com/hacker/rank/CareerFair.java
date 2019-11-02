package com.hacker.rank;
import java.util.*;
import java.util.stream.Stream;

public class CareerFair {
	
	public static int maxEvents(List<Integer> arrival,List<Integer> duration) {
		int[][] events = new int[arrival.size()][arrival.size()];
		for(int i=0;i<arrival.size();i++) {
			events[i] = new int[] {arrival.get(i), arrival.get(i) + duration.get(i)};
		}
		Arrays.sort(events, (a, b)->(a[1] - b[1]));
	//	Stream.of(events).map(Arrays::toString).forEach(System.out::println);

		
		Queue<int[]> minHeap = new PriorityQueue<>((a, b)->a[1] - b[1]);
		int[] first = events[0];
		for(int i=1;i<events.length;i++) {
			int[] cur = events[i];
			if(cur[0] < first[1]) {
				minHeap.offer(cur);
			}
			else {
				first[1] = events[i][1];
			}	
		}
		return arrival.size() - minHeap.size();
		
	}
	
	public static void main(String args[]) {
		List<Integer> arrival = Arrays.asList(1, 3, 3,  5, 7);
		List<Integer> duration = Arrays.asList(2, 2, 1, 2 , 1);
		System.out.println(maxEvents(arrival,duration));
	}

}

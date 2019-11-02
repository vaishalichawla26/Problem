package com.hacker.rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MaxDistanceBetAdjcentArray {
	
	public static int maxDiff(List<Integer> arr) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1 ; i < arr.size() ; i++ ) {
			for(int j = i-1 ; j >= 0 ; j-- ) {
				if(arr.get(i) > arr.get(j)) {
					list.add(arr.get(i) - arr.get(j));
				}
			}
		}
		list.sort(Comparator.reverseOrder());
		return list.get(0);
		
	}
	
	public static void main(String args[]) {
		// 2,3,10,2,4,8,1
		// 1,2,6,4
		List<Integer> arr = Arrays.asList(1,2,6,4); 
		System.out.println("maxDiff: "+maxDiff(arr));
		
	}

}

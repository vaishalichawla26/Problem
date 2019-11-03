package com.uhg;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.*;

public class DuplicateRemoval {

	public static void main(String args[]) {
		
		String str = "abcdabcdaa";
		char[] charArr = str.toCharArray();
		LinkedHashMap<Character, Integer> occurMap = new LinkedHashMap<Character, Integer>();
		for(char c : charArr) {
			if (occurMap.get(c) == null) {
				occurMap.put(c, 1);
			} else {
				occurMap.replace(c, occurMap.get(c) + 1);
			}
		}
		System.out.println(occurMap);
		System.out.println(occurMap.keySet().stream().map(String::valueOf).collect(Collectors.joining()));

		

//		String str = "abcdabcdaa";
//		LinkedHashMap<Character, Integer> occurMap = new LinkedHashMap<Character, Integer>();
//
//		for (int i = 0; i < str.length(); i++) {
//			if (occurMap.get((char) str.charAt(i)) == null) {
//				occurMap.put((char) str.charAt(i), 1);
//			} else {
//				occurMap.replace((char) str.charAt(i), occurMap.get((char) str.charAt(i)) + 1);
//			}
//
//		}
//		System.out.println(occurMap);
//		System.out.println(occurMap.keySet().stream().map(String::valueOf).collect(Collectors.joining()));

		
//		String str = "abcdabcdaa";
//		List<Character> charList = str.chars().mapToObj(x -> (char)x).collect(Collectors.toList());
//		LinkedHashMap<Character, Long> occuranceMap = charList.stream().
//				collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new
//						,Collectors.counting()));
//		System.out.println(occuranceMap);
		
//		System.out.println("Removal of duplicate elemts: Set to string "+
//		occuranceMap.keySet().stream().map(String::valueOf).collect(Collectors.joining()));

//	String str = "abcdabcdaa";
//	LinkedHashSet<Character> uniqueChars =
//			str.chars().mapToObj(x -> (char)x).collect(Collectors.toCollection(LinkedHashSet::new));
//	System.out.println(uniqueChars.stream().map(String::valueOf).collect(Collectors.joining()));

	}
}

package com.hacker.rank;
import java.util.*;

public class StringChainDFS {
	
    static int longestChain(List<String> words) {
        // create something with O(1) searching of words.
        final Set<String> allWords = new HashSet<>();
        for (String e : words) allWords.add(e);

        int max = -1;
        for (String target : words) {
            int k = depthFirstCount(target, allWords);
            if (k > max) max = k;
        }

        return max;
    }

    private static int depthFirstCount(String target, Set<String> allWords) {
        int n = target.length();
        int max = 0;

        if (!allWords.contains(target)) return 0;

        for (int i = 0; i < n; i++) {
            String current = removeCharAt(target, i);
            // increase our depth by 1;
            int local = 1 + depthFirstCount(current, allWords);
            // find the max depth recursively.
            if (local > max)
                max = local;
        }
        return max;
    }

    static String removeCharAt(String s, int i) {
        StringBuilder buf = new StringBuilder(s);
        buf.delete(i, i+1);
        return buf.toString();
    }
    
    public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int longestChain = longestChain(Arrays.asList(words));
		System.out.println("longestChain " + longestChain);
	}
    

}

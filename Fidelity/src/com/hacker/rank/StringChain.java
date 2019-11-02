package com.hacker.rank;

import java.util.*;

/**
 * Created by cancobanoglu on 11/09/16.
 */
public class StringChain {

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int longestChain = longestChain(words);
		System.out.println("longestChain " + longestChain);
	}

	static int longestChain(String words[]) {
		List<String> wordList = Arrays.asList(words);
		int max = Integer.MIN_VALUE;
		for (String word : words) {
			int current = processWord(word, wordList);
			if (max < current) {
				max = current;
			}
			System.out.println(current);
		}

		return max;
	}

	static int processWord(String word, List<String> allWords) {
		if (word.length() == 1)
			return 1;

		Stack<String> wordsStack = new Stack<String>();
		wordsStack.add(word);

		// start and end indices which hold character is dropped from the current word
		int startIndex = 0;
		int endIndex = 1;

		while (!wordsStack.isEmpty()) {
			String currentWord = wordsStack.peek();

			if (endIndex > currentWord.length()) {
				break;
			}

			if (allWords.contains(currentWord)) {
				StringBuilder wordBuilder = new StringBuilder(currentWord);
				wordBuilder.delete(startIndex, endIndex);
				wordsStack.add(wordBuilder.toString());
			} else {
				wordsStack.pop();
				startIndex++;
				endIndex++;
			}
		}

		return wordsStack.size();
	}
}

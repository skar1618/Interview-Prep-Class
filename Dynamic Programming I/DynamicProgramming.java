

public class DynamicProgramming {
		
	/**
	 * Return the nth Fibonacci Number
	 */
	public int fibonacci(int n) {
		if(n == 1 || n == 2) {
			return 1;
		}
				
		int n1 = fibonacci(n - 1);
		int n2 = fibonacci(n - 2);
		
		return n1 + n2;
	}
	
	public int fibonacciDP(int n) {
		int[] fibVals = new int[n];
		fibVals[0] = 1;
		fibVals[1] = 1;
		
		for(int i = 2; i < n; i++) {
			fibVals[i] = fibVals[i - 1] + fibVals[i - 2];
		}
		
		return fibVals[n - 1];
	}
	
	/**
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction (ie, buy one and 
	 * sell one share of the stock), design an algorithm to find the maximum profit.
	 */
	public int bestProfit(int[] prices) {
		int size = prices.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < size; i++) {
			if(min > prices[i]) {
				min = prices[i];
			}
			
			
			int mayBeMax = prices[i] - min;
			if(max < mayBeMax) {
				max = mayBeMax;
			}
		}
		return max;
	}
	
	
	private int getMaxValue(int[] profits) {
		int size = profits.length;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < size; i++) {
			if(profits[i] > max) {
				max = profits[i];
			}
		}
		return max;
	}
	
	
	/**
	 * Find the nth row kth element in the pascal's triangle
	 * @param n
	 * @param k
	 *
	 **/
	public int pascalTriangle(int n, int k) {
		int[][] pascal = new int[n + 1][n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
		}
		
		for(int j = 1; j <= k; j++) {
			for(int i = 2; i < n + 1; i++) {
				pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1]; 
			}
		}
		
		return pascal[n][k];
	}
	
	/**
	 * Can the input sentence without spaces be split into into words.
	 * Assume you are given a Dictionary.
	 */
	
	public boolean isSentence(String sentence) {
		int size = sentence.length();
		boolean[] validSentence = new boolean[size + 1];
		
		validSentence[0] = true;
		for(int i = 0; i < size; i++) {
			for(int j = i; j >= 0; j--) {
				if(validSentence[j]) {
					String subString = sentence.substring(j, i + 1);
					if(isWord(subString)) {
						validSentence[i + 1] = true;
						break;
					}
				}
			}
		}
		return validSentence[size];
	}

	private boolean isWord(String word) {
		if(word.equals("this") || word.equals("is") || word.equals("a") || word.equals("sentence")) {
			return true;
		}
		return false;
		
	}
	
	/** 
	 * Find the length longest substring that is a Palindrome
	 */
	public int longestPalindrome(String str) {
		int size = str.length();
		boolean[][] isPalindrome = new boolean[size][size];
		int maxLen = 1;
		
		for(int i = 0; i < size; i++) {
			isPalindrome[i][i] = true;
		}
		
		for(int i = 0; i < size - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)) {
				isPalindrome[i][i + 1] = true;
				maxLen = 2;
			}
			
		}
		
		for(int diff = 2; diff < size ; diff++) {
			for(int i = 0; i < size - diff; i++) {
				if(str.charAt(i) == str.charAt(i + diff)) {
					isPalindrome[i][i + diff] = isPalindrome[i + 1][i + diff - 1];
					if(isPalindrome[i][i + diff]) {
						maxLen = diff + 1;
					}
				}
				else {
					isPalindrome[i][i + diff] = false;
				}
			}
		}
		
		return maxLen;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

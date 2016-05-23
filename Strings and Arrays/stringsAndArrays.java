
public class stringsAndArrays {
	//  Implement an algorithm to determine if a string has all unique characters. 
	//  What if you cannot use additional data structures 
	//  EX1: "karaoke"
	public boolean allUniqueChars(String str) {
		int strLen = str.length();
		for(int i = 0; i < strLen - 1; i++) {
			for(int j = i + 1; j < strLen; j++) {
				if(str.charAt(i) == str.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	public boolean allUniqueChars_v2(String str) {
		int strLen = str.length();
		boolean[] charsPresent = new boolean[256];
		for(int i = 0; i < strLen; i++) {
			if(charsPresent[str.charAt(i)])
				return false;
			
			charsPresent[str.charAt(i)] = true;
		}
		return true;
	}
	
	// Given two strings, write a method to decide if one is a permutation of the other
	public boolean arePermutations(String str1, String str2) {
		int strLen1 = str1.length();
		int strLen2 = str2.length();
		if(strLen1 != strLen2) {
			return false;
		}
		
		int[] charCounts = new int[256];
		for(int i = 0; i < strLen1; i++) {
			int charIndex = str1.charAt(i);
			charCounts[charIndex]++;
		}
		
		for(int i = 0; i < strLen2; i++) {
			int charIndex = str2.charAt(i);
			charCounts[charIndex]--;
			
			if(charCounts[charIndex] < 0)
				return false;
		}
		
		return true;
	}
	
	// Write a method to replace all spaces in a string with '%20'. 
	// You may assume that the string has sufficient space at the 
	// end of the string to hold the additional characters, and that
	// you are given the "true" length of the string. 
	// (Note: if implementing in Java, please use a character array so 
	// that you can perform this operation in place.) 
	public void replaceSpaces(char[] str, int length) {
		int actLen = str.length;
		int actItr = actLen - 1;
		for(int i = length - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[actItr] = '0';
				str[actItr - 1] = '2';
				str[actItr - 2] = '%';
				actItr -= 3;
			}
			else {
				str[actItr] = str[i];
				actItr--;
			}
		}
	}
	
	// Given a sorted array, print all pairs of integers that differ by the input diff
	public void printPairsWithDiff(int[] arr, int diff) {
		int arrSize = arr.length;
		int i = 0, j = 1;
		while(j < arrSize) {
			if(arr[j] - arr[i] < diff) {
				j++;
			}
			else if(arr[j] - arr[i] > diff) {
				i++;
			}
			else {
				System.out.println(arr[i] + "," + arr[j]);
				i++;
				j++;
			}
		}
	}
	
	// Given a two strings (one smaller than the other), find if the smaller
	// is part of the larger and return the index of the first occurrence of the smaller
	// return -1 otherwise
	public int stringContains(String larger, String smaller) {
		int largerSize = larger.length();
		int smallerSize = smaller.length();
		int i = 0, j = 0;
		for(i = 0; i < largerSize - smallerSize + 1; i++) {
			for(j = 0; j < smallerSize; j++) {
				if(larger.charAt(i + j) != smaller.charAt(j))
					break;
			}
			
			if(j == smallerSize)
				return i;
		}
		return -1;
	}
	
	//  Given an image represented by an NxN matrix, where each pixel in the image 
	//  is 4 bytes, write a method to rotate the image by 90 degrees. 
	// Can you do this in place? 
	public void rotate90(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n / 2; i++) {
			for(int j = i; j < n - i - 1; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i];
				matrix[n - j -1][i] = temp;
			}
		}
	}
	
	public void prettyPrintMatrix(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			String row = "";
			for(int j = 0; j < n; j++) {
				row += matrix[i][j] + " ";
			}
			System.out.println(row);
		}
	}
}

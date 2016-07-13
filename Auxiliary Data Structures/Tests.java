import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class Tests {
	DataStructures ds = new DataStructures();
	
	@Test
	public void largestRectangleTests() {
		int[] H = {1,2,1,2,1,5,2,2,2,3,4,5,6};
		int largest = ds.LargestRectangleArea(H);
		assertEquals(largest, 16);
	}
	
	@Test
	public void medianOfNumsTests() {
		int[] nums = {8,4,3,9,2,5,8,2,6,6,5,7,8,3,1};
		float val = ds.medianOfNums(nums);
		assertEquals((int)val, 5);
	}
	
	@Test
	public void LCSTests() {
		int[] arr = {100,4,200,6,3,1,5,2};
		int lcs = ds.longestConsecutiveSequence(arr);
		assertEquals(lcs, 6);
	}
	
	@Test
	public void findWordsTests() {
		char[][] board = {
				{'k','n','o','c'},
				{'o','f','l','e'},
				{'a','u','c','i'},
				{'t','h','s','u'}};
		String[] words = {"oath","pea","elf","rain","confucius"};
		ArrayList<String> wordsInBoard = ds.findWords(board, words);
		for(String str : wordsInBoard) {
			System.out.println(str);
		}
	}
}

import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {
	DynamicProgramming dp = new DynamicProgramming();
	

	@Test
	public void bestProfitTests() {
		int[] prices = {800, 2400, 600, 2400, 2800, 800, 1200};
		int maxProfit = dp.bestProfit(prices);
		assertEquals(maxProfit, 2200);
	}
	
	@Test
	public void pascalTriangleTest() {
		int numPaths = dp.pascalTriangle(10, 5);
		assertEquals(numPaths, 252); 
	}
	
	
	@Test
	public void isSentenceTests() {
		String sentence = "thisisasentence";
		boolean isSentence = dp.isSentence(sentence);
		assertEquals(isSentence, true);
		
		sentence = "thisisnotasente";
		isSentence = dp.isSentence(sentence);
		assertEquals(isSentence, false);
	}
	
	@Test
	public void longestPalindromeTests() {
		String str = "abaxabayabaxabaxyz";
		int len = dp.longestPalindrome(str);
		assertEquals(len, 15);
		
		str = "malayalam";
		len = dp.longestPalindrome(str);
		assertEquals(len, 9);
	}
	

	
	
	
}

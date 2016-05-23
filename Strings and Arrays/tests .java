import static org.junit.Assert.*;

import org.junit.Test;


public class tests {
	public stringsAndArrays strArr = new stringsAndArrays();
	@Test
	public void allUniqueCharsTest() {
		stringsAndArrays strArr = new stringsAndArrays();
		boolean b1 = strArr.allUniqueChars("karaoke");
		boolean b2 = strArr.allUniqueChars("phoenix");
		assertEquals(b1, false);
		assertEquals(b2, true);
		
		boolean b3 = strArr.allUniqueChars_v2("karaoke");
		boolean b4 = strArr.allUniqueChars_v2("phoenix");
		assertEquals(b3, false);
		assertEquals(b4, true);
	}
	
	@Test
	public void arePermutationsTests() {
		boolean b1 = strArr.arePermutations("tom marvolo riddle ", "i am lord voldemort");
		boolean b2 = strArr.arePermutations("tomatoes", "smmotate");
		boolean b3 = strArr.arePermutations("smmotate", "tomatoes");
		assertEquals(b1, true);
		assertEquals(b2, false);
		assertEquals(b3, false);
	}
	
	@Test
	public void replaceSpacesTest() {
		char[] a = {'a', ' ', 'b', 'c', ' ', '\0', '\0', '\0', '\0'};
		char[] b = {'a', ' ', 'b', 'c', ' '};
		strArr.replaceSpaces(a, 5);
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
	
	@Test
	public void printPairsWithDiffTest() {
		int[] a = {3, 5, 8, 11, 13, 14, 16, 21, 24, 1000, 1003};
		strArr.printPairsWithDiff(a, 3);
	}
	
	@Test
	public void stringContainsTest() {
		String s1 = "lioness";
		String s2 = "lion";
		String s3 = "tigress";
		String s4 = "tiger";
		int i1 = strArr.stringContains(s1, s2);
		int i2 = strArr.stringContains(s3, s4);
		assertEquals(i1, 0);
		assertEquals(i2, -1);
	}
	
	@Test
	public void rotate90Test() {
		int[][] matrixOdd = {{5, 7, 3}, {8, 2, 7}, {3, 2, 6}};
		int[][] matrixEven = {{5, 7, 3, 5}, {8, 2, 7, 4}, {3, 2, 6, 7}, {4, 2, 7, 9}};
		strArr.prettyPrintMatrix(matrixOdd);
		System.out.println();
		strArr.rotate90(matrixOdd);
		strArr.prettyPrintMatrix(matrixOdd);
		System.out.println();
		strArr.prettyPrintMatrix(matrixEven);
		System.out.println();
		strArr.rotate90(matrixEven);
		strArr.prettyPrintMatrix(matrixEven);
		
	}

}

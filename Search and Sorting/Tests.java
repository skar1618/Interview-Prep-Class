import static org.junit.Assert.*;

import org.junit.Test;


public class Tests {
BinarySearch bs = new BinarySearch();
	
	@Test
	public void sqrtTests() {
		double epsilon = 0.0001;
		double sqrt = bs.sqrt(5, epsilon);
		assertEquals(sqrt, 2.236, epsilon);
	}
	
	@Test
	public void searchMatrixTests() {
		int[][] matrix = {
		                  {1,   4,  7, 11, 15},
		                  {2,   5,  8, 12, 19},
		                  {3,   6,  9, 16, 22},
		                  {10, 13, 14, 17, 24},
		                  {18, 21, 23, 26, 30}
						};
		
		boolean b1 = bs.searchMatrix(matrix, 8);
		boolean b2 = bs.searchMatrix(matrix, 27);
		assertEquals(b1, true);
		assertEquals(b2, false);
	}
	
	@Test
	public void findPeakElementTest() {
		int[] nums = {12,30,40,38,32,31,24,22,20};
		int index = bs.findPeakElement(nums);
		assertEquals(index, 2);
	}
	
	@Test
	public void searchRotatedTests() {
		int[] nums = {7,8,1,2,3,5};
		for(int i = 0; i < 6; i++) {
			assertEquals(i, bs.search(nums, nums[i]));
		}
		assertEquals(-1, bs.search(nums, 10));
		
	}
	
		
	
	
	
	
	
	
	
}


public class BinarySearch {
	/**
	 * Given an Integer and an error correction epsilon
	 * find the square root within the given error.
	 * @param x
	 * @param epsilon
	 * @return
	 */
	double sqrt(int x, double epsilon) {
		double min = 0; 
		double max = x;
		double  sqrt = 0;
		while(Math.abs(Math.pow(sqrt, 2) - x) > epsilon) {
			sqrt = (min + max) / 2;
			if(Math.pow(sqrt, 2) > x) {
				max = sqrt;
			}
			else {
				min = sqrt;
			}
		}
		
		return sqrt;
	}
		
	/** 
	 * Write an efficient algorithm that searches for a value in an m x n matrix.
	 * This matrix has the following properties:
     *  - Integers in each row are sorted in ascending from left to right.
	 *  - Integers in each column are sorted in ascending from top to bottom.
	 *  Ex: 
	 *  [
   		 [1,   4,  7, 11, 15],
  		 [2,   5,  8, 12, 19],
  		 [3,   6,  9, 16, 22],
  		 [10, 13, 14, 17, 24],
  		 [18, 21, 23, 26, 30]
		]
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		int rowItr = rows - 1;
		int colItr = 0;
		while(colItr < cols && rowItr >= 0) {
			int itr = matrix[rowItr][colItr];
			if(itr == target) {
				return true;
			}
			else if(itr < target) {
				colItr++;
			}
			else {
				rowItr--;
			}
		}
		
		return false;
	}
	
	public int findPeakElement(int[] nums) {
		return findPeakElement(nums, 0, nums.length - 1);
	}

	private int findPeakElement(int[] nums, int start, int end) {
		if(start == end) {
			return start;
		}
		else if(end - start == 1) {
			if(nums[end] > nums[start]) {
				return end;
			}
			else {
				return start;
			}
		}
		
		int mid = (start + end) / 2;
		if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
			return mid;
		}
		else if(nums[mid] < nums[mid - 1]) {
			return findPeakElement(nums, start, mid - 1);
		}
		else {
			return findPeakElement(nums, mid + 1, end);
		}
		
	}
	
	/**
	 * Suppose a sorted array is rotated at some pivot unknown
	 *  to you beforehand.
		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	 	You are given a target value to search. If found in the
	 	array return its index, otherwise return -1.
		You may assume no duplicate exists in the array.
	 * @param nums
	 * @param target
	 * @return
	 */
	 public int search(int[] nums, int target) {
		 int max = nums.length - 1;
		 int min = 0;
		 
		 while(min <= max) {
			 int mid = (min + max) / 2;
			 if(nums[mid] == target) {
				 return mid;
			 }
			 else if(nums[mid] > nums[min]) {
				 if(target >= nums[min] && target < nums[mid]) {
					 max = mid - 1;
				 }
				 else {
					 min = mid + 1;
				 }
			 }
			 else {
				 if(target <= nums[max] && target > nums[mid]) {
					 min = mid + 1;
				 }
				 else {
					 max = mid - 1;
				 }
			 }
		 }
		 
		 return -1;
		 
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

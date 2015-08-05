package sse.ustc.edu;

public class FindMinimuminRotatedSortedArray {
	 /*1 2 3 4 5 6 7,      3 4 5 6 7 1 2 */
    //A[mid] < A[end], the left can be decreasing order or ascending order  =>min must in A[start:mid]
    //A[mid] > A[end], the left must be ascending order and the most left is larger than the right most element=> min must in A[mid + 1:end]
    
    //base case 1: start == end, the A[start] is we want to find. 
    //base case 2: start and end is adjacent. can be the 1 2 or 6 5, when we arrive at here start and mid is at the same position
    //if it is the former, mid is less than end, ,min must A[start:mid], so we get the min 1
    //if it is the latter, mid is larger than the end, min must in A[mid+1:end],we alse get the min 5
    
    
    //if dumplicate exists in the array, how to do?
    //if A[mid] == A[end], min must in A[start:end - 1]
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            throw new IllegalArgumentException();
            
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = (low + high) / 2;
            if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high = mid;
        }
        return nums[low];
    }
}

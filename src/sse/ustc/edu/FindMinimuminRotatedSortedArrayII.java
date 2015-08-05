package sse.ustc.edu;

public class FindMinimuminRotatedSortedArrayII {
	 //solution 1:iterative
    // public int findMin(int[] nums) {
    //     if(nums == null || nums.length == 0)
    //         return -1;//here we shoule throw exception
    //     int low = 0;
    //     int high = nums.length - 1;
    //     while(low < high) {
    //         int mid = (low + high) / 2;
    //         if(nums[mid] < nums[high])
    //             high = mid;
    //         else if(nums[mid] > nums[high])
    //             low = mid + 1;
    //         else
    //             high --;
    //     }
        
    //     return nums[low];
    // }
    
    //solution 2:recursive
    
    public int helper(int[] nums, int low, int high) {
        if(low >= high)
            return nums[low];
        int mid = (low + high) / 2;
        if(nums[mid] < nums[high])
            return helper(nums, low, mid);
        else if(nums[mid] > nums[high])
            return helper(nums, mid + 1, high);
        else
            return helper(nums, low, high - 1);
    }
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
}

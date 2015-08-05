package sse.ustc.edu;

public class SearchinRotatedSortedArray {
	 /**the roated list will be splitted into two parts after the rotate,and both are sorted list */
    /*we can use the lsearch, but here we can use the binary search with the attribute of rotated list */
    /*when we split the list with middle, there must be one sorted list */
    
    //assume no duplicate exists in the array
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return -1;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high);
            if(nums[mid] == target)
                return mid;
                
            if(nums[mid] > nums[low]) {
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            else {
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        
        return -1;
    }
}

package sse.ustc.edu;

public class SearchinRotatedSortedArrayII {
	 /*it is a good question following the rotated sorted array 1*/
    /*eg 3  1 2 3 3 3, we don;t know where to go,left or right. so we just start ++ until they are different.*/
    //if all the elmement is same, and the target is not in the array.the time complexity is O(n)
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] > nums[low]) {
                if(target >= nums[low] && target < nums[mid])
                    high = mid -1;
                else
                    low = mid + 1;
            }
            else if(nums[mid] < nums[low]) {
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid -1;
            }
            //here is most important to solve the duplicate
            else  {
                low ++;
            }
        }
        
        return false;
    }
}

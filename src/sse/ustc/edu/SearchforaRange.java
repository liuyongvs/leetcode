package sse.ustc.edu;

public class SearchforaRange {
	public int findLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        /* need to check the low's index, low will be less than the 0 */
        if(low >= 0 && low < nums.length && nums[low] == target)
            return low;
        else
            return -1;
    }
    
    public int findRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] <= target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if(high >= 0 && high < nums.length && nums[high] == target)
            return high;
        else
            return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }
}

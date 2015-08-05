package sse.ustc.edu;

public class ContainsDuplicateIII {

	/* first solution, brute force, simple and easy to understand, time complexity O(n^2)*/
	/* k size window, |nums[i] - nums[j]| <= t , so nums[i] - t <= nums[j] <= nums[i] + t , we use the treeset, time complexity O(nlogk)*/

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k < 1 || t < 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i ++) {
            long leftBound = (long)nums[i] - t;
            long rightBound = (long)nums[i] + t + 1;
            SortedSet<Long> subset = set.subSet(leftBound, rightBound);
            if(!subset.isEmpty())
                return true;
            if(i >= k) {
                set.remove((long)nums[i - k]);
            }
            
            set.add((long)nums[i]);
        }
        
        return false;
    }
}

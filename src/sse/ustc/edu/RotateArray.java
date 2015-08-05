package sse.ustc.edu;

public class RotateArray {
	 /*solution 1: use the O(1) extra space, reverse twice*/
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start ++;
            end --;
        }
    }
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0)
            throw new IllegalArgumentException();
        
        k = k % nums.length;
        if(k == 0)
            return;
        reverse(nums, 0 , nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    
    //solution 2: use the O(n) extra space
    // public void rotate(int[] nums, int k) {
    //     if(nums == null || nums.length == 0 || k < 0)
    //       throw new IllegalArgumentException("Illegal argument!");
        
    //     k = k % nums.length;
    //     if(k == 0)
    //         return;
    //     int[] res = new int[nums.length];
    //     System.arraycopy(nums, 0, res, k, nums.length - k);
    //     System.arraycopy(nums, nums.length - k, res, 0, k);
    //     System.arraycopy(res, 0, nums, 0, nums.length);
    // }
    
    
    //solution 3: we use the approach, which is similar to bubble.use the O(1) extra space, but time complexity is O(n * k).
    //But it will cause TLE(time limit exceeded)
    // public void rotate(int[] nums, int k) {
    //     if(nums == null || nums.length == 0 || k < 0)
    //         throw new IllegalArgumentException("illegal argument");
    //     k = k % nums.length;
    //     if(k == 0)
    //         return;
    //     for(int i = 1; i <= k; i ++) {
    //         for(int j = nums.length - 1; j > 0; j --) {
    //             int temp = nums[j];
    //             nums[j] = nums[j - 1];
    //             nums[j - 1] = temp;
    //         }
    //     }
    // }
}

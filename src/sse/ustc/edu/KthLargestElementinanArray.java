package sse.ustc.edu;

public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.length + 1, Collections.reverseOrder());
        for(int element: nums) {
            pq.add(element);
        }
        
        while(true) {
            int res = pq.poll();
            k --;
            if(k == 0)
                return res;
        }
    }
}

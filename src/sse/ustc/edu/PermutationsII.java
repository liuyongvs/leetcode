package sse.ustc.edu;

public class PermutationsII {
	 public void helper(List<List<Integer>> res, List<Integer> item, int[] nums, boolean[] isVisited) {
	        if(item.size() == nums.length) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        
	        for(int i = 0; i < nums.length; i++) {
	            
	            if(!isVisited[i]) {
	                if(i > 0 && nums[i] == nums[i - 1] && isVisited[i - 1] == false)
	                    continue;
	                isVisited[i] = true;
	                item.add(nums[i]);
	                helper(res, item, nums, isVisited);
	                isVisited[i] = false;
	                item.remove(item.size() - 1);
	            }
	        }
	    }
	    public List<List<Integer>> permuteUnique(int[] nums) {
	        List<List<Integer>> res = new ArrayList<>();
	        if(nums == null || nums.length == 0)
	            return res;
	        
	        Arrays.sort(nums);
	        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
	        return res;
	    }
}

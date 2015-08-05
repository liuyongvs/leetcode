package sse.ustc.edu;

public class Permutations {
	public void helper(List<List<Integer>> res, List<Integer> item, int[] nums, boolean[] isVisited) {
        if(item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for(int i = 0; i < nums.length; i ++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                item.add(nums[i]);
                helper(res, item, nums, isVisited);
                isVisited[i] = false;
                item.remove(item.size() - 1);
            }
            
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
            
        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }
}

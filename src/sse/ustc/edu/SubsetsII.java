package sse.ustc.edu;

public class SubsetsII {
	public void helper(List<List<Integer>> res, List<Integer> item, int start, int[] nums, boolean[] isVisited) {
        for(int i = start; i < nums.length; i ++) {
            if(i > start && nums[i] == nums[i - 1])
                continue;
            if(!isVisited[i]) {
                item.add(nums[i]);
                isVisited[i] = true;
                res.add(new ArrayList<Integer>(item));
                helper(res, item, i + 1, nums, isVisited);
                isVisited[i] = false;
                item.remove(item.size() - 1);
            }
        }
    }
    
    //It can only can use the solution 1 of Subsets 1
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        helper(res, new ArrayList<Integer>(), 0, nums, new boolean[nums.length]);
        return res;
    }
}

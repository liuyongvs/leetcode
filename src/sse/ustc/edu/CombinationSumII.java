package sse.ustc.edu;

public class CombinationSumII {
	public void helper(List<List<Integer>> res, List<Integer> item, int start, int[] candidates, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(target < 0)
            return;
            
        for(int i = start; i < candidates.length; i ++) {
            if(i > start && candidates[i] == candidates[i - 1])
                continue;
            item.add(candidates[i]);
            helper(res, item, i + 1, candidates, target - candidates[i]);
            item.remove(item.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < 0)
            return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
    }
}

package sse.ustc.edu;

public class CombinationSum {
	 /*this is a NP problem. And we use the recursive. Basically, we enum all the element*/
    public void helper(List<List<Integer>> res, List<Integer> item, int start, int[] candidates, int target) {
        if(target == 0) {
            res.add(new ArrayList<Integer>(item));
            return ;
        }
        
        // if(target < 0)
        //     return;
     
        /* here we need start, or will get the duplicate result,
         eg, [2, 3, 5, 7] 7 => [[2, 2, 3], [2, 3, 2], [2, 5], [3, 2, 2], [5, 2], [7]] */
        for(int i = start; i < candidates.length; i ++) {
            if(target < candidates[i])
                return;
            item.add(candidates[i]);
            helper(res, item, i, candidates, target - candidates[i]);
            item.remove(item.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < 0)
            return res;
        Arrays.sort(candidates);
        helper(res, new ArrayList<Integer>(), 0, candidates, target);
        return res;
     }
}

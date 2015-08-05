package sse.ustc.edu;

public class CombinationSumIII {
	 public void helper(List<List<Integer>> res, List<Integer> item, int start, int target, int k) {
	        if(target == 0 && item.size() == k) {
	            res.add(new ArrayList<Integer>(item));
	            return;
	        }
	        
	        // if(item.size() > k)
	        //     return;
	        // if(target < 0)
	        //     return;
	        
	        for(int i = start; i < 10; i++) {
	            /*it can decrease the function call times in this way*/
	            if(i > target)
	                break;
	            if(item.size() > k)
	                break;
	            item.add(i);
	            helper(res, item, i + 1, target - i, k);
	            item.remove(item.size() - 1);
	        }
	    }
	    
	    public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res = new ArrayList<>();
	        /*k numbers must be different, so n(1,2,3,4...9) max is 45*/
	        if(k < 1 || k > 9 || n > 45 || n <= 0)
	            return res;

	        helper(res, new ArrayList<Integer>(), 1, n, k);
	        return res;
	    }
}

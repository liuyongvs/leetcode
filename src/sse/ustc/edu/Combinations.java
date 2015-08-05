package sse.ustc.edu;

public class Combinations {
	 /* this is a simple problem, using dfs, and this is a NP probelm, which means the time complexity is not polynominal time*/
    public void helper(List<List<Integer>> res, List<Integer> item, int start, int n, int k) {
        if(k == item.size()) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i <= n; i ++) {
            item.add(i);
            helper(res, item, i + 1, n, k);
            item.remove(item.size() - 1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 0 || k <= 0 || k > n)
            return res;
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
}

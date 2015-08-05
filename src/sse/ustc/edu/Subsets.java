package sse.ustc.edu;

public class Subsets {
	 //solution 1: backtrace, enumerate all the situation
    //solution 2: start {{}} 
    //            add 1 {{} {1}}
    //            add 2 {{} {1} {2} {1, 2}}
    //            add 3 {{} {1} {2} {1, 2} {3}, {1, 3}, {2, 3}, {1,2,3}}
    
    //solution 3: bit mapulation number of array will have 2^n subset. eg, a,b,c for 3(011) => bc
    
    
    // public void helper(List<List<Integer>>res, List<Integer> item, int start, int[] nums) {
    //     if(item.size() == nums.length)
    //         return;
    //     for(int i = start; i < nums.length; i++) {
    //         item.add(nums[i]);
    //         res.add(new ArrayList<Integer>(item));
    //         helper(res, item, i + 1, nums);
    //         item.remove(item.size() - 1);
    //     }
    // }
    
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(nums == null || nums.length == 0)
    //         return res;
    //     Arrays.sort(nums);
    //     helper(res, new ArrayList<Integer>(), 0, nums);
    //     //add the [] to list
    //     res.add(new ArrayList<Integer>());
    //     return res;
    // }
    
    
    // public List<List<Integer>> subsets(int[] nums) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     if(nums == null || nums.length == 0)
    //         return res;
    //     Arrays.sort(nums);
    //     res.add(new ArrayList<Integer>());
    //     for(int i = 0; i < nums.length; i++) {
    //         int size = res.size();
    //         for(int j = 0; j < size; j++) {
    //             List<Integer> item = new ArrayList<>();
    //             item.addAll(res.get(j));
    //             item.add(nums[i]);
    //             res.add(new ArrayList<Integer>(item));
    //         }
    //     }
    //     return res;
    // }
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        res.add(new ArrayList<>());
        
        
        int size = 1 << nums.length;
        for(int i = 1; i < size; i++) {
            int flag = 1;
            List<Integer> item = new ArrayList<>();
            for(int j = 0; j < nums.length; j ++) {
                if((i & flag) != 0) {
                    item.add(nums[j]);
                }
                flag = flag << 1;
            }
            res.add(new ArrayList<>(item));
        }
        return res;
    }
}

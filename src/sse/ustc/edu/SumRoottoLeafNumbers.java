package sse.ustc.edu;

public class SumRoottoLeafNumbers {
	 private int sum = 0;
	    public void sumNumbersHelper(List<Integer> list, TreeNode root) {
	        if(root == null)
	            return;
	        list.add(root.val);
	        if(root.left == null && root.right ==null)
	        {
	            int num = 0;
	            for(Integer element: list)
	                num = 10 *num + element;
	            sum += num;
	        }
	        sumNumbersHelper(list, root.left);
	        sumNumbersHelper(list, root.right);
	        list.remove(list.size() - 1);
	    }
	    
	    public int sumNumbers(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        sumNumbersHelper(list, root);
	        return sum;
	    }
}

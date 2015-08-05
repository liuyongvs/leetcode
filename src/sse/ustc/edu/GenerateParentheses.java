package sse.ustc.edu;

public class GenerateParentheses {
	 // private void helper(int left, int right, String item, List<String> res) {
    //     //here is most important.
    //     if(right < left) {
    //         return;
    //     }
        
    //     if(left == 0 && right == 0) {
    //         res.add(item);
    //         return;
    //     }
        
    //     if(left > 0) {
    //         helper(left - 1, right, item + "(", res);
    //     }
        
    //     if(right > 0) {
    //         helper(left, right - 1, item + ")", res);
    //     }
    // }
    // public List<String> generateParenthesis(int n) {
    //     List<String> res = new ArrayList<>();
    //     if(n <= 0)
    //         return res;
    //     helper(n, n, new String(), res);
    //     return res;
    // }
    
    private void helper(int left, int right, List<Character> item, List<String> res) {
        if (right < left) {
			return;
		}
		if(left == 0 && right == 0) {
			StringBuilder sb = new StringBuilder();
            for (int i = 0; i < item.size(); i++) {	
				sb.append(item.get(i));
			}
            res.add(sb.toString());
        }
        
        if(left > 0) {
            item.add('(');
            helper(left - 1, right, item, res);
            item.remove(item.size() - 1);
        }
        
        if(right > 0) {
            item.add(')');
            helper(left, right - 1, item, res);
            item.remove(item.size() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0)
            return res;
        helper(n, n, new ArrayList<Character>(), res);
        return res;
    }
}

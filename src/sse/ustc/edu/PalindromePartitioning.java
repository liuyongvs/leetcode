package sse.ustc.edu;

public class PalindromePartitioning {
	/*check the string whether is palindrome, that is to say , the string need to be symmetic*/
    public boolean isPalindrome(String str) {
        if(str == null || str.length() == 0)
            return false;
        int len = str.length();
        for(int i = 0, j = len - 1; i < j; i ++, j --) {
            if(str.charAt(i) != str.charAt(j))
                return false;
        }
        return true;
    }
    
    /*we enumrate all the situations*/
    public void helper(List<List<String>> res, List<String> item, String s) {
        if(s.length() == 0) {
            res.add(new ArrayList<String>(item));
            return;
        }
        
        for(int i = 1; i <= s.length(); i ++) {
            String str = s.substring(0, i);
            if(isPalindrome(str)) {
                item.add(str);
                /*here is important*/
                String substr = s.substring(i);
                helper(res, item, substr);
                item.remove(item.size() - 1);
            }
        }
    }
    
    /*second solution*/
    public void helper1(List<List<String>> res, List<String> item, int start, String s) {
        if(start == s.length()) {
            res.add(new ArrayList<String>(item));
            return;
        }
        for(int i = start + 1; i <= s.length(); i ++) {
            String str = s.substring(start, i);
            if(isPalindrome(str)) {
                item.add(str);
                helper1(res, item, i, s);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s == null || s.length() == 0)
            return res;
        //first solution
       // helper(res, new ArrayList<String>(), s);
        
        //second solution
        helper1(res, new ArrayList<String>(), 0, s);
        return res;
    }
}

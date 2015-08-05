package sse.ustc.edu;

public class LetterCombinationsofaPhoneNumber {
	//solution 1: backtracing
//    private void helper(String digits, int index, HashMap<Character, String> map, List<Character> item, List<String> res) {
//    	if (item.size() == digits.length()) {
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < item.size(); i++) {
//				sb.append(item.get(i));
//			}
//			res.add(sb.toString());
//			return;
//		}
   	
//    	Character ch = digits.charAt(index);
//    	String string = map.get(ch);
//    	for (int i = 0; i < string.length(); i++) {
//			item.add(string.charAt(i));
//			helper(digits, index + 1, map, item, res);
//			item.remove(item.size() - 1);
//		}
//    }
   
//    public List<String> letterCombinations(String digits) {
//    	List<String> res = new ArrayList<>();
//    	if (digits == null || digits.length() == 0) {
//			return res;
//		}
//    	HashMap<Character, String> map = new HashMap<>();
//    	map.put('0', " ");
//    	map.put('1', "");
//    	map.put('2', "abc");
//    	map.put('3', "def");
//    	map.put('4', "ghi");
//    	map.put('5', "jkl");
//    	map.put('6', "mno");
//    	map.put('7', "pqrs");
//    	map.put('8', "tuv");
//    	map.put('9', "wxyz");
   	
//    	helper(digits, 0, map, new ArrayList<>(), res);
//    	return res;
//    }


   //solution 2: collection
   //add the element into collection
   // {} {a, b, c} {ad, ae, af, bd, be, bf, cd, ce, cf} ...
   public List<String> letterCombinations(String digits) {
   	List<String> res = new ArrayList<>();
   	if(digits == null || digits.length() == 0)
   	    return res;
   	String[] str = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
   	//hers is most important
   	res.add("");
   	
   	for(int i = 0; i < digits.length(); i++) {
   	    List<String> temp = new ArrayList<>();
   	    temp.addAll(res);
   	    res.clear();
   	    
   	    int size = temp.size();
   	    for(int j = 0; j < size; j++) {
   	        
   	        
   	        String key = str[digits.charAt(i) - '0'];
   	        for(int k = 0; k < key.length(); k ++) {
   	            String element = temp.get(j);
   	            element += key.charAt(k);
   	            res.add(element);
   	        }
   	    }
   	}
   	
   	return res;
   }
}

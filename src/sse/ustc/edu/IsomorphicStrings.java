package sse.ustc.edu;

public class IsomorphicStrings {
	 /*sting "" is different from null.The former is a instantiated object, the latter is not.*/
    /*if call the function s.length(), the former get the result 0, the latter throw null expression*/
    /*String a = ""; String b = null; a == b =>get the false. a.equals(b) also get false.*/
    
    //ab = >aa will get false. so we not only need a => a, b => a, but also a => a, a => b here not true
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;
            
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(map1.containsKey(s.charAt(i))) {
                if(map1.get(c1) != c2)
                    return false;
            }
            else
                map1.put(c1, c2);
                
            if(map2.containsKey(t.charAt(i))) {
                if(c1 != map2.get(c2))
                    return false;
            }
            else
                map2.put(c2, c1);
        }
        return true;
    }
}

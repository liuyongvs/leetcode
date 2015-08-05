package sse.ustc.edu;

public class Anagrams {
	  /*if the list's length is k, every string's length is n, time complexity is O(k * nlogn)*/
    //we can also use the vrute force approach, need two loops, time complexity is O(k^2 *nlogn)
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<>();
        if(strs == null)
            return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i ++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = String.valueOf(arr);
             List<String> l = null;
            if(map.containsKey(str))
                l = map.get(str);
            else
                l = new LinkedList<>();
                
            l.add(strs[i]);
            map.put(str, l);
        }
        
        for(List<String> list: map.values()) {
            if(list.size() > 1)
               res.addAll(list);
        }

        return res;
    }
}

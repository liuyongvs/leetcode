package sse.ustc.edu;

public class SubstringwithConcatenationofAllWords {
	 /*the word in the words has duplicates*/
    /*we need maintain a window which size is equal to the all words.And we need maintain a hashtable, 
     and the key is word, the value is occurrence.So we can check the string whether is in the word with O(1) time complexity*/
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words[0].length() == 0)
            return res;
        
        int numOfWords = words.length;
        int wordLength = words[0].length();
        int windowSize = numOfWords * wordLength;
        int len = s.length();
        if(len < windowSize)
            return res;
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i]))
                map.put(words[i], 1);
            else
                map.put(words[i], map.get(words[i]) + 1);
        }
        
        
        for(int i = 0; i <= len - windowSize; i++) {
            String substr = s.substring(i, i + windowSize);
            HashMap<String, Integer> map2 = (HashMap<String, Integer>) map.clone();
            
            int j;
            for(j = 0; j < windowSize; j += wordLength) {
                String word = substr.substring(j, j + wordLength);
                if(map2.containsKey(word)) {
                    int count = map2.get(word);
                    count --;
                    if(count < 0)
                        break;
                    map2.put(word, count);
                }
                else {
                    break;
                }
            }
            
            if(j == windowSize)
                res.add(i);
        }
        
        return res;
    }
}

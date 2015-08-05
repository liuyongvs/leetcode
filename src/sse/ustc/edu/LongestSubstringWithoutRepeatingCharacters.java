package sse.ustc.edu;

public class LongestSubstringWithoutRepeatingCharacters {
	/* we maintain a window to avoid backstrace , so we need the start to remember the start of window*/
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        boolean[] map = new boolean[256];
        char[] arr = s.toCharArray();
        int start = 0;
        int maxLen = 0;
        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if(map[ch]) {
                maxLen = Math.max(maxLen, i - start);
                for(int k = start; k < i; k ++) {
                    if(arr[k] == ch) {
                        start = k + 1;
                        break;
                    }
                    map[arr[k]] = false;
                }
            }
            else {
                map[ch] = true;
            }
        }
        
        return Math.max(maxLen, arr.length - start);
    }
}

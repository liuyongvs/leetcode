package sse.ustc.edu;

public class SimplifyPath {
	 public String simplifyPath(String path) {
	        Set<String> isSkip = new HashSet<>(Arrays.asList("", ".", ".."));
	        String[] tokens = path.split("/");
			Stack<String> s = new Stack<>();
			for (int i = 0; i < tokens.length; i++) {
				
				if (tokens[i].equals("..") && !s.isEmpty()) {
					s.pop();
				}
			//	else if (tokens[i].equals(".") || tokens[i].equals("") || tokens[i].equals("..")) 
			    else if (isSkip.contains(tokens[i])){
					continue;
				}
				else {
					s.push(tokens[i]);
				}
			}
			String res = "";
			for (String dir : s) {
			    res += "/" + dir;
			}
			
			return res.length() == 0? "/" : res;
	    }
}

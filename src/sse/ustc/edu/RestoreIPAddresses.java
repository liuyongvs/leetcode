package sse.ustc.edu;

public class RestoreIPAddresses {
//  private boolean isValid(String s) {
//		if (s == null || s.length() <= 0 || s.length() > 3) {
//			return false;
//		}
//		if (s.charAt(0) == '0' && s.length() > 1) {
//			return false;
//		}
//		if (s.length() == 3 && Integer.parseInt(s) > 255) {
//			return false;
//		}
		
//		return true;
//	}
	
//	private void dfs(String s, int count, List<String> item, List<String> res) {
//		if (count == 3) {
//			//it will not need to continue to do recursion, such as count >= 4
//			if (isValid(s)) {
//				StringBuilder sb = new StringBuilder();
//				for (int i = 0; i < item.size(); i++) {
//					sb.append(item.get(i) + ".");
//				}
//				sb.append(s);
//				res.add(sb.toString());
				
//			}
//			return ;
//		}
		
//		for (int i = 0; i < 3 && i < s.length() - 1; i++) {
//			String sub = s.substring(0, i + 1);
//			if (isValid(sub)) {
//				item.add(sub);
//				//System.out.println(s.substring(i + 1));
//				dfs(s.substring(i + 1), count + 1, item, res);
//				item.remove(item.size() - 1);
//			}
//		}
//	}
	
//	public List<String> restoreIpAddresses(String s) {
//		List<String> res = new ArrayList<String>();
//		if (s == null || s.length() < 4 || s.length() > 12) {
//			return res;
//		} 
//		dfs(s, 0, new ArrayList<>(), res);
//		return res;
//	}


 private boolean isValid(String s) {
		if (s == null || s.length() <= 0 || s.length() > 3) {
			return false;
		}
		if (s.charAt(0) == '0' && s.length() > 1) {
			return false;
		}
		if (s.length() == 3 && Integer.parseInt(s) > 255) {
			return false;
		}
		
		return true;
	}
	
	private void dfs(String s, int index, int count, List<String> item, List<String> res) {
		if (count == 4) {
			//it will not need to continue to do recursion, such as count >= 4
			String sub = s.substring(index);
			if (isValid(sub)) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < item.size(); i++) {
					sb.append(item.get(i) + ".");
				}
				sb.append(sub);
				res.add(sb.toString());
				
			}
			return ;
		}
		
		for (int i = index; i < index + 3 && i < s.length() - 1; i++) {
			String sub = s.substring(index, i + 1);
			if (isValid(sub)) {
				item.add(sub);
				//System.out.println(s.substring(i + 1));
				dfs(s, i + 1, count + 1, item, res);
				item.remove(item.size() - 1);
			}
		}
	}
	
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		if (s == null || s.length() < 4 || s.length() > 12) {
			return res;
		} 
		dfs(s, 0, 1, new ArrayList<>(), res);
		return res;
	}
}

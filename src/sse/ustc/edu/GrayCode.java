package sse.ustc.edu;

public class GrayCode {
    //this problem is difficult to some extent.
    /**
     * 
     * 
     *  n = 0: 0
     *  n = 1: 0, 1
     *  n = 2: 00, 01, 11, 10  (0, 1, 3, 2)
     *  n = 3: 000, 001, 011, 010, 110, 111, 101, 100 (0, 1, 3, 2, 6, 7, 5, 4) 
     *  以n = 3为例，grey code中前4个包括了n = 2的所有gray code。后4个则是前4个逆序后加上2^2。
     *  推广：n = i的grey code的前一半包括了n = i-1的所有grey code，而后一半则为前一半逆序后家上2^(i-1)。 
     * 
     */
     //solution 1:
//     public List<Integer> grayCode(int n) {
// 		List<Integer> res = new ArrayList<>();
// 		res.add(0);
		
// 		for (int i = 1; i <= n; i++) {
// 			int size = res.size();
// 			for (int j = size - 1; j >= 0; j --) {
// 				int element = res.get(j);
				
// 				res.add(element + (1 << (i - 1)));
// 			}
// 		}
// 		return res;
// 	}
	
	//solution 2: recursive
	public List<Integer> grayCode(int n) {
	    if(n == 0) {
	        List<Integer> res = new ArrayList<>();
	        res.add(0);
	        return res;
	    }
	    List<Integer> temp = grayCode(n - 1);
	    int addNumber = 1 << (n - 1);
	    for(int i = temp.size() - 1; i >= 0; i --) {
	        temp.add(temp.get(i) + addNumber);
	    }
	    return temp;
	}
}

package sse.ustc.edu;

public class ReverseInteger {

	public int reverse(int x) {
        long result = 0;
        int mod = -1;
        long quotients = -1;
        if(x >= 0) {
        	quotients = x;
        }
        else {
			quotients = -(long)x;
		}
		
		long int_max = Integer.MAX_VALUE;
        do {
         	mod = (int) (quotients % 10);
         	quotients = quotients / 10;
         	result = result * 10 + mod;
         	
         	/*check whether it is overflow*/
         	if(result > int_max)
         	    return 0;
         	
 		}while (quotients > 0);
         
         if(x >= 0) {
        	 return (int)result;
         }
         else {
 			return -(int)result;
 		}
    }
//    public static void main(String[] args) {
//		System.out.println(new Solution().reverse(-2147483648));
//	}
}

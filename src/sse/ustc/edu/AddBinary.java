package sse.ustc.edu;

public class AddBinary {
	 //solution 1: transformate binary to decimal
    // private long getValue(char[] arr) {
    //     long value = 0;
    //     for(int i = 0; i < arr.length; i ++)
    //         value = value * 2 + arr[i] - '0';
    //     return value;
    // }
    
    // private String numberToBinaryBit(long num) {
    //     StringBuilder sb = new StringBuilder();
    //     if(num == 0)
    //         return "0";
    //     long remainder = 0;
    //     while(num != 0) {
    //         remainder = num % 2;
    //         num /= 2;
    //         sb.append(remainder);
    //     }
        
    //     return sb.reverse().toString();
    // }
    
    // public String addBinary(String a, String b) {
    //     if(a == null || b == null || a.length() == 0 || b.length() == 0)
    //         throw new IllegalArgumentException();
    //     char[] arra = a.toCharArray();
    //     char[] arrb = b.toCharArray();
        
    //     long c = getValue(arra) + getValue(arrb);
    //     return numberToBinaryBit(c);
    // }
    
    
    public String addBinary(String a, String b) {
    	if (a == null || a.length() == 0) {
			return b;
		}
    	if (b == null || b.length() == 0) {
			return a;
		}
    	char[] arra = a.toCharArray();
    	char[] arrb = b.toCharArray();
    	
    	StringBuilder sb = new StringBuilder();
    	int carry = 0;
    	
    	int i = arra.length - 1;
    	int j = arrb.length - 1;
    	for ( ; i >= 0 && j >= 0; i --, j --) {
			int digit = arra[i] - '0' + arrb[j] - '0' + carry;
			carry = digit / 2;
			digit = digit % 2;
			sb.append(digit);
		}
    	System.out.println(sb.toString());
    	while(i >= 0) {
    		int digit = arra[i] - '0' + carry;
    		carry = digit / 2;
			digit = digit % 2;
			sb.append(digit);
			i --;
    	}
    	
    	while(j >= 0) {
    		int digit = arrb[j] - '0' + carry;
    		carry = digit / 2;
			digit = digit % 2;
			sb.append(digit);
			j --;
    	}
    	if (carry > 0) {
    		sb.append(carry);
		}
    	
    	
    	return sb.reverse().toString();
    }
}

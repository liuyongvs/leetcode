package sse.ustc.edu;

public class PlusOne {
	 /*the implement if BigInteger is using the int array*/
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i --) {
            int digit = (digits[i] + 1) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
            
            if(carry == 0)
                return digits;
        }

        // if(carry == 1) {
        //     int[] res = new int[digits.length + 1];
        //     res[0] = 1;
        //     return res;
        // }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}

package sse.ustc.edu;

public class Numberof1Bits {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int flag = 1;
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((flag & n) != 0)
                count ++;
            flag = flag << 1;
        }
        
        return count;
    }
}

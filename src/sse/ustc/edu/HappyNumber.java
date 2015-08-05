package sse.ustc.edu;

public class HappyNumber {
	public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int sum = 0;
        while(true) {
            while(n > 0) {
                int remainder = n % 10;
                sum += remainder * remainder;
                n = n / 10;
            }
            if(sum == 1)
                return true;
            if(set.contains(sum))
                return false;
            else
                set.add(sum);
            n = sum;
            sum = 0;
        }
        
    }
}

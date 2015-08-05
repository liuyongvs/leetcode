package sse.ustc.edu;

public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
    	HashMap<Integer, Integer> hashMap = new HashMap<>();
    	for (int i = 0; i < numbers.length; i++) {
			if (hashMap.containsKey(numbers[i])) {
				result[0] = hashMap.get(numbers[i]) + 1;
				result[1] = i + 1;
				return result;
			}
			else {
				hashMap.put(target - numbers[i], i);
			}
		}
    	return null;
    }
    
}

package sse.ustc.edu;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        char[] array = s.toCharArray();
        int value = 0;
        for (int i = 0; i < array.length; i++) {
			value = value * 26 + array[i] - 64;
		}
        return value;
    }
}

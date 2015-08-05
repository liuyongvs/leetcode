package sse.ustc.edu;

public class PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if(rowIndex < 0)
            return res;
        
        res.add(1);
        for(int i = 1; i <= rowIndex; i ++) {
            for(int j = res.size() - 1; j >= 1; j --) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
            res.add(1);
        }
        
        return res;
    }
}

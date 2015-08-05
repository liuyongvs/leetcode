package sse.ustc.edu;

public class Searcha2DMatrix {
    /*first : brute force O(n * m)*/
    /*second : use binary search for every row, O(mlogn)*/
    /*third : from left and bottom, or right top. O(max(m, n))*/
    /*fourth : binary search O(log(mn) = logm + logn)*/
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
    //         return false;
            
    //     int row = matrix.length;
    //     int col = matrix[0].length;
    //     int i = 0;
    //     int j = col - 1;
    //     while(i < row && j >= 0) {
    //         if(matrix[i][j] == target)
    //             return true;
    //         else if(matrix[i][j] > target)
    //             j--;
    //         else
    //             i ++;
    //     }
    //     return false;
    // }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int midValue = matrix[mid / col][mid % col];
            if(midValue < target)
                low = mid + 1;
            else if(midValue > target)
                high = mid - 1;
            else
                return true;
        }
        return false;
        
    }
}

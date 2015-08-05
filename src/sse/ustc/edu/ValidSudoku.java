package sse.ustc.edu;

public class ValidSudoku {
	/*time complexity O(3 * n^2) */
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board[0].length != 9 || board.length != 9)
            return false;
        
        for(int i = 0; i < 9; i ++) {
            boolean[] map = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(map[(int)(board[i][j] - '1')])
                        return false;
                    else
                        map[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        
        for(int i = 0; i < 9; i ++) {
            boolean[] map = new boolean[9];
            for(int j = 0; j < 9; j++) {
                 if(board[j][i] != '.') {
                    if(map[(int)(board[j][i] - '1')])
                        return false;
                    else
                        map[(int)(board[j][i] - '1')] = true;
                }
            }
        }
        
        for(int block = 0; block < 9; block ++) {
            boolean[] map = new boolean[9];
            for(int i = block / 3 * 3; i < block / 3 * 3 + 3; i ++) {
                for(int j = block % 3 * 3; j < block % 3 *3 + 3; j ++) {
                   if(board[j][i] != '.') {
                        if(map[(int)(board[j][i] - '1')])
                            return false;
                        else
                            map[(int)(board[j][i] - '1')] = true;
                    }
                }
            }

        }
        return true;
    }
}

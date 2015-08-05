package sse.ustc.edu;

public class WordSearch {
	 //this is a good problem
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || word.length() == 0)
            return false;
        
        for(int i =0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
               if(dfs(board, i, j, word, 0, new boolean[board.length][board[0].length]))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] isVisited) {
        if(word.length() == index)
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index) || isVisited[i][j])
            return false;
        
        isVisited[i][j] = true;
        if(dfs(board, i - 1, j, word, index + 1, isVisited))
            return true;
            
        if( dfs(board, i + 1, j, word, index + 1, isVisited))
            return true;
        
        if( dfs(board, i, j - 1, word, index + 1, isVisited))
            return true;
        
        if( dfs(board, i, j + 1, word, index + 1, isVisited))
            return true;
        //this statement is equal to the four statement above 
       // boolean res = dfs(board, i - 1, j, word, index + 1, isVisited) || dfs(board, i + 1, j, word, index + 1, isVisited) ||
         //               dfs(board, i, j - 1, word, index + 1, isVisited) || dfs(board, i, j + 1, word, index + 1, isVisited);
        isVisited[i][j] = false;
        return false;
       // return res;
    }
}

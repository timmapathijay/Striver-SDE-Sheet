class Solution {
    private void dfsTraversal(int row, int col, char[][] board, boolean[][] visited, int[][] directions){
        visited[row][col] = true;
        // Connected-Cell
        for(int[] direction : directions)
        {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length 
            && board[newRow][newCol] == 'O' && !visited[newRow][newCol])
            dfsTraversal(newRow, newCol, board, visited, directions);
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // Edge-Traversal
        for(int i = 0; i < cols; i++)
        {
            if(board[0][i] == 'O' && !visited[0][i])
            {
                dfsTraversal(0, i, board, visited, directions);
            }
            if(board[rows - 1][i] == 'O' && !visited[rows - 1][i])
            {
                dfsTraversal(rows - 1, i, board, visited, directions);
            }
        }
        for(int i = 0; i < rows; i++)
        {
            if(board[i][0] == 'O' && !visited[i][0])
            {
                dfsTraversal(i, 0, board, visited, directions);
            }
            if(board[i][cols - 1] == 'O' && !visited[i][cols - 1])
            {
                dfsTraversal(i, cols - 1, board, visited, directions);
            }
        }
        // Make untouched 'O' to surrounded region 
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(board[i][j] == 'O' && !visited[i][j])
                board[i][j] = 'X';
            }
        }
    }
}
// TC : N + M (Edge Traversal) + N * M * 4 (DFS Traversal) + N * M('O' to 'X')
// SC : N * M (Visited) + N * M (Recursive Stack Space)

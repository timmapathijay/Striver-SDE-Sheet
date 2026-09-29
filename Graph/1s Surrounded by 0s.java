class Solution {
    private void dfsTraversal(int row, int col, int[][] grid, 
    boolean[][] visited, int[][] directions)
    {
        visited[row][col] = true;
        // Adjacent-Node (will visit connected 1's to boundary)
        for(int[] direction : directions)
        {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
            && grid[newRow][newCol] == 1 && !visited[newRow][newCol])
            dfsTraversal(newRow, newCol, grid, visited, directions);
            
        }
    }
    public int cntOnes(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[rows][cols];
        int[][] directions = {{-1 , 0}, {0 , 1}, {1 , 0}, {0 , -1}};
        // Boundary - Traverse 
        for(int i = 0; i < cols; i++)
        {
            // first-row
            if(grid[0][i] == 1 && !visited[0][i])
            dfsTraversal(0, i, grid, visited, directions);
            
            // last-row
            if(grid[rows - 1][i] == 1 && !visited[rows - 1][i])
            dfsTraversal(rows - 1, i, grid, visited, directions);
            
        }
        for(int j = 0; j < rows; j++)
        {
            // first-column
            if(grid[j][0] == 1 && !visited[j][0])
            dfsTraversal(j, 0, grid, visited, directions);
            
            // last-column
            if(grid[j][cols - 1] == 1 && !visited[j][cols - 1])
            dfsTraversal(j, cols - 1, grid, visited, directions);

        }
        
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1 && !visited[i][j])
                ans++;
            }
        }
        return ans;
    }
};

// TC : N + M + (N * M * 4)[DFS Traversal] + N * M (Compute ans)
// SC : N * M (Visited Array) + (N + M)[Recursive Stack Space]

class RottenOrange{
    int row, col, time;
    public RottenOrange(int row, int col, int time)
    {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] matrix) {
        int[][] grid = matrix;
        int rows = grid.length;
        int cols = grid[0].length;
        int minimumTime = 0, freshOrangesCount = 0;
        int[][] directions = {{-1 , 0}, {0 , 1}, {1 , 0}, {0 , -1}};
        Queue<RottenOrange> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 2)
                queue.add(new RottenOrange(i, j, 0));
                else if(grid[i][j] == 1)
                freshOrangesCount += 1;
            }
        }
        // BFS - Traversal (Radially-Move)
        while(!queue.isEmpty())
        {
            RottenOrange rottenOrange = queue.poll();
            minimumTime = Math.max(minimumTime , rottenOrange.time);
            // Rotting adjacent oranges 
            for(int[] direction : directions)
            {
                int newRow = rottenOrange.row + direction[0];
                int newCol = rottenOrange.col + direction[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1)
                {
                    queue.add(new RottenOrange(newRow, newCol, rottenOrange.time + 1));
                    grid[newRow][newCol] = 2;
                    freshOrangesCount -= 1;
                }
            }
        }
        return freshOrangesCount == 0 ? minimumTime : -1;
    }
}
// TC : rows * cols (to add rotten oranges) + rows * cols * 4 (bfs) 
// SC : rows * cols (grid) + rows * cols (queue)

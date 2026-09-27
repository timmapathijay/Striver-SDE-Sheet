class Cell{
    int row, col, distance;
    public Cell(int row, int col, int distance)
    {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] directions = {{-1 , 0}, {0 , 1}, {1 , 0}, {0 , -1}};
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++)
        {
            ans.add(new ArrayList<>(Collections.nCopies(cols, -1)));   
        }
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    queue.add(new Cell(i, j, 0));
                    ans.get(i).set(j , 0);
                }
            }
        }
        
        // BFS-Traversal to find distance with 1 for each cell having 0
        while(!queue.isEmpty())
        {
            Cell cell = queue.poll();
            for(int[] direction : directions)
            {
                int newRow = cell.row + direction[0];
                int newCol = cell.col + direction[1];
                if(newRow >= 0 && newRow < rows && newCol >= 0 
                && newCol < cols && ans.get(newRow).get(newCol) == -1)
                {
                    queue.add(new Cell(newRow, newCol, cell.distance + 1));
                    ans.get(newRow).set(newCol , cell.distance + 1);
                }
            }
            
        }
        return ans;
    }
}

// TC : N * M + N * M (Adding all 1's in queue) + N * M * 4 (BFS Traversal)
// SC : N * M (Queue)



class Solution {
    private void dfsTraversal(int row, int col, int[][] image, int originalColor, 
    int newColor, int[][] directions, boolean[][] visited){
        image[row][col] = newColor;
        visited[row][col] = true;
        // Adjacent-Node
        for(int[] direction : directions)
        {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length 
            && image[newRow][newCol] == originalColor && !visited[newRow][newCol])
            {
                dfsTraversal(newRow, newCol, image, originalColor, newColor, directions, visited);
            }
        }
        
    }
    public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {
        int[][] image = grid;
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int originalColor = image[sr][sc];
        int[][] directions = {{-1, 0}, {0 , 1}, {1 , 0}, {0 , -1}};
        dfsTraversal(sr, sc, image, originalColor, newColor, directions, visited);
        return image;
    }
}
// TC : N * M * 4 
// SC : N * M (Recursive Stack Space) + N * M (Visited Array)

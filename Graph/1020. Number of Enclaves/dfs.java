class Solution {

    void dfs(int[][] grid, int i, int j){

        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return;
        }

        grid[i][j] = 0; // Marking as visited

        // For Left Right Up Down
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;


        for(int row=0; row<m; row++){
            // First Column
            if(grid[row][0] == 1) dfs(grid, row, 0);
            
            // Last Column
            if(grid[row][n-1] == 1) dfs(grid, row, n-1);
        }

        for(int colm=0; colm<n; colm++){
            // First Row
            if(grid[0][colm] == 1) dfs(grid, 0, colm);

            // Last Row
            if(grid[m-1][colm] == 1) dfs(grid, m-1, colm);
        }

        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    count++; // count no of 1s present
                }
            }
        }

        return count;
    }
}

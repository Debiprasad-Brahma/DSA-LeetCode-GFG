class Solution {
    
    void solve(int i, int j, int row, int col, ArrayList<String> list, int[][]maze, String str, int[][]visited){
        
        // Add if reach destination
        if(i == row - 1 && j == col - 1){
            list.add(str);
            return;
        }
        
        
        visited[i][j] = 1; // when entering mark 1
        
        // Go Down
        if(i + 1 < row && visited[i + 1][j] == 0 && maze[i + 1][j] == 1){
            solve(i + 1, j, row, col, list, maze, str + 'D', visited);

        }
        
        // Go Up
        if(i - 1 >= 0 && visited[i - 1][j] == 0 && maze[i - 1][j] == 1){
            solve(i - 1, j, row, col, list, maze, str + 'U', visited);
        }
        
        // Go Left
        if(j - 1 >= 0 && visited[i][j - 1] == 0 && maze[i][j - 1] == 1){
            solve(i, j - 1, row, col, list, maze, str + 'L', visited);
        }
        
        // Go Right
        if(j + 1 < col && visited[i][j + 1] == 0 && maze[i][j + 1] == 1){
            solve(i, j + 1, row, col, list, maze, str + 'R', visited);
        }
        
        visited[i][j] = 0; // when leaving mark 0
    }  
    
    public ArrayList<String> ratInMaze(int[][] maze) {

        int row = maze.length;
        int col = maze[0].length;
        
        int [][] visited = new int[row][col];
        
        ArrayList<String> list = new ArrayList<>();
        
        if(maze[0][0] == 1) solve(0, 0, row, col, list, maze, "", visited);
        Collections.sort(list);
        return list;
    }
    
   
}

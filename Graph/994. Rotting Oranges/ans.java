// Leet Code
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();
        int fresh = 0; // for count of fresh orange present

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){ // if already rotten add to queue;
                    que.offer(new int[]{i, j});
                }
                else  if(grid[i][j] == 1) fresh++; // count fresh oranges
            }
        }

        if(fresh == 0 ) return 0; // if after traversal no fresh orange is present

        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // the direction from a place we can traverse
        int min = 0; // coutn minutes 

        while(!que.isEmpty()){
            int size = que.size();

            while(size-- > 0){ // for multiple bfs 
                int[] curr = que.poll();
                int i = curr[0];
                int j = curr[1];

                for(int [] dir : direction){
                    int new_i = i + dir[0]; // for new rotten orange
                    int new_j = j + dir[1]; 

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1){ // check if i and j are valid in grid
                        grid[new_i][new_j] = 2; // make that rotten
                        fresh--; // decrease the no of fresh oranges
                        que.offer(new int[]{new_i, new_j}); // add the new rotten orange into queue for forther process on that
                    }   
                }
            }
            
            min++; // count minutes
        }
        
        return fresh == 0 ? (min - 1)  : -1; // check for if (fresh =! 0)
    }
}

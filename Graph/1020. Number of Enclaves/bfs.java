class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        // Add all boundary land cells to queue
        for (int row = 0; row < m; row++) {
            if (grid[row][0] == 1) {
                q.offer(new int[]{row, 0});
                grid[row][0] = 0;
            }
            if (grid[row][n - 1] == 1) {
                q.offer(new int[]{row, n - 1});
                grid[row][n - 1] = 0;
            }
        }

        for (int col = 0; col < n; col++) {
            if (grid[0][col] == 1) {
                q.offer(new int[]{0, col});
                grid[0][col] = 0;
            }
            if (grid[m - 1][col] == 1) {
                q.offer(new int[]{m - 1, col});
                grid[m - 1][col] = 0;
            }
        }

        // Directions for BFS
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS traversal
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0], j = cell[1];

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                    grid[ni][nj] = 0;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        // Count remaining land cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) count++;
            }
        }

        return count;
    }
}

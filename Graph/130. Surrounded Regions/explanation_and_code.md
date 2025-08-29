# Surrounded Regions (DFS Approach)

## Intuition
The problem asks us to capture all regions surrounded by `'X'`. An `'O'` should remain unchanged only if it is connected to the border (directly or indirectly).  
So, the key idea is:  
- Start from all border `'O'`s, run DFS/BFS, and mark them as safe.  
- After that, flip all unmarked `'O'`s to `'X'`, because they are surrounded.  
- Finally, convert marked safe cells back to `'O'`.

## Approach
1. Traverse the **first and last row** and the **first and last column** of the board.  
2. Whenever we see an `'O'` on the border, we run DFS to mark all connected `'O'` cells as **safe** (temporarily marked as `'#'`).  
3. After DFS is complete:
   - Convert all remaining `'O'` to `'X'` (they are captured).  
   - Convert all `'#'` back to `'O'` (they are safe and connected to the border).  

This ensures only surrounded regions are captured.

## Complexity

### Time Complexity
- **O(m × n)**  
  - We potentially visit each cell once during the DFS and again while flipping characters.

### Space Complexity
- **O(m × n)** in the worst case (recursion stack for DFS if the board is filled with `'O'`).  
- If BFS with a queue is used, auxiliary space is still **O(m × n)**.

---

## Java Code

```java
class Solution {

    void dfs(char[][] board, int i, int j) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#'; // mark as safe temporarily

        dfs(board, i, j+1);
        dfs(board, i, j-1);
        dfs(board, i+1, j);
        dfs(board, i-1, j);
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        // Step 1: DFS from borders
        for (int r = 0; r < m; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][n-1] == 'O') dfs(board, r, n-1);
        }
        for (int c = 0; c < n; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[m-1][c] == 'O') dfs(board, m-1, c);
        }

        // Step 2: Flip captured regions
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X'; // surrounded region
                if (board[i][j] == '#') board[i][j] = 'O'; // safe region
            }
        }
    }
}

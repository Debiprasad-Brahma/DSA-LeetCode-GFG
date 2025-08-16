# 🖌️ Flood Fill (BFS & DFS)

## 📌 Problem
You are given a 2D grid `image` representing an image, where each cell has an integer value (color).  
Starting from a pixel `(sr, sc)`, **flood fill** the image by changing the color of the starting pixel and all **4-directionally connected** pixels with the same original color to a new `color`.

- Directions allowed: **up, down, left, right**.  
- Diagonal connections are **not considered**.  

**Constraints:**
- 1 ≤ `image.length, image[0].length` ≤ 50  
- 0 ≤ `image[i][j], color` < 2^16  
- 0 ≤ `sr` < `image.length`  
- 0 ≤ `sc` < `image[0].length`  

---

## 💡 Intuition
- This problem is similar to **graph traversal** on a 2D matrix.  
- Each pixel is like a **node**, and edges exist between **adjacent pixels** of the same color.  
- Starting from `(sr, sc)`, we need to **recolor all reachable pixels** with the same original color.  
- We can solve this with:
  - **DFS (recursion)** → explores depth-first.  
  - **BFS (queue)** → explores level-by-level.  

---

## 📝 Algorithm
1. Store the `originalColor = image[sr][sc]`.  
2. If `originalColor == color`, return the image (no changes needed).  
3. Use **BFS or DFS** to traverse from `(sr, sc)`:
   - For each valid neighbor `(x, y)`:
     - If its color equals `originalColor`, recolor it to `color`.  
     - Continue traversal.  
4. Stop when all reachable connected pixels are recolored.  
5. Return the modified `image`.  

---

## ⏱️ Complexity Analysis
- **Time Complexity:**  
  - `O(m * n)` where `m` = rows, `n` = columns.  
  - In the worst case, we might visit all cells once.  

- **Space Complexity:**  
  - **DFS (recursive):** `O(m * n)` in the worst case (stack depth in recursion).  
  - **BFS (queue):** `O(m * n)` for storing nodes in the queue.  

---

## 🧑‍💻 Code (BFS - Iterative)
```java
import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];

        if(originalColor == color) return image; // nothing to change

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!que.isEmpty()){
            int[] curr = que.poll();
            int i = curr[0];
            int j = curr[1];

            for(int[] dir : directions){
                int new_i = i + dir[0];
                int new_j = j + dir[1];

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n 
                   && image[new_i][new_j] == originalColor){
                    image[new_i][new_j] = color;
                    que.offer(new int[]{new_i, new_j});
                }
            }
        }
        return image;
    }
}
```
## 🧑‍💻 Code (DFS - Recursive)
```java
import java.util.*;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor != color)
            dfs(image, sr, sc, originalColor, color);
        return image;
    }

    private void dfs(int[][] image, int i, int j, int originalColor, int color) {
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length 
           || image[i][j] != originalColor) return;

        image[i][j] = color;

        dfs(image, i+1, j, originalColor, color);
        dfs(image, i-1, j, originalColor, color);
        dfs(image, i, j+1, originalColor, color);
        dfs(image, i, j-1, originalColor, color);
    }
}

```

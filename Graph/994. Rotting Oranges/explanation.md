# 🍊 Rotting Oranges Problem - README  

## Intuition  
The problem is like a spreading infection: every rotten orange can rot its adjacent fresh oranges in one minute.  
So, the natural idea is to simulate this process using **Breadth First Search (BFS)**, where each rotten orange at the current time infects its neighboring fresh oranges, and then those become rotten for the next round.  
If after the process some fresh oranges remain, it means they were isolated and could never rot → return `-1`.  

---

## Approach  
1. **Traverse the grid once:**  
   - Count all fresh oranges.  
   - Push all initially rotten oranges into a queue (BFS starting points).  

2. **BFS Traversal:**  
   - While the queue is not empty, process each level (represents one minute).  
   - For each rotten orange in the queue, check its **four directions** (up, down, left, right).  
   - If a neighboring cell has a fresh orange (`1`):  
     - Turn it rotten (`2`).  
     - Decrease the fresh orange count.  
     - Add this newly rotten orange to the queue.  

3. **Time Counting:**  
   - After processing one full BFS level, increment the minute counter.  

4. **Final Check:**  
   - If no fresh oranges are left, return `(minutes - 1)`.  
   - Otherwise, return `-1`.  

---

## Example  
**Input:**  
```
grid = [[2,1,1],
        [1,1,0],
        [0,1,1]]
```

**Output:**  
```
4
```

**Explanation:**  
- Minute 0: Rotten at (0,0).  
- Minute 1: (0,1) and (1,0) become rotten.  
- Minute 2: (0,2) and (1,1) become rotten.  
- Minute 3: (2,1) becomes rotten.  
- Minute 4: (2,2) becomes rotten.  

All oranges are rotten in **4 minutes**.  

---

## Complexity Analysis  
- **Time Complexity:** `O(m * n)` → We visit each cell at most once.  
- **Space Complexity:** `O(m * n)` in the worst case → The queue can store all oranges.  

---

## ✅ Summary  
We use BFS to spread the rot level by level, keeping track of minutes and fresh oranges.  
If all oranges rot, return the time taken; otherwise, return `-1`.  

---

## Java Code  
```java
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
        int min = 0; // count minutes 

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
        
        return fresh == 0 ? (min - 1)  : -1; // check for if (fresh != 0)
    }
}
```

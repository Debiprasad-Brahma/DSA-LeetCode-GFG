# Depth First Search (DFS) in Java

## 🧠 Intuition
Depth First Search (DFS) is a graph traversal algorithm that explores as far as possible along a branch before backtracking.  
Think of it as going down one path completely before trying other paths.

In this problem, we are given a graph in the form of an **adjacency list**. We need to visit all vertices starting from a given source node (or all components if the graph is disconnected) using DFS.

---

## 📜 Approach
1. **Visited Array**  
   - Use a boolean array `visited[]` to track which vertices have been visited to avoid revisiting and infinite loops.

2. **Recursive DFS Function (`dfsUtil`)**  
   - Mark the current node as visited.
   - Add it to the result list `ans`.
   - Recursively visit each unvisited neighbor.

3. **Handling Disconnected Graphs**  
   - Loop over all vertices in the main `dfs()` method.
   - If a vertex is not visited, call `dfsUtil()` on it to ensure all components are covered.

4. **Adjacency List Access**  
   - Pass `adj` into the recursive function to access neighbor information.

---

## 💻 Code
```java
import java.util.ArrayList;

class Solution {
    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        if (adj == null) return ans;

        int n = adj.size();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfsUtil(adj, visited, i);
            }
        }
        return ans;
    }

    void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node) {
        visited[node] = true;
        ans.add(node);

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfsUtil(adj, visited, neighbour);
            }
        }
    }
}

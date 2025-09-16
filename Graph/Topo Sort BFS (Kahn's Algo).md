# Topological Sort using Kahn's Algorithm (BFS)

## 📌 Problem
Perform **Topological Sorting** on a Directed Acyclic Graph (DAG) using **Kahn's Algorithm**.  
The algorithm ensures that for every directed edge `u → v`, vertex `u` comes before `v` in the ordering.

---

## 🧠 Intuition
- Topological sort is only possible for **DAGs**.  
- The idea is to repeatedly remove nodes with **indegree = 0** (no incoming edges) and reduce the indegree of their neighbors.  
- If a neighbor’s indegree becomes 0, push it into the queue.  
- Continue until all nodes are processed.

---

## 🚀 Approach (Step by Step)
1. **Convert edge list to adjacency list**  
   Build a graph representation for easier traversal.
   
2. **Calculate indegrees**  
   Count how many incoming edges each vertex has.

3. **Initialize queue**  
   Push all vertices with `indegree = 0` into a queue.

4. **Process queue (BFS)**  
   - Pop a node, add it to the result list.  
   - For each neighbor, decrease its indegree by 1.  
   - If any neighbor’s indegree becomes 0, add it to the queue.

5. **Return result**  
   The order of removal gives a valid topological ordering.

---

## ⏱️ Complexity Analysis
- **Time Complexity:** `O(V + E)`  
  - Each vertex is added once to the queue.  
  - Each edge is considered exactly once while decreasing indegree.
- **Space Complexity:** `O(V + E)`  
  - Adjacency list + indegree array + queue.

---

## 💻 Code Implementation
```java
//GFG

import java.util.*;

class Solution {
    public static ArrayList<Integer> topoSort(int v, int[][] edges) {
        // Step 1: Convert to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] node : edges) {
            adj.get(node[0]).add(node[1]); // Directed edge u → v
        }

        // Step 2: Compute indegree
        int[] indeg = new int[v];
        for (int i = 0; i < v; i++) {
            for (int node : adj.get(i)) {
                indeg[node]++;
            }
        }

        // Step 3: Push nodes with indegree 0 into queue
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indeg[i] == 0)
                que.offer(i);
        }

        // Step 4: Process queue (BFS)
        ArrayList<Integer> ans = new ArrayList<>();
        while (!que.isEmpty()) {
            int node = que.poll();
            ans.add(node);

            for (int n : adj.get(node)) {
                indeg[n]--;
                if (indeg[n] == 0) {
                    que.offer(n);
                }
            }
        }

        return ans;
    }
}

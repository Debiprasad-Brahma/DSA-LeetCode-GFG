# Cycle Detection in Directed Graph

This project contains a Java implementation to detect whether a directed graph contains a cycle.  
It uses **Kahn's Algorithm (Topological Sort using BFS)**.

---

## 📌 Problem Statement
Given a directed graph with `V` vertices and a list of directed edges, determine whether the graph contains a cycle.

- If the graph contains a cycle → return **true**  
- If the graph does not contain a cycle → return **false**

---

## ⚡ Approach: Kahn's Algorithm (BFS)
1. Build the **adjacency list** from the given edges.
2. Compute the **indegree** of each vertex.
3. Add all vertices with indegree `0` into a queue.
4. Perform **BFS (Topological Sort)**:
   - Remove a node from the queue.
   - Reduce the indegree of its neighbors.
   - If a neighbor’s indegree becomes `0`, add it to the queue.
5. Keep a count `cnt` of how many nodes are processed.
6. If `cnt == V`, then all nodes were processed → **No cycle exists**.  
   If `cnt < V`, then some nodes were not processed (stuck in a cycle) → **Cycle exists**.

---

## ✅ Corrected Code

```java
import java.util.*;

class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int[] node : edges) {
            adj.get(node[0]).add(node[1]); // a → b
        }

        int[] indeg = new int[V];
        for (int i = 0; i < V; i++) {
            for (int node : adj.get(i)) {
                indeg[node]++;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) {
                que.offer(i);
            }
        }

        int cnt = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            cnt++;

            for (int n : adj.get(node)) {
                indeg[n]--;
                if (indeg[n] == 0) {
                    que.offer(n);
                }
            }
        }

        return cnt != V; // true if cycle exists
    }
}

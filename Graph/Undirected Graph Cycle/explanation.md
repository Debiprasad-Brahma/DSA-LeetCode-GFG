# 🔄 Cycle Detection in an Undirected Graph (DFS)

## 📌 Problem
Given an undirected graph with `V` vertices and a list of `edges`, determine if the graph contains a **cycle**.  
- The graph is undirected.  
- `edges` is given as an **edge list** (each element is a pair `[u, v]` representing an edge between vertices `u` and `v`).  

---

## 💡 Intuition
- We need to check whether there exists a cycle in the graph.  
- A cycle in an undirected graph means that during traversal, we revisit a vertex that is **already visited and not the parent** of the current vertex.  
- We use **DFS traversal**:
  1. Start DFS from every unvisited node.  
  2. While traversing neighbors:
     - If the neighbor is unvisited → recursively call DFS.  
     - If the neighbor is already visited and **not the parent**, then a cycle exists.  
  3. If DFS finishes without finding such a condition, no cycle exists.  

---

## 📝 Algorithm
1. Maintain a `visited[]` array to track visited vertices.  
2. Iterate over all vertices `0..V-1`.  
   - If a vertex is unvisited, call DFS on it.  
3. In DFS:
   - Mark the current node as visited.  
   - For each edge connected to this node:
     - Determine the neighbor (`u` or `v`).  
     - If neighbor is not visited → DFS on it.  
     - If neighbor is visited and not the parent → cycle found.  
4. If any DFS call detects a cycle, return `true`.  
5. Otherwise, return `false`.  

---

## 🧑‍💻 Code

```java
class Solution {
    public boolean isCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycleDFS(i, -1, visited, edges)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleDFS(int node, int parent, boolean[] visited, int[][] edges) {
        visited[node] = true;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u == node || v == node) { // edge connected to node
                int neighbor = (u == node) ? v : u;

                if (!visited[neighbor]) {
                    if (isCycleDFS(neighbor, node, visited, edges)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true; // cycle found
                }
            }
        }
        return false;
    }
}

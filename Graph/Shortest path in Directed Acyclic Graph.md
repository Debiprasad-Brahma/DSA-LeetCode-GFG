# Shortest Path in Directed Acyclic Graph (DAG)

This project contains a Java implementation to find the **shortest path** in a **Directed Acyclic Graph (DAG)** using **Topological Sorting**.

---

## 🚀 Problem Statement
Given a **Directed Acyclic Graph (DAG)** with `V` vertices and `E` weighted edges, the task is to find the shortest path from **source node `0`** to all other vertices.  

If a vertex is **not reachable**, return `-1` for that vertex.

---

## 📌 Approach

1. **Graph Representation**  
   - Use adjacency list with a custom `Pair` class to store `(vertex, weight)`.

2. **Topological Sort (DFS-based)**  
   - Perform DFS and push nodes onto a stack once all adjacent nodes are visited.

3. **Relax Edges in Topological Order**  
   - Initialize `dist[0] = 0` (source node) and others as `∞`.  
   - For each popped node, relax all outgoing edges.

4. **Handle Unreachable Nodes**  
   - Convert distances with `∞` to `-1`.

---

## 🧑‍💻 Code

```java

class Solution {
    
    // Pair Class
    class Pair{
        int v, w;
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    
    // Function for Toposort
    void topoSort(int node, boolean[] visited, Stack<Integer> stk, ArrayList<ArrayList<Pair>> adj){
        visited[node] = true;
        
        for(Pair edge : adj.get(node)){
            if(!visited[edge.v])
            topoSort(edge.v, visited, stk, adj);
        }
        stk.push(node);
    }
    
    public int[] shortestPath(int V, int E, int[][] edges) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] arr : edges){
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }
        
        boolean[] visited = new boolean[V];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort(i, visited, stk, adj);
            }
        }
        
        // Finding the distance
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Assigning the source
        
        while(!stk.isEmpty()){
            int u = stk.pop();
            if(dist[u] != Integer.MAX_VALUE){
                for(Pair edge : adj.get(u)){
                    if(dist[u] + edge.w < dist[edge.v]){
                        dist[edge.v] = dist[u] + edge.w;
                    }
                }
            }
        }
        
        for(int i=0; i < V; i++){
            if(dist[i] == Integer.MAX_VALUE)
            dist[i] = -1;
        }
        
        return dist;
    }
}

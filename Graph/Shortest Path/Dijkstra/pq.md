# Dijkstra’s Algorithm – Java Implementation

---

## Problem
Find the shortest distance from a **source node** to all other nodes in a weighted undirected graph using **Dijkstra’s Algorithm**.

---

## Intuition
Dijkstra’s algorithm works by:
- Starting from the source node with distance `0`.
- Expanding to the nearest unvisited node using a **min-heap (priority queue)**.
- Updating shortest distances to its neighbors.
- Repeating until all nodes are processed.

This ensures we always pick the shortest path available at each step.

---

## Approach
1. **Graph Representation**  
   - Use an adjacency list to store neighbors and weights.  
   - Each edge is stored as `(vertex, weight)` using a custom `Pair` class.  

2. **Initialization**  
   - Distance array `dist` initialized with `Integer.MAX_VALUE`.  
   - Set `dist[src] = 0`.  
   - Min-heap (`PriorityQueue`) to process nodes with the smallest distance first.  

3. **Relaxation Process**  
   - Pop the node with the smallest tentative distance.  
   - If we find a shorter path to its neighbors, update and push them into the priority queue.  

4. **Result**  
   - After processing, `dist[]` contains the shortest distance from `src` to every vertex.  

---

## Code

```java
import java.util.*;

class Solution {
    
    // Pair Class for adjacency list and PQ
    class Pair implements Comparable<Pair> {
        int v; // vertex
        int w; // weight
        Pair(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Pair other) {
            return this.w - other.w; // min-heap based on weight
        }
    }
    
    public int[] dijkstra(int V, int[][] edges, int src) {
        // Convert to adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
       
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // Undirected graph
        }
        
        // Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        
        // Min-heap for shortest distance
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.v;
            int d = curr.w;
            
            // Skip if this path is not better
            if (d > dist[node]) continue;
            
            // Relaxation
            for(Pair nei : adj.get(node)){
                if (dist[node] + nei.w < dist[nei.v]) {
                    dist[nei.v] = dist[node] + nei.w;
                    pq.add(new Pair(nei.v, dist[nei.v]));
                }
            }
        }
        
        return dist;
    }
}

# 📌 Topological Sort in Java

This repository contains a Java implementation of **Topological Sorting** of a Directed Acyclic Graph (DAG) using **DFS (Depth First Search) + Stack**.

---

## 📖 Problem Statement
Given a directed graph with `v` vertices and a list of edges, return the **topological ordering** of the vertices.  
A topological ordering is a linear ordering of vertices such that for every directed edge `u → v`, vertex `u` comes **before** `v` in the ordering.

---

## 🚀 Approach
1. Represent the graph as an **adjacency list**.
2. Use a **DFS traversal** to explore the graph.
3. After visiting all neighbors of a node, push it onto a **stack**.
4. Once DFS completes for all nodes, pop elements from the stack to get the **topological ordering**.

---

## 🧩 Code

```java

// GFG

import java.util.*;

class Solution {
    
    public static ArrayList<Integer> topoSort(int v, int[][] edges) {
        
        Stack<Integer> stk = new Stack<>();
        
        // Converting to adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int[] node : edges) {
            adj.get(node[0]).add(node[1]); // a → b
        }
        
        boolean[] visited = new boolean[v];
        
        for(int i=0; i < v; i++){
            if(!visited[i]){
                dfs(i, visited, adj, stk);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!stk.isEmpty()) {
            ans.add(stk.pop());
        }
        return ans;
    }
    
    private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk){
        visited[node] = true;
        
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, visited, adj, stk);
            }
        }
        stk.push(node); // ✅ Correct push (not neighbour)
    }
}

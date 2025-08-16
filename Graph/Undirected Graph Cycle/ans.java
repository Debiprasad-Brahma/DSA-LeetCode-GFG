/// GFG
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

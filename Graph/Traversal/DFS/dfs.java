// GFG solution
class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer> ans = new ArrayList<>();
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[adj.size()];
        dfsUtil(adj, visited, 0);
        return ans;
    }
    
    void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;
        ans.add(node);
        
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
              dfsUtil(adj, visited, neighbour);
            }
           
        }
    }
}

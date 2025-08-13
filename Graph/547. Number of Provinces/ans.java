// Leet Code - 547
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, isConnected, i);
                count++; // found a new province
            }
        }
        return count;
    }

    void dfs(boolean[] visited, int[][] isConnected, int node){
        visited[node]= true;
        for(int i=0; i< isConnected.length; i++){
           if (isConnected[node][i] == 1 && !visited[i]) {
                dfs(visited, isConnected, i);
            }
        }
    }
}

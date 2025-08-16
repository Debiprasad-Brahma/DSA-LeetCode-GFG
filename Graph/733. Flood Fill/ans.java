class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];
        if(originalColor == color) return image; // nothing to do
        image[sr][sc] = color; // making first color

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr, sc});

        int[][] direction = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // this directions from a place we can traverse
        while(!que.isEmpty()){
                int[] curr = que.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] dir : direction){
                int new_i = i + dir[0];
                int new_j = j + dir[1];
                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && image[new_i][new_j] == originalColor){
                    image[new_i][new_j] = color;
                    que.offer(new int[]{new_i, new_j});
                } 
            }
        }
        return image;
    }
}

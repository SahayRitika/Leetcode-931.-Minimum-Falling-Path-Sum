class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int dp[][]= new int[n][m];
        for(int[] row:dp)
        Arrays.fill(row,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            dp[0][i]= grid[0][i];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int ele= dp[i-1][j];
                for(int k=0;k<m;k++){
                    if(k!=j){
                    dp[i][k]= Math.min(dp[i][k] ,(ele+grid[i][k]));
                    }
                }
            }
        }
        // for(int i=0;i<m;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int minn= Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            minn= Math.min(minn, dp[n-1][j]);
        }
        return minn;
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        // for(int[] row:dp)Arrays.fill(row,-101);
        int minn=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            dp[0][j]=matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=dp[i-1][j];
                int left=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                if(j>0)left=dp[i-1][j-1];
                if(j<m-1)right=dp[i-1][j+1];
                dp[i][j]=Math.min(up,Math.min(left,right))+matrix[i][j];
            }
        }
        for(int j=0;j<m;j++){
            minn=Math.min(minn,dp[n-1][j]);
        }
        return minn;
    }
}

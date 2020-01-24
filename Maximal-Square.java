/**
LeetCode Submitted : YES
Space Complexity : Matrix*Matrix
Time Complexity : O(Matrix*Matrix)

The idea is to use DP array to store previous max number of 1 at each position by finding nearby ones at each horizontal, vertical and diagonal positions. Find minimum value from (horizontal, vertical and diagonal) and then storing largest possible square length. Lastly, return square of the length.

**/
class Solution {
    int[][] dp;
    int m;
    int n;
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length < 1)
            return 0;
        
        m = matrix.length;
        n = matrix[0].length;
        
        dp = new int[m+1][n+1];
        
        int l = 0;
        
        for(int i = 1; i<=m;i++){
            for(int j = 1; j<=n;j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    l = Math.max(l,dp[i][j]);  
                }
            }
        }
        return l * l;
    }
}

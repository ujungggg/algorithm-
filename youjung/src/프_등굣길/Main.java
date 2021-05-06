package ÇÁ_µî±·±æ;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int m = 4;
		int n = 3;
		int[][] puddles = {{2,2}};
		
		solution(m,n,puddles);
	}
    public static int solution(int m, int n, int[][] puddles) {
    	
    	long[][] dp = new long[n+2][m+2];

    	for(int i=0;i<puddles.length;i++){
    		int x = puddles[i][0];
    		int y = puddles[i][1];
    		
    		dp[x][y] = -1; // ¹°¿õµ¢ÀÌ °¥¼ö ¾øÀ½
    		
    	}
    	
    	dp[1][1] = 1;
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=m;j++){
    			if(i==1 &&j==1) continue;
    			if(dp[i][j]!=-1){
    				if(dp[i-1][j]==-1){
    					dp[i][j] = dp[i][j-1] % 1000000007;
    				}else if(dp[i][j-1]==-1){
    					dp[i][j] = dp[i-1][j] % 1000000007;
    				}else{
    					dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
    				}
    			
    			}
    		}
    	}
    	for(int i=1;i<=n;i++){
    		for(int j=1;j<=m;j++){
    			System.out.print(dp[i][j]+" ");
    		}System.out.println();
    		
    	}
    	int answer = (int)(dp[n][m] / 1000000007);
        return answer;
    }
}
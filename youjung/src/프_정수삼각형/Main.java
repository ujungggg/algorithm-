package 프_정수삼각형;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[][] tri = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		solution(tri);
	}
    public static int solution(int[][] arr) {
    	
    	int[][] dp= new int[arr.length][arr.length];
    	
    	dp[0][0] = arr[0][0];
    	
    	int max =0;
    	for(int i=1;i<arr.length;i++){
    		for(int j=0;j<arr[i].length;j++){
    			if(j-1<0){
    				dp[i][j] = dp[i-1][j] + arr[i][j];
    			}else{
    				dp[i][j] = Math.max(dp[i-1][j] + arr[i][j], dp[i-1][j-1]+arr[i][j]);
    			}
    			max = Math.max(dp[i][j], max);
    		}
    	}
        int answer = max;
        System.out.println(max);
        
         
        return answer;
    }
}
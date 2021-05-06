package 프_가장큰정사각형찾기;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int[][] board = {{0,0,0,1},{0,0,0,0}};
		solution(board);
	}
	
	
	 public static int solution(int[][] board) {
	    	
	    	 int max =0;
	    	 int[][] dp = new int[board.length][board[0].length];
	    	for(int i=0;i<board[0].length;i++){
	    		dp[0][i] = board[0][i];
	    		max = Math.max(dp[0][i], max);
	    	}
		
	    	int[][] dir = {{-1,-1},{0,-1},{-1,0}};
		
	    	for(int i=1;i<board.length;i++){
	    		for(int j=0;j<board[0].length;j++){
	    			if(board[i][j] == 1){
	    				//1인 경우에 위로 세 방향을 확인
	    				int min = 100000000;
	    				boolean flag = false;
	    				for(int d=0;d<3;d++){
	    					int x = i+ dir[d][0];
	    					int y = j+ dir[d][1];
	    					if(x<0 || y<0 || x>=board.length || y>= board[0].length){
	    						dp[i][j] = 1;
 	    						max = Math.max(dp[i][j], max);
 	    						flag = true;
	    						break;
	    					}
	    					min = Math.min(dp[x][y], min);
	    				}
	    				if(!flag){
	    					dp[i][j] = min+1;
		    				max = Math.max(dp[i][j], max);
	    				}
	    				
	    			}
	    		}
	    	}
//	    	for(int i=0;i<board.length;i++){
//	    		for(int j=0;j<board[0].length;j++){
//	    			System.out.print(dp[i][j]+" ");
//	    		}System.out.println();
//	    	}
//	    	System.out.println(max);
	    	return max*max;
	    }
}


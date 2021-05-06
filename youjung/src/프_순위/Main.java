package 프_순위;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int n = 5;
		int[][] result = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		
		solution(n,result);
	}
	 public static int solution(int n, int[][] results) {
	    	
		 int[][] arr = new int[n+1][n+1];
		 for(int i=1;i<=n;i++){
			 Arrays.fill(arr[i], Integer.MAX_VALUE);
		 }
		 
		 for(int i=0;i<results.length;i++){
			int x = results[i][0];
			int y = results[i][1];
			
			arr[x][y] = 1; //길이 있음을 표현
		 }
		 
		 for(int k=1;k<=n;k++){
			 for(int a=1;a<=n;a++){
				 for(int b=1;b<=n;b++){
					 if(arr[a][k] == 1 && arr[k][b] ==1){
						 arr[a][b] = 1;
					 }
				 }
			 }
		 }
		 
		 int[] total = new int[n+1];
		 for(int i=1;i<=n;i++){
			 for(int j=1;j<=n;j++){
				 if(arr[i][j]==1){
					 total[i]++;
					 total[j]++;
				 }
			 }
		 }
		 
		 int answer =0;
		 for(int i=1;i<=n;i++){
			 if(total[i] == n-1){
				 answer++;
			 }
		 }
//		 System.out.println(answer);
		 return answer;
	    }
}


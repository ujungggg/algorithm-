package Ÿ�ϸ�;



class Solution {
	
	 public static void main(String[] args) {
	 
	int n = 4;
	
	 solution(n);
		}
	 
	 static int total= 0;
	
	 public static int solution(int n) {
	
		 int[] dp = new int[n+1];
		 dp[0]=0;
		 dp[1]=1;
		 dp[2]=2;
		 
		 for(int i=3;i<=n;i++){
			 dp[i] = (dp[i-1]+dp[i-2])%1000000007;
		 }
		 System.out.println(dp[n-1] );
		 int answer = (dp[n] %1000000007);
		 System.out.println(answer);
		 return answer;
    	
    }
   
}
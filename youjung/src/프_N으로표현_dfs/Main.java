package 프_N으로표현_dfs;
import java.util.*;

class Solution {
	
	public static void main(String[] args) {
		int N = 2;
		int number = 11;
		solution(N,number);
	}
	public static int min = 9;
	public static void solve(int N, int cnt, int num, int number){
		if(cnt>8) return;
		if(num == number){
			min = Math.min(min, cnt);
			return;
		}else{
			int nn =0;
			for(int i=0;i<8;i++){
				nn = nn*10 + N;
				solve(N, cnt+i+1, num+nn,number);
				solve(N, cnt+i+1, num-nn,number);
				solve(N, cnt+i+1, num*nn,number);
				solve(N, cnt+i+1, num/nn,number);
			}
		}
	}
    public static int solution(int N, int number) {
    	
    	solve(N,0,0,number);
    	System.out.println(min);
    	if(min >=8){
    		return -1;
    	}else{
    		return min;
    	}
    }
}
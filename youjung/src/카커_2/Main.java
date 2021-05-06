package 카커_2;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[][] needs = { { 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		int r = 2;
		solution(needs, r);
	}
	public static boolean[] visit;
	public static int max =0;
	public static void solve(int start, int cnt, int total,int r, int[][] needs){
		if(cnt == r){
			check(needs);
		}else{
			for(int i=start;i<total;i++){
				if(!visit[i]){
					visit[i] = true;
					solve(i+1, cnt+1, total,r, needs);
					visit[i] = false;
				}
			}
		}
	}
	
	public static void check(int[][] needs){
		int cnt =0;
		for(int i=0;i<needs.length;i++){
			boolean flag = false;
			for(int j=0;j<needs[0].length;j++){
				if(!visit[j] && needs[i][j]==1){ //선택한 부품이 아닌데, 그것이 필요한 경우면 조건 충족
					flag = true;
					break;
				}
			}
			if(!flag){
				cnt++;
			}
		}
		max = Math.max(cnt, max);
	}
    public static int solution(int[][] needs, int r) {
    	
    	visit = new boolean[needs[0].length];
    	solve(0,0,needs[0].length,r,needs);
    	System.out.println(max);
        int answer = 0;
        return answer;
    }
}
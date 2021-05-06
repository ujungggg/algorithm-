package 프_땅따먹기;
import java.util.*;

class Solution {
	static int max =0;
	
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		solution(land);
	}
	/*
	 * bf: 시간 초과 4의 10000.. 승까지 갈 수 있기 때문
	public static void solve(int before,int level ,int sum,int[][] land){
		if(level == land.length ){
			max = Math.max(sum,max);
			return;
		}else{
			for(int i=0;i<4;i++){
				if(i==before) continue;
				solve(i,level+1,sum+land[level][i],land);
			}
		}
	}
	*/
	static int solution(int[][] land) {
    	

		for(int i=1;i<land.length;i++){
			land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
			land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
			land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][3]));
			land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1][2]));
		}
		for(int i=0;i<land.length;i++){
			for(int j=0;j<4;j++){
				System.out.print(land[i][j]+" ");
			}System.out.println();
		}
		   int answer = 0;
		for(int i=0;i<4;i++){
			answer = Math.max(land[land.length-1][i], answer);
		}
//     System.out.println(answer);
        return answer;
    }
}

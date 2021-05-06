package ÇÁ_»ï°¢´ŞÆØÀÌ;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		int n = 5;
		solution(n);
	}
	
	public static int[] solution(int n) {
		int[][] arr = new int[n][n];
		int[][] dir = {{1,0},{0,1},{-1,-1}};
		
		int num = 1;
		int x =0; int y =0; int d =0;
		arr[0][0] = 1;
		
		int cnt =0;
		while(true){
			
			x+= dir[d%3][0];
			y+= dir[d%3][1];
			if(cnt>1) break;
			if(x <0 || y<0 || x>=n || y >=n || arr[x][y]!=0) {
				x-= dir[d%3][0];
				y-= dir[d%3][1];
				cnt++;
				d++;
			}else{
				cnt =0;
				arr[x][y] = ++num;
			}
			
		}
		 int[] answer =new int[num];
		 int tot =0;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(arr[i][j]!=0){
					answer[tot++] = arr[i][j];
					System.out.print(arr[i][j]+" ");
				}
			}
		}
	        return answer;
    }	
}


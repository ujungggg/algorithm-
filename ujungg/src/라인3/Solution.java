package 라인3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
	public static void main(String[] args) {
		int [][] maze = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
		
		
		solution(maze);
	}
	static int[][] dir = {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1},};
	static int[][] dir2 = {{1,0},{0,1},{-1,0},{0,-1}};
	static int result =0;
	public static void solve(int startX, int startY, int dr,int[][] arr,int cnt){
		if(startX == arr.length-1 && startY == arr.length-1){
			result = cnt;
			return;
		}
		for(int d=0;d<4;d++){
			int x= startX + dir2[d][0];
			int y = startY + dir2[d][1];
			
			int checkX1 = startX + dir[((d+2)%8)][0];
			int checkY1 = startY + dir[((d+2)%8)][1];
			int checkX2 = startX + dir[((d+3)%8)][0];
			int checkY2 = startY + dir[((d+3)%8)][1];
			
			if(x<0 || y<0 || x>= arr.length || y>= arr.length) continue;
			if(arr[x][y]==0){
				if(checkX1 <0 || checkX2<0 || checkY1<0 || checkY2<0 ||
						checkX1 >= arr.length || checkX2>= arr.length || checkY1>= arr.length || checkY2>= arr.length ){
					solve(x,y,d,arr,cnt+1);
				}else{
					if(arr[checkX1][checkY1]==1 || arr[checkX2][checkY2]==1){
						solve(x,y,d,arr,cnt+1);
					}
				}
//				if(arr[checkX1][checkY1]==1 || arr[checkX2][checkY2]==1 ||
//						
//						){
//					solve(x,y,d,arr,cnt+1);
//					return;
//				}
			}
		}
		
	}
	public static int solution(int[][] maze) {
		
		int d = 0; //사람방향
		int d2 =0; //체크해야할 벽
		//사람방향 0, 
		
		solve(0,0,0,maze,0);
		System.out.println(result);
        int answer = 0;
        return answer;
    }
        
   
}
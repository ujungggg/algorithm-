package 카카오프렌즈컬러링북;

import java.util.*;
class Solution {
    static int[][] picture;
    static int[][] visit;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static int max =0;  static int cnt=0;
    
    public static void main(String[] args) {
		int m= 6;
		int n= 4;
		int[][] pictures = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		solution(m,n,pictures);
    }
        
    static void solve(int startX, int startY, int color,int m , int n,int[][] picture){
    	LinkedList<Integer> temp = new LinkedList<Integer>();
    	Collections.sort(temp);
       for(int d=0;d<4;d++){
           int x = startX + dir[d][0];
           int y = startY + dir[d][1];
          
           if(x<0 || y<0 || x>=m || y>=n) continue;
           if(visit[x][y]==0 && picture[x][y]== color){
        	   visit[x][y]=1;
        	   cnt++;
               solve(x,y,color,m,n,picture);
           }
       }
    }
    
    
    public static int[] solution(int m, int n, int[][] picture) {
    	
        visit = new int[m][n];

        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		visit[i][j]=0;
        	}
        }
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0; j<n;j++){
                if(visit[i][j]==0 && picture[i][j]!=0){
                    numberOfArea ++;
                    visit[i][j]=1;
                    cnt=1;
                    solve(i,j,picture[i][j],m,n,picture); //시적X, 시작Y, 색, 영역
                    
                    max = Math.max(cnt,max);
                }        
            }
        }
    
        maxSizeOfOneArea = max;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
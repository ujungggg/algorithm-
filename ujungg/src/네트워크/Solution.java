package 네트워크;

import java.util.ArrayList;

class Solution {
    
    public static void main(String[] args){
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution(n,computers);
    }
    static int[] visit ;
    static int cnt=0;
    
    public static void solve(int start,int n, int[][] computers){
        for(int j=0;j< n;j++){
            if(start!=j && computers[start][j] ==1 && visit[j]==0){
                visit[j]=1;
                solve(j,n,computers);
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        // this.computers = computers;
        visit = new int[n];
        
       
        for(int i=0;i<n ;i++){
            if(visit[i]==0){
                visit[i]=1; 
                cnt++;
                solve(i,n,computers);
            }
        }
        System.out.println(cnt);
        int answer = 0;
        return answer;
    }
}
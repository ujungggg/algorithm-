package 프_nqueen;
class Solution {
    public static int answer =0;
    public static int[][] visit ;
    
    public static void main(String[] args) {
		int n = 4;
		solution(n);
	}
     static void goCheck(int x,int y, int flag,int n){
        int[][] dir = {{1,1},{1,-1},{1,0}};
        for(int d=0;d<3;d++){
            int newX = x;
            int newY = y;
             while(true){
                newX+= dir[d][0];
                newY+= dir[d][1];
                if(newX >= n || newY >=n || newX <0 || newY <0) break;
                visit[newX][newY] += flag;
             }
        }
       
    }
    public static void solve(int start, int cnt, int n){
        if(start == n && cnt == n){
            answer++;
            return;
        }else{
            for(int i= 0;i<n;i++){
                if(visit[start][i] ==0 ){
                    goCheck(start,i,1,n); // +1 해주면서 체크함
                    for(int k=0 ;k<n;k++){
                    	for(int m=0;m<n;m++){
                    		System.out.print(visit[k][m]+" ");
                    	}System.out.println();
                    }System.out.println("-------------------");
                    solve(start+1,cnt+1,n);
                    goCheck(start,i,-1,n);
                }
            }
        }
    }
    public static int solution(int n) {
        visit = new int[n][n];
        solve(0,0,n);
        System.out.println(answer);
        return answer;
    }
}

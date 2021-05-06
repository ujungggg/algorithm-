package 구슬탈출2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N ; static int M;
	static char[][] arr;
	static Queue<Pair> queR = new LinkedList<>();
	static Queue<Pair> queB = new LinkedList<>();
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[][][][] visit ;
    static int total = 0;
	static class Pair{
		int x; int y; int cnt;
		Pair(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static void solve(){
		while(!queR.isEmpty()){
			Pair temp =queR.remove();
			int firstRx = temp.x;
			int firstRy = temp.y;
			int cnt = temp.cnt;
			
			Pair temp2 =queB.remove();
			int firstBx = temp2.x;
			int firstBy = temp2.y;
			int bcnt = temp2.cnt;
			if(cnt>10) {
				total = -1;
				return;
			}
			
			boolean rFlag = false;
			boolean bFlag = false;
			
			for(int d=0;d<4;d++){
				int rx = firstRx;
				int ry = firstRy;
				int bx = firstBx;
				int by = firstBy;
				
				while(true){
					rFlag = false;
					rx+= dir[d][0];
					ry+= dir[d][1];
					
					if(rx<0 || ry<0 || rx>=N ||ry>=M) continue;
					if(arr[rx][ry]== '#'){
						rx-= dir[d][0];
						ry-= dir[d][1];
					//	queR.add(new Pair(rx,ry,cnt+1));
						break;
					}else if(arr[rx][ry]== 'O'){
						//queR.add(new Pair(rx,ry,cnt+1));
						rFlag = true;
						break;
					}
				}
				
				while(true){
					bFlag = false;
					bx+= dir[d][0];
					by+= dir[d][1];
					
					if(bx<0 || by<0 || bx>=N ||by>=M) continue;
						if(arr[bx][by] == '#'){
						bx-= dir[d][0];
						by-= dir[d][1];
					//	queR.add(new Pair(rx,ry,cnt+1));
					//	queB.add(new Pair(bx,by,cnt+1));
						break;
					}else if(arr[bx][by] == 'O'){
					//	queB.add(new Pair(bx,by,cnt+1));
						bFlag = true;
						break;
					}
				}
				
				if(!bFlag ){
					if(rx == bx && ry == by){
						if(d==0){ // 오른쪽 방향
							if(firstRy < firstBy){
								rx -=dir[d][0];
								ry -= dir[d][1];
							}else{
								bx -=dir[d][0];
								by -=dir[d][1];
							}
					
						}else if(d==1){ // 아래방향
							if(firstRx < firstBx){
								rx -=dir[d][0];
								ry -= dir[d][1];
							}else{
								bx -=dir[d][0];
								by -=dir[d][1];
							}
					
						}else if(d==2){ //왼쪽방향 
							if(firstRy < firstBy){
								bx -=dir[d][0];
								by -= dir[d][1];
							}else{
								rx -=dir[d][0];
								ry -=dir[d][1];
							}
						}else if(d==3){ // 위쪽방향
							if(firstRx < firstBx){
								bx -=dir[d][0];
								by -=dir[d][1];
							}else{								
								rx -=dir[d][0];
								ry -= dir[d][1];
							}
						}
					}
					
					
//					if((firstRx == rx && firstRy == ry && firstBx == bx && firstBy == by)){
//						//처음이랑 구슬위치가 같지 않을때만
//						
//					}else{
//						queR.add(new Pair(rx,ry,cnt+1));
//						queB.add(new Pair(bx,by,cnt+1));
//					}
//					
					if(visit[rx][ry][bx][by] == 0){
						visit[rx][ry][bx][by] = 1;
						queR.add(new Pair(rx,ry,cnt+1));
						queB.add(new Pair(bx,by,cnt+1));
					}
					if(rFlag && !bFlag){
//						System.out.println("total"+(cnt+1));
						total = cnt+1;
						return;
					}
						
				}
				
			}
		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	 N = Integer.parseInt(st.nextToken());
	 M = Integer.parseInt(st.nextToken());
	arr = new char[N][M];
	visit = new int[N][M][N][M];
	for(int i=0;i<N;i++){
		String str = br.readLine();		
		for(int j=0;j<M;j++){
			
			char ch = str.charAt(j);
			if(ch == 'R'){
				arr[i][j] = '.';
				queR.add(new Pair(i,j,0));
			}else if(ch == 'B'){
				arr[i][j] = '.';
				queB.add(new Pair(i,j,0));
			}else{
				arr[i][j] = ch;
			}
		}
	}

	
	solve();
	if(total ==0 || total>10){
		System.out.println("-1");
	}else{
		System.out.println(total);	 
	}

}
}
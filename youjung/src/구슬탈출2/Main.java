package ±∏ΩΩ≈ª√‚2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static Character[][] arr;
	static boolean[][][][] visit;
	static LinkedList<Pair> list;
	static int totalTime = 0;
	
	static class Pair{
		int rx; int ry; int bx; int by; int time;
		Pair(int rx, int ry, int bx, int by, int time){
			this.rx = rx;
			this.ry = ry;
			this.bx = bx;
			this.by = by;
			this.time = time;
		}
	}
	
	public static void solve(){
		
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}}; //«œ ªÛ øÏ ¡¬
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int rx = temp.rx;
			int ry = temp.ry;
			int bx = temp.bx;
			int by = temp.by;
			int time = temp.time;
			if(time>=10){  
				totalTime = -1; 
				return;
				}
			for(int d=0;d<4; d++){
				int nrx = rx; int nry = ry;  int nbx = bx;  int nby = by; 
				boolean redFlag = false; boolean sFlag = false;
				boolean blueFlag = false; boolean sFlag2 = false;
				while(true){
					if(!sFlag && !redFlag){
						nrx += dir[d][0];
						nry += dir[d][1];
//						System.out.println(nrx+ " "+ nry);
						if(arr[nrx][nry]=='#' ){
							nrx -= dir[d][0];
							nry -= dir[d][1];
							sFlag = true;
						}
						else if(arr[nrx][nry] =='O'){
							redFlag = true;
							
						} 
					}
					if( sFlag || redFlag){
						break;
					}
				}
				
				while(true){
					if(!sFlag2 && !blueFlag){
						nbx += dir[d][0];
						nby += dir[d][1];
						

						 if(arr[nbx][nby]=='#'){
								nbx -= dir[d][0];
								nby -= dir[d][1];
								sFlag2 = true;
							}else if(arr[nbx][nby] =='O'){
								blueFlag = true;
						}
					}
					if( sFlag2 || blueFlag ){
						break;
					}
				}
				if(nrx==nbx && nry == nby){
					if(d==0){ //«œ
						if(rx > bx){ 
							nbx -= dir[d][0];
							nby -= dir[d][1];
						}else{
							nrx -= dir[d][0];
							nry -= dir[d][1];
						}
					}else if(d==1){ //ªÛ
						if(rx > bx){
							nrx -= dir[d][0];
							nry -= dir[d][1];
						}else{
							nbx -= dir[d][0];
							nby -= dir[d][1];
						}
					}else if(d==2){ //øÏ
						if(ry > by){
							nbx -= dir[d][0];
							nby -= dir[d][1];
						}else{
							nrx -= dir[d][0];
							nry -= dir[d][1];
						}
					}else if(d==3){ //¡¬
						if(ry > by){
							nrx -= dir[d][0];
							nry -= dir[d][1];
						}else{
							
							nbx -= dir[d][0];
							nby -= dir[d][1];
						}
					}
					
				}
				/*
				while(true){
					
					if(!sFlag && !redFlag){
						nrx += dir[d][0];
						nry += dir[d][1];
//						System.out.println(nrx+ " "+ nry);
						if(arr[nrx][nry]=='#' ){
							nrx -= dir[d][0];
							nry -= dir[d][1];
							sFlag = true;
						}
						else if(arr[nrx][nry] =='O'){
							redFlag = true;
							
						} 
					}
					if(!sFlag2 && !blueFlag){
						nbx += dir[d][0];
						nby += dir[d][1];
						

						 if(arr[nbx][nby]=='#'){
								nbx -= dir[d][0];
								nby -= dir[d][1];
								sFlag2 = true;
							}else if(arr[nbx][nby] =='O'){
								blueFlag = true;
						}
					}
					if((sFlag && sFlag2 ) || redFlag || blueFlag ){
						break;
					}
					if(nrx==nbx && nry == nby){
						if(d==0){ //«œ
							if(rx > bx){ 
								nbx -= dir[d][0];
								nby -= dir[d][1];
							}else{
								nrx -= dir[d][0];
								nry -= dir[d][1];
							}
						}else if(d==1){ //ªÛ
							if(rx > bx){
								nrx -= dir[d][0];
								nry -= dir[d][1];
							}else{
								nbx -= dir[d][0];
								nby -= dir[d][1];
							}
						}else if(d==2){ //øÏ
							if(ry > by){
								nbx -= dir[d][0];
								nby -= dir[d][1];
							}else{
								nrx -= dir[d][0];
								nry -= dir[d][1];
							}
						}else if(d==3){ //¡¬
							if(ry > by){
								nrx -= dir[d][0];
								nry -= dir[d][1];
							}else{
								
								nbx -= dir[d][0];
								nby -= dir[d][1];
							}
						}
						
						break;
					}
					
				}
			*/
			
				if(redFlag && !blueFlag) {
					totalTime = time+1;
//					System.out.println(totalTime);
					return;
				}
				if(!redFlag && !blueFlag){
					if(!visit[nrx][nry][nbx][nby]){
						visit[nrx][nry][nbx][nby] = true;
						list.add(new Pair(nrx,nry,nbx,nby,time+1));
					}
				}
			}
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new LinkedList<>();
		arr = new Character[N][M];
		visit = new boolean[N][M][N][M];
		
		int rx = 0; int ry = 0; int bx =0 ; int by=0;
		for(int i=0;i<N;i++){
			String br2 = br.readLine();
			for(int j=0;j<M;j++){
				arr[i][j] = br2.charAt(j) ;
				if(arr[i][j] == 'R'){
					rx = i; ry = j;
					arr[i][j] = '.';
				}else if(arr[i][j] == 'B'){
					bx = i; by=j;
					arr[i][j] = '.';
				}
			}
		}
		visit[rx][ry][bx][by] = true;
		list.add(new Pair(rx,ry,bx,by,0));
		
		solve();
		if(totalTime==0){
			System.out.println("-1");
		}else{
			System.out.println(totalTime);
		}
		
	}
}




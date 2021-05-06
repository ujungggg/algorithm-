package 인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이중 for문을 돌면서 bfs로 개방할수 있는 영역 찾기. 
 * count를 하나씩 늘려주면서 영역 구분하기
 * 영역을 다 세운후에 다시 for문 돌면서 계산후에 다시 영역 만들기
 *  계산을 하면서 한꺼번에 계산해서 넣음(1)
 *  for문을 한번더 돌지 않기 위해 visit배열이 변한건 list에 넣음
 * */
public class Main {
	static int N; 
	static int L; 
	static int R;
	static int[][] arr;
	static int[][] visit;
	static int time =0;
	static LinkedList<Pair> list = new LinkedList<>();
	
	static class Pair{
		int a ; int b;
		Pair(int a, int b){
			this.a=a;
			this.b=b;
		}
	}
	
	public static void solve(){
		int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
		
		while(true){
			boolean flag =true;
			
			 
				int count =0; //큰 단위 영역의 갯수
				int[][] tempTotal = new int[2][5000]; // tempTotal[0][count]:영역의 합(숫자),tempTotal[1][count] 영역의 갯수(크기) 넣음
//				LinkedList<Pair> deleteList = new LinkedList<>();
				for(int a=0;a<N;a++){
					for(int b=0;b<N;b++){
						
						if(visit[a][b]==0){
							count++;
							visit[a][b]=count;
							tempTotal[0][count]+=arr[a][b];
							tempTotal[1][count]+=1;
							list.add(new Pair(a,b));
						//	deleteList.add(new Pair(a,b));
							while(!list.isEmpty()){
								Pair temp = list.remove();
								int k = temp.a;
								int l = temp.b;
								
							for(int d=0;d<4;d++){
						    	int x = k + dir[d][0];
						    	int y = l + dir[d][1];
						    	if(x<0 || y<0 || x>=N || y>=N) continue;
						    	if(visit[x][y] == 0 && Math.abs(arr[x][y]-arr[k][l])>=L && Math.abs(arr[x][y]-arr[k][l])<=R){
						    		flag = false;
						    		visit[x][y] = count;
						    		tempTotal[0][count] += arr[x][y];
						    		tempTotal[1][count] += 1;
						    		list.add(new Pair(x,y));
						 //   		deleteList.add(new Pair(x,y));
						    	}
						    }
							
						}
							
						}
					
				}
				 
			}
				if(flag) return;
				
				//영역에 새로운 값 배정
//				int ds = deleteList.size();
//				for(int s=0;s<ds;s++){
//					Pair temp = deleteList.remove();
//					int i = temp.a; int j = temp.b;
////					for(int c=1;c<=count;c++){
//						if(visit[i][j] !=0){
//							arr[i][j] =  tempTotal[0][visit[i][j]]/tempTotal[1][visit[i][j]];
//						}
////					}
//				}
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(visit[i][j] !=0){
							arr[i][j] =  tempTotal[0][visit[i][j]]/tempTotal[1][visit[i][j]];
						}
					}
				}
				
				
				
//				for(int i=0;i<N;i++){
//					for(int j=0;j<N;j++){
//						System.out.print(arr[i][j]+" ");
//					}System.out.println();
//				}
				
				time++;
				visit = new int[N][N];
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N];
		visit = new int[N][N];
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		list.add(new Pair(0,0));
		solve();
		System.out.println(time);
	}

}
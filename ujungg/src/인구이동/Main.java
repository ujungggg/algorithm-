package �α��̵�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ���� for���� ���鼭 bfs�� �����Ҽ� �ִ� ���� ã��. 
 * count�� �ϳ��� �÷��ָ鼭 ���� �����ϱ�
 * ������ �� �����Ŀ� �ٽ� for�� ���鼭 ����Ŀ� �ٽ� ���� �����
 *  ����� �ϸ鼭 �Ѳ����� ����ؼ� ����(1)
 *  for���� �ѹ��� ���� �ʱ� ���� visit�迭�� ���Ѱ� list�� ����
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
			
			 
				int count =0; //ū ���� ������ ����
				int[][] tempTotal = new int[2][5000]; // tempTotal[0][count]:������ ��(����),tempTotal[1][count] ������ ����(ũ��) ����
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
				
				//������ ���ο� �� ����
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
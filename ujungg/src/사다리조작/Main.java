package 사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[][] visit;
	static int N; static int H; static int M;
	static int min =100000000;
	
	public static void solve(int startX,int startY,int total, int cnt){ //cnt가 목표 숫자
		if(total == cnt){
			// 만족하는지 체크
			if(check()){
//				System.out.println(min);
				min = Math.min(min, total);
			}
			return;
		}else{
			for(int i=startX; i<=M; i++){
				for(int j=startY;j<=N;j++){
					if(arr[i][j]==0 && arr[i][j-1]==0 && arr[i][j+1]==0){
						arr[i][j]=1;
						
						solve(startX,startY,total+1,cnt);
						if(min!=100000000) return;
						arr[i][j]=0;
					}
				}
			}
		}
	}
	
	public static boolean check(){
//		for(int q=1;q<=M;q++){
//			for(int w=1;w<=N;w++){
//				System.out.print(arr[q][w]+" ");
//			}System.out.println();
//		}
//		System.out.println("------------------");
		boolean flag = true;
		for(int j=1;j<=N;j++){
			int nowJ = j;
			for(int i=1;i<=M;i++){
				if(arr[i][nowJ-1]==1){
				nowJ--;
			}
			else if(arr[i][nowJ]==1){
				nowJ++;
			}
			}
//			while(i<=M && nowJ <=N){
//				if(arr[i][nowJ-1]==1){
////					visit[i][nowJ-1]=1;
//					nowJ--;
//				}
//				else if(arr[i][nowJ]==1){
////					visit[i][nowJ]=1;
//					nowJ++;
//				}
//				i++;
//				
//								
//			}
			
//			for(int q=0;q<M;q++){
//				for(int w=0;w<N;w++){
//					visit[q][w]=0;
//				}
//			}
//			visit =new int[M+2][N+2];
			if(j == nowJ){
				flag = true;
			}else{
				flag = false;
				break;
			}
		}
		return flag;
		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st= new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   H = Integer.parseInt(st.nextToken());
	   M = Integer.parseInt(st.nextToken());
	   
	   arr = new int[M+2][N+2];
	   visit = new int[M+2][N+2];
	   for(int h=0;h<H;h++){
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		arr[a][b]=1;
	   }

	   int start  = 0;
	   while(start <= 3){
//		   System.out.println(start);
		   solve(1,1,0,start);
		   
		   if(min!=100000000) {break;}
		   else{
			   start ++;
		   }
	   }
	   if(min == 100000000){
		   System.out.println("-1");
	   }else{
		   System.out.println(min);
	   }
	   
}
}
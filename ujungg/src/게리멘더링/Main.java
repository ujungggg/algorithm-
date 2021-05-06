package 게리멘더링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int[][] visit;
	static int totalMin = 1000000000;
	public static void putLine(int startX, int startY ,int d1,int d2){
		int[][] dir={{1,-1},{1,1}};//
		visit = new int[N+1][N+1];
//		System.out.println(startX +" "+startY+" "+d1+" "+d2);
		int cnt =0;
		int x = startX;
		int y = startY;
		
		visit[x][y] = 5;
		while(cnt<d1){ //왼쪽 아래 경게선 1번 
			x += 1;
			y += -1;
			visit[x][y] = 5;
			cnt++;
		}
		
		cnt =0;
		x = startX;
		y = startY;
		while(cnt <d2){ //오른쪽 아래 경꼐선2번
			x +=1;
			y+=1;
			visit[x][y]=5;
			cnt++;
			
		}
		cnt =0;
		x = startX +d1; //시작점 변경
		y = startY -d1;
		while(cnt<d2){ //경계선3번
			x += 1;
			y += 1;
			visit[x][y] = 5;
			cnt++;
		}
		cnt =0;
		x = startX +d2; //시작점 변경
		y = startY +d2;
		while(cnt <d1){ //경계선 4번
			x += 1;
			y += -1;
			visit[x][y]=5;
			cnt++;
		}
		
//		for(int i=1;i<=N;i++){
//			for(int j=1;j<=N;j++){
//				System.out.print(visit[i][j]+" ");
//			}System.out.println();
//		}
		for(int i=1;i<=N;i++){
			int start =0; 
			int fin = N;
			
			if(start==0){
				while(start<=N && visit[i][start] !=5){
					start++;
				}
			}
			if(start !=0 && fin ==N){
				
				while(fin>=1 && visit[i][fin] !=5){
					fin--;
				}
			}
			
//			System.out.println("@@@"+start+" "+fin);
			if(start!=fin){
				for(int s = start;s<=fin;s++){
					visit[i][s]=5;
				}
			}
			
		}
//		for(int i=1;i<=N;i++){
//			for(int j=1;j<=N;j++){
//				System.out.print(visit[i][j]+" ");
//			}System.out.println();
//		}
//		System.out.println("-----------------");
	}
	
	public static void setColor(int x, int y ,int d1,int d2,int color){
		
		for(int r=1;r<=N;r++){
			for(int c=1;c<=N;c++){
				if(visit[r][c]==5) continue;
				else if(r>=1 && r<x+d1 && 1<=c && c<=y) visit[r][c]=1;
				else if(r>=1 && r<=x+d2 && y<c && c<=N) visit[r][c]=2;
				else if(r>=x+d1 && r<=N && 1<=c && c<y-d1+d2) visit[r][c]=3;
				else if(r>x+d2 && r<=N && y-d1+d2<=c && c<=N) visit[r][c]=4;
			}
		}
		
//		System.out.println("------영역확인-----------");
//		for(int i=1;i<=N;i++){
//			for(int j=1;j<=N;j++){
//				System.out.print(visit[i][j]+" ");
//			}System.out.println();
//		}
//		System.out.println("-----------------");
		
		
	}
	public static int check(){
		int max =0;
		int min =100000000;
		int[] count = new int[6];
		
		for(int i=1;i<=N;i++){
			for(int j=1;j<=N;j++){
				if(visit[i][j]==1){
					count[1]+=arr[i][j];
				}else if(visit[i][j]==2){
					count[2]+=arr[i][j];
				}else if(visit[i][j]==3){
					count[3]+=arr[i][j];
				}else if(visit[i][j]==4){
					count[4]+=arr[i][j];
				}else if(visit[i][j]==5){
					count[5]+=arr[i][j];
				}
			}
		}
		for(int i=1;i<=5;i++){
			if(max<count[i]){
				max = count[i];
			}
			if(min>count[i]){
				min = count[i];
			}
		}
		return max-min;
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	arr = new int[N+1][N+1];
	visit = new int[N+1][N+1];
	for(int i=1;i<=N;i++){
		st = new StringTokenizer(br.readLine());
		for(int j=1;j<=N;j++){
			arr[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	//조합을 만들기 x,y,d1,d2
	for(int x=1 ; x<=N;x++){
		for(int y=1;y<=N;y++){
			for(int d1 =1;d1<=N;d1++){
				for(int d2=1;d2<=N;d2++){
					if(x+d1+d2 <=N && y-d1>=1 && y-d1<y && y<y+d2 && y+d2<=N){
						
						putLine(x,y,d1,d2); // 경계선을 놓는다
						setColor(x,y,d1,d2,1);
						setColor(x,y,d1,d2,2);
						setColor(x,y,d1,d2,3);
						setColor(x,y,d1,d2,4);
						int count = check();
						totalMin = Math.min(count, totalMin);
					}
				}
			}
		}
	}
	System.out.println(totalMin);

}
}
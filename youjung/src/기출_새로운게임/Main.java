package 기출_새로운게임;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Integer>[][] list;
	public static int[][] arr;
	public static Pair[] horse;
	public static int N;
	public static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	public static boolean check = false;
	public static class Pair{
		int x; int y; int d;
		Pair(int x, int y, int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	public static int changeDir(int d){
		int newD = 0;
		if(d==0){
			newD = 1;
		}else if(d==1){
			newD = 0;
		}else if(d==2){
			newD = 3;
		}else if(d==3){
			newD = 2;
		}
		
		return newD;
	}
	public static void move(int index,int cnt){ //지금 움직일 i 인덱스
		int x = horse[index].x;
		int y = horse[index].y;
		int d = horse[index].d;  
		
		int nx = x+ dir[d][0];
		int ny = y+ dir[d][1];
		
		
		//list[x][y]에 있는 좌표들을 모두 nx,ny로 옮겨야하는 상황
		if(nx<0 || ny<0 || ny>=N || nx>=N || arr[nx][ny]==2){
			//맵 벗어나거나 파란색이면 방향만 바꿈
			int newD = changeDir(d);
			if(cnt==0){
				horse[index] = new Pair(x,y,newD);
				move(index,1);
			}else{ //두번째인 경우
//				horse[index] = new Pair(x,y,newD);
				
//				int size = list[x][y].size();
				int newIndex = list[x][y].get(0);
				horse[newIndex] = new Pair(x,y,d); //바꾸려고 했던건 방향만 바꿈
				if(list[x][y].size()>=4){
					check = true;
					return;
				}
				/*
				for(int s=0;s<size;s++){
					int newIndex = list[x][y].remove();
					// horse[x][y] 이 좌표 x  
					list[nx][ny].add(newIndex);
					
					if(s==0){
						horse[newIndex] = new Pair(nx,ny,newD); //바꾸려고 했던건 방향만 바꿈
					}else{
						horse[newIndex] = new Pair(nx,ny,horse[newIndex].d);
					}
					
					
				}
				*/
			}
			
		}else if(arr[nx][ny]==1){
			//맴 빨간색이면  반대로 넣음
			int size = list[x][y].size();
			
			while(size>0){
				int newIndex = list[x][y].removeLast();
				// horse[x][y] 이 좌표 x  
				list[nx][ny].add(newIndex);
				horse[newIndex] = new Pair(nx,ny,horse[newIndex].d);
				size--;
			}
			if(list[nx][ny].size()>=4){
				check = true;
				return;
			}
		}else{ //흰색일때 리스트에 있는 순서대로 옮김
			int size = list[x][y].size();
			
			for(int s=0;s<size;s++){
				int newIndex = list[x][y].remove();
				// horse[x][y] 이 좌표 x  
				list[nx][ny].add(newIndex);
				horse[newIndex] = new Pair(nx,ny,horse[newIndex].d);
				
				if(list[nx][ny].size()>=4){
					check = true;
					return;
				}
				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		list = new LinkedList[N][N];
		horse = new Pair[K+1];
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				list[i][j] = new LinkedList<>();
			}
		}
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken()); //색깔 정보
			}
		}
		//리스트에 놓인 말의 정보
		//말 하나의 정보 (좌표, 방향)
		
		for(int i=1;i<=K;i++){
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken()) -1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			horse[i] = new Pair(x,y,d); //말하나 노드의 정보
			list[x][y].add(i); // 지도 위에 있는 말의 형태
					
		}
		
		int time =0;
		boolean flag = false;
		while(time<=1000){
			time++;
//			for(int i=1;i<=K;i++){
//				System.out.println(i+"         "+ horse[i].x + " "+ horse[i].y+" ");
//			}
//			System.out.println("---------------------");
			for(int i=1;i<=K;i++){
				if(flag) break;
				Pair temp = horse[i];
				int x= temp.x;
				int y = temp.y;
				
				if(list[x][y].get(0) == i){ //말이 그 좌표에서 가장 처음으로 있는거면
					
					move(i,0); //인덱스 보내서 움직임
				}
				if(list[x][y].size()>=4) {
					flag = true;
					break;
				}
			}
			if(flag || check) break;
			
		}
		if(time>1000){
			System.out.println("-1");
		}else{
			System.out.println(time);
		}
		
	}
}


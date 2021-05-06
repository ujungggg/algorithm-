package 열쇠_bfs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int h,w;
	static char[][] arr;
	static boolean[][] visit;
	
	static boolean[] keys;
	static int total;
	static int cnt;
	static boolean flag = false;
	static class Pair{
		int x; int y; 
		Pair(int x, int y){
			this.x=x;
			this.y=y;
			
		}
	}
	
	public static void solve(){
		int[][] dir= {{1,0},{-1,0},{0,1},{0,-1}};
		LinkedList<Pair> nextList = new LinkedList<>();
		LinkedList<Pair> list = new LinkedList<>();
		
		list.add(new Pair(0,0));
		
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int x= temp.x;
			int y = temp.y;
			for(int d=0;d<4;d++){
				int newX = x+ dir[d][0];
				int newY = y+dir[d][1];
				
				if(newX<0 || newX>=h+2 || newY<0 || newY>=w+2) continue;
			
				if(arr[newX][newY]=='.' && !visit[newX][newY]){
					visit[newX][newY] = true;
					list.add(new Pair(newX,newY));
				}
				else if(arr[newX][newY] =='$' && !visit[newX][newY]){
					visit[newX][newY] = true;
					arr[newX][newY]='.';
					list.add(new Pair(newX,newY));
					cnt++;
				}
				else if(arr[newX][newY]>='a' && arr[newX][newY]<='z' && !visit[newX][newY]){//소문자면 key에 넣음
					keys[arr[newX][newY]-'a'] = true;
					visit[newX][newY] = true;
					list.add(new Pair(newX,newY));
					arr[newX][newY]='.';
					
				}
				else if(arr[newX][newY]>='A' && arr[newX][newY]<='Z' && !visit[newX][newY]){
					int tempKey = arr[newX][newY]- 65; // 소문자값 알아내기
					
					if(keys[tempKey]) { //열쇠가 있는거면
						list.add(new Pair(newX,newY)); // 그 자리 문열고 들어감
						arr[newX][newY]='.';
						visit[newX][newY] = true;
					}else{
						nextList.add(new Pair(newX, newY)); // 원래 시작점 자리를 한번더 넣어줌 (나중엔 열쇠가 생겼을수 있으니까)
					}
				}
				
				int tempSize = nextList.size();
				for(int t=0;t<tempSize;t++){
					Pair temps = nextList.remove();
					
					int tempsX = temps.x; 
					int tempsY = temps.y;
					int tempsKey = arr[tempsX][tempsY] -65;
					if(tempsKey>=0 && keys[tempsKey]){
						list.add(new Pair(tempsX,tempsY)); // 그 자리 문열고 들어감
						arr[tempsX][tempsY]='.';
						visit[tempsX][tempsY] = true;
						
					}else{
						nextList.add(new Pair(tempsX,tempsY));
					}
				}
				if(cnt == total) return; //열쇠 다 찾았으면 out
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++){
			total = 0;
			cnt =0;
		
			keys =new boolean[50];
			
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			arr = new char[h+5][w+5];
			visit = new boolean[h+5][w+5];
			for(int i=0;i<w+2;i++){
				arr[0][i] = '.';
				arr[h+1][i] = '.';
			}
			
			for(int i=0;i<h+2;i++){
				arr[i][0] = '.';
				arr[i][w+1] = '.';
			}
			
			//겉에부분을 .으로 쌓아줌
			for(int i=1;i<=h;i++){
				String str = br.readLine();
			
				for(int j=0;j<w;j++){
					arr[i][j+1] = str.charAt(j);
					if(arr[i][j+1]=='$'){
						total++;
					}
				}
			}
			String str = br.readLine();
			for(int s=0;s<str.length();s++){
				if(str.charAt(s) != '0'){
					keys[str.charAt(s)-'a'] = true;
				}
			}
			
			
			
			solve();
			System.out.println(cnt);
		}
	}
}
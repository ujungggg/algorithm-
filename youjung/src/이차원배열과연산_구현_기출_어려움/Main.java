package 이차원배열과연산_구현_기출_어려움;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	public static int[][] arr;
	public static int R;
	public static int C;
	public static int K;
	
	public static boolean check = false;
	static class Pair implements Comparable<Pair>{
		int num; int cnt;
		Pair(int num, int cnt){
			this.num=num;
			this.cnt=cnt;
		}
		

		/*
		 *  2 1 1 2
		 * 1 1 2 1 3 1
		 * */
		@Override
		public int compareTo(Pair p) {
			if(this.cnt > p.cnt) return 1; //
			else if(this.cnt == p.cnt){ //cnt가 같은경우
				if(p.num < this.num) return 1; //num에 따른 오름차순
				else return -1;
			}
			return -1; // 바꾸지 않겠다는 뜻
			
			
		}
	}
	
	public static void solveR(){
		LinkedList<Pair> list = new LinkedList<>() ;
		
		int max =0;
		int[][] temp = new int[101][101];
		for(int i=0; i<arr.length; i++){ //한줄씩 진행해보도록
			int[] count = new int[101]; // 각 열에서 그 숫자가 몇번 나오는지 알기 위해. 그 숫자는 100을 넘어가지 않는다
			
							
			for(int j=0; j<arr[0].length; j++){
				if(arr[i][j]!=0) count[arr[i][j]] ++;
			}
			for(int c=0; c<count.length;c++){
				
				if(count[c]!=0) {
					list.add(new Pair(c,count[c]));
				}
			}
			
			Collections.sort(list);
			
			int t=0;
			int size = list.size();
			for(int g=0;g<size;g++){
			
				Pair temps = list.remove();
				int num = temps.num;
				int cnt = temps.cnt;
				
				temp[i][t] = num;
				temp[i][t+1] = cnt;
				t+=2; 
				
				max = Math.max(max, t);
			}
			
			if(max >= 100) return;
			
		}
		if(max>100){max = 100;}
		arr = new int[arr.length][max];
		
		for(int a=0 ;a<arr.length;a++){
			for(int b=0;b<max;b++){
				arr[a][b] = temp[a][b];
			}
		}
		
		if(C<max && R<arr.length &&arr[R][C] == K) { check = true;}
//		System.out.println("-----------------------");
//		for(int a=0 ;a<arr.length;a++){
//			for(int b=0;b<max;b++){
//				System.out.print(arr[a][b]+" ");
//			}System.out.println();
//		}
//		System.out.println("-----------------------");
	}
	public static void solveC(){
		LinkedList<Pair> list = new LinkedList<>() ;
		
		int max =0;
		int[][] temp = new int[101][101];
			for(int i=0;i<arr[0].length;i++){ //x 
				
				int[] count = new int[101];
				
				for(int j=0;j<arr.length;j++){ //y값증가
				if(arr[j][i]!=0) count[arr[j][i]]++;
			}
			
		
			for(int c=0;c<count.length;c++){
				if(count[c]!=0) list.add(new Pair(c, count[c]));
			}
			
			Collections.sort(list);
			
			int t=0;
			int size = list.size();
			for(int g=0;g<size;g++){
				Pair temps = list.remove();
				
				int num = temps.num;
				int cnt = temps.cnt;
				
				temp[t][i] = num;
				temp[t+1][i] = cnt;
				
				t+=2;
				max = Math.max(max, t);
				
			}
		  
		}
			if(max>100){max = 100;}
			  arr = new int[max][arr[0].length];
			  
//			  System.out.println("-----------------------");
//			  for(int a=0 ;a<max;a++){
//					for(int b=0;b<arr.length;b++){
//						System.out.print(temp[a][b]+" ");
//					}System.out.println();
//				}
//			  System.out.println("-----------------------");
			  
			    for(int a=0;a<max;a++){
			    	for(int b=0;b<arr[0].length;b++){
			    		arr[a][b] = temp[a][b];
			    	}
			    }
			    
			   if(R<max && C<arr[0].length && arr[R][C] == K) check = true;
//			   for(int a=0 ;a<arr.length;a++){
//					for(int b=0;b<max;b++){
//						System.out.print(arr[a][b]+" ");
//					}System.out.println();
//				}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()) -1;
		C = Integer.parseInt(st.nextToken()) -1;
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[3][3];
		
		
		for(int i=0;i<3;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(R<3 && C<3 && arr[R][C] == K) check = true; 
		//처음에 내건 조건이 배열의 범위를 초과할 수 있음 
		int time=0;
		while(true){
			if(time>100 ) break;
			if(check) break;
			if(arr.length >= arr[0].length) {// 행의 갯수 >= 열의 갯수 
				solveR();
			}else{
				solveC();
			}
			
			
			time++;
		}
		
		if(check){
			System.out.println(time);
		}else{
			System.out.println("-1");
		}
		
		
	}
}


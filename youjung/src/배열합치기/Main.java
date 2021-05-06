package 배열합치기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arrA = new int[N];
		int[] arrB = new int[M];
		LinkedList<Integer> list = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arrA[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++){
			arrB[i] = Integer.parseInt(st.nextToken());
		}
		
		int a =0; int b=0;
		 StringBuilder sb = new StringBuilder();
		while(a< N && b< M){
			if(arrA[a] < arrB[b]){
//				 list.add(arrA[a]);
				sb.append(arrA[a]+" ");
				 a++;
				}else{
//					list.add(arrB[b]);
					sb.append(arrB[b]+" ");
					b++;
			}
		}
		
		while(a<N){
			sb.append(arrA[a]+" ");
			a++;
		}
		while(b<M){
			sb.append(arrB[b]+" ");
			b++;
		}
		System.out.println(sb.toString().trim());
//		for(int s=0;s<list.size();s++){
//			System.out.print(list.get(s)+" ");
//		}
	}
}


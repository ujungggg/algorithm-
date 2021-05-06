package ��Ʈ��ũ����;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; 
	static int[] parent;
	static class Pair implements Comparable<Pair>{
		int num; int x; int y; int value;
		
		Pair(int num,int x, int y, int value){
			this.num = num;
			this.x= x;
			this.y=y;
			this.value = value;
		}
		
		@Override
		public int compareTo(Pair o) {
			return this.value- o.value;
		}
	}
	
	public static int findParent(int value){
		if(parent[value] == value) return value;
		else return parent[value] = findParent(parent[value]);
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken());
	   st = new StringTokenizer(br.readLine());
	   int M = Integer.parseInt(st.nextToken());
	   
	   parent = new int[N+1];
	   Pair[] list = new Pair[M];
	   for(int i=0;i<M;i++){
		   st = new StringTokenizer(br.readLine());
		   int x = Integer.parseInt(st.nextToken());
		   int y = Integer.parseInt(st.nextToken());
		   int value = Integer.parseInt(st.nextToken());
		   
		   list[i] = new Pair(i,x,y,value);
		   
	   }
	   Arrays.sort(list, (o1,o2) -> o1.value - o2.value);
	   for(int i=1;i<=N;i++){
		   parent[i] = i;
	   }
	   
	   int value = 0;
	   for(int i=0;i<M;i++){ //value���� ���� ������ �����鼭 parent �� �ٲ��ָ鼭 �׷��� �ϼ�
		   int a = findParent(list[i].x);
		   int b = findParent(list[i].y);
		   
		   if(a!=b){ // �θ� ���� ��������
			   
			   value += list[i].value;
			   
			   if (a<b){
				   parent[b] = a; 
			   }else{
				   parent[a] = b;
			   }
		   }
	   }
	   System.out.println(value);

}
}
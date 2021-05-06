package ����_���ο����2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

import ����_���ο����.Main.Pair;

public class Main {
	static int N,K;
	static LinkedList<Integer>[][] arr;
	static int[][] color;
	static Pair[] list;
	static int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
	static class Pair{
		int i; int x; int y; int d;
		Pair(int i, int x, int y, int d){
			this.i = i;
			this.x =x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static int changeDir(int d){
		if(d==0) return 1;
		if(d==1) return 0;
		if(d==2) return 3;
		else return 2;
	}
	
	public void move(int i){ //������ ������
		Pair temp = list[i];
		int index = temp.i;
		int x = temp.x;
		int y = temp.y;
		int d = temp.d;
		
		int nx = x+ dir[d][0];
		int ny = y+ dir[d][1];
		
		if(nx<0 || ny<0 || nx>=N || ny>=N || color[nx][ny] == 2){
			//�������� �Ѿ�ų� �Ķ���ĭ�̸� ������ �ٲ�
			int nd = changeDir(d);
			int nx2 = nx+ dir[nd][0];
			int ny2 = ny+ dir[nd][1];
			
			if( color[nx2][ny2] == 2){
				list[i] = new Pair(i,x,y,nd); 
				arr[x][y].add(i);
				//�� �̵��Ϸ��� ������ �Ķ����̸� ���⸸ �ٲ۴�
			}
			
		}
		if(color[nx][ny] ==0){ //����ΰ��
			int time = arr[x][y].indexOf(i); //i��° ��尡 ���°�� �ִ���
			int size = arr[x][y].size();
			
			for(int t=time;t<size;t++){
				int nowIndex = arr[x][y].remove(t);
				list[nowIndex] = new Pair(nowIndex,nx,ny,d); //index�� �����������?
				arr[nx][ny].add(nowIndex);
			}
		}else if(color[nx][ny]==1){
			int time = arr[x][y].indexOf(i); //i��° ��尡 ���°�� �ִ���
			int size = arr[x][y].size();
			
			for(int t=size-1;t>=time;t--){
				int nowIndex = arr[x][y].remove(t);
				list[nowIndex] = new Pair(nowIndex,nx,ny,d); //index�� �����������?
				arr[nx][ny].add(nowIndex);
			}
		}
		
	}
	
 public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	
	st = new StringTokenizer(br.readLine());
	N = Integer.parseInt(st.nextToken());
	K = Integer.parseInt(st.nextToken());
	
	arr = new LinkedList[N][N];
	color = new int[N][N];
	list = new Pair[K+1];
	
	for(int i=0;i<N;i++){
		st = new StringTokenizer(br.readLine());
		for(int j=0;j<N;j++){
			color[i][j] = Integer.parseInt(st.nextToken()); //���� ��Ÿ���ִ� �迭
			arr[i][j] = new LinkedList<>(); // ���� ���̰Ե� �迭
		}
	}
	for(int i=1;i<=K;i++){
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken())-1;
		int y = Integer.parseInt(st.nextToken())-1;
		int d = Integer.parseInt(st.nextToken())-1;
		
		list[i] = new Pair(i,x,y,d); 
		
	}
	
	
	int answer = 0;
	boolean flag = false;
	while(true){
		for(int i=1;i<=K;i++){
			
//			makeMove();
//
//			if(arr[x][y].size()>=4) {
//				flag = true;
//				break;
//			}
		}
		if(flag) break;
		answer++;
	}
	System.out.println(answer);
}
}


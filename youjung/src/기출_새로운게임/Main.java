package ����_���ο����;
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
	public static void move(int index,int cnt){ //���� ������ i �ε���
		int x = horse[index].x;
		int y = horse[index].y;
		int d = horse[index].d;  
		
		int nx = x+ dir[d][0];
		int ny = y+ dir[d][1];
		
		
		//list[x][y]�� �ִ� ��ǥ���� ��� nx,ny�� �Űܾ��ϴ� ��Ȳ
		if(nx<0 || ny<0 || ny>=N || nx>=N || arr[nx][ny]==2){
			//�� ����ų� �Ķ����̸� ���⸸ �ٲ�
			int newD = changeDir(d);
			if(cnt==0){
				horse[index] = new Pair(x,y,newD);
				move(index,1);
			}else{ //�ι�°�� ���
//				horse[index] = new Pair(x,y,newD);
				
//				int size = list[x][y].size();
				int newIndex = list[x][y].get(0);
				horse[newIndex] = new Pair(x,y,d); //�ٲٷ��� �ߴ��� ���⸸ �ٲ�
				if(list[x][y].size()>=4){
					check = true;
					return;
				}
				/*
				for(int s=0;s<size;s++){
					int newIndex = list[x][y].remove();
					// horse[x][y] �� ��ǥ x  
					list[nx][ny].add(newIndex);
					
					if(s==0){
						horse[newIndex] = new Pair(nx,ny,newD); //�ٲٷ��� �ߴ��� ���⸸ �ٲ�
					}else{
						horse[newIndex] = new Pair(nx,ny,horse[newIndex].d);
					}
					
					
				}
				*/
			}
			
		}else if(arr[nx][ny]==1){
			//�� �������̸�  �ݴ�� ����
			int size = list[x][y].size();
			
			while(size>0){
				int newIndex = list[x][y].removeLast();
				// horse[x][y] �� ��ǥ x  
				list[nx][ny].add(newIndex);
				horse[newIndex] = new Pair(nx,ny,horse[newIndex].d);
				size--;
			}
			if(list[nx][ny].size()>=4){
				check = true;
				return;
			}
		}else{ //����϶� ����Ʈ�� �ִ� ������� �ű�
			int size = list[x][y].size();
			
			for(int s=0;s<size;s++){
				int newIndex = list[x][y].remove();
				// horse[x][y] �� ��ǥ x  
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
				arr[i][j] = Integer.parseInt(st.nextToken()); //���� ����
			}
		}
		//����Ʈ�� ���� ���� ����
		//�� �ϳ��� ���� (��ǥ, ����)
		
		for(int i=1;i<=K;i++){
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken()) -1;
			int d = Integer.parseInt(st.nextToken())-1;
			
			horse[i] = new Pair(x,y,d); //���ϳ� ����� ����
			list[x][y].add(i); // ���� ���� �ִ� ���� ����
					
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
				
				if(list[x][y].get(0) == i){ //���� �� ��ǥ���� ���� ó������ �ִ°Ÿ�
					
					move(i,0); //�ε��� ������ ������
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


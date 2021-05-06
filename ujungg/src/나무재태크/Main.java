package ��������ũ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1. ArrayList���� LinkedList�� ������ �� ����.
	2. LinkedList�� ���� add�ϰ� poll�ϴ°��� ���� ���ÿ����÷ο츦 �� �� �ִ�. ���� get���� �����ϰų� iterator�� ������ ����ϴ� ���� ���ɿ� ����.
	3. �����ְ� ���� �������� ������ �ٷ� ���μ����� ������ �� �ִ� ������ ¥���Ѵ�.
 * */
public class Main {
	static int[][] arr;
	static int[][] map;
	static int N; 
	
	static LinkedList<Pair> list = new LinkedList<>();
	
	static class Pair {
		int x; int y; int age; boolean alive;
		Pair(int x, int y,int age,boolean alive){
			this.x = x;
			this.y = y;
			this.age = age;
			this.alive = alive;
			
		}
	}
	
	static void solve(int time){
		int t =0;
		while(t<time){
			
			//��
			for(Pair s: list){
				if(map[s.x][s.y] >= s.age){
					map[s.x][s.y] -= s.age;
					s.age ++;
				}else{
					//��о����� ����
					s.alive = false;
				}
			}
			
			//����
			
//			 for(Iterator<Pair> itt = list.iterator(); itt.hasNext();){
//	                Pair temp= itt.next();
//	                if(!temp.alive){
//	                    map[temp.x][temp.y] += (temp.age / 2);
//	                    itt.remove();;
//	                }
//	            }
			 
			LinkedList<Pair> temp = new LinkedList<>();
			
			int size = list.size();
			for(int s1=0;s1<size;s1++){
				Pair s = list.get(s1);
				if(!s.alive){ //�׾�������
					map[s.x][s.y] += (s.age/2);
				}else{
					temp.add(new Pair(s.x,s.y,s.age,s.alive));
				}
			}
			list = temp;
			 
			//����
			LinkedList<Pair> newTree  = new LinkedList<>();
//			int size2 = list.size();
//			for(int s1=0;s1<size2;s1++){   //�ð��ʰ�!!
			for(Pair s : list){
//				Pair s = list.get(s1);      
//				System.out.println(s.age);
				if(s.age > 0 && s.age %5 ==0){
					int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
					for(int d=0;d<8;d++){
						int x = s.x + dir[d][0];
						int y = s.y + dir[d][1];
						
						if(x<1 || y<1 || x>N || y>N) continue;
						newTree.add(new Pair(x,y,1,true)); //���ο� �迭�� 1�� �־���
					}
				}
			}
			list.addAll(0, newTree); //list�� �պκп������� newTree�� �־��� -> ���� ������ ���� �Ǿ�����
			
			if(t==time-1) { //�ð� ����. �����
                return;
            }
			//�ܿ�
			for(int i=1;i<=N;i++){
				for(int j=1;j<=N;j++){
					map[i][j] += arr[i][j]; //����߰�
				}
			}
			
			t++;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		map = new int[N+1][N+1];
		
				
		int M = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());
		for(int[] row : map){
			Arrays.fill(row, 5);  //�ð� ����
		}
		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
//				map[i][j] = 5; //��������
			}
		}
		for(int m=0;m<M;m++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			
			list.add(new Pair(x,y,age,true));
		}
		
		solve(time);
		int count =0;
		
		for(Pair s: list){
//			System.out.println(s.x+" "+s.y+" "+s.age+" "+s.alive);
			if(s.alive){
				count++;
			}
		}
		System.out.println(count);
	}
}
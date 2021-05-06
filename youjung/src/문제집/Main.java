package ������;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] arr = new ArrayList[N+1] ;
		for(int i=1;i<=N;i++){
			arr[i] = new ArrayList<>(); //LinkedList�� ������ �ð��ʰ��� ��
		}
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		int[] degree = new int[N+1];
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			degree[b] ++;
			
		}
		
		//���������� 0�� ��带 ť�� ����
		for(int i=1;i<=N;i++){
			if(degree[i] ==0){
				que.add(i);
			}
		}
		
		//���������� ������ ����Ƿ��� ����� ����ŭ�� N�� �����Ѵ�
		while(!que.isEmpty()){
			//n���� �湮�ϱ� ���� �̹� que�� empty�� �Ǹ� ����Ŭ�� �߻��Ѱ�
			
		
			int num = que.remove();
			System.out.print(num+" ");
			
			int size = arr[num].size();
			for(int s=0;s<size;s++){
				int temp = arr[num].get(s);
				degree[temp] --;
				if(degree[temp]==0){
					que.add(temp);
				}
			}
			
		}
	
		
	}
}




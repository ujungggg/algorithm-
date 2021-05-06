package ������ť;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static class Pair{
		int x; boolean point;
		
		Pair(int x, boolean point){
			this.x=x; 
			this.point = point;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
//			boolean[] visit = new boolean[N];
//			visit[M] = true;
			
			Queue<Pair> que = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for(int n=0;n<N;n++){
				if(n==M){
					que.add(new Pair(Integer.parseInt(st.nextToken()),true));
				}else{
					que.add(new Pair(Integer.parseInt(st.nextToken()),false));
				}
			}
			
			int time = 0;
			while(true){
				
				Pair temp = que.poll();
				int x = temp.x;
				
				int size = que.size();
				boolean flag = false;
				
				Iterator it = que.iterator();
				while(it.hasNext()){
					Pair temp2 = (Pair) it.next();
					if(temp2.x > x){
						que.add(new Pair(x, temp.point));
						flag = true;
						break;
					}
				}
//				for(int s=0;s<size;s++){
//					Pair temp2 = que.get(s);
//					if(temp2.x > x){
//						que.add(new Pair(x, temp.point));
//						flag = true;
//						break;
//					}
//				}
				
				if(!flag){ // �켱������ �� ū�� ��� �ڷ� �������� ���ٴ� ��
					time++;
					if(temp.point){ // ��ħ ���� ���� �ñ��ߴ� �����ΰŸ� ����
						 
						break;
					}
				}
				
			}
			System.out.println(time);
		}
		
		
	}
}




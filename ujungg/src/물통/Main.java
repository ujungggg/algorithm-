package 물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static int[][][] visit = new int[201][201][201]; // 한번 조합이 생성된 경우는 제외하기 위해 
	public static int a; 
	public static int b; 
	public static int c; 
	public static LinkedList<Integer> ans = new LinkedList<>(); 
	public static LinkedList<Pair> list = new LinkedList<>();
	
	static class Pair{
		int x; int y; int z;
		Pair(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void solve(){
		
		while(!list.isEmpty()){
			Pair temp = list.remove();
			int x = temp.x;
			int y = temp.y;
			int z = temp.z;
			
			int x1 = x;
			int y1 = y;
			int z1 = z;
//			System.out.println(x+" "+y+" "+z);
			if(x==0){
				ans.add(z);
			}
			
			
			if(x>0){
				//x -> y
				 // x가 0이 되거나 y가 b가 될때까지 
				if(x+y <= b ){
					y += x;
					x = 0;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
					
				}else if(x+y > b){
					x -= (b-y);
					y = b;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
			      x= x1;
			      y = y1;
			      z = z1;
				//x -> z
				if(x+z <= c){
					z += x;
					x = 0;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}else if(x+z > c){
					x -= (c-z);
					z= c;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
			}
		    x= x1;
		      y = y1;
		      z = z1;
			if(y>0){
				//y->x
				if(x+y <= a){
					x += y;
					y =0;
					
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}else if(x+y > a){
					y -= (a-x);
					x = a;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
			    x= x1;
			      y = y1;
			      z = z1;
				//y->z
				if(y+z <= c){
					z += y;
					y = 0;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}else if(y+z > c){
					y -= (c-z);
					z= c;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
				
			}
		    x= x1;
		      y = y1;
		      z = z1;
			if(z>0){
				// z->x
				if(x+z <= a){
					x += z;
					z = 0;
					
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}else if(x+z > a){
					z -= (a-x);
					x = a;
					
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
			    x= x1;
			      y = y1;
			      z = z1;
				// z->y
				if(y+z <= b){
					y += z;
					z =0;
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}else if(y+z > b){
					z -= (b-y);
					y = b;
					
					if(visit[x][y][z]==0){
						visit[x][y][z]=1;
						list.add(new Pair(x,y,z));
					}
				}
			}
		}
		
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	   
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st;
	   
	   st = new StringTokenizer(br.readLine());
	   a= Integer.parseInt(st.nextToken());
	   b= Integer.parseInt(st.nextToken());
	   c= Integer.parseInt(st.nextToken());
	   
	   // c가 0이 될때까지 bfs 돌려봄 c->a, c->b a->b a->c b->a b->c 
	   
	   visit[0][0][c] = 1;
	   list.add(new Pair(0,0,c));
	   solve();
	   
	   Collections.sort(ans);
	   for(int s=0;s<ans.size();s++){
		  System.out.print(ans.get(s)+" ");
		  
	   }
}
}
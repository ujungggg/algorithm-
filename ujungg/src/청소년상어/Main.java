package û�ҳ���;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr = new int[4][4];
	static int[][] direc = new int[4][4];
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int eat = 0;
	static LinkedList<Pair> sharks = new LinkedList<>();
	static LinkedList<Pair> fish = new LinkedList<>();
	
	static class Pair{
		int x; int y; //int d;
	    Pair(int x, int y){
	    	this.x = x;
	    	this.y=y ;
	    	//this.d=d;
	    }
	}
	
	static void solve(){
		
		while(true){
			  for(int i=0;i<4;i++){
				  for(int j=0;j<4;j++){
					  System.out.print(direc[i][j]+" ");
				  }System.out.println();
			  }System.out.println();
			  
			int fish1 = 17; 
			//���� fish ã�� 
			  int startFishX =0; int startFishY =0;
			  for(int i=0;i<4;i++){
				  for(int j=0;j<4;j++){
					  if(arr[i][j]<fish1 && arr[i][j]!=0){
						  fish1 = arr[i][j];
						  startFishX = i;
						  startFishY = j;
					  }
				  }
			  }
//			  fish.add(new Pair(startFishX,startFishY));
//			while(!fish.isEmpty()){ //����� �̵�
				 for(int i=0;i<4;i++){
					  for(int j=0;j<4;j++){
						  System.out.print(arr[i][j]+" ");
					  }System.out.println();
				  }System.out.println();
				  
//			     Pair temp = fish.remove();
//			     int startX = temp.x; int startY = temp.y;
//			     int startD = direc[startX][startY];
			   
			     int startD = direc[startFishX][startFishY];
			     int d = startD;
			     int x = startFishX + dir[d][0];
			     int y = startFishY + dir[d][1];
			     
			     boolean flag = true;
			     //�̵��Ҽ��ִ°��� ���ö����� �ݽð� 45������ �����δ�
			     while(x < 0 || y < 0 || x >=4 || y>=4 || arr[x][y]==0){
			    	 x -= dir[d%7][0];
			    	 y-= dir[d%7][1];
			    	 if(d > startD+7) { 
				    		flag = false; 
				    		break; //�̹� 7������ ��� Ž�������� �ݺ��� ������ ����⵵ �̵��� �� ����
				    	}
			    	 d++;
			    	 x += dir[d%7][0];
			    	 y += dir[d%7][1];
			    	 
			     }
			  
			     if(flag){ //����Ⱑ �̵��� ������ �ִ� ��츸
			    	  fish.add(new Pair(x,y));
					     int temps = arr[startFishX][startFishY];
					     arr[startFishX][startFishY] = arr[x][y];
					     arr[x][y] = temps;
					     
					     direc[startFishX][startFishY] = direc[x][y];
					     direc[x][y] = (d%7) ;//�ٲ� ���� �ֱ�
			     }else{
			    	 //������ ����
			    	 return;
			     }
//			}
		}
		
	}
	
	public static void sharksEat(int startX, int startY){
		
		
//		Pair temp = sharks.remove();
//		int startX = temp.x; 
//		int startY = temp.y;
//		int maxFishSize =0;
//		
//		int xx = startX; int yy = startY;
//		int pointX =0; int pointY =0;
//		boolean flags = false;
//		xx += dir[direc[startX][startY]][0];
//		yy += dir[direc[startX][startY]][1];
//		while(xx>=0 && yy >=0 && xx < 4 && yy <4 && arr[xx][yy]!=0){ //�����ȿ� �ְ� ������ ����������
//			flags = true;
//			if(maxFishSize < arr[xx][yy]){
//				maxFishSize = arr[xx][yy];
//				pointX = xx; pointY = yy; //������ �ִ밪�� ����
//			}
//			xx += dir[direc[startX][startY]][0];
//			yy += dir[direc[startX][startY]][1];
//			
//		}
//		
//		if(flags){ //�� �����Ű� ���� ���
//			eat += arr[pointX][pointY];
//			arr[pointX][pointY] =0; //�Ծ ����
////			direc[pointX][pointY] = direc[startX][startY]; //����� ������ ���� �ִ� ĭ�� ����� ����
//			sharks.add(new Pair(pointX,pointY));
//		}else{
//			return;
//		}
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  
	  for(int i=0;i<4;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<4;j++){
			  arr[i][j] = Integer.parseInt(st.nextToken());
			  direc[i][j] = Integer.parseInt(st.nextToken())-1;
		  }
	  }

	  sharks.add(new Pair(0,0));
	  arr[0][0]=0; //�� ����
	  
//	  int fish1 = 17; 
//	  int startX =0; int startY =0;
//	  for(int i=0;i<4;i++){
//		  for(int j=0;j<4;j++){
//			  if(arr[i][j]<fish1){
//				  fish1 = arr[i][j];
//				  startX = i;
//				  startY = j;
//			  }
//		  }
//	  }
//	  fish.add(new Pair(startX,startY));
	 
	  solve();
	  sharksEat(0,0);
	  System.out.println("eat"+ eat);
}
}
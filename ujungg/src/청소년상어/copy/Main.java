package û�ҳ���.copy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.StreamPrintService;

public class Main {
	
	static int[][] firstArr = new int[4][4];
	static int[][] dir = {{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
	static int max =0;
	static Pair[] firstFish = new Pair[17];
	static LinkedList<Pair> sharks = new LinkedList<>();
	static class Pair{
		int x; int y; int d;
		Pair(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	static void dfs(int[][] firstArr, Pair[] firstFish, int eat){
		int[][] arr = new int[4][4];
		for(int k=0;k<4;k++){
			 System.arraycopy(firstArr[k], 0, arr[k], 0, 4);
		}
		
		Pair[] fish = new Pair[17];
		for(int i=1;i<=16;i++){
			fish[i] = new Pair(firstFish[i].x, firstFish[i].y, firstFish[i].d);
		}
		boolean check = false;
		for(int i=1;i<=16;i++){ //������� ������� �����δ�.
			for(int a=0;a<4;a++){
				for(int j=0;j<4;j++){
					System.out.print(arr[a][j]+" ");
				}System.out.println();
			}
			System.out.println();
			int startX = fish[i].x;
			int startY = fish[i].y;
			int startD =  fish[i].d;
			System.out.println("�̹� ����!!!!!!!!"+i);
			if(startD != -1){ //�̹� ���� ����Ⱑ �ƴҶ�
				check = true;
				int d =startD;
				int x = startX + dir[d][0];
				int y = startY +dir[d][1];
				
				boolean flag = true;
			     //�̵��Ҽ��ִ°��� ���ö����� �ݽð� 45������ �����δ�
				
				
				 while(x < 0 || y < 0 || x >=4 || y>=4 || arr[x][y] == -1){ // -1�� ����ϰ��
			    	 x -= dir[d%8][0];
			    	 y-= dir[d%8][1];
			    	 if(d > startD+7) { 
				    		flag = false; 
				    		break; //�̹� 7������ ��� Ž�������� �ݺ��� ������ ����⵵ �̵��� �� ����
				    	}
			    	 d++;
			    	 x += dir[d%8][0];
			    	 y += dir[d%8][1];
			    	 
			     }
				 
				 if(flag){ //����Ⱑ �̵��� ������ �ִ� ��츸
					 if( arr[x][y]==0){ //�ű� ������ ��ĭ�̸� �׳� �ű�� ��
						 fish[arr[startX][startY]] = new Pair(x,y,d%8); //���ο� ��ǥ��
						
						 arr[x][y]= arr[startX][startY]; //�ű�� �ڸ��� �� �־��ְ�
						 arr[startX][startY]=0; // �� (�� ���� �ڸ�)
						 
					 }else if(arr[x][y]>0){ //�ű� ���⿡ ����Ⱑ ������
						 fish[arr[startX][startY]] = new Pair(x,y,d%8); //��ǥ�� ���� �ٲ���
					     fish[arr[x][y]] = new Pair(startX,startY,fish[arr[x][y]].d);
					     
					     int temps = arr[startX][startY];
					     arr[startX][startY] = arr[x][y];
					     arr[x][y] = temps; //��ǥ �ٲٰ� 
					 }
				    
			     }
			}
			
		}
			
		Pair temp = sharks.remove();
		int startX = temp.x; 
		int startY = temp.y;
		int sharksDir = temp.d;
		
		boolean eatCheck = false;
		for(int i=1;i<=4;i++){ //4ĭ�� �ִ�ϱ� 
			int sx = startX + (dir[sharksDir][0] * i);
			int sy = startY + (dir[sharksDir][1] * i);	
			
			if(sx >=0 && sy>=0 && sx < 4 && sy <4){
				if(arr[sx][sy] >0 ){
					//���� �ִ� ����� ����
					eatCheck = true;
					int changeDir = fish[arr[sx][sy]].d; //���� �� �ڸ��� �ִ� ������� ����
					sharks.add(new Pair(sx,sy,changeDir)); //����� ���⵵ �ٲ������
					int nowEat = arr[sx][sy];
					fish[arr[sx][sy]] = new Pair(0,0,-1); // �� �����ִ� -1�� ó��
					arr[sx][sy] = -1; //����� ���� ��ġ�� -1�� ����
					arr[startX][startY]=0; //�� ���� �ִ� �ڸ��� ���ڸ��� �ٲ�
					
//					System.out.println("���� �����"+ (eat + nowEat));
					dfs(arr,fish, eat+nowEat );
					for(int a=0;a<4;a++){
					for(int j=0;j<4;j++){
						System.out.print(arr[a][j]+" ");
					}System.out.println();
				}
					
					arr[startX][startY] =-1;
					arr[sx][sy] = nowEat;
					fish[arr[sx][sy]] = new Pair(sx,sy,changeDir); //���󺹱�
				}
			}
		}

		if(!eatCheck){
//			System.out.println("eat!!!!!!!!!!"+eat);
			max = Math.max(max, eat);
		}
		
			
	
	}
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringTokenizer st;
	  int[][] direc = new int[4][4];
	  for(int i=0;i<4;i++){
		  st = new StringTokenizer(br.readLine());
		  for(int j=0;j<4;j++){
			  int fishSize = Integer.parseInt(st.nextToken());
			  int fishDir = Integer.parseInt(st.nextToken())-1;
			  
			  firstFish[fishSize] = new Pair(i,j,fishDir); //fish�迭�� ��ǥ �־��� (���� ũ���� ���Ե�)
			  firstArr[i][j] = fishSize;
			  direc[i][j] = fishDir;
		  }
	  }

	  int eat = firstArr[0][0];
	  int sharksDir = firstFish[firstArr[0][0]].d;
	  sharks.add(new Pair(0,0,sharksDir));
	  firstFish[firstArr[0][0]]  = new Pair(0,0,-1); //0,0�� �ִ� fish�� ���� ó�� ���� (-1�� ������ ǥ����)
	  firstArr[0][0] = -1; // �� ����
//	  for(int i=0;i<4;i++){
//		  for(int j=0;j<4;j++){
//			  System.out.print(direc[i][j]+ " ");
//		  }System.out.println();
//	  }
	  dfs(firstArr, firstFish, eat);
	  System.out.println(max);
	
}
}
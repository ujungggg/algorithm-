package ��ɰ���;

import java.util.ArrayList;

class Solution {
	
	 public static void main(String[] args) {
	 int[] progresses = {95, 95, 95, 95};
	 int[] speeds = {4, 3, 2, 1};
	 solution(progresses, speeds);
		}
	 
	 static int total= 0;
	
	 public static int[] solution(int[] progresses, int[] speeds) {
		 int[] answer = {};
		 ArrayList<Integer> visit = new ArrayList<>();
		 int[] deploy = new int[progresses.length];
		 int [] arr = new int[progresses.length];
		 int stack =1;
		 for(int i=0;i<progresses.length;i++){
			 int left = (100-progresses[i])/ speeds[i];
			 if(((100-progresses[i]) % speeds[i]) !=0){ left += 1;}
			 
			 arr[i] = left ;
		 }
		 for(int i=0;i<arr.length;i++){
			 System.out.print(arr[i]+" ");
		 }System.out.println();
		 visit.add(arr[0]);
		 deploy[0] = 1;
		
		 int point = stack-1; //���� �ֱ� �ִ밪�̿��� ��
		 //stack : ȭ��ǥ -> �ϳ��� ������
		 while(stack < arr.length){
			 
			 if(arr[stack]<=visit.get(point)){
				 deploy[point]++; // �ֱ��� �������� +1
				stack++;
			 }else{ //���� ũ�� ���ο� ���������� �߰�
				 visit.add(arr[stack]);
				 deploy[point+1] +=1;
				 stack++;
				 point++;
			 }	 
			
		 }
		 
		 ArrayList<Integer> an = new ArrayList<>();
		 
		 for(int i=0;i<deploy.length;i++){
			 System.out.println(deploy[i]);
			 if(deploy[i]!=0){
				 an.add(deploy[i]);
			 }
		 }
		 answer = new int[an.size()];
		 for(int i=0;i<an.size();i++){
			 answer[i] = an.get(i);
//			System.out.println(answer[i]);
		 }
		 return answer;
    	
    }
   
}
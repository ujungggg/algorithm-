package 체육복_그리디;



class Solution {
	 public static void main(String[] args) {
	 
	int n = 5;
	int[] lost ={1};
	int[] reserve = {1};
	
	  solution(n, lost, reserve);
		}
	
	 public static int solution(int n, int[] lost, int[] reserve) {
		
		 int[] visit = new int[n+1];
		 
		 for(int i=0;i<lost.length;i++){
			 visit[lost[i]] -=1;
		 }
		 for(int i=0;i<reserve.length;i++){
			 visit[reserve[i]] += 1;
		 }
		 for(int i=1;i<=n;i++){
			 System.out.print(visit[i]+" ");
		 }System.out.println();
		 
		 for(int i=1;i<n+1;i++){
			 if(visit[i]==-1){
				if(i<n && visit[i+1] == 1 ){
					visit[i+1]-=1;
					visit[i]+=1;
				}
				if(i>1 && visit[i-1] ==1){
					visit[i-1] -=1;
					visit[i]+=1;
				}
			 }
		 }
		 int answer =0;
		 for(int i=1;i<=n;i++){
			 System.out.print(visit[i]+" ");
			if(visit[i] >=0 ){
				answer ++;
			}
		 }
		System.out.println(answer);
		 return answer;
    	
    }
   
}
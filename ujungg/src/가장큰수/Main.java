package 가장큰수;
import java.util.*;
class Solution {
    public static int max =0;
    public static int[] visit ;
    public static void main(String[] args) {
		int[] numbers = {3, 30, 34, 5, 9};
//    	int[] numbers = {0,0,0}; //34331 
		solution(numbers);
	}
    /*
    public static void solve(int[] numbers, int n,int start,int cnt,String num,String before){
        if(cnt == n){
        	int maxNum = Integer.parseInt(num);
//        	System.out.println(maxNum);
            max = Math.max(maxNum, max);
            
            return;
        }else{
            for(int s=start;s<numbers.length;s++){
            	if(visit[s]==0){
            		visit[s] = 1;
            		 before = num;
                 	 num += (numbers[s]);
                 	 solve(numbers,n,s+1,cnt+1,num,before);
                 	 visit[s] = 0;
                 	 num = before;
            	}
               
                
               
               
            }
        }
    }*/
    
    //31 3 34     vs  34 3 31
    public static String solution(int[] numbers) {
    	  String[] list = new String[numbers.length];
	        for(int i=0;i<numbers.length;i++){
	            list[i] = String.valueOf(numbers[i]);
	            
	        }
	        Arrays.sort(list,(o1,o2)->(o2+o1).compareTo(o1+o2));
	        String answer ="";
	        
	        if(list[0].equals("0")){
	        	return "0";
	        }
	        for(int i=0;i<numbers.length;i++){
	        	answer += list[i];
	        }
	       System.out.println(answer);
	       
	        return answer;
//    	visit = new int[numbers.length];
//        solve(numbers,numbers.length,0,0,"","");
//        String answer = Integer.toString(max);
//        System.out.println(answer);
//        return answer;
    }
}
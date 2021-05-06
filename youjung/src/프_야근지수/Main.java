package 프_야근지수;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] works = {4,3,3};
		int n = 4;
		solution(n,works);
	}
    public static long solution(int n, int[] nworks) {
       Integer[] works = Arrays.stream(nworks).boxed().toArray(Integer[]::new);
       Arrays.sort(works,Collections.reverseOrder());
        
       /*
        int total = works.length;
        while( n / total > 0 ){
            int minus = n / total ;
            for(int i=0;i<total ;i++){
                if( works[i] - minus>=0){
                    works[i] -= minus;
                    n -= minus;
                }else{
                    works[i] = 0;
                }
            }
        }
        long answer = 0;
        for(int i=0;i<total;i++){
            if(n>0){
            	if(works[i]-1>=0){
            		works[i] --;
                    n--;
            	}
                
            }
            
            answer += Math.pow(works[i],2);
        }
        */
       
       int total = works.length;
       int minus = n/total;
       for(int i=0;i<total;i++){
    	   System.out.println(works[i]);
       }
       for(int i=0;i< total;i++){
    	   if(n<= 0) break;
    	   if(works[i]-minus>=0){
    		   System.out.println(works[i]);
    		   works[i] -= minus;
    		   System.out.println(works[i]);
    		   n -= minus;
    	   }
    	  
       }   
       for(int i=0;i<total;i++){
    	   System.out.print(works[i]+" ");
       }
       long answer =0;
       if(n>0){
    	   for(int i=0;i< total;i++){
        	   if(n<= 0) break;
        	   if(works[i]-1>=0){
        		   works[i] -= 1;
        		   n -= 1;
        	   }
        	
        	   answer += Math.pow(works[i], 2);
           }   
    	  
       }
      
        System.out.println(answer);
        return answer;
    }
}
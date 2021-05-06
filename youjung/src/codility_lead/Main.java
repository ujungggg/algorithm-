package codility_lead;
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 
	public static void main(String[] args) {
		int[] A = {1};
		solution(A);
	}
public static int solution(int[] A) {

 
  HashMap<Integer,Integer> hash = new HashMap<>();
  int max =0;
  int maxValue = 0;
   boolean flag = false;
  for(int i=0;i<A.length;i++){

      if(hash.containsKey(A[i])){
          int cnt = hash.get(A[i])+1;
          hash.put(A[i],cnt);
          if(max < cnt){
              max = cnt;
              maxValue = i;
              flag = true;
          }
      }else{
    	  
     	 hash.put(A[i],1);
          
     	 if(!flag){
     		 max = 1;
     		 maxValue = i;
     	 }
      }
     
  }

  if(max > A.length/2){
// 	  System.out.println(maxValue);
      return maxValue;
  }else{
//	  System.out.println("??");
      return -1;
  }
  // write your code in Java SE 8
}
}



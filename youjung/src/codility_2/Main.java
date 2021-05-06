package codility_2;
//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	public static void main(String[] args) {
		solution(101);
	}
 public static int solution(int N) {
   
   int cnt =0;
   int min = Integer.MAX_VALUE;
   int a=1; int b=N;
   while(a<=b){
       cnt = (a+b) *2;
       System.out.println(cnt);
       min = Math.min(cnt, min);
       a++;
       while(true){
         if(N% a ==0){
           b = N/a;
           break;
         }
         else{
             a++;
         }
       }
   }
   System.out.println(min);
   return min;
 }
}


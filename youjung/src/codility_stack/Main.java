package codility_stack;
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	
	public static void main(String[] args) {
		int[] A = {4,3,2,1,5};
		int[] B = {0,1,0,0,0};
		
		solution(A,B);
	}
 public static int solution(int[] A, int[] B) {
    Stack<Integer> downFish = new Stack<>();
     int upFish = 0;
    for(int i=0;i<B.length;i++){
        if(B[i] ==0){
            if(downFish.size() ==0){
                 upFish ++;
            }else{
                while(!downFish.isEmpty()){
                    int num = downFish.peek();

                    System.out.println(num+" "+A[i]);
                    if(num< A[i]){
                        downFish.pop();
                    }else{
                        break;
                    }
                }
                 if(downFish.size() ==0){
                     upFish ++;
                 }


            }


        }else { //B[i] ==1ÀÌ¸י
             downFish.add(A[i]);
        }
    }

    int totalSize = upFish + downFish.size();
    return totalSize;
 }
}


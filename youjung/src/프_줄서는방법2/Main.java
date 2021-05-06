package 프_줄서는방법2;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int n = 3;
		int k = 5;
		solution(n,k);
	}
    public static int[] solution(int n, long k) {
    	
    	LinkedList<Integer> numList = new LinkedList<>();

    	k--;
    	long facNum = 1;
    	for(int i=1;i<=n;i++){
			numList.add(i);
			facNum *= i;
		}
    	int[] answer = new int[n];
    	int result =0;
    	
    	while(n>0){
    		
    		facNum /= n;
    		
    		
    		answer[result++] = numList.get((int) (k / facNum));
    		numList.remove((int) (k / facNum));
    		
    		k = (k % facNum);
    		n--;
    	}
       
        return answer;
    }
}

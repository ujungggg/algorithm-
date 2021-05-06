package 프_카펫;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int brown = 24;
		int yellow = 24;
		
		solution(brown, yellow);
	}
	
	public static int solve(int x,int total, int yellow){
		int y = total- x;
		
		if((x-2)*(y-2) == yellow && x>=y){
			return y;
		}else{
			return solve(x+1,total,yellow);
		}
	}
    public static int[] solution(int brown, int yellow) {
    	
    	//가로 x 세로 y
    	
    	int total = (brown + 4)/2; //total은 x+y 한값
    	
    	//조합을 만들기
    	int y = solve(3,total,yellow);
    	int x = total - y;
    	System.out.println(x+" "+y);
        int[] answer = {x,y};
        return answer;
        
        	
    }
}
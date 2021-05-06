package 프_구명보트;
import java.util.*;

class Solution {
	
	
	public static void main(String[] args) {
		int[] scoville = {10, 30, 40, 50 ,60, 70 ,90 }	;
		int limit = 100;
		solution(scoville,limit);
	}
	
	public static int solution(int[] people, int limit) {
		
		Arrays.sort(people);
		int start = 0;
		int last = people.length -1;
		
		 int answer = 0;
		while(start <= last){
			if(start == last) {
				answer ++;
				break;
			}
			if(people[start] + people[last]<= limit){
				start ++;
				last --;
				answer ++;
			}else{
				answer++;
				last --;
			}
		}
       System.out.println(answer);
        return answer;
    }
}


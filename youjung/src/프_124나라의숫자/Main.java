package 프_124나라의숫자;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int n = 19;
		solution(n);
	}
    public static String solution(int n) {
        
        StringBuilder sb = new StringBuilder();
        
        int m = 0;
        int left =0;
        while(n>0){
           m  = (n-1)/3; //몫
           left = (n-1) %3; //나머지
            n = m;
           
            if(left == 0){
                sb.insert(0,1);
            }else if(left == 1){
                sb.insert(0,2);
            }else if(left == 2){
                sb.insert(0,4);
            }
//            System.out.println(sb.toString());
        }
        System.out.println(sb.toString());
        String answer = sb.toString();
        return answer;
    }
}
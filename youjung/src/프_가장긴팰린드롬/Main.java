package 프_가장긴팰린드롬;
import java.util.*;

class Solution
{
	public static void main(String[] args) {
		String s = "abcdcba";
		
		solution(s);
	}
    public static int solution(String s)
    {
//    	int j=0;
    	int[] table = new int[s.length()];
    	for(int j=0;j<s.length(); j++){
    		int tempJ = j;
    		for(int i=j+1;i<s.length();i++){
        		System.out.println(s.charAt(i)+" "+s.charAt(tempJ));
        		while(tempJ>0 && s.charAt(i) != s.charAt(tempJ)){
        			tempJ = table[tempJ-1]; //이전 인덱스로 이동
        		}
        		if(s.charAt(i) == s.charAt(tempJ)){
        			table[i] = ++tempJ; //j인덱스 증가
        		}
        	}
    	}
    	
    	for(int i=0;i<s.length();i++){
    		System.out.print(table[i]+" ");
    	}System.out.println();
        int answer = 0;


        return answer;
    }
}
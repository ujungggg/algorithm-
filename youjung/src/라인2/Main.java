package 라인2;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		String str = "CaCbCgCdC888834A";
		solution(str);
	}
    public static int[] solution(String inp_str) {
    	 boolean[] answer = new boolean[6];
    	 int index = 0;
    	 if(inp_str.length()<8 || inp_str.length() >15){
    		 if(!answer[1]){
    			 index++;
    			 answer[1] = true;
    		 }
    		
    	 }
    	 
    	 int big = 0; //대문자
    	 int small=0; //소문자
    	 int number =0; //숫자
    	 int charac = 0; //특수준자
    	 
    	 int before=0; int continues = 1; //연속해서 나타나는지
    	 boolean[] flag = new boolean[4]; //3지 종류 이상 넘었는지 알기 위해
    	for(int i=0;i<inp_str.length();i++){
    		char c = inp_str.charAt(i);
    		
    		if(c>= 'A' && c<='Z'){
    			big ++;
    			flag[0] = true;
    			
    			if(before == 1){ // 이전꺼도 1이였는데 또 1이 나오면
        			continues++;
    			}else{
    				continues = 1;
    			}
    			before = 1;
    			
    		}else if(c>='a' && c<='z'){
    			small++;
    			flag[1] = true;
    			if(before == 2){ // 이전꺼도 2이였는데 또 2이 나오면
        			continues++;
    			}else{
    				continues = 1;
    			}
    			before = 2;
    		}else if(c>='0' && c<='9'){
    			number++;
    			flag[2] = true;
    			if(before == 3){ // 이전꺼도 3이였는데 또3이 나오면
        			continues++;
    			}else{
    				continues = 1;
    			}
    			before = 3;
    		}else if(c=='~' || c== '!'|| c=='@' ||c=='#' ||c=='$' ||c=='%' ||c=='^' ||c=='&'|| c=='*'){
    			charac++;
    			flag[3] = true;
    			if(before == 4){ // 이전꺼도 4이였는데 또 4이 나오면
        			continues++;
    			}else{
    				continues = 1;
    			}
    			before = 4;
    		}else{
    			if(!answer[2]){
    				answer[2] =true;
    				index++;
    			}
    			
    		}
    		
    		if(continues>=4){
    			if(!answer[4]){
    				answer[4] = true;
    				index++;
    			}
    			
    		}
    	}
        int cnt =0;
        for(int i=0;i<4;i++){
        	if(flag[i]){
        		cnt++;
        	}
        }
        if(cnt<3){
        	if(!answer[3]){
        		index++;
        		answer[3] = true;
        	}
        	
        }
    	if(big>=5 || small>=5 || number>=5 || charac>=5 ){
    		if(!answer[5]){
        		index++;
        		answer[5] = true;
        	}
    	}
    	int[] result = new int[1];
    	if(index>0){
    		result = new int[index];
        	
        	int newIndex =0;
        	for(int i=1;i<=5;i++){
        		if(answer[i]){
        			result[newIndex++] = i;
        		}
        	
        	}
    	}else{
    		result[0] = 0;
    	}
    	
    	for(int i=0;i<index;i++){
    		System.out.println(result[i]);
    	}
    	
        return result;
    }
}
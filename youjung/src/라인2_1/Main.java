package ∂Û¿Œ2_1;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		String program ="line";
		String[] flag = {"-s STRING", "-n NUMBER", "-e NULL"};
		String[] comm ={"line -n 100 -s hi -e", "lien -s Bye"};
		
		solution(program,flag,comm);
	} 
	
	public static boolean checkString(String str){
		for(int i=0;i<str.length();i++){
			if(!((str.charAt(i)>='A' && str.charAt(i)<='Z')|| (str.charAt(i)>='a' && str.charAt(i)<='z'))){
				return false;
			}
		}
		return true;
	}
	public static boolean checkNum(String str){
		for(int i=0;i<str.length();i++){
			if(!(str.charAt(i)>='0' && str.charAt(i)<='9')){
				return false;
			}
		}
		return true;
	}
	public static boolean checkNull(String str){
//		for(int i=0;i<str.length();i++){
//			if(!((str.charAt(i)>='A' && str.charAt(i)<='Z')|| str.charAt(i)>='a' && str.charAt(i)<='z'))){
//				return false;
//			}
//		}
		return true;
	}
    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
    	
    	String[][] rules = new String[flag_rules.length][2];
    	for(int i=0;i<flag_rules.length;i++){
    		rules[i]= flag_rules[i].split(" ");
    		System.out.println(rules[i]);
    	}
    	
    	 boolean[] answer = new boolean[commands.length];
    	 
    	for(int i=0;i<commands.length;i++){
    		System.out.println(commands[i]);
    		String[] commandsArr  = commands[i].split(" ");
    		System.out.println(commandsArr.length);
    		if(!commandsArr[0].equals(program)){
				answer[i] = false;
				continue;
			}
    		for(int j=1;j<commandsArr.length;j++){
    			
    			for(int a=0;a<flag_rules.length ;a++){
    				System.out.println(commandsArr[j]);
    				System.out.println(rules[a][0]);
    				if(commandsArr[j].equals(rules[a][0])){
    					System.out.println(rules[a][1]);
    					if(rules[a][1].equals("STRING")){
    						j+=1;
    						if(!checkString(commandsArr[j+1])){
    							answer[i] = false;
    							
    						}
    					}else if(rules[a][1].equals("NUMBER")){
    						j+=1;
    						if(!checkNum(commandsArr[j+1])){
    							answer[i] = false;
    						}
    					}else if(rules[a][1].equals("NULL")){
    						if(!checkNull(commandsArr[j+1])){
    							answer[i] = false;
    						}
    						
    					}
    				
    				}
    			}
    				
    			
    			
    		}
    	}
       
        return answer;
    }
}
package ∂Û¿Œ1;
import java.util.*;
class Solution {
	public static void main(String[] args) {
//		String[] table = {AVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] table = {"ABC JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "AACB JAVA JAVASCRIPT PYTHON KOTLIN PHP", "AA C++ C# JAVASCRIPT C JAVA"};
		String[] lan = {"JAVA", "JAVASCRIPT"};
		int[] pre ={7,5};
		solution(table,lan,pre);
	}
    public static String solution(String[] table, String[] languages, int[] preference) {
    	
    	String[] splitTable = new String[7];
    	
    	ArrayList<String> lanList = new ArrayList<>();
    	for(int s=0;s<languages.length;s++){
    		lanList.add(languages[s]);
    	}
    	String answer = "";
    	int max =0;
    		for(int j=0;j<5;j++){
//    			System.out.println(table[j]);
    			splitTable = table[j].split(" ");
    			
    			
    			int total = 0; 
        		for(int b=1;b<=5;b++){
//        			System.out.println(splitTable[b]);
        			if(lanList.contains(splitTable[b])){
        				int index = lanList.indexOf(splitTable[b]);
//        				System.out.println(6-b);
//        				System.out.println(preference[index]);
        				total += ((6-b) * (preference[index]));
        			}
        		}	
//        		System.out.println(splitTable[0]+" "+total);
        		if(max == total){
        			if(answer.compareTo(splitTable[0]) > 0){
        				answer = splitTable[0];
        			}
        		}else if(max <total){
        			max = total;
        			answer = splitTable[0];
        			
        		}
        		
    		}
    		System.out.println(answer);
        return answer;
    }
}
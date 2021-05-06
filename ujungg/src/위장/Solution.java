package 위장;

import java.util.*;
class Solution {
	public static void main(String[] args) {
		String[][] clothes= {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		solution(clothes);
	}
    public static int solution(String[][] clothes) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0 ;i<clothes.length;i++){
        	//[i][0] : 종류 (키값) / [i][1] : 이름
        	
        	if(!map.containsKey(clothes[i][1])){
        		map.put(clothes[i][1], 1);
        	}else {
        		int numKey = map.get(clothes[i][1]);
        		System.out.println(numKey);
        		map.put(clothes[i][1], numKey+1);
        	}
        }
        
        int answer = 1;
       for(String key : map.keySet()){
    	   answer *= (map.get(key)+1);
       }
//        int answer = 1; (차이점은?)
//        for(int s=0;s<map.size();s++){
//        	System.out.println(map.get(clothes[s][1]));
//            answer *= (map.get(clothes[s][1]))+1;
//        }
        return answer-1;
    }
}
package µÎ°³»Ì¾Æ¼­;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;


class Solution {
	public static void main(String[] args) {
		int[] numbers = {5,0,2,7};
		
		solution(numbers);
	}
    public static int[] solution(int[] numbers) {
        LinkedList<Integer> hash = new LinkedList();
        
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                int value = numbers[i]+numbers[j];
                
                if(!hash.contains(value)){
                	hash.add(value);
                }
            }
        }
        Collections.sort(hash);
        int[] answer = new int[hash.size()];
        for(int i=0;i<hash.size();i++){
        	answer[i] = hash.get(i);
        	System.out.println(answer[i]);
        }
        return answer;
    }
}
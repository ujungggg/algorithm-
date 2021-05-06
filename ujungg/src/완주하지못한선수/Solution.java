package 완주하지못한선수;
import java.util.*;


class Solution {
public static void main(String[] args) {
	String[] participant = {"leo", "kiki", "eden"};
	String[] completion = {"eden", "kiki"};
	
	solution(participant,completion);
}
	public static String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();
        
        for(int s=0;s<participant.length;s++){
            if(!map1.containsKey(participant[s])){
                map1.put(participant[s],1);
            }else{
                int key = map1.get(participant[s]);
                  map1.put(participant[s],key+1);
            }
        }
        
        for(int s=0;s<completion.length;s++){
            if(!map2.containsKey(completion[s])){
                map2.put(completion[s],1);
            }else{
                int key = map2.get(completion[s]);
                  map2.put(completion[s],key+1);
            }
        }
        
        // LinkedList<String> ans = new LinkedList<>();
         String answer = "";
        Iterator<String> keys = map1.keySet().iterator();
        
        while(keys.hasNext()){
            String key = keys.next();
            if(!map2.containsKey(key)){
                answer = key;
            }else{
                if(map2.get(key) != map1.get(key)){
                     answer = key;
                }
            }
            
        }
        System.out.println(answer);
       
        
        return answer;
    }
}
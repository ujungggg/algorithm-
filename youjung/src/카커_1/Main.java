package īĿ_1;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		int[] gift_cards = {5,4,5,4,5};
		int[] wants = {1,2,3,5,4};
		
		solution(gift_cards, wants);
	}
    public static int solution(int[] gift_cards, int[] wants) {
    	
    	HashMap<Integer,Integer> gift = new HashMap<>();
    	HashMap<Integer,Integer> want = new HashMap<>();
    	
    	for(int i=0;i<gift_cards.length;i++){
    		if(gift.containsKey(gift_cards[i])){
    			int nums = gift.get(gift_cards[i]);
    			gift.put(gift_cards[i], nums+1);
    		}else{
    			gift.put(gift_cards[i], 1);
    		}
    	}
    	
    	for(int i=0;i<wants.length;i++){
    		if(want.containsKey(wants[i])){
    			int nums = gift.get(wants[i]);
    			want.put(wants[i], nums+1);
    		}else{
    			want.put(wants[i], 1);
    		}
    	}
    	
    	int total = 0;
    	
    	Iterator<Integer> keys = gift.keySet().iterator();
        while( keys.hasNext() ){
            int key = keys.next();
            int num = gift.get(key);
            
            if(want.containsKey(key)){
            	int wantNum = want.get(key);
            	
            	if(num> wantNum){
            		total += wantNum;
            	}else if(num<=wantNum){
            		total+= num;
            	}
            }
        }

	
        int answer = gift_cards.length - total;
        System.out.println(answer);
        return answer;
    }
}
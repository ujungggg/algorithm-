package 프_오픈채팅방;
import java.util.*;

class Solution {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
	}
    public static String[] solution(String[] record) {
        String[][] arr = new String[record.length+1][2];
        HashMap<String,String> map = new HashMap<>();
        
        int total = 0;
        for(int i=0;i<record.length;i++){
            String[] temp = record[i].split(" ");
            //temp[0]: 행위
            //temp[1]: id
            //temp[2]: 이름
            if(temp[0].equals("Enter")){
            	total++;
            	map.put(temp[1], temp[2]);
                arr[i][0] = "Enter";
                arr[i][1] = temp[1];
              
            }else if(temp[0].equals("Leave")){
            	total++;
                arr[i][0] = "Leave";
                arr[i][1] = temp[1];
            }else if(temp[0].equals("Change")){
            	map.put(temp[1], temp[2]);
            }
        }
        String[] answer = new String[record.length];
        int index =0 ;
        for(int i=0;i<record.length;i++){
        	System.out.println(arr[i][0]);
        	if(arr[i][0]!=null){
        		System.out.println("??");
        		if(arr[i][0].equals("Enter")){
            		answer[index++] = map.get(arr[i][1]) +"님이 들어왔습니다.";
            	}else if(arr[i][0].equals("Leave")){
            		answer[index++] = map.get(arr[i][1]) +"님이 나갔습니다.";
            	}	
        	}
        		
        }
        return answer;
    }
}

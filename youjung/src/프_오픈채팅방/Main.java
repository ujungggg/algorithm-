package ��_����ä�ù�;
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
            //temp[0]: ����
            //temp[1]: id
            //temp[2]: �̸�
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
            		answer[index++] = map.get(arr[i][1]) +"���� ���Խ��ϴ�.";
            	}else if(arr[i][0].equals("Leave")){
            		answer[index++] = map.get(arr[i][1]) +"���� �������ϴ�.";
            	}	
        	}
        		
        }
        return answer;
    }
}

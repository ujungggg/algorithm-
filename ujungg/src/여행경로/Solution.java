package 여행경로;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class Solution {
	
	public static void main(String[] args) {
//	 String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};	
	String[][] tickets ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
	 solution(tickets);
	}
	static int[] visit;
    static String[][] tickets;
    static String temp = "";
    static LinkedList<String> link = new LinkedList<>();
    public static void solve(int point, String start, int cnt,String[][] tickets){
    	 temp += (start+",");
        if(cnt == tickets.length){
            link.add(temp);
          
            
            // 배열 검사
        }else{
            for(int i=0;i<tickets.length;i++){
            	
                if(tickets[i][0].equals(start) && visit[i]==0){
                    visit[i]=1;
                    solve(i,tickets[i][1],cnt+1,tickets);
                    temp = temp.substring(0,temp.length()-4);
                    visit[i] =0;
                }
            }
        }
    }
    public static String[] solution(String[][] tickets) {
        
        visit = new int[tickets.length];
       
        for(int i=0;i<tickets.length;i++){
            if(tickets[i][0].equals("ICN")){
                visit[i] = 1;
                temp = ("ICN"+",");
                solve(i,tickets[i][1],1,tickets);
                temp = temp.substring(0,temp.length()-4);
                visit[i]=0;
            }
        }
        String[] answer = new String[link.get(0).length()];
        Collections.sort(link);
        answer =  link.get(0).split(",");
      
        return answer;
    }
   
}
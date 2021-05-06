package Ä«Ä«¿À2;

import java.util.ArrayList;

class Solution {
	
	 public static void main(String[] args) {
	
		 String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		 String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		 solution(info,query);
		}
	 
	 static int total= 0;
	
	 public static int[] solution(String[] info, String[] query) {
		
		 String[][] infos = new String[query.length][5];
		 String[][] querys = new String[query.length][5];
		 for(int a=0; a<info.length;a++){
//			 String temp = info[a].replaceAll("and"," ");
			 for(int b=0;b<5;b++){
//				infos[a][b] = temp.split(" ")[b];
			 }
		 }
 
		 for(int a=0; a<query.length;a++){
			 String temp = query[a].replaceAll(" and","");
			 for(int b=0;b<5;b++){
				querys[a][b] = temp.split(" ")[b];
			 }
		 }
		 ArrayList<Integer> arr = new ArrayList<>();
		 for(int i = 0 ; i < querys.length; ++i) {
	            int cnt = 0 ;
	            for(int j = 0 ; j < infos.length; ++j) {
	                if(querys[i][0].equals(infos[j][0]) || querys[i][0].equals("-")) {
	                    if(querys[i][1].equals(infos[j][1]) || querys[i][1].equals("-")) {
	                        if(querys[i][2].equals(infos[j][2]) || querys[i][2].equals("-")) {
	                            if(querys[i][3].equals(infos[j][3]) || querys[i][3].equals("-")) {
	                                if(Integer.parseInt(querys[i][4]) <= Integer.parseInt(infos[j][4]) || querys[i][4].equals("-")) {
	                                    ++cnt;
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            arr.add(cnt);
	    }
		System.out.println(arr);
		 int[] answer = new int[arr.size()];
		for(int s=0;s<arr.size();s++){
			answer[s] = arr.get(s);
			System.out.println(answer[s]);
		}
		
         return answer;
	 }
}
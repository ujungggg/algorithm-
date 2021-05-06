package 전화번호목록;



class Solution {
	
	
	 public static void main(String[] args) {
	 
	
	 String[] words ={"12","123","1235","567","88"};
	
	 solution(words);
		}
	 
	
	  public static boolean  solution(String[] phone_book) {
	        boolean flag = true;
	        for(int i=0;i<phone_book.length;i++){
	        	if(!flag) break;
	            for(int j=0;j<phone_book.length;j++){
	                if(i!=j && phone_book[i].length() < phone_book[j].length()){
	                	
	                	String temp = phone_book[j].substring(0,phone_book[i].length());
	                    if(temp.contains(phone_book[i])){
	                        flag = false;
	                        break;
	                    }
	                }
	            }
	        }
	        boolean answer = flag;
	        System.out.println(flag);
	        return answer;
	    }
   
}
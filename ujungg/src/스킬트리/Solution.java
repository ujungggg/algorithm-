package ��ųƮ��;



class Solution {
	
	 public static void main(String[] args) {
	
	String skill ="CBD";
//	String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
	String[] skill_trees = { "AAAABACA"};
	 solution(skill,skill_trees);
		}
	 
	 static int total= 0;
	
	 public static int solution(String skill, String[] skill_trees) {
	        int answer = 0;
	        
	        for(int i=0;i<skill_trees.length;i++){
	            String words = skill_trees[i];
	            
	            int before =-1 ;
	            boolean check = true;
	            
	            for(int b=0;b<skill.length();b++){  //�־��� ���ڿ�
	            	if(check){
	            		
	            		check = false;
	            		 for( int a=0;a<words.length();a++){ 
	 	                    if(a> before && skill.charAt(b) == (words.charAt(a))){ // ���� point���� ũ�� ���ڰ� ������
	 	                    	 check = true;
	 	                    	 before = a;
	 	                    	 break;
	 	                    }else if(a<before && skill.charAt(b) == (words.charAt(a))){ //���ڴ� ������ ���� point ���� ������ ����
	 	                    	break;
	 	                    }
	 	                    if(a==words.length()-1){ //�ܾ� �ȿ� �´� ���ڰ� ������ �׳� �Ѿ�� point�� ���� ū ���ڷ� 
	 	                    	check = true;
	 	                    	before = words.length();
	 	                    }
	 	                }
	            	}
	            }
	            if(check){
	            	answer ++;
	            }
	            
	        }
	        System.out.println(answer);
	        return answer;
	    }
   
}
package tex;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;




class Para{
	public void change(int a, int[] k){
		a= 20;
		k[3]= 400;
		System.out.println("i??"+a);
	}
	
	public void display(int i, int[] j){
		System.out.println("i "+i);
		System.out.println("j: ");
		for(int k=0;k<j.length;k++){
			System.out.print(j[k]+" ");
		}
	}
}
public class Test{
	public static void main(String[] args) {
		Para pp = new Para();
		int i = 10;
		int j[] = {1,2,3,4};
		pp.change(i, j);
		pp.display(i, j);
	}
}
package 잠시테스트;
import java.util.*;

class ClassP {
	int func1(int a, int b) {
		return (a+b);
	}
	int func2(int a, int b) {
		return (a-b);
	} 
	int func3(int a, int b) {
		return (a*b);
	}
	}
	public class ClassA extends ClassP {
		int func1(int a, int b) {
		return (a%b);
	}
		int func2(int a, int b) {
		return (a*b);
	}
	double func3(double a, double b) {
		return (a/b);
	}
	public static void main(String[] args) {
		ClassP P = new ClassA();
		System.out.print(P.func1(5, 2) + ", "
		+ P.func2(5, 2) + ", " + P.func3(5, 2));
	}
	}
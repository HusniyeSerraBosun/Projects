package exercises;
import java.util.*;
public class Basic_Calculator {
	public static void main(String[] args) {
		//This calculator performs four operations and mode operation.
		Scanner scanner=new Scanner(System.in);
		System.out.println("This calculator performs four operations and mode operation.");
		
		while(true) {
		double a,b,result;
		System.out.print("Please first number: ");
		a=scanner.nextDouble();
		System.out.print("Please second number: ");
		b=scanner.nextDouble();
		
		
		System.out.print("Choose the operation (+, -, *, /, %): ");
		String choice=scanner.next();
  
		if (choice.equals("+")) {
			result=a+b;
			System.out.println("Result is "+result);
			
		}else if (choice.equals("-")) {
			result=a-b;
			System.out.println("Result is "+result);
			
		}else if (choice.equals("*")) {
			result=a*b;
			System.out.println("Result is "+result);
			
		}else if (choice.equals("/")) {
			if(b!=0) {
				result=a/b;
				System.out.println("Result is "+result);
				
			}else {
				System.out.println("Error: Division by zero is not allowed!");
			}
		}else if (choice.equals("%")) {
			if(b!=0) {
				result=a%b;
				System.out.println("Result is "+result);
				
			}else {
				System.out.println("Error: Division by zero is not allowed!");
			}
		}else {
			System.out.println("Invalid operation!!! Please try again.");
		}
		
		}
	}
}
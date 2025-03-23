package bmi;
import java.util.*;
public class BmiTest {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		
		Bmi[]bmiArray=new Bmi[3];

		for(int i=0;i<bmiArray.length;i++) {
			System.out.println("---Enter Person " + (i + 1) + " Value---");
			System.out.print("Enter name, age, weight, height: (as space separated)\n");
			String userInput=scanner.nextLine();
			String[]inputValues=userInput.split(" ");
			
			String name=inputValues[0]+" "+inputValues[1];
			int age=Integer.parseInt(inputValues[2]);
			double weight=Double.parseDouble(inputValues[3]);
			double height=Double.parseDouble(inputValues[4]);
			
			bmiArray[i]=new Bmi(name,age,weight,height);
		}
		for(int i=0;i<bmiArray.length;i++) {
			System.out.println(
			"**The BMI result of "+bmiArray[i].getName()+
			"(Age: "+bmiArray[i].getAge()+
			" Weight: "+bmiArray[i].getWeight()+
			" Height: "+bmiArray[i].getHeight()+
			" ) is "+bmiArray[i].getStatus()
			);
		}

	}
}

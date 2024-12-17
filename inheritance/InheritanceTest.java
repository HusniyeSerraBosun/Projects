package lab_04_encapsulation_inheritance;

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base_Plus_Commission_Employee employee=new Base_Plus_Commission_Employee(1923.00,// base salary
				   																 "Hüsniye Serra",//first name
				   																 "Bosun",//last name
				   																 "221-805-033",//SSN
				   																 2022.00,//gross sales
				   																 0.1);//commission
		
		System.out.println("Employee information obtained by get methods and earnings:");
		System.out.println("---------------------------------------------------------");
		System.out.println("First name: "+employee.getfirstName()+
						   "\nLast name: "+employee.getlastName()+
						   "\nSocial security number:"+employee.getsocialSecurityNumber()+
						   "\nCommission Rate: "+employee.getcommissionRate()+
						   "\nBase salary: "+employee.getbaseSalary()+
						   "\nEarnings: "+employee.earnings());
		
	   employee.setbaseSalary(2500.00);

	   System.out.println("\nUpdated employee information obtained by toString and earnings:");
	   System.out.println("---------------------------------------------------------");
	   System.out.println(employee.toString());
	}

}

package lab_04_encapsulation_inheritance;

public class Base_Plus_Commission_Employee extends Commission_Employee {
	private double baseSalary;
	
	public Base_Plus_Commission_Employee() {
		super("Hüsniye Serra", "Bosun", "245-805-933", 2022.00, 0.1);
		this.baseSalary=1923.00;
	}
	public Base_Plus_Commission_Employee(double baseSalary,String firstName,String lastName,
										String socialSecurityNumber,double grossSales,
										double commissionRate) {
		super(firstName,lastName,socialSecurityNumber,grossSales,commissionRate);
		setbaseSalary(baseSalary);
	}
	public double getbaseSalary() {
		return baseSalary;
	}
	public void setbaseSalary(double baseSalary) {
		if(baseSalary<0) {
			throw new Error("Base salary cannot be negative. ");
		}
		this.baseSalary=baseSalary;
	}
	@Override
	public double earnings() {
		return super.earnings()+baseSalary;
	}
	@Override
	public String toString() {
		return  super.toString() + "\n" +
		        "Base Salary: " + baseSalary + "\n" +
		        "Total Earnings: " + earnings();
		
	}
}

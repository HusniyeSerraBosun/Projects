package lab_04_encapsulation_inheritance;

public class Commission_Employee {
		private String firstName;
		private String lastName;
		private String socialSecurityNumber;
		private double grossSales;
		private double commissionRate;
		
		public Commission_Employee() {
			String firstName="Hüsniye Serra";
			String lastName="Bosun";
			String socialSecurityNumber="221-805-033";
			double grossSales=2022.00;
			double commissionRate=2027.00;
		}
		
		public Commission_Employee(String firstName,String lastName,String socialSecurityNumber,
				                  double grossSales,double commissionRate) {
			this.firstName=firstName;
			this.lastName=lastName;
			this.socialSecurityNumber=socialSecurityNumber;
			this.grossSales=grossSales;
			this.commissionRate=commissionRate;
			setgrossSales(grossSales);
			setcommissionRate(commissionRate);
			
		}
		public String getfirstName() {
			return firstName;
		}
		public String getlastName() {
			return lastName;
		}
		public String getsocialSecurityNumber() {
			return socialSecurityNumber;
		}
		public double getgrossSales() {
			return grossSales;
		}
		public double getcommissionRate() {
			return commissionRate;
		}
		
		public void setfirstName(String firstName) {
			this.firstName=firstName;
		}
		public void setlastName(String lastName) {
			this.lastName=lastName;
		}
		public void setsocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber=socialSecurityNumber;
		}
		public void setgrossSales(double grossSales) {
			if(grossSales<0) {
				throw new Error("Gross sales cannot be negative.");
			}
			this.grossSales=grossSales;
		}
		public void setcommissionRate(double commissionRate) {
			if(commissionRate<=0 || commissionRate>1) {
				throw new Error("Commission rate must be between 0 and 1.");
			}
			this.commissionRate=commissionRate;
		}
		
		public double earnings() {
			return grossSales*commissionRate;
		}
		public String toString() {
			return "First Name: "+firstName+"\nLast Name: "+lastName+
					"\nSocial security number: "+socialSecurityNumber+
					"\nGross sales: "+grossSales+"\nCommision Rate: "+commissionRate;
		}
		
	

	}



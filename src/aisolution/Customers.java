package aisolution;

public class Customers {
	// field
	private Customer[] customerArr;
	private int arrLength; // 배열의 길이
	private Parameter parameter;
	private GroupType groupType;
	
	// constructor
	public Customers(GroupType groupType) {
		this.arrLength = 0;
		this.customerArr = null;
		this.groupType = groupType;
	}
	public Customers() {
		this.arrLength = 0;
		this.customerArr = null;
	}
	
	public Customers(Parameter parameter, GroupType groupType) {
		this.arrLength = 0;
		this.parameter = parameter;
		this.groupType = groupType;
	}

	// setter, getter
	public Customer[] getCustomerArr() {
		return customerArr;
	}

	public void setCustomerArr(Customer[] customerArr) {
		this.customerArr = customerArr;
	}

	public int getArrLength() {
		return arrLength;
	}

	public void setArrLength(int arrLength) {
		this.arrLength = arrLength;
	}
	
	public void init(int x) {
		Customer[] copy = new Customer[x];
		for(int i = 0; i < this.arrLength; i++) {
			copy[i] = this.customerArr[i];
		}
		this.customerArr = copy;
	}
	
	public void createCustomer(int x, int y) {
		for(int i = x; i < y; i ++) {
			this.customerArr[i] = new Customer();
		}
	}
	
	public void setAge(int x, int y) {
		this.customerArr[x].setAge(y);
	}
	
	public void setGender(int x, String y) {
		this.customerArr[x].setGender(y);
	}
	
	public void setLocation(int x, String y) {
		this.customerArr[x].setLocation(y);
	}
	
	public void setSpentTime(int x, int y) {
		this.customerArr[x].setSpentTime(y);
	}
	
	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

	public void editCostomerData(int x, int y) {
		if(y == 1) {
			
		}
	}
	
	public void creatCustomerArr(Customers c) {
		int count = 0;
		for(int i = 0; i < c.getArrLength(); i++) {
			if (this.parameter.classification(c.getCustomerArr()[i])) {
				count++;
			}
		}
		this.setCustomerArr(new Customer[count]);
		this.arrLength = count;
		int groupIdx = 0;
		for(int i = 0; i < c.getArrLength(); i++) {
			if (this.parameter.classification(c.getCustomerArr()[i])) {
				this.getCustomerArr()[groupIdx++] = c.getCustomerArr()[i];
				c.getCustomerArr()[i].setGroupType(this.groupType);
			}
		}
	}
	
	public void creatCustomerArr(Customers c, Parameters p) {
		int count = 0;
		for (int i = 0; i < c.getArrLength(); i++) {
			if (!(p.classification(c.getCustomerArr()[i]))) {
				count++;
			}
		}
		this.setCustomerArr(new Customer[count]);
		this.arrLength = count;
		int groupIdx = 0;
		for (int i = 0; i < c.getArrLength(); i++) {
			if (!(p.classification(c.getCustomerArr()[i]))) {
				this.getCustomerArr()[groupIdx++] = c.getCustomerArr()[i];
				c.getCustomerArr()[i].setGroupType(this.groupType);
			}
		}
	}
	
	public void summary() {
		System.out.println("======================");
		if(this.parameter != null) {
		System.out.printf("%s Group : %d customer(s)\n", this.groupType, this.arrLength);
		System.out.printf("[Parameter] %s\n", this.parameter.getParameter());
		}
		else {
			System.out.printf("Others : %d customer(s)\n", this.arrLength);
		}
		System.out.println("------------------------------");
		if(this.arrLength == 0) {
			System.out.println("No customer.");
			System.out.println();
		}
		else {
			this.viewCustomerData();
			System.out.println();
		}
		System.out.println();
	}
	
	public void viewCustomerData() {
		for(int i = 0; i < this.arrLength; i++) {
			System.out.printf("No. %d => Age: %d, Gender : %s, Location : %s, SpentTime : %d, GroupType : %s\n"
					, i + 1, this.customerArr[i].getAge(), this.customerArr[i].getGender(), this.customerArr[i].getLocation(), this.customerArr[i].getSpentTime(), this.customerArr[i].getGroupType());
		}
	}
	

}

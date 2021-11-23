package aisolution;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======================");
		System.out.println("Title : Customer Segmentation");
		System.out.println("======================");
		System.out.println();
		System.out.println();
		
		while(true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Customer Paramer");
			System.out.println(" 2.   Enter Customer Data");
			System.out.println(" 3.   Summary");
			System.out.println(" 4.   Quit");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.nextInt();
			System.out.println();

			if (userInputNum == 1) {
				setCustomerParameter();
			} 
			else if (userInputNum == 2) {
				enterCustomerData();
			} 
			else if (userInputNum == 3) {
				summary();
			} 
			else if (userInputNum == 4) {
				return;
			}
			
		}
		
	}
	
	// Set Customer Parameter
	static Parameter ideal = new Parameter(GroupType.IDEAL);
	static Parameter likely = new Parameter(GroupType.LIKELY);
	static Parameter defect = new Parameter(GroupType.DEFECT);
	static Parameters parameters = new Parameters(ideal, likely, defect);
	static void setCustomerParameter() {
		while(true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Parameter");
			System.out.println(" 2.   View Parameter");
			System.out.println(" 3.   Edit Parameter");
			System.out.println(" 4.   Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.nextInt();
			System.out.println();
			if (userInputNum == 1) {
				setParameter();
			} 
			else if (userInputNum == 2) {
				viewParameter();
			} 
			else if (userInputNum == 3) {
				editParameter();
			} 
			else if (userInputNum == 4) {
				return;
			}
		}
	}
	
	// Set Prameter
	static void setParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			String temp = sc.next();
			System.out.println();
			
			if (temp.equals("end")) {
				return;
			} 
			else if(parameters.notCheckString(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
			
			for(int i = 0; i < parameters.getArrLength(); i++) {
				if(parameters.checkString(i, temp)) {
					if(parameters.getParameter(i) != null) {
						System.out.printf("%s group already exists.\n", parameters.getGroupType(i));
						System.out.println();
						System.out.printf("GroupType : %s\n", parameters.getGroupType(i));
						System.out.printf("Parameter : %s\n", parameters.getParameter(i));
						continue;
					}
					inputParameter(parameters.parameterArr[i]);
				}
			}

		}	
	
	}
	
	static void editParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			String temp = sc.next();
			System.out.println();
			
			if (temp.equals("end")) {
				return;
			} 
			else if(parameters.notCheckString(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
			
			for(int i = 0; i < parameters.getArrLength(); i++) {
				if(parameters.checkString(i, temp)) {
					if(parameters.getParameter(i)== null) {
						System.out.println("No parameter. Set the parameter first.");
						System.out.println();
						continue;
					}
					inputParameter(parameters.parameterArr[i]);
				}
			}

		}
	}
	
	static void inputParameter(Parameter p) {
		while (true) {
			System.out.println("======================");
			System.out.println(" 1.  Age");
			System.out.println(" 2.  Gender");
			System.out.println(" 3.  Location");
			System.out.println(" 4.  Online Spent Time");
			System.out.println(" 5.  Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.nextInt();
			System.out.println();
			if(userInputNum == 5) return;
			inputParameterData(p, userInputNum);
		}
	}
	
	static void inputParameterData(Parameter p, int x) {
		if (x == 1) {
			System.out.print("Input Minimum Age : ");
			p.setMinAge(sc.nextInt());
			
			System.out.print("Input Maximum Age : ");
			p.setMaxAge(sc.nextInt());
			System.out.println();
		} 
		else if (x == 2) {
			System.out.print("Intput Gender : ");
			p.setGender(sc.next());
			System.out.println();
		} 
		else if (x == 3) {
			System.out.print("Intput Location : ");
			p.setLocation(sc.next());
			System.out.println();
		} 
		else if (x == 4) {
			System.out.print("Intput Online Spent Time : ");
			p.setSpentTime(sc.nextInt());
			System.out.println();
		}
		p.setParameter();
	}
	
	// View Parameter
	static void viewParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			String temp = sc.next();
			System.out.println();
			
			if (temp.equals("end")) {
				return;
			} 
			else if(parameters.notCheckString(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

			for(int i = 0; i < parameters.getArrLength(); i++) {
				if(parameters.checkString(i, temp)) {
					System.out.printf("GroupType : %s\n", parameters.getGroupType(i));
					System.out.printf("Prameter : %s\n", parameters.getParameter(i));
					System.out.println();
				}
			}
			
		}	
	}
	
	// Enter Customer Data
	static int userInputNum = 0;
	static void enterCustomerData() {
		while (true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Customer Data");
			System.out.println(" 2.   View Customer Data");
			System.out.println(" 3.   Edit Customer Data");
			System.out.println(" 4.   Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.nextInt();
			System.out.println();

			if (userInputNum == 1) {
				setCustomerData();
				if(allofCustomers.getArrLength() != 0) {
					classification();
					}
			} 
			else if (userInputNum == 2) {
				viewCustomerData();
			} 
			else if (userInputNum == 3) {
				editCostomerData();
			} 
			else if (userInputNum == 4) {
				return;
			}
		}
	}

	// Set Customer Data
	static Customers allofCustomers = new Customers();
	static int numofCustomers = 0;
	static int oldNum = 0;
	static void setCustomerData() {
//		allofCustomers.setArrLength(numofCustomers); // 배열길이 초기화
		System.out.println("** Press -1, if you want to exit! **");
		System.out.print("How many customers to input? ");
		userInputNum = sc.nextInt();
		System.out.println();
		if(userInputNum == - 1) return;
		numofCustomers += userInputNum; // 유저입력
		
		allofCustomers.init(numofCustomers); // 새배열 생성 + 배열 복사
		allofCustomers.createCustomer(oldNum, numofCustomers);
		for (int i = oldNum; i < numofCustomers; i++) {
			selectSetData(i);
		}
		oldNum = numofCustomers;
		allofCustomers.setArrLength(numofCustomers);
	}
	
	static void selectSetData(int x) {
		while (true) {
			System.out.printf("====== Customer %d Info. ======\n", x + 1);
			System.out.println();
			System.out.println("======================");
			System.out.println(" 1.  Age");
			System.out.println(" 2.  Gender");
			System.out.println(" 3.  Location");
			System.out.println(" 4.  Online Spent Time");
			System.out.println(" 5.  Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.nextInt();
			System.out.println();
			if (userInputNum == 5)
				return;
			inputCostomerData(x, userInputNum);
		}
	}
	
	
	// View Customer Data
	static Customer[] copyCustomerArr;
	static void viewCustomerData() {
		if(numofCustomers == 0) {
			System.out.println("No customer. Set customer data first.");
			System.out.println();
			return;
		}
		System.out.println("======= Customer Info. =======");
		allofCustomers.viewCustomerData();
		System.out.println();
	}
	
	// Edit Customer Data
	static void editCostomerData() {
		if(numofCustomers == 0) {
			System.out.println("No customer. Set customer data first.");
			System.out.println();
			return;
		}
		viewCustomerData();
		System.out.printf("Which customer do you want to edit ( 1 ~ %d )? ", allofCustomers.getArrLength());
		int temp = sc.nextInt();
		System.out.println();
		selectSetData(temp - 1);
	}
	
	static void inputCostomerData(int x, int y) {
		if (y == 1) {
			System.out.print("Intput Age : ");
			allofCustomers.setAge(x, sc.nextInt());
			System.out.println();
		} 
		else if (y == 2) {
			System.out.print("Intput Gender : ");
			allofCustomers.setGender(x, sc.next());
			System.out.println();
		} 
		else if (y == 3) {
			System.out.print("Intput Location : ");
			allofCustomers.setLocation(x, sc.next());
			System.out.println();
		} 
		else if (y == 4) {
			System.out.print("Intput Online Spent Time : ");
			allofCustomers.setSpentTime(x, sc.nextInt());
			System.out.println();
		}
	}
	
	// Summary
	static Customers idealGroup = new Customers(ideal, GroupType.IDEAL);
	static Customers likelyGroup = new Customers(likely, GroupType.LIKELY);
	static Customers defectGroup = new Customers(defect, GroupType.DEFECT);
	static Customers others = new Customers();
	
	static void classification() {
		idealGroup.creatCustomerArr(allofCustomers);
		likelyGroup.creatCustomerArr(allofCustomers);
		defectGroup.creatCustomerArr(allofCustomers);
		others.creatCustomerArr(allofCustomers, parameters);
	}
	
	static void summary() {
		idealGroup.summary();
		likelyGroup.summary();
		defectGroup.summary();
		others.summary();
	}


}

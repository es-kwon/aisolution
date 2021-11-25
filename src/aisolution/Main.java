package aisolution;

import java.util.*;

public class Main implements HandleException {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======================");
		System.out.println("Title : Customer Segmentation");
		System.out.println("======================");
		System.out.println();
		System.out.println();

		while (true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Customer Paramer");
			System.out.println(" 2.   Enter Customer Data");
			System.out.println(" 3.   Summary");
			System.out.println(" 4.   Quit");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.next();
			System.out.println();

			if (userInputNum.equals("1")) {
				setCustomerParameter();
			} else if (userInputNum.equals("2")) {
				enterCustomerData();
			} else if (userInputNum.equals("3")) {
				summary();
			} else if (userInputNum.equals("4")) {
				System.out.println("Program Finished.");
				return;
			} else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

		}

	}

	// Set Customer Parameter
	static Parameter ideal = new Parameter(GroupType.IDEAL);
	static Parameter likely = new Parameter(GroupType.LIKELY);
	static Parameter defect = new Parameter(GroupType.DEFECT);
	static Parameters parameters = new Parameters(ideal, likely, defect);

	static void setCustomerParameter() {
		while (true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Parameter");
			System.out.println(" 2.   View Parameter");
			System.out.println(" 3.   Edit Parameter");
			System.out.println(" 4.   Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.next();
			System.out.println();
			if (userInputNum.equals("1")) {
				setParameter();
				if (allofCustomers.getArrLength() != 0) {
					classification();
				}
			} else if (userInputNum.equals("2")) {
				viewParameter();
			} else if (userInputNum.equals("3")) {
				editParameter();
				if (allofCustomers.getArrLength() != 0) {
					classification();
				}
			} else if (userInputNum.equals("4")) {
				return;
			} else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
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

			if (temp.equals("end")) { // end 입력시 종료
				return;
			}
			// ideal, likely, defect, end 이외의 값이 들어오면 컨티뉴
			else if (parameters.checkNotAll(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

			for (int i = 0; i < parameters.getArrLength(); i++) {
				if (parameters.checkGT(i, temp)) {
					if (parameters.getParameter(i) != null) {
						System.out.printf("%s group already exists.\n", parameters.getGroupType(i));
						System.out.println();
						System.out.printf("GroupType : %s\n", parameters.getGroupType(i));
						System.out.printf("Parameter : %s\n", parameters.getParameter(i));
						System.out.println();
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
			} else if (parameters.checkNotAll(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

			for (int i = 0; i < parameters.getArrLength(); i++) {
				if (parameters.checkGT(i, temp)) {
					if (parameters.getParameter(i) == null) {
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
			userInputNum = sc.next();
			System.out.println();
			if (userInputNum.equals("5"))
				return;
			else if (userInputNum.equals("1") || userInputNum.equals("2") || userInputNum.equals("3")
					|| userInputNum.equals("4"))
				inputParameterData(p, Integer.parseInt(userInputNum));
			else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
		}
	}

	static void inputParameterData(Parameter p, int x) {
		if (x == 1) {
			while (true) {
				try {
					System.out.print("Input Minimum Age : ");
					userInput = sc.nextInt();
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setMinAge(userInput);

					System.out.print("Input Maximum Age : ");
					userInput = sc.nextInt();
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setMaxAge(userInput);
					System.out.println();
					break;
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}
		} else if (x == 2) {
			while (true) {
				System.out.print("Intput Gender : ");
				String temp = sc.next().toLowerCase();
				if (!(temp.equals("male") || temp.equals("female"))) {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				p.setGender(temp);
				System.out.println();
				break;
			}
		} else if (x == 3) {
			System.out.print("Intput Location : ");
			p.setLocation(sc.next().toLowerCase());
			System.out.println();
		} else if (x == 4) {
			while (true) {
				try {
					System.out.print("Intput Online Spent Time : ");
					userInput = sc.nextInt();
					if (userInput < 0) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setSpentTime(userInput);
					System.out.println();
					break;
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}
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
			} else if (parameters.checkNotAll(temp)) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

			for (int i = 0; i < parameters.getArrLength(); i++) {
				if (parameters.checkGT(i, temp)) {
					System.out.printf("GroupType : %s\n", parameters.getGroupType(i));
					System.out.printf("Prameter : %s\n", parameters.getParameter(i));
					System.out.println();
				}
			}

		}
	}

	// Enter Customer Data
	static String userInputNum = "";

	static void enterCustomerData() {
		while (true) {
			System.out.println("======================");
			System.out.println(" 1.   Set Customer Data");
			System.out.println(" 2.   View Customer Data");
			System.out.println(" 3.   Edit Customer Data");
			System.out.println(" 4.   Back");
			System.out.println("======================");
			System.out.print("Choose One : ");
			userInputNum = sc.next();
			System.out.println();

			if (userInputNum.equals("1")) {
				setCustomerData();
				if (allofCustomers.getArrLength() != 0) {
					classification();
				}
			} else if (userInputNum.equals("2")) {
				viewCustomerData();
			} else if (userInputNum.equals("3")) {
				editCostomerData();
				if (allofCustomers.getArrLength() != 0) {
					classification();
				}
			} else if (userInputNum.equals("4")) {
				return;
			} else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

		}
	}

	// Set Customer Data
	static Customers allofCustomers = new Customers();
	static int numofCustomers = 0;
	static int oldNum = 0;
	static int userInput = 0;

	static void setCustomerData() {
		while (true) {
			try {
				System.out.println("** Press -1, if you want to exit! **");
				System.out.print("How many customers to input? ");
				userInput = sc.nextInt();
				System.out.println();
				if (userInput == -1)
					return;
				else if (userInput < 0) {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				numofCustomers += userInput; // 유저입력
				allofCustomers.init(numofCustomers); // 새배열 생성 + 배열 복사
				allofCustomers.createCustomer(oldNum, numofCustomers);
				for (int i = oldNum; i < numofCustomers; i++) {
					selectSetData(i);
				}
				oldNum = numofCustomers;
				allofCustomers.setArrLength(numofCustomers);
				break;
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println();
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
			}
		}
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
			userInputNum = sc.next();
			System.out.println();
			if (userInputNum.equals("5"))
				return;
			else if (userInputNum.equals("1") || userInputNum.equals("2") || userInputNum.equals("3")
					|| userInputNum.equals("4"))
				inputCostomerData(x, Integer.parseInt(userInputNum));
			else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
		}
	}

	// View Customer Data
	static Customer[] copyCustomerArr;

	static void viewCustomerData() {
		if (numofCustomers == 0) {
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
		if (numofCustomers == 0) {
			System.out.println("No customer. Set customer data first.");
			System.out.println();
			return;
		}
		while (true) {
			try {
				viewCustomerData();
				System.out.printf("Which customer do you want to edit ( 1 ~ %d )? ", allofCustomers.getArrLength());
				int temp = sc.nextInt();
				System.out.println();
				if (temp >= 1 && temp <= allofCustomers.getArrLength()) {
					selectSetData(temp - 1);
					break;
				} else {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println();
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
			}
		}
	}

	static void inputCostomerData(int x, int y) {
		if (y == 1) {
			while (true) {
				try {
					System.out.print("Intput Age : ");
					userInput = sc.nextInt();
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					allofCustomers.setAge(x, userInput);
					System.out.println();
					break;
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}
		} else if (y == 2) {
			while (true) {
				System.out.print("Intput Gender : ");
				String temp = sc.next().toLowerCase();
				if (!(temp.equals("male") || temp.equals("female"))) {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				allofCustomers.setGender(x, temp);
				System.out.println();
				break;
			}
		} else if (y == 3) {
			System.out.print("Intput Location : ");
			allofCustomers.setLocation(x, sc.next().toLowerCase());
			System.out.println();
		} else if (y == 4) {
			while (true) {
				try {
					System.out.print("Intput Online Spent Time : ");
					userInput = sc.nextInt();
					if (userInput < 0) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					allofCustomers.setSpentTime(x, userInput);
					System.out.println();
					break;
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}

		}
	}

	// Summary
	static Customers idealGroup = new Customers(ideal, GroupType.IDEAL);
	static Customers likelyGroup = new Customers(likely, GroupType.LIKELY);
	static Customers defectGroup = new Customers(defect, GroupType.DEFECT);
	static Customers others = new Customers(GroupType.NONE);

	static void classification() {
		if (ideal.getParameter() != null)
			idealGroup.creatCustomerArr(allofCustomers);
		if (likely.getParameter() != null)
			likelyGroup.creatCustomerArr(allofCustomers);
		if (defect.getParameter() != null)
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

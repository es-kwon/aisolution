package aisolution;

import java.util.*;

public class Main implements HandleException {
	static Scanner sc = new Scanner(System.in);

	// #######################################
	// ## 10. 메인 메뉴
	// ## : 번호 입력시 해당 메소드 호출
	// #######################################

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

	// ------------------------------------------------------

	// #######################################
	// ## 20. Set Customer Parameter 메뉴
	// ## : Parameter 설정, 조회, 수정 관리
	// #######################################

	// 기준별 객체 및 기준그룹 객체 배열 생성
	static Parameter ideal = new Parameter(GroupType.IDEAL);
	static Parameter likely = new Parameter(GroupType.LIKELY);
	static Parameter defect = new Parameter(GroupType.DEFECT);
	static Parameters parameters = new Parameters(ideal, likely, defect);

	static String userInputNum = ""; // user가 입력한 값

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
			} else if (userInputNum.equals("2")) {
				viewParameter();
			} else if (userInputNum.equals("3")) {
				editParameter();
			} else if (userInputNum.equals("4")) {
				return;
			} else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 30. Set Parameter 메뉴
	// ## : Parameter 선택 후 세부내역 설정
	// #######################################

	static void setParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			// 유저 입력
			String temp = sc.next().toLowerCase();
			System.out.println();
			
			if (temp.equals("end")) { // end 입력시 종료
				return;
			}
			// ideal, likely, defect, end 이외의 값이 들어오면 continue
			else if ((!(temp.equals("ideal") || temp.equals("likely") || temp.equals("defect")))) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
			
			// GroupType 중 유저입력값 찾아 임시저장
			GroupType gtTemp = GroupType.valueOf(temp.toUpperCase());
			// GroupType 인덱스 임시저장
			int intTemp = gtTemp.ordinal();

			// 선택한 Parameter가 이미 설정되어있는지 확인
			// 설정되어있으면 다음 내용 출력 후 continue
			if (parameters.parameterArr[intTemp] != null) {
				System.out.printf("%s group already exists.\n", parameters.getGroupType(intTemp));
				System.out.println();
				System.out.printf("GroupType : %s\n", parameters.getGroupType(intTemp));
				System.out.printf("Parameter : %s\n", parameters.getParameter(intTemp));
				System.out.println();
				continue;
			}
			// 확인한 Parameter의 인덱스와 GroupType 인자로 전달
			inputParameter(parameters.parameterArr[intTemp], gtTemp);
		}

	}

	// ------------------------------------------------------

	// #######################################
	// ## 40. Edit Parameter 메뉴
	// ## : Parameter 선택 후 세부내역 수정
	// #######################################

	static void editParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			// 유저 입력
			String temp = sc.next().toLowerCase();
			System.out.println();
			
			if (temp.equals("end")) { // end 입력시 종료
				return;
				// ideal, likely, defect, end 이외의 값이 들어오면 continue
			} else if ((!(temp.equals("ideal") || temp.equals("likely") || temp.equals("defect")))) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
			// 유저입력값 찾아 임시저장
			// GroupType 중 유저입력값 찾아 임시저장
			GroupType gtTemp = GroupType.valueOf(temp.toUpperCase());
			// GroupType 인덱스 임시저장
			int intTemp = gtTemp.ordinal();

			// Parameter 이름들과 User 입력한 값 비교
			if (parameters.parameterArr[intTemp] == null) {
				System.out.println("No parameter. Set the parameter first.");
				System.out.println();
				continue;
			}
			// 확인한 Parameter의 인덱스와 GroupType 인자로 전달
			inputParameter(parameters.parameterArr[intTemp], gtTemp);

		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 50. Input Parameter 메뉴
	// ## : 선택된 Parameter의 필드값 설정
	// #######################################

	static void inputParameter(Parameter p, GroupType gt) {
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
			if (userInputNum.equals("5")) { // 5입력시 종료
				// Parameter 설정 완료 후 모든 Customer 분류
				// Customer의 수가 0일때는 실시하지 않음
				if (allofCustomers.getArrLength() != 0) {
					classify();
				}
				return;
			}
			// Parameter 필드중 user가 선택한 값 설정 메소드 호출
			else if (userInputNum.equals("1") || userInputNum.equals("2") || userInputNum.equals("3")
					|| userInputNum.equals("4"))
				inputParameterData(p, Integer.parseInt(userInputNum));
			else { // 1, 2, 3, 4, 5 외의 값 입력시 continue
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 60. Input Parameter Data 메소드
	// ## : Parameter 중 user가 선택한 값을 set하는 메소드
	// #######################################
	// #######################################
	// ## 61. p : 선택된 Parameter
	// ## x : 메뉴의 번호
	// #######################################

	static void inputParameterData(Parameter p, int x) {

		// 메뉴 1
		// Age 설정
		if (x == 1) {
			while (true) {
				try {

					// Minimum Age 설정
					System.out.print("Input Minimum Age : ");
					userInput = sc.nextInt();

					// 0 ~ 100 이외의 값이 들어오면 continue
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setMinAge(userInput);

					// Maximum Age 설정
					System.out.print("Input Maximum Age : ");
					userInput = sc.nextInt();

					// 0 ~ 100 이외의 값이 들어오면 continue
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setMaxAge(userInput);
					System.out.println();
					break;

					// user가 int이외의 값 입력 시 예외처리
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}

			// 메뉴 2
			// Gender 설정
		} else if (x == 2) {
			while (true) {
				System.out.print("Input Gender : ");
				String temp = sc.next().toLowerCase();

				// Male, Female 이외의 값 입력 시 continue
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

			// 메뉴 3
			// Location 설정
		} else if (x == 3) {
			System.out.print("Input Location : ");
			p.setLocation(sc.next().toLowerCase());
			System.out.println();

			// 메뉴 4
			// Online Spent Time 설정
		} else if (x == 4) {
			while (true) {
				try {
					System.out.print("Input Online Spent Time : ");
					userInput = sc.nextInt();

					// 값이 음수면 continue
					if (userInput < 0) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					p.setSpentTime(userInput);
					System.out.println();
					break;

					// user가 int이외의 값 입력 시 예외처리
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}
		}

	}

	// ------------------------------------------------------

	// #######################################
	// ## 70. View Parameter 메뉴
	// ## : 설정된 Parameter의 세부내역 출력
	// #######################################

	static void viewParameter() {
		while (true) {
			System.out.println("** Pres 'end', if you want to exit! **");
			System.out.print("which group (ideal, likely, defect)? ");
			String temp = sc.next().toLowerCase();
			System.out.println();
			
			if (temp.equals("end")) { // end 입력시 종료
				return;
				// ideal, likely, defect, end 이외의 값이 들어오면 continue
			} else if ((!(temp.equals("ideal") || temp.equals("likely") || temp.equals("defect")))) {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
			
			// GroupType 중 유저입력값 찾아 임시저장
			GroupType gtTemp = GroupType.valueOf(temp.toUpperCase());
			// GroupType 인덱스 임시저장
			int intTemp = gtTemp.ordinal();

			// User가 선택한 Parameter 내용 출력
			System.out.printf("GroupType : %s\n", parameters.getGroupType(intTemp));
			System.out.printf("Prameter : %s\n", parameters.getParameterArr()[intTemp].toString());
			System.out.println();

		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 80. Enter Customer Data 메뉴
	// ## : Customer Data 설정, 조회, 수정 관리
	// #######################################

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
			} else if (userInputNum.equals("2")) {
				viewCustomerData();
			} else if (userInputNum.equals("3")) {
				editCustomerData();
			} else if (userInputNum.equals("4")) {
				return;
			} else {
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}

		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 90. Set Customer Data 메뉴
	// ## : Customer 생성 후 Data 세부내역 설정
	// #######################################

	// 전체 Customer 객체 배열
	static Customers allofCustomers = new Customers();
	// Customer 수
	static int numofCustomers = 0;
	// 기존 Customer 수 저장 변수
	static int oldNum = 0;
	// user가 입력한 값
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
				// user 입력한 값이 음수인지 확인
				else if (userInput < 0) {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				// user가 입력한 값을 Customer 수에 더함
				numofCustomers += userInput;
				// 새 배열 생성 + 배열 원소 복사
				allofCustomers.init(numofCustomers);
				// Customer 객체 생성 후 배열에 저장
				allofCustomers.createCustomer(oldNum, numofCustomers);
				// 새로 생성된 Customer 객체의 Data 설정
				for (int i = oldNum; i < numofCustomers; i++) {
					selectSetData(i);
				}
				// 새 배열의 길이를 저장
				oldNum = numofCustomers;
				allofCustomers.setArrLength(numofCustomers);
				break;
				// user가 int이외의 값 입력 시 예외처리
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println();
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
			}
		}
	}

	
	// ------------------------------------------------------

	// #######################################
	// ## 100. Select Set Data 메뉴
	// ## : Customer 객체의 필드값 설정메뉴
	// #######################################
	// #######################################
	// ## 101. Customer 객체배열의 Index를 인자로 받아와 접근
	// ## 각 Customer 객체별로 필드값을 설정
	// #######################################

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
			if (userInputNum.equals("5")) { // 5입력시 종료
				// Parameter 설정 완료 후 모든 Customer 분류
				// Customer의 수가 0일때는 실시하지 않음
				if (allofCustomers.getArrLength() != 0) {
					classify();
				}
				return;
			}
			// Parameter 필드중 user가 선택한 값 설정 메소드 호출
			else if (userInputNum.equals("1") || userInputNum.equals("2") || userInputNum.equals("3")
					|| userInputNum.equals("4"))
				inputCustomerData(x, Integer.parseInt(userInputNum));
			else { // 1, 2, 3, 4, 5 외의 값 입력시 continue
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
				continue;
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 110. View Customer Data 메뉴
	// ## : 모든 Customer 객체의 Data 출력
	// #######################################

	static void viewCustomerData() {
		// Customer 객체가 존재하는지 검사
		// Customer가 설정되지 않았으면 아래 문구 출력후 종료
		if (numofCustomers == 0) {
			System.out.println("No customer. Set customer data first.");
			System.out.println();
			return;
		}
		// 모든 Customer 객체의 Data 출력
		System.out.println("======= Customer Info. =======");
		allofCustomers.viewCustomerData();
		System.out.println();
	}

	// ------------------------------------------------------

	// #######################################
	// ## 120. Edit Customer Data 메뉴
	// ## : Customer 객체의 필드값 수정메뉴
	// #######################################

	static void editCustomerData() {
		// Customer 객체가 존재하는지 검사
		// Customer가 설정되지 않았으면 아래 문구 출력후 종료
		if (numofCustomers == 0) {
			System.out.println("No customer. Set customer data first.");
			System.out.println();
			return;
		}
		while (true) {
			try {
				viewCustomerData();
				// Customer 객체의 개수를 user에게 제시
				System.out.printf("Which customer do you want to edit ( 1 ~ %d )? ", allofCustomers.getArrLength());
				int temp = sc.nextInt();
				System.out.println();
				// user가 입력한 값이 1 ~ (전체 Customer의 수) 범위에 해당하는지 확인
				if (temp >= 1 && temp <= allofCustomers.getArrLength()) {
					selectSetData(temp - 1);
					break;
					// 해당하지 않을경우 continue
				} else {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				// user가 int이외의 값 입력 시 예외처리
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println();
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 130. Input Customer Data 메소드
	// ## : Customer 객체의 필드값 수정메뉴
	// #######################################
	// #######################################
	// ## 131. int x : Customer의 index,
	// ## int y : 메뉴의 번호
	// #######################################

	static void inputCustomerData(int x, int y) {

		// 메뉴 1
		// Age 설정
		if (y == 1) {
			while (true) {
				try {
					System.out.print("Input Age : ");
					userInput = sc.nextInt();
					// 0 ~ 100 범위에 해당하는지 확인
					if (!((userInput >= 0) && (userInput <= 100))) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					allofCustomers.setAge(x, userInput);
					System.out.println();
					break;
					// user가 int이외의 값 입력 시 예외처리
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}

			// 메뉴 2
			// Gender 설정
		} else if (y == 2) {
			while (true) {
				System.out.print("Input Gender : ");
				String temp = sc.next().toLowerCase();

				// Male, Female 이외의 값 입력 시 continue
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

			// 메뉴 3
			// Location 설정
		} else if (y == 3) {
			System.out.print("Input Location : ");
			allofCustomers.setLocation(x, sc.next().toLowerCase());
			System.out.println();

			// 메뉴 4
			// Online Spent Time 설정
		} else if (y == 4) {
			while (true) {
				try {
					System.out.print("Input Online Spent Time : ");
					userInput = sc.nextInt();

					// 값이 음수면 continue
					if (userInput < 0) {
						System.out.println();
						System.out.println("Invalid Input. Please try again.");
						System.out.println();
						continue;
					}
					allofCustomers.setSpentTime(x, userInput);
					System.out.println();
					break;

					// user가 int이외의 값 입력 시 예외처리
				} catch (InputMismatchException e) {
					sc.next();
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
				}
			}

		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 140. Summary 메뉴
	// ## : 전체 Customer를 Summary 해서 출력
	// #######################################

	// 각 기준별 Customer 객체 배열
	static Customers idealGroup = new Customers(ideal);
	static Customers likelyGroup = new Customers(likely);
	static Customers defectGroup = new Customers(defect);
	static Customers others = new Customers();

	// 전체 Customer를 기준별로 분류
	static void classify() {
		if (ideal != null)
			idealGroup.creatCustomerArr(allofCustomers);
		if (likely != null)
			likelyGroup.creatCustomerArr(allofCustomers);
		if (defect != null)
			defectGroup.creatCustomerArr(allofCustomers);
		others.creatCustomerArr(allofCustomers, parameters);
	}

	// Summary된 내용 출력
	static void summary() {
		idealGroup.summary();
		likelyGroup.summary();
		defectGroup.summary();
		others.summary();
	}

}

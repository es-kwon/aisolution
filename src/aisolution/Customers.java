package aisolution;

public class Customers {
	// ## field
	private Customer[] customerArr;
	private int arrLength; // Customer 배열의 길이
	private Parameter parameter; // Customer 그룹의 Parameter

	// ## constructor

	// 1) 빈생성자
	public Customers() {
		this.arrLength = 0;
		this.customerArr = null;
	}

	// 2) Parameter를 가지는 생성자
	// 2-1) 각 기준별 Customer 객체 배열 생성시 사용
	public Customers(Parameter parameter) {
		this.arrLength = 0;
		this.parameter = parameter;
		this.customerArr = null;
	}

	// ## setter, getter
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

	// ------------------------------------------------------

	// #######################################
	// ## 10. 새 객체 배열에 기존 객체 복사하는 메소드
	// ## : 새 배열의 길이를 인자로 받음
	// #######################################

	public void init(int x) {
		// 새 배열의 길이에 해당하는 배열 생성
		Customer[] copy = new Customer[x];
		// 기존 배열 원소 복사
		for (int i = 0; i < this.arrLength; i++) {
			copy[i] = this.customerArr[i];
		}
		// 새 배열을 기존 배열에 할당
		this.customerArr = copy;
	}

	// ------------------------------------------------------

	// #######################################
	// ## 20. 새 객체 생성 메소드
	// ## x : 기존 배열의 길이, y : 새 배열의 길이
	// #######################################
	// #######################################
	// ## 21. 전체 Customer 배열에서 빈 공간에
	// ## 새 객체를 할당
	// #######################################

	public void createCustomer(int x, int y) {
		for (int i = x; i < y; i++) {
			this.customerArr[i] = new Customer();
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 30. 전체 Customer 분류 메소드
	// ## : 전체 Customer를 Parameter로 분류하여 배열 생성
	// #######################################

	public void creatCustomerArr(Customers c) {
		int count = 0;
		// 전체 Customer 중 Parameter에 해당하는 Customer 수 확인
		for (int i = 0; i < c.getArrLength(); i++) {
			if (c.getCustomerArr()[i].classifybyParameter(this.parameter)) {
				count++;
			}
		}
		// 확인된 Customer 수에 해당하는 배열 생성
		this.setCustomerArr(new Customer[count]); // 배열 생성
		this.arrLength = count; // 배열의 길이 지정
		int groupIdx = 0; // 배열 index 체크

		// 배열에 저장
		for (int i = 0; i < c.getArrLength(); i++) {
			if (c.getCustomerArr()[i].classifybyParameter(this.parameter)) {
				// Parameter에 해당하면 배열에 저장 후 groupIdx 1 증가
				this.getCustomerArr()[groupIdx++] = c.getCustomerArr()[i];
				// 해당되는 Customer 객체에 Group Type 할당
				c.getCustomerArr()[i].setGroupType(this.parameter.getGroupType());
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 40. 전체 Customer 분류 메소드
	// ## : Parameter에 해당되지 않는 Customer 배열 생성
	// #######################################

	public void creatCustomerArr(Customers c, Parameters p) {
		int count = 0;
		// 전체 Customer 중 어느 Parameter에도 해당하지 않는 Customer 수 확인
		for (int i = 0; i < c.getArrLength(); i++) {
			if (!(c.getCustomerArr()[i].classifybyParameters(p))) {
				count++;
			}
		}
		// 확인된 Customer 수에 해당하는 배열 생성
		this.setCustomerArr(new Customer[count]); // 배열 생성
		this.arrLength = count; // 배열의 길이 지정
		int groupIdx = 0; // 배열 index 체크

		// 배열에 저장
		for (int i = 0; i < c.getArrLength(); i++) {
			if (!(c.getCustomerArr()[i].classifybyParameters(p))) {
				// 어느 Parameter에도 해당하지 않으면 배열에 저장 후 groupIdx 1 증가
				this.getCustomerArr()[groupIdx++] = c.getCustomerArr()[i];
				// 해당되는 Customer 객체에 Group Type (NONE) 할당
				c.getCustomerArr()[i].setGroupType(GroupType.NONE);
			}
		}
	}

	// ------------------------------------------------------

	// #######################################
	// ## 50. Customer 배열 출력 메소드
	// ## : 배열의 유효성 검사 후 배열 출력
	// #######################################

	public void summary() {
		System.out.println("======================");
		// Customer 배열이 Parameter 필드를 포함하는지 검사
		if (this.parameter != null) {
			System.out.printf("%s Group : %d customer(s)\n", this.parameter.getGroupType(), this.arrLength);
			System.out.printf("[Parameter] %s\n", this.parameter.toString());
			// 포함하지 않으면 아래 문장 출력 (Others 그룹)
		} else {
			System.out.printf("Others : %d customer(s)\n", this.arrLength);
		}
		System.out.println("------------------------------");
		// 배열의 길이가 0이면 (원소가 없으면) 아래 문장 출력
		if (this.arrLength == 0) {
			System.out.println("No customer.");
			System.out.println();
			// 배열의 원소가 있으면 원소를 출력
		} else {
			this.viewCustomerData();
			System.out.println();
		}
		System.out.println();
	}

	// ------------------------------------------------------

	// #######################################
	// ## 60. Customer 배열의 원소 출력 메소드
	// ## : 배열이 포함하는 원소들을 String으로 모두 출력
	// #######################################

	public void viewCustomerData() {
		for (int i = 0; i < this.arrLength; i++) {
			System.out.printf("No. %d => %s\n", i + 1, this.customerArr[i]);
		}
	}

}

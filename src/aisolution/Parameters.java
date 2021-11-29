package aisolution;

public class Parameters {
	// ## field
	Parameter[] parameterArr;
	
	// ## constructor
	public Parameters(Parameter ideal, Parameter likely,
			Parameter defect){
		Parameter[] parameters = {ideal, likely, defect};
		this.parameterArr = parameters;
	}

	// ## getter, setter
	public Parameter[] getParameterArr() {
		return parameterArr;
	}

	public void setParameterArr(Parameter[] parameterArr) {
		this.parameterArr = parameterArr;
	}
	
	public int getArrLength() {
		return this.parameterArr.length;
	}
	
	public String getParameter(int x) {
		return this.parameterArr[x].toString();
	}
	
	public GroupType getGroupType(int x) {
		return this.parameterArr[x].getGroupType();
	}
	
	// ------------------------------------------------------

	// #######################################
	// ## 10. Customer를 Parameter들로 검사하는 메소드
	// ## : Customer를 인자로 받아 모든 Parameter에 해당하는지 검사
	// #######################################
	
	public boolean classifybyParameters (Customer c) {
		boolean[] x = new boolean[3];
		for (int i = 0; i < 3; i++) {
			x[i] = this.parameterArr[i].classifybyParameter(c);
			
			// Parameter가 지정되어있지 않으면 false 출력
			if (this.parameterArr[i] == null) x[i] = false;
		}
		return x[0] || x[1] || x[2];
	}
	
		

	

}

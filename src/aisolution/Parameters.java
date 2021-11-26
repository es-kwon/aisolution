package aisolution;

public class Parameters {
	// field
	Parameter[] parameterArr;
	
	// constructor
	public Parameters(Parameter ideal, Parameter likely,
			Parameter defect){
		Parameter[] parameters = {ideal, likely, defect};
		this.parameterArr = parameters;
	}

	// getter, setter
	public Parameter[] getParameterArr() {
		return parameterArr;
	}

	public void setParameterArr(Parameter[] parameterArr) {
		this.parameterArr = parameterArr;
	}
	
	public boolean classify (Customer c) {
		boolean[] x = new boolean[3];
		for (int i = 0; i < 3; i++) {
			x[i] = this.parameterArr[i].classify(c);
			if (this.parameterArr[i] == null) x[i] = false;
		}
		return x[0] || x[1] || x[2];
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
	
		

	

}

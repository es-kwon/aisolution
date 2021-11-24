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
	
	public boolean classification (Customer c) {
		boolean[] x = new boolean[3];
		for (int i = 0; i < 3; i++) {
			x[i] = this.parameterArr[i].classification(c);
			if (this.parameterArr[i].getParameter() == null) x[i] = false;
		}
		return x[0] || x[1] || x[2];
	}
	
	public boolean checkGT(int x, String s) {
		return this.parameterArr[x].checkGT(s);
	}
	
	public boolean checkNotAll(String s) {
		return !(this.parameterArr[0].checkGT(s) 
				|| this.parameterArr[1].checkGT(s) 
				|| this.parameterArr[2].checkGT(s));
	}
	
	public int getArrLength() {
		return this.parameterArr.length;
	}
	
	public String getParameter(int x) {
		return this.parameterArr[x].getParameter();
	}
	
	public GroupType getGroupType(int x) {
		return this.parameterArr[x].getGroupType();
	}
	
		

	

}

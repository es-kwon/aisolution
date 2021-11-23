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
		return this.parameterArr[0].classification(c)
				&& this.parameterArr[1].classification(c)
				&& this.parameterArr[2].classification(c);
	}
	
	public boolean checkString(int x, String s) {
		return this.parameterArr[x].checkString(s);
	}
	
	public boolean notCheckString(String s) {
		return !(this.parameterArr[0].checkString(s) 
				|| this.parameterArr[1].checkString(s) 
				|| this.parameterArr[2].checkString(s));
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

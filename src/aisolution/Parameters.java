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

	
		

	

}

package aisolution;

public class Customer {

	// ## field
	private int age;
	private String gender;
	private String location;
	private int spentTime;
	private GroupType groupType;

	// ## constructor
	public Customer() {
		this.gender = "null";
		this.location = "null";
	}

	// ## setter, getter
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(int spentTime) {
		this.spentTime = spentTime;
	}

	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	// ## toString
	@Override
	public String toString() {
		return String.format("Age: %d, Gender : %s, Location : %s, SpentTime : %d, GroupType : %s", age, gender,
				location, spentTime, groupType);
	}
	
	// ------------------------------------------------------

	// #######################################
	// ## 10. Customer를 Parameter로 검사하는 메소드
	// ## : Parameter를 인자로 받아 Customer가 이에 해당하는지 검사
	// #######################################
	
	public boolean classifybyParameter(Parameter p) {
		return (age >= p.getMinAge() && age <= p.getMaxAge())
				&& gender.equals(p.getGender()) && location.endsWith(p.getLocation())
				&& spentTime == p.getSpentTime();
	}
	
	// ------------------------------------------------------

	// #######################################
	// ## 20. Customer를 Parameter들로 검사하는 메소드
	// ## : Parameters를 인자로 받아 Customer가
	// ## : 모든 Parameter에 해당하는지 검사
	// #######################################
	
	public boolean classifybyParameters (Parameters p) {
		boolean[] x = new boolean[3];
		for (int i = 0; i < 3; i++) {
			x[i] = this.classifybyParameter(p.parameterArr[i]);
			
			// Parameter가 지정되어있지 않으면 false 출력
			if (p.parameterArr[i] == null) x[i] = false;
		}
		return x[0] || x[1] || x[2];
	}

}

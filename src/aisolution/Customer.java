package aisolution;

public class Customer {
	// field
	private int age;
	private String gender;
	private String location;
	private int spentTime;
	private GroupType groupType;
	
	// constructor
	public Customer() {}

	// setter, getter
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

	// toString
	@Override
	public String toString() {
		return String.format
				("age : %d, gender : %s, location : %s, spent_time : %d",
						age, gender, location, spentTime);
	}

}

package aisolution;

public class Parameter {
	// field
	private int minAge;
	private int maxAge;
	private String gender;
	private String location;
	private int spentTime;
	private GroupType groupType;

	// constructor
	public Parameter(GroupType g) {
		this.groupType = g;
		this.gender = "null";
		this.location = "null";
	}

	// getter, setter
	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
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
	
	public void printCustomers(Customer[] p) {
		int count = 0;
		for (int i = 0; i < p.length; i++) {
			if (this.classify(p[i])) {
				System.out.printf("No. %d => %s", count + 1, p[i]);
				count++;
			}
		}
	}

	public boolean classify(Customer c) {
		if (c.getGender() == null)
			c.setGender("null");
		if (c.getLocation() == null)
			c.setLocation("null");
		return (c.getAge() >= this.getMinAge() && c.getAge() <= this.getMaxAge())
				&& c.getGender().equals(this.getGender()) && c.getLocation().endsWith(this.getLocation())
				&& c.getSpentTime() == this.getSpentTime();
	}

	// toString
	@Override
	public String toString() {
		return String.format("minAge : %d, maxAge : %d, Gender : %s, Location : %s, SpentTime : %d", minAge, maxAge,
				gender, location, spentTime);
	}

}

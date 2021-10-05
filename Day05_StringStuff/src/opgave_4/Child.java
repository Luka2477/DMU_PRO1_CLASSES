package opgave_4;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a boy

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		if(this.age == 0) return "Home";
		else if(this.age <= 2) return "Nursery";
		else if(this.age <= 5) return "Kindergarten";
		else if(this.age <= 16) return "School";
		return "Out of school";
	}

	public String gender() { return (this.boy) ? "Boy" : "Girl"; }

	public String team() {
		if(this.boy) return (this.age < 8) ? "Young cubs" : "Cool boys";
		return (this.age < 8) ? "Tumbling girls" : "Springy girls";
	}

}

package modelchild;

/**
 * Write a description of class Barn here.
 */
public class Child {
	private int age;
	private boolean boy; // true if the child is a

	private double[] weight;

	public Child(int age, boolean boy, double[] weight) {
		this.age = age;
		this.boy = boy;
		this.weight = weight;
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

	//------------------------------------------------------------------------

	public double getWeight(int age) {
		return this.weight[age];
	}

	public double getIncrease() {
		double maxDelta = 0;
		for(int i=1; i<this.weight.length; i++) {
			double weightDelta = this.weight[i] - this.weight[i - 1];
			if(weightDelta > maxDelta)
				maxDelta = weightDelta;
		}

		return maxDelta;
	}
}

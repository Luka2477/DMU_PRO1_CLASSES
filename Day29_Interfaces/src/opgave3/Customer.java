package opgave3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Models a Customer with Orders.
 */
public class Customer {
	private String name;
	private LocalDate birthday;
	private List<Order> orders = new ArrayList<>();

	private Discount discount;

	/**
	 * Create a new Customer.
	 * 
	 * @param name     the name.
	 * @param birthday birthday of the customer.
	 */
	public Customer(String name, LocalDate birthday) {
		this.name = name;
		this.birthday = birthday;
		this.discount = null;
	}

	public Customer (String name, LocalDate birthday, Discount discount) {
		this(name, birthday);
		this.discount = discount;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return this.birthday;
	}

	public List<Order> getOrders() {
		return new ArrayList<>(orders);
	}

	public void addOrder(Order order) {
		if (!orders.contains(order)) {
			orders.add(order);
		}
	}

	public void removeOrder(Order order) {
		orders.remove(order);
	}

	public double totalBuy () {
		double sum = 0.0;
		for (Order o : this.orders) {
			sum += o.getOrderPrice();
		}
		return sum;
	}

	public double totalBuyWithDiscount () {
		double totalBuy = this.totalBuy();
		return totalBuy - ((this.discount != null) ? this.discount.getDiscount(totalBuy) : 0);
	}

}

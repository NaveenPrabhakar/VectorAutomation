package net.codejava;

public class Milk_Details {
	
	private double milk_total;
	private double local_total;
	private double rest_milk;
	public double getMilk_total() {
		return milk_total;
	}
	public void setMilk_total(double milk_total) {
		this.milk_total = milk_total;
	}
	public double getLocal_total() {
		return local_total;
	}
	public void setLocal_total(double local_total) {
		this.local_total = local_total;
	}
	public Milk_Details(double milk_total, double local_total, double rest_milk) {
		super();
		this.milk_total = milk_total;
		this.local_total = local_total;
		this.rest_milk = rest_milk;
	}
	public double getRest_milk() {
		return rest_milk;
	}
	public void setRest_milk(double rest_milk) {
		this.rest_milk = rest_milk;
	}
	@Override
	public String toString() {
		return "Milk_Details [milk_total=" + milk_total + ", local_total=" + local_total + ", rest_milk=" + rest_milk
				+ "]";
	}
	
	
	

}

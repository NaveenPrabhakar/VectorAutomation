package net.codejava;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="localsale")
public class LocalSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long bill_number;

	public String shift;
	public double available_milk; 
	public double quantity; 
	public double rate;
	public double amount;
	public Date created_date; 
	
	
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public LocalSale()
	{
		
	}
	public long getBill_number() {
		return bill_number;
	}
	public void setBill_number(long bill_number) {
		this.bill_number = bill_number;
	}
	
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public double getAvailable_milk() {
		return available_milk;
	}
	public void setAvailable_milk(double available_milk) {
		this.available_milk = available_milk;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalSale(long bill_number, String shift, double available_milk, double quantity, double rate, double amount,
			Date created_date) {
		super();
		this.bill_number = bill_number;
		this.shift = shift;
		this.available_milk = available_milk;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
		this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "LocalSale [bill_number=" + bill_number + ", shift=" + shift + ", available_milk=" + available_milk
				+ ", quantity=" + quantity + ", rate=" + rate + ", amount=" + amount + ", created_date=" + created_date
				+ "]";
	}
	
	

}

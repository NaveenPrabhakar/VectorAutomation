package net.codejava;

import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trucksheet {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long truck_id;
	private Date created_date;
	private String shift;
	private String rasu;
	private String milktype ;
	private double quantity; 
	private long tottal_can;
	private double fat; 
	private double snf;
	private double rate;
	private double amount;
	
	public Trucksheet()
	{
		
	}
	
	public long getTruck_id() {
		return truck_id;
	}
	public void setTruck_id(long truck_id) {
		this.truck_id = truck_id;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getRasu() {
		return rasu;
	}
	public void setRasu(String rasu) {
		this.rasu = rasu;
	}
	public String getMilktype() {
		return milktype;
	}
	public void setMilktype(String milktype) {
		this.milktype = milktype;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public long getTottal_can() {
		return tottal_can;
	}
	public void setTottal_can(long tottal_can) {
		this.tottal_can = tottal_can;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSnf() {
		return snf;
	}
	public void setSnf(double snf) {
		this.snf = snf;
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
	public Trucksheet(long truck_id, Date created_date, String shift, String rasu, String milktype, double quantity,
			long tottal_can, double fat, double snf, double rate, double amount) {
		super();
		this.truck_id = truck_id;
		this.created_date = created_date;
		this.shift = shift;
		this.rasu = rasu;
		this.milktype = milktype;
		this.quantity = quantity;
		this.tottal_can = tottal_can;
		this.fat = fat;
		this.snf = snf;
		this.rate = rate;
		this.amount = amount;
	}
	
	
	
	

}

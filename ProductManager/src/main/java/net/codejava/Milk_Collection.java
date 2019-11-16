package net.codejava;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Milk_Collection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	public long milk_collection_id ;
	public long member_id;
	public String name ;
	public String shift;
	public double quantity;
	public double clr;
	public double fat;
	public double snf;
	public double rate;
	public String cattle_type;
	
	public Milk_Collection(long milk_collection_id, long member_id, String name, String shift, double quantity,
			double clr, double fat, double snf, double rate, String cattle_type, double amount, Timestamp created_date) {
		super();
		this.milk_collection_id = milk_collection_id;
		this.member_id = member_id;
		this.name = name;
		this.shift = shift;
		this.quantity = quantity;
		this.clr = clr;
		this.fat = fat;
		this.snf = snf;
		this.rate = rate;
		this.cattle_type = cattle_type;
		this.amount = amount;
		this.created_date = created_date;
	}

	public Timestamp getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Timestamp timestamp) {
		this.created_date = timestamp;
	}

	public double amount;
	public Timestamp created_date; 
	
	
	
	public Milk_Collection()
	{
		
	}

	public long getMilk_collection_id() {
		return milk_collection_id;
	}

	public void setMilk_collection_id(long milk_collection_id) {
		this.milk_collection_id = milk_collection_id;
	}

	

	

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getClr() {
		return clr;
	}

	public void setClr(double clr) {
		this.clr = clr;
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

	public String getCattle_type() {
		return cattle_type;
	}

	public void setCattle_type(String cattle_type) {
		this.cattle_type = cattle_type;
	}

	

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public long getMember_id() {
		return member_id;
	}

	public void setMember_id(long member_id) {
		this.member_id = member_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Milk_Collection [milk_collection_id=" + milk_collection_id + ", member_id=" + member_id + ", name="
				+ name + ", shift=" + shift + ", quantity=" + quantity + ", clr=" + clr + ", fat=" + fat + ", snf="
				+ snf + ", rate=" + rate + ", cattle_type=" + cattle_type + ", amount=" + amount + ", created_date="
				+ created_date + "]";
	}

	

	
	   
	

}

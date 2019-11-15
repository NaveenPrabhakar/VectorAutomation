package net.codejava;

import java.sql.Date;

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
	public long quantity;
	public long clr;
	public long fat;
	public long snf;
	public long rate;
	public String cattle_type;
	public long amount;
	
	
	
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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getClr() {
		return clr;
	}

	public void setClr(long clr) {
		this.clr = clr;
	}

	public long getFat() {
		return fat;
	}

	public void setFat(long fat) {
		this.fat = fat;
	}

	public long getSnf() {
		return snf;
	}

	public void setSnf(long snf) {
		this.snf = snf;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public String getCattle_type() {
		return cattle_type;
	}

	public void setCattle_type(String cattle_type) {
		this.cattle_type = cattle_type;
	}

	

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
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

	public Milk_Collection(long milk_collection_id, long member_id, String name, String shift, long quantity,
			long clr, long fat, long snf, long rate, String cattle_type, long amount) {
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
	}

	@Override
	public String toString() {
		return "Milk_Collection [milk_collection_id=" + milk_collection_id + ", member_id=" + member_id + ", name="
				+ name + ", shift=" + shift + ", quantity=" + quantity + ", clr=" + clr + ", fat=" + fat + ", snf="
				+ snf + ", rate=" + rate + ", cattle_type=" + cattle_type + ", amount=" + amount + "]";
	}

	

	
	   
	

}

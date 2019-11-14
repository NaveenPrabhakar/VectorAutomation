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
	public Date date;
	public String shift;
	public String quantity;
	public long clr;
	public long fat;
	public long snf;
	public long rate;
	public String cattle_type;
	public Date created_date;
	public Date updated_date;
	public long amount;
	
	@ManyToOne(
	          fetch = FetchType.LAZY,
	          optional = false
	  )
	  @JoinColumn(
	          name = "member_id",
	          nullable = false
	  )
	  @JsonIgnore
	public Member member;
	
	public Milk_Collection()
	{
		
	}

	public long getMilk_collection_id() {
		return milk_collection_id;
	}

	public void setMilk_collection_id(long milk_collection_id) {
		this.milk_collection_id = milk_collection_id;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Milk_Collection(long milk_collection_id, long member_id, Date date, String shift, String quantity, long clr,
			long fat, long snf, long rate, String cattle_type, Date created_date, Date updated_date, long amount,
			Member member) {
		super();
		this.milk_collection_id = milk_collection_id;
		this.date = date;
		this.shift = shift;
		this.quantity = quantity;
		this.clr = clr;
		this.fat = fat;
		this.snf = snf;
		this.rate = rate;
		this.cattle_type = cattle_type;
		this.created_date = created_date;
		this.updated_date = updated_date;
		this.amount = amount;
		this.member = member;
	}

	@Override
	public String toString() {
		return "Milk_Collection [milk_collection_id=" + milk_collection_id + ",  date="
				+ date + ", shift=" + shift + ", quantity=" + quantity + ", clr=" + clr + ", fat=" + fat + ", snf="
				+ snf + ", rate=" + rate + ", cattle_type=" + cattle_type + ", created_date=" + created_date
				+ ", updated_date=" + updated_date + ", amount=" + amount + ", member=" + member + "]";
	}
	
	
	
	
	   
	

}

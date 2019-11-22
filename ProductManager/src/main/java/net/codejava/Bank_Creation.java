package net.codejava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bank_Creation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bankid;
	private String bankname;
	private String branch;
	private String ifsc;
	private String migration_number;
	private long pincode;
	private double balance;
	private String other_details;
	public long getBankid() {
		return bankid;
	}
	public void setBankid(long bankid) {
		this.bankid = bankid;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getIfsc() {
		return ifsc;
	}
	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	public String getMigration_number() {
		return migration_number;
	}
	public void setMigration_number(String migration_number) {
		this.migration_number = migration_number;
	}
	public long getPincode() {
		return pincode;
	}
	public void setPincode(long pincode) {
		this.pincode = pincode;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getOther_details() {
		return other_details;
	}
	public void setOther_details(String other_details) {
		this.other_details = other_details;
	}
	public Bank_Creation(long bankid, String bankname, String branch, String ifsc, String migration_number,
			long pincode, double balance, String other_details) {
		super();
		this.bankid = bankid;
		this.bankname = bankname;
		this.branch = branch;
		this.ifsc = ifsc;
		this.migration_number = migration_number;
		this.pincode = pincode;
		this.balance = balance;
		this.other_details = other_details;
	}
	@Override
	public String toString() {
		return "Bank_Creation [bankid=" + bankid + ", bankname=" + bankname + ", branch=" + branch + ", ifsc=" + ifsc
				+ ", migration_number=" + migration_number + ", pincode=" + pincode + ", balance=" + balance
				+ ", other_details=" + other_details + "]";
	}
	
	public Bank_Creation()
	{
		
	}
	
	
}

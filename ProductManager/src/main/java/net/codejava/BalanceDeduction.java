package net.codejava;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BalanceDeduction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long balanceid;
	private LocalDate fromDate;
	private LocalDate toDate;
	private long member_id;
	private String name;
	private double total_amount;
	private double deduction_amount;
	private double balance_amount;
	
	public BalanceDeduction()
	{
		
	}
	public long getBalanceid() {
		return balanceid;
	}
	public void setBalanceid(long balanceid) {
		this.balanceid = balanceid;
	}
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
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
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public double getDeduction_amount() {
		return deduction_amount;
	}
	public void setDeduction_amount(double deduction_amount) {
		this.deduction_amount = deduction_amount;
	}
	public double getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(double balance_amount) {
		this.balance_amount = balance_amount;
	}
	public BalanceDeduction(long balanceid, LocalDate fromDate, LocalDate toDate, long member_id, String name,
			double total_amount, double deduction_amount, double balance_amount) {
		super();
		this.balanceid = balanceid;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.member_id = member_id;
		this.name = name;
		this.total_amount = total_amount;
		this.deduction_amount = deduction_amount;
		this.balance_amount = balance_amount;
	}
	@Override
	public String toString() {
		return "BalanceDeduction [balanceid=" + balanceid + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", member_id=" + member_id + ", name=" + name + ", total_amount=" + total_amount
				+ ", deduction_amount=" + deduction_amount + ", balance_amount=" + balance_amount + "]";
	}
	
	
	
	
}

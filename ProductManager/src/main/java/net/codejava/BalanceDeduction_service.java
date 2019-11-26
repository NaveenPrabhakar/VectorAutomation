package net.codejava;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BalanceDeduction_service {
	
	@Autowired
	private BalanceDeductionrRepo balanceDeductionrRepo;
	
	public BalanceDeduction getBalance(long id, LocalDate from_date, LocalDate to_date)
	{
		
		return balanceDeductionrRepo.getBalance(id,from_date,to_date);
		
	}
	
	public void save(BalanceDeduction balanceDeduction)
	{
		balanceDeductionrRepo.save(balanceDeduction);
	}

	public List<BalanceDeduction> getdata(long member_id)
	{
		 return balanceDeductionrRepo.getData(member_id);
	}
}

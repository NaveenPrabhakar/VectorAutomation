package net.codejava;

import java.sql.Date;
import java.time.LocalDate;

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

}

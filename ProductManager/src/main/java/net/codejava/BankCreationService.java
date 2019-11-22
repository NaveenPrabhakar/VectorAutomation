package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankCreationService {
	
	@Autowired
	private BankCreationRepo repo;
	
	public void save(Bank_Creation bank_Creation)
	{
		repo.save(bank_Creation);
	}

}

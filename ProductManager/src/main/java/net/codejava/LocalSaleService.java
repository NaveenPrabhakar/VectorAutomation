package net.codejava;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocalSaleService {
	@Autowired
	private LocalSaleRepo repo;
	
	public long findMaxBillNumber()
	{
		return repo.findByMaxBillNumber();
	}
	
	public void save(LocalSale localSale)
	{
		repo.save(localSale);
	}
	public Double local_quantity(LocalDate created_date)
	{
		return repo.totalquantity(created_date);
	}

	public List<LocalSale> getdata(LocalDate created_date)
	{
		return repo.getlocalsale(created_date);
	}
	
	public void deleteId(long id)
	{
		repo.deleteById(id);
	}
}

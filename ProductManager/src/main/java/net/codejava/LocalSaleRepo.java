package net.codejava;



import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LocalSaleRepo extends JpaRepository<LocalSale, Long> {
	
	@Query(value = "select max(bill_number)+1  from localsale",nativeQuery = true)
	public long findByMaxBillNumber();
	
	@Query(value = "select sum(quantity) from localsale where created_date =:created_date",nativeQuery = true)
	public Double totalquantity(LocalDate created_date);
	
	@Query(value = "select * from localsale where created_date =:created_date order by bill_number desc",nativeQuery = true)
	public List<LocalSale> getlocalsale(LocalDate created_date);
	
	

}

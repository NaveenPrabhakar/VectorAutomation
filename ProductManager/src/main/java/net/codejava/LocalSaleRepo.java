package net.codejava;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LocalSaleRepo extends JpaRepository<LocalSale, Long> {
	
	@Query(value = "select max(bill_number)+1  from localsale",nativeQuery = true)
	public long findByMaxBillNumber();

}

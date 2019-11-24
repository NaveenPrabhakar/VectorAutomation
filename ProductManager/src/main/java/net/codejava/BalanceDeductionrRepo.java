package net.codejava;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BalanceDeductionrRepo extends JpaRepository<BalanceDeduction, Long> {
	
	@Query(value = "select m.id as member_id, m.name as name,sum(c.amount) as total_amount from member m , milk_collection c where c.member_id = :id and m.id=:id and c.created_date between :from_date and :to_date",nativeQuery = true)
	public BalanceDeduction getBalance(long id,LocalDate from_date, LocalDate to_date);

}

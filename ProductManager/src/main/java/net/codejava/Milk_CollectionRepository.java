package net.codejava;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface Milk_CollectionRepository extends JpaRepository<Milk_Collection, Long> {
	
	@Query(value = "select * from milk_collection WHERE member_id = :member_id order by milk_collection_id desc",nativeQuery = true)
	List<Milk_Collection> findByMemberId(@Param("member_id") long member_id);
	
	@Query(value = "select count(*) from milk_collection where member_id = :member_id and shift = :shift and created_date = :created_date",nativeQuery = true)
	long  check_id(long member_id, String shift, Date created_date);
	
	
	@Query(value = "select * from milk_collection where created_date = :created_date order by milk_collection_id desc",nativeQuery = true)
	List<Milk_Collection> todaysCollection(LocalDate created_date);
	
	
	@Query(value = "select sum(quantity) from milk_collection where created_date=:created_date",nativeQuery = true)
	double tottalQuanity(LocalDate created_date);
	 
	
	
	
}

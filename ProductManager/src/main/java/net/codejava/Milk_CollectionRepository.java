package net.codejava;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface Milk_CollectionRepository extends JpaRepository<Milk_Collection, Long> {
	
	@Query(value = "select * from milk_collection WHERE member_id = :member_id order by milk_collection_id desc",nativeQuery = true)
	List<Milk_Collection> findByMemberId(@Param("member_id") long member_id);
	
	
}

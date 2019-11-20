package net.codejava;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class Milk_CollectionService {
	
	@Autowired
	private Milk_CollectionRepository repo;
	
	public void save(Milk_Collection milk_Collection)
	{
		repo.save(milk_Collection);
	}
	
	public Milk_Collection findById( long MILK_COLLECTION_ID )
	{
		return repo.findById(MILK_COLLECTION_ID).get();
	}
	
	public List<Milk_Collection> getMilk_Collection(long id)
	{
		return repo.findByMemberId(id);
	}
	
	public List<Milk_Collection> get_todays_Milk_Collection(LocalDate created_date )
	{
		
		return repo.todaysCollection(created_date);
	}
	 public int check_duplicate_ShiftEntry(long member_id, String shift, Date created_date)
	 {
		 
		 return  (int) repo.check_id(member_id, shift, created_date);
		 
	 }

}

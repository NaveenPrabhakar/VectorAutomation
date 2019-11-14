package net.codejava;

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
	
	public Milk_Collection findById( long member_id )
	{
		return repo.findById(member_id).get();
	}
	
	public List<Milk_Collection> getMilk_Collection(long id)
	{
		return repo.findByMemberId(id);
	}

}

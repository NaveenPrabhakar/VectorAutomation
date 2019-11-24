package net.codejava;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SocietyService {
	
	@Autowired
	private SocietyRepo repo;

	 @Cacheable(value="society") 
	public Society getdata(long id)
	{
		 return repo.findById(id).get();
	}
	 
	 @CacheEvict(value = "society", allEntries = true)
	  public void resetAllEntries() {
	    // Intentionally blank
	  }
}

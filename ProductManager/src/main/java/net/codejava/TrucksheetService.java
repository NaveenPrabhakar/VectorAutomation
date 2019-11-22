package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class TrucksheetService {
	
	@Autowired
	private TruckSheetRepo repo;
	
	public void save(Trucksheet trucksheet) {
		
		repo.save(trucksheet);
	}

}

package net.codejava;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginRepository repo;
	
	public void save(Login login) {
		repo.save(login);
	}
	
	public Login getId(long id)
	{
		return repo.findById(id).get();
		
	}
	
	public Boolean id_Exist(long id)
	{
		return repo.existsById(id);
	}

}

package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberRepository repo;
	
	public List<Member> listAll() {
		return repo.findAll();
	}
	
	public void save(Member member) {
		repo.save(member);
	}
	public Boolean is_Id_Exist(long id)
	{
		Boolean value = repo.existsById(id);
		return value;
	}
	
	public Member get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}
}

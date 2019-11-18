package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping("/restmemebr")
	public Member getMember()
	{
		Member member= memberservice.get(3);
		return member;
		
	}
	
	

}

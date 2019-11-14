package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class AppController {

	@Autowired
	private ProductService service;

	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private LoginService loginService;	
	
	@Autowired
	private Milk_CollectionService milk_collectionservice;

	@RequestMapping("/")
	public String viewLoginPage(Model model) {

		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}
	
	@RequestMapping("/welcome")
    public String hello(){
        return "welcome";
    }
	
	@RequestMapping("/milk")
    public String milk(){
        return "millk_wizard";
    }
	
	@RequestMapping("/logout")
	public ModelAndView viewLogoutPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("confirmationMessage", "ನೀವು ಯಶಸ್ವಿಯಾಗಿ ಲಾಗ್ ಔಟ್ ಟ್ ಆಗಿದ್ದೀರಿ." );
		return mav;
	}
	
	@RequestMapping("/main")
	public String viewMainPage(Model model) {

		return "main";
	}
	
	@RequestMapping("/view_member")
	public String viewMemberPage(Model model) {
		Member member = new Member();
		model.addAttribute("member", member);

		return "view_member";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("login") Login login) {
		
		
		Boolean value = loginService.id_Exist(login.getId());
		if (value)
		{
			Login log = loginService.getId(login.getId());
			if(log.getPassword().equals(login.getPassword()))
			{
				ModelAndView mav = new ModelAndView("main");
				return mav;
				
			}else {
				ModelAndView mav = new ModelAndView("login");
				mav.addObject("confirmationMessage", "ಬಳಕೆದಾರಹೆಸರು ಅಥವಾ ಪಾಸ್‌ವರ್ಡ್ ತಪ್ಪಾಗಿದೆ" );
				return mav;
			}
		}
		else {
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ" );
			return mav;
		}
		
		
	}

	@GetMapping("/add_member")
	public String addNewMember(Model model) {
		// Product product = new Product();
		Member member = new Member();
		model.addAttribute("member", member);

		return "member";
	}

	@RequestMapping(value = "/view_member_ctr", method = RequestMethod.POST)
	public ModelAndView view_Memeber(@ModelAttribute("member") Member member, ModelAndView modelAndView) {
		ModelAndView mav = new ModelAndView("view_member");
		Boolean id_Exist = memberservice.is_Id_Exist(member.getId());
		System.out.println("Bolean Value ---"+id_Exist);
		if (id_Exist)
		{
		Member mem = memberservice.get(member.getId());
		mav.addObject("listMember", mem);
		}
		else {
			mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ  -> " + member.getId());
		}
		return mav;
	}

	@RequestMapping(value = "/save_member", method = RequestMethod.POST)
	public ModelAndView saveMember(@ModelAttribute("member") Member member, ModelAndView modelAndView) {
		memberservice.save(member);
		modelAndView.addObject("confirmationMessage", "ಸದಸ್ಯರನ್ನು ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿದೆ " + member.getName());
		modelAndView.setViewName("member");
		return modelAndView;
	}
	
	
	
	@RequestMapping("/edit_member/{id}")
	public ModelAndView edit_Memeber(@PathVariable(name = "id") int id,@ModelAttribute("member") Member member) {
		Boolean id_Exist = memberservice.is_Id_Exist(id);
		if (id_Exist)
		{
			ModelAndView mav = new ModelAndView("edit_member");
			Member mem = memberservice.get(id);
			mav.addObject("member", mem);
			return mav;
			
		}
		else {
		ModelAndView mav = new ModelAndView("view_member");
		mav.addObject("member", member);
		mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ  -> " + member.getId());
		return mav;
		}
		
		
	}
	@RequestMapping("/delete_member/{id}")
	public ModelAndView delete_Memeber(@PathVariable(name = "id") int id, ModelAndView modelAndView, @ModelAttribute("member") Member member) {
		Boolean id_Exist = memberservice.is_Id_Exist(id);
		if(id_Exist)
		{
				memberservice.delete(id);
			 modelAndView.addObject("confirmationMessage", "ಸದಸ್ಯರನ್ನು ಯಶಸ್ವಿಯಾಗಿ ಅಳಿಸಲಾಗಿದೆ " );
			 modelAndView.addObject("member", member);
				modelAndView.setViewName("view_member");
		}
		else {
			modelAndView.addObject("member", member);
			modelAndView.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ  -> " + member.getId());
			
		}
		
			return modelAndView;
		
	}
	
	@RequestMapping("/index")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "index";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/index";
	}
	

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@GetMapping("/milk_data")
	public ModelAndView getdata()
	{
		System.out.println("INside milk data");
		ModelAndView mav = new ModelAndView("milk_wizard");
		List<Milk_Collection> milk = milk_collectionservice.getMilk_Collection(3);
		mav.addObject("milk_member", milk);
		return mav;
	}
	
	
}

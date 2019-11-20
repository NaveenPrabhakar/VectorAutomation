package net.codejava;


import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import ch.qos.logback.classic.Logger;



@Controller
public class AppController {
	
	public static org.slf4j.Logger log = LoggerFactory.getLogger(AppController.class);

	@Autowired
	private ProductService service;

	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private LoginService loginService;	 
	
	@Autowired
	private Milk_CollectionService milk_collectionservice;
	
	@Autowired
	private LocalSaleService localSaleService;

	@RequestMapping("/")
	public String viewLoginPage(Model model) {

		Login login = new Login();
		model.addAttribute("login", login);
		
		log.info("Login Page is involked");
		return "login";
	}
	
	@RequestMapping("/admin")
	public String viewAdminPage(Model model) {

		log.info("Admin Page is involked");
		return "admin";
	}
	
	
	
	@RequestMapping("/milk_wizard")
    public String milk(Model model){
		log.info("Milk Wizard  Page is involked");
		LocalDate created_date = LocalDate.now();
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		log.info("Todays date is -"+created_date);
		Milk_Collection milk_Collection = new Milk_Collection();
		//model.addAttribute("member", member); ${milk_member}
		model.addAttribute("milk_collection", milk_Collection);
		model.addAttribute("milk_member", collections);
        return "milk_wizard";
    }
	
	@RequestMapping("/local_sale")
	public String viewLocalsale(Model model)
	{
		log.info("Local sale Page is involked");
		LocalSale localSale = new LocalSale();
		long maxBillNumber = localSaleService.findMaxBillNumber();
		localSale.setBill_number(maxBillNumber);
		log.info("Local page  - Bill Number is - - "+maxBillNumber);
		model.addAttribute("localsale", localSale);
		return "localsale";
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView viewLogoutPage(Model model) {
		log.info("Logout Page is involked");
		Login login = new Login();
		model.addAttribute("login", login);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("confirmationMessage", "ನೀವು ಯಶಸ್ವಿಯಾಗಿ ಲಾಗ್ ಔಟ್ ಟ್ ಆಗಿದ್ದೀರಿ." );
		return mav;
	}
	
	@RequestMapping("/main")
	public String viewMainPage(Model model) {
		log.info("Main Page is involked");
		return "main";
	}
	
	@RequestMapping("/view_member")
	public String viewMemberPage(Model model) {
		log.info("View Member  Page is involked");
		Member member = new Member();
		model.addAttribute("member", member);

		return "view_member";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute("login") Login login) {
		
		log.info("Login Controller");
		
		Boolean value = loginService.id_Exist(login.getId());
		log.info("Usernsame is exist in Database - "+value);
		if (value)
		{
			Login login1 = loginService.getId(login.getId());
			if(login1.getPassword().equals(login.getPassword()))
			{
				log.info("Login Successful");
				ModelAndView mav = new ModelAndView("main");
				return mav;
				
			}else {
				log.info("Login Failed");
				ModelAndView mav = new ModelAndView("login");
				mav.addObject("confirmationMessage", "ಬಳಕೆದಾರಹೆಸರು ಅಥವಾ ಪಾಸ್‌ವರ್ಡ್ ತಪ್ಪಾಗಿದೆ" );
				return mav;
			}
		}
		else {
			log.info("Login Failed");
			ModelAndView mav = new ModelAndView("login");
			mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ" );
			return mav;
		}
		
		
	}

	@GetMapping("/add_member")
	public String addNewMember(Model model) {
		// Product product = new Product();
		log.info("Add Member page is invoked");
		Member member = new Member();
		model.addAttribute("member", member);

		return "member";
	}
	
	

	@RequestMapping(value = "/view_member_ctr", method = RequestMethod.POST)
	public ModelAndView view_Memeber(@ModelAttribute("member") Member member, ModelAndView modelAndView) {
		log.info("View member Controller invoked");
		ModelAndView mav = new ModelAndView("view_member");
		Boolean id_Exist = memberservice.is_Id_Exist(member.getId());
		System.out.println("Bolean Value ---"+id_Exist);
		if (id_Exist)
		{
		Member mem = memberservice.get(member.getId());
		mav.addObject("listMember", mem);
		log.info("Member details - "+mem.toString());
		}
		else {
			log.info("Member info is not available");
			mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ  -> " + member.getId());
		}
		return mav;
	}

	@RequestMapping(value = "/save_member", method = RequestMethod.POST)
	public ModelAndView saveMember(@ModelAttribute("member") Member member, ModelAndView modelAndView) {
		log.info("Save Member controller is invoked");
		log.info("Save Member Details - "+member.toString());
		memberservice.save(member);
		modelAndView.addObject("confirmationMessage", "ಸದಸ್ಯರನ್ನು ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿದೆ " + member.getName());
		modelAndView.setViewName("member");
		return modelAndView;
	}
	
	@RequestMapping("/edit_member/{id}")
	public ModelAndView edit_Memeber(@PathVariable(name = "id") int id,@ModelAttribute("member") Member member) {
		log.info("Edit member Controller is invoked and id is "+id);
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
		log.info("Delete member controller is invoked and id details - "+id);
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
	
	@RequestMapping(value = "/save_milkCollection", method = RequestMethod.POST)
	public ModelAndView saveMolkCollection(@ModelAttribute("milk_collection") Milk_Collection milk_collection, ModelAndView modelAndView) {
		log.info("Save MilkCollection controller is Invoked - "+milk_collection.toString());
		int count = milk_collectionservice.check_duplicate_ShiftEntry(milk_collection.getMember_id(), milk_collection.getShift(), milk_collection.getCreated_date());
		log.info("Member count in this shift - "+count);
		Boolean id_Exist = memberservice.is_Id_Exist(milk_collection.getMember_id());
		if(id_Exist) {
			if(count == 0) {
		milk_collectionservice.save(milk_collection);
		LocalDate created_date = LocalDate.now();
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		//List<Milk_Collection> milk = milk_collectionservice.getMilk_Collection(milk_collection.getMember_id());
		modelAndView.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
		modelAndView.addObject("milk_member", collections);
		modelAndView.setViewName("milk_wizard");
		return modelAndView;}
			else {
				modelAndView.addObject("confirmationMessage", "ಈ ಶಿಫ್ಟ್‌ನಲ್ಲಿ ಸದಸ್ಯ ಈಗಾಗಲೇ ಹಾಲು ಸೇರಿಸಿದ್ದಾರೆ");
				modelAndView.setViewName("milk_wizard");
				return modelAndView;
			}
		}
		else {
			modelAndView.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ");
			modelAndView.setViewName("milk_wizard");
			return modelAndView;
		}
	}
	@RequestMapping(value = "/view_milk_member", method = RequestMethod.POST)
	public ModelAndView view_Milkmember(@ModelAttribute("milk_collection") Milk_Collection milk_Collection, ModelAndView modelAndView) {
		ModelAndView mav = new ModelAndView("milk_wizard");
		Boolean id_Exist = memberservice.is_Id_Exist(milk_Collection.getMember_id());
		log.info("view milk member is invoked");
		log.info("Id exist - "+id_Exist);
		if (id_Exist)
		{
		Member mem = memberservice.get(milk_Collection.getMember_id());
		log.info("Member Details  - "+mem.toString());
		LocalDate created_date = LocalDate.now();
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		Milk_Collection collection  = new Milk_Collection();
		collection.setMember_id(mem.getId());
		collection.setName(mem.getName());
		mav.addObject("milk_member", collections);
		mav.addObject("milk_collection", collection);
		}
		else {
			
			milk_Collection.setMember_id(0);
			mav.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ  -> " + milk_Collection.getMember_id());
		}
		return mav;
	}
	
	
	@RequestMapping("/edit_milk/{milk_collection_id}")
	public ModelAndView edit_Milk(@PathVariable(name = "milk_collection_id") long milk_collection_id,@ModelAttribute("milk") Milk_Collection collection) {
		log.info("ID  -- - -"+milk_collection_id);
		log.info("Edit member Controller is invoked and id is -  "+collection.toString());
		Milk_Collection milk = milk_collectionservice.findById(milk_collection_id);
		ModelAndView mav = new ModelAndView("edit_milkwizard");
		mav.addObject("milk_collection",milk);
		return mav;
		
	}
	@RequestMapping(value = "/save_EditMilk", method = RequestMethod.POST)
	public ModelAndView saveEditMilk(@ModelAttribute("milk_collection") Milk_Collection milk_collection, ModelAndView modelAndView) {
		milk_collectionservice.save(milk_collection);
		LocalDate created_date = LocalDate.now();
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		modelAndView.setViewName("milk_wizard");
		modelAndView.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಮಾರ್ಪಡಿಸಲಾಗಿದೆ");
		modelAndView.addObject("milk_member", collections);
		return modelAndView;
	
	}
	
	
	@RequestMapping(value = "/local_sale", method = RequestMethod.POST)
	public ModelAndView save_Localsale(@ModelAttribute("localsale") LocalSale localSale, ModelAndView modelAndView) {
		log.info("Save Local sale controller is invoked - " +localSale.toString());
		ModelAndView mav = new ModelAndView("localsale");
		localSaleService.save(localSale);
		mav.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
		return mav;
	}
	
}

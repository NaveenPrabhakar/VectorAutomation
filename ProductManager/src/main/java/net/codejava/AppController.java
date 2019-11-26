package net.codejava;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

@Controller
public class AppController {
	
	public static org.slf4j.Logger log = LoggerFactory.getLogger(AppController.class);
	LocalDate created_date = LocalDate.now();

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
	
	@Autowired
	private TrucksheetService trucksheetService;
	
	@Autowired
	private BankCreationService bankCreationService;
	
	@Autowired
	private SocietyService societyService;
	
	@Autowired
	private BalanceDeduction_service balanceDeduction_service;
	
	

	@RequestMapping("/")
	public String viewLoginPage(Model model) {
		Login login = new Login();
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		model.addAttribute("login", login);
		log.info("Login Page is involked");
		return "login";
	}
	
	@RequestMapping("/admin")
	public String viewAdminPage(Model model) {
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		log.info("Admin Page is involked");
		return "admin";
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
		List<LocalSale> list = localSaleService.getdata(created_date);//
		model.addAttribute("localsales", list);
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		return "localsale";
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView viewLogoutPage(Model model) {
		log.info("Logout Page is involked");
		societyService.resetAllEntries();
		log.info("Cache is Evicted");
		Login login = new Login();
		model.addAttribute("login", login);
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("confirmationMessage", "ನೀವು ಯಶಸ್ವಿಯಾಗಿ ಲಾಗ್ ಔಟ್ ಟ್ ಆಗಿದ್ದೀರಿ." );
		return mav;
	}
	
	@RequestMapping("/main")
	public String viewMainPage(Model model) {
		log.info("Main Page is involked");
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		
		return "main";
	}
	
	@RequestMapping("/view_member")
	public String viewMemberPage(Model model) {
		log.info("View Member  Page is involked");
		Member member = new Member();
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
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
				long id =1;
				Society society= societyService.getdata(id);
				mav.addObject("society",society);
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
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
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
	
	@RequestMapping("/milk_wizard")
    public String milk(Model model){
		log.info("Milk Wizard  Page is involked");
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		log.info("Todays date is -"+created_date);
		Double milk_quantity = milk_collectionservice.getMilkData(created_date);
		log.info("milk"+milk_quantity);
		Double local_quantity = localSaleService.local_quantity(created_date);
		log.info("local"+local_quantity);
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		if(milk_quantity !=null && local_quantity!=null )
		{
		double current_milk = milk_quantity - local_quantity;
		log.info("milkvalue - "+milk_quantity+"local - "+local_quantity+"diff - "+current_milk);
		model.addAttribute("milkquantity", milk_quantity);
		model.addAttribute("localquantity", local_quantity);
		model.addAttribute("totalquantity", current_milk);
		Milk_Collection milk_Collection = new Milk_Collection();
		model.addAttribute("milk_collection", milk_Collection);
		List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
		model.addAttribute("milk_member", coll);
		return "milk_wizard";
		}else if(milk_quantity != null && local_quantity == null )
		{
			model.addAttribute("milkquantity", milk_quantity);
			Milk_Collection milk_Collection = new Milk_Collection();
			model.addAttribute("milk_collection", milk_Collection);
			List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
			model.addAttribute("milk_member", coll);
			model.addAttribute("localquantity", 0);
			model.addAttribute("totalquantity", 0);
			return "milk_wizard";
		}
		else if(milk_quantity == null && local_quantity != null)
		{
			model.addAttribute("localquantity", local_quantity);
			Milk_Collection milk_Collection = new Milk_Collection();
			model.addAttribute("milk_collection", milk_Collection);
			List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
			model.addAttribute("milk_member", coll);
			model.addAttribute("milkquantity", 0);
			model.addAttribute("totalquantity", 0);
			return "milk_wizard";
		}
		else {
			model.addAttribute("milkquantity", 0);
			model.addAttribute("localquantity", 0);
			model.addAttribute("totalquantity", 0);
		Milk_Collection milk_Collection = new Milk_Collection();
		model.addAttribute("milk_collection", milk_Collection);
		List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
		model.addAttribute("milk_member", coll);
		return "milk_wizard";
       }
    }
	
	@RequestMapping(value = "/save_milkCollection", method = RequestMethod.POST)
	public ModelAndView saveMolkCollection(@ModelAttribute("milk_collection") Milk_Collection milk_collection, ModelAndView modelAndView) {
		log.info("Save MilkCollection controller is Invoked - "+milk_collection.toString());
		int count = milk_collectionservice.check_duplicate_ShiftEntry(milk_collection.getMember_id(), milk_collection.getShift(), milk_collection.getCreated_date());
		log.info("Member count in this shift - "+count);
		long id =1;
		Society society= societyService.getdata(id);
		Boolean id_Exist = memberservice.is_Id_Exist(milk_collection.getMember_id());
		if(id_Exist) 
		{
			if(count == 0) {
					milk_collectionservice.save(milk_collection);
				//	LocalDate created_date = LocalDate.now();
					List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
					//List<Milk_Collection> milk = milk_collectionservice.getMilk_Collection(milk_collection.getMember_id());
					modelAndView.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
					modelAndView.addObject("milk_member", collections); //society
					modelAndView.addObject("society", society);
					modelAndView.setViewName("milk_wizard");
					
							}
			else {
					List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
					modelAndView.addObject("milk_member", collections);
					modelAndView.addObject("confirmationMessage", "ಈ ಶಿಫ್ಟ್‌ನಲ್ಲಿ ಸದಸ್ಯ ಈಗಾಗಲೇ ಹಾಲು ಸೇರಿಸಿದ್ದಾರೆ");
					modelAndView.addObject("society", society);
					modelAndView.setViewName("milk_wizard");
					
				}
		}
		else {
			modelAndView.addObject("confirmationMessage", "ನೀವು ನಮೂದಿಸಿದ ಸದಸ್ಯರ ಸಂಖ್ಯೆ ಲಭ್ಯವಿಲ್ಲ");
			modelAndView.addObject("society", society);
			modelAndView.setViewName("milk_wizard");
			
		}
		
		Double milk_quantity = milk_collectionservice.getMilkData(created_date);
		log.info("milk"+milk_quantity);
		Double local_quantity = localSaleService.local_quantity(created_date);
		log.info("local"+local_quantity);
		if(milk_quantity !=null && local_quantity!=null )
		{
		double current_milk = milk_quantity - local_quantity;
		log.info("milkvalue - "+milk_quantity+"local - "+local_quantity+"diff - "+current_milk);
		modelAndView.addObject("milkquantity", milk_quantity);
		modelAndView.addObject("localquantity", local_quantity);
		modelAndView.addObject("totalquantity", current_milk);
		Milk_Collection milk_Collection = new Milk_Collection();
		modelAndView.addObject("milk_collection", milk_Collection);
		List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
		modelAndView.addObject("milk_member", coll);
		modelAndView.addObject("society", society);
		return modelAndView;
		}else if(milk_quantity != null && local_quantity == null )
		{
			modelAndView.addObject("milkquantity", milk_quantity);
			modelAndView.addObject("localquantity", 0);
			modelAndView.addObject("totalquantity", 0);
			Milk_Collection milk_Collection = new Milk_Collection();
			modelAndView.addObject("milk_collection", milk_Collection);
			List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
			modelAndView.addObject("milk_member", coll);
			modelAndView.addObject("society", society);
			return modelAndView;
		}
		else if(milk_quantity == null && local_quantity != null)
		{
			modelAndView.addObject("localquantity", local_quantity);
			modelAndView.addObject("milkquantity", 0);
			modelAndView.addObject("totalquantity", 0);
			Milk_Collection milk_Collection = new Milk_Collection();
			modelAndView.addObject("milk_collection", milk_Collection);
			List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
			modelAndView.addObject("milk_member", coll);
			modelAndView.addObject("society", society);
			return modelAndView;
		}
		else {
			modelAndView.addObject("milkquantity", 0);
			modelAndView.addObject("localquantity", 0);
			modelAndView.addObject("totalquantity", 0);
		Milk_Collection milk_Collection = new Milk_Collection();
		modelAndView.addObject("milk_collection", milk_Collection);
		List<Milk_Collection> coll = milk_collectionservice.get_todays_Milk_Collection(created_date);
		modelAndView.addObject("milk_member", coll);
		modelAndView.addObject("society", society);
		return modelAndView;
       }
	}
	@RequestMapping(value = "/view_milk_member", method = RequestMethod.POST)
	public ModelAndView view_Milkmember(@ModelAttribute("milk_collection") Milk_Collection milk_Collection, ModelAndView modelAndView) {
		ModelAndView mav = new ModelAndView("milk_wizard");
		Boolean id_Exist = memberservice.is_Id_Exist(milk_Collection.getMember_id());
		log.info("view milk member is invoked");
		log.info("Id exist - "+id_Exist);
		long id =1;
		Society society= societyService.getdata(id);
		mav.addObject("society",society);
		if (id_Exist)
		{
		Member mem = memberservice.get(milk_Collection.getMember_id());
		log.info("Member Details  - "+mem.toString());
		//LocalDate created_date = LocalDate.now();
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
		//LocalDate created_date = LocalDate.now();
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		modelAndView.setViewName("milk_wizard");
		modelAndView.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಮಾರ್ಪಡಿಸಲಾಗಿದೆ");
		modelAndView.addObject("milk_member", collections);
		return modelAndView;
	
	}
	
	@RequestMapping("/delete_milkdata/{milk_collection_id}")
	public ModelAndView delete_MilkData(@PathVariable(name = "milk_collection_id") int milk_collection_id,@ModelAttribute("milk") Milk_Collection collection) {
		log.info("ID  -- - -"+milk_collection_id);
		log.info("/delete_milkdata Controller is invoked and id is -  "+collection.toString());
		milk_collectionservice.deleteById(milk_collection_id);
		List<Milk_Collection> collections = milk_collectionservice.get_todays_Milk_Collection(created_date);
		//Milk_Collection milk = new Milk_Collection();
		ModelAndView mav = new ModelAndView("milk_wizard");
		mav.addObject("confirmationMessage", "ಸದಸ್ಯರನ್ನು ಯಶಸ್ವಿಯಾಗಿ ಅಳಿಸಲಾಗಿದೆ " );
		mav.addObject("milk_collection", collection);
		mav.addObject("milk_member", collections);
		return mav;
		
	}
	
	
	@RequestMapping(value = "/local_sale", method = RequestMethod.POST)
	public ModelAndView save_Localsale(@ModelAttribute("localsale") LocalSale localSale, ModelAndView modelAndView) {
		log.info("Save Local sale controller is invoked - " +localSale.toString());
		ModelAndView mav = new ModelAndView("localsale");
		localSaleService.save(localSale);
		List<LocalSale> list = localSaleService.getdata(created_date);//
		mav.addObject("localsales", list);
		long id =1;
		Society society= societyService.getdata(id);
		modelAndView.addObject("society",society);
		mav.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
		return mav;
	}
	
	@GetMapping("/view_trucksheet")
	public String viewTrucksheet(Model model)
	{
		log.info("Truck sheet is invoked");
		Trucksheet trucksheet = new Trucksheet();
		model.addAttribute("trucksheet",trucksheet);
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		return "trucksheet";
		
	}
	@RequestMapping(value = "/truck_sheet", method = RequestMethod.POST)
	public ModelAndView save_trucksheet(@ModelAttribute("localsale") Trucksheet trucksheet, ModelAndView modelAndView) {
		log.info("Save truck sheet controller is invoked - " +trucksheet.toString());
		ModelAndView mav = new ModelAndView("trucksheet");
		trucksheetService.save(trucksheet);
		long id =1;
		Society society= societyService.getdata(id);
				mav.addObject("society",society);
		Trucksheet truck = new Trucksheet();
		mav.addObject("trucksheet",truck);
		mav.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
		return mav;
	}
	
	@GetMapping("/view_bank")
	public String view_bank(Model model)
	{
		log.info("Bank View is invoked");
		Bank_Creation bank_Creation =  new Bank_Creation();
		model.addAttribute("bank",bank_Creation);
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		return "bank_creation";
	}
	
	
	@RequestMapping(value = "/create_bank", method = RequestMethod.POST)
	public ModelAndView save_bank(@ModelAttribute("bank") Bank_Creation bank_Creation, ModelAndView modelAndView) {
		log.info("Save truck sheet controller is invoked - " +bank_Creation.toString());
		ModelAndView mav = new ModelAndView("bank_creation");
		bankCreationService.save(bank_Creation);
		Bank_Creation bc = new Bank_Creation();
		mav.addObject("trucksheet",bc);
		long id =1;
		Society society= societyService.getdata(id);
				mav.addObject("society",society);
		mav.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
		return mav;
	}
	
	@RequestMapping("/balance")
	public String viewBalancePage(Model model) {
		BalanceDeduction balanceDeduction = new BalanceDeduction();
		long id =1;
		Society society= societyService.getdata(id);
		model.addAttribute("society",society);
		model.addAttribute("balance_data",balanceDeduction);
		log.info("Balace Page is involked");
		return "balance_deduct";
	}
	

	@RequestMapping(value = "/balanceinfo", method = RequestMethod.POST)
	public ModelAndView get_balance(@ModelAttribute("balance_data") BalanceDeduction balanceDeduction, ModelAndView modelAndView) {
		log.info("Check Balance is invoked - " +balanceDeduction.toString());
		
		Member mem = memberservice.get(balanceDeduction.getMember_id());
		List<BalanceDeduction> list = balanceDeduction_service.getdata(balanceDeduction.getMember_id());
		log.info("Member info - "+mem.toString());
		Double totalamount = milk_collectionservice.getAmount(balanceDeduction.getMember_id(), balanceDeduction.getFromDate(), balanceDeduction.getToDate());
		log.info("totalamount  - "+totalamount);
		BalanceDeduction bd = new BalanceDeduction();
		bd.setMember_id(mem.getId());
		bd.setName(mem.getName());
		bd.setFromDate(balanceDeduction.getFromDate());
		bd.setToDate(balanceDeduction.getToDate());
		bd.setTotal_amount(totalamount);
		log.info("Balance inf0 - "+bd.toString());
		ModelAndView mav = new ModelAndView("balance_deduct");
				log.info("Balanceinfo - "+bd.toString());
				long id =1;
				Society society= societyService.getdata(id);
				mav.addObject("society",society);
				mav.addObject("balance_data",bd);
				mav.addObject("listinfo",list);
				return mav;
	}
	
	//save_balance
	
	@RequestMapping(value = "/save_balance", method = RequestMethod.POST)
	public ModelAndView save_balance(@ModelAttribute("balance_data") BalanceDeduction balanceDeduction, ModelAndView modelAndView) {
		log.info("save_balance  is invoked - " +balanceDeduction.toString());
		balanceDeduction.setBalance_amount(balanceDeduction.getTotal_amount() - balanceDeduction.getDeduction_amount());
		balanceDeduction_service.save(balanceDeduction);
		List<BalanceDeduction> list = balanceDeduction_service.getdata(balanceDeduction.getMember_id());
		ModelAndView mav = new ModelAndView("balance_deduct");
		long id =1;
		Society society= societyService.getdata(id);
				mav.addObject("society",society);
				mav.addObject("listinfo",list);
				mav.addObject("confirmationMessage", "ಯಶಸ್ವಿಯಾಗಿ ಸೇರಿಸಲಾಗಿ");
				
				return mav;
	}
	
	
}

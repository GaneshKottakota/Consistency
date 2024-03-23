package in.ganeshIT.Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ganeshIT.Application.entity.User;
import in.ganeshIT.Application.service.EmailService;

@Controller
public class MailController {
int a=5;
	
	@Autowired
	private EmailService service;
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("user", new User());
		return "form";
		
	}
	@PostMapping("/register")
	public String register(User user,Model model) {
		boolean user2 = service.rgstrUser(user);
		if(user2==true) {
	model.addAttribute("user", new User());
		            
		   model.addAttribute("msg", "registraion done");
		}else {
			model.addAttribute("user", new User());
			model.addAttribute("msg", "registrationfailed");
		}
			
		
		   return "loginform";
	}
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "loginForm";
		
		
		
	}
	@PostMapping("/loginuser")
	public String handleLogin(User user,Model model) {
		  User login = service.login(user.getEmail(), user.getPwd());
		  
			 if(login!=null) {
		  
		  
			  return "redirect:/dashboard";
			 }
			 else {
				 model.addAttribute("errmsg", "Bad credentials");
				 return "loginform";
			 }
			  
		  }
			  
		  
	@GetMapping("/dashboard")
	public String dashBoard(Model model) {
		return "dashboard";
		
		  
	}
	@GetMapping("/recover")
	public String recoverPwdForm(Model model) {
		return "recoverpwdform";
	}
	@GetMapping("/pwd")
	public String handlepwdRecovery(@RequestParam String email,Model model) {
		         Boolean usr = service.recoverPwd(email);
		       if(usr) {
		    	   model.addAttribute("msg", "pwd sent to ur mail");
		       }
		       else {
		    	   model.addAttribute("msg", "invalid email");
		       }
		       return "recoverpwdform";
		
	}
		
		  
		

}

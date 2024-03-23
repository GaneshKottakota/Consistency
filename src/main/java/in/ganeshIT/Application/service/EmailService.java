package in.ganeshIT.Application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ganeshIT.Application.entity.User;
import in.ganeshIT.Application.repo.MailRepo;
import in.ganeshIT.Application.util.EmailUtils;

@Service
public class EmailService {
	@Autowired
	private EmailUtils emailUtils;
	@Autowired
	private MailRepo repo;
	public  boolean rgstrUser(User user) {
		   User u1 = repo.save(user);
		   if(u1!=null) {
		   return true;
		   }
		   else {
			   return false;
		   }
		
		
	}
	public User login(String email,String pwd) {
		return  repo.findByEmailAndPwd(email, pwd);
		
		}
	public Boolean recoverPwd(String email) {
		User user= repo.findByEmail(email);
		  if(user!=null) {
			  String subject="Recover password";
			  String body="<h1>your password is "+user.getPwd()+"<h1>";
			return  emailUtils.sendEmail(subject, body, email);
			  
		  }
		  else {
			  return false;
		  }
		
		
		}
		
		
	}



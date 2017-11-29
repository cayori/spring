package _10_login.controller;

import javax.validation.Valid;

import _10_login.service.AuthenticationException;
import _10_login.service.Authenticator;
import _10_login.service.LoginCommand;
import _10_login.validator.LoginCommandValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "_10_login/form";
	
	@Autowired
	private Authenticator authenticator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@ModelAttribute
	public LoginCommand formBacking() {
		return new LoginCommand();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@Valid LoginCommand loginCommand, BindingResult result) {
		if(result.hasErrors()) {
			return formViewName;
		}
		try {
			authenticator.authenticate(loginCommand);
			return "redirect:/index.jsp";
		}catch (AuthenticationException e) {
			result.reject("invalidIdOrPassword", new Object[] {loginCommand.getUserId()}, null);
			return formViewName;
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new LoginCommandValidator());
	}
	
	public void setAuthenticator(Authenticator loginService) {
		this.authenticator = loginService;
	}
}
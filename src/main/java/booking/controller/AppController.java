package booking.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import booking.model.User;
import booking.model.UserDTO;

import booking.repository.UserRepository;
import booking.security.IUserService;
import booking.security.UserAlreadyExistException;
 
@Controller
public class AppController {

    @Autowired
    private IUserService userService;
    
	@GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @GetMapping("/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
    }
    
    @PostMapping("/registration")
    public String registerUserAccount(
      @ModelAttribute("user") @Valid UserDTO userDto,
      HttpServletRequest request, Errors errors) {
        
       
      User registered = userService.registerNewUserAccount(userDto);
      return "hello";
       
}
}
package booking.controller;

import booking.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    public String displayLogin(Model model){
        User user= new User();
        model.addAttribute("user",user);
        return "user_login";
    }

}

package secondspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller

public class PortfolioController {
	@GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("dob", "30 may 2002"); // replace with actual DOB
        model.addAttribute("email", "deekshitha78@gmail.com");
        model.addAttribute("mobile", "8123308575");
        model.addAttribute("address", "#175 Sullurupeta, Ramanagara");
        return "about";
    }
}



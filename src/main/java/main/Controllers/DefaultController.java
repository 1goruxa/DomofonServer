package main.Controllers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration
@Controller
public class DefaultController {


    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/profile")
    public String  profile(Model model){
        return "profile";

    }

}
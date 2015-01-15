package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
	
	 @RequestMapping(value="/link")
	 public String mainPage() {
	  return new String("home");
	 }
}

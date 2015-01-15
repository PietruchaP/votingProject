package controller;

import hibernate.model.ZipCodes;
import hibernate.service.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/zipCode")
public class Controler {
	@Autowired
	private Manager manager;

	 @RequestMapping(value="/add", method=RequestMethod.GET)
	 public ModelAndView addStrategyPage(@RequestParam(value = "param") String param) {
		 System.out.println(param);
	  ModelAndView modelAndView = new ModelAndView("strategy-add");
	  modelAndView.addObject("zipCode", new ZipCodes());
	  return modelAndView;
	 }
	 
	 @RequestMapping(value="/add/{param}", method=RequestMethod.GET)
	 public ModelAndView addStrategyPage2(@PathVariable(value = "param") String param) {
		 System.out.println(param);
	  ModelAndView modelAndView = new ModelAndView("strategy-add");
	  modelAndView.addObject("zipCode", new ZipCodes());
	  return modelAndView;
	 }
	  
	 @RequestMapping(value="/add", method=RequestMethod.POST)
	 public ModelAndView addingStrategy(@ModelAttribute ZipCodes zipCode) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  manager.insertZipCode(zipCode);
	  String message = "zipCode was successfully added.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }

	 @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	 public ModelAndView editStrategyPage(@PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("strategy-edit");
//	  ZipCodes zipCode = manager.retriveZipCode(id);
//	  modelAndView.addObject("strategy",zipCode);
	  return modelAndView;
	 }
	  
	 @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	 public ModelAndView edditingStrategy(@ModelAttribute ZipCodes zipCode, @PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
	  manager.updateZipCode(zipCode);
	  String message = "zipCode was successfully edited.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
	  
	 @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	 public ModelAndView deleteStrategy(@PathVariable Integer id) {
	  ModelAndView modelAndView = new ModelAndView("home");
//	  manager.deleteZipCode(id);
	  String message = "zipCode was successfully deleted.";
	  modelAndView.addObject("message", message);
	  return modelAndView;
	 }
}

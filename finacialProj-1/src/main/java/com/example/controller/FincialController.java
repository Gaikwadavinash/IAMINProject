package com.example.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.FinacialGoal;
import com.example.service.IfinacialMangService;

@Controller

public class FincialController {
@Qualifier
	private Validator validate;
	@Autowired
	private IfinacialMangService service;
	
@GetMapping("/home")
	public String getHomePage( @ModelAttribute("finacialGoal")FinacialGoal finacialGoal) {
		return "form";
	}
@PostMapping("/home")
public String showData(@ModelAttribute("finacialGoal") FinacialGoal finacialGoal,Map<String, Object> map,BindingResult result,HttpSession ses,RedirectAttributes att) {
/*
	if(validate.supports(FinacialGoal.class)) {
		validate.validate(finacialGoal, result);
	if(result.hasErrors()) 
		//return lvn
		return "form";
	}
	else 
		return "form";
	*/
	//use service class
	String result1=service.fetchFinacialGoal(finacialGoal);
ses.setAttribute("resultMsg", result1);
	return "redirect:display";
}
@GetMapping("/display")
public String getMessage() {
	System.out.println("FincialController.getMessage()");
	return "show";
}


@RequestMapping("/show")
public String getAllData(@ModelAttribute ("finacialGoal") FinacialGoal finacialGoal,Map<String,Object> map,HttpSession ses1) {

	List<FinacialGoal>	 goal1=service.getAllData();
String result1=service.fetchFinacialGoal(finacialGoal);
//map.put("listData", goal1);
//map.put("resultMsg", result1);

  ses1.setAttribute("listData", goal1);
  ses1.setAttribute("resultMsg",result1);
 
return  "redirect:dis";
} 
@GetMapping("/dis")
public String showMessage() {
	System.out.println("FincialController.getMessage()");
	return "show_Result";
}
@RequestMapping("/delete_goal")
public String deleteGoal(
		@RequestParam("goalName")String name,Map<String,Object> map,@ModelAttribute("finacialGoal")FinacialGoal finacialGoal) {
	//use service
	List<FinacialGoal>	 goal1=service.getAllData();
String res=service.fetchDeletegoalByGoalName(name);
map.put("delete", res);
map.put("listData", goal1);
return "show_Result";
}

@GetMapping("/update_goal")
public String updateGoalbyprice(@ModelAttribute("finacialGoal") FinacialGoal finacialGoal,
		@RequestParam("goalName") String Name) {

	FinacialGoal msg=service.fetchgoalbyGoalName(Name);
	//copy to Model class obj
	BeanUtils.copyProperties(msg,finacialGoal );
	return "form_modify";
}


@PostMapping("/update_goal")
public   String  updateEmployee(Map<String,Object> map,
		@ModelAttribute("finacialGoal") FinacialGoal finacialGoal) {
	
	//use service
	List<FinacialGoal> goal1=service.getAllData();
	String updationMsg=service.upadateGoalPrice(finacialGoal);
	
	map.put("listData", goal1);
	map.put("getData",updationMsg);


	return "show_Result";
	

}
}

package com.example.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;

import com.example.model.FinacialGoal;

@Component("validator")
@Validated
public class Validator implements org.springframework.validation.Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		if(clazz==FinacialGoal.class)
			return true;
		else
	return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Validator.validate()");
		//typecasting
	FinacialGoal goal= (FinacialGoal)target;
	if(goal.getGoalName()==null || goal.getGoalName().equals("") || goal.getGoalName().length()==0) {
	errors.rejectValue("goalName", "goal.Name.Required");
	}else if(goal.getGoalName().length()<5)  {
		errors.rejectValue("goalName", "goal.Name.Length");
	}
	
	if(goal.getGoalPrice()==null || goal.getGoalPrice().equals(""))
		errors.rejectValue("goalPrice","goal.Price.required" );
	else if(goal.getGoalPrice()<100 || goal.getGoalPrice()>1000)
			errors.rejectValue("goalPrice","goal.Price.Int" );
			
		
	}
	}



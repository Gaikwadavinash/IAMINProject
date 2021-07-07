package com.example.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IFinacialDAO;
import com.example.model.FinacialGoal;
import com.example.utility.HibernateUtil;

@Service("finaceService")
public class FincicalMangServiceImpl implements IfinacialMangService {
@Autowired
	private IFinacialDAO dao;


	@Override
	public String fetchFinacialGoal(FinacialGoal goal) {
		//use dao
		int result=dao.insertGoal(goal);
		return result==0?"Record are Inserted":"Record are Inserted";
	}
@Override
	public List<FinacialGoal> getAllData() {
List<FinacialGoal>goal=dao.fetchAllGaol();
		return goal;
	}
public String fetchDeletegoalByGoalName(String goalName) {
		//use dao
	int count=dao.deleteGoalBygoalName(goalName);
		return count==0? "Record are Not deleted":"Record are deleted";
	}

public String upadateGoalPrice(FinacialGoal goal ) {
System.out.println("FincicalMangServiceImpl.upadateGoalPrice()");
	//use dao
	int count =dao.updateGoalByPrice(goal);
		return count==0?"Record are Not Updated":"Record are Updated";
	}


@Override
	public FinacialGoal fetchgoalbyGoalName(String goalName) {
	FinacialGoal fgoal=dao.getGoalbyGoalName(goalName);
		return fgoal;
	}
}

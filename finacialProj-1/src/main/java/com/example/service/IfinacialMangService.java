package com.example.service;

import java.util.List;

import com.example.model.FinacialGoal;

public interface IfinacialMangService {
public String fetchFinacialGoal(FinacialGoal goal );
public List<FinacialGoal>getAllData();
public String fetchDeletegoalByGoalName(String goalName);
public String upadateGoalPrice(FinacialGoal goal );
public FinacialGoal  fetchgoalbyGoalName( String goalName);
}

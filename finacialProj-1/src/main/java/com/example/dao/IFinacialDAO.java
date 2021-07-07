package com.example.dao;

import java.util.List;

import com.example.model.FinacialGoal;

public interface IFinacialDAO {
public int insertGoal(FinacialGoal goal);
public List<FinacialGoal> fetchAllGaol();
public int deleteGoalBygoalName(String goalName);
public int updateGoalByPrice(FinacialGoal goal);
public FinacialGoal getGoalbyGoalName(String GoalName);
}

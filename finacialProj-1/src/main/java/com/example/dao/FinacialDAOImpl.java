package com.example.dao;

import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.TransactionManager;

import org.hibernate.HibernateException;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.FinacialGoal;
import com.example.utility.HibernateUtil;
@Repository("finaceDAO")
public class FinacialDAOImpl implements IFinacialDAO {

//insert Query
private static final String  insert_goal="INSERT INTO Finacial_Goal VALUES(FINA_SEQ.NEXTVAL,?,?)"; 
//Select Query
private static final String get_data="SELECT *FROM Finacial_Goal"	;
//delete Query
private static final String delete_goal="DELETE  FROM  Finacial_Goal WHERE GOAL_NAME=? "	;
//update Query
private static final String update_goal_price="UPDATE  Finacial_Goal SET GOAL_PRICE=?  WHERE  GOAL_NAME=?";

private static final String retrive_goal_by_GoalName="Select GOAL_ID,GOAL_NAME,GOAL_PRICE FROM Finacial_Goal WHERE GOAL_NAME=?";
//Inject data Source	
	@Autowired
private JdbcTemplate jt;
//insert method
	@Override
	public int insertGoal(FinacialGoal goal) {
	
	int count=jt.update(insert_goal,
			goal.getGoalName(),
			          goal.getGoalPrice());
		return count;
}
	//select  Method
	@Override
	public List<FinacialGoal> fetchAllGaol() {
	List<FinacialGoal> Listgoal=jt.query(get_data,rs->{
		List<FinacialGoal> list=new ArrayList();
		while(rs.next()) {
			FinacialGoal goal=new FinacialGoal();
			goal.setGoalId(rs.getInt(1));
			goal.setGoalName(rs.getString(2));
			goal.setGoalPrice(rs.getInt(3));
			list.add(goal);
		
		}
		return list;
	});
	return Listgoal;
	}
		//delete Method
	public int deleteGoalBygoalName(String goalName) {
			int count=jt.update(delete_goal,goalName);
			return count;
		}

	//update Method
	public int updateGoalByPrice(FinacialGoal goal) {
System.out.println("FinacialDAOImpl.updateGoalByPrice()");
System.out.println(goal.getGoalId()+" "+goal.getGoalPrice()+" "+goal.getGoalName());
int count=0;

count=jt.update(update_goal_price,
				
		goal.getGoalPrice(),
				goal.getGoalName());
return count;	
	}

	
	


	
	
	
	
	
	
	@Override
	public FinacialGoal getGoalbyGoalName(String GoalName) {
		FinacialGoal fg =jt.queryForObject(retrive_goal_by_GoalName,(rs,index)->{
		FinacialGoal  goal= new FinacialGoal ();
		goal.setGoalId(rs.getInt(1));
		goal.setGoalName(rs.getString(2));
		goal.setGoalPrice(rs.getInt(3));
		return goal;
	},GoalName);
		return fg;
	}
}	/*
		Transaction tx=null;
		//FinacialGoal goal= new FinacialGoal();
	int goalPriceUp = 0;
		
				if(goal.getGoalPrice()==1000) {
	tx.rollback();				
					return goalPriceUp;
				}else if(goal.getGoalPrice()==500) {
				if(goal.getGoalPrice()==100) {
					
			goalPriceUp=goal.getGoalPrice()+100;
					tx.commit();
				}else if(goal.getGoalPrice()==200)
				goalPriceUp=goal.getGoalPrice()+200;
				tx.commit();
					return goalPriceUp;
				}else if(goal.getGoalPrice()==200) {
					
					if(goal.getGoalPrice()==500) {
						goalPriceUp=goal.getGoalPrice()+500;
								tx.commit();
							}else if(goal.getGoalPrice()==100)
									goalPriceUp=goal.getGoalPrice()+100;
							tx.commit();
								return goalPriceUp;
				}
								else if(goal.getGoalPrice()==100) {
									
									if(goal.getGoalPrice()==500) {
										goalPriceUp=goal.getGoalPrice()+500;
												tx.commit();
											}else if(goal.getGoalPrice()==200)
													goalPriceUp=goal.getGoalPrice()+200;
											tx.commit();
												return goalPriceUp;
								}
						*/

		
		
		
		
	
	



package com.example.model;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity

;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.executable.ValidateOnExecution;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;




@RequiredArgsConstructor
@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Finacial_Goal")
@ConfigurationProperties(prefix ="goal")

public class FinacialGoal implements Serializable{

	@Id
	@GeneratedValue

	private Integer goalId;
//@NonNull
	//@NotNull(message ="GoalName is required" )
//@Min(value = 5,message = "GoalName length  must be 5 character")
	//@Max(value = 255,message = "GoalName length  must be 5 character")
//@jakarta.validation.constraints.NotEmpty
	
	private String goalName;
//@NonNull
	//@NotNull(message ="goal Price is Required" )
//@Size(min = 100,max = 1000,message ="price must be integer 100 to 1000" )
	//@jakarta.validation.constraints.NotEmpty
	private Integer goalPrice;


public String getGoalName() {
	return goalName;
}

public void setGoalName(String goalName) {
	this.goalName = goalName;
}

public Integer getGoalPrice() {
	return goalPrice;
}

public void setGoalPrice(Integer goalPrice) {
	this.goalPrice = goalPrice;
}
public int getGoalId() {
	return goalId;
}

public void setGoalId(int goalId) {
	this.goalId = goalId;
}

@Override
public String toString() {
	return "FinacialGoal [goalId=" + goalId + ", goalName=" + goalName + ", goalPrice=" + goalPrice + "]";
}

}

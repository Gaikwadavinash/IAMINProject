<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<p align="center">${getData}</p>
 <p align="center">${delete}</p>
 <table align="center" bgcolor="cyan">
 <tr> 
     <c:choose>
     <c:when test="${!empty listData}">


    <th>GoalId</th>
    <th>GoalName</th>
        <th>GoalPrice</th>
        <th>DeleteGoal</th>
         <th>UpdateGoalPrice</th>
        </tr>
     <c:forEach var="list" items="${listData}">
     <tr>
    <td>${list.goalId} </td> 
          <td>${list.goalName} </td>
               <td>${list.goalPrice} </td>
  
                <td><a href="delete_goal?goalName=${list.goalName}"><input type="submit" value="delete"></a><td>
                <td><a href="update_goal?goalName=${list.goalName} "><input type="submit" value="update"></a><td>
     </tr>
  
     </c:forEach>

     </c:when>
     <c:otherwise>
     <p>Record are Not Found</p>
     </c:otherwise>
     
     </c:choose>   
</table>



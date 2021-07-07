<%@ page isELIgnored="false"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>


<h1 style="color:red;text-align:center">Goal Edit</h1>

<table border="1"  align="center" bgcolor="cyan">
   <form:form modelAttribute="finacialGoal">
     <tr>
        <td> GoalID::  </td>
        <td> <form:input path="goalId" readonly="true" cssStyle="color:red;background-color:lightgrey"/> </td>
      </tr>
      <tr>
   
      <tr>
        <td> GoalName::  </td>
        <td> <form:input path="goalName" readonly="true" cssStyle="color:red;background-color:lightgrey"/> </td>
      </tr>
      <tr>
        <td>GoalPrice::  </td>
        <td> <form:input path="goalPrice"/> </td>
      </tr>
      
      <tr>
        <td colspan="2"><input type="submit" value="Update"></td>
      </tr>
   </form:form>
</table>


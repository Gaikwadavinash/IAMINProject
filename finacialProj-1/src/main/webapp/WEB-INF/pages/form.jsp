<%@ page isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form  modelAttribute="finacialGoal">


<%-- <p style="text-align: center;color:red">
<form:errors path="*"></form:errors>
</p> --%>
<table align="center" bgcolor="cyan">
<h1 style="text-align: center;color: blue;">Goal</h1>


<tr>
<td>GoalName::</td>
<td><form:input path="goalName"/>
<form:errors cssClass="red" path="goalName"/>
</td>
</tr>

<tr>
<td>GoalPrice::</td>
<td><form:input path="goalPrice"/>
<form:errors cssClass="red" path="goalPrice" />
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Register">
</td>
</tr>

 </table>
</form:form>

<p align="center"><a href="show">get All Data</a></p>


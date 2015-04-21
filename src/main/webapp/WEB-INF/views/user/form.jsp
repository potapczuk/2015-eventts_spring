<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<c:choose>
  <c:when test="${item.id != null}">
    <c:set var="title" value="Edit User" />
  </c:when>
  <c:otherwise>
    <c:set var="title" value="New User" />
  </c:otherwise>
</c:choose>

<t:page title="${title}">
	<div class="row">
		<spring:url var="action" value="/user/save" />
		<form:form action="${action}" commandName="item" method="POST">
			<form:hidden path="id"/>
			<div class="col-md-6">
			
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header">
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<div class="box-body">
						<t:input path="name" labelKey="user.label.name"/>
						<t:input path="email" labelKey="user.label.email"/>
						<t:input path="password" labelKey="user.label.password"/>
					</div>
					<div class="box-footer">
						<input type="submit" value="<spring:message code="template.save"/>" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</form:form>
	</div>
</t:page>
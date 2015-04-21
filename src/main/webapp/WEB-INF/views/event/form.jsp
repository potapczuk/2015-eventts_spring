<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>


<c:choose>
  <c:when test="${item.id != null}">
    <c:set var="title" value="Edit Event" />
  </c:when>
  <c:otherwise>
    <c:set var="title" value="New Event" />
  </c:otherwise>
</c:choose>

<t:page title="${title}">
	<div class="row">
		<spring:url var="action" value="/event/save" />
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
						<t:input path="name" labelKey="event.label.name"/>
						<t:input path="description" labelKey="event.label.description"/>
						<t:input path="price" labelKey="event.label.price"/>
						<t:input path="eventDate" labelKey="event.label.eventDate"/>
					</div>
					<div class="box-footer">
						<input type="submit" value="<spring:message code="template.save"/>" class="btn btn-primary" />
					</div>
				</div>
			</div>
		</form:form>
	</div>
</t:page>
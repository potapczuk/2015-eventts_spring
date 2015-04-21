<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="Remove Event">
	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<div class="box-body">
					<div>Do you really want to remove this record?</div>
					<div>
						<strong>${item.name}</strong>
					</div>
				</div>
				<div class="box-footer">
					<spring:url var="action" value="/event/remove" />
					<form:form action="${action}" commandName="item" method="POST">
						<form:hidden path="id" />
						<input type="submit"
							value="<spring:message code="template.remove"/>"
							class="btn btn-danger" />
						<a href="<c:url value="/event/" />" class="btn btn-default" >
							<spring:message code="template.cancel" />
						</a>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</t:page>
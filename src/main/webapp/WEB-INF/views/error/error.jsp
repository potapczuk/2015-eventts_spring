<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="Error">
	<div class="row">
		<div class="col-md-12">
			<p>Ops, we got a little error</p>
			<p>Please contact our support</p>
		</div>
	</div>
	
	<c:if test="${debug == true}">
		<div class="row">
			<div class="col-md-12">
				<p><br/><br/>
					<b>Failed URL:</b> ${url}<br/>
					<b>${exception.class.name}:</b> ${exception.message}<br/><br/>
					
					<b>Stack:</b><br/>
					<c:forEach items="${exception.stackTrace}" var="ste">${ste}<br/></c:forEach>
					
					<c:if test="${exception.suppressed != null}">
						<br/><br/>
						<b>Suppressed Stack:</b><br/>
						<c:forEach items="${exception.suppressed}" var="sste">${sste}<br/><br/></c:forEach>
					</c:if>
				</p>
			</div>
		</div>
	</c:if>
</t:page>
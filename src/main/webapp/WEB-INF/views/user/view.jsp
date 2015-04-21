<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="${item.name}">
	<div class="row">
		<div class="col-md-12">
			<!-- Info box -->
			<div class="box box-info">

				<div class="box-tools pull-right">

					<div class="btn-group">
						<a href="<c:url value="/user/edit/" />${item.id}"
							class="btn btn-success btn-xs"> <spring:message
								code="template.edit" /></a> <a
							href="<c:url value="/user/remove/" />${item.id}"
							class="btn btn-danger btn-xs"> <spring:message
								code="template.remove" /></a>
					</div>
				</div>

				<div class="box-body">
					<p>${item.email}</p>
					<p>User: ${item.user.name}</p>
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					
				</div>
				<!-- /.box-footer-->
			</div>
			<!-- /.box -->
		</div>
	</div>
</t:page>
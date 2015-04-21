<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:page title="Events">
	<div class="row">
		<c:forEach items="${items.content}" var="item">
			<div class="col-md-4">
				<!-- Info box -->
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">
							<a href="<c:url value="/event/view/" />${item.id}">${item.name}
							</a>
						</h3>
					</div>
					<div class="box-body">${item.description}</div>
					<!-- /.box-body -->
					<div class="box-footer"><fmt:formatDate type="both" 
            dateStyle="short" timeStyle="short" 
            value="${item.eventDate}" /></div>
					<!-- /.box-footer-->
				</div>
				<!-- /.box -->
			</div>
		</c:forEach>
	</div>
</t:page>
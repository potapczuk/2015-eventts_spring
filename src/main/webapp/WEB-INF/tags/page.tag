<%@ attribute name="title" required="true" %>
<%@ tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="template.title" /> - ${title}</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport' />

<link
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/vendor/font-awesome-4.3.0/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value="/resources/vendor/ionicons-1.5.2/css/ionicons.min.css" />"
	rel="stylesheet" type="text/css" />

<link
	href="<c:url value="/resources/vendor/AdminLTE/css/AdminLTE.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="<c:url value="/resources/vendor/html5shiv.js" />"></script>
  <script src="<c:url value="/resources/vendor/respond.min.js" />"></script>
<![endif]-->

</head>

<body class="skin-blue">
	<!-- header logo: style can be found in header.less -->
	<header class="header">
		<a href='<c:url value="/" />' class="logo"><spring:message
				code="template.title" /></a>
		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="navbar-btn sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
			</a>
			<div class="navbar-right">
				<ul class="nav navbar-nav">
					<!-- User Account: style can be found in dropdown.less -->
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <i
							class="glyphicon glyphicon-user"></i> <span>Diego
								Potapczuk <i class="caret"></i>
						</span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header bg-light-blue">
								<p>Diego Potapczuk</p>
							</li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="#" class="btn btn-default btn-flat">Profile</a>
								</div>
								<div class="pull-right">
									<a href="#" class="btn btn-default btn-flat">Sign out</a>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="wrapper row-offcanvas row-offcanvas-left">
		<!-- Left side column. contains the logo and sidebar -->
		<aside class="left-side sidebar-offcanvas">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- search form -->
				<form action="#" method="get" class="sidebar-form">
					<div class="input-group">
						<input type="text" name="q" class="form-control"
							placeholder="Search..." /> <span class="input-group-btn">
							<button type='submit' name='seach' id='search-btn'
								class="btn btn-flat">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div>
				</form>
				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu">
					<li class="active"><a href="<c:url value="/" />"> <i
							class="fa fa-th"></i> <span><spring:message code="menu.home" /></span>
					</a></li>
					<li class="treeview"><a href="#"> <i
							class="fa fa-calendar"></i> <span><spring:message
									code="menu.events" /></span> <i class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="<c:url value="/event/my" />"> <i
									class="fa fa-angle-double-right"></i> <spring:message
										code="menu.events.myevents" />
							</a></li>
							<li><a href="<c:url value="/event/create" />"> <i
									class="fa fa-angle-double-right"></i> <spring:message
										code="menu.events.create" />
							</a></li>
						</ul></li>

					<li class="treeview"><a href="#"> <i class="fa fa-users"></i>
							<span><spring:message code="menu.users" /></span> <i
							class="fa fa-angle-left pull-right"></i>
					</a>
						<ul class="treeview-menu">
							<li><a href="<c:url value="/user/list" />"> <i
									class="fa fa-angle-double-right"></i> <spring:message
										code="menu.users.manage" />
							</a></li>

							<li><a href="<c:url value="/user/create" />"> <i
									class="fa fa-angle-double-right"></i> <spring:message
										code="menu.users.create" />
							</a></li>

						</ul></li>
				</ul>

			</section>
			<!-- /.sidebar -->
		</aside>

		<!-- Right side column. Contains the navbar and content of the page -->
		<aside class="right-side">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>&nbsp;</h1>
				<ol class="breadcrumb">
					<li><a href="<c:url value="/" />"><spring:message
								code="menu.home" /></a></li>
					<li class="active">#BREADCRUMB</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
			
				<c:forEach items="${flashMessages}" var="msg">
					<div class="callout callout-info">${msg}</div>
				</c:forEach>
				
				<c:forEach items="${flashErrors}" var="msg">
					<div class="callout callout-danger">${msg}</div>
				</c:forEach>

				<div class="row">
					<div class="col-md-12">
						<h1>${title}</h1>
					</div>
				</div>

				<jsp:doBody />

			</section>
			<!-- /.content -->
		</aside>
		<!-- /.right-side -->
	</div>
	<!-- ./wrapper -->


	<script src="<c:url value="/resources/vendor/jquery/jquery-2.1.3.min.js" />"></script>
	<script
		src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"
		type="text/javascript"></script>
	<script
		src="<c:url value="/resources/vendor/AdminLTE/js/AdminLTE/app.js" />"
		type="text/javascript"></script>
</body>

</html>
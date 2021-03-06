<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!-- BEGIN CONTENT -->
<div class="page-content-wrapper">
	<div class="page-content">
		<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<div class="modal fade" id="portlet-config" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Modal title</h4>
					</div>
					<div class="modal-body">Widget settings form goes here</div>
					<div class="modal-footer">
						<button type="button" class="btn blue">Save changes</button>
						<button type="button" class="btn default" data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
		<!-- BEGIN PAGE HEADER-->
		<h3 class="page-title">Sữa Thông Tin Người Dùng</h3>
		<div class="page-bar">
			<ul class="page-breadcrumb">
				<li><i class="fa fa-home"></i> <a href="index.html">Home</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Quản Lý Người Dùng</a> <i
					class="fa fa-angle-right"></i></li>
				<li><a href="#">Sữa Thông Tin Người Dùng</a> <i
					class="fa fa-angle-right"></i></li>
			</ul>
		</div>
		<!-- END PAGE HEADER-->
		<!-- BEGIN PAGE CONTENT-->
	<div class="portlet box red">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i> Nhập thông tin người dùng:
							</div>
							<div class="tools">
								<a href="" class="collapse">
								</a>
								<a href="#portlet-config" data-toggle="modal" class="config">
								</a>
								<a href="" class="reload">
								</a>
								<a href="" class="remove">
								</a>
							</div>
						</div>
						<div class="portlet-body form">
						<c:if test="${not empty warn}">
    						<div class="alert alert-warning">
    						<strong>Warning!</strong> ${warn }
  							</div>
						</c:if>
							<form role="form" action="${pageContext.request.contextPath }/admin/user/list?type=edit" method="post">
							<div class="form-body">
									<div class="form-group">
										<input type="hidden" class="form-control" name="uid" value='${fn:escapeXml(user.uid)}'>
									</div>
									<div class="form-group">
										<label>Username:</label>
										<input type="text" class="form-control" name="username" value='${fn:escapeXml(user.uname) }' required>
									</div>
									<div class="form-group">
										<label>Password:</label>
										<input type="password" class="form-control" name="password" value='${fn:escapeXml(user.upass) }' required>
									</div>
									<div class="form-group">
										<label>Is Admin: </label>
										<select class="form-control" name="isAd">
											<option value='0' ${fn:escapeXml(user.isAd)==0 ? "selected":""}>False</option>
											<option value='1' ${fn:escapeXml(user.isAd)==1 ? "selected":""}>True</option>
										</select>
									</div>
									<div class="form-group">
										<label>Is Seller: </label>
										<select class="form-control" name="isSel">
											<option value='0' ${fn:escapeXml(user.isSel)==0 ? "selected":""}>False</option>
											<option value='1' ${fn:escapeXml(user.isSel)==1 ? "selected":""}>True</option>
										</select>
									</div>
									<div class="form-group">
										<label>Shop:</label>
										<select class="form-control" name="shop">
											<option value='0'>Null</option>
											<c:forEach items="${shopList }" var="s">
											<c:choose>
												<c:when test="${not empty fn:escapeXml(user.shop) }">
												<option value='${fn:escapeXml(s.sID) }' ${fn:escapeXml(user.shop.sID)==s.sID ? "selected":""}> ${fn:escapeXml(s.sName) } </option>
												</c:when>
												<c:otherwise>
												<option value='${fn:escapeXml(s.sID) }'> ${fn:escapeXml(s.sName) } </option>
												</c:otherwise>
											</c:choose>
											</c:forEach>
										</select>
									</div>
									</div>
								<input type="hidden" name="<csrf:tokenname/>" value="<csrf:tokenvalue uri="${pageContext.request.contextPath }/admin/user/list"/>"/>	
								<div class="form-actions right">
									<button type="submit" class="btn green">Submit</button>
								</div>
							</form>
						</div>
					</div>
	<!-- END CONTENT -->
</div>
	<!-- END CONTAINER -->
	</div>
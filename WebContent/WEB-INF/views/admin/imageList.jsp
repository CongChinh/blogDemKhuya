<%@page import="java.io.OutputStream"%>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Image</title>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>

<div class="admin_content">
	<div class="divLink">
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/imageList">List</a></li>
		</ul>
	</div>
	<div class="table">
		<div class="">
			<div>
				<!-- Trigger/Open The Modal -->
				<button id="myBtn" class="btnAdd">
					click
				</button>
			</div>
			<table id="frame">
				<tr>
					<th>ID</th>
					<th>Ảnh</th>
					<th>Thể loại</th>
					<th>Ngày tải</th>
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
				<c:forEach items="${imageList}" var="image">
					<tr>
						<td>${image.image_id}</td>
						<td>
							<img width="100" height="70" alt="" src=" ${pageContext.request.contextPath}/admin/imageList?image_id=${image.image_id}">
						</td>
						<td>${image.images_category_id}</td>
						<td>${image.image_date}</td>
						<td><a href="#">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/subjectDelete?subject_id=${image.image_id}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<!--Phan trang-->
			<div class="pagination">
				<table class="tableNGLLPagination">
					<tr>
						<c:if test="${currentPage != 1}">
							<td><a
								href="${pageContext.request.contextPath}/admin/imageList?page=${currentPage - 1}">Previous</a>
							</td>
						</c:if>
						<c:forEach begin="1" end="${totalRecords}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><a
										href="${pageContext.request.contextPath}/admin/imageList?page=${i}">${i}</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${currentPage lt totalRecords}">
							<td><a
								href="${pageContext.request.contextPath}/admin/imageList?page=${currentPage + 1}">Next</a>
							</td>
						</c:if>
					</tr>
				</table>
			</div>

		</div>
	</div>
</div>
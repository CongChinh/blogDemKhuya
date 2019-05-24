<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Âm nhạc</title>
<jsp:include page="_header.jsp"></jsp:include>
<div class="row">

	<%--Danh sách chủ đề ảnh --%>
	<div class="col-2 menu">
		<c:forEach items="${imagecategoryList}" var="imagecategory">
			<ul>
				<li>${imagecategory.images_category_name}</li>
			</ul>
		</c:forEach>

	</div>
	<%--Danh sách ảnh --%>
	<div class="col-9">
		<c:forEach items="${imageList}" var="image">
			<tr>
				<td>
					<div class="col-4">
						<table>
							<tr>
								<td style="border-style: solid 1px"><img width="100%"
									height="100%" alt=""
									src=" ${pageContext.request.contextPath}/admin/imageList?image_id=${image.image_id}"></td>
							</tr>
						</table>
					</div>
				</td>
			</tr>
		</c:forEach>
	</div>
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
<jsp:include page="_footer.jsp"></jsp:include>
<%@page import="entity.Subject"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="_header.jsp"></jsp:include>
<div class="row">
	<div class="col-3 menu">
		<ul>
			<li>JavaScript</li>
			<li>Java</li>
			<li>Python</li>
			<li>aLa</li>
		</ul>
	</div>
	<div class="col-6">
		<c:forEach items="${imageList}" var="image">
			<tr>
				<td><img width="100" height="70" alt=""
					src=" ${pageContext.request.contextPath}/admin/imageList?image_id=${image.image_id}">
				</td>
			</tr>
		</c:forEach>
	</div>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Upload Music</title>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>
    <div class="admin_content">
    <div>
    	<h1>Cong Chinh</h1>
    
    </div>
		<h1>Tải image</h1>
		<form action="${pageContext.request.contextPath}/admin/imageUpload" method="post" enctype="multipart/form-data" >
			<label>Tải tệp : </label>
			<input type="file" name="image"  /> <br />
			<select name="imagesCategory">
				<c:forEach items="${imagescategoryList}" var="imagescategory">
					<option value="${imagescategory.images_category_id}">${imagescategory.images_category_name}</option>
				</c:forEach>
			</select><br>
			<input type="submit" />
		</form>
	</div>
<jsp:include page="_footer.jsp"></jsp:include>
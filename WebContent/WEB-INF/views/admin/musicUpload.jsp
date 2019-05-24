<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Upload Music</title>

<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>
    <div class="admin_content">
		<h1>Tải nhạc</h1>
		<form action="${pageContext.request.contextPath}/admin/musicUpload" method="post" enctype="multipart/form-data" >
			<span>Ten bai hat : </span>
			<input type="text" name="music_name" size="100" /><br>
			<span>Tải tệp : </span>
			<input type="file" name="file"  /> <br />			
			
			<span>Ca si</span>
			<input type="text" name="music_singer" size="100" /><br>
			<select name="musicsCategory">
				<c:forEach items="${musicscategoryList}" var="musicscategory">
					<option value="${musicscategory.musics_category_id}">${musicscategory.musics_category_name}</option>
				</c:forEach>
			</select><br>
			<input type="submit" value="Upload" />
		</form>
	</div>
<jsp:include page="_footer.jsp"></jsp:include>
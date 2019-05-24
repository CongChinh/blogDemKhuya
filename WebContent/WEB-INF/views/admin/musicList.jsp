<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Âm nhạc</title>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>

<div class="admin_content">
	<div class="divLink">
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/musicList">List</a></li>
		</ul>
	</div>
	<div class="divTable">
		<div class="divTableChild">
			<div>
				<!-- Trigger/Open The Modal -->
				<button id="myBtn" class="btnAdd"><i class="fas fa-plus-circle"></i></button>
			</div>
			<table id="tableNGLL">
				<tr>
					<th>ID</th>
					<th>Bài hát</th>
					<th>Tệp bài hát</th>
					<th>Ca sĩ</th>
					<th>MP3</th>
					<th>Thể loại</th>
					<th>Ngày tải</th>
					
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
				<c:forEach items="${musicList}" var="music">
					<tr>
						<td>${music.music_id}</td>
						<td>${music.music_name}</td>
						<td>${music.music_filename}</td>
						<td>${music.music_singer}</td>
						<td>
							 <audio controls>
  								
  								<source src="${pageContext.request.contextPath}/admin/musicList?music_id=${music.music_id}" type="audio/mpeg">
								
							</audio> 
						</td>
						
						<td>${music.musics_category_id}</td>
						<td>${music.music_date}</td>
						<td><a href="#">Edit</a></td>
						<td><a
								href="${pageContext.request.contextPath}/admin/subjectDelete?subject_id=${music.music_id}">Delete</a>
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
									href="${pageContext.request.contextPath}/admin/musicList?page=${currentPage - 1}">Previous</a>
							</td>
						</c:if>
						<c:forEach begin="1" end="${totalRecords}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><a
											href="${pageContext.request.contextPath}/admin/musicList?page=${i}">${i}</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${currentPage lt totalRecords}">
							<td><a
									href="${pageContext.request.contextPath}/admin/musicList?page=${currentPage + 1}">Next</a>
							</td>
						</c:if>
					</tr>
				</table>
			</div>

		</div>
	</div>
</div>
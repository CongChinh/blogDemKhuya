<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Ngôn ngữ lập trình</title>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>

<div class="admin_content">
	<div class="divLink">
		<ul class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/subjectList">List</a></li>
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
					<th>Ngôn ngữ lập trình</th>
					<th>Sửa</th>
					<th>Xóa</th>
				</tr>
				<c:forEach items="${subjectList}" var="subject">
					<tr>
						<td>${subject.subject_id}</td>
						<td>${subject.subject_name}</td>
						<td><a href="#">Edit</a></td>
						<td><a
								href="${pageContext.request.contextPath}/admin/subjectDelete?subject_id=${subject.subject_id}">Delete</a>
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
									href="${pageContext.request.contextPath}/admin/subjectList?page=${currentPage - 1}">Previous</a>
							</td>
						</c:if>
						<c:forEach begin="1" end="${totalRecords}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<td>${i}</td>
								</c:when>
								<c:otherwise>
									<td><a
											href="${pageContext.request.contextPath}/admin/subjectList?page=${i}">${i}</a>
									</td>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${currentPage lt totalRecords}">
							<td><a
									href="${pageContext.request.contextPath}/admin/subjectList?page=${currentPage + 1}">Next</a>
							</td>
						</c:if>
					</tr>
				</table>
			</div>

		</div>
	</div>
</div>


<!-- The Modal Add -->
<div id="myModal" class="modal">

	<!-- Modal content -->
	<div class="modal-content">
		<span class="close">&times;</span>
		<form action="${pageContext.request.contextPath}/admin/subjectCreate" method="POST">
			Ngôn ngữ lập trình:
			<input type="text" name="subject_name" value="${subject.subject_name}">

			<br><br>
			<input type="submit" value="Submit">
		</form>
	</div>

</div>
<!-- The Modal Update-->
<script>

	// Get the modal
	var modal = document.getElementById('myModal');

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal
	btn.onclick = function () {
		modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function () {
		modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function (event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
</script>
<jsp:include page="_footer.jsp"></jsp:include>
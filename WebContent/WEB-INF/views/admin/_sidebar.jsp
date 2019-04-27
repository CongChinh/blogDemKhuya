<%@ page pageEncoding="utf-8"%>
<div class="admin_sidenav">
	<a href="${pageContext.request.contextPath}/admin">Dashboard</a>
	<a href="#" class="userManager">Quản lý người dùng</a>
	<ul class="hideShow" style="color:white">
		<li><a href="#">Add</a></li>
		<li><a href="#">Update</a></li>
		<li><a href="#">Delete</a></li>
	</ul>
	<a href="${pageContext.request.contextPath}/admin/subjectList">Chủ đề</a>
	<a href="">Âm nhạc</a>
	<script>
		$(document).ready(function () {
			$(".hideShow").hide();
			$(".userManager").click(function () {
				$(".hideShow").toggle(500);
			});
		});
	</script>
</div>

<%@ page pageEncoding="utf-8"%>
<div class="admin_sidenav">
	<a href="${pageContext.request.contextPath}/admin">Dashboard</a>
	<a href="#">Quản lý người dùng</a>
	<button class="admin_dropdown-btn">Dropdown 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="admin_dropdown-container">
	    <a href="#">Link 1</a>
	    <a href="#">Link 2</a>
	    <a href="#">Link 3</a>
  	</div>
  	
	<a href="${pageContext.request.contextPath}/admin/subjectList">Chủ đề</a>
	
	<button class="admin_dropdown-btn">Âm nhạc 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="admin_dropdown-container">
	    <a href="${pageContext.request.contextPath}/admin/musicUpload">Thêm nhạc</a>
	    <a href="${pageContext.request.contextPath}/admin/musicList">Danh sách nhạc</a>
  	</div>
	
	
	<button class="admin_dropdown-btn">Ảnh 
    	<i class="fa fa-caret-down"></i>
  	</button>
  	<div class="admin_dropdown-container">
	    <a href="${pageContext.request.contextPath}/admin/imageUpload">Thêm ảnh</a>
	    <a href="${pageContext.request.contextPath}/admin/imageList">Danh sách ảnh</a>
  	</div>
	
	<script>
		var dropdown = document.getElementsByClassName("admin_dropdown-btn");
		var i;
	
		for (i = 0; i < dropdown.length; i++) {
		  dropdown[i].addEventListener("click", function() {
		  	this.classList.toggle("active");
		  	var dropdownContent = this.nextElementSibling;
		  	if (dropdownContent.style.display === "block") {
		  		dropdownContent.style.display = "none";
		  	} else {
		  		dropdownContent.style.display = "block";
		  	}
		  });
		}
	</script>
</div>

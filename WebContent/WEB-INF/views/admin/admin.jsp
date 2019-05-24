<%@ page pageEncoding="utf-8"%>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_sidebar.jsp"></jsp:include>

<div class="admin_content">
	<div class="tableDashboard">
		<table class="tableDash">
			<tr>
				<th class="th1 thDashboard">Java</th>
				<th class="th2 thDashboard">JavaScript</th>
				<th class="th3 thDashboard">HTML</th>
				<th class="th4 thDashboard">CSS</th>
			</tr>
			<tr>
				<th>CSS</th>
				<th colspan="3" class="weather">
					<img src="<%=request.getContextPath()%>/templates/images/beautifulGirl.jpg" alt="" width="500px" height="500px">
					<img src="Downloads/windows-10.jpg" alt="" width="100px" height="100px">
				</th>
			</tr>
		</table>
	</div>
</div>

<jsp:include page="_footer.jsp"></jsp:include>
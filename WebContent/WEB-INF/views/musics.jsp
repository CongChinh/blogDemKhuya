<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>Âm nhạc</title>
<jsp:include page="_header.jsp"></jsp:include>
<div class="row">
	<div class="col-3 menu">
		<c:forEach items="${musiccategoryList}" var="musiccategory">
			<ul>
				<li>${musiccategory.musics_category_name}</li>
			</ul>
		</c:forEach>
	</div>
	<div class="col-6">
		<button style="border: none; background-color: white">
			Click
		</button>
		<table>
			<tr>
				<th>
					<audio controls>
						<source id="audioPlayer" src="" type="audio/mpeg">
					</audio>
				</th>
			</tr>
			<c:forEach items="${top10Musics}" var="top10">
			<tr>
				<td>
					<ul id="playlist">
						<li><a href="${pageContext.request.contextPath}/musics?music_id=${top10.music_id}">${top10.music_name}</a></li>
					</ul>
				</td>
			</tr>
			</c:forEach>
		</table>
		<%-- <audio controls style="width: 60%;margin-left: 20%;">
			<c:forEach items="${top10Musics}" var="top10">
				<source src="${pageContext.request.contextPath}/musics?music_id=${top10.music_id}" type="audio/mpeg">
			</c:forEach>
		</audio> --%>
	</div>
</div>
<%-- <div class="row">
	<div class="12" style="background-color: black">
		<a href="#" style="float: left;color: aliceblue">Click</a>
		<audio controls style="width: 40%;margin-left: 30%;">
			<c:forEach items="${top10Musics}" var="top10">
			<source src="${pageContext.request.contextPath}/musics?music_id=${top10.music_id}" type="audio/mpeg" aria-valuetext="asd">
			</c:forEach>
		  </audio> 
	</div>
</div>--%>
<script>
	 
</script>
<jsp:include page="_footer.jsp"></jsp:include>
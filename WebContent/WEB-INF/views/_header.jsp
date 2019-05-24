<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="templates/style.css" rel="stylesheet" type="text/css">
	<link href="templates/audio.css" rel="stylesheet" type="text/css">
	<title>Trò chuyện đêm khuya</title>
</head>

<body>
	<div class="topnav">
		<div>
			<a class="active" href="${pageContext.request.contextPath}/">Trang chủ</a>
			<a href="#new">Radio</a>
			<a href="#contact">Blog</a>
			<a href="${pageContext.request.contextPath}/musics">MP3</a>
			<a href="${pageContext.request.contextPath}/images">Ảnh</a>
		</div>

		<div class="topright">
			<a href="${pageContext.request.contextPath}/admin">Admin</a>
			<a href="#login">Đăng nhập</a>
		</div>
	</div>
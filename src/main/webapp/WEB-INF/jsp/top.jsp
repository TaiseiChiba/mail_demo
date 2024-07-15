<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common/bootstrap.css">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/common/formCheck.js"></script>
<title>トップ</title>
</head>
<body>
<main>
  <h1>トップページ</h1>
  <c:out value="${ sessionScope.user.userName }"/>
  <form action="./front-controller" method="post">
    <button class="btn btn-primary" name="buttonId" value="uc002_01">メール送信</button>
  </form>
</main>
</body>
</html>
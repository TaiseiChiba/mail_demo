<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
  href="${pageContext.request.contextPath}/css/common/bootstrap.css">
<script type="text/javascript"
  src="${pageContext.request.contextPath}/js/common/formCheck.js"></script>
<title>ログイン画面</title>
</head>
<body>
  <main>
    <h1>ログイン画面</h1>
    <hr>
    <div class="row mb-3">
      <c:out value="${ requestScope.errorMessage }" />
    </div>
    <form class="neeeds-validation" action="./front-controller"
      method="post" novalidate>
      <div class="row mb-3">
        <label for="email" class="col-sm-2 col-form-label">メールアドレス</label>
        <div class="col-sm-4">
          <input id="email" class="form-control" type="email"
            name="email" value="${ param.email }">
          <div class="invalid-feedback">メールアドレス形式で入力してください</div>
        </div>
      </div>
      <div class="row mb-3">
        <label for="password" class="col-sm-2 col-form-label">パスワード</label>
        <div class="col-sm-4">
          <input id="password" class="form-control" type="password"
            name="password" value="${ param.password }" required>
          <div class="invalid-feedback">入力してください</div>
        </div>
      </div>
      <div class="row mb-3">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
          <button class="btn btn-primary" type="submit" name="buttonId"
            value="uc001_02">送信</button>
        </div>
        <div class="col-sm-4"></div>
      </div>
    </form>
  </main>
</body>
</html>
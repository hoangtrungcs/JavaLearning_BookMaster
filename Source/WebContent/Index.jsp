<%@page import="Utility.Util"%>
<%@page import="Model.BookModelForm"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<html>
<head>
<title>Book Master</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="The book master">
<meta name="author" content="Trung Lee">

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/assets/css/style.css">

<script type="text/javascript">
	
</script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>
<body>
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="logo span4">
						<h1>
							<a style="float:left" href="">本マスタメンテ <span class="red">.</span></a>
						</h1>
					</div>
				</div>
			</div>
		</div>

		<div class="register-container container">
			<div class="row">
				<div class="iphone span5">
					<img src="${pageContext.request.contextPath}/resources/assets/img/book.png" alt="">
				</div>
				<div class="register span6">
					<html:form action="hello.do" method="post">
						<h2>
							<span class="red"><strong>本</strong></span>マスタメンテ
							<a style="float:right;font-size: 12px;" href="javascript:window.open('','_self').close();" >閉じる</a>
						</h2>
						
						<label  for="bookid">本ID：  <font color="red"><html:errors property="bookid" /></font> </label>  
						<input type="text" value="${requestScope.book.bookid}" maxlength="4"
							style="width: 50%; margin-right: 10px" id="bookId" name="bookid" placeholder="enter the book Id...">
						<button type="submit" id="btnBookId" name="method" value="search"  class="btn btn-default">検索</button>
						<hr />
						
						<label for="booktitle" >本タイトル： <font color="red"><html:errors  property="bookTitle" /></font></label>
						<input type="text" id="booktitle" name="bookTitle" value="${requestScope.book.bookTitle}" placeholder="enter the book title..."> 
						
						<label for="authorname">著者名： <font color="red"><html:errors property="authorName" /></font> </label> 
						<input type="text"	id="authorname" name="authorName" value="${requestScope.book.authorName}" placeholder="enter the author name..."> 
						
						<label for="publisher">出版社： <font color="red"><html:errors property="publisher" /></font> </label> 
						<input type="text" value="${requestScope.book.publisher}" id="publisher" name="publisher"
						placeholder="enter the publisher..."> 
						
						<label for="publicationdate">出版年月日（西暦）： <font color="red"><html:errors property="publicationdate" /></font> </label></label>
						<div class="divBottom">
							<input type="number" id="year" style="width: 20%" name="year" minlength="4" maxlength="4" value="${requestScope.book.year}"
								placeholder="year..."> 
								<label class="publicationdate"	for="year">年</label> 
								<input type="number" id="month" value="${requestScope.book.month}" minlength="2" maxlength="2" style="width: 10%" name="month" placeholder="month...">
							<label class="publicationdate" for="month">月</label> 
							<input	type="number" id="day" style="width: 10%"  name="day" value="${requestScope.book.day}"
								minlength="2" maxlength="2" placeholder="day..."> <label class="publicationdate"
								for="day">日</label>
						</div>
						
						<div class="group groupbuttonakignright">
							<button type="submit" id="btnAdd" name="method" value="add"
								class="btn btn-primary margintop">追加</button>
							<button type="submit" id="btnUpdate" name="method" value="update"
								class="btn btn-primary margintop">更新</button>
							<button type="submit" id="btnDelete" name="method" value="delete"
								class="btn btn-primary margintop">削除</button>
									<button type="submit" id="btnClear" name="method" value="clear"
								class="btn btn-warning margintop buttonA">クリア</button>
						</div>
					</html:form>
				</div>
			</div>
		</div>
		
		<!-- Model poup -->
		<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">メッセージ</h4>
		      </div>
		      <div class="modal-body">
		        <p id="showMessage">${requestScope.book.message}</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">Ok</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
		
	<!-- Javascript -->
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.8.2.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/assets/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/assets/js/jquery.backstretch.min.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/resources/assets/js/scripts.js"></script>
</body>
</body>
</html>
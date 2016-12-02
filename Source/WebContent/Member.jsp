<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tag"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>

<tag:MasterTag>
	<html:form style="height:458px" action="hello.do" method="post">
		<h2>
			<span class="red"><strong>メニュー</strong></span>画面
			<a style="float: right; font-size: 12px;" href="javascript:window.open('','_self').close();">閉じる</a>
		</h2>
		
		<table style="width: 100%; height: 350px">
			<tr>
				<td style="width: 50%;height:50%;text-align: center;">
					<button type="button" style="width:60%;height: 100px" class="btn btn-info btn-lg">
  					<span class="glyphicon glyphicon-user" aria-hidden="true"></span> 会員マスタメンテ</button>
				</td>
				<td style="text-align: center;">
					<button type="button" style="width:60%;height: 100px" class="btn btn-warning btn-lg">
  					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>貸出</button>
				</td>
			</tr>
			<tr >
				<td></td>
				<td style="text-align: center;width: 50%;height:100%;">
					<button type="button" style="width:60%;height: 100px" class="btn btn-danger btn-lg">
  					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>返却</button>
				</td>
			</tr>
		</table>
		
		
		
		
		
		
	</html:form>
			
</tag:MasterTag>
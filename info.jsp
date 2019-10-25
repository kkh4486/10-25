<%@page import="com.exam.dao.MemberDao"%>
<%@page import="com.exam.vo.MemberVO2"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 조회</title>
</head>
<body>
	<!-- header 영역 -->
	<jsp:include page="../include/header.jsp" />

	<!-- nav 영역 -->
	<jsp:include page="../include/nav.jsp" />
	<div class="full-width back-image1 full-page page" id="first"> 
	<%
//세션값 가져오기
String id = (String)session.getAttribute("id");

// DAO 객체 땡겨오기
MemberDao memberDao = MemberDao.getInstance();

// VO 객체 가져오기
MemberVO2 memberVO2 = memberDao.getMember(id);



// 세션값 없으면 loginForm.jsp 이동
if (id == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>

<h1 style="text-align: center;">회원정보 조회</h1>
<table style="text-align: center; margin: auto;">
<tr>
	<td>아이디: <%=memberVO2.getId() %></td>
</tr>
<tr>	
	<td>패스워드: <%=memberVO2.getPasswd() %></td>
</tr>
<tr>
<td>이름: <%=memberVO2.getName() %></td>
</tr>
<tr>
<td>이메일: <%=(memberVO2.getEmail() == null) ? "" : memberVO2.getEmail() %></td>
</tr>
<tr>
	<td>가입날짜: <%=memberVO2.getRegDate() %></td>
</tr>
</table>
<br />
<button style="margin-left: 900px;">
	<input type="button" value="뒤로가" onclick="location.href='../main/main.jsp';"/>
</button>
  <%-- footer 영역 --%>
   <jsp:include page ="../include/footer.jsp" />

</div>
</body>
</html>




<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User2::modify</title>
</head>
<body>
	<h3>User2 수정</h3>
	
	<a href="#">처음으로</a>
	<a href="#">목록</a>
	
	<form action="#" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="uid" readonly/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="date" name="birth" /></td>
			</tr>
			<tr>
				<td>주소</td>
				<td><input type="text" name="addr" /></td>
			</tr>

			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정하기"/>
				</td>
			</tr>		
		</table>
	
	</form>
	
	
</body>
</html>
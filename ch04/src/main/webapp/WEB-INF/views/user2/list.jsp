<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>User2::list</title>

	</script>
</head>
<body>
	<h3>User2 목록</h3>

	<a href="/ch04/">처음으로</a>
	<a href="/ch04/user2/register">등록</a>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>생년월일</th>
			<th>주소</th>
			<th>관리</th>
		</tr>

		<tr>
			<td>dsadsa</td>
			<td>asdsad</td>
			<td>asdas</td>
			<td>sadas</td>

			<td>
				<a href="/ch04/user2/modify?uid=${user.uid}">수정</a>
				<a href="">삭제</a>
			</td>
		</tr>
	</table>
</body>
</html>
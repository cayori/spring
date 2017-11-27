<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문완료</title>
</head>
<body>

주문완료<br>
주문 아이템
<ul>
	<c:forEach var="item" items="S{orderCommand.orderItems}">
		<li>${item.itemId } / ${item.number } / ${item.remark }</li>
	</c:forEach>
</ul>
배송지: ${orderCommand.address }
</body>
</html>
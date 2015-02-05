<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Currency Fair transaction Info</title>
<style type="text/css">
table {
	font-family: verdana, arial, sans-serif;
	font-size: 11px;
	color: #333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}

table th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}

table td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>
<body>

	<table>
		<tr>
			<th>User</th>
			<th>Currency From</th>
			<th>Currency To</th>
			<th>Amount Sell</th>
			<th>Amount Buy</th>
			<th>Rate</th>
			<th>Time Placed</th>
			<th>originating Country</th>
		</tr>
		<tr>
			<c:forEach items="${allTransactions}" var="transMoney">
				<tr>
					<td>${transMoney.user}</td>
					<td>${transMoney.currencyFrom}</td>
					<td>${transMoney.currencyTo}</td>
					<td>${transMoney.amountSell}</td>
					<td>${transMoney.amountBuy}</td>
					<td>${transMoney.rate}</td>
					<td>${transMoney.timePlaced}</td>
					<td>${transMoney.originatingCountry}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<p></p>
	<table>
		<tr>
			<th>Currency From</th>
			<th>Currency To</th>
			<th>Sum amountSell</th>
			<th>Sum amountBuy</th>
		</tr>
		<%
			java.util.List<Object> transGroupByCurrency = (java.util.List) request.getAttribute("transactionByCurrency");
			for (Object transRow : transGroupByCurrency) {
				Object[] row = (Object[]) transRow;
		%>
		<tr>
			<td><%=row[0]%></td>
			<td><%=row[1]%></td>
			<td><%=row[2]%></td>
			<td><%=row[3]%></td>
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>

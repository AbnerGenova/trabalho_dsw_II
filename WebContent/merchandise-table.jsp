<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "gerpro";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Gerpro</title>
		<link rel="stylesheet" type="text/css" href="public/assets/css/default.css">
		<link rel="stylesheet" type="text/css" href="public/assets/css/table.css">
		<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700" rel="stylesheet">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="page">
			<div class="header">
				<div class="logo">
					<a href="index.jsp" title="Gerpro">
						<img src="public/assets/images/logo.png" alt="Gerpro" />
					</a>
				</div>
				<div class="header_menu">
					<ul>
						<li><a href="add-merchandise.jsp" title="Adicionar">Adicionar mercadorias</a></li>
						<li><a href="merchandise-table.jsp" title="Ver">Ver mercadorias</a></li>
					</ul>
				</div>
				<div class="clear"></div>
			</div>
			<div class="container">
			  	<h2>Mercadorias cadastradas</h2>
			 	<p>Veja abaixo todas as mercadorias já inseridas na plataforma.</p>            
			  	<table class="table table-hover">
			    	<thead>
				      	<tr>
				      		<th>Id</th>
				        	<th>Código da mercadoria</th>
				        	<th>Tipo da mercadoria</th>
				        	<th>Nome da mercadoria</th>
				        	<th>Quantidade</th>
				        	<th>Preço</th>
				        	<th></th>
				      	</tr>
			    	</thead>
			    	<tbody>
			    		<%
							try{
							connection = DriverManager.getConnection(connectionUrl+database, userid, password);
							statement=connection.createStatement();
							String sql ="select * from product";
							resultSet = statement.executeQuery(sql);
							while(resultSet.next()){
						%>
						<tr>
				        	<td><%=resultSet.getString("id") %></td>
				        	<td><%=resultSet.getString("code") %></td>
				        	<td><%=resultSet.getString("type") %></td>
				        	<td><%=resultSet.getString("name") %></td>
				        	<td><%=resultSet.getString("quantity") %></td>
				        	<td><%=resultSet.getString("price") %></td>
				        	<td>
				        		<form action="Delete" method="post">
				        			<input type="hidden" name="product_id" value=<%=resultSet.getString("id") %>>
				        			<input type="submit" class="delete_item_button" value="" />
				        		</form>
				        	</td>
				        </tr>
						<%
							}
							connection.close();
							} catch (Exception e) {
							e.printStackTrace();
							}
						%>
			    	</tbody>
			  </table>
			</div>
		</div>
	</body>
</html>
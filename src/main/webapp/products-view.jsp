<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="com.uniovi.sdi.* , java.util.List"%>
<html lang="en">
<head>
    <title>Servlets</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Contenido -->
<div class="container" id="main-container">
    <h2>Lista de Productos</h2>
    <div class="row ">
        <c:forEach var="product" begin="0" items="${productsList}">
            <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
                <div>
                    <div><c:out value="${product.name}"/></div>
                    <div><c:out value="${product.price}"/> €</div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>

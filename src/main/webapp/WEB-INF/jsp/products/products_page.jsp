<%@ page import="com.github.abureala.Abureala.model.Product" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s products are</h1>
    <%= request.getAttribute("productsList")%>
    <ul>
        <c:forEach items="${productsList}" var="product">
            <li>Product id: ${product.id} Product name: ${product.name}</li>
        </c:forEach>
    </ul>
</div>

<div class="album py-5 bg-light">
    <div class="container">
        <%@include file="product_list.jspf" %>
    </div>
</div>

<%@ include file="../common/footer.jspf" %>
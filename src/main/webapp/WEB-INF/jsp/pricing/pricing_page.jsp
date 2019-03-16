<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>

<div class="position-relative overflow-hidden p-3 p-md-5 m-md-3 text-center bg-light">
    <div class="col-md-5 p-lg-5 mx-auto my-5">
        <h1 class="display-4 font-weight-normal">${productName}</h1>
        <p class="lead font-weight-normal">Our product is very cool.Yes, yes it is.
            Who is a good product?
            You are!
            Yes you are!</p>
        <a class="btn btn-outline-secondary" href="<c:url value="../checkout/${productId}"/>">Checkout</a>
    </div>
    <div class="product-device shadow-sm d-none d-md-block"></div>
    <div class="product-device product-device-2 shadow-sm d-none d-md-block"></div>
</div>

<div class="d-md-flex flex-md-equal w-100 my-md-3 pl-md-3">
    <%@include file="pricing_product.jspf" %>
</div>
<div class="card-deck mb-3 text-center">
    <%@include file="pricing_options.jspf" %>
</div>

<%@ include file="../common/footer.jspf" %>
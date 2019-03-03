<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<style>
    .content {
        position: fixed;
        top: 50%;
        left: 50%;
        /* bring your own prefixes */
        transform: translate(-50%, -50%);
    }
</style>
<body class="text-center">
    <div class="content">
        <h1 class="hello-world-text">Hello, world!</h1>
        <h1>It is a pleasure to meet you!</h1>
    </div>
</body>

<%@ include file="common/footer.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navbar.jspf" %>
<div class="container mt-5">
    <h1 class="hello-world-text">${companyName}'s products</h1>

    <div class="row">
        <%@include file="management_form.jspf" %>
    </div>

    <div class="row">
        <%@include file="products_table.jspf" %>
    </div>
</div>
<script>
    function edit() {
        var tableCellsAreNotEditable = $("#product-list-table tbody tr")[0].getAttribute("contenteditable") == "false"
        if (tableCellsAreNotEditable) {
            $("#product-list-table tbody tr").attr("contenteditable", "true")
            $("#product-list-table tbody tr td input").attr("readonly", false)
        } else {

            $("#form-management")
                .submit();
        }

    }
</script>
<%@ include file="../common/footer.jspf" %>
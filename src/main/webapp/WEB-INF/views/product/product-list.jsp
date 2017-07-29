<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>iShop | Каталог товаров</title>
</head>
<body>
    <h1>Каталог товаров iShop</h1>
    <ul>
        <%--<%--%>
            <%--List<Product> products = (List<Product>) request.getAttribute("products");--%>
            <%--for (Product product : products) {--%>
        <%--%>--%>
            <%--<li><%= product.printInfo() %></li>--%>
        <%--<%--%>
            <%--};--%>
        <%--%>--%>
        <c:forEach items="${products}" var="product">
            <jsp:useBean id="product" type="edu.bionic.domain.Product"/>
            <%--<li><c:out value="${product.printInfo()}"/></li>--%>
            <li><a href="<c:url value="products/${product.id}"/>">${product.printInfo()}</a></li>
        </c:forEach>
    </ul>
    <a href="<c:url value="/"/> "><button>На главную</button></a>
</body>
</html>

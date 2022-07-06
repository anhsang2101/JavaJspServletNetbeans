<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="home">Shoes</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
            <ul class="navbar-nav m-auto">
                <c:if test = "${sessionScope.acc.isAdmin == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="">Manager Account</a>
                    </li>
                </c:if>
                <c:if test = "${sessionScope.acc.isSell == 1}">
                    <li class="nav-item">
                        <a class="nav-link" href="manager">Manager Product</a>
                    </li>
                </c:if>


            </ul>
            <c:if test = "${sessionScope.acc != null}">
                <span type="button" class="btn btn-primary">Hello ${sessionScope.acc.user}</span>
            </c:if>
            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <div class="input-group input-group-sm">
                    <input value="${tfSearch}" name="tfSearch" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-secondary btn-number">
                            <i class="fa fa-search"></i>
                        </button>
                    </div>
                </div>
                <c:if test = "${sessionScope.acc.isSell == 0 && sessionScope.acc.isAdmin == 0}">
                    <a class="btn btn-success btn-sm ml-3" href="Cart.jsp">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light">3</span>
                    </a>
                </c:if>
            </form>
            <c:if test = "${sessionScope.acc == null}">
                <a href="Login.jsp" style="margin-left: 10px" type="button" class="btn btn-success btn-sm">Log in</a>

            </c:if>

            <c:if test = "${sessionScope.acc != null}">
                <a href="logout" style="margin-left: 10px" type="button" class="btn btn-danger btn-sm">Log out</a>

            </c:if>    

        </div>
    </div>
</nav>
<section class="jumbotron text-center">
    <div class="container">
        <h1 class="jumbotron-heading">Siêu thị giày chất lượng cao</h1>
        <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm giày sản xuất tại Việt Nam</p>
    </div>
</section>
<!--end of menu-->

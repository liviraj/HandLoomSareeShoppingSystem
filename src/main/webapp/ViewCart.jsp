<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Homepage - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
         <style type="text/css">
         /* Custom CSS for positioning the alert */
        .add-cart-alert {
            position: fixed;
            top: 10%;
            left: 50%;
            transform: translate(-50%, -50%);
            z-index: 1000; /* Ensure the alert appears on top of other elements */
        }
        </style>
        <script src="js/jquery.min.js"></script>
       <script type="text/javascript">
       $(document).ready(function() {
    	    // Add click event listener to the submit button
    	    $(".placeOrderBtn").click(function(event) {
    	        event.preventDefault(); // Prevent the default form submission

    	        // Display a normal JavaScript alert
    	        alert('Congratulations! Order placed successfully. To purchase more, visit the product page.');
    	    });
    	});
</script>
    </head>
    <body>
        <!-- Navigation-->
         <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container px-5">
                    <a class="navbar-brand" href="home.jsp">LoomCraft Boutique</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link px-4 me-sm-3" href="HandLoomController?action=product&loginId=${loginId}">Product</a></li>
                            <li class="nav-item"><a class="btn btn-outline-danger px-4" href="home.jsp">LogOut</a></li>
                        </ul>
                    </div>
                </div>
            </nav>
        <!-- Header-->
        <header class="bg-dark py-5" style="background-image: url('assets/home-page.webp'); background-size: contain; background-position: center;">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">.</h1>
                    <p class="lead fw-normal text-white-50 mb-0">   </p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <table border="3" class="table table-striped">
	<thead class="thead-dark">
		<tr class="warning">
		<th>Product Name</th>
		<th>Price</th>
		<th>Availability</th>
		<th>Rating</th>
		</tr>
		</thead>
			<c:forEach items="${details}" var="detail">
			<tr>
				<td><c:out value="${detail.productName}"></c:out></td>
				<td><c:out value="${detail.price}"></c:out></td>
				<td><c:out value="${detail.availability}"></c:out></td>
				<td><c:out value="${detail.rating}"></c:out></td>
				<td><a href="HandLoomController?action=order&loginId=<c:out value="${detail.loginId}"/>"><button class="placeOrderBtn btn btn-primary">Place Order</button></a>
			</tr>
			</c:forEach>
			</table>
        </section>
         <!-- Footer-->
         <footer class="bg-dark py-4 mt-auto">
            <div class="container px-5">
                <div class="row align-items-center justify-content-between flex-column flex-sm-row">
                    <div class="col-auto"><div class="small m-0 text-white">Copyright &copy; LoomCraft Boutique 2023</div></div>
                    <div class="col-auto">
                        <a class="link-light small" href="#!">Privacy</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="#!">Terms</a>
                        <span class="text-white mx-1">&middot;</span>
                        <a class="link-light small" href="contact.jsp">Contact</a>
                    </div>
                </div>
            </div>
        </footer>
       <!-- Bootstrap core JS-->
        <script src="js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>

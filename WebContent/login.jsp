<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<% 
	String err_msg = (String)request.getSession(false).getAttribute("errorMessage"); 
	if(err_msg == null)
	{
		err_msg ="";
	}
	request.getSession(false).setAttribute("errorMessage","");
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Login ShopCart</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- Customize styles -->
    <link href="style.css" rel="stylesheet"/>
    <!-- font awesome styles -->
	<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
		<!--[if IE 7]>
			<link href="css/font-awesome-ie7.min.css" rel="stylesheet">
		<![endif]-->

		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

	<!-- Favicons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
  </head>
<body>
<!-- 
	Upper Header Section 
-->
<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="topNav">
		<div class="container">
			<div class="alignR">
				<div class="pull-left socialNw">
					<a ><span class="icon-twitter"></span></a>
					<a ><span class="icon-facebook"></span></a>
					<a ><span class="icon-youtube"></span></a>
					<a ><span class="icon-tumblr"></span></a>
				</div>
				<a href="/OnlineBookStore/allBook"> <span class="icon-home"></span> Home</a> 
				<a class="active" ><span class="icon-user"></span> My Account</a> 
				<a ><span class="icon-edit"></span> Free Register </a> 
				<a ><span class="icon-envelope"></span> Contact us</a>
				<a href="viewcart.jsp"><span class="icon-shopping-cart"></span>Cart Item(s)</span></a>
			</div>
		</div>
	</div>
</div>

<!--
Lower Header Section 
-->
<div class="container">
<div id="gototop"> </div>
<header id="header">
<div class="row">
	<div class="span4">
	<h1>
	<a class="logo" href="index.jsp"><span>Twitter Bootstrap ecommerce template</span> 
		<img src="assets/img/logo-bootstrap-shoping-cart.png" alt="bootstrap sexy shop">
	</a>
	</h1>
	</div>
	<div class="span4">
	
	</div>
	<div class="span4 alignR">
	<p><br> <strong> Support (24/7) :  0613 2528 951 </strong><br><br></p>
	<span class="btn btn-mini"><span class="icon-shopping-cart"></span></span>
	<span class="btn btn-warning btn-mini">$</span>
	<span class="btn btn-mini">&pound;</span>
	<span class="btn btn-mini">&euro;</span>
	</div>
</div>
</header>


<!--
Navigation Bar Section 
-->
<div class="navbar">
	  <div class="navbar-inner">
		<div class="container">
		  <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		  </a>
		  <div class="nav-collapse">
			<ul class="nav">
			  <li class="active"><a href="/OnlineBookStore/allBook">Home	</a></li>
			</ul>
		  </div>
		</div>
	  </div>
	</div>
<!-- 
Body Section 
-->
	<div class="row">
<div id="sidebar" class="span3">
<div class="well well-small">
	<ul class="nav nav-list">
	 <li><a href="/OnlineBookStore/categoryviewservlet?Category=Biography"><span class="icon-chevron-right"></span>Biography</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Business"><span class="icon-chevron-right"></span>Business</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Finance"><span class="icon-chevron-right"></span>Finance</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Fashion"><span class="icon-chevron-right"></span>Fashion</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Computers"><span class="icon-chevron-right"></span>Computers</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=History"><span class="icon-chevron-right"></span>History</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Children"><span class="icon-chevron-right"></span>Children</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Fiction"><span class="icon-chevron-right"></span>Fiction </a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Home"><span class="icon-chevron-right"></span>Home</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Crafts and Hobbies"><span class="icon-chevron-right"></span>Crafts and Hobbies</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Romance"><span class="icon-chevron-right"></span>Romance</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Science and Nature"><span class="icon-chevron-right"></span>Science and Nature</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Poetry"><span class="icon-chevron-right"></span>Poetry</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Comics"><span class="icon-chevron-right"></span>Comics</a></li>
		<li><a href="/OnlineBookStore/categoryviewservlet?Category=Food and Wine"><span class="icon-chevron-right"></span>Food and Wine</a></li>
		<li style="border:0"> &nbsp;</li>	
	</ul>
</div>

			  <div class="well well-small alert alert-warning cntr">
				  <h2>50% Discount</h2>
				  <p> 
					 only valid for online order. <br><br><a class="defaultBtn" href="#">Click here </a>
				  </p>
			  </div>
			  <div class="well well-small" ><a><img src="assets/img/paypal.jpg" alt="payment method paypal"></a></div>
			
			<a class="shopBtn btn-block">Upcoming products <br><small>Click to view</small></a>
			<br>
			<br>
			<ul class="nav nav-list promowrapper">	
		  </ul>
	</div>
	
<!-- Login and Registration -->	
	
	<div class="span9">
	<div class="span9">
    <ul class="breadcrumb">
		<li><a href="/OnlineBookStore/allBook">Home</a> <span class="divider">/</span></li>
		<li class="active">Login</li>
    </ul>
	<h3> Login</h3>
	<p style="color:red" class="dynamic"><%=err_msg %>
	<hr class="soft"/>
	
	<div class="row">
		<div class="span4">
			<div class="well">
			<h5>CREATE YOUR ACCOUNT</h5><br/>
			Not registered yet? Please create an account now.<br/><br/><br/>
			<form>
			  <div class="controls">
			  <a class="shopBtn" href="/OnlineBookStore/register.jsp" class="shopBtn btn-large">Create Your Account</a>
			  </div>
			</form>
		</div>
		</div>
		<div class="span1"> &nbsp;</div>
		<div class="span4">
			<div class="well">
			<h5>ALREADY REGISTERED ?</h5>
			<form action= "LoginUserServlet" method="post">
			  <div class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
				  <input class="span3" name ="email" type="text" placeholder="Email" required>
				</div>
			  </div>
			  <div class="control-group">
				<label class="control-label" for="inputPassword">Password</label>
				<div class="controls">
				  <input type="password" name="password" class="span3" placeholder="Password" required>
				</div>
			  </div>
			  <div class="control-group">
				<div class="controls">
				  <button type="submit" class="defaultBtn">Sign in</button> <a hidden href="#">Forgot password?</a>
				</div>
			  </div>
			</form>
		</div>
		</div>
	</div>	
	
</div>
</div>
<!-- 
Clients 
-->
<section class="our_client">
	<hr class="soften"/>
	<h4 class="title cntr"><span class="text"> Publishers</span></h4>
	<hr class="soften"/>
	<div class="row">
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer1.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer2.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer3.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer4.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer5.png"></a>
		</div>
		<div class="span2">
			<a href="#"><img alt="" src="assets/img/footer6.png"></a>
		</div>
	</div>
</section>

<!--
Footer
-->
<footer class="footer">
<div class="row-fluid">
<div class="span2">
<h5>Your Account</h5>
<a >YOUR ACCOUNT</a><br>
<a >PERSONAL INFORMATION</a><br>
<a >ADDRESSES</a><br>
<a >DISCOUNT</a><br>
<a >ORDER HISTORY</a><br>
 </div>
<div class="span2">
<h5>Information</h5>
<a >CONTACT</a><br>
<a >SITEMAP</a><br>
<a >LEGAL NOTICE</a><br>
<a >TERMS AND CONDITIONS</a><br>
<a >ABOUT US</a><br>
 </div>
<div class="span2">
<h5>Our Offer</h5>
<a >NEW PRODUCTS</a> <br>
<a >TOP SELLERS</a><br>
<a >SPECIALS</a><br>
<a >MANUFACTURERS</a><br>
<a >SUPPLIERS</a> <br/>
 </div>
 <div class="span6">
<h5>A Message to all book lovers:</h5>
"There is no friend as loyal as a Book"<br>
Maybe this is why we read, and why in moments of darkness we return to books: to find words for what we already know
 </div>
 </div>
</footer>
</div><!-- /container -->

<div class="copyright">
<div class="container">
	<p class="pull-right">
		<a ><img src="assets/img/maestro.png" alt="payment"></a>
		<a ><img src="assets/img/mc.png" alt="payment"></a>
		<a ><img src="assets/img/pp.png" alt="payment"></a>
		<a ><img src="assets/img/visa.png" alt="payment"></a>
		<a ><img src="assets/img/disc.png" alt="payment"></a>
	</p>
	<span>Copyright &copy; 2018<br> Shop Cart Online Bookstore</span>
</div>
</div>
<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
    <script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
    <script src="assets/js/shop.js"></script>
  </body>
</html>

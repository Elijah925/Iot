<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Order List</title>
<style type="text/css">
	body {
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		text-align: center;
		float: left;
	}
</style>
	<link href="js/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
   <h1>Order List</h1>
  <div class="icon">
  <form  method="post" action="OrderServlet?method=findById">
  Search by ID: <input type="text" name="id" value="" placeholder="Order id" >
  <input type="submit" value="Submit" >
  </form>
  
  <table class="table table-striped">
      <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Address</th>
      <th>Contact Number</th>
      <th>Create Date</th>
      <th>Product Name</th>
      <th>Product price</th>
      <th>Product Amount</th>
      <th>Total Sum</th>
      <th>Operation</th>
      </tr>
       <tr>
      <td>${order.id}</td>
      <td>${order.name}</td>
      <td>${order.address}</td>
      <td>${order.contactNum}</td>
      <td>${order.createTime}</td>
      <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      <c:if test="${idx.index == 0}">
          ${product.name}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.name}
       </c:if>
      </c:forEach>
      </td>
            <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      <c:if test="${idx.index == 0}">
          ${product.price}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.price}
       </c:if>
      </c:forEach>
      </td>
      <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      	<c:if test="${idx.index == 0}">
          ${product.amount}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.amount}
       </c:if>
      </c:forEach>
      </td>
      <td>${order.totalSum }</td>
      </tr>
      
<c:forEach items="${orderList }" var="order">

      <tr>
      <td>${order.id}</td>
      <td>${order.name}</td>
      <td>${order.address}</td>
      <td>${order.contactNum}</td>
      <td>${order.createTime}</td>
      <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      <c:if test="${idx.index == 0}">
          ${product.name}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.name}
       </c:if>
      </c:forEach>
      </td>
            <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      <c:if test="${idx.index == 0}">
          ${product.price}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.price}
       </c:if>
      </c:forEach>
      </td>
      <td>
      <c:forEach items="${order.productList}" var="product" varStatus="idx">
      	<c:if test="${idx.index == 0}">
          ${product.amount}
      </c:if>
      <c:if test="${idx.index != 0}">
         /${product.amount}
       </c:if>
      </c:forEach>
      </td>
      <td>${order.totalSum }</td>
      <td>
      <c:if test="${order.state ==0 }">
      <a href="OrderServlet?method=delete&id=${order.id}">Delete</a><br>
      <a href="OrderServlet?method=submit&id=${order.id}">Submit</a><br>
      <a href="order_update.jsp?id=${order.id}">Update</a>
      </c:if>
      <c:if test="${order.state ==1 }">
      	Submitted, No Operation;
      </c:if>
      </td>
      </tr>
 </c:forEach>
</table>
  </div>
  
  </body>
 
</html>


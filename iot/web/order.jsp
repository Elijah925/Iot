<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>IOT-Order</title>
     <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
    	document.getElementById("productIds").value = getQueryVariable("productIds");
    	document.getElementById("productAmounts").value = getQueryVariable("productAmounts");
    	document.getElementById("productPrices").value = getQueryVariable("productPrices");
    	document.getElementById("productNames").value = getQueryVariable("productNames");
    });

      function resetForm(){
        $("form input[name]").val("");
      }
      function getQueryVariable(variable)
      {
             var query = window.location.search.substring(1);
             var vars = query.split("&");
             for (var i=0;i<vars.length;i++) {
                     var pair = vars[i].split("=");
                     if(pair[0] == variable){return pair[1];}
             }
             return(false);
      }
    </script>
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Create Order</h1>
        <form  method="post" action="OrderServlet">
            <p>Name: <input type="text" name="name" value="" placeholder="Your name" ></p>
            <p>Address: <input type="text" name="address" value="" placeholder="Your delivery address"></p>
            <p>Contact Number:<input type="text" name="contactNum" value="" placeholder="Your contact Number" ></p>
            <p><input id = "totalSum" type="hidden" name="totalSum" value="" ></p>
            <p><input id = "productIds" type="hidden" name="productIds" value="" ></p>
            <p><input id = "productAmounts" type="hidden" name="productAmounts" value="" ></p>
            <p><input id = "productNames" type="hidden" name="productNames" value="" ></p>
            <p><input id = "productPrices" type="hidden" name="productPrices" value="" ></p>
            <p><input  type="hidden" name="method" value="create" ></p>
            <p class="submit">
                <input type="submit" value="Submit" >
                <input type="button" value="Clear" onclick="resetForm()">
            </p>
        </form>
    </div>
</section>
</body>
</html>
package uts.isd.controller;

import uts.isd.model.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import uts.isd.model.Product;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderService();

    public String create(HttpServletRequest request, HttpServletResponse response) {
    	String productIds = request.getParameter("productIds");
    	String productNames = request.getParameter("productNames");
    	String productPrices = request.getParameter("productPrices");
    	String productAmounts = request.getParameter("productAmounts");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String num = request.getParameter("contactNum");
        String ids[] = productIds.split(",");
        String amounts[] = productAmounts.split(",");
        String prices[] = productPrices.split(",");
        String names[] = productNames.split(",");
        Order order = new Order();
        order.setName(name);
        order.setAddress(address);
        order.setContactNum(num);
        Double sum = 0.0;
        List<Product> productList = new ArrayList<Product>();
        for(int i=0;i<ids.length;i++) {
        	Product product = new Product();
        	product.setPrice(Double.valueOf(prices[i]));
        	product.setName(names[i]);
        	product.setId(Long.parseLong(ids[i]));
        	product.setAmount(Integer.parseInt(amounts[i]));
        	sum+= Integer.parseInt(amounts[i]) * Double.valueOf(prices[i]);
        	productList.add(product);
        }
        order.setProductList(productList);
        order.setTotalSum(sum);
        orderService.createOrder(order);
        return "f:/order_index.jsp";
    }
    
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("orderList", orderService.findAll());
		return "f:/order_list.jsp";
		
	}
	
	public String findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		request.setAttribute("order", orderService.findById(id));
		return "f:/order_list.jsp";
	}
	
	public String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		orderService.delete(id);
		return "f:/OrderServlet?method=findAll";
	}
	
	public String submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		orderService.submit(id);
		return "f:/OrderServlet?method=findAll";
		
	}
	
	public String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("productIds"));
		 String name = request.getParameter("name");
	     String address = request.getParameter("address");
	     String num = request.getParameter("contactNum");
		orderService.update(id,name,address,num);
		return "f:/OrderServlet?method=findAll";
		
	}
	
	public String test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello world");
		return null;
		
	}
}
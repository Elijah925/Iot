package uts.isd.controller;

import java.util.List;


import uts.isd.model.Order;
import uts.isd.model.dao.OrderDao;

public class OrderService {
	private OrderDao dao = new OrderDao();
	
	public void createOrder(Order order) {
		dao.createOrder(order);
	}
	
	public List<Order> findAll(){
		return dao.findAll();
	}

	public Order findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Long id) {
		 dao.delete(id);
	}
	
	public void submit(Long id) {
		 dao.submit(id);
	}
	
	public void update(Long id, String name, String address, String num) {
		 dao.update(id,name,address,num);
	}
	
}

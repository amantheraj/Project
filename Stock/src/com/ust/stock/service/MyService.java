package com.ust.stock.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ust.stock.model.OrderDTO;
import com.ust.stock.model.ProductDTO;
import com.ust.stock.model.UserDTO;

public interface MyService {

	
	 public boolean register(UserDTO dto);
	   
	   public UserDTO login(UserDTO dto);

	public boolean addData(ProductDTO dto);

	public List<ProductDTO> view();

	public ProductDTO edit(int id);

	public boolean updatedata(HttpServletRequest req);

	public List<ProductDTO> search(HttpServletRequest req);

	public List<ProductDTO> addtocart(int id);

	public List<OrderDTO> mycart();

//	public List<ProductDTO> generatebill(HttpServletRequest req);

//	public List<ProductDTO> order();

	
}

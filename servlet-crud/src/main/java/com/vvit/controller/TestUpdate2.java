package com.vvit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.vvit.dao.CustomerCrud;
import com.vvit.dto.Customer;
@WebServlet(value = "/update2")
public class TestUpdate2 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Customer c = new Customer();
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("email"));
		c.setAge(Integer.parseInt(req.getParameter("age")));
		c.setPhone(Long.parseLong(req.getParameter("phone")));
		
		CustomerCrud crud = new CustomerCrud();
		int a = crud.updateCustomerById(id, c);
		if(a>0) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("view");
			dispatcher.forward(req, res);
		}else {
			PrintWriter printWriter = res.getWriter();
			printWriter.print("No Customer To Update With Given ID");
		}
	}

}

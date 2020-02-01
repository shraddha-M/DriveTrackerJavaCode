package com.drivetracker.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drivetracker.dao.DaoLayer;
import com.drivetracker.pojo.Employee;
import com.drivetracker.utility.UtilityJson;

@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in viwe...");
		try {
			ArrayList<Employee> list = DaoLayer.getDriveListFromDb();

			System.out.println(list);

			String jsonstr = (String) UtilityJson.getJSONFromObject(list);
			System.out.println(jsonstr);
			response.getWriter().write(jsonstr);
			response.flushBuffer();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}

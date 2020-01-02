package com.Drive.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Drive.login.DAO.DaoLayer;
import com.Drive.pojo.Employee;
import com.Drive.utility.UtilityJson;

/**
 * Servlet implementation class EditEmployee
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("update");
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Employee lib = (Employee) UtilityJson.getObjectFromJSON(jsonobject, Employee.class);
		System.out.println(lib);

		Map<String, String> mp = DaoLayer.update(lib);

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();

	}

}

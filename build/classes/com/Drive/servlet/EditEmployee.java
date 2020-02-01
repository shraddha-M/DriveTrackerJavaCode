package com.drivetracker.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.drivetracker.dao.DaoLayer;
import com.drivetracker.pojo.Employee;
import com.drivetracker.utility.UtilityJson;

@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsonobject = request.getReader().readLine();

		Employee emp = (Employee) UtilityJson.getObjectFromJSON(jsonobject, Employee.class);

		Map<String, String> mp = DaoLayer.updateEmployees(emp);

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);

		response.flushBuffer();

	}

}

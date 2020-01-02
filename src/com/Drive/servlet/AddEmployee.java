package com.Drive.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

import com.Drive.login.DAO.DaoLayer;
import com.Drive.pojo.Employee;
import com.Drive.utility.UtilityJson;

/**
 * Servlet implementation class AddEmployee
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Employee lib = (Employee) UtilityJson.getObjectFromJSON(jsonobject, Employee.class);
		System.out.println(lib);

		Map<String, String> mp=null;
		try {
			mp = DaoLayer.createlibrarian(lib);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			System.out.println(mp);
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();
	}

}

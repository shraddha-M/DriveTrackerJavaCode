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
import com.Drive.pojo.Drives;
import com.Drive.utility.UtilityJson;

/**
 * Servlet implementation class AddDrive
 */
@WebServlet("/AddDrive")
public class AddDrive extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
	String jsonobject = request.getReader().readLine();
	System.out.println(jsonobject);

	Drives BK = (Drives) UtilityJson.getObjectFromJSON(jsonobject, Drives.class);
	System.out.println(BK);

	try {
		Map<String, String> mp= DaoLayer.addDrive(BK);
		System.out.println(mp);
		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);
		System.out.println(jsonString);
		response.flushBuffer();
	} catch (ClassNotFoundException e) {
		 
		e.printStackTrace();
	} catch (SQLException e) {
		 
		e.printStackTrace();
	}
}

}

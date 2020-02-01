package com.drivetracker.servlet;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.drivetracker.dao.DaoLayer;
import com.drivetracker.pojo.Drives;
import com.drivetracker.utility.UtilityJson;

@WebServlet("/EditDrive")
public class EditDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsonobject = request.getReader().readLine();

		Drives dr = (Drives) UtilityJson.getObjectFromJSON(jsonobject, Drives.class);

		Map<String, String> mp = DaoLayer.updateDrive(dr);

		String jsonString = (String) UtilityJson.getJSONFromObject(mp);
		response.getWriter().write(jsonString);

		response.flushBuffer();

	}

}

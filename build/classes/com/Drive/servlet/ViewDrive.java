package com.drivetracker.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drivetracker.dao.DaoLayer;
import com.drivetracker.pojo.Drives;
import com.drivetracker.utility.UtilityJson;

@WebServlet("/ViewDrive")
public class ViewDrive extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Drives> list = DaoLayer.getDriveList();

		String jsonstr = (String) UtilityJson.getJSONFromObject(list);

		response.getWriter().write(jsonstr);
		
		response.flushBuffer();
	}

}

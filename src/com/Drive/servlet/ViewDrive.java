package com.Drive.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Drive.login.DAO.DaoLayer;
import com.Drive.pojo.Drives;
import com.Drive.utility.UtilityJson;

/**
 * Servlet implementation class ViewDrive
 */
@WebServlet("/ViewDrive")
public class ViewDrive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in viwe...");
		try {
			ArrayList<Drives> list=DaoLayer.getDriveList();
			
			System.out.println(list);
			
		    String jsonstr=(String) UtilityJson.getJSONFromObject(list);
		    System.out.println(jsonstr);
		    response.getWriter().write(jsonstr);
            response.flushBuffer();		    
		} catch (ClassNotFoundException e) {
			//System.out.println("11111");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();
		}
   }

		
	}



package com.drivetracker.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.drivetracker.pojo.Employee;
import com.drivetracker.utility.UtilityEmail;
import com.drivetracker.utility.UtilityJson;

@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String jsonobject = request.getReader().readLine();

		Employee em = (Employee) UtilityJson.getObjectFromJSON(jsonobject, Employee.class);

		String msg = "Hii Your email is=" + em.getEmail() + "and Your Password is=" + em.getPassword();

		boolean flag = UtilityEmail.sendMail(msg, em);

		if (flag) {
			System.out.println("Done");
		} else {
			System.out.println("Sorry");
		}

	}

}

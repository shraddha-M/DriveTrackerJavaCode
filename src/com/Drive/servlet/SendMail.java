package com.Drive.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.Drive.pojo.Employee;
import com.Drive.utility.UtilityEmail;
import com.Drive.utility.UtilityJson;


@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in post");
		
		String jsonobject = request.getReader().readLine();
		System.out.println(jsonobject);

		Employee em= (Employee) UtilityJson.getObjectFromJSON(jsonobject,Employee.class);
		System.out.println(em);
		
		String msg="Hii Your email is="+em.getEmail()+"and Your Password is="+em.getPassword();
		
        boolean flag=UtilityEmail.sendMail(msg,em);
        
        if(flag)
        {
        	System.out.println("Done");
        }
        else
        {
        	System.out.println("Sorry");
        }

	}

}

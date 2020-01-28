package com.Drive.utility;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.Drive.pojo.Employee;

public class UtilityEmail {

	public static String MAIL_SMTP_AUTH = "mail.smtp.auth";
	public static String MAIL_SMTP_STARTTLS_ENABLE = "mail.smtp.starttls.enable";
	public static String MAIL_SMTP_HOST = "mail.smtp.host";
	public static String MAIL_SMTP_PORT = "mail.smtp.port";
	public static String CONST_SMTP_HOST = "smtp.gmail.com";
	public static String CONST_SMTP_TLS_PORT = "587";
	
	public static boolean sendMail(String msg, Employee em) {


		final String email = "tqpriyanka@gmail.com";
        final String pwd = "moms@ngel";
		
		try {
	        Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
	        props.put("mail.smtp.port", "587");
	        props.put("mail.smtp.auth", "true");
	        props.put("mail.smtp.starttls.enable", "true"); //TLS

			// Get the Session object.
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(email, pwd);
				}
			});

			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(email));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(em.getEmail()));

//			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse("xyz@gmail.com"));

			// Set Subject: header field
			message.setSubject("Subject");

			// Now set the actual message
			message.setText(msg);

			// Send message
			Transport.send(message);

			System.out.println("Mail Sent");
			return true;

		}
		catch (MessagingException e)
		{
			System.out.println(e);
			return false;
		}
		
	}

}

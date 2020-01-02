package com.Drive.constants;

public class constantdb {

	public static final String STR_Emp_GETALL = "Select * from employee";
	public static final String STR_Emp_DELETE = "delete from employee where id=?";
	public static final String STR_Emp_INSERT= "insert into employee(name,email,password,mobno) values(?,?,?,?)";
	public static final String STR_Emp_UPDATE = "update employee set name=?,email=?,Password=?,mobno=? where id=?";
	public static final String STR_Drive = "insert into drivedetails(cname, driveDate, position, packageOffered, vacanciesAvailable, location, contactPersonDetails,email) values(?,?,?,?,?,?,?,?)";
	public static final String STR_drives_GETALL = "select * from drivedetails";
	public static final String STR_Drive_DELETE = "delete from drivedetails where id=?";
	public static final String STR_drive_UPDATE = "update drivedetails set cname=?, driveDate=?, position=?, packageOffered=?, vacanciesAvailable=?, location=?, contactPersonDetails=? where id=?";
	
}

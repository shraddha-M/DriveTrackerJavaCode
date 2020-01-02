package com.Drive.login.DAO;

import com.Drive.constants.DBCon;
import com.Drive.constants.constantdb;
import com.Drive.pojo.Drives;
import com.Drive.pojo.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoLayer {
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) 
		{
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> addDrive(Drives bk) throws ClassNotFoundException, SQLException {
		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_Drive);

		String cname = bk.getCname();
		String driveDate = bk.getDriveDate();
		String position = bk.getPosition();
		int packageOffered = bk.getPackageOffered();
		int vacanciesAvailable = bk.getVacanciesAvailable();
		String location = bk.getLocation();
		String contactPersonDetails = bk.getContactPersonDetails();
		String email=bk.getEmail();

		Object[] parameter = { cname, driveDate, position, packageOffered, vacanciesAvailable, location,
				contactPersonDetails, email };

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		return mp;

	}

	public static Map<String, String> chklogin(Employee drive) throws SQLException, ClassNotFoundException {

		Map<String, String> mapobject = new HashMap<String, String>();

		ResultSet status = null;

		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_GETALL);

		status = ps.executeQuery();

		while (status.next()) {
			if (status.getString(3).equals(drive.getEmail()) && status.getString(4).equals(drive.getPassword())) {
				mapobject.put("status", "user");
				break;
			} else if ("admin@gmail.com".equals(drive.getEmail()) && "admin123".equals(drive.getPassword())) {
				mapobject.put("status", "admin");
				break;
			} else {
				mapobject.put("status", "Error");
			}
		}
		return mapobject;

	}

	public static Map<String, String> createlibrarian(Employee lb) throws ClassNotFoundException, SQLException {
		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_INSERT);

		String name = lb.getName();
		String email = lb.getEmail();
		String password = lb.getPassword();
		long mobno = lb.getMobno();

		Object[] parameter = { name, email, password, mobno };

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		return mp;

	}

	public static ArrayList<Employee> getDriveListFromDb() throws Exception {

		ArrayList<Employee> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_Emp_GETALL);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		
		while (resultSet.next()) {
			Employee u = new Employee();
			u.setId(resultSet.getInt(1));
			u.setName(resultSet.getString(2));
			u.setEmail(resultSet.getString(3));
			u.setPassword(resultSet.getString(4));
			u.setMobno(resultSet.getLong(5));

			list.add(u);
		}
		return list;

	}

	public static Map<String, String> deletelibrarian(Employee lib) throws Exception {
		System.out.println("in  delete method ");

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_DELETE);

		ps.setObject(1, lib.getId());

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}

		return mp;

	}

	public static Map<String, String> update(Employee lib) {
		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_UPDATE);

			ps.setString(1, lib.getName());
			ps.setString(2, lib.getEmail());
			ps.setString(3, lib.getPassword());
			ps.setLong(4, lib.getMobno());
			ps.setInt(5, lib.getId());

			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;

	}

	public static ArrayList<Drives> getDriveList() throws ClassNotFoundException, SQLException {
		ArrayList<Drives> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_drives_GETALL);

		ResultSet rs = null;

		rs= ps1.executeQuery();
		while (rs.next()) 
		{
			Drives u = new Drives();
			u.setDriveId(rs.getInt(1));
			u.setCname(rs.getString(2));
			u.setDriveDate(rs.getString(3));
			u.setPosition(rs.getString(4));
			u.setPackageOffered(rs.getInt(5));
			u.setVacanciesAvailable(rs.getInt(6));
			u.setLocation(rs.getString(7));
			u.setContactPersonDetails(rs.getString(8));
			u.setEmail(rs.getString(9));
			
			list.add(u);
		}
		return list;
	}

	public static Map<String, String> deletedrive(Drives lib) throws ClassNotFoundException, SQLException {
		System.out.println("in  delete method ");

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement("delete from drivedetails where id=?");

		ps.setObject(1,lib.getDriveId());

		status = ps.executeUpdate();

		if (status == 1)
		{
			mp.put("Msg", "Delete successfully");
		} 
		else
		{
			mp.put("Msg", "Error");
		}

		return mp;

	}

	public static Map<String, String> updatedrive(Drives lib) {
		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_drive_UPDATE);

			ps.setString(1, lib.getCname());
			ps.setString(2, lib.getDriveDate());
			ps.setString(3, lib.getPosition());
			ps.setInt(4, lib.getPackageOffered());
			ps.setInt(5, lib.getVacanciesAvailable());
			ps.setString(6, lib.getLocation());
			ps.setString(7, lib.getContactPersonDetails());
			ps.setInt(8, lib.getDriveId());
			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;
	}

}
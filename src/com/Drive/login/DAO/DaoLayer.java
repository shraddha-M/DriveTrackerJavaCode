package com.drivetracker.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import com.drivetracker.constants.DBCon;
import com.drivetracker.constants.constantdb;
import com.drivetracker.pojo.Drives;
import com.drivetracker.pojo.Employee;

public class DaoLayer {
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> addDrive(Drives dr) {
		Map<String, String> mp = new HashMap<>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_Drive);) {

			int status = 0;
			String cname = dr.getCname();
			String driveDate = dr.getDriveDate();
			String position = dr.getPosition();
			int packageOffered = dr.getPackageOffered();
			int vacanciesAvailable = dr.getVacanciesAvailable();
			String location = dr.getLocation();
			String contactPersonDetails = dr.getContactPersonDetails();
			String email = dr.getEmail();

			Object[] parameter = { cname, driveDate, position, packageOffered, vacanciesAvailable, location,
					contactPersonDetails, email };

			setValues(ps, parameter);

			status = ps.executeUpdate();

			if (status == 1) {

				mp.put("Msg", "successfully");

			} else {
				mp.put("Msg", "Error");
			}

		} catch (Exception e) {
		}

		return mp;

	}

	public static Map<String, String> chklogin(Employee drive) {

		Map<String, String> mapobject = new HashMap<String, String>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_GETALL);
				ResultSet status = ps.executeQuery();) {
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

		} catch (Exception e) {
		}

		return mapobject;

	}

	public static Map<String, String> insertEmployees(Employee emp) {

		Map<String, String> mp = new HashMap<>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_INSERT);) {

			int status = 0;

			String name = emp.getName();
			String email = emp.getEmail();
			String password = emp.getPassword();
			long mobno = emp.getMobno();

			Object[] parameter = { name, email, password, mobno };

			setValues(ps, parameter);

			status = ps.executeUpdate();

			if (status == 1) {

				mp.put("Msg", "successfully");

			} else {
				mp.put("Msg", "Error");
			}

		} catch (Exception e) {

		}
		return mp;

	}

	public static ArrayList<Employee> getDriveListFromDb() {

		ArrayList<Employee> list = new ArrayList<>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps1 = con.prepareStatement(constantdb.STR_Emp_GETALL);
				ResultSet resultSet = ps1.executeQuery();) {

			while (resultSet.next()) {
				Employee u = new Employee();
				u.setId(resultSet.getInt(1));
				u.setName(resultSet.getString(2));
				u.setEmail(resultSet.getString(3));
				u.setPassword(resultSet.getString(4));
				u.setMobno(resultSet.getLong(5));

				list.add(u);
			}
		} catch (Exception e) {
		}
		return list;

	}

	public static Map<String, String> deleteEmployees(Employee emp) {

		Map<String, String> mp = new HashMap<>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_DELETE);) {
			int status = 0;

			ps.setObject(1, emp.getId());

			status = ps.executeUpdate();

			if (status == 1) {

				mp.put("Msg", " Delete successfully");

			} else {
				mp.put("Msg", "Error");
			}

		} catch (Exception e) {

		}

		return mp;

	}

	public static Map<String, String> updateEmployees(Employee emp) {
		Map<String, String> mapobject = new HashMap<String, String>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_Emp_UPDATE);) {
			int status = 0;

			ps.setString(1, emp.getName());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getPassword());
			ps.setLong(4, emp.getMobno());
			ps.setInt(5, emp.getId());

			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}

		} catch (Exception e) {
		}

		return mapobject;

	}

	public static ArrayList<Drives> getDriveList() {

		ArrayList<Drives> list = new ArrayList<>();
		try (Connection con = DBCon.getConnection();
				PreparedStatement ps1 = con.prepareStatement(constantdb.STR_drives_GETALL);
				ResultSet rs = ps1.executeQuery();) {
			while (rs.next()) {
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

		} catch (Exception e) {

		}

		return list;
	}

	public static Map<String, String> deletedrive(Drives lib) {

		Map<String, String> mp = new HashMap<>();
		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement("delete from drivedetails where id=?");) {
			int status = 0;
			ps.setObject(1, lib.getDriveId());

			status = ps.executeUpdate();

			if (status == 1) {
				mp.put("Msg", "Delete successfully");
			} else {
				mp.put("Msg", "Error");
			}

		} catch (Exception e) {

		}
		return mp;

	}

	public static Map<String, String> updateDrive(Drives dr) {
		Map<String, String> mapobject = new HashMap<String, String>();

		try (Connection con = DBCon.getConnection();
				PreparedStatement ps = con.prepareStatement(constantdb.STR_drive_UPDATE);) {
			int status = 0;

			ps.setString(1, dr.getCname());
			ps.setString(2, dr.getDriveDate());
			ps.setString(3, dr.getPosition());
			ps.setInt(4, dr.getPackageOffered());
			ps.setInt(5, dr.getVacanciesAvailable());
			ps.setString(6, dr.getLocation());
			ps.setString(7, dr.getContactPersonDetails());
			ps.setInt(8, dr.getDriveId());
			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}

		} catch (Exception e) {

		}

		return mapobject;
	}

}
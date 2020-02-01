package com.drivetracker.pojo;

public class Drives {
	private int driveId;
	private String cname;
	private String driveDate;
	private String position;
	private int packageOffered;
	private int vacanciesAvailable;
	private String location;
	private String contactPersonDetails;
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDriveId() {
		return driveId;
	}

	public void setDriveId(int driveId) {
		this.driveId = driveId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getDriveDate() {
		return driveDate;
	}

	public void setDriveDate(String driveDate) {
		this.driveDate = driveDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getPackageOffered() {
		return packageOffered;
	}

	public void setPackageOffered(int packageOffered) {
		this.packageOffered = packageOffered;
	}

	public int getVacanciesAvailable() {
		return vacanciesAvailable;
	}

	public void setVacanciesAvailable(int vacanciesAvailable) {
		this.vacanciesAvailable = vacanciesAvailable;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContactPersonDetails() {
		return contactPersonDetails;
	}

	public void setContactPersonDetails(String contactPersonDetails) {
		this.contactPersonDetails = contactPersonDetails;
	}

}

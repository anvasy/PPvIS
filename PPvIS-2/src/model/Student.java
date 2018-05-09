package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class Student {
	private String name;
	private String surname;
	private String fathername;
	private Calendar birthDate;
	private Calendar startUniDate;
	private Calendar endUniDate;
	
	public Student (String n, String s, String f, Calendar b, Calendar st, Calendar e) {
		name = n;
		surname = s;
		fathername = f;
		birthDate = b;
		startUniDate = st;
		endUniDate = e;
	}
	
	public Student () {
		birthDate = Calendar.getInstance();
		startUniDate = Calendar.getInstance();
		endUniDate = Calendar.getInstance();
	}
	
	public Vector returnVec() {
		Vector<String> vec = new Vector();
		vec.add(name + " " + surname + " " + fathername);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		vec.add(dateFormat.format(birthDate.getTime()));
		vec.add(dateFormat.format(startUniDate.getTime()));
		vec.add(dateFormat.format(endUniDate.getTime()));
		return vec;
	}
	
	public String dateBirthToString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		return dateFormat.format(birthDate.getTime());
	}
	
	public String dateEnrollToString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		return dateFormat.format(startUniDate.getTime());
	}
	
	public String dateGradToString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		return dateFormat.format(endUniDate.getTime());
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurName() {
		return surname;
	}
	
	public String getFatherName() {
		return fathername;
	}
	
	public Calendar getBirthDate() {
		return birthDate;
	}
	
	public int getBirthDay() {
		return birthDate.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getBirthMonth() {
		return birthDate.get(Calendar.MONTH);
	}
	
	public int getBirthYear() {
		return birthDate.get(Calendar.YEAR);
	}
	
	
	public int getStartUniYear() {
		return startUniDate.get(Calendar.YEAR);
	}
	
	public int getEndUniYear() {
		return endUniDate.get(Calendar.YEAR);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	
	public void setStartUniDate(int day, int month, int year) {
		birthDate.set(year, month - 1, day);
	}
	
	public void setEndUniDate(int day, int month, int year) {
		startUniDate.set(year, month - 1, day);
	}

	public void setBirthDate(int day, int month, int year) {
		endUniDate.set(year, month - 1, day);
	}
}

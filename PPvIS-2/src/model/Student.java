package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

public class Student {
	private String name, surname, fathername;
	private Calendar birthDate, startUniDate, endUniDate;
	
	public Student (String n, String s, String f, Calendar b, Calendar st, Calendar e) {
		name = n;
		surname = s;
		fathername = f;
		birthDate = b;
		startUniDate = st;
		endUniDate = e;
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
	
	public int getStartUniDay() {
		return startUniDate.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getStartUniMonth() {
		return startUniDate.get(Calendar.MONTH);
	}
	
	public int getStartUniYear() {
		return startUniDate.get(Calendar.YEAR);
	}
	
	public int getEndUniDay() {
		return endUniDate.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getEndUniMonth() {
		return endUniDate.get(Calendar.MONTH);
	}
	
	public int getEndUniYear() {
		return endUniDate.get(Calendar.YEAR);
	}
}

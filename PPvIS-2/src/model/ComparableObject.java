package model;

import java.util.Calendar;

public class ComparableObject {
	private String name;
	private String surname;
	private String fathername;
	private int dayBirth;
	private int monthBirth;
	private int yearBirthStart;
	private int yearBirthEnd;
	private int yearStartEnroll;
	private int yearEndEnroll;
	private int yearStartGrad;
	private int yearEndGrad;
	
	public ComparableObject(String name, String surname, String fathername, int day) {
		this.name = name;
		this.surname  = surname;
		this.fathername = fathername; 
		dayBirth = day;
		monthBirth = 0;
		yearBirthStart = 0;
		yearBirthEnd = 0;
		yearStartEnroll = 0;
		yearEndEnroll = 0;
		yearStartGrad = 0;
		yearEndGrad = 0;
	}
	
	public ComparableObject(int yearStart, int yearEnd, int day) {
		name = null;
		surname = null;
		fathername = null;
		yearBirthStart = yearStart;
		yearBirthEnd = yearEnd;
		dayBirth = day;
		monthBirth = 0;
		yearStartEnroll = 0;
		yearEndEnroll = 0;
		yearStartGrad = 0;
		yearEndGrad = 0;
	} 
	
	public ComparableObject(int day, int month) {
		name = null;
		surname = null;
		fathername = null;
		yearBirthStart = 0;
		yearBirthEnd = 0;
		yearStartEnroll = 0;
		yearEndEnroll = 0;
		yearStartGrad = 0;
		yearEndGrad = 0;
		monthBirth = month;
		dayBirth = day;
	} 
	
	public ComparableObject(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad) {
		name = null;
		surname = null;
		fathername = null;
		yearBirthStart = 0;
		yearBirthEnd = 0;
		dayBirth = 0;
		monthBirth = 0;
		this.yearStartEnroll = yearStartEnroll;
		this.yearEndEnroll = yearEndEnroll;
		this.yearStartGrad = yearStartGrad;
		this.yearEndGrad = yearEndGrad;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public int getDayBirth() {
		return dayBirth;
	}

	public int getMonthBirth() {
		return monthBirth;
	}


	public int getYearBirthStart() {
		return yearBirthStart;
	}


	public int getYearBirthEnd() {
		return yearBirthEnd;
	}


	public int getYearStartEnroll() {
		return yearStartEnroll;
	}

	public int getYearStartGrad() {
		return yearStartGrad;
	}


	public int getYearEndEnroll() {
		return yearEndEnroll;
	}


	public int getYearEndGrad() {
		return yearEndGrad;
	}


	
}

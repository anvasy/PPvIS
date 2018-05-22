package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Info {
	private ArrayList<Student> studentData;
	
	public Info () {
		studentData = new ArrayList();
    }
	
	public ArrayList<Student> getData() {
		return studentData;
	}
	
	public void setData(ArrayList<Student> students) {
		studentData = students;
	}

    public void addNewLine(Student std) {
    	studentData.add(std);
    }
    
}

package controller;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Info;
import model.Student;
import view.DataTable;
import view.ResultFrame;

public class Controller {
	private Info info;
	private DataTable mainTable;

    public Controller(Info inf) {
    	info = inf;
    }
	
	public void getNewStudent(Student stud) {
		info.addNewLine(stud);
		updatePage(mainTable, 1, 5);
	}
	
	public ArrayList<Student> getData(int counter, int numRows) {
		return info.getPartOfArrayForThatGodDamnedTable(info.getData(), counter, numRows);
	}
	
	public ArrayList<Student> getData(ArrayList<Student> stud, int counter, int numRows) {
		return info.getPartOfArrayForThatGodDamnedTable(stud, counter, numRows);
	}
 	
	public int getDataSize() {
		return info.getData().size();
	}
	
	/*public ArrayList updatePage(DataTable table, int counter, int numRows) {
		ArrayList<Student> newData = new ArrayList();
		newData = info.getPartOfArrayForThatGodDamnedTable(info.getData(), counter, numRows);
		for(int row = 0; row < newData.size(); row++) {
			Vector v = new Vector();
            v = newData.get(row).returnVec();
			for(int el = 0; el < table.getColumnCount(); el++) {
				table.setValueAt(v.get(el), row, el);
			}
			
		}
		
		return newData;
	}*/	
	public void updatePage(DataTable table, int counter, int numRows) {
		ArrayList<Student> newData = new ArrayList();
		newData = info.getPartOfArrayForThatGodDamnedTable(info.getData(), counter, numRows);
		for(int row = 0; row < newData.size(); row++) {
			Vector v = new Vector();
            v = newData.get(row).returnVec();
			for(int el = 0; el < table.getColumnCount(); el++) {
				table.setValueAt(v.get(el), row, el);
			}
			
		}
	}
	
	public void getData(String name, String surname, String fatherName, int birthDay, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "���� �������" + info.deleteStudents(name, surname, fatherName, birthDay) 
						+ "�������", "��������!", JOptionPane.INFORMATION_MESSAGE);
			mainTable.removeData();
			updatePage(mainTable, 1, 5);
		} else {
			if(info.searchStudents(name, surname, fatherName, birthDay).isEmpty()) {
				JOptionPane.showMessageDialog(null, "�� ������ ������� ������ �� �������.", 
						"��������!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(name, surname, fatherName, birthDay), this);
			}
		}
	}
	
	public void getData(int yearStart, int yearEnd, int dayBirth, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "���� ������� " + info.deleteStudents(yearStart, yearEnd, dayBirth) 
						+ " �������", "��������!", JOptionPane.INFORMATION_MESSAGE);
			mainTable.removeData();
			updatePage(mainTable, 1, 5);
		} else {
			if(info.searchStudents(yearStart, yearEnd, dayBirth).isEmpty()) {
				JOptionPane.showMessageDialog(null, "�� ������ ������� ������ �� �������.", 
						"��������!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(yearStart, yearEnd, dayBirth), this);
			}
		}
	}
	
	public void getData(int day, int month, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "���� ������� " + info.deleteStudents(day, month) 
						+ " �������", "��������!", JOptionPane.INFORMATION_MESSAGE);
			mainTable.removeData();
			updatePage(mainTable, 1, 5);
		} else {
			if(info.searchStudents(day, month).isEmpty()) {
				JOptionPane.showMessageDialog(null, "�� ������ ������� ������ �� �������.", 
						"��������!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.getPartOfArrayForThatGodDamnedTable(info.searchStudents(day, month), 5, 1), this);
			}
		}
	}
	
	public void getData(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "���� ������� " + info.deleteStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad) + 
						" �������", "��������!", JOptionPane.INFORMATION_MESSAGE);
			mainTable.removeData();
			updatePage(mainTable, 1, 5);
		} else {
			if(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad).isEmpty()) {
				JOptionPane.showMessageDialog(null, "�� ������ ������� ������ �� �������.", 
						"��������!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad), this);
			}
		}
	}
	
	public void getMainTable(DataTable table) {
    	mainTable = table;
    }
}

package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import model.Info;
import model.Student;
import view.ResultFrame;

public class Controller {
	private Info info;
	private JTable mainTable;

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
	
	public int getDataSize() {
		return info.getData().size();
	}
	
	public void updatePage(JTable table, int counter, int numRows) {
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
			JOptionPane.showMessageDialog(null, "Были удалены" + info.deleteStudents(name, surname, fatherName, birthDay) + "записей", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if(info.searchStudents(name, surname, fatherName, birthDay).isEmpty()) {
				JOptionPane.showMessageDialog(null, "По вашему запросу ничего не найдено.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(name, surname, fatherName, birthDay));
			}
		}
	}
	
	public void getData(int yearStart, int yearEnd, int dayBirth, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "Были удалены " + info.deleteStudents(yearStart, yearEnd, dayBirth) + " записей", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if(info.searchStudents(yearStart, yearEnd, dayBirth).isEmpty()) {
				JOptionPane.showMessageDialog(null, "По вашему запросу ничего не найдено.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(yearStart, yearEnd, dayBirth));
			}
		}
	}
	
	public void getData(int day, int month, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "Были удалены " + info.deleteStudents(day, month) + " записей", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if(info.searchStudents(day, month).isEmpty()) {
				JOptionPane.showMessageDialog(null, "По вашему запросу ничего не найдено.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.getPartOfArrayForThatGodDamnedTable(info.searchStudents(day, month), 5, 1));
			}
		}
	}
	
	public void getData(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad, boolean ifDelete) {
		if(ifDelete) {
			JOptionPane.showMessageDialog(null, "Были удалены " + info.deleteStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad) + " записей", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			if(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad).isEmpty()) {
				JOptionPane.showMessageDialog(null, "По вашему запросу ничего не найдено.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
			} else {
				new ResultFrame(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad));
			}
		}
	}
	
	public void getMainTable(JTable table) {
    	mainTable = table;
    }
}

package controller;

import java.awt.Dimension;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.Info;
import model.SAXReader;
import model.Student;
import model.WriterXML;
import view.DataTable;
import view.ResultFrame;
import view.TableComponent;

public class Controller {
	private Info info;
	private TableComponent tc;
	private WriterXML writerXML;
	private SAXReader saxReader;
	
    public Controller(Info inf) {
    	info = inf;
    }
	
	public void getNewStudent(Student stud) {
		info.addNewLine(stud);
		updatePage(tc.getTable(), 1, 5, info.getData());
	}
	
	public ArrayList<Student> getData(int counter, int numRows) {
		return info.getPartOfArrayForThatGodDamnedTable(info.getData(), counter, numRows);
	}
	
	public ArrayList<Student> getData(ArrayList<Student> stud, int counter, int numRows) {
		return info.getPartOfArrayForThatGodDamnedTable(stud, counter, numRows);
	}
	
	public ArrayList<Student> getData() {
		return info.getData();
	}
 	
	public int getDataSize(ArrayList<Student> data) {
		return data.size();
	}
	
	public void updatePage(DataTable table, int counter, int numRows, ArrayList<Student> stud) {
		ArrayList<Student> newData = new ArrayList();
		newData = info.getPartOfArrayForThatGodDamnedTable(stud, counter, numRows);
		for(int row = 0; row < newData.size(); row++) {
			Vector v = new Vector();
            v = newData.get(row).returnVec();
			for(int el = 0; el < table.getColumnCount(); el++) {
				table.setValueAt(v.get(el), row, el);
			}
			
		}
		tc.updateElementsNumber();
	}
	
	
	public boolean writeXML(File file) {
		if (writerXML == null)
            writerXML = new WriterXML(info.getData());
        writerXML.setFile(file);
        try {
            writerXML.write();
            return true;
        } catch (Exception e) {
            return false;
        }
	}
	
	
	public boolean readFile(File file) {
		 if (saxReader == null) 
			 saxReader = new SAXReader();
		 try {
	    	 
	         SAXParserFactory factory = SAXParserFactory.newInstance();
	         SAXParser parser = factory.newSAXParser();    
	         parser.parse(file, saxReader);
	         ArrayList<Student> studData = new ArrayList();
	         studData = saxReader.getStudents();
	         info.setData(studData);
	         tc.newData(studData);
	         tc.getTable().removeData();
	         updatePage(tc.getTable(), 1, 5, info.getData()); 
	         
	         return true;
		 } catch (Exception ex) { 
			 ex.printStackTrace();
	         return false;
		 }
	}
	
	public int getData(String name, String surname, String fatherName, int birthDay, boolean ifDelete) {
		if(ifDelete) {
			int counter = info.deleteStudents(name, surname, fatherName, birthDay);
			tc.getTable().removeData();
			updatePage(tc.getTable(), 1, 5, info.getData());
			return counter;
		} else {
			if(info.searchStudents(name, surname, fatherName, birthDay).isEmpty()) {
				return -1;
			} else {
				new ResultFrame(info.searchStudents(name, surname, fatherName, birthDay), this);
				return -2;
			}
		}
	}
	
	public int getData(int yearStart, int yearEnd, int dayBirth, boolean ifDelete) {
		if(ifDelete) {
			int counter = info.deleteStudents(yearStart, yearEnd, dayBirth);
			tc.getTable().removeData();
			updatePage(tc.getTable(), 1, 5, info.getData());
			return counter;
		} else {
			if(info.searchStudents(yearStart, yearEnd, dayBirth).isEmpty()) {
				return -1;
			} else {
				new ResultFrame(info.searchStudents(yearStart, yearEnd, dayBirth), this);
				return -2;
			}
		}
	}
	
	public int getData(int day, int month, boolean ifDelete) {
		if(ifDelete) {
			int counter = info.deleteStudents(day, month);
			tc.getTable().removeData();
			updatePage(tc.getTable(), 1, 5, info.getData());
			return counter;
		} else {
			if(info.searchStudents(day, month).size() == 0) {
				return -1;
			} else {
				new ResultFrame(info.searchStudents(day, month), this);
				return -2;
			}
		}
	}
	
	public int getData(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad, boolean ifDelete) {
		if(ifDelete) {
			int counter = info.deleteStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad);
			tc.getTable().removeData();
			updatePage(tc.getTable(), 1, 5, info.getData());
			return counter;
		} else {
			if(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad).isEmpty()) {
				return -1;
			} else {
				new ResultFrame(info.searchStudents(yearStartEnroll, yearEndEnroll, yearStartGrad, yearEndGrad), this);
				return -2;
			}
		}
	}
	
	public void getMainTable(TableComponent tc) {
    	this.tc = tc;
    }
}

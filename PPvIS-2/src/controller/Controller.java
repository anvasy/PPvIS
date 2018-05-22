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

import model.ComparableObject;
import model.Info;
import model.SAXReader;
import model.Student;
import model.WriterXML;
import view.DataTable;
import view.MainFrame;
import view.ResultFrame;
import view.TableComponent;

public class Controller {
	private Info info;
	private WriterXML writerXML;
	private SAXReader saxReader;
	
    public Controller(Info inf) {
    	info = inf;
    }
	
	public void getNewStudent(Student stud) {
		info.addNewLine(stud);
	}
	
	public ArrayList<Student> getData() {
		return info.getData();
	}
 	
	public int getDataSize(ArrayList<Student> data) {
		return data.size();
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
	         
	         return true;
		 } catch (Exception ex) { 
			 ex.printStackTrace();
	         return false;
		 }
	}
	

	public int useStrategy(ComparableObject obj, Strategy strategy) {
		return strategy.perform(obj, info.getData(), this);
	}
}

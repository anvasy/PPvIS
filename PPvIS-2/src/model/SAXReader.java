package model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXReader extends DefaultHandler {
    private ArrayList<Student> students;
    private Student student;
    private ElementType thisEl;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	
    	if (qName.equals("studentData")) {
            students = new ArrayList();
            thisEl = ElementType.studentData;
            return;
        }
    	
        if (qName.equals("student")) {
        	student = new Student();
            thisEl = ElementType.student;
            return;
        }
        
        if (qName.equals("FIO")) {
            thisEl = ElementType.FIO;
            return;
        }
        
        if (qName.equals("dateBirth")) {
            thisEl = ElementType.birthday;
            return;
        }
        
        if (qName.equals("dateStartUniversity")) {
            thisEl = ElementType.enrollDate;
            return;
        }
        
        if (qName.equals("dateGraduation")) {
            thisEl = ElementType.graduateDate;
            return;
        }
    
        if (qName.equals("name")) {
            thisEl = ElementType.name;
            return;
        }
        
        if (qName.equals("surname")) {
            thisEl = ElementType.surname;
            return;
        }
        
        if (qName.equals("fatherName")) {
            thisEl = ElementType.fathername;
            return;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        
        if ("".equals(str)) 
        	return;
        
        if (thisEl == ElementType.name) {
            student.setName(str);
            return;
        }
        if (thisEl == ElementType.surname) {
            student.setSurname(str);
            return;
        }
        if (thisEl == ElementType.fathername) {
            student.setFathername(str);
            return;
        }
        
        if (thisEl == ElementType.birthday) {
        	String[] parts = str.split("-");
        	student.setBirthDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
        
        if (thisEl == ElementType.enrollDate) {
        	String[] parts = str.split("-");
        	student.setStartUniDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
        
        if (thisEl == ElementType.graduateDate) {
        	String[] parts = str.split("-");
        	student.setEndUniDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("student")) {
            students.add(student);
            student = null;
            return;
        }
    }
    
    public ArrayList<Student> getStudents() {
        ArrayList<Student> list = students;
        students = null;
        return list;
    }
}

enum ElementType {
	student,
	studentData,
	name,
	surname,
	fathername,
	FIO,
	birthday,
	enrollDate,
	graduateDate;
}
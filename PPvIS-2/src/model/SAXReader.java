package model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXReader extends DefaultHandler {
    private ArrayList<Student> students;
    private Student student;
    private ElementNames thisEl;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    	
    	if (qName.equals(ElementNames.studentData.toString())) {
            students = new ArrayList<Student>();
            thisEl = ElementNames.studentData;
            return;
        }
    	
        if (qName.equals(ElementNames.student.toString())) {
        	student = new Student();
            thisEl = ElementNames.student;
            return;
        }
        
        if (qName.equals(ElementNames.FIO.toString())) {
            thisEl = ElementNames.FIO;
            return;
        }
        
        if (qName.equals(ElementNames.birthday.toString())) {
            thisEl = ElementNames.birthday;
            return;
        }
        
        if (qName.equals(ElementNames.enrollDate.toString())) {
            thisEl = ElementNames.enrollDate;
            return;
        }
        
        if (qName.equals("dateGraduation")) {
            thisEl = ElementNames.graduateDate;
            return;
        }
    
        if (qName.equals( ElementNames.name.toString())) {
            thisEl = ElementNames.name;
            return;
        }
        
        if (qName.equals(ElementNames.surname.toString())) {
            thisEl = ElementNames.surname;
            return;
        }
        
        if (qName.equals(ElementNames.fathername.toString())) {
            thisEl = ElementNames.fathername;
            return;
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String str = new String(ch, start, length).trim();
        
        if ("".equals(str)) 
        	return;
        
        if (thisEl == ElementNames.name) {
            student.setName(str);
            return;
        }
        if (thisEl == ElementNames.surname) {
            student.setSurname(str);
            return;
        }
        if (thisEl == ElementNames.fathername) {
            student.setFathername(str);
            return;
        }
        
        if (thisEl == ElementNames.birthday) {
        	String[] parts = str.split("-");
        	student.setBirthDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
        
        if (thisEl == ElementNames.enrollDate) {
        	String[] parts = str.split("-");
        	student.setStartUniDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
        
        if (thisEl == ElementNames.graduateDate) {
        	String[] parts = str.split("-");
        	student.setEndUniDate(Integer.valueOf(parts[2]), Integer.valueOf(parts[1]), Integer.valueOf(parts[0]));
            return;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals(ElementNames.student.toString())) {	
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
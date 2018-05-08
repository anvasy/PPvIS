package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class WriterXML {
    private File file;
    private Document doc;
    private List<Student> students;

    public WriterXML(File file, List<Student> students) {
        this.file = file;
        this.students = students;
    }

    public WriterXML(List<Student> students) {
        this.students = students;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void write() throws TransformerException, ParserConfigurationException {
        if (file != null && students != null) {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element elementList = doc.createElement("studentData");
            for (Student stud : students) {
                Element elementStudent = doc.createElement("student");
                Element elementFIO = doc.createElement("FIO");

                Element elementName = doc.createElement("name");
                elementName.setTextContent(stud.getName());
                elementFIO.appendChild(elementName);

                Element elementSurname = doc.createElement("surname");
                elementSurname.setTextContent(stud.getSurName());
                elementFIO.appendChild(elementSurname);

                Element elementFatherName = doc.createElement("fatherName");
                elementFatherName.setTextContent(stud.getFatherName());
                elementFIO.appendChild(elementFatherName);

                elementStudent.appendChild(elementFIO);

                
                Element elementDateBirth = doc.createElement("dateBirth");
                
                Element elementdayBirth = doc.createElement("day");
                elementdayBirth.setTextContent(Integer.toString(stud.getBirthDay()));
                elementDateBirth.appendChild(elementdayBirth);
                
                Element elementMonthBirth = doc.createElement("month");
                elementMonthBirth.setTextContent(Integer.toString(stud.getBirthMonth()));
                elementDateBirth.appendChild(elementMonthBirth);
                
                Element elementBirthYear = doc.createElement("year");
                elementBirthYear.setTextContent(Integer.toString(stud.getBirthYear()));
                elementDateBirth.appendChild(elementBirthYear);
                
                
                Element elementDateEnroll = doc.createElement("dateEnrollIntoUniversity");
                
                Element elementdayEnroll = doc.createElement("day");
                elementdayEnroll.setTextContent(Integer.toString(stud.getStartUniDay()));
                elementDateEnroll.appendChild(elementdayEnroll);
                
                Element elementMonthEnroll = doc.createElement("month");
                elementMonthEnroll.setTextContent(Integer.toString(stud.getStartUniMonth()));
                elementDateEnroll.appendChild(elementMonthEnroll);
                
                Element elementYearEnroll = doc.createElement("year");
                elementYearEnroll.setTextContent(Integer.toString(stud.getStartUniYear()));
                elementDateEnroll.appendChild(elementYearEnroll);
                
                elementStudent.appendChild(elementDateEnroll);
                
                
                Element elementDateGrad = doc.createElement("dateGraduation");
                
                Element elementdayGrad = doc.createElement("day");
                elementdayGrad.setTextContent(Integer.toString(stud.getEndUniDay()));
                elementDateGrad.appendChild(elementdayEnroll);
                
                Element elementMonthGrad = doc.createElement("month");
                elementMonthGrad.setTextContent(Integer.toString(stud.getEndUniMonth()));
                elementDateGrad.appendChild(elementMonthEnroll);
                
                Element elementYearGrad = doc.createElement("year");
                elementYearGrad.setTextContent(Integer.toString(stud.getEndUniYear()));
                elementDateGrad.appendChild(elementYearGrad);
                
                elementStudent.appendChild(elementDateGrad);
                
                elementList.appendChild(elementStudent);
            }
            doc.appendChild(elementList);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);
        }
    }
}

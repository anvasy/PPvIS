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
                elementDateBirth.setTextContent(stud.dateBirthToString());
                elementStudent.appendChild(elementDateBirth);
                
                Element elementDateEnroll = doc.createElement("dateStartUniversity");
                elementDateEnroll.setTextContent(stud.dateEnrollToString());
                elementStudent.appendChild(elementDateEnroll);
                
                
                Element elementDateGrad = doc.createElement("dateGraduation");
                elementDateGrad.setTextContent(stud.dateGradToString());
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

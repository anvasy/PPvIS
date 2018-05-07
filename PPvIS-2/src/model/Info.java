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
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(118, 03, 04));
		Student e = new Student("1", "a", "a", calendar, calendar, calendar);
		studentData.add(e);
		studentData.add(e);
		studentData.add(e);
		studentData.add(e);
		studentData.add(e);
		studentData.add(e);
		studentData.add(e);
    }
	
	public ArrayList<Student> getData() {
		return studentData;
	}
	
	public ArrayList<Student> getPartOfArrayForThatGodDamnedTable(ArrayList<Student> stud, int counter, int numRows) {

		if(numRows >= stud.size())
			return stud;
		
		ArrayList<Student> result = new ArrayList<Student>();
		int endOfSubList = 0;
		if(numRows * (counter - 1) + numRows > stud.size())
			endOfSubList = stud.size();
		else
			endOfSubList = numRows * (counter - 1) + numRows;
		
		for(int el = numRows * (counter - 1); el < endOfSubList; el++)
		{
			result.add(stud.get(el));
		}
		return result;
	}

    public ArrayList searchStudents(String name, String surname, String fatherName, int birthDay) {
    	ArrayList resultList = new ArrayList();
    	for(int el = 0; el < studentData.size(); el++) {
    		if(name.equals(studentData.get(el).getName()) && surname.equals(studentData.get(el).getSurName())  && 
    				fatherName.equals(studentData.get(el).getFatherName()) && birthDay == studentData.get(el).getBirthDay()) {
    			resultList.add(studentData.get(el));
    		} else {
    			continue;
    		}
    	}
    	return resultList;
    }
    
    public ArrayList searchStudents(int yearStart, int yearEnd, int dayBirth) {
    	ArrayList resultList = new ArrayList();
    	for(int el = 0; el < studentData.size(); el++) {
    		if(dayBirth == studentData.get(el).getBirthDay()) {
    			if(studentData.get(el).getBirthYear() >= yearStart && studentData.get(el).getBirthYear() <= yearEnd)
    			resultList.add(studentData.get(el));
    		} else {
    			continue;
    		}
    	}
    	return resultList;
    }
    
    public ArrayList searchStudents(int day, int month) {
    	ArrayList resultList = new ArrayList();
    	for(int el = 0; el < studentData.size(); el++) {
    		if(day == studentData.get(el).getBirthDay() && month - 1 == studentData.get(el).getBirthMonth()) {
    			resultList.add(studentData.get(el));
    		} else {
    			continue;
    		}
    	}
    	return resultList;
    }
    
    public ArrayList searchStudents(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad) {
    	ArrayList resultList = new ArrayList();
    	for(int el = 0; el < studentData.size(); el++) {
    		if(yearStartEnroll >= studentData.get(el).getStartUniYear() && yearEndEnroll <= studentData.get(el).getEndUniYear()) {
    			if(studentData.get(el).getEndUniYear() >= yearStartGrad && studentData.get(el).getEndUniYear() <= yearEndGrad)
    			resultList.add(studentData.get(el));
    		} else {
    			continue;
    		}
    	}
    	return resultList;
    }
    
    public int deleteStudents(String name, String surname, String fatherName, int birthDay) {
    	int counter = 0;
    	for(int el = 0; el < studentData.size(); el++) {
    		if(name.equals(studentData.get(el).getName()) && surname.equals(studentData.get(el).getSurName())  && 
    				fatherName.equals(studentData.get(el).getFatherName()) && birthDay == studentData.get(el).getBirthDay()) {
    			studentData.remove(el);
    			counter++;
    		} else {
    			continue;
    		}
    	}
    	return counter;
    }
    
    public int deleteStudents(int yearStart, int yearEnd, int dayBirth) {
    	int counter = 0;
    	for(int el = 0; el < studentData.size(); el++) {
    		if(dayBirth == studentData.get(el).getBirthDay()) {
    			if(studentData.get(el).getBirthYear() >= yearStart && studentData.get(el).getBirthYear() <= yearEnd)
    				studentData.remove(el);
    				counter++;    		
    			} else {
    			continue;
    		}
    	}
    	return counter;
    }
    
    public int deleteStudents(int day, int month) {
    	int counter = 0;
    	for(int el = 0; el < studentData.size(); el++) {
    		if(day == studentData.get(el).getBirthDay() && month - 1 == studentData.get(el).getBirthMonth()) {
    			studentData.remove(el);
				counter++; 
    		} else {
    			continue;
    		}
    	}
    	return counter;
    }
    
    public int deleteStudents(int yearStartEnroll, int yearEndEnroll, int yearStartGrad, int yearEndGrad) {
    	int counter = 0;
    	for(int el = 0; el < studentData.size(); el++) {
    		if(yearStartEnroll >= studentData.get(el).getStartUniYear() && yearEndEnroll <= studentData.get(el).getStartUniYear()) {
    			if(studentData.get(el).getEndUniYear() >= yearStartGrad && studentData.get(el).getEndUniYear() <= yearEndGrad)
    				studentData.remove(el);
					counter++; 
    		} else {
    			continue;
    		}
    	}
    	return counter;
    }
	
    public void addNewLine(Student std) {
    	studentData.add(std);
    }
    
}

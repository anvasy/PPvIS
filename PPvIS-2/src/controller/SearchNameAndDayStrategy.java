package controller;

import java.util.ArrayList;

import model.ComparableObject;
import model.Student;
import view.ResultFrame;

public class SearchNameAndDayStrategy implements SearchStrategy {

	@Override
	public int perform(ComparableObject obj,  ArrayList<Student> stud, Controller ctr) {
		// TODO Auto-generated method stub
		ArrayList<Student> result = new ArrayList<Student>();
		result = getArray(obj, stud);
		if(result.isEmpty())
			return -1;
		new ResultFrame(result, ctr);
		return -2;
	}

	@Override
	public ArrayList<Student> getArray(ComparableObject obj, ArrayList<Student> stud) {
		ArrayList<Student> data = new ArrayList<Student>();
		
		for (int el = 0; el < stud.size(); el++) {
			if(obj.getName().equals(stud.get(el).getName()) && obj.getSurname().equals(stud.get(el).getSurName()) &&
					obj.getFathername().equals(stud.get(el).getFatherName()) && obj.getDayBirth() == stud.get(el).getBirthDay())
				data.add(stud.get(el));
		}
		
		return data;
	}
}

package controller;

import java.util.ArrayList;

import model.ComparableObject;
import model.Student;
import view.ResultFrame;

public class SearchYearsStrategy implements SearchStrategy {

	@Override
	public int perform(ComparableObject obj, ArrayList<Student> stud, Controller ctr) {
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
		// TODO Auto-generated method stub
		ArrayList<Student> data = new ArrayList<Student>();
		
		for (int el = 0; el < stud.size(); el++) {
			if(stud.get(el).getStartUniYear() >= obj.getYearStartEnroll() && stud.get(el).getStartUniYear() <= obj.getYearEndEnroll()
					&& stud.get(el).getEndUniYear() >= obj.getYearStartGrad() && stud.get(el).getEndUniYear() <= obj.getYearEndGrad())
				data.add(stud.get(el));
		}
		
		return data;
	}

}

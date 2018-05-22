package controller;

import java.util.ArrayList;

import model.ComparableObject;
import model.Student;

public class DeleteStrategy implements Strategy {
	
	public int perform(ComparableObject obj, ArrayList<Student> stud, Controller ctr) {
		ArrayList<Student> result = new ArrayList<Student>();
		StrategyChooser sc = new StrategyChooser();
		SearchStrategy str = sc.chooseStrategy(obj);
		result = str.getArray(obj, stud);
		
		for (int el = 0; el < stud.size(); el++) {
			for (int el2 = 0; el2 < result.size(); el2++) {
				if(stud.get(el) == result.get(el2)) {
					stud.remove(el);
					el--;
					break;
				}		
			}
		}
		
		return result.size();
	}
}

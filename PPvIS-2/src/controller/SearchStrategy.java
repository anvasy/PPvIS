package controller;

import java.util.ArrayList;
import model.ComparableObject;
import model.Student;

public interface SearchStrategy extends Strategy{
	public int perform(ComparableObject obj, ArrayList<Student> stud, Controller ctr);
	public ArrayList<Student> getArray(ComparableObject obj, ArrayList<Student> stud);
}

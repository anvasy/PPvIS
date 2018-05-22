package controller;

import java.util.ArrayList;

import model.ComparableObject;
import model.Student;

public interface Strategy {
	public int perform(ComparableObject obj, ArrayList<Student> stud, Controller ctr);
}

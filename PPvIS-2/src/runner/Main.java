package runner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import controller.Controller;
import model.Info;
import model.Student;
import view.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info inf = new Info();
		//inf.setData(generateData());
		Controller ctr = new Controller(inf);
		new MainFrame(ctr);
	}
	
	private static ArrayList<Student> generateData() {
		ArrayList<Student> data = new ArrayList();
		
		for (int el = 0; el < 50; el++) {
			data.add(new Student(genString(), genString(), genString(), genData(), genData(), genData()));
		}
		
		return data;
	}
	
	private static String genString() {
		Random random = new Random();
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < random.nextInt(10) + 4; i++) {
            name.append((char) ((97) + random.nextInt(26)));
        }
        return name.toString();
	}
	
	private static Calendar genData() {
		Calendar date = Calendar.getInstance();
		Random r = new Random();
		int day = r.nextInt((31 - 1) + 1) + 1;
		int month = r.nextInt((11 - 0) + 1) + 0;
		int year = r.nextInt((2018 - 1980) + 1) + 1980;
		
		date.set(year, month, day);
		
		return date;
	}

}

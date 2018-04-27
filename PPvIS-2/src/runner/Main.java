package runner;

import controller.Controller;
import model.Info;
import view.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Info inf = new Info();
		Controller ctr = new Controller(inf);
		new MainFrame(ctr);
	}

}

package runner;

import java.awt.EventQueue;

import ui.MainFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	new MainFrame();
	            }
		  });
	} 

}

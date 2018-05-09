package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;

public class ResultFrame extends JFrame{

	private ArrayList studentData;
	private Controller ctr;
	
	public ResultFrame(ArrayList res, Controller c) {
		ctr = c;
		studentData = res;
		
        setTitle("Результаты поиска");
        setSize(550, 450);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
        
        setResizable(false);
        setVisible(true); 
        setLayout(new FlowLayout(FlowLayout.TRAILING)); 
        initComponents();
    }

	private void initComponents() {
		TableComponent tc = new TableComponent(ctr, studentData);
		
		add(tc);
	}
}

package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ResultFrame extends JFrame{

	private JButton okButton, nextButton, prevButton;
	private ArrayList studentData;
	
	public ResultFrame(ArrayList res) {
		studentData = res;
        setTitle("Результаты поиска");
        setSize(540, 240);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
        
        setResizable(false);
        setVisible(true); 
        setLayout(new FlowLayout(FlowLayout.TRAILING)); 
        initComponents();
        action();
    }

	private void initComponents() {
		DataTable dat = new DataTable(studentData);
		dat.setPreferredSize(new Dimension(520, 125));
		add(dat);
		nextButton = new JButton("Вперёд");
		nextButton.setPreferredSize(new Dimension(258, 30));
		prevButton = new JButton("Назад");
		prevButton.setPreferredSize(new Dimension(258, 30));
		okButton = new JButton("Ок");
		okButton.setPreferredSize(new Dimension(520, 30));
		add(prevButton);
		add(nextButton);
		add(okButton);
	}

	private void action() {
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
    		
    	});
		
		
	}
}

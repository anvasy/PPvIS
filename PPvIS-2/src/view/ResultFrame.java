package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import controller.Controller;

public class ResultFrame extends JFrame{

	private JButton okButton, nextButton, prevButton;
	private ArrayList studentData;
	private JLabel pagesCount;
	private DataTable dat;
	private Controller ctr;
	private int counter = 1;
	
	public ResultFrame(ArrayList res, Controller c) {
		ctr = c;
		studentData = res;
        setTitle("Результаты поиска");
        setSize(540, 260);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
        
        setResizable(false);
        setVisible(true); 
        setLayout(new FlowLayout(FlowLayout.TRAILING)); 
        initComponents();
        action();
    }

	private void initComponents() {
		pagesCount = new JLabel("Страница " + counter + " из " + (int) Math.ceil(studentData.size()/5.0));
		add(pagesCount);
		dat = new DataTable(ctr.getData(studentData, counter, 5));
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
		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(studentData.size() > 5 * counter)
				{
					counter++;
					pagesCount.setText("Страница " + counter + " из " + 
									(int) Math.ceil(studentData.size()/5.0));
					dat.removeData();
					ctr.updatePage(dat, counter, 5);
					dat.resize(new Dimension(520, 25 * 5));
					
				}
				
			}
		});
		
	
		prevButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(counter > 1)
				{
					counter--;
					pagesCount.setText("Страница " + counter + " из " + 
									(int) Math.ceil(ctr.getDataSize()/5.0));
					dat.removeData();
					ctr.updatePage(dat, counter, 5);	
					dat.resize(new Dimension(520, 25 * 5));
				}
				
			}
		});
	}
}

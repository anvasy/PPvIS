package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;
import controller.DeleteStrategy;
import controller.SearchNameAndDayStrategy;
import controller.SearchStrategy;
import controller.Strategy;
import controller.StrategyChooser;
import model.ComparableObject;

public class SearchFrame extends JFrame {
	private JTextField name;
	private JTextField surname;
	private JTextField fatherName;			
	private JTextField yearStart;
	private JTextField yearEnd;		
	private JTextField dayBirth;	
	private JTextField yearStartEnroll;	
	private JTextField yearEndEnroll;
	private JTextField yearStartGrade;
	private JTextField yearEndGrade;
	private JTextField dayBirth1;
	private JTextField monthBirth; 
	private JTextField dayBirth0;
	private MainFrame mf;
	private JButton search1;
	private JButton search2;
	private JButton search3;
	private JButton search4;
	private StrategyChooser sc;
	private Strategy str1;
	private Strategy str2;
	private Strategy str3;
	private Strategy str4;
	private Controller ctr;

	public SearchFrame(Controller c, MainFrame mf, Strategy str1, Strategy str2, Strategy str3, Strategy str4) {
		ctr = c;
		this.str1 = str1;
		this.str2 = str2;
		this.str3 = str3;
		this.str4 = str4;
		this.mf = mf;
		makeFrame();
    }
	
	private void makeFrame() {
		setTitle(" ");
		
        setSize(340, 700);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
        
        setResizable(false);
        setVisible(true); 
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  
        initComponents();
        action();
	}
	
	private void initComponents() {
		JPanel container = new JPanel();
    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    	
    	JPanel firstOptPanel = new JPanel();
    	firstOptPanel.setPreferredSize(new Dimension (350, 130));
    	firstOptPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
    	JPanel secondOptPanel = new JPanel();
    	secondOptPanel.setPreferredSize(new Dimension (350, 130));
    	secondOptPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
    	JPanel thirdOptPanel = new JPanel();
    	thirdOptPanel.setPreferredSize(new Dimension (350, 130));
    	thirdOptPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
    	JPanel fourthOptPanel = new JPanel();
    	fourthOptPanel.setPreferredSize(new Dimension (350, 130));
    	fourthOptPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
    	
    	container.add(firstOptPanel);
    	firstOptPanel.setBorder(BorderFactory.createTitledBorder("№1"));
    	container.add(secondOptPanel);
    	secondOptPanel.setBorder(BorderFactory.createTitledBorder("№2"));
    	container.add(thirdOptPanel);
    	thirdOptPanel.setBorder(BorderFactory.createTitledBorder("№3"));
    	container.add(fourthOptPanel);
    	fourthOptPanel.setBorder(BorderFactory.createTitledBorder("№4"));
    	
    	JLabel nameL = new JLabel("Имя: ");
		JLabel surnameL = new JLabel("Фамилия: ");
		JLabel fatherNameL = new JLabel("Отчество: ");
		JLabel birthDateL = new JLabel("День рождения: ");
		name = new JTextField(20);
		surname = new JTextField(20);
		fatherName = new JTextField(20);
		search1 = new JButton("Ок");
		search1.setPreferredSize(new Dimension(300, 30));
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		dayBirth0 = new JTextField(3);
		
		firstOptPanel.add(nameL);
		firstOptPanel.add(name);
		firstOptPanel.add(surnameL);
		firstOptPanel.add(surname);
		firstOptPanel.add(fatherNameL);
		firstOptPanel.add(fatherName);
		firstOptPanel.add(birthDateL);
		firstOptPanel.add(dayBirth0);
		firstOptPanel.add(search1);
		
		JLabel birthYearDateL = new JLabel("Год рождения: ");
		yearStart = new JTextField(5);
		JLabel lineL = new JLabel(" — ");
		yearEnd = new JTextField(5);
		search2 = new JButton("Ок");
		search2.setPreferredSize(new Dimension(300, 30));
		JLabel birthDayDateL = new JLabel("День рождения: ");
		dayBirth = new JTextField(3);
		
		secondOptPanel.add(birthYearDateL);
		secondOptPanel.add(yearStart);
		secondOptPanel.add(lineL);
		secondOptPanel.add(yearEnd);
		secondOptPanel.add(birthDayDateL);
		secondOptPanel.add(dayBirth);
		secondOptPanel.add(search2);
		
		JLabel birthDayDate = new JLabel("День рождения: ");
		dayBirth1 = new JTextField(3);
		JLabel birthMonthDateL = new JLabel("Месяц рождения: ");
		monthBirth = new JTextField(3);
		search3 = new JButton("Ок");
		search3.setPreferredSize(new Dimension(300, 30));
		
		thirdOptPanel.add(birthDayDate);
		thirdOptPanel.add(dayBirth1);
		thirdOptPanel.add(birthMonthDateL);
		thirdOptPanel.add(monthBirth);
		thirdOptPanel.add(search3);

		JLabel startYearDateL = new JLabel("Год поступления: ");
		yearStartEnroll = new JTextField(5);
		JLabel lineL1 = new JLabel(" — ");
		yearEndEnroll = new JTextField(5);
		JLabel endYearDateL = new JLabel("Год окончания: ");
		yearStartGrade = new JTextField(5);
		JLabel lineL2 = new JLabel(" — ");
		yearEndGrade = new JTextField(5);
		search4 = new JButton("Ок");
		search4.setPreferredSize(new Dimension(300, 30));
		
		fourthOptPanel.add(startYearDateL);
		fourthOptPanel.add(yearStartEnroll);
		fourthOptPanel.add(lineL1);
		fourthOptPanel.add(yearEndEnroll);
		fourthOptPanel.add(endYearDateL);
		fourthOptPanel.add(yearStartGrade);
		fourthOptPanel.add(lineL2);
		fourthOptPanel.add(yearEndGrade);
		fourthOptPanel.add(search4);
		
    	add(container);
	}
	
	private void action() {
		sc = new StrategyChooser();
		
		search1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					if(name.getText().isEmpty() || surname.getText().isEmpty() || 
							fatherName.getText().isEmpty() || dayBirth0.getText().isEmpty())
						JOptionPane.showMessageDialog(null, "Заполните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
					else {
						ComparableObject obj = new ComparableObject(name.getText(), surname.getText(), 
								fatherName.getText(), Integer.valueOf(dayBirth0.getText()));
										
						int check = ctr.useStrategy(obj, str1);
						throwAlert(check);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Что-то не так.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
		
		search2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ComparableObject obj = new ComparableObject(Integer.valueOf(yearStart.getText()), 
							Integer.valueOf(yearEnd.getText()), Integer.valueOf(dayBirth.getText()));
					
					int check = ctr.useStrategy(obj, str2);
					throwAlert(check);
					
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Что-то не так.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
		
		search3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					
					ComparableObject obj = new ComparableObject(Integer.valueOf(dayBirth1.getText()), 
							Integer.valueOf(monthBirth.getText()));
					
					int check = ctr.useStrategy(obj, str3);
					throwAlert(check);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Что-то не так.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
		
		search4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ComparableObject obj = new ComparableObject(Integer.valueOf(yearStartEnroll.getText()), Integer.valueOf(yearEndEnroll.getText()), 
							Integer.valueOf(yearStartGrade.getText()), Integer.valueOf(yearEndGrade.getText()));
					
					int check = ctr.useStrategy(obj, str4);
					throwAlert(check);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Что-то не так.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
	}
	
	private void throwAlert(int check) {
		if(check >= 0) {
			JOptionPane.showMessageDialog(null, "Были удалены " + check 
			+ " записей", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
			mf.updateTable();
		}
		if(check == -1)
			JOptionPane.showMessageDialog(null, "По вашему запросу ничего не найдено.", 
					"Внимание!", JOptionPane.INFORMATION_MESSAGE);
	}
}

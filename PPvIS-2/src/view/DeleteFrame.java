package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;

import javax.swing.*;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;

public class DeleteFrame extends JFrame {
	private JTextField name, surname, fatherName, yearStart, yearEnd, dayBirth, yearStartEnroll, yearEndEnroll, yearStartGrade, yearEndGrade, dayBirth1, monthBirth, dayBirth0;
	private JButton del1, del2, del3, del4;
	private Controller ctr;
	
	public DeleteFrame(Controller c) {
		ctr = c;
        setTitle("Удалить");
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
    	del1 = new JButton("Удалить");
		del1.setPreferredSize(new Dimension(300, 30));
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
		firstOptPanel.add(del1);
		
		JLabel birthYearDateL = new JLabel("Год рождения: ");
		yearStart = new JTextField(5);
		JLabel lineL = new JLabel(" — ");
		yearEnd = new JTextField(5);
		del2 = new JButton("Удалить");
		del2.setPreferredSize(new Dimension(300, 30));
		JLabel birthDayDateL = new JLabel("День рождения: ");
		dayBirth = new JTextField(3);
		
		secondOptPanel.add(birthYearDateL);
		secondOptPanel.add(yearStart);
		secondOptPanel.add(lineL);
		secondOptPanel.add(yearEnd);
		secondOptPanel.add(birthDayDateL);
		secondOptPanel.add(dayBirth);
		secondOptPanel.add(del2);
		
		JLabel birthDayDate = new JLabel("День рождения: ");
		dayBirth1 = new JTextField(3);
		JLabel birthMonthDateL = new JLabel("Месяц рождения: ");
		monthBirth = new JTextField(3);
		del3 = new JButton("Удалить");
		del3.setPreferredSize(new Dimension(300, 30));
		
		thirdOptPanel.add(birthDayDate);
		thirdOptPanel.add(dayBirth1);
		thirdOptPanel.add(birthMonthDateL);
		thirdOptPanel.add(monthBirth);
		thirdOptPanel.add(del3);

		JLabel startYearDateL = new JLabel("Год поступления: ");
		yearStartEnroll = new JTextField(5);
		JLabel lineL1 = new JLabel(" — ");
		yearEndEnroll = new JTextField(5);
		JLabel endYearDateL = new JLabel("Год окончания: ");
		yearStartGrade = new JTextField(5);
		JLabel lineL2 = new JLabel(" — ");
		yearEndGrade = new JTextField(5);
		del4 = new JButton("Удалить");
		del4.setPreferredSize(new Dimension(300, 30));
		
		fourthOptPanel.add(startYearDateL);
		fourthOptPanel.add(yearStartEnroll);
		fourthOptPanel.add(lineL1);
		fourthOptPanel.add(yearEndEnroll);
		fourthOptPanel.add(endYearDateL);
		fourthOptPanel.add(yearStartGrade);
		fourthOptPanel.add(lineL2);
		fourthOptPanel.add(yearEndGrade);
		fourthOptPanel.add(del4);
		
    	add(container);

	}
	
	private void action() {
		del1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ctr.getData(name.getText(), surname.getText(), 
						fatherName.getText(), Integer.valueOf(dayBirth0.getText()), true);
			}
    		
    	});
		
		del2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ctr.getData(Integer.valueOf(yearStart.getText()), 
							Integer.valueOf(yearEnd.getText()), Integer.valueOf(dayBirth.getText()), true);
				} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Заоплните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
		
		del3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ctr.getData(Integer.valueOf(dayBirth1.getText()), 
							Integer.valueOf(monthBirth.getText()), true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Заоплните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
		
		del4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					ctr.getData(Integer.valueOf(yearStartEnroll.getText()), Integer.valueOf(yearEndEnroll.getText()), 
							Integer.valueOf(yearStartGrade.getText()), Integer.valueOf(yearEndGrade.getText()), true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Заоплните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
    		
    	});
	}
}

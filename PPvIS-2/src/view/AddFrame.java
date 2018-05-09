package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import java.util.Calendar;

import javax.swing.*;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import controller.Controller;
import model.Student;

public class AddFrame extends JFrame {
	 
	private UtilDateModel modelBirth;
	private UtilDateModel modelStart;
	private UtilDateModel modelEnd;
	private JDatePanelImpl datePanelBirth;
	private JDatePanelImpl datePanelStart;
	private JDatePanelImpl datePanelEnd;
	private JDatePickerImpl birthDate;
	private JDatePickerImpl startDate;
	private JDatePickerImpl endDate;
	private JTextField name;
	private JTextField surname;
	private JTextField fatherName;
	private JButton addButton;
	private Controller ctr;
	
	public AddFrame(Controller c) {
		ctr = c;
        setTitle("Добавить");
        setSize(333, 240);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);    
        
        setResizable(false);
        setVisible(true); 
        setLayout(new FlowLayout(FlowLayout.TRAILING)); 
        initComponents();
        action();
    }
	
	private void initComponents() {
		
		JLabel nameL = new JLabel("Имя: ");
		JLabel surnameL = new JLabel("Фамилия: ");
		JLabel fatherNameL = new JLabel("Отчество: ");
		JLabel birthDateL = new JLabel("Дата рождения: ");
		JLabel startDateL = new JLabel("Дата поступления: ");
		JLabel endDateL = new JLabel("Дата выпуска: ");
		
		name = new JTextField(20);
		surname = new JTextField(20);
		fatherName = new JTextField(20);
		
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		
		modelBirth = new UtilDateModel();
		datePanelBirth = new JDatePanelImpl(modelBirth, p);
		birthDate = new JDatePickerImpl(datePanelBirth, new DateComponentFormatter());
		
		modelStart = new UtilDateModel();
		datePanelStart = new JDatePanelImpl(modelStart, p);
		startDate = new JDatePickerImpl(datePanelStart, new DateComponentFormatter());
		
		modelEnd = new UtilDateModel();
		datePanelEnd = new JDatePanelImpl(modelEnd, p);
		endDate = new JDatePickerImpl(datePanelEnd, new DateComponentFormatter());
		
		addButton = new JButton("Добавить");
		addButton.setPreferredSize(new Dimension(318, 30));
		
		add(nameL);
		add(name);
		add(surnameL);
		add(surname);
		add(fatherNameL);
		add(fatherName);
		add(birthDateL);
		add(birthDate);
		add(startDateL);
		add(startDate);
		add(endDateL);
		add(endDate);
		add(addButton);
	}
	
	private void action() {
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(name.getText().isEmpty() || surname.getText().isEmpty() || fatherName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Заоплните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
				} else {
					try{
						Calendar cal = Calendar.getInstance();
						Date date = (Date) birthDate.getModel().getValue();
						cal.setTime(date);
						Calendar cal1 = Calendar.getInstance();
						Date date1 = (Date) startDate.getModel().getValue();
						cal1.setTime(date1);
						Calendar cal2 = Calendar.getInstance();
						Date date2 = (Date) endDate.getModel().getValue();
						cal2.setTime(date2);
						Student std = new Student(name.getText(), surname.getText(), fatherName.getText(), cal, 
								cal1, cal2);
						ctr.getNewStudent(std);
						JOptionPane.showMessageDialog(null, "Новая запись добавлена.", " ", JOptionPane.INFORMATION_MESSAGE);
					} catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Заоплните все поля.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
    	});
	}
}

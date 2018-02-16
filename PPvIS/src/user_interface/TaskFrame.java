package user_interface;

import java.awt.Dimension;

import javax.swing.*;

public class TaskFrame extends JFrame {

	 private JPanel firstOptPanel, secondOptPanel, thirdOptPanel, fourthOptPanel, fifthOptPanel;
	 private JButton p1Button, p2FirstButton, p2SecondButton, p3Button;
	 private JTextField p1TextField, p2TextField, p3TextField;
	 private JComboBox p1ComboBox;
	 private JRadioButton p3RadioButt1, p3RadioButt2, p3RadioButt3;

	    public TaskFrame() {
	        setTitle("TaskFrame");
	        setSize(400, 700);
	        setLocationRelativeTo(null); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE); 
	        initComponents();
	        action();
	        setResizable(false);
	        setVisible(true); 
	        //doLayout();
	        //pack();
	    }

	    private void initComponents() {
	
	    	JPanel container = new JPanel();
	    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

	    	firstOptPanel = new JPanel();
	    	secondOptPanel = new JPanel();
	    	thirdOptPanel = new JPanel();
	    	JPanel panel4 = new JPanel();
	    	JPanel panel5 = new JPanel();
	    	
	    	doFirstPanel();
	    	doSecondPanel();
	    	doThirdPanel();

	    	container.add(firstOptPanel);
	    	firstOptPanel.setBorder(BorderFactory.createTitledBorder("¹1"));
	    	container.add(secondOptPanel);
	    	secondOptPanel.setBorder(BorderFactory.createTitledBorder("¹2"));
	    	container.add(thirdOptPanel);
	    	thirdOptPanel.setBorder(BorderFactory.createTitledBorder("¹3"));
	    	container.add(panel4);
	    	panel4.setBorder(BorderFactory.createTitledBorder("¹4"));
	    	container.add(panel5);
	    	panel5.setBorder(BorderFactory.createTitledBorder("¹5"));
	    	
	    	add(container);
	    }
	    
	    private void doFirstPanel()
	    {
	    	p1Button = new JButton();
	    	p1Button.setPreferredSize(new Dimension(200, 30));
	    	p1ComboBox = new JComboBox();
	    	p1ComboBox.setPreferredSize(new Dimension(200, 30));
	    	p1TextField = new JTextField(20);
	    	p1TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	firstOptPanel.add(p1TextField);
	    	firstOptPanel.add(p1Button);
	    	firstOptPanel.add(p1ComboBox);
	    }
	    
	    private void doSecondPanel()
	    {
	    	p2FirstButton = new JButton();
	    	p2FirstButton.setPreferredSize(new Dimension(200, 30));
	    	p2SecondButton = new JButton();
	    	p2SecondButton.setPreferredSize(new Dimension(200, 30));
	    	p2TextField = new JTextField(20);
	    	p2TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	secondOptPanel.add(p2TextField);
	    	secondOptPanel.add(p2FirstButton);
	    	secondOptPanel.add(p2SecondButton);
	    }
	    
	    private void doThirdPanel()
	    {
	    	p3Button = new JButton();
	    	p3Button.setPreferredSize(new Dimension(200, 30));
	    	ButtonGroup p3RadioGroup = new ButtonGroup();
	    	p3RadioGroup.add(p3RadioButt1);
	    	p3RadioGroup.add(p3RadioButt2);
	    	p3RadioGroup.add(p3RadioButt3);
	    	p3TextField = new JTextField(20);
	    	p3TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	thirdOptPanel.add(p3TextField);
	    	thirdOptPanel.add(p3Button);
	    	thirdOptPanel.add(p1ComboBox);
	    }

	    private void action() {
	    	
	    }
}

package user_interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class TaskFrame extends JFrame {

	 private JPanel firstOptPanel, secondOptPanel, thirdOptPanel, fourthOptPanel, fifthOptPanel;
	 private JButton p1Button, p2FirstButton, p2SecondButton, p3Button, p4Button, p5FirstButton, p5SecondButton, p5ThirdButton;
	 private JTextField p1TextField, p2TextField, p3TextField, p4TextField, p5TextField;
	 private JComboBox p1ComboBox;
	 private JRadioButton p3RadioButt1, p3RadioButt2, p3RadioButt3;
	 private JCheckBox p4Check1, p4Check2, p4Check3;
	 private JTable p5Table;

	    public TaskFrame() {
	        setTitle("TaskFrame");
	        setSize(400, 700);
	        setLocationRelativeTo(null); 
	        setDefaultCloseOperation(EXIT_ON_CLOSE); 
	        initComponents();
	        
	        firstPanelAction();
	        secondPanelAction();
	        thirdPanelAction();
	        fourthPanelAction();
	        fifthPanelAction();
	        
	        setResizable(false);
	        setVisible(true); 
	        //doLayout();
	        getContentPane().setLayout(new FlowLayout());
	        //pack();
	    }

	    private void initComponents() {
	
	    	JPanel container = new JPanel();
	    	container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

	    	firstOptPanel = new JPanel();
	    	firstOptPanel.setPreferredSize(new Dimension (350, 130));
	    	secondOptPanel = new JPanel();
	    	secondOptPanel.setPreferredSize(new Dimension (350, 130));
	    	thirdOptPanel = new JPanel();
	    	thirdOptPanel.setPreferredSize(new Dimension (350, 130));
	    	fourthOptPanel = new JPanel();
	    	fourthOptPanel.setPreferredSize(new Dimension (350, 130));
	    	fifthOptPanel = new JPanel();
	    	fifthOptPanel.setPreferredSize(new Dimension (350, 130));
	    	
	    	doFirstPanel();
	    	doSecondPanel();
	    	doThirdPanel();
	    	doFourthPanel();
	    	doFifthPanel();

	    	container.add(firstOptPanel);
	    	firstOptPanel.setBorder(BorderFactory.createTitledBorder("¹1"));
	    	container.add(secondOptPanel);
	    	secondOptPanel.setBorder(BorderFactory.createTitledBorder("¹2"));
	    	container.add(thirdOptPanel);
	    	thirdOptPanel.setBorder(BorderFactory.createTitledBorder("¹3"));
	    	container.add(fourthOptPanel);
	    	fourthOptPanel.setBorder(BorderFactory.createTitledBorder("¹4"));
	    	container.add(fifthOptPanel);
	    	fifthOptPanel.setBorder(BorderFactory.createTitledBorder("¹5"));
	    	
	    	add(container);
	    }
	    
	    private void doFirstPanel() {
	    	p1Button = new JButton();
	    	p1Button.setPreferredSize(new Dimension(200, 30));
	    	p1ComboBox = new JComboBox();
	    	p1ComboBox.setPreferredSize(new Dimension(200, 30));
	    	p1ComboBox.setEditable(true);
	    	p1TextField = new JTextField(20);
	    	p1TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	firstOptPanel.add(p1TextField);
	    	firstOptPanel.add(p1Button);
	    	firstOptPanel.add(p1ComboBox);
	    }
	    
	    private void doSecondPanel() {
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
	    
	    private void doThirdPanel() {
	    	p3Button = new JButton();
	    	p3Button.setPreferredSize(new Dimension(300, 30));
	    	p3RadioButt1 = new JRadioButton();
	    	p3RadioButt1.setText("first");
	    	p3RadioButt2 = new JRadioButton();
	    	p3RadioButt2.setText("second");
	    	p3RadioButt3 = new JRadioButton();
	    	p3RadioButt3.setText("third");
	    	ButtonGroup p3RadioGroup = new ButtonGroup();
	    	p3RadioGroup.add(p3RadioButt1);
	    	p3RadioGroup.add(p3RadioButt2);
	    	p3RadioGroup.add(p3RadioButt3);
	    	p3TextField = new JTextField(20);
	    	p3TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	thirdOptPanel.add(p3TextField);
	    	thirdOptPanel.add(p3Button);
	    	thirdOptPanel.add(p3RadioButt1);
	    	thirdOptPanel.add(p3RadioButt2);
	    	thirdOptPanel.add(p3RadioButt3);
	    }
	    
	    private void doFourthPanel() {
	    	p4Button = new JButton();
	    	p4Button.setPreferredSize(new Dimension(300, 30));
	    	p4Check1 = new JCheckBox();
	    	p4Check1.setText("erste");
	    	p4Check2 = new JCheckBox();
	    	p4Check2.setText("zweite");
	    	p4Check3 = new JCheckBox();
	    	p4Check3.setText("dritte");
	    	p4TextField = new JTextField(20);
	    	p4TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	fourthOptPanel.add(p4TextField);
	    	fourthOptPanel.add(p4Button);
	    	fourthOptPanel.add(p4Check1);
	    	fourthOptPanel.add(p4Check2);
	    	fourthOptPanel.add(p4Check3);
	    }
	    
	    private void doFifthPanel() {
	    	p5FirstButton = new JButton();
	    	p5FirstButton.setPreferredSize(new Dimension(100, 30));
	    	p5SecondButton = new JButton();
	    	p5SecondButton.setPreferredSize(new Dimension(100, 30));
	    	p5ThirdButton = new JButton();
	    	p5ThirdButton.setPreferredSize(new Dimension(100, 30));
	    	p5TextField = new JTextField(28);
	    	p5TextField.setPreferredSize(new Dimension(200, 30));
	    	p5Table = new JTable(1,2);
	    	p5Table.setPreferredSize(new Dimension(200, 16));
	    	
	    	fifthOptPanel.add(p5TextField);
	    	fifthOptPanel.add(p5FirstButton);
	    	fifthOptPanel.add(p5SecondButton);
	    	fifthOptPanel.add(p5ThirdButton);
	    	fifthOptPanel.add(p5Table);
	    }

	    private void firstPanelAction() {
	    	
	    	
	    	p1Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					JOptionPane.showMessageDialog(firstOptPanel, "Element already exists.", "Attention!", JOptionPane.INFORMATION_MESSAGE);
				}
	    		
	    	});
	    }
	    
	    private void secondPanelAction() {
	    	p2FirstButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					p2SecondButton.setText(p2TextField.getText());
				}
	    		
	    	});
	    	p2SecondButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String p2FirstButtonText = p2FirstButton.getText();
					p2FirstButton.setText(p2SecondButton.getText());
					p2SecondButton.setText(p2FirstButtonText);
				}
	    		
	    	});
	    }
	    
	    private void thirdPanelAction() {
	    	p3Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String p3Text = p3TextField.getText();
				}
	    		
	    	});
	    }
	    
	    private void fourthPanelAction() {

	    }
	    
	    private void fifthPanelAction() {

	    }
}

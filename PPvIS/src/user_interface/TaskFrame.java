package user_interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class TaskFrame extends JFrame {

	 private JPanel firstOptPanel, secondOptPanel, thirdOptPanel, fourthOptPanel, fifthOptPanel;
	 private JButton p1Button, p2FirstButton, p2SecondButton, p3Button, p4Button, p5FirstButton, p5SecondButton, p5ThirdButton;
	 private JTextField p1TextField, p2TextField, p3TextField, p4TextField, p5TextField;
	 private JComboBox<String> p1ComboBox;
	 private JRadioButton p3RadioButt1, p3RadioButt2, p3RadioButt3;
	 private JCheckBox p4Check1, p4Check2, p4Check3;
	 private JTable p5Table;
	 private Vector<String> p1Combo;
	 
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
	        getContentPane().setLayout(new FlowLayout()); //что это??
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
	    	firstOptPanel.setBorder(BorderFactory.createTitledBorder("№1"));
	    	container.add(secondOptPanel);
	    	secondOptPanel.setBorder(BorderFactory.createTitledBorder("№2"));
	    	container.add(thirdOptPanel);
	    	thirdOptPanel.setBorder(BorderFactory.createTitledBorder("№3"));
	    	container.add(fourthOptPanel);
	    	fourthOptPanel.setBorder(BorderFactory.createTitledBorder("№4"));
	    	container.add(fifthOptPanel);
	    	fifthOptPanel.setBorder(BorderFactory.createTitledBorder("№5"));
	    	
	    	add(container);
	    }
	    
	    private void doFirstPanel() {
	    	p1Button = new JButton();
	    	p1Button.setPreferredSize(new Dimension(200, 30));
	    	p1Button.setText("Кнопка");
	    	p1Combo = new Vector<String>();
	    	p1ComboBox = new JComboBox<String>(p1Combo);
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
	    	p2FirstButton.setText("И это кнопка");
	    	p2FirstButton.setPreferredSize(new Dimension(200, 30));
	    	p2SecondButton = new JButton();
	    	p2SecondButton.setText("Тут тоже кнопка");
	    	p2SecondButton.setPreferredSize(new Dimension(200, 30));
	    	p2TextField = new JTextField(20);
	    	p2TextField.setPreferredSize(new Dimension(200, 30));
	    	
	    	secondOptPanel.add(p2TextField);
	    	secondOptPanel.add(p2FirstButton);
	    	secondOptPanel.add(p2SecondButton);
	    }
	    
	    private void doThirdPanel() {
	    	p3Button = new JButton();
	    	p3Button.setText("И здесь кнопка");
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
	    	p4Button.setText("Ещё одна кнопка");
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
	    	p5FirstButton.setText("Кн");
	    	p5FirstButton.setPreferredSize(new Dimension(100, 30));
	    	p5SecondButton = new JButton();
	    	p5SecondButton.setText("оп");
	    	p5SecondButton.setPreferredSize(new Dimension(100, 30));
	    	p5ThirdButton = new JButton();
	    	p5ThirdButton.setText("ка");
	    	p5ThirdButton.setPreferredSize(new Dimension(100, 30));
	    	p5TextField = new JTextField(28);
	    	p5TextField.setPreferredSize(new Dimension(200, 30));
	    	p5Table = new JTable(1, 2);
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
					
					String p1Text = p1TextField.getText();
					int button;
					if(!p1Text .isEmpty()) {
					for(button = 0; button < p1Combo.size(); button++) {
						if(p1Text.equals(p1Combo.get(button))) {
							JOptionPane.showMessageDialog(firstOptPanel, "Такой элемент существует. А жаль.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
					if(button == p1Combo.size())
						p1Combo.add(p1Text);
					} else {
						JOptionPane.showMessageDialog(firstOptPanel, "Тут пусто.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
					}
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
	    	Vector<JRadioButton> radioButtons = new Vector<JRadioButton>();
	    	radioButtons.add(p3RadioButt1);
	    	radioButtons.add(p3RadioButt2);
	    	radioButtons.add(p3RadioButt3);
	    	
	    	p3Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					String p3Text = p3TextField.getText();
					int rButton;
					if(!p3Text .isEmpty()) {
						for(rButton = 0; rButton < radioButtons.size(); rButton++) {
							if(p3Text.equals(radioButtons.get(rButton).getText())) {
								radioButtons.get(rButton).setSelected(true);
								break;
							}
						}
						if(rButton == radioButtons.size())
							JOptionPane.showMessageDialog(thirdOptPanel, "Увы, такого варианта здесь нет.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(thirdOptPanel, "Думаю, вы забыли ввести текст.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
						}
				}
	    		
	    	});
	    }
	    
	    private void fourthPanelAction() {
	    	Vector<JCheckBox> checkBoxes = new Vector<JCheckBox>();
	    	checkBoxes.add(p4Check1);
	    	checkBoxes.add(p4Check2);
	    	checkBoxes.add(p4Check3);
	    	
	    	p4Button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					String p4Text = p4TextField.getText();
					int chBox;
					if(!p4Text .isEmpty()) {
						for(chBox = 0; chBox < checkBoxes.size(); chBox++) {
							if(p4Text.equals(checkBoxes.get(chBox).getText())) {
								checkBoxes.get(chBox).setSelected(!checkBoxes.get(chBox).isSelected());
								break;
							}
						}
						if(chBox == checkBoxes.size())
							JOptionPane.showMessageDialog(fourthOptPanel, "Такой опции нет. Попробуй ещё раз.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(fourthOptPanel, "Где текст?", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
						}
				}
	    		
	    	});
	    }
	    
	    private void fifthPanelAction() {
	    	
	    	p5FirstButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(!p5TextField.getText().isEmpty())
					{
						if(p5Table.getValueAt(0, 1) != null)
							JOptionPane.showMessageDialog(fifthOptPanel, "Оба столбца будут заняты. Так нельзя.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
						else
							p5Table.setValueAt(p5TextField.getText() , 0, 0);
					}
					else
						JOptionPane.showMessageDialog(fifthOptPanel, "Здесь должен быть текст. Но его нет.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
				}
	    		
	    	});
	    	
	    	p5SecondButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(p5Table.isCellSelected(0, 0) && p5Table.getValueAt(0, 0) != null) {
						p5Table.setValueAt(p5Table.getValueAt(0, 0), 0, 1);
						p5Table.setValueAt(null, 0, 0);
					} else {
						JOptionPane.showMessageDialog(fourthOptPanel, "Что-то пошло не так.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
	    		
	    	});
	    	
	    	p5ThirdButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					if(p5Table.isCellSelected(0, 1) && p5Table.getValueAt(0, 1) != null) {
						p5Table.setValueAt(p5Table.getValueAt(0, 1), 0, 0);
						p5Table.setValueAt(null, 0, 1);
					} else {
						JOptionPane.showMessageDialog(fourthOptPanel, "Что-то пошло не так.", "Внимание!", JOptionPane.INFORMATION_MESSAGE);
					}
				}
	    		
	    	});
	    }
}


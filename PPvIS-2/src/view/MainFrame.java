package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  //sax reader
import java.util.ArrayList;		
import java.util.Vector;			
import java.io.File;
import java.io.FileFilter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Info;
import model.Student;

public class MainFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu operationsMenu;
	private JMenu fileMenu;
	private JMenuItem addItem;
	private JMenuItem searchItem;
	private JMenuItem deleteItem;
	private JMenuItem saveItem;
	private JMenuItem loadItem;
	private JButton addButton;
	private JButton searchButton;
	private JButton deleteButton;
	private JButton saveButton; 
	private JButton loadButton;
	private Controller ctr;
	private int counter = 1;
	private TableComponent tc;
	private JFileChooser fc;
	
	public MainFrame(Controller c) {
		ctr = c;
        setTitle("MainFrame");
        setSize(540, 500);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);    
        initComponents();
        
        setResizable(false);
        setVisible(true); 
        setLayout(new FlowLayout(FlowLayout.TRAILING)); 
    }
	
	private void initComponents() {
		tc = new TableComponent(ctr, ctr.getData());
		fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("XML file", "xml");
		fc.setFileFilter(filter);
		ctr.getMainTable(tc);
		addMenu();
		addButtons();
		add(tc);	
		action();
	}	
	
	private void addMenu() {
		menuBar = new JMenuBar();
		operationsMenu = new JMenu("Опции");
		fileMenu = new JMenu("Файл");
		addItem = new JMenuItem("Добавить");
		searchItem = new JMenuItem("Найти");
		deleteItem = new JMenuItem("Удалить");
		saveItem = new JMenuItem("Сохранить");
		loadItem = new JMenuItem("Открыть");
		fileMenu.add(loadItem);
		fileMenu.add(saveItem);
		operationsMenu.add(addItem);
		operationsMenu.add(deleteItem);
		operationsMenu.add(searchItem);
		menuBar.add(fileMenu);
		menuBar.add(operationsMenu);
		setJMenuBar(menuBar);
	}
	
	private void addButtons() {
		addButton = new JButton("Добавить");
		addButton.setPreferredSize(new Dimension(100, 30));
		add(addButton);
		searchButton = new JButton("Найти");
		searchButton.setPreferredSize(new Dimension(100, 30));
		add(searchButton);
		deleteButton = new JButton("Удалить");
		deleteButton.setPreferredSize(new Dimension(100, 30));
		add(deleteButton);
		saveButton = new JButton("Сохранить");
		saveButton.setPreferredSize(new Dimension(100, 30));
		add(saveButton);
		loadButton = new JButton("Открыть");
		loadButton.setPreferredSize(new Dimension(100, 30));
		add(loadButton);
	}
	
	private void action() {
		
		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub	
				try {
					int returnVal = fc.showOpenDialog(MainFrame.this);
				
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						if(file.getName().contains(".xml")){
							ctr.readFile(file);
						} else {
							JOptionPane.showMessageDialog(null, "Неверный формат файла.", "Ошибка!", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} catch (Exception ex) {
					System.out.println("Error");
				}
			}
    		
    	});
		
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					int returnVal = fc.showSaveDialog(MainFrame.this);
				
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						ctr.writeXML(file);
					}
				} catch (Exception ex) {
					System.out.println("Error");
				}
			}
    		
    	});
		
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new AddFrame(ctr);
			}
    		
    	});
		
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new SearchFrame(ctr, false);
			}

    	});
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new SearchFrame(ctr, true);
			}
    		
    	});
		
		loadItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					int returnVal = fc.showOpenDialog(MainFrame.this);
				
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						if(file.getName().contains(".xml")){
							ctr.readFile(file);
						}
					}
				} catch (Exception ex) {
					System.out.println("Error");
				}
			}
    	});
		
		saveItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				try {
					int returnVal = fc.showSaveDialog(MainFrame.this);
				
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						File file = fc.getSelectedFile();
						ctr.writeXML(file);
					}
				} catch (Exception ex) {
					System.out.println("Error");
				}
				
			}
    		
    	});
		
		addItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new AddFrame(ctr);
			}
    		
    	});
		
		searchItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new SearchFrame(ctr, false);
			}

    	});
		
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new SearchFrame(ctr, true);
			}
    		
    	});
	}
}

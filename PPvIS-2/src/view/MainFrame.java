package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import model.Info;
import model.Student;

public class MainFrame extends JFrame {
	private JMenuBar menuBar;
	private JMenu operationsMenu, fileMenu;
	private JMenuItem addItem, searchItem, deleteItem, saveItem, loadItem;
	private JButton addButton, searchButton, deleteButton, saveButton, loadButton, prevButton, nextButton, updateButton;
	private JLabel pagesCount;
	private JTextField numRows;
	private Controller ctr;
	private DataTable dataStud;
	private int counter = 1;
	private double pagesNum;
	
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
        //pack();
    }
	
	private void initComponents() {
		addMenu();
		addButtons();
		dataStud = new DataTable(ctr.getData(counter, 5));
		dataStud.setPreferredSize(new Dimension(520, 25*5));
		ctr.getMainTable(dataStud);
		JLabel pages = new JLabel("Количество строк: ");
		numRows = new JTextField(3);
		numRows.setText("5");
		prevButton = new JButton("Назад");
		nextButton = new JButton("Вперёд");
		updateButton = new JButton("Обновить");
		pagesCount = new JLabel("Страница " + counter + " из " + (int) Math.ceil(ctr.getDataSize()/5.0));
		//////
		add(pages);
		add(numRows);
		add(updateButton);
		add(prevButton);
		add(nextButton);
		add(pagesCount);
		add(dataStud);
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
		
		JFileChooser fcLoad = new JFileChooser();
		loadButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int returnVal = fcLoad.showOpenDialog(MainFrame.this);
			}
    		
    	});
		
		JFileChooser fcSave = new JFileChooser();
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int returnVal = fcSave.showSaveDialog(MainFrame.this);
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
				
				new SearchFrame(ctr);
			}

    	});
		
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new DeleteFrame(ctr);
			}
    		
    	});
		
		loadItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int returnVal = fcLoad.showOpenDialog(MainFrame.this);
			}
    		
    	});
		
		saveItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				int returnVal = fcSave.showSaveDialog(MainFrame.this);
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
				
				new SearchFrame(ctr);
			}

    	});
		
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new DeleteFrame(ctr);
			}
    		
    	});
		
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int nRows = Integer.valueOf(numRows.getText());
				if(nRows >=2 && nRows <= 14) {
					dataStud.resize(new Dimension(520, 25 * nRows));
				}
				else
					numRows.setText("5");
				
			}
		});
		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ctr.getDataSize() > Integer.valueOf(numRows.getText()) * counter)
				{
					counter++;
					pagesCount.setText("Страница " + counter + " из " + 
									(int) Math.ceil(ctr.getDataSize()/Double.valueOf(numRows.getText())));
					
					ctr.updatePage(dataStud, counter, Integer.valueOf(numRows.getText()));
					dataStud.resize(new Dimension(520, 25 * Integer.valueOf(numRows.getText())));
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
									(int) Math.ceil(ctr.getDataSize()/Double.valueOf(numRows.getText())));
					ctr.updatePage(dataStud, counter, Integer.valueOf(numRows.getText()));	
					dataStud.resize(new Dimension(520, 25 * Integer.valueOf(numRows.getText())));
				}
				
			}
		});
	}
}

package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import model.Student;

public class TableComponent extends JPanel {
	
	private ArrayList<Student> data;
	
	private JButton prevButton;
	private JButton nextButton;
	private JButton toFirstPage;
	private JButton toLastPage;
	private JButton updateButton;
	private JLabel pagesCount;
	private JTextField numRows;
	private JLabel itemsNumber;
	private DataTable dataStud;
	private Controller ctr;
	
	private int counter = 1;
	private int currentRowNumber = 5;
	
	public TableComponent(Controller ctr, ArrayList<Student> data) {
		setPreferredSize(new Dimension(530, 500));
		setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		this.ctr = ctr;
		this.data = data;
		
		dataStud = new DataTable(ctr.getData(this.data, counter, 5));
		dataStud.setPreferredSize(new Dimension(520, 25*5));
		dataStud.resize(new Dimension(520, 25 * 5));
		
		JLabel pages = new JLabel("Количество строк: ");
		if(data.size() == 0)
			pagesCount = new JLabel("Страница 1 из 1");
		else
			pagesCount = new JLabel("Страница " + counter + " из " + (int) Math.ceil(data.size()/5.0));
		itemsNumber = new JLabel("Количество записей: " + data.size());
		numRows = new JTextField(3);
		numRows.setText("5");
		prevButton = new JButton("<");
		nextButton = new JButton(">");
		toFirstPage = new JButton("<<");
		toLastPage = new JButton(">>");
		updateButton = new JButton("Обновить");
		
		add(pages);
		add(numRows);
		add(updateButton);
		add(toFirstPage);
		add(prevButton);
		add(nextButton);
		add(toLastPage);
		add(pagesCount);
		add(itemsNumber);
		add(dataStud);
		
		action();
	}
	
	private void action() {
		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int nRows = Integer.valueOf(numRows.getText());
				if(nRows >=2 && nRows <= 14) {
					currentRowNumber = nRows;
					dataStud.setPreferredSize(new Dimension(520, 25*nRows));
					dataStud.resize(new Dimension(520, 25 * nRows));
					counter = 1;
					ctr.updatePage(dataStud, 1, Integer.valueOf(numRows.getText()), data);
					pagesCount.setText("Страница " + counter + " из " + 
								(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
				}
				else {
					numRows.setText(String.valueOf(currentRowNumber));
					dataStud.setPreferredSize(new Dimension(520, 25*currentRowNumber));
					dataStud.resize(new Dimension(520, 25 * currentRowNumber));
					counter = 1;
					ctr.updatePage(dataStud, 1, currentRowNumber, data);
					pagesCount.setText("Страница " + counter + " из " + 
								(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
				}
			}
			
		});
		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(ctr.getDataSize(ctr.getData()) > Integer.valueOf(numRows.getText()) * counter)
				{
					counter++;
					pagesCount.setText("Страница " + counter + " из " + 
									(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
					dataStud.removeData();
					ctr.updatePage(dataStud, counter, Integer.valueOf(numRows.getText()), data);
					dataStud.setPreferredSize(new Dimension(520, 25*Integer.valueOf(numRows.getText())));
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
									(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
					dataStud.removeData();
					ctr.updatePage(dataStud, counter, Integer.valueOf(numRows.getText()), data);	
					dataStud.setPreferredSize(new Dimension(520, 25*Integer.valueOf(numRows.getText())));
					dataStud.resize(new Dimension(520, 25 * Integer.valueOf(numRows.getText())));
				}
				
			}
		});
		
		toFirstPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				dataStud.setPreferredSize(new Dimension(520, 25*currentRowNumber));
				dataStud.resize(new Dimension(520, 25 * currentRowNumber));
				counter = 1;
				dataStud.removeData();
				ctr.updatePage(dataStud, 1, currentRowNumber, data);
				pagesCount.setText("Страница 1 из " + 
							(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
			}
		});
		
		toLastPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				counter = (int) Math.ceil(data.size()/Double.valueOf(currentRowNumber));
				dataStud.removeData();
				ctr.updatePage(dataStud, counter, currentRowNumber, data);
				pagesCount.setText("Страница " + counter + " из " + 
						(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
			}
		});
	}
	
	
	public void updateElementsNumber() {
		itemsNumber.setText("Количество записей: " + data.size());
		pagesCount.setText("Страница " + counter + " из " + 
				(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
	}
	
	public DataTable getTable() {
		return dataStud;
	}
	
	public void newData(ArrayList<Student> data) {
		this.data = data;
	}
}

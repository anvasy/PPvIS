package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

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
	
	private int counter = 1;
	private int currentRowNumber = 5;
	
	public TableComponent(ArrayList<Student> data) {
		setPreferredSize(new Dimension(530, 500));
		setLayout(new FlowLayout(FlowLayout.TRAILING));
		
		this.data = data;
		
		dataStud = new DataTable(getPartOfArray(this.data, counter, 5));
		dataStud.setPreferredSize(new Dimension(520, 25*5));
		dataStud.resize(new Dimension(520, 25 * 5));
		
		JLabel pages = new JLabel("Количество страниц: ");
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
					updatePage(1, Integer.valueOf(numRows.getText()));
					pagesCount.setText("Страница " + counter + " из " + 
								(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
				}
				else {
					numRows.setText(String.valueOf(currentRowNumber));
					dataStud.setPreferredSize(new Dimension(520, 25*currentRowNumber));
					dataStud.resize(new Dimension(520, 25 * currentRowNumber));
					counter = 1;
					updatePage(1, currentRowNumber);
					pagesCount.setText("Страница " + counter + " из " + 
								(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
				}
			}
			
		});
		
		nextButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(data.size() > Integer.valueOf(numRows.getText()) * counter)
				{
					counter++;
					pagesCount.setText("Страница " + counter + " из " + 
									(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
					updatePage(counter, Integer.valueOf(numRows.getText()));
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
					pagesCount.setText("Страница" + counter + " из " + 
									(int) Math.ceil(data.size()/Double.valueOf(numRows.getText())));
					updatePage(counter, Integer.valueOf(numRows.getText()));	
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
				updatePage(1, currentRowNumber);
				pagesCount.setText("Страница 1 из " + 
							(int) Math.ceil(data.size()/Double.valueOf(currentRowNumber)));
			}
		});
		
		
		
		toLastPage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				counter = (int) Math.ceil(data.size()/Double.valueOf(currentRowNumber));
				updatePage(counter, currentRowNumber);
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
	
	public void updatePage(int counter, int numRows) {
		dataStud.removeData();
		ArrayList<Student> newData = new ArrayList();
		newData = getPartOfArray(data, counter, numRows);
		for(int row = 0; row < newData.size(); row++) {
			Vector v = new Vector();
            v = newData.get(row).returnVec();
			for(int el = 0; el < dataStud.getColumnCount(); el++) {
				dataStud.setValueAt(v.get(el), row, el);
			}
		}
		updateElementsNumber();
	}
	
	public ArrayList<Student> getPartOfArray(ArrayList<Student> stud, int counter, int numRows) {

		if(numRows >= stud.size())
			return stud;
		
		ArrayList<Student> result = new ArrayList<Student>();
		int endOfSubList = 0;
		if(numRows * (counter - 1) + numRows > stud.size())
			endOfSubList = stud.size();
		else
			endOfSubList = numRows * (counter - 1) + numRows;
		
		for(int el = numRows * (counter - 1); el < endOfSubList; el++)
		{
			result.add(stud.get(el));
		}
		return result;
	}
}

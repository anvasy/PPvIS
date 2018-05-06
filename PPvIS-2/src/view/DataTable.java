package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import model.Student;

public class DataTable extends JTable {
	private String[] columnNames = { "ФИО", "Дата рождения", "Дата поступления", "Дата окончания" };
	private DefaultTableModel dtm;
	
	public DataTable(ArrayList<Student> res) {
		dtm = new DefaultTableModel();
		for (int el = 0; el < columnNames.length; el++) {
            dtm.addColumn(columnNames[el]);
        }
		
		for(int el = 0; el < 15; el++)
		{
			Vector v = new Vector();
			for(int emV = 0; emV < 4; emV++)
				v.add("");
			dtm.addRow(v);
		}
		
        for(int el = 0; el < res.size(); el++) {
            Vector v = new Vector();
            v = res.get(el).returnVec();
            for(int emV = 0; emV < 4; emV++)
            	dtm.setValueAt(v.get(emV), el, emV);
          
           // dtm.insertRow(el, v);
            //dtm.removeRow(end);
            
        }
        dtm.setColumnIdentifiers(columnNames);
        setModel(dtm);
        setEnabled(false);
        setRowHeight(25);
        getColumnModel().getColumn(0).setPreferredWidth(205);
        getColumnModel().getColumn(1).setPreferredWidth(105);
        getColumnModel().getColumn(2).setPreferredWidth(105);
        getColumnModel().getColumn(3).setPreferredWidth(105);      
	}
	
	public void addRows(Vector v) {
		dtm.addRow(v);
	}
	
	public void removeData() {
		for (int i = 0; i < 15; i++)
		      for(int j = 0; j < 4; j++) {
		          dtm.setValueAt("", i, j);
		      }
		
		/*dtm.getDataVector().removeAllElements();
		dtm.fireTableDataChanged(); */
	
		/*for(int el = 0; el < 15; el++)
		{
			Vector v = new Vector();
			for(int emV = 0; emV < 4; emV++)
				v.add("");
			dtm.addRow(v);
		}*/
	}
	
}

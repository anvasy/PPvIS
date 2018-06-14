package ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.ChartPoint;
import model.Coordinates;

public class CoordsTableModel extends AbstractTableModel {
    private String[] tableHeader = {"X", "Y"};

    private ArrayList<ChartPoint> list;

    public CoordsTableModel(){
        list = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public String getColumnName(int column) {
        return tableHeader[column];
    }

    @Override
    public int getColumnCount() {
        return tableHeader.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	ChartPoint rows = list.get(rowIndex);
        return rows.getValue(columnIndex);
    }

    public void add(ChartPoint point){
        list.add(point);
        fireTableDataChanged();
    }

    public void deleteAll()
    {
        list.clear();
        fireTableDataChanged();
    }
}

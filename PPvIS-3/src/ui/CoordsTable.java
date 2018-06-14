package ui;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controller.Controller;

public class CoordsTable {
	private Controller controller;

	private CoordsTableModel tModel = new CoordsTableModel();
	JTable table = new JTable(tModel);
	JScrollPane jsp = new JScrollPane(table);

	public CoordsTable(Controller controller){
        this.controller = controller;
    }

	public void addCoord() {
		synchronized (controller.getCoords()) {
			tModel.deleteAll();
			for (int index = 0; index < controller.getCoordsSize(); index++) {
				tModel.add(controller.getElement(index));
			}
		}
	}

	public JScrollPane getPane() {
		jsp.setPreferredSize(new Dimension(200, 30));
		return jsp;
	}
}

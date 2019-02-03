package reports.strategy;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public interface Ireports {
	public TableView getReport(TableView tbl1,Label lblCaption);
	public void getExportReport(String name);
}

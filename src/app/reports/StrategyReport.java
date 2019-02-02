package app.reports;

import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class StrategyReport {
	private Ireports strategy;
	public void SetStrategy(Ireports strategy) {
		this.strategy=strategy;
	}
	public TableView getStrategy(TableView tbl1,Label lblCaption) {
		return  strategy.getReport(tbl1,lblCaption);
	}
}

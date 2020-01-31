package donutchart;

import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class DonutChart extends StackPane {
	private AnchorPane anchor;
	private PieChart pie;
	private Circle circle;
	
	public DonutChart(ObservableList<PieChart.Data> datas) {
		initi(datas);
	}
	
	private void initi(ObservableList<PieChart.Data> datas) {
		initiPie(datas);
		initiCircle();
		initiAnchor();
		this.getChildren().addAll(this.anchor,this.circle);
	}
	
	private void initiAnchor() {
		this.anchor = new AnchorPane();
		this.anchor.getChildren().add(this.pie);
	}
	
	private void initiPie(ObservableList<PieChart.Data> datas) {
		this.pie = new PieChart();
		this.pie.setData(datas);
		this.pie.setLegendVisible(false);
		AnchorPane.setTopAnchor(pie,0.0);
		AnchorPane.setRightAnchor(pie,0.0);
		AnchorPane.setBottomAnchor(pie,0.0);
		AnchorPane.setLeftAnchor(pie,0.0);
	}
	
	private void initiCircle() {
		this.circle = new Circle();
		this.circle.setRadius(80.0f);
		this.circle.setFill(Paint.valueOf("#fcfcfc"));
	}
	
	public void setCenterCircleStyle(double radius, String color) {
		this.circle.setRadius(radius);
		this.circle.setFill(Paint.valueOf(color));
	}
	
	public void pieColors(String...colors) {
		int i = 0;
        for (PieChart.Data data : pie.getData()) {
          data.getNode().setStyle("-fx-pie-color: " + colors[i % colors.length] + ";");
          i++;
        }
	}
	
	public void autoRadius() {
		double width = this.getWidth();
		System.out.println("w: "+width);
		this.circle.setRadius(width/3);
	}
}

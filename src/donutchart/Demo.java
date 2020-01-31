package donutchart;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Demo extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		//Preparing datas
		ArrayList<PieChart.Data> datas = new ArrayList<>();
		datas.add(new Data("Java",10));
		datas.add(new Data("C", 30));
		datas.add(new Data("Kotlin", 20));
		datas.add(new Data("PHP", 10));
		datas.add(new Data("C++", 30));
		
		//Instance
		DonutChart donut = new DonutChart(FXCollections.observableList(datas));
		
		//Styling
		donut.setCenterCircleStyle(80.0f,"#FCFCFC");
		donut.pieColors("#9966FF","#CC0066","#20B2AA","#FFCC33","#93D573");
		
        //Add to container
        primaryStage.setScene(new Scene(donut,400,300));
        primaryStage.setTitle("DonutChart JavaFX - by Patrick Rios");
        primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
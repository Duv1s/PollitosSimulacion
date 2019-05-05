package com.restaurantsimulation.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.RestaurantSimulation;
import logic.entity.Dish;
import logic.entity.DishStat;

public class FXMLController implements Initializable {
    
    private ObservableList<DishStat> data;

    @FXML
    private Spinner<Integer> simulationTimeSpinner, simulationMinComensal, simulationMaxComensal, simulationMinWork, simulationMaxWork;
    @FXML
    private TableView<DishStat> resultsTable;
        @FXML
    private TableColumn<DishStat, Dish> dishColumn;

    @FXML
    private TableColumn<DishStat, Integer> sellsColumn,rankedColumn;

    @FXML
    private TableColumn<DishStat, Double> rankColumn;

    @FXML
    private void startSimulation(){
        data.clear();
        RestaurantSimulation rs = new RestaurantSimulation( simulationMaxComensal.getValue(), simulationMinComensal.getValue(),
                simulationMinWork.getValue(), simulationMaxWork.getValue(), simulationTimeSpinner.getValue());
        rs.startSimulation();
        data.add(rs.getPlato1());
        data.add(rs.getPlato2());
        data.add(rs.getPlato3());
        data.add(rs.getPlato4());
        rs.printStats();
    }
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        dishColumn.setCellValueFactory(new PropertyValueFactory<>("dish"));
        sellsColumn.setCellValueFactory(new PropertyValueFactory<>("totalSells"));
        rankedColumn.setCellValueFactory(new PropertyValueFactory<>("rankedSells"));
        rankColumn.setCellValueFactory(new PropertyValueFactory<>("rank"));
        data = FXCollections.observableArrayList();
        resultsTable.setItems(data);
        simulationTimeSpinner.valueFactoryProperty().getValue().setValue(100);
        simulationMinComensal.valueFactoryProperty().getValue().setValue(73);
        simulationMaxComensal.valueFactoryProperty().getValue().setValue(103);
        simulationMinWork.valueFactoryProperty().getValue().setValue(10);
        simulationMaxWork.valueFactoryProperty().getValue().setValue(12);

    }    
}

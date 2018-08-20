package main;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Toglovanje extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        VBox root = new VBox();
        
        ToggleGroup group = new ToggleGroup();

        ToggleButton tb1 = new ToggleButton("Minor");
        tb1.setUserData("minor");
        tb1.setToggleGroup(group);
        tb1.setSelected(true);

        ToggleButton tb2 = new ToggleButton("Major");
        tb2.setUserData("major");
        tb2.setToggleGroup(group);
        
        ToggleButton tb3 = new ToggleButton("Critical");
        tb3.setUserData("criticial");
        tb3.setToggleGroup(group);
        
        root.getChildren().addAll(tb1, tb2, tb3);
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) ->
        {
            System.out.println(newValue.getUserData());
        });
    }
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

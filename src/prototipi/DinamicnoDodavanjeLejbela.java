package prototipi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DinamicnoDodavanjeLejbela extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        Pane root = new Pane();
        
        Label label = new Label();
        label.setMinSize(5, 5);
        label.setStyle("-fx-background-color: blue;");
        root.getChildren().add(label);
                
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}

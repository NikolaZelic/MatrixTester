package prototipi.reaktivnost;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ReaktivniTextFild extends Application
{
    private StringProperty str = new SimpleStringProperty("Pera");
    public ReaktivniTextFild(){
        str.addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) ->
        {
            System.out.println("Promena");
        });
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        Button btn = new Button();
        btn.setText("Change");
        btn.setOnAction((ActionEvent event) ->
        {
            str.setValue("Zika");
        });
        TextField tf = new TextField();
//        tf.textProperty().bind( str );
        tf.textProperty().bindBidirectional(str);
        HBox root = new HBox();
        root.getChildren().addAll(btn, tf);
        
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

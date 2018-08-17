package prototipi.reaktivnost;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class ReaktivnaCElija extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        Button btn = new Button("asdf");
        btn.setText("Say 'Hello World'");
        
        IntegerProperty value = new SimpleIntegerProperty(1);
        Cell cell = new Cell(keyValues, value, 10, 10, 20, 20);
        
        btn.setOnAction((event) ->
        {
            value.set(0);
        });
        
        VBox root = new VBox();
        root.getChildren().addAll(cell, btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
 
    
    private Map<Integer, String> keyValues = new HashMap<>();
    public ReaktivnaCElija()
    {
        keyValues.put(0, "lightblue");
        keyValues.put(1, "blue");
    }
}

class Cell extends StackPane
{
    private Map<Integer, String> keyValues; 
    private IntegerProperty value;
    public Cell(Map<Integer, String> keyValues, IntegerProperty value, double x, double y, double width, double height)
    {
        this.keyValues = keyValues;
        this.value = value;
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.LIGHTBLUE);
        Label label = new Label();
        label.setMinSize(width, height);
        label.setStyle("-fx-background-color: " + keyValues.get(value.get()) + ";");
        setTranslateX(x);
        setTranslateY(y);
        getChildren().addAll(rectangle, label);
        label.setOnMouseClicked((MouseEvent event) ->
        {
            int get = value.get();
            if(get==0)
                value.set(1);
            else
                value.set(0);
        });
        value.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) ->
        {
            label.setStyle("-fx-background-color: " + keyValues.get(value.get()) + ";");
        });
    }

}

package verzija1;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Playground extends GridPane
{
    // MATRIX DATA
    protected ObjectProperty<IntegerProperty[][]> matrix;
    protected Map<Integer, String> valueMap;
    protected void renderMatrix(){
        IntegerProperty[][] m = matrix.getValue();
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                Cell cell = new Cell(m[i][j], valueMap);
                gridPane.add(cell, i, j);
            }
        }
    }
    protected ObjectProperty<IntegerProperty[][]> defaultMatrix(){
        int n=20, m=20;
        IntegerProperty[][] mat = new IntegerProperty[n][m];
        ObjectProperty<IntegerProperty[][]> result = new SimpleObjectProperty<>(mat);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                IntegerProperty el = new SimpleIntegerProperty(0);
                mat[i][j] = el;
            }
        }
        return result;
    }
    protected Map<Integer, String> defaultValueMap(){
        Map<Integer, String> map =  new HashMap<>();
        map.put(0, "blue");
        map.put(1, "green");
        return map;
    }
    
    // JAVA_FX 
    protected GridPane gridPane;
    protected VBox legend;
    protected HBox heder;
    protected void setUpGridPane(){
        gridPane = new GridPane();
    }
    protected void setUpLegend(){
        legend = new VBox();
        legend.getChildren().add( new Label("Teks") );
    }
    protected void setUpHeder(){
        heder = new HBox(new Label("Run"));
    }
    
    public Playground(){
        setUpGridPane();
        setUpLegend();
        setUpHeder();
        
        getColumnConstraints().add(new ColumnConstraints(100)); 
        
        add(heder, 1, 0);
        add(legend, 0, 1);
        add(gridPane, 1, 1);
        
        // TEST
        valueMap = defaultValueMap();
        matrix = defaultMatrix();
        renderMatrix();
    }
}

class Cell extends Label
{
    protected IntegerProperty value;
    protected Map<Integer, String> valueMap;

    public Cell(IntegerProperty value, Map<Integer, String> valueMap)
    {
        this.value = value;
        this.valueMap = valueMap;
        setColor( valueMap.get(value.get()) );
        setPrefSize(30, 30);
        this.value.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) ->
        {
            setColor( valueMap.get(newValue) );
        });
    }
    
    protected void setColor(String color){
        setStyle("-fx-background-color: "+color+";");
    }
}
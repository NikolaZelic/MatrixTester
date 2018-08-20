package verzija1;

import java.util.HashMap;
import java.util.Map;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public final class Playground extends GridPane
{
    // MATRIX DATA
    protected ObjectProperty<IntegerProperty[][]> matrix;
    protected Map<Integer, String> valueMap;
    protected Map<Integer, String> valueLegend;
    protected Integer selectLegend = null;
    protected void renderMatrix(){
        gridPane.getChildren().clear();
        IntegerProperty[][] m = matrix.getValue();
        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                Cell cell = new Cell(m[i][j], valueMap, this);
                gridPane.add(cell, i, j);
            }
        }
    }
    protected ObjectProperty<IntegerProperty[][]> defaultMatrix(){
        // CREATE MATRIX
        int n=20, m=20;
        IntegerProperty[][] mat = new IntegerProperty[n][m];
        ObjectProperty<IntegerProperty[][]> result = new SimpleObjectProperty<>(mat);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                IntegerProperty el = new SimpleIntegerProperty(0);
                mat[i][j] = el;
            }
        }
        // ADD CHANGE LISTENER
        result.addListener((ObservableValue<? extends IntegerProperty[][]> observable, IntegerProperty[][] oldValue, IntegerProperty[][] newValue) ->
        {
            renderMatrix();
        });
        return result;
    }
    protected Map<Integer, String> defaultValueMap(){
        Map<Integer, String> map =  new HashMap<>();
        map.put(0, "blue");
        map.put(1, "green");
        return map;
    }
    protected Map<Integer, String> defaultValueLegend(){
        Map<Integer, String> result = new HashMap<>();
        result.put(0, "Prolaz");
        result.put(1, "Zid");
        return result;
    }
    public void setMatrix(IntegerProperty[][] matrix){
        this.matrix.setValue(matrix);
    }
    public IntegerProperty[][] getMatrix(){
        return matrix.getValue();
    }
    protected IntegerProperty[][] newMatrix(int im, int jm){
        IntegerProperty[][] result = new IntegerProperty[im][jm];
        for(int i=0; i<im; i++)
            for(int j=0; j<jm; j++)
                result[i][j] = new SimpleIntegerProperty(0);
        return result;
    }
    protected void setValuesToMatrix(IntegerProperty[][] from, IntegerProperty[][] to){
        int oi = from.length, oj = from[0].length, ni = to.length, nj = to[0].length;
        int smallerI = ni < oi ? ni : oi;
        int smallerJ = nj < oj ? nj : oj;
        
        for(int i=0;i<smallerI; i++){
            for(int j=0; j<smallerJ; j++){
                to[i][j].setValue(from[i][j].getValue());
            }
        }
    }
    
    // JAVA_FX 
    protected GridPane gridPane;
    protected VBox legend;
    protected HBox heder;
    protected ScrollPane scroll;
    protected TextField iTf;
    protected TextField jTf;
    protected Button changeDimenstionsBtn;
    protected void setUpGridPane(){
        gridPane = new GridPane();
    }
    protected void setUpLegend(){
        legend = new VBox();
        Label header = new Label("Legend");
        legend.getChildren().add(header);
        ToggleGroup group = new ToggleGroup();
        
        valueLegend.forEach((k, v)->{
            ToggleButton btn = new ToggleButton(v+" - "+valueMap.get(k));
            btn.setToggleGroup(group);
            btn.setUserData(k);
            legend.getChildren().add(btn);
            btn.setOnAction((event) -> {
                selectLegend = (Integer)btn.getUserData();
                System.out.println(selectLegend);
            });
        });
        
        ToggleButton clear = new ToggleButton("Toggle");
        clear.setToggleGroup(group);
        clear.setOnAction((event) -> {
            selectLegend = null;
            System.out.println(selectLegend);
        });
        legend.getChildren().add(clear);
    }
    protected void setUpHeder(){
        iTf = new TextField("20");
        jTf = new TextField("20");
        changeDimenstionsBtn = new Button("Change");
        changeDimenstionsBtn.setOnAction(this.changeDimesnionsEvent);
        heder = new HBox(iTf, jTf, changeDimenstionsBtn);
    }
    protected EventHandler<ActionEvent> changeDimesnionsEvent = (ActionEvent event) -> {
        try{
            int i = Integer.valueOf(iTf.getText());
            int j = Integer.valueOf(jTf.getText());
            IntegerProperty[][] matrix = newMatrix(i, j);
            setValuesToMatrix(this.matrix.getValue(), matrix);
            setMatrix(matrix);
        } 
        catch (NumberFormatException e){
        }
    };
    
    public Playground(){
        valueMap = defaultValueMap();
        valueLegend = defaultValueLegend();
        setUpHeder();
        setUpGridPane();
        setUpLegend();
        matrix = defaultMatrix();
        renderMatrix();
        scroll = new ScrollPane(gridPane);
        
        getColumnConstraints().add(new ColumnConstraints(100)); 
        
        add(heder, 1, 0);
        add(legend, 0, 1);
        add(scroll, 1, 1);
    }
}

class Cell extends Label
{
    protected IntegerProperty value;
    protected Map<Integer, String> valueMap;

    public Cell(IntegerProperty value, Map<Integer, String> valueMap, Playground parent)
    {
        this.value = value;
        this.valueMap = valueMap;
        setPrefSize(30, 30);
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        setColor( valueMap.get(value.get()) );
        
        this.value.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) ->
        {
            setColor( valueMap.get(newValue) );
        });
        setOnMouseClicked((MouseEvent event) ->
        {
            if(parent.selectLegend==null){
                int br = this.value.getValue();
                while(true){
                    br++;
                    String get = this.valueMap.get(br);
                    if(get==null){
                        br = -1;
                        continue;
                    }
                    this.value.setValue(br);
                    break;
                }
            }
            else{
                this.value.setValue(parent.selectLegend);
            }
        });
    }
    
    protected void setColor(String color){
        setStyle("-fx-background-color: "+color+";");
    }
}
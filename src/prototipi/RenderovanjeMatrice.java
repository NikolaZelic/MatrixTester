package prototipi;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.KeyValue;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RenderovanjeMatrice extends Application
{

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 20;
    private int m = 20;

//    double gridWidth = sceneWidth / n;
//    double gridHeight = sceneHeight / m;
    double gridWidth = 30;
    double gridHeight = 30;
    
    private Cell[][] playfield = new Cell[n][m];
    
    private int[][] matrix;
    private int[][] createMatrix(int x, int y, int value)
    {
        int[][] matrix = new int[x][y];
        for(int i=0;  i<x; i++)
        {
            for(int j=0; j<y; j++)
            {
                matrix[i][j] = value;
            }
        }
        return matrix;
    }
    
    private Group group = new Group();
    private void renderMatrix()
    {
        playfield = new Cell[n][m];
        group.getChildren().clear();
        matrix = createMatrix(n, m, 0);
        System.out.println(group.getChildren().size());
        for(int i=0;  i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                playfield[i][j] = new Cell(matrix[i][j], i*gridWidth, j*gridHeight, gridWidth, gridHeight);
                group.getChildren().add(playfield[i][j]);
            }
        }
        System.out.println(group.getChildren().size());
    }
    
    private static Map<Integer, String> keyValues = new HashMap<>();
    public RenderovanjeMatrice()
    {
        keyValues.put(0, "lightblue");
        keyValues.put(1, "blue");
//        matrix = createMatrix(n, m, 0);
//        matrix[0][0] = 1;
    }
    
    private TextField rowsInput = new TextField(""+n);
    private TextField columnsInput = new TextField(""+m);
    private Button changeDimensionsBtn = new Button("Change");
    private void setUpHeder(GridPane grid)
    {
        HBox  pane = new HBox (rowsInput, columnsInput, changeDimensionsBtn);
        grid.add(pane, 1, 0);
        // Add click event on "Change" button
        changeDimensionsBtn.setOnAction((ActionEvent event) ->
        {
            String rowsText = rowsInput.getText();
            String columnsText = columnsInput.getText();
            if( rowsText.length() == 0 || columnsText.length() == 0 )
                return;
            try{
                n = Integer.valueOf(rowsText);
                m = Integer.valueOf(columnsText);
            }
            catch(NumberFormatException e){
                e.printStackTrace();
                return;
            }
            renderMatrix();
            scrollPane.setContent(group);
        });
    }
    
    private GridPane gridPane = new GridPane();
    private ScrollPane scrollPane = new ScrollPane();
    
    @Override
    public void start(Stage primaryStage)
    {
        renderMatrix();
        
        scrollPane.setContent(group);
        
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.add(scrollPane, 1, 1);
        
        setUpHeder(gridPane);
        
        Scene scene = new Scene(gridPane);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public static class Cell extends StackPane
    {

        public Cell( int value, double x, double y, double width, double height)
        {
            Rectangle rectangle = new Rectangle(width, height);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTBLUE);
            Label label = new Label();
            label.setMinSize(width, height);
            label.setStyle("-fx-background-color: "+keyValues.get(value)+";");
            setTranslateX(x);
            setTranslateY(y);
            getChildren().addAll(rectangle, label);
        }

    }

}

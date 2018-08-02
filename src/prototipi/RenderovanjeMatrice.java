package prototipi;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.KeyValue;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RenderovanjeMatrice extends Application
{

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 10;
    private int m = 10;

    double gridWidth = sceneWidth / n;
    double gridHeight = sceneHeight / m;

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
        for(int i=0;  i<matrix.length; i++)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                playfield[i][j] = new Cell(matrix[i][j], i*gridWidth, j*gridHeight, gridWidth, gridHeight);
                group.getChildren().add(playfield[i][j]);
            }
        }
        
    }
    
    private static Map<Integer, String> keyValues = new HashMap<>();
    public RenderovanjeMatrice()
    {
        keyValues.put(0, "lightblue");
        keyValues.put(1, "blue");
        matrix = createMatrix(n, m, 0);
        matrix[0][0] = 1;
    }
    
    @Override
    public void start(Stage primaryStage)
    {
        renderMatrix();
        Scene scene = new Scene(group, sceneWidth, sceneHeight);
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

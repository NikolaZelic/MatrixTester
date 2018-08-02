package prototipi;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class NodeDemo extends Application
{

    private double sceneWidth = 1024;
    private double sceneHeight = 768;

    private int n = 10;
    private int m = 10;

    double gridWidth = sceneWidth / n;
    double gridHeight = sceneHeight / m;

    MyNode[][] playfield = new MyNode[n][m];

    @Override
    public void start(Stage primaryStage)
    {
        Group root = new Group();
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                MyNode node = new MyNode("Item " + i + "/" + j, i * gridWidth, j * gridHeight, gridWidth, gridHeight);
                root.getChildren().add(node);
                playfield[i][j] = node;
            }
        }
        Scene scene = new Scene(root, sceneWidth, sceneHeight);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public static class MyNode extends StackPane
    {

        public MyNode(String name, double x, double y, double width, double height)
        {
            Rectangle rectangle = new Rectangle(width, height);
            rectangle.setStroke(Color.BLACK);
            rectangle.setFill(Color.LIGHTBLUE);
            Label label = new Label(name);
            setTranslateX(x);
            setTranslateY(y);
            getChildren().addAll(rectangle, label);
        }

    }

}

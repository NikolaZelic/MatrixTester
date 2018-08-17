package prototipi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class PokusajGridPane extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root);
        stage.setScene(scene);

        GridPane gridpane = new GridPane();
        
//        for (int i = 0; i < 100; i++) {
//            ColumnConstraints column = new ColumnConstraints(10);
//            RowConstraints row = new RowConstraints(10);
//            gridpane.getRowConstraints().add(row);
//            gridpane.getColumnConstraints().add(column);
//        }
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                Label label = new Label("a");
                gridpane.add(label, i, j);
            }
        }
        
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(800, 600);
        scroll.setContent(gridpane);
        scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        
        root.getChildren().add(scroll);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
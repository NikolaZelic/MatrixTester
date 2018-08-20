package verzija1;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        Playground p = new Playground();
        Scene scene = new Scene(p, 800, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        int n = 5, m = 5;
        IntegerProperty[][] matrix = new IntegerProperty[n][m];
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++){
                matrix[i][j] = new SimpleIntegerProperty(0);
            }
                
        p.setMatrix(matrix);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}

package verzija1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        Playground p = new Playground();
        Scene scene = new Scene(p, 600, 800);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}

package verzija1;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application
{
    
    @Override
    public void start(Stage primaryStage)
    {
        Map<Integer, String> valueMap = new HashMap<>();
        Map<Integer, String> valuelegend = new HashMap<>();
        valueMap.put(0, "blue");
        valuelegend.put(0, "zid");
        valueMap.put(1, "green");
        valuelegend.put(1, "prolaz");
        
        Playground p = new Playground(valueMap, valuelegend);
        Scene scene = new Scene(p, 800, 400);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}

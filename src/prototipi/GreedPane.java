package prototipi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import main.Form;

public class GreedPane extends Form
{

    @FXML
    private GridPane background;
    
    public GreedPane()
    {
        int n = 5;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                Label label = new Label();
                label.setMinSize(5, 5);
                label.setStyle("-fx-background-color: blue;");
                background.add(label, i, j);
            }
        }
    }
}

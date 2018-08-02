package prototipi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import main.Form;

public class test1 extends Form
{

    @FXML
    private AnchorPane background;
    
    public test1()
    {
        initialize();
    }
    
    protected void initialize()
    {
        Label label = new Label();
        label.setMinSize(150, 150);
        label.setStyle("-fx-background-color: blue;");
        background.getChildren().add(label);
    }
}

package prototipi;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import main.Form;

public class LejbelNaTabeli extends Form
{

    @FXML
    private TableView<Label> table;
    @FXML
    private TableColumn<Label, Label> tc1;
    @FXML
    private TableColumn<?, ?> tc2;
    
    public LejbelNaTabeli()
    {
        super();
        ObservableList<Label> list = FXCollections.observableArrayList();
        Label label = new Label();
        label.setMinSize(20, 20);
        label.setStyle("-fx-background-color: blue;");
        list.add(label);
        tc1.setCellValueFactory(( param) ->
        {
            Label value = param.getValue();
            ObservableValue<Label> observable = new SimpleObjectProperty<>(value);
            return observable;
        });
        table.setItems(list);
    }
    
}

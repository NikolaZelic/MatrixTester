package prototipi.reaktivnost;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


public class ReaktivnaMatrica
{

    public static void main(String[] args)
    {
        ObjectProperty<Integer[][]> observable = new SimpleObjectProperty<>();
        observable.addListener((ObservableValue<? extends Integer[][]> observable1, Integer[][] oldValue, Integer[][] newValue) ->
        {
            System.out.println("Renderovanje matrice");
        });
        observable.set(new Integer[][]{{1},{2}});
    }
    
}

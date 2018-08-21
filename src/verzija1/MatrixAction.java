package verzija1;

import java.util.Map;
import javafx.beans.property.IntegerProperty;

public interface MatrixAction
{
    public void action(IntegerProperty[][] matrix, Map<Integer, String> valuMap);
}

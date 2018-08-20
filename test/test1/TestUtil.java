package test1;

import java.io.File;
import javafx.beans.property.IntegerProperty;
import verzija1.Util;

public class TestUtil
{

    public static void main(String[] args) throws Exception
    {
        IntegerProperty[][] matrix = Util.parseFileToMatrix(new File("C:\\Users\\Grupa1\\Desktop\\test.txt"));
        Util.writeMatrix(matrix);
    }
    
}

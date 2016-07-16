import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DataRetriever {

    public static Object deserializeData(String fileName){
        Object returnValue = null;
        try {
            File inputFile = new File(fileName);
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(inputFile));
                    returnValue = readIn.readObject();
                    readIn.close();
                } else {
                    System.out.println(fileName + " is a directory.");
                }
            } else {
                System.out.println(fileName + " does not exist.");
            }
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (ClassNotFoundException exc){
            exc.printStackTrace();
        }
        return returnValue;
    }

}

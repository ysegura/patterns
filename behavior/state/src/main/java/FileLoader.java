import java.io.*;

public class FileLoader {

    public static Object loadData(File inputFile) {
        Object returnValue = null;
        try {
            if (inputFile.exists()){
                if (inputFile.isFile()){
                    ObjectInputStream readIn = new ObjectInputStream(new FileInputStream(inputFile));
                    returnValue = readIn.readObject();
                    readIn.close();
                }else{
                    System.err.println(inputFile + " is a directory.");
                }
            }else {
                System.err.println(inputFile + " does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return returnValue;
    }

    public static void storeData(File outputFile, Serializable data){
        try {
            ObjectOutputStream writeOut = new ObjectOutputStream(new FileOutputStream(outputFile));
            writeOut.writeObject(data);
            writeOut.close();
        }catch (IOException exc){
            exc.printStackTrace();
        }
    }

}

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    static Object loadObject(String fileName) {
        Object retObj = null;

        try {
            ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileName));

            retObj = objIn.readObject();

            objIn.close();
        }

        catch (InvalidClassException e) {
            System.out.println("Savefilen är föråldrad.");

        } catch (FileNotFoundException e) {
            System.out.println("Welcome new player!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
            e.printStackTrace();
        }

        return retObj;
    }

    static void saveObject(String fileName, Object objectToSave) {
        // System.out.println("Saving object to file: " + fileName);
        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            ObjectOutputStream objOutStream = new ObjectOutputStream(outStream);

            objOutStream.writeObject(objectToSave);

            objOutStream.close();

        } catch (FileNotFoundException e) {
           // e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static String readSaveFile(String fileName) {
        // System.out.println("Reading file " + fileName);
        StringBuilder retStr = new StringBuilder();

        try {
            FileInputStream inStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                retStr.append(line);
            }
            bufferedReader.close();

        } catch (FileNotFoundException e) {
          //  e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retStr.toString();

    }

    static void writeSaveFile(String fileName, String content) {
        // File saveFile = new File("save.txt");

        try {
            FileOutputStream outStream = new FileOutputStream(fileName);
            OutputStreamWriter writer = new OutputStreamWriter(outStream, StandardCharsets.UTF_8);

            for (int i = 0; i < content.length(); i++) {
                writer.write(content.charAt(i));
            }
            writer.close();
            // System.out.println("File written.");
        } catch (FileNotFoundException e) {
          //  System.out.println("File not found.");
          //  e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

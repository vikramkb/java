package serialization;

import singleton.Log2;
import singleton.Log3;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serialization {
    public static void serializeLog2Out(Log2 log2) throws IOException {
        String path = getProjectHomeDirectory() + "Log2.ser";
        //try with resources construct
        try (
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ){
            objectOutputStream.writeObject(log2);
        }
    }


    public static Log2 serializeLog2In() throws IOException, ClassNotFoundException {
        String path = getProjectHomeDirectory() + "Log2.ser";
        //try with resources construct
        try(
            FileInputStream fileInStream = new FileInputStream(path);
            ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
        ) {
            Log2 log2 = (Log2)objectInStream.readObject();
            return log2;
        }
    }

    public static void serializeLog2Out(Log3 log3) throws IOException {
        String path = getProjectHomeDirectory() + "Log3.ser";
        //try with resources construct
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)
        ){
            objectOutputStream.writeObject(log3);
        }
    }


    public static Log3 serializeLog3In() throws IOException, ClassNotFoundException {
        String path = getProjectHomeDirectory() + "Log3.ser";
        //try with resources construct
        try(
                FileInputStream fileInStream = new FileInputStream(path);
                ObjectInputStream objectInStream = new ObjectInputStream(fileInStream);
        ) {
            Log3 log3 = (Log3)objectInStream.readObject();
            return log3;
        }
    }

    private static String getProjectHomeDirectory() {
        Path currentRelativePath = Paths.get(".");
        return currentRelativePath.toAbsolutePath().toString();
    }
}

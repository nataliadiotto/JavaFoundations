package IO;

import java.io.File;
import java.io.IOException;

public class FileTest01 {

    public static void main(String[] args) {

        File file = new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

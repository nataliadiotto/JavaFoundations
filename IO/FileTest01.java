package IO;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

public class FileTest01 {

    public static void main(String[] args) {

        File file = new File("file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println(isCreated);
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Is directory? " + file.isDirectory());
            System.out.println("Is file? " + file.isFile());
            System.out.println("Is hidden? " + file.isHidden());
            System.out.println("Is directory? " + file.isDirectory());
            System.out.println("Last modified: " + Instant.ofEpochMilli(file.lastModified())
                    .atZone(ZoneId.systemDefault()).toLocalDateTime());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

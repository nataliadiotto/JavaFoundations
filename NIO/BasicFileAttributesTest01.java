package NIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {

    public static void main(String[] args) throws IOException {

        LocalDateTime date = LocalDateTime.now().minusDays(10);
        File file = new File("folder02/new.txt");
        boolean isCreated = file.createNewFile();

        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC)
                .toEpochMilli());


        //Modifying with NIO
        Path path = Paths.get("folder02/new_path.txt");
        Files.createFile(path);

        LocalDateTime datePath = LocalDateTime.now().minusDays(5);

        //criar um objeto de time
        FileTime fileTime = FileTime.from(datePath.toInstant(ZoneOffset.UTC));
        Files.setLastModifiedTime(path, fileTime);
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path));


    }

}

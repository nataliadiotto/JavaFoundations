package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("file02");

        if (Files.notExists(filePath)) {
            Path fileDirectory = Files.createDirectory(filePath);
        }

        //mutliplos diretorios, criando subpastas
        Path subFilePath = Paths.get("file03/subfile/subsubfile");
        Path subFileDirectory = Files.createDirectories(subFilePath);
    }
}

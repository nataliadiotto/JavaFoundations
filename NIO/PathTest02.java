package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {
    public static void main(String[] args) throws IOException {
        Path folderPath = Paths.get("folder");

        if (Files.notExists(folderPath)) {
            Path fileDirectory = Files.createDirectory(folderPath);
        }

        //mutliplos diretorios, criando subpastas
        Path subFolderPath = Paths.get("folder/subfolder/subsubfolder");
        Path subFileDirectory = Files.createDirectories(subFolderPath);

        //criando arquivos
        Path filePath = Paths.get(subFolderPath.toString(), "file.txt");
        if (Files.notExists(filePath)) {
            Path filePathCreated = Files.createFile(filePath);
        }

        Path filePath02 = Paths.get("/Users/Natalia/JavaFoundations/folder/subfolder",
                "file02.txt");

        if (Files.notExists(filePath02)) {
            Path subFilePathCreated = Files.createFile(filePath02);
        }

        //copiando arquivos
        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "renamed_file.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);


    }
}

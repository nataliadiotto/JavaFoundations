package NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        Path path01 = Paths.get("/Users/Natalia/JavaFoundations/file.txt");

        //transformar em file
        //System.out.println(path01.getFileName().toFile());

        //posso passar o path separado que a propria classe une o caminho
        Path path02 = Paths.get("Users:", "/Natalia/JavaFoundations/", "file.txt");
        System.out.println(path01.getFileName());
        System.out.println(path02.getFileName());

    }
}

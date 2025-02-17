package NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String projectDirectory = "home/diotto/dev";
        String fileTxt = "../../file.txt";
        Path path01 = Paths.get(projectDirectory, fileTxt);
        System.out.println(path01);
        System.out.println(path01.normalize());
    }
}

package NIO;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest {

    public static void main(String[] args) {
        Path dir = Paths.get("/home/diotto");
        Path file = Paths.get("dev/file.txt");
        Path resolve = dir.resolve(file);
        System.out.println(resolve);

    }

}

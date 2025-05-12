package NIO;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {

    public static void main(String[] args) {

        Path path01 = Paths.get("folder/subfolder/file.bkp");
        Path path02 = Paths.get("folder/subfolder/file.java");
        Path path03 = Paths.get("folder/subfolder/file.txt");

        matches(path01, "glob:*.bkp");
        matches(path01, "glob:**.bkp");
        matches(path02, "glob:**/*.{bkp,java,txt}");
        matches(path03, "glob:**/*.{bkp,java,txt}");

        matches(path01, "glob:**/*.???");
        matches(path02, "glob:**/*.???");
        matches(path03, "glob:**/*.???");

        matches(path03, "glob:**/file.???");
        matches(path02, "glob:**/file.???");

    }

    private static void matches(Path path, String glob) {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }

}

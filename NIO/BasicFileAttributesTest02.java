package NIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {

    public static void main(String[] args) throws IOException {

        //BasicFileAttributesView, DosFileAttributesView, PosixFileAttributesView

        Path path = Paths.get("folder02/nex02.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();

        System.out.println("Creation time: " + creationTime);
        System.out.println("Last access time: " + lastAccessTime);
        System.out.println("Last modified time: " + lastModifiedTime);
        System.out.println("------------------------");

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(
                path, BasicFileAttributeView.class);

        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());
        fileAttributeView.setTimes(lastModifiedTime, newCreationTime, creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();

        System.out.println("Creation time: " + creationTime);
        System.out.println("Last access time: " + lastAccessTime);
        System.out.println("Last modified time: " + lastModifiedTime);


    }
}

package NIO;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {

    public static void main(String[] args) {

        Path zipFile = Paths.get("folder/file.zip");
        Path filesToZip = Paths.get("folder/subfolder01/subsubfolder01");
        zip(zipFile, filesToZip);

    }

    private static void zip(Path zipFile, Path filesToZip) {
        try(ZipOutputStream zipStream = new ZipOutputStream(
            Files.newOutputStream(zipFile));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filesToZip)) {

            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());//preparando a entrada pro arquivo zip
                zipStream.putNextEntry(zipEntry); //colocar os arquivos no zip
                Files.copy(file, zipStream); //copiando os arquivos pro zip
                zipStream.closeEntry(); //fechando a entrada
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

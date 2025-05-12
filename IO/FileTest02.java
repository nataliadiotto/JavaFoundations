package IO;

import java.io.File;
import java.io.IOException;

public class FileTest02 {

    public static void main(String[] args) throws IOException {
        File directory = new File("folder");
        boolean isDirectoryCreated = directory.mkdir();
        System.out.println(isDirectoryCreated);

        //criar arquivo dentro do diretorio - Forma #01: usando path absoluto
        File fileForDirectory = new File("/Users/Natalia/JavaFoundations/folder/file.txt");
        boolean isFileCreated = fileForDirectory.createNewFile();
        System.out.println("Is directory created? " + isDirectoryCreated);

        //criar arquivo dentro do diretorio - Forma #02: usando referencia do diretorio
        File fileForDirectory02 = new File(directory,"file02.txt");
        isFileCreated = fileForDirectory02.createNewFile();
        System.out.println("Is file created? " + isDirectoryCreated);

        //Renomeando arquivos: preciso criar o objeto que dará o nome ao arquivo primeiro
        //e apontar a referencia do diretorio, caso contrario, sera criado fora do diretorio atual
        File renamedFile = new File(directory, "renamed_file.txt");
        boolean isRenamed = fileForDirectory.renameTo(renamedFile);
        System.out.println("Is file renamed? " + isRenamed);

        //Renomeando diretorios
        File renamedDirectory = new File("RenamedFolder");
        boolean isDirectoryRenamed = directory.renameTo(renamedDirectory);
        System.out.println("Is directory renamed? " + isDirectoryRenamed);

    }

}

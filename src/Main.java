import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the source");
        String sourcePath = scanner.nextLine();
        System.out.println("Enter the destination");
        String destinationPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);
        try {
            copyFileUsingJava7Files(sourceFile, destinationFile);
            System.out.println("Copy Completed");
        }catch (IOException e) {
            System.out.println("Can't copy that file");
            System.out.println(e.getMessage());
        }
    }

    public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
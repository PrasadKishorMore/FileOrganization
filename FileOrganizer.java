import java.io.File;
import java.util.Scanner;

public class FileOrganizer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter folder path: ");
        File folder = new File(sc.nextLine());

        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid path");
            return;
        }

        for (File file : folder.listFiles()) {

            if (file.isFile()) {

                String ext = "";
                int i = file.getName().lastIndexOf('.');
                if (i != -1) ext = file.getName().substring(i + 1);

                String type =
                        ext.equals("jpg") || ext.equals("png") ? "Images" :
                        ext.equals("pdf") || ext.equals("txt") ? "Documents" :
                        "Others";

                File target = new File(folder, type);
                if (!target.exists()) target.mkdir();

                file.renameTo(new File(target, file.getName()));
                System.out.println("Moved: " + file.getName());
            }
        }
    }
}


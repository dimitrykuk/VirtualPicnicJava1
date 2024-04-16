import impl.HandlerFile;

import java.io.File;
import java.util.Scanner;

public class View {

    public void Run() {
        File folder = new File("src\\\\impl");
        int i = 0;
        for (File file : folder.listFiles())
        {
            System.out.println(++i+ ". " + file.getName());
        }
        //HandlerFile rf = new HandlerFile(String.format("src\\\\impl\\\\%s.txt",prompt()));

    }

    private static String prompt() {
        System.out.println("Введите имя файла: ");
        return new Scanner(System.in).next();
    }

}

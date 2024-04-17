import impl.HandlerFile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
private final Map<Integer, String> files = new HashMap<>();
private static final Map<Integer, String> operations = new HashMap<>();
    static {
        operations.put(1, "getLongestWord()");
        operations.put(2, "getWordFrequency()");
    }
    public void Run() {
        File folder = new File("src\\\\impl");
        int count = 0;
        for (File file : folder.listFiles())
        {
            if (getFileType(file).equals("txt")){
                files.put(++count,file.getName());
                System.out.println(count + ". " + file.getName());
            }
        }

        int flag = Integer.parseInt(prompt("Введите номер файла для работы"));
        while (flag > files.size()){
            System.err.println("Такого файла не существует. Попробуйте снова.");
            flag = Integer.parseInt(prompt("Введите номер файла для работы"));
        }

        HandlerFile rf = new HandlerFile(String.format("src\\\\impl\\\\%s",files.get(flag)));


        int operationNumber = Integer.parseInt(prompt("Введите номер операции"));


        System.out.printf("Самые длинные слова в файле: %s", rf.getLongestWord());
        System.out.println(rf.getWordFrequency());
        ;
    }

    private static String prompt(String text) {
        System.out.println(text+": ");
        return new Scanner(System.in).next();
    }
    private String getFileType(File file){
        String[] stringArray = file.toString().split("\\.");
        return stringArray[stringArray.length-1];
    }

}

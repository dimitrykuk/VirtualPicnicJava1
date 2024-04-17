import impl.HandlerFile;
import impl.LongestWord;
import impl.NumberOfWord;
import impl.WordFrequency;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
private final Map<Integer, String> files = new HashMap<>();
private HandlerFile hf;

public View(){
    Run();
}
    private void Run() {
        File folder = new File("src\\\\impl");
        int count = 0;
        System.out.println("Доступные файлы:\n");

        for (File file : folder.listFiles())
        {
            if (getFileType(file).equals("txt")){
                files.put(++count,file.getName());
                System.out.println(count + ". " + file.getName());
            }
        }
        if(count == 0) throw new RuntimeException("Файлов с форматом txt не обнаружено");

        int flag = Integer.parseInt(prompt("Введите номер файла для работы"));
        while (flag > files.size()){
            System.err.println("Такого файла не существует. Попробуйте снова.");
            flag = Integer.parseInt(prompt("Введите номер файла для работы"));
        }

        hf = new HandlerFile(String.format("src\\\\impl\\\\%s",files.get(flag)));
    }
    public void numberOfWordInFile(){
        NumberOfWord numberOfWord = new NumberOfWord();
        System.out.println(numberOfWord.getNumberOfWord(hf));
    }
    public void longestWordInFile(){
        LongestWord longestWord = new LongestWord();
        System.out.println(longestWord.getLongestWord(hf));
    }
    public void wordFrequencyInFile(){
        WordFrequency wordFrequency = new WordFrequency();
        System.out.println(wordFrequency.getWordFrequency(hf));
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

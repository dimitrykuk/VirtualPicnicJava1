package impl;

import java.util.ArrayList;
import java.util.List;

public class LongestWord  {

    public String getLongestWord(HandlerFile file){
        List<String> products = file.getFoodMap().keySet().stream().toList();
        ArrayList<String> longestWord = new ArrayList<>();
        longestWord.add("");

        for(String name: products){
            if (name.length() > longestWord.getFirst().length()){
                longestWord.clear();
                longestWord.add(name);
            } else if (name.length() == longestWord.getFirst().length()) {
                longestWord.add(name);
            }
        }
        return String.format("\nСамое длинное слово: %s", longestWord);
    }
}

package impl;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordFrequency {
    public String getWordFrequency(HandlerFile file){
        getValidProductList(file);

        String product = inputWord();
        return String.format("\nЧастота %s в файле: %s",product, file.getFoodMap().get(product.toUpperCase()));
    }
    private void getValidProductList(HandlerFile file){
        System.out.println("Доступные параметры: ");
        for (Map.Entry<String, Integer> entry : file.getFoodMap().entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
        }

    }
    private String inputWord(){
        System.out.println("\nВведите продукт из списка");
        return new Scanner(System.in).next();
    }
}

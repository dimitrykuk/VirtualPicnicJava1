package impl;

import java.io.*;
import java.util.*;

public class HandlerFile {
    private final Map<String, Integer> foodMap = new HashMap<>();
    private final StringBuilder line = new StringBuilder();

    public HandlerFile(String fileName){
        ReadFile(fileName);
        getSplitElements();
    }

    private void ReadFile(String fileName){

        File file = new File(fileName);

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                line.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Файл не найден!!!!");
        }
    }

    private void getSplitElements(){
        String[] products = line.toString().split(" ");

        for (String name : products){
            if (!name.isEmpty()){
                if (foodMap.containsKey(name)) {
                    foodMap.replace(name,foodMap.get(name),foodMap.get(name)+1);
                }
                else{
                    foodMap.put(name,1);
                }
            }
        }
    }

    public void getWordsNumber(){
        System.out.println(foodMap.values().stream().mapToInt(Integer::intValue).sum());
    }
    public ArrayList<String> getLongestWord(){
        List<String> products = foodMap.keySet().stream().toList();

        ArrayList<String> longestWord = new ArrayList<>();
        longestWord.add(" ");

        for(String name: products){
            if (name.length() > longestWord.getFirst().length()){
                longestWord.clear();
                longestWord.add(name);
            } else if (name.length() == longestWord.getFirst().length()) {
                longestWord.add(name);
            }
        }
        return longestWord;
    }

    public String getMostNumerousProduct(){
        List<String> products = foodMap.keySet().stream().toList();
        return null;
    }
    public String getWordFrequency(){
        System.out.println("\nВведите продукт");
        String product = new Scanner(System.in).next();
        return String.format("\nЧастота %s в файле: %s",product, foodMap.get(product));
    }
}


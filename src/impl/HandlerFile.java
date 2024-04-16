package impl;

import java.io.*;
import java.util.*;

public class HandlerFile {
    private final Map<String, Integer> foodMap = new HashMap<>();
    private final StringBuilder line = new StringBuilder();

    public HandlerFile(String fileName){
        ReadFile(fileName);
        getSplitElements();
        getLongestWord();
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
    public void getLongestWord(){
        List<String> products = foodMap.keySet().stream().toList();

        ArrayList<String> longestWord = new ArrayList<>();
        longestWord.add(products.getFirst());

        for(String name: products){
            if (name.length() > longestWord.getFirst().length()){
                longestWord.clear();
                longestWord.add(name);
            } else if (name.length() == longestWord.getFirst().length()) {
                longestWord.add(name);
            }
        }
        System.out.println(longestWord);
    }

    public String getMostNumerousProduct(){
        List<String> products = foodMap.keySet().stream().toList();
        return null;
    }
    public void getWordFrequency(){

    }
    private void sortDataInFile(){

    }


}

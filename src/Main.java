//
//Осуществить подсчет слов:
//        Напишите программу, которая подсчитывает количество слов в
//файле `input.txt`.
//        2. Найти самое длинное слово:
//        Создайте программу, которая находит самое длинное слово в
//файле.
//3. Вычислить частоту слов:
//        Напишите программу, которая анализирует, сколько раз каждое
//слово встречается в файле. Подумайте об этом как о подсчете того,
//какие фрукты и овощи самые популярные на вашем пикнике!


// 2. Ввести возможность повторного ввода имени файла ?3
// 3. Ввывести на экран доступные для выбора файлы ?2
// 4. Раскидать по методам и классам

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        View view = new View();
        //view.longestWordInFile();
        //view.numberOfWordInFile();
        view.wordFrequencyInFile();

    }
}
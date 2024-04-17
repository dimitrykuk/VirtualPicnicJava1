package impl;

import java.util.Collection;

public class NumberOfWord {
        public String getNumberOfWord(HandlerFile file){
        Collection<Integer> list = file.getFoodMap().values();

        return String.format("\n Общее количество слов в файле: %d", list.stream().mapToInt(Integer::intValue).sum());
    }
}

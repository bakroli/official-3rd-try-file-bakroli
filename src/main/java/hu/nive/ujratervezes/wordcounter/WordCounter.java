package hu.nive.ujratervezes.wordcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WordCounter {

    public int[] countWords(String fileName, int wordLength) {
        List<String> rows = new ArrayList<>();
        try {
            rows = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] countWord = new int[rows.size()];
        int index = 0;
        for (String row : rows) {
            row = row.replace(".", "");
            row = row.replace("!", "");
            row = row.replace("?", "");
            String[] words = row.split(" ");
            for (String s : words) {
                if (s.length() == wordLength) {
                    countWord[index] += 1;
                }
            }
            index++;
        }
        return countWord;
    }
}

package com.xyz.service;

import com.xyz.Start;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.IntStream;

public class OptionsService {
    private StringBuilder textFromFile;
    static public List<String> defaultOptions = Arrays.asList("m", "w", "X");

    public boolean isReadableFile(String fileName) {
        if (fileName.contains(".txt")) {
            Path path = Paths.get(fileName);
            Scanner readFile = null;
            try {
                readFile = new Scanner(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            textFromFile = new StringBuilder();
            while (readFile != null && readFile.hasNextLine()) {
                textFromFile.append(readFile.nextLine()).append("\n");
            }
            readFile.close();
//            System.out.println(textFromFile);
            return true;
        }
        return false;
    }

    public void validateOptions(String options) {
        if (options.charAt(0) == '-') {
            String inputOptions = options.replace("-", "");
            Set<String> setInputOptions = new HashSet<>();

            IntStream.range(0, inputOptions.length()).allMatch(n -> {
                if (defaultOptions.contains(Character.toString(inputOptions.charAt(n)))) {
                    setInputOptions.add(Character.toString(inputOptions.charAt(n)));
                }
                return true;
            });
            if (!setInputOptions.isEmpty()) {
                caseOfOptions(setInputOptions);
            }
            return;
        }
        if (options.equals(Start.filename)) {
            caseOfOptions(new HashSet<>(Arrays.asList("m", "w")));
        } else
            System.out.println("input correctly options!");
    }

    public void caseOfOptions(Set<String> options) {
        for (String option : options) {
            switch (option) {
                case "m":
                    System.out.println("count of characters = " + countCharacters());
                    break;
                case "w":
                    System.out.println("count of word = " + countWord());
                    break;
                case "X":
                    System.out.println("duplicate words = " + duplicateWords());
                    break;
            }
        }
    }

    public Set<String> duplicateWords() {
        Map<String, Integer> countDuplicate = new HashMap<>();
        List<String> duplicate = Arrays.asList(textFromFile.toString().replace(".", "")
                .replace(",", "").trim().split(" "));
        Set<String> uniqueWords = new HashSet<>(duplicate);
        for (String word : uniqueWords) {
//            System.out.println(word + " is duplicated " + Collections.frequency(duplicate, word));
            countDuplicate.put(word, Collections.frequency(duplicate, word));
        }
        LinkedHashMap<String, Integer> output = new LinkedHashMap<>();
        countDuplicate.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .forEachOrdered(x -> output.put(x.getKey(), x.getValue()));
        return output.keySet();
    }

    public int countWord() {
        int countWord = 0;
        String[] wordList = textFromFile.toString().split("\\s+");
        countWord += wordList.length;
        return countWord;
    }

    public int countCharacters() {
        int countCharacters = textFromFile.length() - 1;
        return countCharacters;
    }
}
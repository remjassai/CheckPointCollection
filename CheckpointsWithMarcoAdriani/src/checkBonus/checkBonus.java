package checkBonus;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkBonus {
    public static void main(String[] args) throws IOException {
        List<String> poesia = processFile("CheckpointsWithMarcoAdriani/src/checkBonus/FaFreddoDiGianniRodari.txt");
        HashMap<String,Integer> nOfVowelsInWord = processLines(poesia);
        System.out.println(nOfVowelsInWord);
        writeResult("CheckpointsWithMarcoAdriani/src/checkBonus/outputBonus.txt",nOfVowelsInWord);
    }

    public static List<String> processFile(String imputPoem) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(imputPoem));
        List<String> versi = new ArrayList<>();
        while (br.ready()) {
            versi.add(br.readLine().strip());
        }
        br.close();
        return versi;
//return Files.lines(new File(imputPoem.strip()).toPath()).toList();
    }

    public static HashMap<String, Integer> processLines(List<String> versi) {
        HashMap<String, Integer> vocaliRime = new HashMap<String, Integer>();
        for (String linea : versi) {
            if (linea.trim().isEmpty()) {
                System.out.println("Empty line");
            } else {
                String[] parole = linea.toLowerCase().strip().split("[\\s\\W]+");
                for (String parola : parole) {
                    int count = 0;
                    String vocali = "aeiou";
                    for (int i = 0; i < parola.length(); i++) {
                        char c = parola.charAt(i);
                        if (vocali.indexOf(c) != -1) {
                            count++;
                        }
                    }
                    vocaliRime.put(parola, count);
                }
            }
        }
        return vocaliRime;
    }

    public static void writeResult(String filename, Map<String, Integer> nOfVowelsInWord) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (String key : nOfVowelsInWord.keySet()) {
            bw.write("il numero di vocali in '" + key + "' è " + nOfVowelsInWord.get(key) + "\n");
        }
        bw.close();
    }

}

package checkBonusDiffApproach;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkBonusDiffApproach {
    public static void main(String[] args) throws IOException {
        List<String> poesia = processFiles("CheckpointsWithMarcoAdriani/src/resources/FaFreddoDiGianniRodari.txt");
        Map<String,Integer> vocaliRime = processLines(poesia);
        System.out.println(vocaliRime);
        //Viene fuori "EMPTY LINE" spesso, perché quando va a capo due volte, la riga è vuota!
        writeResult("CheckpointsWithMarcoAdriani/src/checkBonusDiffApproach/outBonusDiffApproach.txt", vocaliRime);
    }
    public static List<String> processFiles(String pathPoesia) throws IOException {
        Path path = Path.of(pathPoesia);
        List<String> versi = new ArrayList<>();
        String rime = Files.readString(path);
        String[] lines = rime.strip().split("\n");
        for (String line : lines) {
            versi.add(line);
        }
        return versi;
    }
    //Le HashMap non possono contenere duplicati, quindi non ho bisogno d'implementare nessun codice per rimuovergli
    public static Map<String, Integer> processLines(List<String> versi) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String line : versi) {
            if (line.isEmpty()) {
                System.out.println("Empty line!");
            } else {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split(" ");
                for (String word : words) {
                    int count = 0;
                    String vocale = "aeiou";
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (vocale.indexOf(c) != -1) {
                            count++;
                        }
                    }
                    result.put(word, count);
                }
            }
        }
        return result;
    }

    public static void writeResult(String filename,Map<String,Integer> vocaliRime) throws IOException {
        Path path = Path.of(filename);
        StringBuilder textNewFile= new StringBuilder();
        for(String key:vocaliRime.keySet()){
            textNewFile.append("il numero di vocali in '")
                    .append(key).append("' è ")
                    .append(vocaliRime.get(key)).append("\n");
        }
        Files.writeString(path,textNewFile);
    }
}

package CheckpointTwo/txt;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkpointTwo {
    public static List<String> processFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        List<String> lines = new ArrayList<String>();
        while (br.ready()) {
            lines.add(br.readLine().strip());
        }
        return lines;
    }

    public static Map<Character, Integer> processLines(List<String> lines) {
        Map<Character, Integer> map = new HashMap<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                System.out.println("Empty line found!");
                continue;
            }
            String[] parole = line.replaceAll("[^a-zA-Z ]", "").split("\\s+");
            for (String parola : parole) {
                char chiave = Character.toLowerCase(parola.charAt(0));
                int valore = map.getOrDefault(chiave, 0);
                map.put(chiave, valore + 1);
            }
        }
        return map;
    }

    public static void writeResult(String filename, Map<Character, Integer> entries) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for(Character key: entries.keySet()) {
            bw.write(key + " -> " + entries.get(key)+ "\n");
        }
    bw.close();
    }
}

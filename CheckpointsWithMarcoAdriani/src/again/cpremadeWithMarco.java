package again;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cpremadeWithMarco {


    public class Checkpoint {

        public static List<String> processFIle(String filename) throws IOException {
        /* List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        while (br.ready()) {
            lines.add(br.readLine().strip());
        }
        br.close();
        return lines; */
            return Files.lines(Path.of(filename)).map(line -> line.strip()).toList();
        }

        public static Map<Character, Integer> processLines(List<String> lines) {
            Map<Character, Integer> mappa = new HashMap<>();
            for (String line : lines) {
                if (line.isEmpty()) {
                    System.out.println("ERRORE RIGA VUOTA");
                }
                else {
                    String[] parole = line.split("\\W+");
                    for (String parola : parole) {
                        int old_value = mappa.getOrDefault(parola.charAt(0), 0);
                        mappa.put(parola.charAt(0), old_value + 1);
                    }
                }
            }
            return mappa;
        }

        public static void writeResult(String filename, Map<Character, Integer> mappa) throws IOException {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            for (Character key : mappa.keySet()) {
                bw.write(key + " -> " + mappa.get(key) + "\n");
            }
            bw.close();
        }

    }

}
